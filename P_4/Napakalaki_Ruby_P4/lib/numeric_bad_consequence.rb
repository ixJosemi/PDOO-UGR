#encoding: utf-8

require_relative 'bad_consequence'

module NapakalakiRuby

class NumericBadConsequence < BadConsequence

    attr_reader :nVisibleTreasures
    attr_reader :nHiddenTreasures

    public_class_method :new

    def initialize (text, levels, nVisible, nHidden)

        super(text, levels)
        @nVisibleTreasures = nVisible
        @nHiddenTreasures = nHidden
    end

    def is_empty
        return @nVisibleTreasures == 0 && @nHiddenTreasures == 0
    end

    def substract_visible_treasure (t)
        @nVisibleTreasures = @nVisibleTreasures - 1
    end

    def substract_hidden_treasure (t)
        @nHiddenTreasures = @nHiddenTreasures - 1
    end

    def adjust_to_fit_treasure_list(v,h)
        
        if (v.length != @nVisibleTreasures)
            nVisible = v.length
        else
            nVisible = @nVisibleTreasures
        end

        if (h.length != @nHiddenTreasures)
            nHidden = h.length
        else
            nHidden = @nHiddenTreasures
        end

        bc = NumericBadConsequence.new(@text, @levels, nVisible, nHidden)

        puts "Mal rollo pendiente: \n nV perdidos: #{nVisible} \n nH perdidos: #{nHidden}"

        return bc
    end
end
end
