import java.util.ArrayList;
import java.util.Scanner;

public class AppVideojuego {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Videojuego> videojuegos = new ArrayList<>();
        System.out.println("Ingrese los 4 videojuegos");
        // Carga datos el usuario
        for (int i = 0; i < 4; i++) {
            System.out.print("Ingrese el nombre del videojuego numero " + (i + 1) + ": ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el genero del videojuego numero " + (i + 1) + ": ");
            String genero = scanner.nextLine();

            videojuegos.add(new Videojuego(nombre, genero));
            System.out.println("Juego agregado!");
        }
        // Listado de videojuegos
        System.out.println("Vamos a listar los videojuegos");
        for (Videojuego juego : videojuegos) { // clase varible: arraylist
            System.out.println(juego);
        }
        // listado con indice
        System.out.println("Listado de juegos con indice");
        for (int i = 0; i < videojuegos.size(); i++) {
            System.out.println("Indice: " + (i) + videojuegos.get(i));
        }
        System.out.println();
        // buscar juego
        System.out.println("Ingrese el nombre del juego a buscar: ");
        String buscado = scanner.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < videojuegos.size(); i++) {
            if (videojuegos.get(i).getNombre().equalsIgnoreCase(buscado)) {
                System.out.println("Encontramos el juego!");
                encontrado = true;
                break;
            } /* No hago else, para que no lo imprima cada vez que itera */
        }
        if (!encontrado) { /* Si no lo encuentra */
            System.out.println(buscado + " no esta en la lista");
        }

        System.out.println("Total de juegos en la lista: " + videojuegos.size()); /* Muestra juegos con su indice */
        System.out.println();

        // Eliminar juego. Uso de .remove
        System.out.println("Ingrese el nombre del juego que desea eliminar");
        String eliminar = scanner.nextLine();
        boolean eliminado = false;
        for (int i = 0; i < videojuegos.size(); i++) {
            if (videojuegos.get(i).getNombre().equalsIgnoreCase(eliminar)) {
                System.out.println("Encontramos el juego que vamos a borrar");
                System.out.println("Eliminado: " + videojuegos.get(i)); // imprime como toString Mario Bross
                videojuegos.remove(i);
                eliminado = true;
                break;
            }
        }
        if (!eliminado) {
            System.out.println(eliminar + " no esta en la lista, no se puede eliminar");
        }
        System.out.println();

        // mostrar juegos por genero
        System.out.println("Ingrese el genero del juego que desea ver");
        String opcion = scanner.nextLine();
        for (int i = 0; i < videojuegos.size(); i++) {
            if (videojuegos.get(i).getGenero().equalsIgnoreCase(opcion)) {
                System.out.println(videojuegos.get(i));
            }
        }
        
        scanner.close();
    }
}
