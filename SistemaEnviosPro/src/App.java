import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    static SistemaEnvio sistema = new SistemaEnvio();

    public static void main(String[] args) throws Exception {
          int opcion = 0;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    registrar();
                    break;
                case 2:
                    actualizar();
                    break;
                case 3:
                    calcular();
                    break;
                case 4:
                    estados();
                    break;
                case 5:
                    reporte();
                    break;
                case 6:
                    System.out.println("Saliendo del menu...");
                    break;
                default:
                    break;
            }

        } while (opcion != 6);
    }

    public static void mostrarMenu() {
        System.out.println("==== SISTEMA ENVIOS =====");
        System.out.println("1) REGISTRAR PAQUETE");
        System.out.println("2) ACTUALIZAR ESTADO");
        System.out.println("3) CALCULAR COSTO");
        System.out.println("4) PAQUETES POR ESTADO");
        System.out.println("5) REPORTE GENERAL");
        System.out.println("6) SALIR DEL SISTEMA");
        System.out.println("Ingrese el numero de la accion que desea ejecutar: ");
    }

    public static void registrar() {
        System.out.println("Ingrese el CODIGO del paquete: ");
        String codigo = scanner.nextLine();
        System.out.println("Ingrese el DESTINATARIO del paquete: ");
        String destinatario = scanner.nextLine();
        
        double peso = 0.0;
        boolean validado = false;
        do {
            System.out.println("Ingrese el PESO del paquete: ");
            String pesoS = scanner.nextLine();
            try {
                peso = Double.parseDouble(pesoS);
                validado = true;
            } catch (Exception e) {
                System.out.println("Peso invalido " + e.getMessage());
            }
        } while (!validado);
        

        sistema.registrarPaquete(new Paquete(codigo, destinatario, peso));
        System.out.println("Paquete registrado correctamente");
    }

    public static void actualizar(){
        System.out.println("Ingrese el CODIGO del paquete para actualizar estado: ");
        String codigo = scanner.nextLine();
        boolean valido = false;
        EstadoPaquete nuevo = null;
        //do-while para validar el estado dentro del enum
        do{
            System.out.println("Ingrese el nuevo ESTADO del paquete: (EN_TRANSITO, EN_REPARTO, ENTREGADO, DEVUELTO)");
            try {
                nuevo = EstadoPaquete.valueOf(scanner.nextLine().trim().toUpperCase());
                valido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Estado no valido. Ingrese estado nuevamente");
            }
        } while (!valido);
        //con el estado validado, llamo al metodo dentro del try-catch
        try {
            sistema.actualizarEstado(codigo, nuevo);
        } catch (PaqueteNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void calcular() throws PaqueteNoEncontradoException{
        System.out.println("Ingrese el CODIGO del paquete para calcular costos: ");
        String codigo = scanner.nextLine();
        System.out.println("Ingrese (1) si el envio es EXPRESO. Ingrese (0) si el envio es regular: ");
        boolean expreso = false;
        boolean validado = false;
        do {
            String opcion = scanner.nextLine();
            
            if (opcion.equals("1")) {
                expreso = true;
                validado = true;
            } else if (opcion.equals("0")) {
                expreso = false;
                validado = true;
            } else{
                System.out.println("Opcion invalida. Reintentar");
            }
        } while (!validado);
        double costoFinal = 0;
        try {
            costoFinal = sistema.calcularCosto(codigo, expreso);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Costo final Paquete " + codigo + " : $" + costoFinal);
    }

    public static void estados(){
        System.out.println(sistema.agruparPaquetesPorEstado());
    }

    public static void reporte(){
        System.out.println(sistema.generarReporte());
    }
}
