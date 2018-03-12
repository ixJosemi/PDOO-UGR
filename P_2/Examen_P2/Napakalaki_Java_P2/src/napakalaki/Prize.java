// MADE BY: JOSE MIGUEL HDEZ GARCIA & JAIRO ABRIL MOYA

package napakalaki;

/**
 *
 * @author ixjosemi
 */

public class Prize
{
    // Declaramos los atributos PRIVADOS a utilizar
    private int level;
    private int treasures;

    // Constructor que inicializa a valores por defecto
    public Prize(int treasure, int level)
    {
        this.treasures = treasure;
        this.level = level;
    }

    // Consultores básicos
    // Método get devuelve el valor de los tesoros
    public int getTreasures()
    {
        return treasures;
    }

    // Método get devuelve el valor del nivel
    public int getLevel()
    {
        return level;
    }

    // Método toString para pintar una secuencia
    public String toString()
    {
        return "Level -> " + level + ", Treasures -> " + treasures;
    }
}

