package test;

import datos.Conexion;
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
    //prueba de delete
    Usuario usuario = new Usuario();
    usuario.setId_usuario(1);
    usuarioJDBC.delete(usuario);
}
}
