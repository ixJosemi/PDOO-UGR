# Opción 3 de las pruebas de la clase Muerto Viviente
# PDOO 
# JOSE MIGUEL HERNANDEZ GARCIA

class Muerto_Viviente_1
  def initialize (d)
        @dedos_de_frente = d
    @edad = 30
  end
  def asustar
    'uuuuuuuuu'
  end
  def presentar
    puts "hola"
  end
  protected
  def comer
    puts 'rico rico'
  end
  def miEdad
    return @edad-5
  end
  private :miEdad, :asustar
  public
  def otraPrueba
    self.presentar
    self.comer
    asustar
  end
  m = MuertoViviente.new (2.8)
  m.otraPrueba
end
