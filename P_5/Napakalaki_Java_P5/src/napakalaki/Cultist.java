/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author ixjosemi
 */
public class Cultist {
    
    private String name;
    private int gainedLevels;
    
    // Constructor
    Cultist(String name, int gainedLevels){
        this.name = name;
        this.gainedLevels = gainedLevels;     
    }
    
    // Devuelve los niveles que se han ganado
    int getGainedLevels(){
        return gainedLevels;
    }
}
