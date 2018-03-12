
package napakalaki;

import java.util.ArrayList;

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
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
    }
    
    // Devuelve el numero de tesoros visibles
    public int getVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    // Devuelve el numero de tesoros ocultos
    public int getHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    // Comprueba si el mal rollo esta vacio o no
    public boolean isEmpty () {
        boolean vacio = false;

        if (nVisibleTreasures == 0 && nHiddenTreasures == 0)
            vacio = true;

        return (vacio);
    }
    
    // Actualiza el mal rollo para que el tesoro visible "t" no forme
    // parte de este
    public void substractVisibleTreasures (Treasure t) {       
        nVisibleTreasures = nVisibleTreasures - 1;
    }
    
    // Actualiza el mal rollo para que el tesoro oculto"t" no forme
    // parte de este
    public void substractHiddenTreasures (Treasure t) {
        nHiddenTreasures = nHiddenTreasures - 1;      
    }
    
    // Recibe los tesoros visibles y ocultos del jugador y devuelve un mal
    // rollo adaptado a las posibilidades del jugador
    public BadConsequence adjustToFitTreasureLists (ArrayList <Treasure> v, 
                                                    ArrayList <Treasure> h) {
         
        BadConsequence bc;
        
        int nVisible;
        int nHidden;
      
        if (nVisibleTreasures > v.size()) {
            nVisible = v.size(); 
        }    
        else {
            nVisible = nVisibleTreasures;
        }
            
        if (nHiddenTreasures > h.size()) {
            nHidden = h.size();
        }
        else {
            nHidden = nHiddenTreasures;
        }
                
        bc = new NumericBadConsequence(this.text, levels,nVisible ,nHidden);

        return bc;
    }
}
