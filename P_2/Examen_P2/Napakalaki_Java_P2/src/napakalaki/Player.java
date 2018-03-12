// MADE BY: JOSE MIGUEL HDEZ GARCIA & JAIRO ABRIL MOYA

package napakalaki;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ixjosemi
 */

public class Player {

    static int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    private BadConsequence pendingBadConsequence;
    private Player enemy;

    private ArrayList <Treasure> visibleTreasures = new ArrayList();
    private ArrayList <Treasure> hiddenTreasures = new ArrayList();

    public Player(String name){
        this.name = name;
        this.level = 1;
    }

    public Player (Player p){
        this.name = name;
        this.level = p.level;
        this.pendingBadConsequence = p.pendingBadConsequence;
        this.dead = p.dead;
        this.canISteal = p.canISteal;
    }

    public String getName(){
        return name;
    }

    private void bringToLife(){
        dead = false;
    }

    private int getCombatLevel(){
        int lvl = this.level;
        return lvl;
    }

    private void incrementLevels(int levels){
        this.level += levels;

    }

    private void decrementeLevels(int levels){
        this.level -= levels;

        if (this.level <= 1)
            this.level = 1;
    }

    private void setPendingBadConsequence(BadConsequence bc){
        this.pendingBadConsequence = bc;
    }

    private void applyPrize(Monster m){

    }

    private void applyBadConsequence(Monster m){

    }

    /*
    private boolean canMakeTreasureVisible(Treasure t){

    }
    */

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

    BadConsequence bc;

    public boolean isDead(){
        dead = bc.getDeath();
        return dead;
    }

    public ArrayList getHiddenTreasures(){
        return hiddenTreasures;
    }

    public ArrayList getVisibleTreasure(){
        return visibleTreasures;
    }

    /*
    public CombatResult combat(Monster m){

    }
    */

    public void makeTreasureVisible(Treasure t){

    }

    public void discardVisibleTreasure(Treasure t){

    }

    public void discardHiddenTreasure(Treasure t){

    }

    public boolean validState(){
        return this.pendingBadConsequence == null
                || (this.pendingBadConsequence.isEmpty() && this.hiddenTreasures.size() <= 5);
    }

    public void initTreasure(){

    }

    public int getLevels(){
        return this.level;
    }

    /*
    public Treasure stealTreasure(){

    }
    */

    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }

    private Treasure giveMeATreasure(){
        Random rnd = new Random();

        int i = rnd.nextInt(hiddenTreasures.size());

        return(hiddenTreasures.remove(i));
    }

    public boolean canISteal(){
        return this.canISteal;
    }

    private boolean canYouGiveMeATreasure(){
        boolean have_treasures = true;

        if (hiddenTreasures.isEmpty() && visibleTreasures.isEmpty())
            have_treasures = false;

        return (have_treasures);
    }

    private void haveStolen(){
        canISteal = false;
    }

    public void discardAllTreasures(){

    }
}
