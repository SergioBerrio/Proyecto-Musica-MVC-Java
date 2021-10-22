package Vista;

import Controlador.ControladorMusica;
import Modelo.Artista;
import Modelo.Disco;

import java.io.IOException;
import java.util.Scanner;

public class MainApp {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int opcion = 1;

        ControladorMusica.crearDatabase();
        ControladorMusica.conectar();
        ControladorMusica.eliminarTablas();
        ControladorMusica.crearTablas();

        System.out.println("========================================================================");
        System.out.println("=                 SISTEMA DE GESTIÓN DE MÚSICA                 =");
        System.out.println("========================================================================");
        System.out.println();
        System.out.println();


        while (opcion != 0) {
            mostrarMenuMusica();
            System.out.println("Opción? ");
            opcion = leerOpcion(7); // hay 6 acciones principales sobre el inventario + terminar la aplicación
            switch(opcion) {
                case 1:    //añadir un nuevo artista
                    while (opcion!=0) {
                        mostrarMenuAddNuevoArtista();

                        /*System.out.println("Opción? ");
                        opcion = leerOpcion(6); // 5 clases de productos y salida del menú
                        if (opcion!=0) {
                            Artista A = nuevoArtista(opcion);
                            ControladorMusica.addNuevoArtista(A, opcion);
                            System.out.println("Artista añadido, número "+Artista.tamano()+"\n");
                            //Artista.getArtista(Artista.tamano()).imprimir(); //imprime el último producto incluido
                            System.out.println();
                            System.out.println();
                            pause();
                        }*/

                        pedirNombreArtista();
                        pedirApellido();
                        pedirLocalidad();


                    } opcion=1; break;
                case 2:    //añadir nuevo disco
                    while (opcion!=0) {
                        mostrarMenuAddNuevoArtista();

                        /*System.out.println("Opción? ");
                        opcion = leerOpcion(6); // 5 clases de productos y salida del menú
                        if (opcion!=0) {
                            Disco D = nuevoDisco(opcion);
                            ControladorMusica.addNuevoDisco(D, opcion);
                            System.out.println("Artista añadido, número "+ Disco.tamano()+"\n");
                            //Disco.getDisco(Disco.tamano()).imprimir(); //imprime el último producto incluido
                            System.out.println();
                            System.out.println();
                            pause();
                        }*/

                        pedirNombreDisco();
                        pedirFechaPubli();
                        pedirIdArtista();

                    } opcion=1; break;
                case 3:     //mostrar los aristas registrados
                    ControladorMusica.mostrarArtistas();
                    pause();
                    break;
                case 4:    //consultar los datos X artista, X será el nombre
                    //ControladorMusica.getArtista(Artista.getArtista(opcion));
                    pause();
                    break;
                case 5: 	//modificar un artista
                    while (opcion!=0) {
                        ControladorMusica.mostrarArtistas();
                        System.out.println("0 - Finalizar modificación del artista");
                        System.out.println("Elige el id del artista a modificar, tecla:x (/= 0):");
                        System.out.println("Opción? ");
                        //opcion = leerOpcion(Artista.tamano()+1);
                        if (opcion!=0) {
                            Artista A = ControladorMusica.getArtista(opcion);
                            System.out.println("Artista elegido: "+A.getNombre());
                            ControladorMusica.actualizarArtista(A.getId(), A.getNombre(), A.getApellido(), A.getLocalidad());
                            System.out.println("Artista modificado: "+A.getNombre());
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
                        //opcion = leerOpcion(Artista.tamano()+1);
                        if (opcion!=0) {
                            Artista A = ControladorMusica.getArtista(opcion);
                            System.out.println("Artista elegido: "+A.getNombre());
                            ControladorMusica.eliminarArtista(A.getId());
                            System.out.println("Artista modificado: "+A.getNombre());
                            System.out.println();
                            pause();
                        }
                    } opcion=1;
                    break;
                case 7:	System.out.println("Salir de la aplicación");
                    System.exit(0);
            }
        }
    }

    public static void mostrarMenuMusica() {// ver productos del super ordenados
        System.out.println("====================================================================");
        System.out.println("=            MENÚ PRINCIPAL - GESTIÓN DE LOS ARTISTAS Y DISCOS                =");
        System.out.println("====================================================================");
        System.out.println("            1. - Insertar nuevo artista");
        System.out.println("            2. - Insertar nuevo disco");
        System.out.println("            3. - Mostrar los artistas registrados");
        System.out.println("            4. - Consultar los datos del artista X y sus discos, donde X será el nombre del artista");
        System.out.println("            5. - Modificar datos de un artista");
        System.out.println("            6. - Eliminar un artista junto con todos sus discos");
        System.out.println("            7. - Salir");
        System.out.println("====================================================================");
    }


    public static void mostrarMenuAddNuevoArtista() {// ver productos y escoger uno
        System.out.println("====================================================");
        System.out.println("=   Elige el tipo de artista que quieres añadir:  =");
        System.out.println("====================================================");
        System.out.println("         1. - Lácteo");
        System.out.println("         2. - Frutas u hortalizas");
        System.out.println("         3. - Bebidas");
        System.out.println("         4. - Herramientas");
        System.out.println("         5. - Otros");
        System.out.println("         0. - Cancelar");
        System.out.println("====================================================");
    }

    public static Artista nuevoArtista (int n) {
        //Scanner es = new Scanner (System.in);
        Artista A;
        switch(n) {
            case 1: A = new Artista();
                break;
            default: A = new Artista();
                break;
        }
        return A;
    }

    public static Disco nuevoDisco (int n) {
        //Scanner es = new Scanner (System.in);
        Disco D;
        switch(n) {
            case 1: D = new Disco();
                break;
            default: D = new Disco();
                break;
        }
        return D;
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
        System.out.println("Introduce la fecha de publicación del disco (string)");
        return in.nextLine();
    }

    public static int pedirIdArtista() {
        System.out.println("Introduce la el ID del artista al que pertenece (integer)");
        return in.nextInt();
    }
}
