// MADE BY: JOSE MIGUEL HDEZ GARCIA & JAIRO ABRIL MOYA

package napakalaki;

/*
* Clase Prize del paquete napakalaki
*/

public class Prize{
    
    // Declaramos los atributos PRIVADOS a utilizar
    private int level;
    private int treasures;

    // Constructor
    public Prize(int treasure, int level){
        
        treasures = treasure;
        level = level;
    }

    // Consultores básicos
    // Devuelve los tesoros que se pueden ganar con el buen rollo
    public int getTreasures(){
        return treasures;
    }

    // Devuelve los niveles que pueden ganarse con el buen rollo
    public int getLevel(){
        return level;
    }

    // Método toString para pintar una secuencia
    public String toString(){
        return "Level -> " + Integer.toString(level) + 
               ", Treasures -> " + Integer.toString(treasures);
    }
}