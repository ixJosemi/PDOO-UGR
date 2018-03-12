// MADE BY: JOSE MIGUEL HDEZ GARCIA & JAIRO ABRIL MOYA

package napakalaki;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ixjosemi
 */

public class PruebaNapakalaki
{
    static ArrayList <Monster> monstruos = new ArrayList();

    static void AniadeMonstruos()
    {
        // 3 Byakhee de bonanza
        BadConsequence badConsequence1 = new BadConsequence ("Pierdes tu armadura "
            + "visible y otra oculta ", 0,
            new ArrayList (Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList (Arrays.asList(TreasureKind.ARMOR)));
        Prize prize1 = new Prize (4, 2);
        monstruos.add(new Monster("3 Byakhee de bonanza", 8, badConsequence1, prize1));

        // Tenochtitlan
        BadConsequence badConsequence2 = new BadConsequence ("Embobados con el "
            + "lindo primigenio te descartas de tu casco visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.HELMET)),
            new ArrayList (Arrays.asList()));
        Prize prize2 = new Prize (1, 1);
        monstruos.add(new Monster("Tenochtitlan", 2, badConsequence2, prize2));

        // El sopor de Dunwich
        BadConsequence badConsequence3 = new BadConsequence ("El primordial bostezo "
            + "contagioso. Pierdes el calzado visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.SHOES)),
            new ArrayList (Arrays.asList()));
        Prize prize3 = new Prize (1, 1);
        monstruos.add(new Monster("El sopor de Dunwich", 2, badConsequence3, prize3));

        // Demonios de Magaluf
        BadConsequence badConsequence4 = new BadConsequence ("Te atrapan para "
            + "llevarte de fiesta y te dejan caer en mitad del vuelo. "
            + "Descarta 1 mano visible y 1 mano oculta", 0,
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        Prize prize4 = new Prize (4, 1);
        monstruos.add (new Monster("Demonios de Magaluf", 2, badConsequence4, prize4));

        // El gorrón en el umbral
        BadConsequence badConsequence5 = new BadConsequence ("Pierdes todos tus "
            + "objetos visibles", 0, 5, 0);
        Prize prize5 = new Prize (3, 1);
        monstruos.add (new Monster("El gorrón en el umbral", 13, badConsequence5, prize5));

        // H.P. Munchcraft
        BadConsequence badConsequence6 = new BadConsequence ("Pierdes la armadura "
            + "visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList (Arrays.asList()));
        Prize prize6 = new Prize (2, 1);
        monstruos.add (new Monster("H.P. Munchcraft", 6, badConsequence6, prize6));

        // Necrófago
        BadConsequence badConsequence7 = new BadConsequence ("Sientes bichos bajo "
            + "la ropa. Descarta la armadura visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList (Arrays.asList()));
        Prize prize7 = new Prize (1, 1);
        monstruos.add(new Monster("Necrófago", 13, badConsequence7, prize7));

        // El rey de rosado
        BadConsequence badConsequence8 = new BadConsequence ("Pierdes 5 niveles "
            + "y 3 tesoros visibles", 5, 3, 0);
        Prize prize8 = new Prize (3, 2);
        monstruos.add(new Monster("El rey de rosado", 11, badConsequence8, prize8));

        // Flecher
        BadConsequence badConsequence9 = new BadConsequence ("Toses los pulmones "
            + " y pierdes dos niveles", 2, 0, 0);
        Prize prize9 = new Prize (1, 1);
        monstruos.add(new Monster("Flecher", 2, badConsequence9, prize9));

        // Los hondos
        BadConsequence badConsequence10 = new BadConsequence ("Estos monstruos "
            + "resultan bastante superficiales y te aburren mortalmente. "
            + "Estas muerto", true);
        Prize prize10 = new Prize (2, 1);
        monstruos.add(new Monster ("Los hondos", 8, badConsequence10, prize10));

        // Semillas Cthulthu
        BadConsequence badConsequence11 = new BadConsequence ("Pierdes 2 niveles "
            + "y 2 tesoros ocultos", 2, 0, 2);
        Prize prize11 = new Prize (2, 1);
        monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequence11, prize11));

        // Dameargo
        BadConsequence badConsequence12 = new BadConsequence ("Te intentas "
            + "escaquear. Pierdes una mano visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.ONEHAND)),
            new ArrayList (Arrays.asList()));
        Prize prize12 = new Prize (2, 1);
        monstruos.add(new Monster("Dameargo", 1, badConsequence12, prize12));

        // Pollipólipo volante
        BadConsequence badConsequence13 = new BadConsequence ("Da mucho asquito. "
            + "Pierdes 3 niveles", 3, 0, 0);
        Prize prize13 = new Prize(2, 1);
        monstruos.add(new Monster("Pollipólipo volante", 3, badConsequence13, prize13));

        // Yskhtihyssg-Goth
        BadConsequence badConsequence14 = new BadConsequence ("No le hace gracia "
            + "que pronuncie mal su nombre. Estas muerto", true);
        Prize prize14 = new Prize (3, 1);
        monstruos.add(new Monster("Yskhtihyssg-Goth", 14, badConsequence14, prize14));

        // Familia feliz
        BadConsequence badConsequence15 = new BadConsequence ("La familia te "
            + "atrapa. Estas muerto", true);
        Prize prize15 = new Prize (3, 1);
        monstruos.add(new Monster("Familia feliz", 1, badConsequence15, prize15));

        // Roboggoth
        BadConsequence badConsequence16 = new BadConsequence ("La quinta "
            + "directiva primaria te obliga a perder 2 niveles y un tesoro "
            + "2 manos visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.BOTHHANDS)),
            new ArrayList (Arrays.asList()));
        Prize prize16 = new Prize (2, 1);
        monstruos.add(new Monster("Roboggoth", 8, badConsequence16, prize16));

        // El espía sordo
        BadConsequence badConsequence17 = new BadConsequence ("Te asusta en la "
            + "noche. Pierdes un casco visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.HELMET)),
            new ArrayList (Arrays.asList()));
        Prize prize17 = new Prize (1, 1);
        monstruos.add(new Monster("El espía sordo", 5, badConsequence17, prize17));

        // Tongue
        BadConsequence badConsequence18 = new BadConsequence ("Menudo susto te "
            + "llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        Prize prize18 = new Prize (2, 1);
        monstruos.add(new Monster("Tongue", 19, badConsequence18, prize18));

        // Bicéfalo
        BadConsequence badConsequence19 = new BadConsequence ("Te faltan manos "
            + "para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles"
            + "de las manos", 3,
            new ArrayList (Arrays.asList(TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)),
            new ArrayList (Arrays.asList()));
        Prize prize19 = new Prize (2, 1);
        monstruos.add(new Monster("Bicéfalo", 21, badConsequence19, prize19));
    }

    // Comprobar si el nivel es mayor a 10
    public static ArrayList <Monster> combatLevel10 ()
    {
        ArrayList <Monster> result1 = new ArrayList();
        for (Monster m: monstruos)
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
        for (Monster m: monstruos)
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
        for (Monster m: monstruos)
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
        for (Monster m: monstruos)
        {
            if ((m.getBadConsequence().getSpecificVisibleTreasures().contains(treasure)) ||
                (m.getBadConsequence().getSpecificHiddenTreasures().contains(treasure)))
                 result4.add (m);
        }
        return result4;
    }

    // Función main (principal)
    public static void main(String[] args)
    {
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
