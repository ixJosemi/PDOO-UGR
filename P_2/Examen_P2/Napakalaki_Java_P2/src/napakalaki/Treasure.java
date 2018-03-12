// MADE BY: JOSE MIGUEL HDEZ GARCIA & JAIRO ABRIL MOYA

package napakalaki;

/**
 *
 * @author ixjosemi
 */

public class Treasure {

    private String name;
    private int bonus;
    private TreasureKind type;


    public Treasure (String name, int bonus, TreasureKind type){
        this.name = name;
        this.bonus = bonus;
        this.type = type;
    }
    
    public String getName(){
        return name;
    }
    
    public int getBonus(){
        return bonus;
    }
    
    public TreasureKind getType(){
        return type;
    }
    
}
