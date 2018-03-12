#encoding: utf-8
# MADE BY: JOSE MIGUEL HDEZ GARCIA & JAIRO ABRIL MOYA

module NapakalakiRuby

class Prize
    
    attr_reader :treasures
    attr_reader :level
    
    # Constructor
    def initialize(treasures = 0, level = 0)
        # Atributos
        @treasures = treasures
        @level = level
    end

    # Metodo to_string para pintar en pantalla lo deseado
    def to_s
        "Tesoros ganados: #{@treasures.to_s}
        Niveles ganados: #{@level.to_s}"
    end
    
    def mayor_a_uno
        return @level > 1
    end
    
end

end
