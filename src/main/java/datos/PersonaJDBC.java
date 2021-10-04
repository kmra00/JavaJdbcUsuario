package datos;

import domain.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaJDBC {

    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre ,apellido, email, telefono)VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona  SET nombre=?, apellido =?, email =?,telefono =? WHERE id_persona=?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona=?";

    public List<Persona> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        // donde se guardara el recorrido del metodo , el objeto
        Persona persona = null;
        List<Persona> personas = new ArrayList<Persona>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_persona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("apellido");

                persona = new Persona();
                persona.setId_persona(id_persona);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setEmail(email);
                persona.setTelefono(telefono);

                personas.add(persona);

            }
        } catch (SQLException ex) {
            System.out.println(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return personas;
    }

    public int insert(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());

            System.out.println("Ejecutando el metodo insert SQL " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados :" + rows);
        } catch (SQLException ex) {
            System.out.println(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int update(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query :" + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getId_persona());

            stmt.executeUpdate();
            System.out.println("Registros actualizados " + rows);
        } catch (SQLException ex) {
            System.out.println(System.out);
        }
        return rows;
    }

    public int delete(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getId_persona());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados :" + rows);
        } catch (SQLException ex) {
            System.out.println(System.out);
        }
        return rows;
    }
}
