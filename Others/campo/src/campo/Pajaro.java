

package campo;
import ciudad.Persona;

public class Pajaro {

   
    String especie;
    Persona amigo;
    
    Pajaro (String especie, Persona amigo)
    {
        this.especie = especie;
        this.amigo = amigo;
    }
    
    public String getEspecie()
    {
        return especie;
    }
    
    public Persona getAmigo()
    {
        return amigo;
    }
    
    public static void main(String[] args) 
    {
        Persona p1 = new Persona ("Maria", 30, "rubio");
        
        System.out.println(p1.getNombre());
        System.out.println(Integer.toString(p1.getEdad()));
        System.out.println(p1.getColorPelo());
        System.out.println(p1.nombre);
        System.out.println(p1.edad);
        System.out.println(p1.colorPelo);
        
        Pajaro j1 = new Pajaro("paloma", p1);
        
        System.out.println(j1.getAmigo().getNombre());
        System.out.println(j1.getAmigo().getEdad());
        System.out.println(j1.getAmigo().getColorPelo());
    }
    

}