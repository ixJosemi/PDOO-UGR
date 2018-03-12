# Opción 4 de las pruebas de la clase Muerto Viviente
# PDOO
# JOSE MIGUEL HERNANDEZ GARCIA

class Almacen_Abandonado
  def initialize
    @muerto = MuertoViviente.new(1.0)
  end

  @muerto.presentar
  @muerto.comer
  @muerto.asustar
end
