import java.util.ArrayList;
import java.util.Scanner;

public class App {
    
    private static SistemaHotel hotel = new SistemaHotel();
    private static Integer opcion = 0;
    static Scanner scanner = new Scanner (System.in);

    public static void main(String[] args) throws Exception {

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            validarOpcion(opcion);

            switch (opcion) {
                case 1:
                    agregarReserva();
                    break;
                case 2:
                    confirmarReserva();
                    break;
                case 3:
                    hacerCheckIn();
                    break;
                case 4:
                    hacerCheckOut();
                    break;
                case 5:
                    cancelarReserva();
                    break;
                case 6:
                    obtenerReservasPorEstado();
                    System.out.println();
                    break;
                case 7:
                    reporteOcupacional();
                    break;
                case 8:
                    System.out.println("Saliendo del SISTEMA HOTEL...");
                    break;
                default:
                    break;
            }
        } while (opcion != 8);
      
    }
    
    public static void mostrarMenu(){
        System.out.println("=== MENU SISTEMA HOTEL ===");
        System.out.println("[1] Agregar Reserva");
        System.out.println("[2] Confirmar Reserva");
        System.out.println("[3] CHECK IN Reserva");
        System.out.println("[4] CHECK OUT Reserva");
        System.out.println("[5] Cancelar Reserva");
        System.out.println("[6] Reservas por Estado");
        System.out.println("[7] Reporte Ocupacional ");
        System.out.println("[8] Salir del Menu");
    }

    public static void agregarReserva(){
        System.out.println("Ingrese el CODIGO DE RESERVA: ");
        String codigo = scanner.nextLine().toUpperCase();
        System.out.println("Ingrese NOMBRE Y APELLIDO de la reserva: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el NUMERO DE HABITACION de la resrva: ");
        Integer habitacion = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la CANTIDAD DE NOCHES de la reserva: ");
        Integer cantNoches = scanner.nextInt();
        scanner.nextLine();
        Reserva agregar = new Reserva(codigo, nombre, habitacion, cantNoches);
        try {
            hotel.agregarReserva(agregar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void confirmarReserva(){
        System.out.println("Ingrese el CODIGO DE RESERVA  a confirmar: ");
        String codigoConf = scanner.nextLine().toUpperCase();
        try {
            hotel.confirmarReserva(codigoConf);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void hacerCheckIn(){
        System.out.println("Ingrese el CODIGO DE RESERVA para hacer CHECK IN:");
        String codigoIn = scanner.nextLine().toUpperCase();
        try {
            hotel.hacerCheckIn(codigoIn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void hacerCheckOut(){
        System.out.println("Ingrese el CODIGO DE RESERVA para hacer CHECK OUT:");
        String codigoOut = scanner.nextLine().toUpperCase();
        try {
            hotel.hacerCheckOut(codigoOut);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cancelarReserva(){
        System.out.println("ingrese el CODIGO DE RESERVA  a cancelar: ");
        String codigoCancelar = scanner.nextLine().toUpperCase();
        try {
            hotel.cancelarReserva(codigoCancelar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void reporteOcupacional(){
        String reporte =hotel.generarReporteOcupacional();
        System.out.println(reporte);

    }

    public static void obtenerReservasPorEstado(){
        System.out.println("Ingrese el ESTADO para ver listado: ");
        EstadoReserva estado = EstadoReserva.valueOf(scanner.nextLine().toUpperCase().replace(" ", "_"));
        ArrayList<Reserva> mostrar = hotel.obtenerReservasPorEstado(estado);
        for(Reserva lista : mostrar){
            System.out.println(lista);
        }
    }

    public static void validarOpcion(Integer opcion){
        if (opcion > 8 || opcion < 1) {
            System.out.println("Ingrese un numero entero del 1 al 7");
        }
    }
    
} 
