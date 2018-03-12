# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiRuby
    
require "singleton"

class Dice
    
    include Singleton
    
    def next_number
        
        n = 0
        
        loop do
            
            n = rand(7)
            break if n != 0
        end
        
        return n
    end
end
end
