# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiRuby
    
require_relative 'treasure_kind'
   
class Treasure
    
    #Consultores basicos
    attr_reader :name
    attr_reader :bonus
    attr_reader :type
    
    # Constructor
    def initialize(name = "", bonus = 0, type = Array.new)
        @name = name
        @bonus = bonus
        @type = type
    end
    
    # Metodos
    def to_s
        "Nombre: #{@name}
         Bonus: #{@bonus.to_s}
         Tipo: #{@type.to_s}"
    end
end

end
