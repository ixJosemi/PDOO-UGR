# Opción 1 de las pruebas de la clase Muerto Viviente
# PDOO 
# JOSE MIGUEL HERNANDEZ GARCIA


class MuertoViviviente
  def initialize
    @dedos_de_frente = unFloat
    @edad = 30
  end
  def asustar
    'uuuuuuuuu'
  end
  def presentar
    "tengo" + self.dedos_de_frente.to_s +
    " dedos y " + miEdad.to_s + "lustros" + asustar
  end
  protected
  def comer
    'rico rico'
  end
  def miEdad
    return @edad-5
  end
  private :miEdad, :asustar
  public
  def self.prueba
    @otrozombie = MuertoViviente.new(1,0)
    @otrozombie.presentar
    @otrozombie.comer
    @otrozombie.asustar
  end

  MuertoViviente.prueba
end
