#encoding: utf-8
# MADE BY: JOSE MIGUEL HDEZ GARCIA & JAIRO ABRIL MOYA


module NapakalakiRuby
    
require_relative 'bad_consequence'
require_relative 'prize'
require_relative 'treasure_kind'

class Monster
    attr_accessor :name
    attr_accessor :combatLevel
    attr_accessor :bc
    attr_accessor :prize

    # Metodo initialize que inicia los atributos
    def initialize(name = "", combatLevel = 0, bc = BadConsequence.new(), prize = Prize.new())
        @name = name
        @combatLevel = combatLevel
        @bc = bc
        @prize = prize
    end
    
    def get_levels_gained
        @prize.level
    end
     
    def get_treasures_gained
        @prize.treasures
    end
    
    # Metodo to_string que pinta en pantalla lo deseado
    def to_s
        "\nNombre: #{@name}
        Nivel: #{@combatLevel.to_s}
        Mal rollo: #{@bc.to_s}
        #{@prize.to_s}"
    end
end
end
