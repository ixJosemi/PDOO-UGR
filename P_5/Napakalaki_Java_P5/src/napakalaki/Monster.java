// MADE BY: JOSE MIGUEL HDEZ GARCIA & JAIRO ABRIL MOYA

package napakalaki;


public class Monster
{
    // Declaración de los atributos PRIVADOS a utilizar
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence badconsequence;
    
    private int levelChangeAgainstCultistPlayer = 0;

    // Constructor que inicializa a valores por defecto
    public Monster(String name, int level, BadConsequence bc, Prize prize, int lc)
    {
        this.name = name;
        this.combatLevel = level;
        this.prize = prize;
        this.badconsequence = bc;
        this.levelChangeAgainstCultistPlayer = lc;
    }

    // Consultores básicos
    // Devuelve el nombre del monstruo
    public String getName(){
        return name;
    }

    // Devuelve el nivel de combate del monstruo
    public int getCombatLevel(){
        return combatLevel;
    }

    // Devuelve el buen rollo del monstruo
    public Prize getPrize(){
        return prize;
    }

    // Devuelve el mal rollo de monstruo
    public BadConsequence getBadConsequence(){
        return badconsequence;
    }

    // Devuelve los niveles que se han ganado al derrotar al monstruo
    public int getLevelsGained(){
        return prize.getLevel();
    }

    // Devuelve los tesoros que se han ganado al derrotar al monstruo
    public int getTreasuresGained(){
        return prize.getTreasures();
    }

    // Devuelve el nivel de combate contra los sectarios
    public int getCombatLevelAgainstCultistPlayer(){
        return levelChangeAgainstCultistPlayer + combatLevel;
    }

    // Método toString para pintar una secuencia
    @Override
    public String toString(){
        return "\n\nMonster{" + "\nName = " + name
            + " \nCombat Level = " + Integer.toString(combatLevel)
            + " \nPrize = " + prize.toString()
            + " \nBad Consequence = " + badconsequence.toString();
    }
}
