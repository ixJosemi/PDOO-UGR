
package napakalaki;

/**
 *
 * @author ixjosemi
 */
public class DeathBadConsequence extends NumericBadConsequence{
    
    // Constructor
    public DeathBadConsequence(String text){
        super(text,Player.MAXLEVEL, BadConsequence.MAXTREASURES, 
                BadConsequence.MAXTREASURES);

    }
    
}