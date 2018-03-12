#encoding: utf-8
# MADE BY: JOSE MIGUEL HDEZ GARCIA & JAIRO ABRIL MOYA


module NapakalakiRuby
    
class BadConsequence

    # Consultores básicos
    @@MAXTREASURES = 10
    
    attr_reader :aText
    attr_reader :someLevels
    
    private_class_method :new

    # Metodo initalize que inicia los atributos
    def initialize(aText = "", someLevels = 0)
        @aText = aText
        @someLevels = someLevels
    end

    def self.getMaxTreasures
        return @@MAXTREASURES
    end

    def is_empty
        raise NotImplementedError.new
    end
    
    def substract_visible_treasure(treasure) 
        raise NotImplementedError.new
    end
     
    def substract_hidden_treasure(treasure)
        raise NotImplementedError.new
    end
    
    def adjust_to_fit_treasure_list(v,h)
        raise NotImplementedError.new
    end
    
    # Metodo to_string que pinta en pantalla lo deseado
    def to_s
        "#{@aText}"
    end
 
end
end
