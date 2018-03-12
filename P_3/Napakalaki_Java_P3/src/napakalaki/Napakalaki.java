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

public class Napakalaki {
    
    private static final Napakalaki instance = new Napakalaki();
    
    private ArrayList <Player> players;
    private Player currentPlayer = null;
    private Monster currentMonster = null;
    private CardDealer dealer = CardDealer.getInstance();
    
    private Napakalaki(){}
    
    private void initPlayers(ArrayList<String> names){
        this.players = new ArrayList();
        
        for (String s : names)
            players.add(new Player(s));
    }
    
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
    
    private boolean nextTurnIsAllowed(){
        
        boolean isAllowed;
        
        if (currentPlayer == null)
            isAllowed = true;
        else
            isAllowed = currentPlayer.validState();
        
        return isAllowed;
    }
    
    private void setEnemies(){
       
        Random rnd = new Random();
        int number;
        
        for(int i = 1; i < players.size(); i++){
            number = rnd.nextInt(players.size());
            
            players.get(i).setEnemy(players.get(number));         
        }
    }

    public static Napakalaki getInstance(){
        return instance;
    }
    
    public CombatResult developCombat(){
        
        CombatResult combatResult;
        
        combatResult = currentPlayer.combat(currentMonster);
        
        dealer.giveMonsterBack(currentMonster);
        
        return combatResult;
    }
    
    public void discardVisibleTreasure(ArrayList <Treasure> treasures){
        
        for(Treasure t: treasures){
            currentPlayer.discardVisibleTreasure(t);
            
            dealer.giveTreasureBack(t);
        }
    }
    
    public void discardHiddenTreasure(ArrayList <Treasure> treasures){
        
        for(Treasure t: treasures){
            currentPlayer.discardHiddenTreasure(t);
            
            dealer.giveTreasureBack(t);
        }
        
    }
    
    private void makeTreasuresVisible(ArrayList <Treasure> treasures){
        
        for(Treasure t: treasures){
            currentPlayer.makeTreasureVisible(t);
        }
        
    }
    
    public void initGame(ArrayList <String> players){
        
        this.initPlayers(players);
        
        this.setEnemies();
        
        dealer.initCards();
        
        this.nextTurn();
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
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
