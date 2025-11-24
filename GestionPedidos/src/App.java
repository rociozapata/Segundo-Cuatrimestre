public class App {
    static SistemaPedidos sistema = new SistemaPedidos();

    public static void main(String[] args) throws Exception {
        // Registrar pedidos
        sistema.registrarPedido(new Pedido("P001", "Gimena Lopez", 100.0));
        sistema.registrarPedido(new Pedido("P002", "Pedro Pérez", 50.0));
        sistema.registrarPedido(new Pedido("P003", "Ana García", 200.0));
        sistema.registrarPedido(new Pedido("P004", "Luis Martínez", 75.0));

        // Actualizar Prioridades y manejar excepciones
        try {
            sistema.actualizarPrioridad("P001", PrioridadPedido.URGENTE);
            sistema.actualizarPrioridad("P002", PrioridadPedido.BAJA);
            sistema.actualizarPrioridad("P005", PrioridadPedido.CRITICA); // Lanza excepción
        } catch (PedidoNoEncontradoException e) {
            System.out.println("ERROR en Actualizar: " + e.getMessage());
        }

        // Calcular Costos
        try {
            System.out.println("Costo P001: $" + sistema.calcularCostoFinal("P001"));
            System.out.println("Costo P002: $" + sistema.calcularCostoFinal("P002"));
            System.out.println("Costo P005: $" + sistema.calcularCostoFinal("P005")); // Lanza excepción
        } catch (PedidoNoEncontradoException e) {
            System.out.println("ERROR en Costo: " + e.getMessage());
        }

        // Agrupar y generar reporte
        System.out.println("\n--- RESUMEN ---");
        System.out.println(sistema.agruparPedidosPorPrioridad());
        System.out.println("\n--- REPORTE DETALLADO ---");
        System.out.println(sistema.generarReporte());
    }
}
