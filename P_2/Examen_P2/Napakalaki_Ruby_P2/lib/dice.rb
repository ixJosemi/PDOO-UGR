#encoding: utf-8
# MADE BY: JOSE MIGUEL HDEZ GARCIA & JAIRO ABRIL MOYA

module Napakalaki
require "singleton"

class Dice
    
    # Hacemos uso del singleton
    include Singleton
    
    def next_number
        return 1 + rand(6)
    end
end
end
