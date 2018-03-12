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
    def initialize(aText = "", someLevels = 0, nVisibleTreasures = 0,
                nHiddenTreasures = 0,  someSpecificVisibleTreasures = Array.new,
                someSpecificHiddenTreasures = Array.new, death = false)
        @aText = aText
        @someLevels = someLevels
        @nVisibleTreasures = nVisibleTreasures
        @nHiddenTreasures = nHiddenTreasures
        @someSpecificVisibleTreasures = someSpecificVisibleTreasures
        @someSpecificHiddenTreasures = someSpecificHiddenTreasures
        @death = death
    end

    # Constructor #1
    def self.newLevelNumberOfTreasures(aText, someLevels,
                      nVisibleTreasures, nHiddenTreasures)
        new(aText, someLevels, nVisibleTreasures, nHiddenTreasures)
    end

  # Constructor #2
    def self.newLevelSpecificTreasures(aText, someLevels,
                      someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    new(aText, someLevels, 0, 0, someSpecificVisibleTreasures, someSpecificHiddenTreasures,
        false)
    end

    # Constructor #3
    def self.newDeath (aText)
        new(aText, 0, 0, 0, Array.new, Array.new, true)
    end

    def is_empty
        empty = false
        
        if (@levels == 0 && @death == false && @nHiddenTreasures == 0 &&
           @nVisibleTreasures == 0 && @someSpecificVisibleTreasures.empty? &&
           @someSpecificHiddenTreasures.empty?)
                empty = true
        end
        return empty
    end
    
    def substract_visible_treasure(treasure) 
        @specificVisibleTreasures.delete(treasure.type);
    end
     
    def substract_hidden_treasure(treasure)
        @specificHiddenTreasures.delete(treasure.type);      
    end
    
    def adjust_to_fit_treasure_list(v, h)
       
        t_visible = Array.new
        t_hidden = Array.new
         
        v.each do |t|
     
            if (t_visible.index(t.type) == nil)
                t_visible << t.type
            end
        end
         
        h.each do |t|

            if (t_hidden.index(t.type) == nil)
                t_hidden << t.type
            end
        end
        bc = BadConsequence.newLevelSpecificTreasures(@text, 0, t_visible, t_hidden)
        
        return bc  
    end
    
    # Metodo to_string que pinta en pantalla lo deseado
    def to_s
        "#{@aText}
        Niveles perdidos: #{@someLevels.to_s}
        Objetos visibles perdidos: #{@nVisibleTreasures.to_s}
        Objetos ocultos perdidos: #{@nHiddenTreasures.to_s}
        Objetos especificos visibles: #{@someSpecificVisibleTreasures}
        Objetos especificos ocultos: #{@someSpecificHiddenTreasures}
        Muerto? #{@death.to_s} \n"
    end
 
end
end
