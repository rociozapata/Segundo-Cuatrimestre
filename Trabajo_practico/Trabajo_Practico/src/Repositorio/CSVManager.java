package Repositorio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Entidades.Tarea;
import Enums.Estado;
import Enums.Prioridad;

public class CSVManager {
    private static String rutaTareas = "Trabajo_Practico/src/Archivos/tareas.csv"; //ruta del archivo almacenada en variable

    public static void crearArchivoTareas(){
        File archivoTareas = new File(rutaTareas); //Creo objeto File con la ruta del archivo
        if (!archivoTareas.exists()) {
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaTareas))) {  //BufferedW para escribir en el archivo
                escritor.write("ID,Titulo,Descripcion,Fecha_inicio,FEcha_vencimiento,Prioridad,Estado"); //header del csv
                escritor.newLine();
            } catch (Exception e) {
                System.out.println("Error al crear el archivo " + e.getMessage());
            }  
        }
    }
    // leo las tareas desde el CSV y los almaceno en una lista
    public static List<Tarea> leerTareas(){
        List<Tarea> tareas = new ArrayList<>(); // creo lista para almacenar las tareas leidas 
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaTareas))) {
            lector.readLine();
            String linea;
            while((linea = lector.readLine()) != null){
                String[] tarea = linea.split(",");      //separo el string formado por los atributos de tarea con coma
                LocalDate fecha_inicio = LocalDate.parse(tarea[3]);     //en ambas fechas, transformo el string en fecha con .parse()
                LocalDate fecha_vencimiento = LocalDate.parse(tarea[4]);
                tareas.add(new Tarea(tarea[1], tarea[2], fecha_inicio, fecha_vencimiento, Prioridad.valueOf(tarea[5]), Estado.valueOf(tarea[6])));
            }
        } catch (Exception e) {
            System.out.println("Error al leer las tareas" + e.getMessage());
        }
        return tareas;
    }

    public static void agregarTarea(Tarea tarea){
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaTareas, true))) {
            escritor.write(tarea.toCSV());
            escritor.newLine();
            } catch (Exception e) {
            System.out.println("Error al agregar tarea " + e.getMessage());
        }
    }

    public static void reescribirTareas(Map<Long, Tarea> tareas){
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaTareas))) {
            escritor.write("id,titulo,descripcion,fecha_inicio,fecha_vencimiento,prioridad,estado");
            escritor.newLine();
            for(Tarea t : tareas.values()){
                escritor.write(t.toCSV());
                escritor.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error al reescribir el CSV tareas");
        }
    }
}