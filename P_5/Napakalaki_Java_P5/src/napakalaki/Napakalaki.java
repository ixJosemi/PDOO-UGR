
package napakalaki;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author ixjosemi
 */

public class Napakalaki {
    private static Napakalaki instance = new Napakalaki();
    private Monster currentMonster;
    private Player currentPlayer = null;
    private ArrayList<Player> players = new ArrayList();
    private CardDealer dealer = CardDealer.getInstance();
    
    private Napakalaki(){}
    
    private void initPlayers(ArrayList<String> names){
        for(String n : names){
            players.add(new Player(n));
        }
    }
    
    private Player nextPlayer(){
        Player sigJugador;
        
        if(currentPlayer == null){
            Random sorteo = new Random();
            
            sigJugador = players.get(sorteo.nextInt(players.size()));
        }
        
        else{
            int i = players.indexOf(currentPlayer);
            
            ++i;
            
            sigJugador = players.get(i%players.size());
        }
        
        return sigJugador;
    }
    
    private boolean nextTurnAllowed(){
        return currentPlayer == null || currentPlayer.validState();
    }
    
    private void setEnemies(){
        Random aleatorio = new Random();
        int entero_aleatorio;
        
        for (Player play : players){
            do {                
               entero_aleatorio = aleatorio.nextInt(players.size());
            } while(entero_aleatorio == players.indexOf(play));
            
            play.setEnemy(players.get(entero_aleatorio));
        }
    }
    
    public static Napakalaki getInstance(){
        return instance;
    }

    public CombatResult developCombat(){
        CombatResult resultado = currentPlayer.combat(currentMonster);
        
        if(resultado == CombatResult.LOSEANDCONVERT){
            CultistPlayer cPlayer = new CultistPlayer(currentPlayer, dealer.nextCultist());
            
            players.remove(currentPlayer);
            players.add(cPlayer);
            
            /*
                Recorremos todos los jugadores y asignamos a los que tenían como enemigo el
                CurrentPlayer a el nuevo que es del tipo Cultist
            */
            
            for(Player jugador : players){
                if(jugador.getEnemy() == currentPlayer)
                    jugador.setEnemy(cPlayer);
            }
            
            currentPlayer = cPlayer;
        }
        
        
        dealer.giveMonsterBack(currentMonster);
        
        return resultado;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for(Treasure trs : treasures){
            currentPlayer.discardVisibleTreasure(trs);
        }
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        for(Treasure trs : treasures){
            currentPlayer.discardHiddenTreasure(trs);
        } 
    }
    
    public void discardAllTreasures(){
        currentPlayer.discardAllTreasures();
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        for(Treasure trs : treasures){
            currentPlayer.makeTreasureVisible(trs);
        }
    }

    public void initGame(ArrayList<String> names){        
        initPlayers(names);
        setEnemies();
        dealer.initCards();
        nextTurn();
    }
    
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return this.currentMonster;
    }
    
    public boolean nextTurn(){
        boolean stateOK = nextTurnAllowed();
        
        if(stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            
            if(currentPlayer.isDead())
                currentPlayer.initTreasures();
        }
        
        return stateOK;
    }
    
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINGAME;
    }
}

