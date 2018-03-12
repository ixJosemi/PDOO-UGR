/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Random;

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

    public BadConsequence pendingBc;
    private Player enemy;

    public ArrayList <Treasure> visibleTreasures = new ArrayList();
    public ArrayList <Treasure> hiddenTreasures = new ArrayList();

    // Constructor
    public Player(String name){
        this.name = name;
        level = 1;
        pendingBc = null;
        enemy = null;
    }

    // Constructor de copia
    public Player (Player p){

        this.name = p.name;
        this.level = p.level;
        this.dead = p.dead;
        this.canISteal = p.canISteal;
        this.enemy = p.enemy;
        this.pendingBc = p.pendingBc;
        this.visibleTreasures = p.visibleTreasures;
        this.hiddenTreasures = p.hiddenTreasures;
    }

    // Devuelve el nombre del jugador
    public String getName(){
        return name;
    }

    // Devuelve el enemigo del jugador
    public Player getEnemy(){
        return enemy;
    }

    // Devuelve a la vida
    private void bringToLife(){
        dead = false;
    }

    // Devuelve el nivel de combate del jugador, añadiendole el bonus de los 
    // tesoros visibles
    public int getCombatLevel(){

        int combatLevel = level;

        for(Treasure t: visibleTreasures)
            combatLevel = combatLevel + t.getBonus();

        return combatLevel;
    }

    // Devuelve el nivel del jugador
    public int getLevels(){
        return level;
    }

    // Devuelve el mal rollo pendiente del jugador
    public BadConsequence getPendingBadConsequence(){
        return pendingBc;
    }
    
    // Devuelve los tesoros ocultos del jugador
    public ArrayList <Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }

    // Devuelve los tesoros visible del jugador
    public ArrayList <Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }

    // Devuelve si el jugador actual esta muerto o no
    public boolean isDead(){
        return dead;
    }

    // Aumenta los niveles del jugador
    private void incrementLevels(int levels){
        this.level += levels;

    }

    // Reduce los niveles del jugador
    private void decrementeLevels(int levels){

        this.level -= levels;

        if (this.level <= 1)
            this.level = 1;
    }
    
    // Asigna el mal rollo al jugador
    private void setPendingBadConsequence(BadConsequence bc){
        this.pendingBc = bc;
    }
    
    // Aplica el buen rollo del monstruo al que el jugador ha vencido, sumandole
    // los niveles que le corresponden y pidiendo los tesoros que el buen rollo 
    // indique, los cuales se añaden a los tesoros ocultos.
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
    
    // Aplica el mal rollo al jugador al perder contra un monstruo, restandole
    // los niveles que correspondan y guardando una copia de un objeto
    // badconsequence ajustada a los tesoros que se pueden perder
    private void applyBadConsequence(Monster m){
        
       BadConsequence badconsequence;
        badconsequence = m.getBadConsequence();
       
       int nLevels = badconsequence.getLevels();
       
       this.decrementeLevels(nLevels);
       
       pendingBc = badconsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
       
       this.setPendingBadConsequence(pendingBc);
       
    }
          
    // Comprueba si el tesoro que le pasemos se puede pasar a visible segun
    // las reglas del juego
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
 
    // Metodo personal que usaremos en el canMakeTreasureVisible para no realizar
    // constantemente las mismas comprobaciones
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
    
    // Devuelve el numero de tesoros visibles que tiene el jugador
    private int howManyVisibleTreasures(TreasureKind tKind){
        
        int i = 0;
        
        for(Treasure t  : this.visibleTreasures){
            
            if (t.getType() == tKind)
                i++;
        }
        return i;
    }
    
    // Cambia el estado del jugador a "muerto" si este ha perdido todos sus 
    // tesoros
    private void dieIfNoTreasure(){
        if(this.visibleTreasures.isEmpty() && this.hiddenTreasures.isEmpty())
            this.dead = true;
    }
     
    // Combate contra el monstruo actual, si el nivel del jugador es mayor que
    // el nivel del monstruo, se aplica el buen rollo y se puede ganar el combate
    // o el juego, en caso contrario, el jugador pierde el combate y se le aplica
    // el mal rollo
    public CombatResult combat(Monster m){
        
        CombatResult combatResult;
        
        int myLevel = this.getCombatLevel();
        int monsterLevel = this.getOponentLevel(m);
        
        if(myLevel > monsterLevel){
            this.applyPrize(m);
            
            if(this.getLevels() >= MAXLEVEL)
                combatResult = CombatResult.WINGAME;
           
            else
                combatResult = CombatResult.WIN;
        }
        else{
            this.applyBadConsequence(m);

            if (this.ShouldConvert())
                combatResult = CombatResult.LOSEANDCONVERT;
            else
                combatResult = CombatResult.LOSE;
        }
        return combatResult;
    }
    
    // Pasa un tesoro de oculto a visible
    public void makeTreasureVisible(Treasure t){
        
        if(this.canMakeTreasureVisible(t)){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    // Descarta un tesoro t que sea visible
    public void discardVisibleTreasure(Treasure t){
        
        visibleTreasures.remove(t);
        
        if(pendingBc != null && !(pendingBc.isEmpty()))
            pendingBc.substractVisibleTreasures(t);
        
        this.dieIfNoTreasure();
    }
    
    // Descarta un tesoro t que sea oculto
    public void discardHiddenTreasure(Treasure t){
        
        hiddenTreasures.remove(t);
        
        if(pendingBc != null && !(pendingBc.isEmpty()))
            pendingBc.substractHiddenTreasures(t);
        
        this.dieIfNoTreasure();
    }
    
    // Devuelve true en caso de que el jugador no tenga un mal rollo que cumplir
    // y no tiene mas de 4 tesoros ocultos
    public boolean validState(){
       
        boolean valid = false;
        
        if((this.pendingBc == null && hiddenTreasures.size() <= 4
                || (pendingBc.isEmpty() && hiddenTreasures.size() >= 4)))
            valid = true;
        
        return valid;
    }
    
    // Cuando un jugador se encuentra en su primer turno o se queda sin tesoros, 
    // hay que proporcionarle nuevos tesoros para que pueda continuar jugando
    // El numero de tesoros proporcionado viene dado por el valor que obtenga al
    // tirar el dado
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
    
    // Cuando el jugador quiere robar un tesoro, este metodo comprueba si es 
    // posible hacerlo y que su enemigo tenga tesoros ocultos que puedan
    // ser robados. El jugador no puede volver a robar tesoros durante el resto
    // de la partida. En el caso de no poder robar un tesoro se notifica.
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
    
    // Le da valor al atributo "enemy"
    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }
    
    // Devuelve un tesoro aleatorio de entre todos los tesoros ocultos del jugador
    private Treasure giveMeATreasure(){
       
        Random rnd = new Random();
        
        int i = rnd.nextInt(hiddenTreasures.size());
        
        return(hiddenTreasures.remove(i));
    }
    
    // Devuelve si el jugador no ha robado ningun tesoro y "false" en caso 
    // de que si lo haya hecho
    public boolean canISteal(){
        return canISteal;
    }
    
    // Devuelve trye si el jugador tiene tesoros que pueden ser robados por
    // otros y "false" en caso de que no
    private boolean canYouGiveMeATreasure(){
        
        boolean haveTreasures = true;
        
        if(hiddenTreasures.isEmpty() && visibleTreasures.isEmpty())
            haveTreasures = false;

        return haveTreasures;
    }
    
    // Cambia CanISteal a false cuando el jugador roba un tesoro
    private void haveStolen(){
        canISteal = false;
    }
     
    // El jugador descarta todos sus tesoros, tanto visibles como ocultos
    public void discardAllTreasures(){
        
        ArrayList <Treasure> visibleCopy = new ArrayList(visibleTreasures);
        ArrayList <Treasure> hiddenCopy = new ArrayList(hiddenTreasures);
        
        for(Treasure t: visibleCopy)
            this.discardVisibleTreasure(t);
        
        for(Treasure t: hiddenCopy)
            this.discardHiddenTreasure(t);
    }
    
    // Devuelve el nivel del monstruo del oponente
    protected int getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    
    // Lanza el dado y se devolvera "true" si se obtiene un 1 y "false" en caso
    // de que no
    protected boolean ShouldConvert(){
        boolean should = false;
        
        Dice dice = Dice.getInstance();
  
        if (dice.nextNumber()==1)
            should = true;
        
        return (should);
    }

    public String toString(){
        return  "" + name
                + ", \nlevel = " + Integer.toString(level)
                + ", \nenemy = " + enemy.getName();
    }
}
