// MADE BY: JOSE MIGUEL HDEZ GARCIA & JAIRO ABRIL MOYA

package napakalaki;


public class Monster
{
    // Declaración de los atributos PRIVADOS a utilizar
    private final String name;
    private final int combatLevel;
    private final Prize prize;
    private final BadConsequence badconsequence;

    // Constructor que inicializa a valores por defecto
    public Monster(String name, int level, BadConsequence bc, Prize prize)
    {
        this.name = name;
        this.combatLevel = level;
        this.prize = prize;
        this.badconsequence = bc;
    }

    // Consultores básicos
    // Devuelve name
    public String getName(){
        return name;
    }

    // Devuelve combatLevel
    public int getCombatLevel(){
        return combatLevel;
    }

    // Devuelve prize
    public Prize getPrize(){
        return prize;
    }

    // Devuelve badconsequence
    public BadConsequence getBadConsequence(){
        return badconsequence;
    }
    
    // Devuelve los niveles que has ganado al derrotar al monstruo
    public int getLevelsGained(){
        return prize.getLevel();
    }
    
    // Devuelve los tesoros que has ganado al derrotar al monstruo
    public int getTreasuresGained(){
        return prize.getTreasures();
    }

    // Método toString para pintar una secuencia
    @Override
    public String toString(){
        return "\n\nMonster{" + "\nName = " + name
            + " \nCombat Level = " + combatLevel
            + " \nPrize = " + prize
            + " \nBad Consequence = " + badconsequence + '}';
    }
}
