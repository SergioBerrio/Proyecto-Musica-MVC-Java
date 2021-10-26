package Controlador;

import Modelo.Artista;
import Modelo.Disco;
import Modelo.ModeloOperaciones;
import Vista.MainApp;

public class ControladorMusica {

    /** OPERACIONES CON LA BASE DE DATOS **/
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

    /** OPERACIONES CON ARTISTAS **/
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

    /** OBTENER EL ARTISTA EN BASE A SU NOMBRE **/
    public static void getDatosArtista(String nombre){
        Artista.getDatosArtista(nombre);
    }

    /** ACTUALIZAR LOS DATOS DEL ARTISTA **/
    public static void actualizarArtista(int id, String nombre, String apellido, String localidad){
        Artista.actualizarArtista(id, nombre, apellido, localidad);
    }

    /** ELIMINAR EL ARTISTA Y SUS DISCOS EN BASE A SU ID **/
    public static void eliminarArtista(int id){
        Artista.eliminarArtista(id);
    }


    /** OPERACIONES CON DISCOS **/
    /** AÑADIR UN NUEVO DISCO **/
    public static void addNuevoDisco(int idArtista) {
        String nombre = MainApp.pedirNombreDisco();
        String fecha_publi = MainApp.pedirFechaPubli();
        int id_artista = idArtista;

        Disco.addNuevoDisco(nombre, fecha_publi, id_artista);
    }
}
