/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import Model.Rutina;
import Model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jhona
 */
public class DatosConexion {
    
    
    Conexion cn;
    
    public DatosConexion(){
        cn = new Conexion();
    }
    
    
    
    public boolean verificarUsuario(String nombre, String celular) {
        boolean usuarioEncontrado = false;
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT id FROM usuario WHERE nombre = ? AND celular = ?");
            pstm.setString(1, nombre);
            pstm.setString(2, celular);
            ResultSet rs = pstm.executeQuery();
            usuarioEncontrado = rs.next(); // Si hay al menos una fila en el resultado, el usuario existe
        } catch (SQLException e) {
            System.out.println(e);
        }
        return usuarioEncontrado;
    }

   
    
public ResultSet getRutinaById(int id) throws SQLException {
    PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT id, "
        + "nombre, " // Agrega coma después de cada nombre de columna
        + "dia_semana, "    // Agrega coma después de cada nombre de columna
        + "tipo_dia, "  // Agrega coma después de cada nombre de columna
        + "ejercicio1, "  // Agrega coma después de cada nombre de columna
        + "ejercicio2, "   // No agregues coma al final de la lista
        + "ejercicio3"
        + "FROM rutina "
        + "WHERE id = ?");
    pstm.setInt(1, id);
    ResultSet res = pstm.executeQuery();
    return res;
}

public ResultSet getRutinas() throws SQLException {
    PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT id, "
            + "nombre, "  // Agrega coma después de cada nombre de columna
            + "dia_semana, "     // Agrega coma después de cada nombre de columna
            + "tipo_dia, "   // Agrega coma después de cada nombre de columna
            + "ejercicio1, "   // Agrega coma después de cada nombre de columna
            + "ejercicio2, "    // No agregues coma al final de la lista
            + "ejercicio3 "
            + "FROM rutina "
            + "ORDER BY id");

    ResultSet res = pstm.executeQuery();
    return res;
}

    
    
    public ResultSet getUsuarioById(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT id, "
                + " nombre, "
                + " correo, "
                + " celular, "
                + " edad,"
                + " peso, "
                + " objetivo, "
                + " lesion "
                + " FROM usuario "
                + " WHERE id = ? ");
        pstm.setInt(1, id);
        System.out.println("entro");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public ResultSet getUsuarios() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT id, "
                + " nombre, "
                + " correo, "
                + " celular, "
                + " edad,"
                + " peso, "
                + " objetivo, "
                + " lesion "
                + " FROM usuario "
                + " ORDER BY nombre");

        ResultSet res = pstm.executeQuery();
        return res;
    }
    
    public void insertarUsuario(Usuario c) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into usuario (nombre, "
                    + " correo,"
                    + " celular,"
                    + " edad,"
                    + " peso,"
                    + " objetivo,"
                    + " lesion) "
                    + " values(?,?,?,?,?,?,?)");
            pstm.setString(1, c.getNombre());
            pstm.setString(2, c.getCorreo());
            pstm.setInt(3, c.getCelular());
            pstm.setInt(4, c.getEdad());
            pstm.setInt(5, c.getPeso());
            pstm.setString(6, c.getObjetivo());
            pstm.setString(7, c.getLesiones());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    
        public void actualizarUsuario(Usuario c) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("update usuario set nombre = ?, "
                    + " correo = ?,"
                    + " celular = ?,"
                    + " edad = ?,"
                    + " peso = ?,"
                    + " objetivo = ?,"
                    + " lesion = ?"
                    + " where id = ?");
            pstm.setString(1, c.getNombre());
            pstm.setString(2, c.getCorreo());
            pstm.setInt(3, c.getCelular());
            pstm.setInt(4, c.getEdad());
            pstm.setInt(5, c.getPeso());
            pstm.setString(6, c.getObjetivo());
            pstm.setString(7, c.getLesiones());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    


    public void borrarUsuario(Usuario c) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("delete from usuario "
                    + " where id = ?");
            pstm.setInt(1, c.getCelular());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
       public String getMensaje() {
        return cn.getMensaje();
    }

}
    

