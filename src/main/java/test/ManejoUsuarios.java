package test;

import datos.Conexion;
import datos.PersonaJDBC;
import datos.UsuarioJDBC;
import domain.*;
import java.util.*;

public class ManejoUsuarios {

    public static void main(String[] args) {
        UsuarioJDBC usuarioJDBC = new UsuarioJDBC();
        List<Usuario> usuarios = usuarioJDBC.select();
        for (Usuario u : usuarios) {
            System.out.println("usuarios = " + u);
        }
        //insertando usuario
        //        Usuario usuario = new Usuario();
        //        usuario.setUsuario("juan");
        //        usuario.setPassword("heymando");
        //        usuarioJDBC.insert(usuario);

        //prueba de update 
        //    Usuario usuario = new Usuario();
        //    usuario.setId_usuario(1);
        //    usuario.setUsuario("Bolsero");
        //    usuario.setPassword("cagarA");
        //    usuarioJDBC.update(usuario);
//    //prueba de delete
//    Usuario usuario = new Usuario();
//    usuario.setId_usuario(1);
//    usuarioJDBC.delete(usuario);
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
