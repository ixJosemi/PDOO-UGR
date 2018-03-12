// MADE BY: JOSE MIGUEL HDEZ GARCIA & JAIRO ABRIL MOYA

package napakalaki;
import java.util.ArrayList; // Importamos el util ArrayList para poder usarlo

/**
 *
 * @author ixjosemi
 */

public class BadConsequence
{
    // Declaramos los atributos privados a utilizar
    static int MAXTREASURES = 10;
    private String text; // Representa lo que dice un mal rollo
    private int levels; // Representa el numero de niveles que se pierden
    private int nVisibleTreasures; // Nº Tesoros visibles que se pierden
    private int nHiddenTreasures; // Nº Tesoros ocultos que se pierden
    private boolean death; // Representa un mal rollo de tipo muerte


    // Constructor que inicializa a valores por defecto
    public BadConsequence(String text, int levels, int nVisible, int nHidden)
    {
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }

    // Constructor que inicializa a valores por defecto
    public BadConsequence (String text, boolean death)
    {
        this.text = text;
        this.death = death;
    }

    // Listas de HiddenTreasures y VisibleTreasures
    private ArrayList <TreasureKind> specificHiddenTreasures = new ArrayList();

    private ArrayList <TreasureKind> specificVisibleTreasures = new ArrayList();

    // Constructor que inicializa a valores por defecto
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,
            ArrayList<TreasureKind> tHidden)
    {
        this.text = text;
        this.levels = levels;
        this.specificHiddenTreasures = tVisible;
        this.specificVisibleTreasures = tHidden;
    }

    // Consultores básicos
    // Devuelve text
    public String getText()
    {
        return text;
    }

    // Devuelve levels
    public int getLevels()
    {
        return levels;
    }

    // Devuelve VisibleTreasures
    public int getVisibleTreasures()
    {
        return nVisibleTreasures;
    }

    // Devuelve HiddenTreasures
    public int getHiddenTreasures()
    {
        return nHiddenTreasures;
    }

    // Devuelve si estás muerto o no
    public boolean getDeath()
    {
        return death;
    }

    // Devuelve el SpecificHIddenTreasure
    public ArrayList<TreasureKind> getSpecificHiddenTreasures()
    {
        return specificHiddenTreasures;
    }

    // Devuelve el SpecificVisibleTreasure
    public ArrayList<TreasureKind> getSpecificVisibleTreasures()
    {
        return specificVisibleTreasures;
    }

    public boolean isEmpty(){
        boolean empty = true;

        if(this.levels == 0 && this.death == false && this.nHiddenTreasures == 0
                && this.nVisibleTreasures == 0 && this.specificHiddenTreasures.isEmpty()
                && this.specificVisibleTreasures.isEmpty())
            empty = true;

        return empty;
    }

    public void substractVisibleTreasures(Treasure t){

    }

    public void substractHiddenTreasures(Treasure t){

    }
    /*
    public BadConsequence adjustToFitTreasureLists(Treasure v, Treasure h){

    }
    */

    // Método toString para pintar una secuencia
    public String toString()
    {
        return  text + " \nLost levels = " + levels
            + " \nVisible treasures = " + nVisibleTreasures
            + " \nHidden treasures = " + nHiddenTreasures
            + " \nDeath? = " + death
            + " \nSpecific Hidden Treasures = " + specificHiddenTreasures
            + " \nSpecific Visible Treasures = " + specificVisibleTreasures;
    }
}
