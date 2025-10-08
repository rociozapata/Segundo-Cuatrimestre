import java.util.ArrayList;
import java.util.List;


public class GestionLista {
    public static void main(String[] args) {
        
        Lista lista1 = new Lista(36283347, "Rocio", "Zapata");
        Lista lista2 = new Lista(36036487, "Andrea", "Gomez");
        Lista lista3 = new Lista(23589664, "Franco", "Estrada");
        Lista lista4 = new Lista(43202159, "Joaquin", "Fernandez");

        //Creo un arraylist de clase Lista, nombre lista con los elementos nuevos 
        ArrayList <Lista> lista = new ArrayList <Lista> (List.of(lista1, lista2, lista3, lista4)); //agrego elementos al arraylist

        Listado miListado = new Listado(lista); // creo un array de la clase listado que contiene el array lista 

        System.out.println(" # Antes de modificar #");
        miListado.mostrarListado();
        
       // Hasta aca funciona. Me falta crear el metodo para eliminar elementos




      
        
    }
    
}
