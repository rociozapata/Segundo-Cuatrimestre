import java.util.HashMap;

public class Registros {
    private HashMap<String, EstadoAsistencia> registro; // declaro atributo hashmap

    //constructor
    public Registros(){
        this.registro = new HashMap<>(); // creo el hashmap
    }

    public void agregarRegistro() throws Exception{
        System.out.println("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacio ");
        }
        if (EstadoAsistencia.valueOf(asistencia) != null) {
            
        }
       
    }
   
    
    }

