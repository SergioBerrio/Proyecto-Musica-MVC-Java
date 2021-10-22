package Modelo;

import java.io.IOException;
import java.sql.*;

public class Disco {

    private int id;
    private String nombre;
    private String fecha_publi;
    private int id_artista;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaPubli() {
        return fecha_publi;
    }

    public void setFechaPubli(String fecha_publi) {
        this.fecha_publi = fecha_publi;
    }

    public int getIdArtista() {
        return id_artista;
    }

    public void setIdArtista(int id_artista) {
        this.id_artista = id_artista;
    }


    /** OPERACIONES CON EL DISCO **/
    public static void addNuevoDisco(String nombre, String fecha_publi, int id_artista) throws IOException {

        String sql = "INSERT INTO Artista(nombre, fecha_publi, id_artista) VALUES(?,?,?,?)";

        try {
            Connection conn = ModeloOperaciones.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, fecha_publi);
            ps.setInt(3, id_artista);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /** MOSTRAR UN DISCO SELECCIONADO **/
    public static void getDisco(int id){

        String sqlSelectArtista ="SELECT * FROM Disco";

        try{
            Connection conn = ModeloOperaciones.conectar();
            Statement st = conn.createStatement();

            System.out.println("");
            System.out.println("**** Tabla de discos ****");
            ResultSet rs = st.executeQuery(sqlSelectArtista);

            while (rs.next()) {
                id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String fecha_publi = rs.getString("fecha_publi");
                int id_artista = rs.getInt("id_artista");

                // print the results
                System.out.printf("ID:%d, Nombre:%s, Fecha de publicación:%s, ID del artista:%d\n", id, nombre, fecha_publi, id_artista);

            }

            System.out.println("");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
