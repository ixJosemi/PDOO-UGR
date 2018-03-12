
package ciudad;

public class Coche 
{   
    String matricula;
    String marca;
    Persona propietario;
    
   Coche(String matricula, String marca, Persona propietario)
   {
       this.matricula = matricula;
       this.marca = marca;
       this.propietario = propietario;
   }
   
   public String getMatricula()
   {
       return matricula;   
   }
   
   public String getMarca()
   {
       return marca;
   }
   
   public Persona getPropietario()
   {
       return propietario;
   }
   
   public static void main(String[] args)
   {
       Persona p1 = new Persona("Mariana",8,"rubia");
       
       System.out.println(p1.getNombre());
       System.out.println(Integer.toString(p1.getEdad()));
       System.out.println(p1.getColorPelo());
       System.out.println(p1.nombre);
       System.out.println(p1.edad);
       System.out.println(p1.colorPelo);
       
       Coche c1 = new Coche("387PDE","Seat", p1);
       
       System.out.println(getPropietario().getNombre());
       System.out.println(getPropietario().getEdad());
   }
}
