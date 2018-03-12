// MADE BY: JOSE MIGUEL HDEZ GARCIA & JAIRO ABRIL MOYA

package napakalaki;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Clase principal del paquete napakalaki
 */

public class PruebaNapakalaki{

    static ArrayList <Monster> unusedMonsters = new ArrayList();

    static void AniadeMonstruos(){

        // 3 Byakhee de bonanza
        BadConsequence badConsequence = new SpecificBadConsequence("Pierdes tu armadura "
            + "visible y otra oculta ", 0,
            new ArrayList (Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList (Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize (4, 2);
        unusedMonsters.add(new Monster("3 Byakhee de bonanza", 8, badConsequence, prize, 0));

        // Tenochtitlan
         badConsequence = new SpecificBadConsequence("Embobados con el "
            + "lindo primigenio te descartas de tu casco visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.HELMET)),
            new ArrayList (Arrays.asList()));
        prize = new Prize (1, 1);
        unusedMonsters.add(new Monster("Tenochtitlan", 2, badConsequence, prize, 0));

        // El sopor de Dunwich
        badConsequence = new SpecificBadConsequence("El primordial bostezo "
            + "contagioso. Pierdes el calzado visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.SHOES)),
            new ArrayList (Arrays.asList()));
        prize = new Prize (1, 1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize, 0));

        // Demonios de Magaluf
        badConsequence = new SpecificBadConsequence ("Te atrapan para "
            + "llevarte de fiesta y te dejan caer en mitad del vuelo. "
            + "Descarta 1 mano visible y 1 mano oculta", 0,
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize (4, 1);
        unusedMonsters.add (new Monster("Demonios de Magaluf", 2, badConsequence, prize, 0));

        // El gorrón en el umbral
        badConsequence = new NumericBadConsequence ("Pierdes todos tus "
            + "objetos visibles", 0, BadConsequence.MAXTREASURES, 0);
        prize = new Prize (3, 1);
        unusedMonsters.add (new Monster("El gorrón en el umbral", 13, badConsequence, prize, 0));

        // H.P. Munchcraft
        badConsequence = new SpecificBadConsequence ("Pierdes la armadura "
            + "visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList (Arrays.asList()));
        prize = new Prize (2, 1);
        unusedMonsters.add (new Monster("H.P. Munchcraft", 6, badConsequence, prize, 0));

        // Necrófago
        badConsequence = new SpecificBadConsequence ("Sientes bichos bajo "
            + "la ropa. Descarta la armadura visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList (Arrays.asList()));
        prize = new Prize (1, 1);
        unusedMonsters.add(new Monster("Necrófago", 13, badConsequence, prize, 0));

        // El rey de rosado
        badConsequence = new NumericBadConsequence ("Pierdes 5 niveles "
            + "y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize (3, 2);
        unusedMonsters.add(new Monster("El rey de rosado", 11, badConsequence, prize, 0));

        // Flecher
        badConsequence = new NumericBadConsequence ("Toses los pulmones "
            + " y pierdes dos niveles", 2, 0, 0);
        prize = new Prize (1, 1);
        unusedMonsters.add(new Monster("Flecher", 2, badConsequence, prize, 0));

        // Los hondos
        badConsequence = new DeathBadConsequence ("Estos monstruos " +
           " resultan bastante superficiales y te aburren mortalmente. "+
            "Estas muerto");
        prize = new Prize (2, 1);
        unusedMonsters.add(new Monster ("Los hondos", 8, badConsequence, prize, 0));

        // Semillas Cthulthu
        badConsequence = new NumericBadConsequence ("Pierdes 2 niveles "
            + "y 2 tesoros ocultos", 2, 0, 2);
        prize = new Prize (2, 1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize, 0));

        // Dameargo
        badConsequence = new SpecificBadConsequence ("Te intentas "
            + "escaquear. Pierdes una mano visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.ONEHAND)),
            new ArrayList (Arrays.asList()));
        prize = new Prize (2, 1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize, 0));

        // Pollipólipo volante
        badConsequence = new NumericBadConsequence ("Da mucho asquito. "
            + "Pierdes 3 niveles", 3, 0, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize, 0));

        // Yskhtihyssg-Goth
        badConsequence = new DeathBadConsequence ("No le hace gracia "
            + "que pronuncie mal su nombre. Estas muerto");
        prize = new Prize (3, 1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 14, badConsequence, prize, 0));

        // Familia feliz
        badConsequence = new DeathBadConsequence ("La familia te "
            + "atrapa. Estas muerto");
        prize = new Prize (3, 1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize, 0));

        // Roboggoth
        badConsequence = new SpecificBadConsequence ("La quinta "
            + "directiva primaria te obliga a perder 2 niveles y un tesoro "
            + "2 manos visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.BOTHHANDS)),
            new ArrayList (Arrays.asList()));
        prize = new Prize (2, 1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize, 0));

        // El espía sordo
        badConsequence = new SpecificBadConsequence ("Te asusta en la "
            + "noche. Pierdes un casco visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.HELMET)),
            new ArrayList (Arrays.asList()));
        prize = new Prize (1, 1);
        unusedMonsters.add(new Monster("El espía sordo", 5, badConsequence, prize, 0));

        // Tongue
        badConsequence = new NumericBadConsequence ("Menudo susto te "
            + "llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize (2, 1);
        unusedMonsters.add(new Monster("Tongue", 19, badConsequence, prize, 0));

        // Bicéfalo
        badConsequence = new SpecificBadConsequence ("Te faltan manos "
            + "para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles"
            + "de las manos", 3,
            new ArrayList (Arrays.asList(TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)),
            new ArrayList (Arrays.asList()));
        prize = new Prize (2, 1);
        unusedMonsters.add(new Monster("Bicéfalo", 21, badConsequence, prize, 0));

        // El mal indecible impronunciable
        badConsequence = new SpecificBadConsequence ("Pierdes 1 mano visible", 0,
           new ArrayList (Arrays.asList(TreasureKind.ONEHAND)),
           new ArrayList (Arrays.asList()));
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10,
            badConsequence, prize, -2));

