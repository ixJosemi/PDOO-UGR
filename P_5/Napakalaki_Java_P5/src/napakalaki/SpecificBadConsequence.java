
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
        specificHiddenTreasures = new ArrayList(tVisible);
        specificVisibleTreasures = new ArrayList(tHidden);
    }
    
    // Devuelve los tesoros visibles especificos
    public ArrayList <TreasureKind> getSpecificVisibleTreasures () {
        
        return this.specificVisibleTreasures;     
    }
    
    // Devuelve los tesoros ocultos especificos
    public ArrayList <TreasureKind> getSpecificHiddenTreasures () {
        
        return this.specificHiddenTreasures;    
    }
    
  
    
    // Comprueba si el mal rollo está vacío.
    @Override
    public boolean isEmpty () {
        return specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty();
    }
    
    /// Actualiza el mal rollo para que el tesoro visible "t" no forme
    // parte de este
    @Override
    public void substractVisibleTreasures (Treasure t) {
        specificVisibleTreasures.remove(t.getType());
    }
    
   // Actualiza el mal rollo para que el tesoro oculto "t" no forme
    // parte de este
    @Override
    public void substractHiddenTreasures (Treasure t) {  
        specificHiddenTreasures.remove(t.getType());
    }
  
    // Recibe los tesoros visibles y ocultos del jugador y devuelve un mal
    // rollo adaptado a las posibilidades del jugador
    @Override
    public BadConsequence adjustToFitTreasureLists (ArrayList <Treasure> v, 
                                                    ArrayList <Treasure> h) {
    
        ArrayList <TreasureKind> vTreasures = new ArrayList();
        ArrayList <TreasureKind> hTreasures = new ArrayList();
   
        vTreasures = interseccionTreasureKind(v, specificVisibleTreasures);
         
        hTreasures = interseccionTreasureKind(h, specificHiddenTreasures);
        
        return new SpecificBadConsequence(text, levels, vTreasures, hTreasures);
        
    }
    
    private ArrayList<TreasureKind> interseccionTreasureKind(ArrayList<Treasure> tesorosPlayer, ArrayList<TreasureKind> tiposBC){
        ArrayList<TreasureKind> newList = new ArrayList(),
                                 tiposPlayer = new ArrayList();
        
        int index; 
         
        for(Treasure trs : tesorosPlayer)
            tiposPlayer.add(trs.getType());
       
        for(TreasureKind tk : tiposBC){
            index = tiposPlayer.indexOf(tk);
            
            if(index > 0){
                newList.add(tiposPlayer.remove(index));
            }
        }
        
        return newList;
    }
    
}
