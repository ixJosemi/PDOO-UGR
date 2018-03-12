class MuertoViviente
  attr_reader :dedos_de_frente
  def initialize(unFloat)
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
end

m = MuertoViviente.new(2,8)
m.prueba
gets()
