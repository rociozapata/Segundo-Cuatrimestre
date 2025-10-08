import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        String archivoEntrada = "archivos/lista_compras.txt";
        String archivoSalida = "archivos/resumen_compras.txt";

        ArrayList<String> productos = new ArrayList<>(); // array de productos

        try (BufferedReader lector = new BufferedReader(new FileReader(archivoEntrada))) {
            String linea;
            while ((linea = lector.readLine()) != null ){    // lo que mi lector lea, lo guarda en linea y luego lo compara
                if (!linea.trim().isEmpty()) {               //si la linea no esta vacia , ignorando los espacios, entra
                    productos.add(linea.trim());             // con este trim elimino los espacios vacios de la tabla y codigo                }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
        
        
        for (int i = 0; i < productos.size(); i++){
            System.out.println((i + 1) + " - " + productos.get(i));
        }

        try (BufferedWriter escritor = new BufferedWriter (new FileWriter(archivoSalida, true))) {
            escritor.write("RESUMEN");
            escritor.newLine();

            // escribe los productos en el resumen
            for (int i = 0; i < productos.size(); i++) {
                escritor.write((i + 1) + " - " + productos.get(i));
                escritor.newLine();
            }
                //Total de productos
            escritor.write("Total de productos: " + productos.size());
            escritor.newLine();

            // muestro primero y ultimo
            escritor.write("Primer producto: " + productos.get(0));
            escritor.newLine();
            escritor.write("Ultimo producto: " + productos.get(productos.size()- 1));

             } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}

