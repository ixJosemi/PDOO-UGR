
package napakalaki;

/**
 *
 * @author ixjosemi
 */
public class Treasure {

    private String name;
    private int bonus;
    private TreasureKind type;

    // Constructor
    public Treasure (String n, int bonus, TreasureKind t){
        name = n;
        bonus = bonus;
        type = t;
    }
    
    // Devuelve el nombre del tesoro
    public String getName(){
        return name;
    }
    
    // Devuelve el bonus que aporta el tesoro
    public int getBonus(){
        return bonus;
    }
    
    // Devuelve el tipo de tesoro
    public TreasureKind getType(){
        return type;
    }

    @Override
    public String toString() {
        return   "Treasure: " + name 
                + "\n bonus = " + bonus 
                + "\n type = " + type;
    }
    
    
}
