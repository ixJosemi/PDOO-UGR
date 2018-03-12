/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
import java.util.Random;
import napakalaki.Dice;

/**
 *
 * @author ixjosemi
 */

public class Player {

    static final int MAXLEVEL = 10;

    private String name;
    private int level;
    private boolean dead = true;
    public boolean canISteal = true;

    public BadConsequence pendingBc = null;
    private Player enemy = null;

    public ArrayList <Treasure> visibleTreasures = new ArrayList();
    public ArrayList <Treasure> hiddenTreasures = new ArrayList();

    public Player(String name){
        this.name = name;
        level = 1;
        pendingBc = null;
        enemy = null;
    }

    public String getName(){
        return name;
    }

    public Player getEnemy(){
        return enemy;
    }
    private void bringToLife(){
        dead = false;
    }

    public int getCombatLevel(){

        int combatLevel = level;

        for(Treasure t: visibleTreasures)
            combatLevel = combatLevel + t.getBonus();

        return combatLevel;
    }

    public int getLevels(){
        return level;
    }

    public BadConsequence getPendingBadConsequence(){
        return pendingBc;
    }

    public ArrayList <Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }

    public ArrayList <Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }

    public boolean isDead(){
        return dead;
    }

    private void incrementLevels(int levels){
        this.level += levels;

    }

    private void decrementLevels(int levels){

        this.level -= levels;

        if (this.level <= 1)
            this.level = 1;
    }

    private void setPendingBadConsequence(BadConsequence bc){
        this.pendingBc = bc;
    }

    private void applyPrize(Monster m){

        int nLevels = m.getLevelsGained();

        this.incrementLevels(nLevels);

        int nTreasures = m.getTreasuresGained();

        if(nTreasures > 0){

            for(int i = 1; i < nTreasures; i++){
                CardDealer dealer = CardDealer.getInstance();
                Treasure treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }
        }
    }

    private void applyBadConsequence(Monster m){

       BadConsequence badconsequence;
        badconsequence = m.getBadConsequence();

       int nLevels = badconsequence.getLevels();

       this.decrementLevels(nLevels);

       pendingBc = badconsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);

       this.setPendingBadConsequence(pendingBc);

    }

    private boolean canMakeTreasureVisible(Treasure t){

        boolean result = false;

        if(this.visibleTreasures.size() < 4){
            TreasureKind type = t.getType();

            switch(type){
                case ONEHAND:

                    if(isTreasureKindInUse(TreasureKind.BOTHHANDS))
                        result = false;
                    else{
                        int i = 0;

                        for(Treasure tv: this.visibleTreasures){

                            if (tv.getType().equals(TreasureKind.ONEHAND))
                                i++;
                        }

                        result = i != 2;
                    }
                    break;

                default:
                    result = !isTreasureKindInUse(type);
            }
        }
        return result;
    }

    private boolean isTreasureKindInUse(TreasureKind type){

        boolean result = false;

        for (Treasure tv : this.visibleTreasures) {

            if (type.equals(tv.getType())) {
                result = true;
                break;
            }
        }
        return result;
    }

    private int howManyVisibleTreasures(TreasureKind tKind){

        int i = 0;

        for(Treasure t  : this.visibleTreasures){

            if (t.getType() == tKind)
                i++;
        }
        return i;
    }

    private void dieIfNoTreasure(){
        if(this.visibleTreasures.isEmpty() && this.hiddenTreasures.isEmpty())
            this.dead = true;
    }

    public CombatResult combat(Monster m){

        CombatResult combatResult;

        int myLevel = this.getCombatLevel();
        int monsterLevel = m.getCombatLevel();

        if(myLevel > monsterLevel){
            this.applyPrize(m);

            if(this.getLevels() >= MAXLEVEL)
                combatResult = CombatResult.WINGAME;

            else
                combatResult = CombatResult.WIN;
        }
        else{
            this.applyBadConsequence(m);

            combatResult = CombatResult.LOSE;
        }
        return combatResult;
    }

    public void makeTreasureVisible(Treasure t){

        if(this.canMakeTreasureVisible(t)){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }

    public void discardVisibleTreasure(Treasure t){

        visibleTreasures.remove(t);

        if(pendingBc != null && !(pendingBc.isEmpty()))
            pendingBc.substractVisibleTreasures(t);

        this.dieIfNoTreasure();
    }

    public void discardHiddenTreasure(Treasure t){

        hiddenTreasures.remove(t);

        if(pendingBc != null && !(pendingBc.isEmpty()))
            pendingBc.substractHiddenTreasures(t);

        this.dieIfNoTreasure();
    }

    public boolean validState(){

        boolean valid = false;

        if((this.pendingBc == null && hiddenTreasures.size() <= 4
                || (pendingBc.isEmpty() && hiddenTreasures.size() >= 4)))
            valid = true;

        return valid;
    }

    public void initTreasures(){

        CardDealer dealer = CardDealer.getInstance();

        Dice dice = Dice.getInstance();

        this.bringToLife();

        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);

        int number = dice.nextNumber();

        if (number > 1){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }

        if (number == 6){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }

    public Treasure stealTreasure(){

        Treasure treasure = null;

        boolean canI = this.canISteal();

        if(canI){

            if(enemy.canYouGiveMeATreasure()){
                treasure = this.enemy.giveMeATreasure();

                hiddenTreasures.add(treasure);

                this.haveStolen();
            }
        }
        return treasure;
    }

    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }

    private Treasure giveMeATreasure(){

        Random rnd = new Random();

        int i = rnd.nextInt(hiddenTreasures.size());

        return(hiddenTreasures.remove(i));
    }

    public boolean canISteal(){
        return canISteal;
    }

    private boolean canYouGiveMeATreasure(){

        boolean haveTreasures = true;

        if(hiddenTreasures.isEmpty() && visibleTreasures.isEmpty())
            haveTreasures = false;

        return haveTreasures;
    }

    private void haveStolen(){
        canISteal = false;
    }

    public void discardAllTreasures(){

        ArrayList <Treasure> visibleCopy = new ArrayList(visibleTreasures);
        ArrayList <Treasure> hiddenCopy = new ArrayList(hiddenTreasures);

        for(Treasure t: visibleCopy)
            this.discardVisibleTreasure(t);

        for(Treasure t: hiddenCopy)
            this.discardHiddenTreasure(t);
    }

    @Override
    public String toString(){
        return  "" + this.name
                + ", \nlevel = " + Integer.toString(level)
                + ", \nenemy = " + enemy.getName();
    }
}
