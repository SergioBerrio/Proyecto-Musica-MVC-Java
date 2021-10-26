package Modelo;

import java.sql.*;

public class ModeloOperaciones {

    /** CREACIÓN DE LA DB **/
    public static void crearDatabase(){

        String sqlCrearDatabase = "CREATE DATABASE dbMusica";

        String url = "jdbc:sqlite:C:\\Users\\USER\\IdeaProjects\\ProyectoMusicaMVC\\dbMusica.sqlite";
        Connection con = null;

        try{
            con = DriverManager.getConnection(url);

            //System.out.println("La DB dbSuperOnline ha sido creada.");

            PreparedStatement ps = con.prepareStatement(sqlCrearDatabase);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("es error de aquiiiiiiiiii");
        }
    }

    /**  CONEXIÓN A LA DB **/
    public static Connection conectar(){

        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\USER\\IdeaProjects\\ProyectoMusicaMVC\\dbMusica.sqlite";
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(url);

            //System.out.println("La conexión con la BD SQLite ha sido establecida.");

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
            Connection con = conectar();

            PreparedStatement ps = con.prepareStatement(sqlEliminarArtista);
            PreparedStatement ps2 = con.prepareStatement(sqlEliminarDisco);

            ps.executeUpdate();
            ps2.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /** CREACIÓN DE LAS TABLAS **/
    public static void crearTablas(){

        String sqlCrearArtista = "CREATE TABLE IF NOT EXISTS Artista (" +
                "id integer PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "nombre text NOT NULL," +
                "apellido text NOT NULL," +
                "localidad text NOT NULL)";

        String sqlCrearDisco = "CREATE TABLE IF NOT EXISTS Disco (" +
                "id integer PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "nombre text NOT NULL," +
                "fecha_publi text NOT NULL," +
                "id_artista integer NOT NULL, " +
                "FOREIGN KEY(id_artista) REFERENCES Artista(id))";

        String sqlForeignKey = "ALTER TABLE Disco DROP FOREIGN KEY Disco_ibfk_1";

        String sqlAddForeignKey = "ALTER TABLE Disco ADD CONSTRAINT Disco_ibfk_1 FOREIGN KEY (id_artista) REFERENCES Artista(id) ON DELETE CASCADE";

        try{
            Connection con = conectar();

            PreparedStatement ps = con.prepareStatement(sqlCrearArtista);
            PreparedStatement ps2 = con.prepareStatement(sqlCrearDisco);
            //PreparedStatement ps3 = con.prepareStatement(sqlForeignKey);
            //PreparedStatement ps4 = con.prepareStatement(sqlAddForeignKey);

            ps.executeUpdate();
            ps2.executeUpdate();
            //ps3.executeUpdate();
            //ps4.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
