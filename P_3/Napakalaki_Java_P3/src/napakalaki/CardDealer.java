/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author jomi_
 */

public class CardDealer {
    
    private static final CardDealer instance = new CardDealer();    
    
    private final ArrayList <Treasure> unusedTreasures = new ArrayList();
    private final ArrayList <Treasure> usedTreasures = new ArrayList();
    private final ArrayList <Monster> unusedMonsters = new ArrayList();
    private final ArrayList <Monster> usedMonsters = new ArrayList();
    
    private CardDealer(){ }
    
    public static CardDealer getInstance(){
        return instance;
    }
    
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
        BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura "
            + "visible y otra oculta ", 0,
            new ArrayList (Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList (Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize (4, 2);
        unusedMonsters.add(new Monster("3 Byakhee de bonanza", 8, badConsequence, prize));

        // Tenochtitlan
         badConsequence = new BadConsequence("Embobados con el "
            + "lindo primigenio te descartas de tu casco visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.HELMET)),
            new ArrayList (Arrays.asList()));
        prize = new Prize (1, 1);
        unusedMonsters.add(new Monster("Tenochtitlan", 2, badConsequence, prize));

        // El sopor de Dunwich
        badConsequence = new BadConsequence("El primordial bostezo "
            + "contagioso. Pierdes el calzado visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.SHOES)),
            new ArrayList (Arrays.asList()));
        prize = new Prize (1, 1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));

        // Demonios de Magaluf
        badConsequence = new BadConsequence ("Te atrapan para "
            + "llevarte de fiesta y te dejan caer en mitad del vuelo. "
            + "Descarta 1 mano visible y 1 mano oculta", 0,
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize (4, 1);
        unusedMonsters.add (new Monster("Demonios de Magaluf", 2, badConsequence, prize));

        // El gorrón en el umbral
        badConsequence = new BadConsequence ("Pierdes todos tus "
            + "objetos visibles", 0, BadConsequence.MAXTREASURES, 0);
        prize = new Prize (3, 1);
        unusedMonsters.add (new Monster("El gorrón en el umbral", 13, badConsequence, prize));

        // H.P. Munchcraft
        badConsequence = new BadConsequence ("Pierdes la armadura "
            + "visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList (Arrays.asList()));
        prize = new Prize (2, 1);
        unusedMonsters.add (new Monster("H.P. Munchcraft", 6, badConsequence, prize));

        // Necrófago
        badConsequence = new BadConsequence ("Sientes bichos bajo "
            + "la ropa. Descarta la armadura visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList (Arrays.asList()));
        prize = new Prize (1, 1);
        unusedMonsters.add(new Monster("Necrófago", 13, badConsequence, prize));

        // El rey de rosado
        badConsequence = new BadConsequence ("Pierdes 5 niveles "
            + "y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize (3, 2);
        unusedMonsters.add(new Monster("El rey de rosado", 11, badConsequence, prize));

        // Flecher
        badConsequence = new BadConsequence ("Toses los pulmones "
            + " y pierdes dos niveles", 2, 0, 0);
        prize = new Prize (1, 1);
        unusedMonsters.add(new Monster("Flecher", 2, badConsequence, prize));

        // Los hondos
        badConsequence = new BadConsequence ("Estos monstruos "
            + "resultan bastante superficiales y te aburren mortalmente. "
            + "Estas muerto", true);
        prize = new Prize (2, 1);
        unusedMonsters.add(new Monster ("Los hondos", 8, badConsequence, prize));

        // Semillas Cthulthu
        badConsequence = new BadConsequence ("Pierdes 2 niveles "
            + "y 2 tesoros ocultos", 2, 0, 2);
        prize = new Prize (2, 1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));

        // Dameargo
        badConsequence = new BadConsequence ("Te intentas "
            + "escaquear. Pierdes una mano visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.ONEHAND)),
            new ArrayList (Arrays.asList()));
        prize = new Prize (2, 1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));

        // Pollipólipo volante
        badConsequence = new BadConsequence ("Da mucho asquito. "
            + "Pierdes 3 niveles", 3, 0, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));

        // Yskhtihyssg-Goth
        badConsequence = new BadConsequence ("No le hace gracia "
            + "que pronuncie mal su nombre. Estas muerto", true);
        prize = new Prize (3, 1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 14, badConsequence, prize));

        // Familia feliz
        badConsequence = new BadConsequence ("La familia te "
            + "atrapa. Estas muerto", true);
        prize = new Prize (3, 1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));

        // Roboggoth
        badConsequence = new BadConsequence ("La quinta "
            + "directiva primaria te obliga a perder 2 niveles y un tesoro "
            + "2 manos visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.BOTHHANDS)),
            new ArrayList (Arrays.asList()));
        prize = new Prize (2, 1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        // El espía sordo
        badConsequence = new BadConsequence ("Te asusta en la "
            + "noche. Pierdes un casco visible", 0,
            new ArrayList (Arrays.asList(TreasureKind.HELMET)),
            new ArrayList (Arrays.asList()));
        prize = new Prize (1, 1);
        unusedMonsters.add(new Monster("El espía sordo", 5, badConsequence, prize));

        // Tongue
        badConsequence = new BadConsequence ("Menudo susto te "
            + "llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize (2, 1);
        unusedMonsters.add(new Monster("Tongue", 19, badConsequence, prize));

        // Bicéfalo
        badConsequence = new BadConsequence ("Te faltan manos "
            + "para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles"
            + "de las manos", 3,
            new ArrayList (Arrays.asList(TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)),
            new ArrayList (Arrays.asList()));
        prize = new Prize (2, 1);
        unusedMonsters.add(new Monster("Bicéfalo", 21, badConsequence, prize));      
    }
    
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }
    
    public Treasure nextTreasure(){
        
        if(this.unusedTreasures.isEmpty()){
            
            for(Treasure t: this.usedTreasures){
                this.unusedTreasures.add(t);
            }
            
            this.shuffleTreasures();
            this.usedTreasures.clear();
        }
        
        Treasure t = this.unusedTreasures.get(0);
        this.usedTreasures.add(t);
        
        this.unusedTreasures.remove(t);
        
        return t;
    }
    
    public Monster nextMonster(){
        
        if(this.unusedMonsters.isEmpty()){
            
            for (Monster m: this.usedMonsters){
                this.unusedMonsters.add(m);
            }
            
            this.shuffleMonsters();
            this.usedMonsters.clear();
        }
        
        Monster m = this.unusedMonsters.get(0);
        this.usedMonsters.add(m);
        
        this.unusedMonsters.remove(m);
        
        return m;
    }
    
    public void giveTreasureBack(Treasure treasure){
        this.usedTreasures.add(treasure);
    }
    
    public void giveMonsterBack(Monster monster){
        this.usedMonsters.add(monster);
    }
    
    public void initCards(){  
        this.initTreasureCardDeck();
        this.initMonsterCardDeck();
    }
}
