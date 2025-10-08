import java.util.ArrayList;
import java.util.List;

public class AppBiblioteca2 {
    public static void main(String[] args) throws Exception {
        Libro2 libro1 = new Libro2 ("1984", "Orwell", 4);
        Libro2 libro2 = new Libro2 ("Cien años de soledad", "Garcia Marquez", 3);
        Libro2 libro3 = new Libro2 ("Paula", "Isabel Allende", 1);

        ArrayList <Libro2> biblioteca = new ArrayList<>(List.of(libro1,libro2, libro3));

        Biblioteca2 miBiblioteca2 = new Biblioteca2(biblioteca); //guardo los libros de biblioteca en el arraylist miBiblioteca2

        miBiblioteca2.listadoDeLibros();

        //Prestar libro 
        try {
            miBiblioteca2.prestarLibro("Paula");
        } catch (SinCopiasException e) {
            System.out.println(e.getMessage());
        } catch (LibroNoEncontradoException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }

         //Prestar libro 
        try {
            miBiblioteca2.prestarLibro("1984");
        } catch (SinCopiasException e) {
            System.out.println(e.getMessage());
        } catch (LibroNoEncontradoException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }

        //Prestar libro que no existe 
        try {
            miBiblioteca2.prestarLibro("Harry Potter");
        } catch (SinCopiasException e) {
            System.out.println(e.getMessage());
        } catch (LibroNoEncontradoException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }

        miBiblioteca2.listadoDeLibros();

        //Devolver libro
        try {
            miBiblioteca2.devolverLibro("Paula");
        } catch (LibroNoEncontradoException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }

        miBiblioteca2.listadoDeLibros();
    }
}
