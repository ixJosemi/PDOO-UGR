// MADE BY: JOSE MIGUEL HDEZ GARCIA & JAIRO ABRIL MOYA

package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author ixjosemi
 */

public class CardDealer {
    
    private static CardDealer instance = null;
    
    private CardDealer(){
        
    }
    
    // Declaramos el array que va a contener todos los tesoros
    static ArrayList <Treasure> unusedTreasures = new ArrayList();
    
    // Declaramos el array que va a contener los tesoros usados
    static ArrayList <Treasure> usedTreasures = new ArrayList();
    
    // Declaramos el array que va a contener todos los monstruos
    static ArrayList <Monster> unusedMonsters = new ArrayList();
    
    // Declaramos el array que va a contener los monstruos usados
    static ArrayList <Monster> usedMonsters = new ArrayList();
    
    
    // Declaramos todos los tesoros
    private void initTreasureCardDeck(){
        
       // ¡Si, mi amo!
       unusedTreasures.add(new Treasure("¡Si, mi amo!", 4, TreasureKind.HELMET));
       
       // Botas de investigacion
       unusedTreasures.add(new Treasure("Botas de investigacion", 3, TreasureKind.SHOES));
       
       // Capucha de Cthulhu
       unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET));
       
       // A prueba de babas
       unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
       
       // Botas de lluvia acida
       unusedTreasures.add(new Treasure("Botas de lluvia acida", 1, TreasureKind.SHOES));
       
       // Casco minero
       unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
       
       // Ametralladora ACME
       unusedTreasures.add(new Treasure("Ametralladora ACME", 4, TreasureKind.BOTHHANDS));
       
       // Camiseta de la ETSIIT
       unusedTreasures.add(new Treasure("Camiseta de la ETSIIT", 1, TreasureKind.ARMOR));
       
       // Clavo de rail ferroviario
       unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND));
       
       // Cuchillo de sushi arcano
       unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
       
       // Fez alopodo
       unusedTreasures.add(new Treasure("Fez alopodo", 3, TreasureKind.HELMET));
       
       // Hacha prehistorica
       unusedTreasures.add(new Treasure("Hacha Prehistorica", 2, TreasureKind.ONEHAND));
       
       // El aparato del Pr. Tesla
       unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR));
       
       // Gaita
       unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
       
       // Insecticida
       unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
       
       // Escopeta de 3 cañones
       unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS));
       
       // Garabato mistico
       unusedTreasures.add(new Treasure("Garabato mistico", 2, TreasureKind.ONEHAND));
       
       // La rebeca metalica
       unusedTreasures.add(new Treasure("La rebeca metalica", 2, TreasureKind.ARMOR));
       
       // Lanzallamas
       unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
       
       // Necrocomicon
       unusedTreasures.add(new Treasure("Necrocomicon", 1, TreasureKind.ONEHAND));
       
       // Necronomicon
       unusedTreasures.add(new Treasure("Necronomicon", 5, TreasureKind.BOTHHANDS));
       
       // Linterna a 2 manos
       unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS));
       
       // Necrognomicon
       unusedTreasures.add(new Treasure("Necrognomicon", 2, TreasureKind.ONEHAND));
       
       // Necrotelecom
       unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
       
       // Mazo de los antiguos
       unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND));
       
       // Necroplayboycon
       unusedTreasures.add(new Treasure("Necroplayboycon", 3, TreasureKind.ONEHAND));
       
       // Porra preternatural
       unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
       
       // Shogulador
       unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
       
       // Varita de atizamiento
       unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
       
       // Tentaculo de pega
       unusedTreasures.add(new Treasure("Tentaculo de pega", 2, TreasureKind.HELMET));
       
       // Zapato deja-amigos
       unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES));
       
    }
    
    // Declaramos todos los monstruos
    private void initMonsterCardDeck(){
        
         // 3 Byakhee de bonanza
        BadConsequence badConsequence1 = new BadConsequence ("Pierdes tu armadura "
            + "visible y otra oculta ", 0,
            new ArrayList (Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList (Arrays.asList(TreasureKind.ARMOR)));
        Prize prize1 = new Prize (4, 2);
        unusedMonsters.add(new Monster("3 Byakhee de bonanza", 8, badConsequence1, prize1));

        // Tenochtitlan
        BadConsequence badConsequence2 = new BadConsequence ("Embobados con el "
            + "lindo primigenio te descartas de tu casco visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.HELMET)),
            new ArrayList (Arrays.asList()));
        Prize prize2 = new Prize (1, 1);
        unusedMonsters.add(new Monster("Tenochtitlan", 2, badConsequence2, prize2));

        // El sopor de Dunwich
        BadConsequence badConsequence3 = new BadConsequence ("El primordial bostezo "
            + "contagioso. Pierdes el calzado visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.SHOES)),
            new ArrayList (Arrays.asList()));
        Prize prize3 = new Prize (1, 1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence3, prize3));

        // Demonios de Magaluf
        BadConsequence badConsequence4 = new BadConsequence ("Te atrapan para "
            + "llevarte de fiesta y te dejan caer en mitad del vuelo. "
            + "Descarta 1 mano visible y 1 mano oculta", 0,
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        Prize prize4 = new Prize (4, 1);
        unusedMonsters.add (new Monster("Demonios de Magaluf", 2, badConsequence4, prize4));

        // El gorrón en el umbral
        BadConsequence badConsequence5 = new BadConsequence ("Pierdes todos tus "
            + "objetos visibles", 0, BadConsequence.MAXTREASURES, 0);
        Prize prize5 = new Prize (3, 1);
        unusedMonsters.add (new Monster("El gorrón en el umbral", 13, badConsequence5, prize5));

        // H.P. Munchcraft
        BadConsequence badConsequence6 = new BadConsequence ("Pierdes la armadura "
            + "visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList (Arrays.asList()));
        Prize prize6 = new Prize (2, 1);
        unusedMonsters.add (new Monster("H.P. Munchcraft", 6, badConsequence6, prize6));

        // Necrófago
        BadConsequence badConsequence7 = new BadConsequence ("Sientes bichos bajo "
            + "la ropa. Descarta la armadura visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList (Arrays.asList()));
        Prize prize7 = new Prize (1, 1);
        unusedMonsters.add(new Monster("Necrófago", 13, badConsequence7, prize7));

        // El rey de rosado
        BadConsequence badConsequence8 = new BadConsequence ("Pierdes 5 niveles "
            + "y 3 tesoros visibles", 5, 3, 0);
        Prize prize8 = new Prize (3, 2);
        unusedMonsters.add(new Monster("El rey de rosado", 11, badConsequence8, prize8));

        // Flecher
        BadConsequence badConsequence9 = new BadConsequence ("Toses los pulmones "
            + " y pierdes dos niveles", 2, 0, 0);
        Prize prize9 = new Prize (1, 1);
        unusedMonsters.add(new Monster("Flecher", 2, badConsequence9, prize9));

        // Los hondos
        BadConsequence badConsequence10 = new BadConsequence ("Estos monstruos "
            + "resultan bastante superficiales y te aburren mortalmente. "
            + "Estas muerto", true);
        Prize prize10 = new Prize (2, 1);
        unusedMonsters.add(new Monster ("Los hondos", 8, badConsequence10, prize10));

        // Semillas Cthulthu
        BadConsequence badConsequence11 = new BadConsequence ("Pierdes 2 niveles "
            + "y 2 tesoros ocultos", 2, 0, 2);
        Prize prize11 = new Prize (2, 1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence11, prize11));

        // Dameargo
        BadConsequence badConsequence12 = new BadConsequence ("Te intentas "
            + "escaquear. Pierdes una mano visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.ONEHAND)),
            new ArrayList (Arrays.asList()));
        Prize prize12 = new Prize (2, 1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence12, prize12));

        // Pollipólipo volante
        BadConsequence badConsequence13 = new BadConsequence ("Da mucho asquito. "
            + "Pierdes 3 niveles", 3, 0, 0);
        Prize prize13 = new Prize(2, 1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence13, prize13));

        // Yskhtihyssg-Goth
        BadConsequence badConsequence14 = new BadConsequence ("No le hace gracia "
            + "que pronuncie mal su nombre. Estas muerto", true);
        Prize prize14 = new Prize (3, 1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 14, badConsequence14, prize14));

        // Familia feliz
        BadConsequence badConsequence15 = new BadConsequence ("La familia te "
            + "atrapa. Estas muerto", true);
        Prize prize15 = new Prize (3, 1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence15, prize15));

        // Roboggoth
        BadConsequence badConsequence16 = new BadConsequence ("La quinta "
            + "directiva primaria te obliga a perder 2 niveles y un tesoro "
            + "2 manos visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.BOTHHANDS)),
            new ArrayList (Arrays.asList()));
        Prize prize16 = new Prize (2, 1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence16, prize16));

        // El espía sordo
        BadConsequence badConsequence17 = new BadConsequence ("Te asusta en la "
            + "noche. Pierdes un casco visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.HELMET)),
            new ArrayList (Arrays.asList()));
        Prize prize17 = new Prize (1, 1);
        unusedMonsters.add(new Monster("El espía sordo", 5, badConsequence17, prize17));

        // Tongue
        BadConsequence badConsequence18 = new BadConsequence ("Menudo susto te "
            + "llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        Prize prize18 = new Prize (2, 1);
        unusedMonsters.add(new Monster("Tongue", 19, badConsequence18, prize18));

        // Bicéfalo
        BadConsequence badConsequence19 = new BadConsequence ("Te faltan manos "
            + "para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles"
            + "de las manos", 3,
            new ArrayList (Arrays.asList(TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)),
            new ArrayList (Arrays.asList()));
        Prize prize19 = new Prize (2, 1);
        unusedMonsters.add(new Monster("Bicéfalo", 21, badConsequence19, prize19));      
    }
    
    private void shuffleTreasures(){
        Collections.shuffle(this.unusedTreasures);
    }
    
    private void shuffleMonsters(){
        Collections.shuffle(this.unusedMonsters);
    }
    
    public CardDealer getInstance(){
        return this.instance;
    }
    
    /*
    public Treasure nextTreasure(){
        
    }
    
    public Monster nextMonster(){
        
    }
    */
    
    public void giveTreasureBack(Treasure treasure){
        this.usedTreasures.add(treasure);
    }
    
    public void giveMonsterBack(Monster monster){
        this.usedMonsters.add(monster);
    }
    
    public void initCards(){
        
    }
}