        // Testigos oculares
        badConsequence = new NumericBadConsequence ("Pierdes tus tesoros visibles. Jajaja", 0, 5, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Testigos oculares", 6, badConsequence, prize, 2));

        // El gran cthulhu
        badConsequence = new DeathBadConsequence ("Hoy no es tu dia de suerte. Mueres");
        prize = new Prize(2, 5);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, badConsequence, prize, 4));

        // Serpiente político
        badConsequence = new NumericBadConsequence ("Tu gobierno te recorta 2 niveles", 2, 0, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Serpiente político", 8, badConsequence, prize, -2));

        // Felpuggoth
        badConsequence = new SpecificBadConsequence ("Pierdes tu casco y tu armadura visible."
            + " Pierdes tus manos ocultas", 0,
            new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)),
            new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS, TreasureKind.ONEHAND)));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, badConsequence, prize, 5));

        // Shoggoth
        badConsequence = new NumericBadConsequence ("Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(4, 2);
        unusedMonsters.add(new Monster("Shoggoth", 16, badConsequence, prize, -4));

        // Lolitagooth
        badConsequence = new NumericBadConsequence ("Pintalabios negro. Pierdes 2 niveles",
            2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, badConsequence, prize, 3));
   
    }

    // Comprobar si el nivel es mayor a 10
    public static ArrayList <Monster> combatLevel10 ()
    {
        ArrayList <Monster> result1 = new ArrayList();
        for (Monster m: unusedMonsters)
        {
            if (m.getCombatLevel() > 10)
                result1.add (m);
        }
        return result1;
    }

    // Comprobar si el mal rollo solo implica perdida de niveles
    public static ArrayList <Monster> OnlyLostLevels()
    {
        ArrayList <Monster> result2 = new ArrayList();
        for (Monster m: unusedMonsters)
        {
            if ((m.getBadConsequence().getHiddenTreasures() == 0) &&
                (m.getBadConsequence().getVisibleTreasures() == 0) &&
                (m.getBadConsequence().getDeath() == false) &&
                (m.getBadConsequence().getLevels() != 0))
                result2.add (m);
        }
        return result2;
    }

    // Comprobar si el buen rollo unicamente proporciona niveles
    public static ArrayList <Monster> GainLevels()
    {
        ArrayList <Monster> result3 = new ArrayList();
        for (Monster m: unusedMonsters)
        {
            if ((m.getPrize().getLevel() > 1))
                result3.add (m);
        }
        return result3;
    }

    // Monstruos que hacen perder un tesoro especifico
    public static ArrayList <Monster> LostTreasures(TreasureKind treasure)
    {
        ArrayList <Monster> result4 = new ArrayList();
        for (Monster m: unusedMonsters)
        {
            if ((m.getBadConsequence().getSpecificVisibleTreasures().contains(treasure)) ||
                (m.getBadConsequence().getSpecificHiddenTreasures().contains(treasure)))
                 result4.add (m);
        }
        return result4;
    }

    // Función main (principal)
    public static void main(String[] args){

        AniadeMonstruos();

        System.out.println(combatLevel10());
        System.out.println(OnlyLostLevels());
        System.out.println(GainLevels());

        System.out.println(LostTreasures(TreasureKind.ARMOR));
        System.out.println(LostTreasures(TreasureKind.BOTHHANDS));
        System.out.println(LostTreasures(TreasureKind.HELMET));
        System.out.println(LostTreasures(TreasureKind.SHOES));
        System.out.println(LostTreasures(TreasureKind.ONEHAND));
    }
}
