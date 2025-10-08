import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // Instancio 3 libros de la clase Libro
        Libro libro1 = new Libro("1984", "Orwell", true);
        Libro libro2 = new Libro("Paula", "Isabel Allende", true);
        Libro libro3 = new Libro("Martin Fierro", "Jose Hernandez", true);

        //Agrego los libros cargados al ArrayList
        ArrayList <Libro> libros = new ArrayList<>();
        // ArrayList <Libro> libros = new ArrayList <Libro> (List.of(libro1, libro2, libro3)); es otra forma de agregar elementos
        libros.add(libro1); // se agregarn de atras para adelante
        libros.add(libro2);
        libros.add(libro3);

        Biblioteca miBiblioteca = new Biblioteca(libros); // Creo un arraylist de biblioteca con los elementos del arraylist libros para usar los metodos de la clase Biblioteca

        // para metodos con excepciones verificadas, lo rodeo con el try-catch dentro del main
        try {
            miBiblioteca.prestarLibro("Paula");
        } catch (LibroNoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (LibroYaPRestadoException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Paso lo que tenia que pasar");
        }
 //aca vuelvo a llamar al metodo para tener otra salida
        try {
            miBiblioteca.prestarLibro("Paula");
        } catch (LibroNoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (LibroYaPRestadoException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Paso lo que tenia que pasar");
        }
//Busco un libro que no existe en el listado
        try {
            miBiblioteca.devolverLibro("Detras del maquillaje");
        } catch (LibroNoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (LibroYaPRestadoException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Paso lo que tenia que pasar");
        }
//Devuelvo un libro prestado 
        try {
            miBiblioteca.devolverLibro("Paula");
        } catch (LibroNoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (LibroYaPRestadoException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Paso lo que tenia que pasar");
        }

    }
}
