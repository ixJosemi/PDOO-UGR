# Opción 2 de las pruebas de la clase Muerto Viviente
# PDOO 
# JOSE MIGUEL HERNANDEZ GARCIA

class MuertoViviente
  attr_reader :dedos_de_frente
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
  def prueba
    otroZombie = MuertoViviente.new(2,
      2)
    otroZombie.presentar
    otroZombie.comer
    otroZombie.asustar
  end
  m = MuertoViviente.new(2,8)
  m.prueba
end

