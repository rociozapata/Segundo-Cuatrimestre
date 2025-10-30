import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SistemaCumples {
    public static void main(String[] args)  {
        GestorArchivos gestorArchivos = new GestorArchivos("personasFechas.csv");
        String[] meses = {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        }; //Array para mostrar el nombre del mes sabiendo su numero
    
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("SISTEMA CUMPLES");
            System.out.println("Opcion 1: Agregar persona");
            System.out.println("Opcion 2: Ver todas las personas");
            System.out.println("Opcion 3: Ver cumples por mes");
            System.out.println("Opcion 4: Mostrar estadistica del mes");
            System.out.println("Opcion 5: Buscar por apellido");
            System.out.println("Opcion 6: Salir");
            System.out.println("Ingrese una opcion:");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.println("Ingrese fecha de nacimiento en formato (YYYY - MM - DD)");
                    String fechaTexto = scanner.nextLine();

                    try {
                        LocalDate fechaNacimiento = LocalDate.parse(fechaTexto); // asigno fechaTexto a fechaNacimiento
                        Persona nueva = new Persona(nombre,apellido,fechaNacimiento); // creo una persona con los datos ingresados
                        gestorArchivos.agregarPersona(nueva);                     //agrego persona nueva al archivo
                        System.out.println("Persona agregada correctamente");

                    } catch (Exception e) {
                        System.out.println("Fecha mal formateada");
                    }
                    break;
                case 2:
                    List<Persona> personas = gestorArchivos.leerPersonas();
                    if (personas.isEmpty()) {
                        System.out.println("No hay nada en el archivo");
                        break;
                    }
                    System.out.println("Personas en el CSV");
                    for (Persona p : personas) {
                        System.out.println(p.retornarPersonaConEdad());   
                    }
                    break;
                case 3:
                    System.out.println("Ingrese un mes del 1 al 12");
                    int mes = scanner.nextInt();
                    scanner.nextLine();
                    List<Persona> people = gestorArchivos.leerPersonas(); //creo un array con personas
                    if (people.isEmpty()) {
                        System.out.println("No hay nada en el archivo");
                        break;
                    }

                    boolean hayCumples = false;
                    System.out.println("Cumples del mes " + mes);
                    for (Persona p : people) {
                        if (p.getFechaNacimiento().getMonthValue() == mes) {
                            System.out.println(p.retornarPersonaConEdad());
                            hayCumples = true;
                        }
                    }

                    if (!hayCumples) {
                       System.out.println("Nadie cumple en el mes"); 
                    }
                    break;

                case 4:
                    List<Persona> person = gestorArchivos.leerPersonas();
                    if(person.isEmpty()){
                        System.out.println("No hay nada en el archivo");
                        break;
                    }
                  
                    HashMap <Integer,Integer> mapa = gestorArchivos.estadisticaMes(person); //Guardo el HashMap que devuelve la funcion, el map tiene de Key= numero del mes, value= cantidad ese mes;

                    System.out.println("Estadistica de cumpleaños por mes");
                    for(int i = 0; i <= 11; i++){
                        // si en ese mes no hay cumple, coloca 0
                        System.out.println(meses[i] + ": " + mapa.getOrDefault(i, 0)  + "personas");
                    }
                    break;
                case 5:  //acomodar este case porq si no encuentra coincidencias, no muestra nada
                    List<Persona> pApellido = gestorArchivos.leerPersonas();
                    if (pApellido.isEmpty()) {
                        System.out.println("No hay nada en el archivo");
                        break;
                    }
                    System.out.println("Ingrese el apellido a buscar: ");
                    String letras = scanner.nextLine();
                    if(pApellido.contains(letras)){
                    System.out.println(gestorArchivos.buscarPorApellido(letras, pApellido)); // imprimo lo que retorna la funcion de busqueda
                    } else {
                        System.out.println("No se encontraron coincidencias");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo de SISTEMA CUMPLES...");
                    break;
                default:
                    break;
            }
        } while (opcion != 6);
        scanner.close();
        
    }
}

