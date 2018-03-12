
package napakalaki;

/**
 *
 * @author ixjosemi
 */
public class DeathBadConsequence extends NumericBadConsequence{
    
    // Constructor
    public DeathBadConsequence(String text){
        super(text, MAXLEVELS, MAXTREASURES,MAXTREASURES);
    }
    
    public String toString(){
        return "Bad Consequence: " + text;
    }
}