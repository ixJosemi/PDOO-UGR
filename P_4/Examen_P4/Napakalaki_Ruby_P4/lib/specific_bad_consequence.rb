
module NapakalakiRuby
    
require_relative 'treasure_kind'
require_relative 'bad_consequence'

class SpecificBadConsequence  < BadConsequence
    
    attr_reader :specificVisibleTreasures
    attr_reader :specificHiddenTreasures
    
    public_class_method :new
    
    # Constructor
    def initialize (text, levels, someSpecificVisibleTreasures,
            someSpecificHiddenTreasures)
                        
        super(text, levels)
        @specificVisibleTreasures = someSpecificVisibleTreasures
        @specificHiddenTreasures = someSpecificHiddenTreasures
    end
    
    def estan_vacias
        return @specificVisibleTreasures.empty? && @specificHiddenTreasures.empty?
    end
    
    def is_empty
        return estan_vacias
    end
    
    def substract_visible_treasure (t)
        @specificVisibleTreasures.delete(t)
    end
    
    def substract_hidden_treasure(t)
        @specificHiddenTreasures.delete(t)
    end
    
    def adjust_to_fit_treasure_list(v, h)
        
        vTreasures = Array.new
        hTreasures = Array.new
        
        v.each do |t|
            vTreasures << t.type
        end
        
        h.each do |t|
            hTreasures << t.type
        end
        
        vTreasures = vTreasures & @specificVisibleTreasures
        hTreasures = hTreasures & @specificHiddenTreasures
        
        bc = SpecificBadConsequence.new(@text, @levels, vTreasures, hTreasures)
        
        frase1 = ""
        frase2 = ""
  
        vTreasures.each do |s|

            frase1 = frase1 + s.to_s + " "
        end
            
        hTreasures.each do |s|
   
            frase2 = frase2 + s.to_s + " "
        end
                
        puts "Mal rollo pendiente: \n vSpecificTreasures perdidos: #{frase1} \n hSpecificTreasures perdidos: #{frase2}"
        
    end
end

end

    