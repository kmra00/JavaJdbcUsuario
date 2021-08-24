package datos;

import domain.Usuario;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioJDBC {
    
    private static final String SQL_SELECT = "SELECT id_usuario, usuario, password FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(usuario,password)VALUES (?,?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET usuario=?, password =? WHERE id_usuario=?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario=?";
    
    public List<Usuario> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        //objeto usuario para setear los valores de usuario
        Usuario usuario = null;
        //lista para guardar los usuarios localmente de la consultas que retornaran del metodo
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            //inicializar la conexion a la base de datos
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_usuario = rs.getInt("id_usuario");
                String usuarioo = rs.getString("usuario");
                String password = rs.getString("password");
                
                usuario = new Usuario();
                usuario.setId_usuario(id_usuario);
                usuario.setUsuario(usuarioo);
                usuario.setPassword(password);
                
                usuarios.add(usuario);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuarios;
        
    }
    
    public int insert(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            
            System.out.println("Ejecutando el metodo insert SQL " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados = " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
        
    }
    
    public int update(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query :" + SQL_UPDATE);
            
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getId_usuario());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados " + rows);
            
        } catch (SQLException ex) {
            System.out.println(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int delete(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query de : " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getId_usuario());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados = " + rows);
        } catch (SQLException ex) {
            System.out.println(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
