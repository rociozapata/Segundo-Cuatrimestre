public class App {
    public static void main(String[] args) throws PaqueteNoEncontradoException {
        SistemaEnvios sistema = new SistemaEnvios();

        sistema.registrarPaquete(new Package("PKG001", "Juan Perez", 2.5));
        sistema.registrarPaquete(new Package("PKG002", "Maria Gonzalez", 5.0));
        sistema.registrarPaquete(new Package("PKG003", "Carlos Ruiz", 1.2));
        sistema.registrarPaquete(new Package("PKG004", "Ana Martinez", 3.8));

        try {
            sistema.actualizarEstado("PKG001", EstadoPaquete.EN_TRANSITO);
            sistema.actualizarEstado("PKG002", EstadoPaquete.ENTREGADO);
            sistema.actualizarEstado("PKG003", EstadoPaquete.EN_REPARTO);
            sistema.actualizarEstado("PKG009", EstadoPaquete.EN_TRANSITO);
        } catch (PaqueteNoEncontradoException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            System.out.println("Costo PKG001 $" + sistema.calcularCosto("PKG001", false) );
            System.out.println("Costo PKG002 $" + sistema.calcularCosto("PKG002", true) );
            System.out.println("Costo PKG009 $" + sistema.calcularCosto("PKG009", false) );
        } catch (PaqueteNoEncontradoException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\n " + sistema.agruparPorEstado());
        System.out.println();
        System.out.println("==== REPORTE DE PAQUETES ====");
        System.out.println("\n " + sistema.generarReporte());
    }
}