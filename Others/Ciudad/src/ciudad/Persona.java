/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciudad;

public class Persona {

    String nombre;
    public int edad;
    public String colorPelo;
            
    Persona (String nombre, int edad, String colorPelo)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.colorPelo = colorPelo;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public int getEdad()
    {
        return edad;
    }
    
    String getColorPelo()
    {
        return colorPelo;
    }
    
    public static void main (String[] args)
    {
        Persona p1 = new Persona("Paco", 30, "moreno");
        
        System.out.println(p1.getNombre());
        System.out.println(Integer.toString(p1.getEdad()));
        System.out.println(p1.getColorPelo());
        System.out.println(p1.nombre);
        System.out.println(p1.edad);
        System.out.println(p1.colorPelo);
        
        
    }
   
    
}
