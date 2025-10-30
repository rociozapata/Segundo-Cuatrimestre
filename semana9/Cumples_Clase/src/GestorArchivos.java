import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestorArchivos {
    private String rutaArchivo;

    public GestorArchivos(String rutaArchivo) { // constructor
        this.rutaArchivo = rutaArchivo;
        this.crearArchivoSiNoExiste();
    }

    private void crearArchivoSiNoExiste() {
        File archivo = new File(rutaArchivo); // creo un nuevo archivo
        if (!archivo.exists()) { // si el archivo no existe, entra
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo))) {
                escritor.write("NOMBRE,APPELIDO,FECHA"); // header del archivo csv
                escritor.newLine(); // salto de linea
                System.out.println("ARCHIVO CREADO");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
            }
        }
    }

    public List<Persona> leerPersonas() {
        List<Persona> personas = new ArrayList<>(); // creo un arraylist de personas
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            boolean primeraLinea = true; // flag de primera linea
            String linea; // variable para ir guardando la primera linea

            while ((linea = lector.readLine()) != null) { // si la linea no esta vacia
                if (primeraLinea) { // entro la primera vez porq ya esta en true
                    primeraLinea = false; // cambio flag a false
                    continue; // evito todo lo siguiente porq estoy en la primera linea y vuelve a iterar
                }
                String[] partes = linea.split(","); // array donde se va a guardar el CSV separado por comas

                if (partes.length != 3) { // si tiene mas de 3 items tira error
                    System.out.println("Linea mal formateada: " + linea);
                }

                try {
                    String nombre = partes[0];
                    String apellido = partes[1];
                    LocalDate fecha = LocalDate.parse(partes[2]); // transformo el string a formato fecha antes de asignarlo a fecha

                    personas.add(new Persona(nombre, apellido, fecha)); // creo una nueva persona y la agrego a personas
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return personas; // retorna lista con todas las personas
    }

    public void agregarPersona(Persona p) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            escritor.write(p.toStringCSV()); // transformo a CSV (funcion de Persona) y lo escribo en archivo
            escritor.newLine();

        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        } 
    }

    public HashMap estadisticaMes(List<Persona> personas) {
        HashMap<Integer, Integer> mapa = new HashMap<>(); // creo nuevo hashmap

        for (Persona p : personas) {
            Integer mes = p.getFechaNacimiento().getMonthValue(); // me devuelve el numero de mes
            mapa.put(mes, mapa.getOrDefault(mes, 0) + 1); // si no tiene valor ya asignado empieza por 0 y ya le agrega 1
        }
        return mapa; // retorna el hashmap
    }

    public String buscarPorApellido(String letras, List<Persona> personas) { // pido las letras y el array de todas las personas                                                                      
        StringBuilder sb = new StringBuilder();
        String letrasLower = letras.toLowerCase(); // letras a minusculas

        for (Persona p : personas) {
            if (p.getApellido().toLowerCase().contains(letrasLower)) { // si el apellido, transformado todo a minuscula,
                                                                       // contiene las letras creo un sb
                sb.append(p.getNombre())
                        .append(" ")
                        .append(p.getApellido())
                        .append(" ")
                        .append(p.getFechaNacimiento().getYear())
                        .append("/")
                        .append(p.getFechaNacimiento().getMonthValue())
                        .append("/")
                        .append(p.getFechaNacimiento().getDayOfMonth());
            }
        }
        return sb.toString(); // retorna el Builder transformado a string
    }



}
