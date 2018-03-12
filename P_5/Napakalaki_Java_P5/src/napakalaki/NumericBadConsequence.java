
package napakalaki;

import java.util.ArrayList;
import static java.lang.Math.min;

/**
 *
 * @author ixjosemi
 */

// Subclase de la clase BadConsequence creada a partir de herencia
public class NumericBadConsequence extends BadConsequence{
    
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    
    // Constructor
    public NumericBadConsequence(String text, int levels, int nVisible, int nHidden){
        
        super(text, levels);
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    
    // Devuelve el numero de tesoros visibles
    public int getnVisibleTreasures(){
        return this.nVisibleTreasures;
    }
    
    // Devuelve el numero de tesoros ocultos
    public int getnHiddenTreasures(){
        return this.nHiddenTreasures;
    }
    
    // Comprueba si el mal rollo esta vacio o no
    @Override
    public boolean isEmpty () {
        return nHiddenTreasures == 0 && nVisibleTreasures == 0;
    }
    
    // Actualiza el mal rollo para que el tesoro visible "t" no forme
    // parte de este
    @Override
    public void substractVisibleTreasures (Treasure t) {       
        if (nVisibleTreasures > 0)
            nVisibleTreasures--;
    }
    
    // Actualiza el mal rollo para que el tesoro oculto"t" no forme
    // parte de este
    @Override
    public void substractHiddenTreasures (Treasure t) {
        if (nHiddenTreasures > 0)
            nHiddenTreasures--;
    }
    
    // Recibe los tesoros visibles y ocultos del jugador y devuelve un mal
    // rollo adaptado a las posibilidades del jugador
    @Override
    public BadConsequence adjustToFitTreasureLists (ArrayList <Treasure> v, 
                                                    ArrayList <Treasure> h) {
         
        BadConsequence bc;
        
        int nVisible;
        int nHidden;
      
        nVisible = min(nVisibleTreasures, v.size());
        nHidden = min(nHiddenTreasures, h.size());
        
        return new NumericBadConsequence(text, levels, nVisible, nHidden);
    }
    
    @Override 
    public String toString(){
        return "Bad Consequence: " + text + 
               " \nLosen Levels: " + Integer.toString(levels) + 
                "\nVisible Treasures: " + Integer.toString(nVisibleTreasures) + 
                "\tHidden Treasure: " + Integer.toString(nHiddenTreasures);
    }
}
