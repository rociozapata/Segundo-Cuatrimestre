import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        //crear pelicula completa
        Pelicula pelicula1 = new Pelicula("La vida es bella", "Guido Perroud", 105, false);

        //crear pelicula sin vista
        Pelicula pelicula2 = new Pelicula ("Tornado", "Santino Maturo", 117);

        //crear pelicula con constructor basico
        Pelicula pelicula3 = new Pelicula("SpiderMan 2", "Chistopher Nollan");

        pelicula1.marcarComoVista();
        System.out.println(pelicula1);
        System.out.println(pelicula2);
        System.out.println(pelicula3);

        scanner.close();
    }
}
