// MADE BY: JOSE MIGUEL HDEZ GARCIA & JAIRO ABRIL MOYA

package napakalaki;
import java.util.Random;
// Clase singleton

/**
 *
 * @author ixjosemi
 */

public class Dice {

    private static Dice instance = null;

    // Dado que el constructor es privado no puede instanciarse desde otra clase
    private Dice(){

    }

    // Consultor que devuelve instance
    public static Dice getInstance(){
        return instance;
    }

    // Generador de numeros aleatorios entre 1 y 6 (Las caras del dado)
    public int nextNumber(){
        Random rnd = new Random();
        int random = rnd.nextInt() * 6 + 1;

        return random;
    }

}
