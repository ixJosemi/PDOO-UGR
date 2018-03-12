
package napakalaki;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author ixjosemi
 */

public class Napakalaki {
    
    private static final Napakalaki instance = new Napakalaki();
    
    private ArrayList <Player> players;
    private Player currentPlayer = null;
    private Monster currentMonster = null;
    private CardDealer dealer = CardDealer.getInstance();
    
    private Napakalaki(){}
    
    public static Napakalaki getInstance(){
        return instance;
    }

    
    // Inicia la lista de jugadores
    private void initPlayers(ArrayList<String> names){
        this.players = new ArrayList();
        
        for (String s : names)
            players.add(new Player(s));
    }
    
    // Decide quien sera el siguiente jugador en jugar
    private Player nextPlayer(){
        
        int nextIndex;
        Player nextPlayer;
        
        int totalPlayers = this.players.size();
        
        if(this.currentPlayer == null){
            Random rnd = new Random();
            nextIndex = rnd.nextInt(totalPlayers);
        }
        else{
            int currentPlayerIndex = this.players.indexOf(this.currentPlayer);
            
            if(currentPlayerIndex == totalPlayers - 1){
                nextIndex = 0;
            }
            else{
                nextIndex = currentPlayerIndex + 1;  
            }
        }
        
        nextPlayer = this.players.get(nextIndex);
        this.currentPlayer = nextPlayer;
        
        return this.currentPlayer;
    }
    
    // Comprueba si el jugador que esta activo, cumple con las reglas para poder
    // terminar su turno y pasar a otro. Devuelve "false" en caso de que no 
    private boolean nextTurnIsAllowed(){
        
        boolean isAllowed;
        
        if (currentPlayer == null)
            isAllowed = true;
        else
            isAllowed = currentPlayer.validState();
        
        return isAllowed;
    }
    
    // Asigna de forma aleatoria un enemigo a cada jugador, teniendo en cuenta
    // que un jugador no puede ser enemigo de si mismo
    private void setEnemies(){
       
        for (Player p: players) {
            
            Random r = new Random();
            
            int num_jugadores = players.size();          
            int indice_aleatorio = -1;
                  
            do {
                indice_aleatorio = r.nextInt(num_jugadores);
            } while (indice_aleatorio == players.indexOf(p));
                     
            Player enemy;
            enemy = players.get(indice_aleatorio);
            
            p.setEnemy(enemy);                
        }
    }

    // Lleva a cabo el combate contra el monstruo actual y devuelve el resultado
    // del combate
    public CombatResult developCombat(){

        CombatResult combatResult;
        combatResult = currentPlayer.combat(currentMonster);

        if (combatResult == CombatResult.LOSEANDCONVERT) {
            
            CardDealer dealer = CardDealer.getInstance();
            Cultist cultist = dealer.nextCultist();
            CultistPlayer cp = new CultistPlayer (currentPlayer,cultist);

            for (Player p: players){

                if (p.getEnemy() == currentPlayer)
                    p.setEnemy(cp);
            }

            int indice_sectario = players.indexOf(currentPlayer);
            players.set(indice_sectario, cp);
            currentPlayer = cp;
        }

        dealer.giveMonsterBack(currentMonster);

        return (combatResult);
    }

    // Elimina los tesoros visibles de la lista de tesoros visibles del jugador.
    // Al hacer esto, se le notifica al mal rollo a cerca de este descarte para
    // su posible actualizacion
    public void discardVisibleTreasure(ArrayList <Treasure> treasures){
        
        for(Treasure t: treasures){
            currentPlayer.discardVisibleTreasure(t);
            
            dealer.giveTreasureBack(t);
        }
    }
    
    // Realiza la misma operacion anterior pero con los tesoros ocultos
    public void discardHiddenTreasure(ArrayList <Treasure> treasures){
        
        for(Treasure t: treasures){
            currentPlayer.discardHiddenTreasure(t);
            
            dealer.giveTreasureBack(t);
        }
        
    }
    
    // Convierte los tesoros ocutlos a visibles, siempre que sea posible
    // respetando las reglas del juego
    private void makeTreasuresVisible(ArrayList <Treasure> treasures){
        
        for(Treasure t: treasures){
            currentPlayer.makeTreasureVisible(t);
        }
        
    }
    
    // Inicializa los mazos de monstruos y tesoros, los jugadores, 
    // proporcionandoles un nombre, les asigna un enemigo y ademas inicia el juego
    // con la llamada a nextTurn pasando al siguiente turno
    public void initGame(ArrayList <String> players){
        
        this.initPlayers(players);
        
        this.setEnemies();
        
        dealer.initCards();
        
        this.nextTurn();
    }
    
    // Devuelve el jugador actual
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    // Devuelve el monstruo que esta en juego actualmente
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    // Comprueba si es posible pasar de turno, segun las reglas de juego y si 
    // es asi, termina el turno actual y pasa al siguiente
    public boolean nextTurn(){
        
        boolean stateOK = this.nextTurnIsAllowed();
        
        if(stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = this.nextPlayer();
            
            if(currentPlayer.isDead()){
                currentPlayer.initTreasures();
            }
        }
        
        return stateOK;
    }
    
    // Devuelve "true" en caso de que result sea WINGAME, sino devolvera "false"
    public boolean endOfGame(CombatResult result){
        
        boolean endGame;
        
        endGame = result == CombatResult.WINGAME;
        
        return endGame;          
    }

    @Override
    public String toString() {
        return  "players = " + players 
                + ", currentPlayer = " + currentPlayer 
                + ", currentMonster = " + currentMonster 
                + ", dealer = " + dealer;
    }
    
    
    
}
