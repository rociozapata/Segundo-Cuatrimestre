import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class ListaMain {
    public static void main(String[] args) {
        
        String archivoEntrada = "./Semana8/ListaComprasA/archivos/productos.csv";
        String archivoSalida = "./Semana8/ListaComprasA/archivos/resumen_compras.txt";
        System.out.println(archivoEntrada);
        ArrayList<Producto> productos = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(archivoEntrada))) {
            String linea;
            lector.readLine(); // con esto ignoro la primer linea del encabezado
        
            // con este while transformo la linea del csv a un array. desp hago variables aux para crear el producto y agregarlo al AL
            while ((linea = lector.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    String[] lineaAux = linea.split(","); // lee la linea y separa los string con coma. Guarda todo en un array comun
                    String nombreAux = lineaAux[0].trim(); // el trim me elimina espacios 
                    Categoria categoriaAux = Categoria.valueOf(lineaAux[1].trim()); // busca el string en el enum
                    Double precioAux = Double.parseDouble(lineaAux[2].trim()); // pasa string a double
                    Integer cantidadAux = Integer.parseInt(lineaAux[3].trim()); // pasa string a int
                    // creo un objeto de tipo Producto con los aux y loagrego en el arraylist productos
                    productos.add(new Producto(nombreAux, categoriaAux, precioAux, cantidadAux));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
            return;
        }

        Map<Categoria, Integer> cantidadPorCategoria = new EnumMap<>(Categoria.class); // acumulador
        Map<Categoria, Double> totalPorCategoria = new EnumMap<>(Categoria.class);
        double totalGeneral = 0.0;

        for(Producto p : productos){

            cantidadPorCategoria.put(
                p.getCategoria(),   // trae la categoria del producto y la transforma en clave
                cantidadPorCategoria.getOrDefault(p.getCategoria(),0) + p.getCantidad()  // guarda el valor con cantidades. sobreescribe el valor
            );

            totalPorCategoria.put(
                p.getCategoria(), 
                totalPorCategoria.getOrDefault(p.getCategoria(),0.0) + p.subTotal()
            );

            totalGeneral += p.subTotal();
        }

        Categoria masCara = null;
        Categoria masBarata = null;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        
        for (Map.Entry<Categoria, Double> entry : totalPorCategoria.entrySet()) {
            double valor = entry.getValue();   // guardo en variable aux el valor de cada map

            if (valor > max) {  // si valor es mayor a max, valor es el nuevo max y asigno la categoria a "masCara"
               max = valor;
               masCara = entry.getKey(); 
            }

            if (valor < min) {
                min = valor;
                masBarata = entry.getKey();
            }
        }
        
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoSalida))){
            escritor.write("----- RESUMEN DE COMPRA -----");
            escritor.newLine();
            escritor.write("*** Lista de productos con subtotales ***");
            escritor.newLine();

            for(Producto p : productos){
                escritor.write("Producto: " + p.getNombre() + " - (" + p.getCategoria() + ") - cantidad: " + p.getCantidad() + "Subtotal: $" +String.format ("%.2f", p.subTotal()));
                escritor.newLine();
                escritor.write("***Total por Categoria***");
                escritor.newLine();
                for (Categoria c : Categoria.values()){
                    int cantTotal = cantidadPorCategoria.getOrDefault(c, 0);
                    double precioTotal = totalPorCategoria.getOrDefault(c, 0.0);
                    escritor.write(c + ": " + cantTotal + "productos - $" + String.format("%.2f", p.subTotal()));
                    escritor.newLine();
                }
                escritor.newLine();
                escritor.write("Total General: $" + String.format("%.2f", totalGeneral)); //chequear el total
                escritor.write("Categoria mas cara: " + masCara + " ($"+ String.format("%.2f", max));
                escritor.newLine();
                escritor.write("Categoria mas barata: " + masBarata + " ($"+ String.format("%.2f", min));
            }

        } catch (IOException e){
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }

        System.out.println("Archivo resumen generado en "+ archivoSalida);
    }
}      
