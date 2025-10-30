
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static Scanner scanner = new Scanner(System.in);
    static int opcion = 0; // es static permite usarlo en toda la clase
    static SistemaHotel hotel = new SistemaHotel(); // creo un objeto sistema hotel que contiene los hashmap de reservas
                                                    // y ocupadas

    public static void main(String[] args) throws Exception {

        System.out.println("=== SISTEMA DE RESERVAS HOTEL ===");

        do {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion < 1 || opcion > 9) {
                    System.out.println("Error: Ingrese un numero entero entre 1 y 9");
                }
            } catch (Exception e) {
                System.out.println("Error: Ingrese un numero entero entre 1 y 9");
            }

            switch (opcion) {
                case 1:
                    agregarReserva();
                    break;
                case 2:
                    confirmarReserva();
                    break;
                case 3:
                    checkIn();
                    break;
                case 4:
                    checkOut();
                    break;
                case 5:
                    cancelarReserva();
                    break;
                case 6:
                    buscarPorCodigo();
                    break;
                case 7:
                    listadoPorEstado();
                    break;
                case 8:
                    reporteOcupacional();
                    break;
                default:
                    break;
            }
        } while (opcion != 9);

    }

    public static void mostrarMenu() {
        System.out.println("=== MENU===");
        System.out.println("(1) Agregar reserva");
        System.out.println("(2) Confirmar reserva");
        System.out.println("(3) Hacer CHECK-IN");
        System.out.println("(4) Hacer CHECK-OUT");
        System.out.println("(5) Cancelar reserva");
        System.out.println("(6) Buscar reserva");
        System.out.println("(7) Reservas por Estado");
        System.out.println("(8) Reporte Ocupacional");
        System.out.println("(9) Salir ");
        System.out.println("Ingrese el numero de la accion que desea realizar: ");
    }

    // funciona bien
    public static void agregarReserva() throws Exception {
        System.out.println("Ingrese el codigo de la reserva:");
        String codigo = scanner.nextLine();

        System.out.println("Ingrese el nombre y apellido del huesped: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el numero de habitacion de la reserva: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la cantidad de noches de la reserva: ");
        int noches = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Agregando reserva " + codigo + "...");
        Reserva nueva = new Reserva(codigo, nombre, numero, noches);
        try {
            hotel.agregarReserva(nueva);
            System.out.println("✓ Reserva " + codigo + " agregada. (Habitacion " + numero + " ocupada)");
        } catch (Exception e) {
            System.out.println("Error al agregar la reserva");
        }
    }

    // funciona bien
    public static void confirmarReserva() throws Exception {
        System.out.println("Ingrese el codigo de la reserva a confirmar: ");
        String aConfirmar = scanner.nextLine();
        try {
            System.out.println("Confirmando reserva " + aConfirmar + "...");
            hotel.confirmarReserva(aConfirmar);
            System.out.println("✓ Reserva " + aConfirmar + " confirmada. ");
        } catch (Exception r) {
            System.out.println("Error al confirmar la reserva");
        }

    }

    // funciona bien
    public static void checkIn() throws ReservaNoEncontradaException {
        System.out.println("Ingrese el codigo de reserva para realizar CHECK-IN:");
        String codigoR = scanner.nextLine();
        try {
            System.out.println("Haciendo CHEK-IN de " + codigoR + "...");
            hotel.hacerCheckIn(codigoR);
        } catch (Exception e) {
            System.out.println("Error al realizar el CHECK-IN");
        }
    }

    // funciona
    public static void checkOut() throws ReservaNoEncontradaException {
        System.out.println("Ingrese el codigo de reserva para realizar CHECK-OUT");
        String codigoRe = scanner.nextLine();
        try {
            System.out.println("Haciendo CHECK-OUT de " + codigoRe);
            hotel.hacerCheckOut(codigoRe); // el msj de confirmacion esta en el metodo hacerCheckOut()
        } catch (Exception e) {
            System.out.println("Error al realizar el CHECK-OUT");
        }

    }

    // funciona
    public static void cancelarReserva() throws ReservaNoEncontradaException {
        System.out.println("Ingrese el codigo de la reserva que desea cancelar: ");
        String codigo = scanner.nextLine();
        try {
            System.out.println("Cancelando reserva " + codigo + "...");
            hotel.cancelarReserva(codigo);
        } catch (Exception e) {
            System.out.println("Error al cancelar la reserva");
        }
    }

    // funciona
    public static void buscarPorCodigo() throws ReservaNoEncontradaException {
        System.out.println("Ingrese el codigo de reserva a buscar: ");
        String codeR = scanner.nextLine().toUpperCase();
        Reserva buscada;
        System.out.println("--- Resultado de la busqueda ---");
        try {
            buscada = hotel.buscarReservaPorCodigo(codeR);
            System.out.println(buscada);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // funciona bien
    public static void listadoPorEstado() {
        System.out.println("Ingrese el estado del cual desea obtener el listado: ");
        String estadoS = scanner.nextLine().toUpperCase();
        EstadoReserva estado = null;
        try {
            estado = EstadoReserva.valueOf(estadoS);
            if (estado == null) {
                return;
            }
        } catch (Exception e) {
            System.out.println("Error: El estado no es valido.");
        }
        System.out.println("--- Lista de reservas en estado " + estado + " --- ");

        ArrayList<Reserva> lista = hotel.obtenerReservasPorEstado(estado);
        for (Reserva r : lista) {
            if (r.getEstado() == estado) {
                System.out.println("\"Codigo: [" + r.getCodigoReserva() + "] | Huesped: [" + r.getNombreHuesped()
                        + "] | Habitacion: [" + r.getCantidadNoches() + "] | Noches: [" + r.getCantidadNoches()
                        + "] | Estado: [" + estado + "]\"");
            }
        }
    }

    // funciona
    public static void reporteOcupacional() {
        System.out.println("---- Reporte Ocupacional ----");
        try {
            String reporte = hotel.generarReporteOcupacional(); // asigno a una variable para despues poder imprimirlo
            System.out.println(reporte);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
