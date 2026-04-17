package Modelo;

import Controlador.Cines;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CinesDAO {

    private static final String SQL_SELECT = 
        "SELECT idPeliculas, Nombre, Clasificacion, Genero, Idioma, Subtitulado, precio FROM peliculas";

    private static final String SQL_INSERT = 
        "INSERT INTO peliculas(idPeliculas, Nombre, Clasificacion, Genero, Idioma, Subtitulado, precio) VALUES(?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = 
        "UPDATE peliculas SET Nombre=?, Clasificacion=?, Genero=?, Idioma=?, Subtitulado=?, precio=? WHERE idPeliculas=?";

    private static final String SQL_DELETE = 
        "DELETE FROM peliculas WHERE idPeliculas=?";

    private static final String SQL_QUERY = 
        "SELECT idPeliculas, Nombre, Clasificacion, Genero, Idioma, Subtitulado, precio FROM peliculas WHERE idPeliculas=?";


    public List<Cines> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cines cine = null;
        List<Cines> listaCines = new ArrayList<Cines>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idPeliculas       = rs.getInt("idPeliculas");
                String nombre         = rs.getString("Nombre");
                String clasificacion  = rs.getString("Clasificacion");
                String genero         = rs.getString("Genero");
                String idioma         = rs.getString("Idioma");
                String subtitulado    = rs.getString("Subtitulado");
                double precio         = rs.getDouble("precio");

                cine = new Cines(idPeliculas, nombre, clasificacion, genero, idioma, subtitulado, precio);
                listaCines.add(cine);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return listaCines;
    }


    public int insert(Cines cine) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, cine.getIdPeliculas());       // idPeliculas va en posición 1 porque NO es autogenerado
            stmt.setString(2, cine.getNombre());
            stmt.setString(3, cine.getClasificacion());
            stmt.setString(4, cine.getGenero());
            stmt.setString(5, cine.getIdioma());
            stmt.setString(6, cine.getSubtitulado());
            stmt.setDouble(7, cine.getPrecio());

            System.out.println("Ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }


    public int update(Cines cine) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cine.getNombre());
            stmt.setString(2, cine.getClasificacion());
            stmt.setString(3, cine.getGenero());
            stmt.setString(4, cine.getIdioma());
            stmt.setString(5, cine.getSubtitulado());
            stmt.setDouble(6, cine.getPrecio());
            stmt.setInt(7, cine.getIdPeliculas());       // el ID va al final porque es el WHERE

            System.out.println("Ejecutando query: " + SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }


    public int delete(Cines cine) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cine.getIdPeliculas());

            System.out.println("Ejecutando query: " + SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }


    public Cines query(Cines cine) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, cine.getIdPeliculas());
            rs = stmt.executeQuery();

            System.out.println("Ejecutando query: " + SQL_QUERY);

            while (rs.next()) {
                int idPeliculas       = rs.getInt("idPeliculas");
                String nombre         = rs.getString("Nombre");
                String clasificacion  = rs.getString("Clasificacion");
                String genero         = rs.getString("Genero");
                String idioma         = rs.getString("Idioma");
                String subtitulado    = rs.getString("Subtitulado");
                double precio         = rs.getDouble("precio");

                cine = new Cines(idPeliculas, nombre, clasificacion, genero, idioma, subtitulado, precio);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return cine;
    }
}