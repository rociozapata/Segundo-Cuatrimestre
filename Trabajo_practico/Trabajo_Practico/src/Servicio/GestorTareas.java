package Servicio;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Entidades.Tarea;
import Enums.Estado;
import Enums.Prioridad;
import Repositorio.CSVManager;

public class GestorTareas {
    private Map<Long, Tarea> mapTareas;

    Scanner scanner = new Scanner(System.in);

    // Constructor
    public GestorTareas() {
        List<Tarea> listaTareas = CSVManager.leerTareas();
        transformarListAHashMap(listaTareas);
    }

    // transformar list a HashMap
    public void transformarListAHashMap(List<Tarea> lista) { // recibe una lista como parametro
        for (Tarea tarea : lista) { // por cada objeto tarea de la lista
            mapTareas.put(tarea.getId(), tarea); // agrego al map el id(clave) y la tarea(valor)
        }
    }

    // crear tarea. dentro de tarea le asigno un id con crearId()
    public void crearTarea(String titulo, String descripcion, LocalDate fecha_inicio,
            LocalDate fecha_vencimiento, Prioridad prioridad, Estado estado) throws Exception {
        // verifico que la fecha final no sea despues de la inicial
        if (fecha_inicio != null && fecha_vencimiento != null && fecha_vencimiento.isBefore(fecha_inicio)) {
            throw new Exception("Ya paso la fecha de vencimiento");
        }
        // caso de tareas con mismo titulo
        if (buscarDuplicados(titulo)) {
            System.out.println("Tienes una tarea con el mismo titulo. Agregar: (1) o rechazar: (2)");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            // agregar tarea lo mismo
            if (opcion == 1) {
                Tarea tarea = new Tarea(crearId(), titulo, descripcion, fecha_inicio, fecha_vencimiento, prioridad,
                        estado); // creo la tarea
                mapTareas.put(tarea.getId(), tarea); // la agrego al mapTarea
                CSVManager.agregarTarea(tarea); // la agrego al CSV
                System.out.println("Tarea agregada!");
            }
            // rechazar
            if (opcion == 2) {
                System.out.println("Tarea rechadaza...");
            }
            // manejo d crearTarea sin excepciones
        } else {
            Tarea tarea = new Tarea(crearId(), titulo, descripcion, fecha_inicio, fecha_vencimiento, prioridad, estado); // creo la tarea con ID 
            mapTareas.put(tarea.getId(), tarea); // la agrego al mapTarea
            CSVManager.agregarTarea(tarea); // la agrego al CSV
            System.out.println("Tarea agregada!");
        }
    }

    // metodo para buscar titulos duplicados
    public Boolean buscarDuplicados(String titulo) {
        for (Tarea tarea : mapTareas.values()) {
            if (tarea.getTitulo().equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }

    // muestro listado de tareas
    public void listarTareas() {
        if (mapTareas.isEmpty()) {
            System.out.println("No hay tareas para mostrar");
            return;
        }
        for (Tarea t : mapTareas.values()) {
            System.out.println(t.toString());
            System.out.println("----------------------");
        }
    }

    // buscar tareas por id / public Tarea para que retorne el objeto tarea completo
    public Tarea buscarTareaPorId(Long id) throws Exception {
        if (!mapTareas.containsKey(id)) {
            throw new Exception("El id buscado no existe");
        }
        Tarea tareaBuscada = null; // variable aux para guardar la tarea buscada por id
        if (mapTareas.containsKey(id)) {
            tareaBuscada = mapTareas.get(id); // asigno la tarea por id
        }
        return tareaBuscada;
    }

    // crear id
    public Long crearId() {
        if (mapTareas.isEmpty()) {
            return Long.parseLong("1"); // si el map esta vacio, devuelve el 1
        }
        Long nuevo = Long.parseLong("0"); // variable para retorno
        for (Long i : mapTareas.keySet()) {
            if (i > nuevo) {
                nuevo = i;
            }
        }
        return (nuevo + 1); // retorno el id mayor mas 1 para crear una nueva tarea
    }

    // eliminar tarea por id
    public void eliminarTarea(Long id) throws Exception {
        if (!mapTareas.containsKey(id)) {
            throw new Exception("El id no fue encontrado"); // si el id no existe en el map tira exc
        } else {
            mapTareas.remove(id);
            CSVManager.reescribirTareas(mapTareas);
        }
        System.out.println("Tarea eliminada correctamente");
    }

    public void guardarCambios() {
        CSVManager.reescribirTareas(mapTareas);
    }

    // lista las tareas por Estado
    public void listarTareasPorEstado() {
        if (mapTareas.isEmpty()) {
            System.out.println("No hay tareas para listar");
            return;
        }
        for (Estado estado : Estado.values()) {
            boolean hayTareas = false;
            System.out.println("Estado: " + estado);
            for (Tarea t : mapTareas.values()) {
                if (t.getEstado() == estado) {
                    System.out.println(t.toString());
                    hayTareas = true;
                }
            }

            if (!hayTareas) {
                System.out.println("No hay tareas con este estado");
            }
            System.out.println();
        }
    }

    // lista las tareas por semana (hoy + 7)
    public void listarPorSemana() {
        if (mapTareas.isEmpty()) {
            System.out.println("No hay tareas para mostrar");
            return;
        }
        LocalDate hoy = LocalDate.now();
        LocalDate finSemana = hoy.plusDays(7);
        boolean hayTareas = false;
        System.out.println("Tareas para la proxima semana: ");

        for (Tarea i : mapTareas.values()) {
            LocalDate fechaVencimiento = i.getFechaVencimiento(); // variable con la fecha de vencim de la tarea i
            if ((fechaVencimiento.isEqual(hoy) || fechaVencimiento.isAfter(hoy)) &&
                    (fechaVencimiento.isEqual(finSemana) || fechaVencimiento.isBefore(finSemana))) {
                System.out.println(i.toString());
                System.out.println("--------------------");
                hayTareas = true;
            }
        }
        if (!hayTareas) {
            System.out.println("No hay tareas para la semana");
        }
    }
    // fin
}
