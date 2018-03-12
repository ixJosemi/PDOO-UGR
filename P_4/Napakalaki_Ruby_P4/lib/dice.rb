
module NapakalakiRuby
    
require "singleton"

class Dice
    
    include Singleton
    
    def next_number
        
        rnd = 0
        
        loop do
            
            rnd = rand(7)
            break if rnd != 0
        end
        
        return rnd
    end
end
end
