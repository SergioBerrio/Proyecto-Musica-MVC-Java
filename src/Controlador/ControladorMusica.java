package Controlador;

import Modelo.Artista;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControladorMusica {

    /** CREACIÓN DE LA DB **/
    public static void crearDatabase(){

        String sqlCrearDatabase = "CREATE DATABASE IF NOT EXISTS dbMusica";

        String url = "jdbc:sqlite:C:\\Users\\2DAM3\\IdeaProjects\\ProyectoMúsicaMVC\\dbMusica.sqlite";
        Connection con = null;

        try{
            try {
                con = DriverManager.getConnection(url);

                //System.out.println("La DB dbSuperOnline ha sido creada.");
            } catch (Exception e) {
                System.out.println(e);
            }

            PreparedStatement pstmt = con.prepareStatement(sqlCrearDatabase);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**  CONEXIÓN A LA DB **/
    public static Connection conectar(){

        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\2DAM3\\IdeaProjects\\ProyectoMúsicaMVC\\dbMusica.sqlite";
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(url);

            System.out.println("La conexión con la BD SQLite ha sido establecida.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conexion;
    }

    /** ELIMINACIÓN DE LAS TABLAS **/
    public static void eliminarTablas(){

        String sqlEliminarArtista = "DROP TABLE IF EXISTS Artista";
        String sqlEliminarDisco = "DROP TABLE IF EXISTS Disco";

        try{
            Connection conn = conectar();

            PreparedStatement pstmt = conn.prepareStatement(sqlEliminarArtista);
            PreparedStatement pstmt2 = conn.prepareStatement(sqlEliminarDisco);

            pstmt.executeUpdate();
            pstmt2.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /** CREACIÓN DE LAS TABLAS **/
    public static void crearTablas(){

        String sqlCrearArtista = "CREATE TABLE Artista (" +
                "id integer PRIMARY KEY," +
                "nombre text NOT NULL," +
                "apellido text NOT NULL," +
                "localidad text NOT NULL)";

        String sqlCrearDisco = "CREATE TABLE Disco (" +
                "id integer PRIMARY KEY," +
                "nombre text NOT NULL," +
                "fecha_publi text NOT NULL," +
                "id_artista integer NOT NULL)";

        try{
            Connection conn = conectar();

            PreparedStatement pstmt = conn.prepareStatement(sqlCrearArtista);
            PreparedStatement pstmt2 = conn.prepareStatement(sqlCrearDisco);

            pstmt.executeUpdate();
            pstmt2.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void addNuevoArtista(Artista artista, int opcion) throws IOException {

        String sql = "INSERT INTO Artista(id, nombre, apellido, localidad) VALUES(?,?,?,?)";

        try {
            Connection conn = conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(restos[0]));
            pstmt.setString(2, restos[1]);
            pstmt.setDouble(3, restos[2]);
            pstmt.setInt(4, restos[3]);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
