import java.time.LocalDate;
import java.util.Scanner;

import Entidades.Tarea;
import Enums.Estado;
import Enums.Prioridad;
import Repositorio.CSVManager;
import Servicio.GestorTareas;
import Servicio.Validador;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static GestorTareas gestor = new GestorTareas();

    public static void main(String[] args) throws Exception {
        CSVManager.leerTareas();
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    creacionTarea();
                    break;
                case 2:
                    gestor.listarTareas();
                    break;
                case 3:
                    editarTarea();
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    System.out.println("Saliendo del Menu Tareas");
                    break;

                default:
                    break;
            }
        } while (opcion != 6);

    }

    public static void mostrarMenu() {
        System.out.println("Menu Tareas");
        System.out.println("Opcion 1: Crear tarea");
        System.out.println("Opcion 2: Listar tareas");
        System.out.println("Opcion 3: Editar tarea");
        System.out.println("Opcion 4: Eliminar tarea");
        System.out.println("Opcion 5: Reportes");
        System.out.println("Opcion 6: Salir");
    }

    public static void creacionTarea() throws Exception {
        String titulo;
        do {
            System.out.println("Ingrese el titulo: ");
            titulo = scanner.nextLine();
            if (!Validador.validarStrings(titulo)) { // si validador es false, mensaje
                System.out.println("El titulo no puede estar vacio");
            }
        } while (!Validador.validarStrings(titulo)); // se repite mientras el título NO sea válido.

        String descripcion;
        do {
            System.out.println("Ingrese la descripcion de la tarea:");
            descripcion = scanner.nextLine();
            if (!Validador.validarStrings(descripcion)) {
                System.out.println("La descripcion no puede estar vacia");
            }
        } while (!Validador.validarStrings(descripcion));

        LocalDate fechaInicio = null;
        String fechaInicioString;
        while (true) { // se usa un while con la condicion que devuelve el localdate.parse(), el error
                       // lo maneja el try-catch
            System.out.println("Ingrese la fecha de inicio de la tarea (YYYY-MM-DD)");
            fechaInicioString = scanner.nextLine();
            try {
                fechaInicio = LocalDate.parse(fechaInicioString); // si no lanza la excepcion, sale del while
                break;
            } catch (Exception e) {
                System.out.println("El formato de la fecha no es valido." + e.getMessage());
            }
        }

        LocalDate fechaVencimiento = null;
        String fechaVencimString;
        while (true) {
            System.out.println("Ingrese la fecha de vencimiento de la tarea (YYYY-MM-DD)");
            fechaVencimString = scanner.nextLine();
            if (!Validador.validarStrings(fechaVencimString)) {
                System.out.println("Error: la fecha no puede estar vacia");
            }
            try {
                fechaVencimiento = LocalDate.parse(fechaVencimString);
                if (fechaVencimiento.isBefore(fechaInicio) || fechaVencimiento == null) {
                    System.out.println("La fecha de vencimiento debe no debe ser anterior a la fecha de incio (" +fechaInicio + ")");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("El formato de la fecha no es valido." + e.getMessage());
            }
            break;
        }

        Prioridad prioridad;
        do {
            System.out.println("Ingrese la prioridad de la tarea (ALTA, MEDIA, BAJA)");
            String prioridadString = scanner.nextLine().toUpperCase(); // transforma todo a mayusculas
            try {
                prioridad = Prioridad.valueOf(prioridadString); // devuelve true si esta contenido
            } catch (IllegalArgumentException e) {
                prioridad = null; // flag para detectar excepcion
                System.out.println("Prioridad no valida.");
            }
        } while (prioridad == null); // minetras prioridad este vacia

        Estado estado;
        do {
            System.out.println("Ingrese el estado de la tarea. (PENDIENTE, EN PROCESO, COMPLETADA)");
            String estadoString = scanner.nextLine().toUpperCase().replace(" ", "_"); // conviernto la linea leida a
                                                                                      // mayusculas u el espacio en _
            try {
                estado = Estado.valueOf(estadoString); // si el estado no es un Estado valido, lanza excepcion
            } catch (IllegalArgumentException e) {
                estado = null; // flag para indicar que no es valido el estado
                System.out.println("Ingrese un estado valido");
            }
            if (estado == null) {
                System.out.println("El estado no puede estar vacio");
            }
        } while (estado == null); // mientras no se pueda asignar un estado, se repite

        gestor.crearTarea(titulo, descripcion, fechaInicio, fechaVencimiento, prioridad, estado); // creo la nueva
                                                                                                  // tarea. en el metodo
                                                                                                  // se le asigna el id
    }

    public static void editarTarea() {
        System.out.println("Ingrese el ID de la tarea que desea modificar: ");
        Tarea tarea = new Tarea();
        Long buscado = scanner.nextLong();
        scanner.nextLine();
        try {
            tarea = gestor.buscarTareaPorId(buscado); // el buscar me retorna una tarea, que la asigno a mi nueva tarea
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        boolean retornar = false;
        int opcion = 0;
        do {
            System.out.println("Opciones para editar tarea");
            System.out.println("Opcion 1: Editar titulo");
            System.out.println("Opcion 2: Editar descripcion");
            System.out.println("Opcion 3: Editar fecha de inicio");
            System.out.println("Opcion 4: Editar fecha vencimiento");
            System.out.println("Opcion 5: Editar prioridad");
            System.out.println("Opcion 6: Editar estado");
            System.out.println("Opcion 7: Salir del editor");
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion > 7 || opcion < 1) {
                System.out.println("Error al ingresar opcion. Debe ser un numero entre entre 1 y 7"); // validar que
                                                                                                      // opcion sea
                                                                                                      // numero entre 1
                                                                                                      // y 7
                opcion = scanner.nextInt();
                scanner.nextLine();
            }

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nuevo titulo. Para volver al menu de editar ingrese .");
                    String nuevoTitulo = scanner.nextLine(); // leo nuevo titulo
                    if (!Validador.validarStrings(nuevoTitulo)) {
                        tarea.setTitulo(nuevoTitulo); // si no esta vacio, lo setea en tarea
                    } else {
                        System.out.println("Error: el titulo no puede estar vacio"); // mensaje de error
                    }
                    break;

                case 2:
                    System.out.println("Ingrese la nueva descripcion:");
                    String nuevaDescripcion = scanner.nextLine();
                    if (!Validador.validarStrings(nuevaDescripcion)) {
                        tarea.setDescricion(nuevaDescripcion);
                    } else {
                        System.out.println("La descripcion no puede estar vacia");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese la nueva fecha de inicio (YYYY-MM-DD)");
                    String fechaIn = scanner.nextLine();
                    if (Validador.validarStrings(fechaIn)) {
                        try {
                            tarea.setFechaInicio(LocalDate.parse(fechaIn));
                        } catch (Exception e) {
                            System.out.println("Formato de fecha no valido.");
                        }
                    } else {
                        System.out.println("La fecha de inicio no puede estar vacia");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese la nueva fecha de vencimiento (YYYY-MM-DD)");
                    String fechaVen = scanner.nextLine();
                    if (Validador.validarStrings(fechaVen)) {
                        try {
                            tarea.setFechaVencimiento(LocalDate.parse(fechaVen));
                        } catch (Exception e) {
                            System.out.println("Formato de fecha no valido.");
                        }
                    } else {
                        System.out.println("La fecha de vencimiento no puede estar vacia");
                    }
                    break;
                case 5:
                    System.out.println("Ingrese la nueva prioridad de la tarea (ALTA, MEDIA, BAJA)");
                    String nuevaPrioridad = scanner.nextLine().toUpperCase();
                    if (!Validador.validarStrings(nuevaPrioridad)) {
                        try {
                            tarea.setPrioridad(Prioridad.valueOf(nuevaPrioridad));
                        } catch (Exception e) {
                            System.out.println("Ingrese una priodiad valida (ALTA, MEDIA, BAJA)");
                        }
                    } else {
                        System.out.println("La prioridad no puede estar vacia");
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el nuevo estado de la tarea");
                    String nuevoEstado = scanner.nextLine().toUpperCase().replace(" ", "_");
                    if (!Validador.validarStrings(nuevoEstado)) {
                        try {
                            tarea.setEstado(Estado.valueOf(nuevoEstado));
                        } catch (Exception e) {
                            System.out.println("ingrese un estado valido (PENDIENTE, EN PROCESO, COMPLETADA)");
                        }
                    } else {
                        System.out.println("El estado no puede estar vacio ");
                    }
                    break;
                case 7:
                    System.out.println("Saliendo del menu de Editar tarea");
                    break;
                default:
                    break;
            }
        } while (opcion != 7);
        gestor.guardarCambios(); // se reescribe la tarea
    }

}
