import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros; //ArrayList de elementos de clase Libro

    //Constructor recibe como parametro libros
    public Biblioteca (ArrayList <Libro> libros){
        this.libros = libros;
    }

    // metodo con excepciones personalizadas
    public void prestarLibro (String titulo) throws LibroNoEncontradoException, LibroYaPRestadoException {
        for (Libro libro : libros) { // para cada libro de tipo Libro en mi arraylist libros hago esto
            if (libro.getTitulo().equalsIgnoreCase(titulo)) { //equalsIgnoreCase ignora mayusculas, solo compara el texto
                if (libro.isDisponible()) { // entra si esta en true
                    libro.setDisponible(false);
                    System.out.println("Libro: " + libro.getTitulo() + " prestado");
                    return;   //si encuentra el libro, sale del metodo
                }
                else {
                    throw new LibroYaPRestadoException("El libro " + libro.getTitulo() + " ya esta prestado");
                }
            }
        }   // si llega aca es porque no encotro el libro
        throw new LibroNoEncontradoException(titulo + " no existe en la Biblioteca");  // uso titulo que recibo como parametro
    }
    //metodo con excepciones personalizadas
    public void devolverLibro(String titulo) throws LibroNoEncontradoException, LibroYaDisponibleException {
        for (Libro libro : libros){
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if(!libro.isDisponible()){ // el ! indica lo opuesto, en este caso entra si esta en false
                    libro.setDisponible(true);
                    System.out.println(libro.getTitulo() + " devuelto exitosamente");
                    return;
                }
                else {
                    throw new LibroYaDisponibleException("El libro " + libro.getTitulo() + " ya habia sido devuelto");
                }
            }
        }
        throw new LibroNoEncontradoException (titulo + " no existe en esta Biblioteca"); // titulo es el parametro buscado, no necesita get
    }
}
