#encoding: utf-8
# MADE BY: JOSE MIGUEL HDEZ GARCIA & JAIRO ABRIL MOYA


module NapakalakiRuby
    
require_relative 'bad_consequence'
require_relative 'prize'
require_relative 'treasure_kind'
require_relative 'numeric_bad_consequence'
require_relative 'specific_bad_consequence'
require_relative 'death_bad_consequence'

class Monster
    
    attr_reader :name
    attr_reader :combatLevel
    attr_reader :bc
    attr_reader :prize
    attr_reader :level_change_against_cultist_player
    
    private_class_method :new

    # Constructor
    def initialize(name = "", combatLevel = 0, bc = BadConsequence.new(), prize = Prize.new(), lc)
        @name = name
        @combatLevel = combatLevel
        @bc = bc
        @prize = prize
        @level_change_against_cultist_player = lc
    end
    
    def self.new_normal_monster(name = "", combatLevel = 0, bc = BadConsequence.new(), 
                                prize = Prize.new(), lc)
        new(name, combatLevel, bc, prize, lc)
    end
    
    def self.new_cultist_monster(name = " ", combatLevel = 0, bc = BadConsequence.new(),
                                prize = Prize.new(), lc)
        new(name, combatLevel, bc, prize, lc)
    end
    
    def get_combat_level_against_cultist_player
        return (@level_change_against_cultist_player + @combatLevel)
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
