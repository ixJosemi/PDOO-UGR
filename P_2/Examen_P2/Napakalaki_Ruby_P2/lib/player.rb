#encoding: utf-8
# MADE BY: JOSE MIGUEL HDEZ GARCIA & JAIRO ABRIL MOYA

require_relative 'treasure'
require_relative 'monster'
require_relative 'treasure_kind'
require_relative 'combat_result'
require_relative 'dice'
require_relative 'napakalaki'

class Player

    # Consultores basicos
    attr_reader :name
    attr_reader :level
    attr_reader :dead
    attr_reader :canISteal
    attr_reader :pending_badconsequence
    attr_reader :visible_treasures
    attr_reader :hidden_treasures
    attr_writer :enemy

    def initialize(name)
        @name = name
        @level = 1
        @dead = true
        @canISteal = true
        @visible_treasures = Array.new
        @hidden_treasures = Array.new
    end

    def is_dead
        return @dead
    end

    def get_combat_level
        @lvl = level
        return @lvl
    end

    def bring_to_life
        @dead = false
    end

    def increment_levels(l)
        @level += l
    end

    def decrement_levels(l)
        @level -= l

        if (@level < 1)
            @level = 1
        end
    end

    def set_pending_badconsequence(bc)
        @pending_badconsequence = bc
    end

    def apply_prize(current_monster)

    end

    def apply_badconsequence(bc)

    end

    def can_make_treasure_visible(t)

    end

    def how_many_visible_treasures(t_kind)

        i = 0
        @visible_treasures.each do |t|

            if t.type == t_kind then
                i = i + 1
            end
        end
        return i
    end

    def die_if_no_treasures
        if @visible_treasures.empty? && @hidden_treasures.empty?
            @dead = true
        end
    end

    def valid_state
       return @pending_badConsequence != nil && @hidden_treasures.length <= 5
    end

    def can_i_steal
        @canISteal = true
    end

    def give_me_a_treasure
        random = rand(@hidden_treasures.length)
        return @hidden_treasures.remove(random)
    end

    def canYouGiveMeATreasure?
        return ( !(@visibleTreasures.empty?) && !(@hiddenTreasures.empty?))
    end


end
