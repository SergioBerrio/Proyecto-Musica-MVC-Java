package Controlador;

import Modelo.Artista;
import Modelo.Disco;
import Modelo.ModeloOperaciones;
import Vista.MainApp;

import java.io.IOException;

public class ControladorMusica {

    /** CREACIÓN DE LA DB **/
    public static void crearDatabase(){

        ModeloOperaciones.crearDatabase();
    }

    /**  CONEXIÓN A LA DB **/
    public static void conectar(){

        ModeloOperaciones.conectar();
    }

    /** ELIMINACIÓN DE LAS TABLAS **/
    public static void eliminarTablas(){

        ModeloOperaciones.eliminarTablas();
    }

    /** CREACIÓN DE LAS TABLAS **/
    public static void crearTablas(){

        ModeloOperaciones.crearTablas();
    }

    /** AÑADIR UN NUEVO ARTISTA **/
    public static void addNuevoArtista() {
        String nombre = MainApp.pedirNombreArtista();
        String apellido = MainApp.pedirApellido();
        String localidad = MainApp.pedirLocalidad();
        Artista.addNuevoArtista(nombre, apellido, localidad);
    }

    /** MOSTRAR TODOS LOS ARTISTAS REGISTRADOS **/
    public static void mostrarArtistas(){
        Artista.mostrarArtistas();
    }

    /** OBTENER EL ARTISTA EN BASE A SU ID **/
    public static Artista getArtista(int opcion){
        Artista.getArtista(opcion);

        return null;
    }

    /** ACTUALIZAR EL ARTISTA EN BASE A SU ID **/
    public static void actualizarArtista(int id, String nombre, String apellido, String localidad){
        Artista.actualizarArtista(id, nombre, apellido, localidad);
    }

    /** ELIMINAR EL ARTISTA EN BASE A SU ID **/
    public static void eliminarArtista(int id){
        Artista.eliminarArtista(id);
    }


    /** AÑADIR UN NUEVO DISCO **/
    public static void addNuevoDisco() throws IOException {
        String nombre = MainApp.pedirNombreDisco();
        String fecha_publi = MainApp.pedirApellido();
        int id_artista = MainApp.pedirIdArtista();
        Disco.addNuevoDisco(nombre, fecha_publi, id_artista);
    }
}
