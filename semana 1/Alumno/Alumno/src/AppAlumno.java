import java.util.Scanner;

public class AppAlumno {
    public static void main (String[] args){
       Scanner scanner = new Scanner(System.in);

       System.out.println("=== INGRESO DE ALUMNO ===");

       System.out.println("Ingrese el nombre del alumno");
       String nombre = scanner.nextLine();

       System.out.println("Ingrese el apellido del alumno");
       String apellido = scanner.nextLine();

       System.out.println("Ingrese el legajo del alumno");
       int legajo = scanner.nextInt();

       scanner.close();

       Alumno alumno1 = new Alumno(nombre, apellido, legajo);

       alumno1.presentarse();

       alumno1.mostrarDatos();

       System.out.println(alumno1);

    }
}
