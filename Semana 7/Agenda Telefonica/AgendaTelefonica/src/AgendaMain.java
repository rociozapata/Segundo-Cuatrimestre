import java.util.Scanner;

public class AgendaMain {
    public static void main(String[] args) throws AgendaException  {

        Scanner scanner = new Scanner(System.in); 

        AgendaTel agenda = new AgendaTel();
        
        System.out.println("/// MENU AGENDA CONTACTOS ///");
        System.out.println("Opcion 1: Agregar contacto");
        System.out.println("Opcion 2: Buscar contacto");
        System.out.println("Opcion 3: Eliminar contacto");
        System.out.println("Opcion 4: Mostrar contacto");
        System.out.println("Opcion 5: Salir del menu");
        int opcion;

        do {
            System.out.println("Ingrese la opcion elegida: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) { // agregar los try catch en cada opcion 
                case 1:
                    // pedir datos al usuario y pasarlos como parametro
                    System.out.println("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el telefono del contacto: ");
                    String telef = scanner.nextLine();
                    agenda.agregarContacto(nombre, telef);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Ingrese el nombre buscado: ");
                    String buscar = scanner.nextLine();
                    agenda.buscarTelefonoPorNombre(buscar);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Ingrese el nombre a eliminar: ");
                    String eliminar = scanner.nextLine();
                    agenda.eliminarContacto(eliminar);
                    System.out.println();
                    break;
                case 4:
                    agenda.mostrarContactos();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Saliendo de Agenda Contactos... ");
                    break;
                default:
                    break;
            }
            
        } while (opcion != 5);

        scanner.close();
    }  
}
