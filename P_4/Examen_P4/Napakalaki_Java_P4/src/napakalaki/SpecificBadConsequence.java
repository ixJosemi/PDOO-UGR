
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author ixjosemi
 */

// Subclase de la clase BadConsequence creada a partir de herencia
public class SpecificBadConsequence extends BadConsequence{
    
    private ArrayList <TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList <TreasureKind> specificVisibleTreasures = new ArrayList();
    
    // Constructor
    public SpecificBadConsequence(String text, int levels, ArrayList <TreasureKind> tVisible,
                                    ArrayList <TreasureKind> tHidden){
        
        super(text, levels);
        specificHiddenTreasures = tHidden;
        specificVisibleTreasures = tVisible;
    }
    
    // Devuelve los tesoros visibles especificos
    public ArrayList <TreasureKind> getSpecificVisibleTreasures () {
        
        return (specificVisibleTreasures);       
    }
    
    // Devuelve los tesoros ocultos especificos
    public ArrayList <TreasureKind> getSpecificHiddenTreasures () {
        
        return (specificHiddenTreasures);       
    }
    
    // Comprueba si las listas de tesoros visibles/ocultos están vacías.
    public boolean estanVacias() {
        boolean vacias = false;
        
        if (specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty()) {
            vacias = true;
        }
                
        return vacias;
    }
    
    // Comprueba si el mal rollo está vacío.
    public boolean isEmpty () {
        
        boolean vacio = false;

        if (estanVacias())
            vacio = true;
        
        return (vacio);

    }
    
    /// Actualiza el mal rollo para que el tesoro visible "t" no forme
    // parte de este
    public void substractVisibleTreasures (Treasure t) {
        specificVisibleTreasures.remove(t);
    }
    
   // Actualiza el mal rollo para que el tesoro oculto "t" no forme
    // parte de este
    public void substractHiddenTreasures (Treasure t) {  
        specificHiddenTreasures.remove(t);
    }
  
    // Recibe los tesoros visibles y ocultos del jugador y devuelve un mal
    // rollo adaptado a las posibilidades del jugador
    public BadConsequence adjustToFitTreasureLists (ArrayList <Treasure> v, 
                                                    ArrayList <Treasure> h) {
        
        BadConsequence bc;
    
        ArrayList <TreasureKind> vTreasures = new ArrayList();
        ArrayList <TreasureKind> hTreasures = new ArrayList();
   
        for(Treasure t:v) 
            vTreasures.add(t.getType()); 
                 
        for(Treasure t:h) 
            hTreasures.add(t.getType());                

        vTreasures.retainAll(specificVisibleTreasures); 
        hTreasures.retainAll(specificHiddenTreasures); 
            
        bc = new SpecificBadConsequence(text, levels, vTreasures, hTreasures);  
     
        return bc;
    }
    
}
