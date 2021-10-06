package test;

import datos.PersonaJDBC;
import domain.Persona;
import java.util.*;

public class ManejoPersonas {
    public static void main(String[] args) {
        
            PersonaJDBC personaJDBC = new PersonaJDBC();
        List<Persona> personas = personaJDBC.select();
        for (Persona p : personas) {
            System.out.println("personas = " + p);
        }
            
        //insertando persona
//       Persona persona = new Persona();
//       persona.setNombre("Legototo");
//       persona.setEmail("jiujiu@gmail.com");
//       persona.setTelefono("8847844");
//       personaJDBC.insert(persona);

        //prueba de update 
//        Persona persona = new Persona();
//        persona.setId_persona(8);
//        persona.setNombre("Nicolas");
//        persona.setApellido("Toto");
//        persona.setTelefono("5555555");
//        personaJDBC.update(persona);
//    //prueba de delete
//        Persona persona = new Persona();
//        persona.setId_persona(8);
//        personaJDBC.delete(persona);
    }
}
