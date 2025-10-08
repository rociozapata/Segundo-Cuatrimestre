public class AppPublicacion {
    public static void main(String[] args){
        
        Libro libro1 = new Libro ("Viajes y otros viajes", 2012, "Antonio Tabucchi", 267);
        libro1.mostrarInfo();
        System.out.println();

        Libro libro2 = new Libro ("Sumo por Pettinato", 2009, "Roberto Pettinato", 253);
        libro2.mostrarInfo();
        System.out.println();

        Revista revista1 = new Revista("Para Ti", 2025, 2365, "Julio 2025");
        revista1.mostrarInfo();
        System.out.println();

        libro1.prestar();
        System.out.println();

        libro1.prestar();
        System.out.println();
        libro1.mostrarInfo();
        
        System.out.println();
        libro1.devolver();
        System.out.println("Despues de la devolucion");
        libro1.mostrarInfo();

    }
}
