package Vista;

import Controlador.ControladorMusica;
import Modelo.Artista;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int opcion = 1;

        //ControladorMusica.crearDatabase();
        ControladorMusica.conectar();
        ControladorMusica.eliminarTablas();
        ControladorMusica.crearTablas();

        System.out.println("========================================================================");
        System.out.println("=                     SISTEMA DE GESTIÓN DE MÚSICA                     =");
        System.out.println("========================================================================");
        System.out.println();
        System.out.println();


        while (opcion != 0) {
            mostrarMenuMusica();
            System.out.println("Opción? ");
            opcion = leerOpcion(7); // hay 6 acciones principales sobre el sistema + terminar la aplicación
            switch(opcion) {
                case 1:    //añadir un nuevo artista
                    ControladorMusica.addNuevoArtista();
                    break;
                case 2:    //añadir nuevo disco
                    ControladorMusica.mostrarArtistas();
                    int idArtista;
                    boolean continuar = true;

                    while (continuar) {

                        try {
                            System.out.println("De qué artista quieres añadir el disco?? Introduce su id");
                            idArtista = in.nextInt();
                            in.nextLine();

                            ControladorMusica.addNuevoDisco(idArtista);

                        } catch (InputMismatchException e) {
                            System.out.println("Introduce un ID en formato numérico correctamente!!");
                            in.nextLine();

                            continuar = true;
                        }
                    }
                    pause();
                    break;
                case 3:     //mostrar los aristas registrados
                    ControladorMusica.mostrarArtistas();
                    pause();
                    break;
                case 4:    //consultar los datos X artista, X será el nombre
                    String nombre = pedirNombreArtista();
                    ControladorMusica.getDatosArtista(nombre);
                    pause();
                    break;
                case 5: 	//modificar un artista
                    while (opcion!=0) {
                        ControladorMusica.mostrarArtistas();
                        System.out.println("0 - Finalizar modificación del artista");
                        System.out.println("Elige el id del artista a modificar, tecla:x (/= 0):");
                        System.out.println("Opción? ");
                        opcion = leerOpcion(6);
                        if (opcion!=0) {
                            Artista.getArtistaID(opcion);
                            System.out.println();

                            System.out.println("Introduce el nuevo nombre del artista (string)");
                            String nombreNuevo = in.nextLine();

                            System.out.println("Introduce el nuevo apellido del artista (string)");
                            String apellidoNuevo = in.nextLine();

                            System.out.println("Introduce la nueva localidad del artista (string)");
                            String localidadNueva = in.nextLine();

                            System.out.println();

                            ControladorMusica.actualizarArtista(opcion, nombreNuevo, apellidoNuevo, localidadNueva);
                            System.out.println("Artista modificado!" + "\nID:" + opcion  + "\nNombre:" + nombreNuevo + "\nApellido:" + apellidoNuevo + "\nLocalidad:" + localidadNueva);

                            System.out.println();
                            pause();
                        }
                    } opcion=1;
                    break;
                case 6:    //eliminar el artista junto a todos sus discos
                    while (opcion!=0) {
                        ControladorMusica.mostrarArtistas();
                        System.out.println("0 - Finalizar eliminación del artista");
                        System.out.println("Elige el id del artista a eliminar, tecla:x (/= 0):");
                        System.out.println("Opción? ");
                        opcion = leerOpcion(6);
                        if (opcion!=0) {
                            ControladorMusica.eliminarArtista(opcion);
                            ControladorMusica.mostrarArtistas();

                            pause();
                        }
                    } opcion=1;
                    break;
                case 0:	System.out.println("Salir de la aplicación");
                    System.exit(0);
            }
        }
    }

    public static void mostrarMenuMusica() {
        System.out.println("==========================================================================");
        System.out.println("=           MENÚ PRINCIPAL - GESTIÓN DE LOS ARTISTAS Y DISCOS            =");
        System.out.println("==========================================================================");
        System.out.println("Tecla:1 - Insertar nuevo artista.");
        System.out.println("Tecla:2 - Insertar nuevo disco.");
        System.out.println("Tecla:3 - Mostrar los artistas registrados.");
        System.out.println("Tecla:4 - Consultar los datos del artista seleccionado junto a sus discos.");
        System.out.println("Tecla:5 - Modificar datos del artista.");
        System.out.println("Tecla:6 - Eliminar un artista junto con todos sus discos.");
        System.out.println("Tecla:0 - Salir.");
        System.out.println("==========================================================================");
    }

    private static void pause() {
        System.out.println("Pulsa 0 para continuar...");
        leerOpcion(1);
    }

    private static int leerOpcion(int max) {
        boolean terminar = false;
        int n = 0;
        while (!terminar) {
            try {
                n = in.nextInt();
                in.nextLine();
                if (n>=max || n<0) {
                    throw new Exception();
                }
                terminar = true;
            } catch (Exception e) {
                System.out.println("Opción incorrecta! Elije de nuevo");
                in.nextLine();
            }
        }
        return n;
    }

    public static String pedirNombreArtista(){
        System.out.println("Introduce el nombre del artista (string)");
        return in.nextLine();
    }

    public static String pedirApellido() {
        System.out.println("Introduce el apellido del artista (string)");
        return in.nextLine();
    }

    public static String pedirLocalidad() {
        System.out.println("Introduce la localidad del artista (string)");
        return in.nextLine();
    }


    public static String pedirNombreDisco(){
        System.out.println("Introduce el nombre del disco (string)");
        return in.nextLine();
    }

    public static String pedirFechaPubli() {
        String str;
        System.out.println("Introduce la fecha de publicación del disco (string)");
        str = in.nextLine();

        if (!str.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("Introduce una fecha válida!!");
            System.out.println("Introduce la fecha de publicación del disco (en este formato: mm/dd/aaaa)");

            return in.nextLine();
        }

        return str;
    }
}
