// MADE BY: JOSE MIGUEL HDEZ GARCIA & JAIRO ABRIL MOYA

package napakalaki;
import java.util.ArrayList; // Importamos el util ArrayList para poder usarlo

/*
* Clase BadConsequence del paquete napakalaki
*/

public abstract class BadConsequence{
    
    // Declaramos los atributos privados a utilizar
    static final int MAXTREASURES = 10;
    
    protected String text; // Representa lo que dice un mal rollo
    protected int levels; // Representa el numero de niveles que se pierden


    // Constructor que inicializa a valores por defecto
    public BadConsequence(String text, int levels){
        this.text = text;
        this.levels = levels;

    }
   
    // Devuelve el texto del mal rollo del monstruo
    public String getText(){
        return this.text;
    }

    // Devuelve los niveles que se pierden con el mal rollo
    public int getLevels(){
        return this.levels;
    }

    // Devuelve si el mal rollo esta vacio o no
    public abstract boolean isEmpty();
    
    // Actualiza el mal rollo para que el tesoro visible "t" no forme parte del
    // mismo
    public abstract void substractVisibleTreasures (Treasure t);
     
    // Actualiza el mal rollo para que el tesoro oculto "t" no forme parte del
    // mismo
    public abstract void substractHiddenTreasures (Treasure t);
        
    // Recibe los tesoros visibles y ocultos del jugador y devuelve un mal
    // rollo adaptado a las posibilidades del jugador
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList <Treasure> v, 
                                                            ArrayList <Treasure> h); 
    
    
    // Método toString para pintar una secuencia
    @Override
    public String toString(){
        return  text + " \nLost levels = " + levels;
          
    }
}

