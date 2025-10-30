
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        String archivoEntrada = "Lista de Compras\\ListaCompras\\archivos\\lista_compras.txt ";
        String archivoSalida = "Lista de Compras\\ListaCompras\\archivos\\resumen_compras.txt";

        ArrayList<String> productos = new ArrayList<>(); // array de productos

        // agrego productos al arraylist mientras no haya lineas vacias en archivo
        // entrada
        try (BufferedReader lector = new BufferedReader(new FileReader(archivoEntrada))) {
            String linea;
            while ((linea = lector.readLine()) != null) { // lo que mi lector lea, lo guarda en linea y luego lo compara
                if (!linea.trim().isEmpty()) { // si la linea no esta vacia , ignorando los espacios, entra
                    productos.add(linea.trim()); // con este trim elimino los espacios vacios de la tabla y codigo
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }

        // muestro el array de productos con indice
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + " - " + productos.get(i));
        }

        // append true indica que voy a agregar lineas al archivoSalida. si no esta o es
        // false, sobreescribe con lo que agregue
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoSalida, true))) {
            escritor.write("RESUMEN");
            escritor.newLine();

            // escribe los productos en el resumen
            for (int i = 0; i < productos.size(); i++) {
                escritor.write((i + 1) + " - " + productos.get(i));
                escritor.newLine();
            }
            // Total de productos
            escritor.write("Total de productos: " + productos.size());
            escritor.newLine();

            // muestro primero y ultimo
            escritor.write("Primer producto: " + productos.get(0));
            escritor.newLine();
            escritor.write("Ultimo producto: " + productos.get(productos.size() - 1));
            escritor.newLine();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
