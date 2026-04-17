/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author isaia
 */
public class CinesDAO {
    private static final String SQL_SELECT = "SELECT idPeliculas, Nombre FROM Cines";
    private static final String SQL_INSERT = "INSERT INTO Cines (idPeliculas, Nombre, Clasificacion, Genero, Idioma, Subtitulado, precio) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM Cines WHERE idPeliculas = ? AND Nombre = ?";
    private static final String SQL_QUERY = "SELECT idPeliculas, Nombre FROM Cines WHERE idPeliculas = ? AND Nombre = ?";
    
    public List<CinesDAO> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<CinesDAO> asignaciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                // Aquí se llenarían los objetos del controlador
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return asignaciones;
    }
    public int insertar(int idPeliculas, String Nombre, String Clasificacion, String Genero, String Idioma, String Subtitulado, double precio) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, idPeliculas);
            stmt.setString(2, Nombre);
            stmt.setString(3, Clasificacion);
            stmt.setString(4, Genero);
            stmt.setString(5, Idioma);
            stmt.setString(6, Subtitulado);
            stmt.setDouble(7, precio);
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
     public int eliminar(int idPeliculas, String Nombre) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, idPeliculas);
            stmt.setString(2, Nombre);
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
     public boolean buscar(int idPeliculas, String Nombre) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, idPeliculas);
            stmt.setString(2, Nombre);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return false;
    }
}
