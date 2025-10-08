import java.util.ArrayList;

public class Biblioteca2 {
    private ArrayList <Libro2> biblioteca;

    public Biblioteca2 (ArrayList <Libro2> biblioteca){
        this.biblioteca = biblioteca;
    }

    public void prestarLibro (String titulo) throws LibroNoEncontradoException, SinCopiasException {
        for (Libro2 libro : biblioteca) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (libro.getCopias() > 0) // numero de copias mayor a 0
                {
                    libro.setCopias(libro.getCopias() - 1); // modifico desde el get - 1 y ya reseteo la cantidad
                    System.out.println("Libro " + titulo + " prestado exitosamente!!");
                    return;
                }
                else {
                    throw new SinCopiasException("El libro " + titulo + " buscado no tiene copias disponibles");
                }
            }
        }
        throw new LibroNoEncontradoException("El libro " + titulo + " no se encuentra en el listado la Biblioteca");
    }

    public void devolverLibro (String titulo) throws LibroNoEncontradoException {
        for (Libro2 libro : biblioteca) {
            if (libro.getTitulo().equals(titulo)) {
                libro.setCopias(libro.getCopias() + 1);
                System.out.println("Libro " + titulo + " devuelto exitosamente! Copias disponobles: " + libro.getCopias());
                return;
            }
        }
        throw new LibroNoEncontradoException("El libro " + titulo + " no se encuentra en el listado la Biblioteca");  
    }

    public void listadoDeLibros() {
        if (biblioteca.isEmpty()) { //isEmpthy devuelve true si esta vacia
            System.out.println("No hay libros aun...");
            return;
        }

        for (Libro2 libro : biblioteca) {
            System.out.println(libro); // uso el toString de libro
            System.out.println();
        }
    }
}
