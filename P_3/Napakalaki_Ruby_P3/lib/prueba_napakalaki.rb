#encoding: utf-8
# MADE BY: JOSE MIGUEL HDEZ GARCIA & JAIRO ABRIL MOYA

require_relative "prize.rb"
require_relative "monster.rb"
require_relative "bad_consequence.rb"
require_relative "treasure_kind.rb"

class PruebaNapakalaki

    # Creamos el array que contendrá todos los montruos
    @@monsters = Array.new()

    # 3 Byakhees de bonanza
    prize = Prize.new(2,1)
    badconsequence = BadConsequence.newLevelSpecificTreasures('Pierdes tu armadura
                     visible y otra oculta', 0, [TreasureKind::ARMOR],
                     [TreasureKind::ARMOR])
    monster = Monster.new('3 Byakhees de bonanza', 8, badconsequence, prize)
    @@monsters.push(monster)

    # Tenochtitlan
    prize = Prize.new(1,1)
    badconsequence = BadConsequence.newLevelSpecificTreasures('Embobados con el
                     lindo primigenio te descartas de tu cascovisible', 0,
                     [TreasureKind::HELMET], [])
    monster = Monster.new('Tenochtitlan', 2, badconsequence, prize)
    @@monsters.push(monster)

    # El sopor de Dunwich
    prize = Prize.new(1,1)
    badconsequence = BadConsequence.newLevelSpecificTreasures('El primordial
                     bostezo contagioso. Pierdes el calzado visible', 0,
                     [TreasureKind::HELMET], [])
    monster = Monster.new('El sopor de Dunwich', 2, badconsequence, prize)
    @@monsters.push(monster)

    # Demonios de Magaluf
    prize = Prize.new(4,1)
    badconsequence = BadConsequence.newLevelSpecificTreasures('Te atrapan para
                     llevarte de fiesta y te dejan caer en mitad del vuelo.
                     Descarta 1 mano visible y 1 mano oculta', 0,
                     [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
    monster = Monster.new('Demonios de Magaluf', 2, badconsequence, prize)
    @@monsters.push(monster)

    # El gorron en el umbral
    prize = Prize.new(3,1)
    badconsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes todos
                     tus tesoros visibles', 0, 5, 0)
    monster = Monster.new('El gorron en el umbral', 13, badconsequence, prize)
    @@monsters.push(monster)

    # H.P. Munchcraft
    prize = Prize.new(2,1)
    badconsequence = BadConsequence.newLevelSpecificTreasures('Pierdes la armadura
                     visible', 0, [TreasureKind::ARMOR], [])
    monster = Monster.new('H.P. Munchcraft', 6, badconsequence, prize)
    @@monsters.push(monster)

    # Necrófago
    prize = Prize.new(1,1)
    badconsequence = BadConsequence.newLevelSpecificTreasures('Sientes bichos
                     bajo la ropa. Descarta la armadura visible', 0,
                     [TreasureKind::ARMOR], [])
    monster = Monster.new('Necrofago', 13, badconsequence, prize)
    @@monsters.push(monster)

    # El rey de rosado
    prize = Prize.new(3,2)
    badconsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 5 niveles
                    y 3 tesoros visibles', 5, 3, 0)
    monster = Monster.new('El rey de rosado', 11, badconsequence, prize)
    @@monsters.push(monster)

    # Flecher
    prize = Prize.new(1,1)
    badconsequence = BadConsequence.newLevelNumberOfTreasures('Toses los pulmones
                     y pierdes 2 niveles', 2, 0, 0)
    monster = Monster.new('Flecher', 2, badconsequence, prize)
    @@monsters.push(monster)

    # Los hondos
    prize = Prize.new(2,1)
    badconsequence = BadConsequence.newDeath('Estos monstruos resultan
                      bastante superficiales y te aburren mortalmente.
                      Estas muerto')
    monster = Monster.new('Los hondos', 8, badconsequence, prize)
    @@monsters.push(monster)

    # Semillas Cthulhu
    prize = Prize.new(2,1)
    badconsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 2 niveles
                      y 2 tesoros ocultos', 2, 0, 2)
    monster = Monster.new('Semillas Cthulhu', 4, badconsequence, prize)
    @@monsters.push(monster)

    # Dameargo
    prize = Prize.new(2,1)
    badconsequence = BadConsequence.newLevelSpecificTreasures('Te intentas
                      escaquear. Pierdes una mano visible', 0,
                      [TreasureKind::ONEHAND], [])
    monster = Monster.new('Dameargo', 1, badconsequence, prize)
    @@monsters.push(monster)

    # Pollipolipo volante
    prize = Prize.new(2,1)
    badconsequence = BadConsequence.newLevelNumberOfTreasures('Da mucho asquito.
                      Pierdes 3 niveles', 3, 0, 0)
    monster = Monster.new('Pollipolipo volante', 3, badconsequence, prize)
    @@monsters.push(monster)

    # Yskhtihyssg-Goth
    prize = Prize.new(3,1)
    badconsequence = BadConsequence.newDeath('No le hace gracia que
                      pronuncien mal su nombre. Estas muerto')
    monster = Monster.new('Ysjhtihyssg-Goth', 14, badconsequence, prize)
    @@monsters.push(monster)

    # Familia feliz
    prize = Prize.new(3,1)
    badconsequence = BadConsequence.newDeath('La familia te atrapa. Estas muerto')
    monster = Monster.new('Familia feliz', 1, badconsequence, prize)
    @@monsters.push(monster)

    # Roboggoth
    prize = Prize.new(2,1)
    badconsequence = BadConsequence.newLevelSpecificTreasures('La quinta
                      directiva primaria te obliga a perder 2 niveles y un
                      tesoro 2 manos visible', 2, [], [TreasureKind::BOTHHANDS])
    monster = Monster.new('Roboggoth', 8, badconsequence, prize)
    @@monsters.push(monster)

    # El espia sordo
    prize = Prize.new(1,1)
    badconsequence = BadConsequence.newLevelSpecificTreasures('Te asusta en la
                      noche. Pierdes un casco visible', 0, [TreasureKind::HELMET],
                      [])
    monster = Monster.new('El espia sordo', 5, badconsequence, prize)
    @@monsters.push(monster)

    # Tongue
    prize = Prize.new(2,1)
    badconsequence = BadConsequence.newLevelNumberOfTreasures('Menudo susto te
                      llevas. Pierdes 2 niveles y 5 tesoros visibles', 2, 5, 0)
    monster = Monster.new('Tongue', 19, badconsequence, prize)
    @@monsters.push(monster)

    # Bicefalo
    prize = Prize.new(2,1)
    badconsequence = BadConsequence.newLevelSpecificTreasures('Te faltan manos
                      para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles
                      de las manos', 0, [TreasureKind::BOTHHANDS, TreasureKind::ONEHAND], [])
    monster = Monster.new('Bicefalo', 21, badconsequence, prize)
    @@monsters.push(monster)

    # Muestra por pantalla
    def Pinta_monstruos()
        for i in(0..@@monsters.length)
            puts @@monters[i].to_s
        end
    end

    # Monstruos con un nivel mayor a 10
    def CombatLevel10 (level = 10)
        @salida = Array.new
        for m in @@monsters

            if (m.combatLevel > level)
                @salida << m
            end
        end
        return (@salida)
    end

    # Monstruos con un mal rollo que solo implique perdida de nivel
    def OnlyLostLevels()
        @salida = Array.new
        for m in @@monsters

            if (m.bc.someLevels > 0)

                if (m.bc.someSpecificVisibleTreasures.empty? &&
                    m.bc.someSpecificHiddenTreasures.empty?)

                    if (m.bc.nVisibleTreasures == 0 &&
                        m.bc.nHiddenTreasures == 0)
                        @salida << m
                    end
                end
            end
        end
        return (@salida)
    end

  # Monstruos con una ganancia de nivel superior a 1 unicamente
    def GainLevels()
        @salida = Array.new
        for m in @@monsters

            if ( m.prize.level > 1 )
                @salida << m
            end
        end
        return (@salida)
    end

    # Monstruos que hacen perder un tesoro en especifico
    def LostTreasures (objeto)
        @salida = Array.new
        for m in @@monsters

            if (m.bc.someSpecificHiddenTreasures.include?(objeto) ||
                m.bc.someSpecificVisibleTreasures.include?(objeto) )
                @salida << m
            end
        end
        return (@salida)
    end

    # Definimos un objeto llamado prueba que pertenece a PruebaNapakalaki
    prueba = PruebaNapakalaki.new

    # Mostramos por pantalla las distintas consultas
    puts prueba.CombatLevel10()
    puts prueba.OnlyLostLevels()
    puts prueba.GainLevels()

    puts prueba.LostTreasures(TreasureKind::BOTHHANDS)
    puts prueba.LostTreasures(TreasureKind::ONEHAND)
    puts prueba.LostTreasures(TreasureKind::ARMOR)
    puts prueba.LostTreasures(TreasureKind::SHOES)
    puts prueba.LostTreasures(TreasureKind::HELMET)
end
