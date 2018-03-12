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

// Subclase de la clase player obtenida a partir de herencia
public class CultistPlayer extends Player{
    
    Cultist myCultistCard;
    static int totalCultistPlayers = 0;
    
    // Constructor
    public CultistPlayer(Player p, Cultist c) {

        super(p); // Llamada al constructor de copia de Player.
        totalCultistPlayers++; 
        myCultistCard = c;
    }
    
    // Devuelve el numero total de sectarios (jugadores)
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
    
    // Calcula el nivel que tiene el jugador sectario
    int getCombatLevels(){
        double combatLevel = (super.getCombatLevel()*1.2)+
            (myCultistCard.getGainedLevels()*totalCultistPlayers);
        
        int combatLevel_truncado = (int)combatLevel;
        
        return combatLevel_truncado;
    }
    
    // Devuelve el monstruo del oponente del jugador sectario
    protected int getOponentLevel(Monster m){
        return (m.getCombatLevelAgainstCultistPlayer());
    }
    
    // Devuelve un tesoro al azar de los tesoros visibles
    protected Treasure giveMeATreasure() {
        ArrayList<Treasure> tVisibles = this.getVisibleTreasures();
        
        Random r = new Random ();       
        int i = r.nextInt(tVisibles.size());
        
        return (tVisibles.remove(i)); 
    }

    // Devuelve siempre "false" ya que un sectario no puede volver a convertirse
    // en sectario
    protected boolean shouldConvert(){
        return (false);
    }
 
    // Devuelve si el enemigo tiene tesoros visibles que puedan robarse
    protected boolean canYouGiveMeATreasure(){
        
        Player enemy = this.getEnemy();
        
        ArrayList<Treasure> t = enemy.getVisibleTreasures();

        boolean tiene = !(t.isEmpty());
        
        return (tiene);
    }
 
    public String IsCultist(){
        return "Sí";
    }
}
