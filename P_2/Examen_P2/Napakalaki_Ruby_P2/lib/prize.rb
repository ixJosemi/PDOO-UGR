#encoding: utf-8
# MADE BY: JOSE MIGUEL HDEZ GARCIA & JAIRO ABRIL MOYA

class Prize
    attr_accessor :treasures
    attr_accessor :level
 
    # Metodo initialize que inicia los atributos
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
end