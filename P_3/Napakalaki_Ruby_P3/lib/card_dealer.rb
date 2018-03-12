#!/bin/env ruby
# encoding: utf-8


module NapakalakiRuby
    
require "singleton"

require_relative 'monster'
require_relative 'treasure'
require_relative 'treasure_kind'
require_relative 'bad_consequence'

class CardDealer
    
    include Singleton
    
    def initialize
        @used_monsters = Array.new
        @unused_monsters = Array.new
        @used_treasures = Array.new
        @unused_treasures = Array.new
    end
    
    def init_treasure_card_deck
        
        # Si mi amo
        treasure = Treasure.new("¡Si mi amo!", 4, TreasureKind::HELMET)
        @unused_treasures.push(treasure)
        
        # Botas de investigacion
        @unused_treasures << Treasure.new("Botas de investigación", 3,TreasureKind::SHOES)
        
        # Capucha de Cthulhu
        @unused_treasures << Treasure.new("Capucha de Cthulhu", 3,TreasureKind::HELMET)
        
        # A prueba de babas
        @unused_treasures << Treasure.new("A prueba de babas", 2, TreasureKind::ARMOR)
        
        # Botas de lluvia acida
        @unused_treasures << Treasure.new("Botas de lluvia acida", 1, TreasureKind::BOTHHANDS)
        
        # Casco minero
        @unused_treasures << Treasure.new("Casco minero", 2, TreasureKind::HELMET)
        
        # Ametralladora ACME
        @unused_treasures << Treasure.new("Ametralladora ACME", 4, TreasureKind::BOTHHANDS)
        
        # Camiseta de la ETSIIT
        @unused_treasures << Treasure.new("Camiseta de la ETSIIT", 1, TreasureKind::ARMOR)
        
        # Clavo de rail ferroviario
        @unused_treasures << Treasure.new("Clavo de rail ferroviario", 3, TreasureKind::ONEHAND)
        
        # Cuchillo de sushi arcano
        @unused_treasures << Treasure.new("Cuchillo de sushi arcano", 2, TreasureKind::ONEHAND)
        
        # Fez alopodo
        @unused_treasures << Treasure.new("Fez alopodo", 3, TreasureKind::HELMET)
       
        # Hacha prehistorica
        @unused_treasures << Treasure.new("Hacha prehistórica", 2, TreasureKind::ONEHAND)
        
        # El aparato del Pr. Tesla
        @unused_treasures << Treasure.new("El aparato del Pr. Tesla", 4, TreasureKind::ARMOR)
        
        # Gaita
        @unused_treasures << Treasure.new("Gaita", 4, TreasureKind::BOTHHANDS)
        
        # Insecticida
        @unused_treasures << Treasure.new("Insecticida", 2, TreasureKind::ONEHAND)
        
        # Escopeta de 3 cañones
        @unused_treasures << Treasure.new("Escopeta de 3 cañones", 4, TreasureKind::BOTHHANDS)
        
        # Garabato Mistico
        @unused_treasures << Treasure.new("Garabato Mistico", 2, TreasureKind::ONEHAND)
        
        # La rebeca metalica
        @unused_treasures << Treasure.new("La rebeca metálica", 2, TreasureKind::ARMOR)
        
        # Mazo de los antiguos
        @unused_treasures << Treasure.new("Mazo de los antiguos", 3, TreasureKind::ONEHAND)
        
        # Necroplayboycon
        @unused_treasures << Treasure.new("Necroplayboycon", 3, TreasureKind::ONEHAND)
        
        # Lanzallamas
        @unused_treasures << Treasure.new("Lanzallamas", 4, TreasureKind::BOTHHANDS)
        
        # Necrocomicon
        @unused_treasures << Treasure.new("Necrocomicón", 1, TreasureKind::ONEHAND)
        
        # Necronomicon
        @unused_treasures << Treasure.new("Necronomicón", 5, TreasureKind::BOTHHANDS)
        
        # Lintera a 2 manos
        @unused_treasures << Treasure.new("Linterna a 2 manos", 3, TreasureKind::BOTHHANDS)
        
        # Necrognomicon
        @unused_treasures << Treasure.new("Necrognomicón", 2, TreasureKind::ONEHAND)
        
        # Necrotelecom
        @unused_treasures << Treasure.new("Necrotelecom", 2, TreasureKind::HELMET)
        
        # Porra preternatural
        @unused_treasures << Treasure.new("Porra preternatural", 2, TreasureKind::ONEHAND)
        
        # Tentaculo de pega
        @unused_treasures << Treasure.new("Tentáculo de pega", 2, TreasureKind::HELMET)
        
        # Zapato deja-amigos
        @unused_treasures << Treasure.new("Zapato deja-amigos", 1, TreasureKind::SHOES)
        
        # Shogulador
        @unused_treasures << Treasure.new("Shogulador", 1, TreasureKind::BOTHHANDS)
        
        # Varita de atizamiento
        @unused_treasures << Treasure.new("Varita de atizamiento", 3, TreasureKind::ONEHAND)
    end
    
    def init_monsters_card_deck
        
        # 3 Byakhees de bonanza
        prize = Prize.new(2,1)
        badconsequence = BadConsequence.newLevelSpecificTreasures('Pierdes tu armadura
                     visible y otra oculta', 0, [TreasureKind::ARMOR],
                     [TreasureKind::ARMOR])
        monster = Monster.new('3 Byakhees de bonanza', 8, badconsequence, prize)
        @unused_monsters.push(monster)

        # Tenochtitlan
        prize = Prize.new(1,1)
        badconsequence = BadConsequence.newLevelSpecificTreasures('Embobados con el
                     lindo primigenio te descartas de tu cascovisible', 0,
                     [TreasureKind::HELMET], [])
        monster = Monster.new('Tenochtitlan', 2, badconsequence, prize)
        @unused_monsters.push(monster)

        # El sopor de Dunwich
        prize = Prize.new(1,1)
        badconsequence = BadConsequence.newLevelSpecificTreasures('El primordial
                     bostezo contagioso. Pierdes el calzado visible', 0,
                     [TreasureKind::HELMET], [])
        monster = Monster.new('El sopor de Dunwich', 2, badconsequence, prize)
        @unused_monsters.push(monster)

        # Demonios de Magaluf
        prize = Prize.new(4,1)
        badconsequence = BadConsequence.newLevelSpecificTreasures('Te atrapan para
                     llevarte de fiesta y te dejan caer en mitad del vuelo.
                     Descarta 1 mano visible y 1 mano oculta', 0,
                     [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
        monster = Monster.new('Demonios de Magaluf', 2, badconsequence, prize)
        @unused_monsters.push(monster)

        # El gorron en el umbral
        prize = Prize.new(3,1)
        badconsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes todos
                     tus tesoros visibles', 0, 5, 0)
        monster = Monster.new('El gorron en el umbral', 13, badconsequence, prize)
        @unused_monsters.push(monster)

        # H.P. Munchcraft
        prize = Prize.new(2,1)
        badconsequence = BadConsequence.newLevelSpecificTreasures('Pierdes la armadura
                     visible', 0, [TreasureKind::ARMOR], [])
        monster = Monster.new('H.P. Munchcraft', 6, badconsequence, prize)
        @unused_monsters.push(monster)

        # Necrófago
        prize = Prize.new(1,1)
        badconsequence = BadConsequence.newLevelSpecificTreasures('Sientes bichos
                     bajo la ropa. Descarta la armadura visible', 0,
                     [TreasureKind::ARMOR], [])
        monster = Monster.new('Necrofago', 13, badconsequence, prize)
        @unused_monsters.push(monster)

        # El rey de rosado
        prize = Prize.new(3,2)
        badconsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 5 niveles
                    y 3 tesoros visibles', 5, 3, 0)
        monster = Monster.new('El rey de rosado', 11, badconsequence, prize)
        @unused_monsters.push(monster)

        # Flecher
        prize = Prize.new(1,1)
        badconsequence = BadConsequence.newLevelNumberOfTreasures('Toses los pulmones
                     y pierdes 2 niveles', 2, 0, 0)
        monster = Monster.new('Flecher', 2, badconsequence, prize)
        @unused_monsters.push(monster)

        # Los hondos
        prize = Prize.new(2,1)
        badconsequence = BadConsequence.newDeath('Estos monstruos resultan
                      bastante superficiales y te aburren mortalmente.
                      Estas muerto')
        monster = Monster.new('Los hondos', 8, badconsequence, prize)
        @unused_monsters.push(monster)

        # Semillas Cthulhu
        prize = Prize.new(2,1)
        badconsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 2 niveles
                      y 2 tesoros ocultos', 2, 0, 2)
        monster = Monster.new('Semillas Cthulhu', 4, badconsequence, prize)
        @unused_monsters.push(monster)

        # Dameargo
        prize = Prize.new(2,1)
        badconsequence = BadConsequence.newLevelSpecificTreasures('Te intentas
                      escaquear. Pierdes una mano visible', 0,
                      [TreasureKind::ONEHAND], [])
        monster = Monster.new('Dameargo', 1, badconsequence, prize)
        @unused_monsters.push(monster)

        # Pollipolipo volante
        prize = Prize.new(2,1)
        badconsequence = BadConsequence.newLevelNumberOfTreasures('Da mucho asquito.
                      Pierdes 3 niveles', 3, 0, 0)
        monster = Monster.new('Pollipolipo volante', 3, badconsequence, prize)
        @unused_monsters.push(monster)

        # Yskhtihyssg-Goth
        prize = Prize.new(3,1)
        badconsequence = BadConsequence.newDeath('No le hace gracia que
                      pronuncien mal su nombre. Estas muerto')
        monster = Monster.new('Ysjhtihyssg-Goth', 14, badconsequence, prize)
        @unused_monsters.push(monster)

        # Familia feliz
        prize = Prize.new(3,1)
        badconsequence = BadConsequence.newDeath('La familia te atrapa. Estas muerto')
        monster = Monster.new('Familia feliz', 1, badconsequence, prize)
        @unused_monsters.push(monster)

        # Roboggoth
        prize = Prize.new(2,1)
        badconsequence = BadConsequence.newLevelSpecificTreasures('La quinta
                      directiva primaria te obliga a perder 2 niveles y un
                      tesoro 2 manos visible', 2, [], [TreasureKind::BOTHHANDS])
        monster = Monster.new('Roboggoth', 8, badconsequence, prize)
        @unused_monsters.push(monster)

        # El espia sordo
        prize = Prize.new(1,1)
        badconsequence = BadConsequence.newLevelSpecificTreasures('Te asusta en la
                      noche. Pierdes un casco visible', 0, [TreasureKind::HELMET],
                      [])
        monster = Monster.new('El espia sordo', 5, badconsequence, prize)
        @unused_monsters.push(monster)

        # Tongue
        prize = Prize.new(2,1)
        badconsequence = BadConsequence.newLevelNumberOfTreasures('Menudo susto te
                      llevas. Pierdes 2 niveles y 5 tesoros visibles', 2, 5, 0)
        monster = Monster.new('Tongue', 19, badconsequence, prize)
        @unused_monsters.push(monster)

        # Bicefalo
        prize = Prize.new(2,1)
        badconsequence = BadConsequence.newLevelSpecificTreasures('Te faltan manos
                      para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles
                      de las manos', 0, [TreasureKind::BOTHHANDS, TreasureKind::ONEHAND], [])
        monster = Monster.new('Bicefalo', 21, badconsequence, prize)
        @unused_monsters.push(monster)
    end
    
    def shuffle_treasures
        @unused_treasures = @unused_treasures.shuffle
    end
    
    def shuffle_monsters
        @unused_monsters = @unused_monsters.shuffle
    end
    
    def next_treasure
        
        if (@unused_treasures.empty?)
            
            @used_treasures.each do |t|      
                @unused_treasures << t
            end
            
            self.shuffle_treasures         
            @used_treasures.clear    
        end
         
        t = @unused_treasures.at(0)         
        @used_treasures << t        
        @unused_treasures.delete(t);
       
        return t 
    end
    
    def next_monster
       
        if (@unused_monsters.empty?) 
         
            @used_monsters.each do |m| 
                @unused_monsters << m
            end
           
            self.shuffle_monsters        
            @used_treasures.clear     
        end
  
        m = @unused_monsters.at(0)    
        @used_monsters << m    
        @unused_monsters.delete(m);    
      
        return m
    end
    
    def give_treasure_back(treasure)
        @used_treasures << treasure
    end
    
    def give_monster_back(monster)
        @used_monsters << monster
    end
    
    def init_cards
        init_treasure_card_deck
        init_monsters_card_deck  
    end
    
end

end
