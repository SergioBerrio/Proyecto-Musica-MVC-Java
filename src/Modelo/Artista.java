package Modelo;

import java.sql.*;

public class Artista {

    private int id;
    private String nombre;
    private String apellido;
    private String localidad;

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }


    /** OPERACIONES CON EL ARTISTA **/

    /** CREAR UN NUEVO ARTISTA **/
    public static void addNuevoArtista(String nombre, String apellido, String localidad) {

        String sql = "INSERT INTO Artista(nombre, apellido, localidad) VALUES(?,?,?)";

        try {
            Connection conn = ModeloOperaciones.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, localidad);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /** MOSTRAR LOS ARTISTAS REGISTRADOS **/
    public static void mostrarArtistas(){
        System.out.println("**** Lista completa de artistas registrados ****");

        String sqlSelectArtista ="SELECT * FROM Artista";

        try{
            Connection conn = ModeloOperaciones.conectar();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sqlSelectArtista);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String localidad = rs.getString("localidad");

                // print the results
                System.out.printf("ID:%d\n Nombre:%s\n Apellido:%s\n Localidad:%s\n", id, nombre, apellido, localidad);
                System.out.println("");

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /** MOSTRAR UN ARTISTA SELECCIONADO **/
    public static void getDatosArtista(String nombre){
        String sqlSelectArtista ="SELECT * FROM Artista WHERE nombre = '" + nombre + "'";
        int id = 0;

        try{
            Connection con = ModeloOperaciones.conectar();
            Statement st = con.createStatement();

            System.out.println("");
            System.out.println("**** Tabla de artistas ****");
            ResultSet rs = st.executeQuery(sqlSelectArtista);

            while (rs.next()) {
                id = rs.getInt("id");
                String nombreArtista = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String localidad = rs.getString("localidad");

                // print the results
                System.out.printf("ID:%d\n Nombre:%s\n Apellido:%s\n Localidad:%s\n", id, nombreArtista, apellido, localidad);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sqlSelectDiscosArtista ="SELECT * FROM Disco WHERE id_artista = " + id;

        try{
            Connection conn = ModeloOperaciones.conectar();
            Statement st = conn.createStatement();

            System.out.println("");
            System.out.println("**** Discos pertenecientes al artista " + nombre + " ****");
            ResultSet rs = st.executeQuery(sqlSelectDiscosArtista);

            while (rs.next()) {
                id = rs.getInt("id");
                String nombreDisco = rs.getString("nombre");
                String fecha_publi = rs.getString("fecha_publi");
                int id_artista = rs.getInt("id_artista");

                // print the results
                System.out.printf("ID:%d\n Nombre:%s\n Fecha de publicación:%s\n ID del artista:%s\n", id, nombreDisco, fecha_publi, id_artista);

            }

            System.out.println("");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /** ACTUALIZAR UN ARTISTA SELECCIONADO **/
    public static void actualizarArtista(int id, String nombre, String apellido, String localidad){
        String sqlActualizarDatosArtista ="UPDATE Artista SET nombre = '" + nombre + "', apellido = '" + apellido + "', localidad = '" + localidad +"' WHERE id = " + id;

        try{
            Connection conn = ModeloOperaciones.conectar();

            PreparedStatement ps = conn.prepareStatement(sqlActualizarDatosArtista);

            ps.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /** MOSTRAR UN ARTISTA SELECCIONADO **/
    public static void getArtistaID(int id) {
        String sqlSelectArtista = "SELECT * FROM Artista WHERE id = " + id;

        try {
            Connection con = ModeloOperaciones.conectar();
            Statement st = con.createStatement();

            System.out.println("");
            System.out.println("**** Tabla del artista con ID:" + id + " ****");
            ResultSet rs = st.executeQuery(sqlSelectArtista);

            while (rs.next()) {
                id = rs.getInt("id");
                String nombreArtista = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String localidad = rs.getString("localidad");

                // print the results
                System.out.printf("ID:%d\n Nombre:%s\n Apellido:%s\n Localidad:%s\n", id, nombreArtista, apellido, localidad);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /** ELIMINAR UN ARTISTA SELECCIONADO Y SUS DISCOS **/
    public static void eliminarArtista(int id){
        String sqlArtista ="DELETE FROM Artista WHERE id = " + id;

        try{
            Connection conn = ModeloOperaciones.conectar();

            PreparedStatement ps = conn.prepareStatement(sqlArtista);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
