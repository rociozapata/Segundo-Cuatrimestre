import java.util.HashMap;
import java.util.EnumMap;
import java.util.Map;

public class SistemaPedidos {
    private HashMap<String, Pedido> pedidos;
    private static final double RECARGO_URGENTE = 15.0; // Recargo fijo por urgencia

    // Constructor (COMPLETAR)
    public SistemaPedidos() {
        this.pedidos = new HashMap<>();
    }

    // Método para registrar un nuevo pedido 
    public void registrarPedido(Pedido p) {
        pedidos.put(p.getId(), p);
    }

    // Método para actualizar la prioridad 
    // Debe lanzar PedidoNoEncontradoException si el ID no existe.
    public void actualizarPrioridad(String id, PrioridadPedido nuevaPrioridad) throws PedidoNoEncontradoException {
        if (!pedidos.containsKey(id)) {
            throw new PedidoNoEncontradoException("El pedido " + id + "no se encontro en el sistema");
        } 
        Pedido cambio = pedidos.get(id);       //guardo el valor en cambiar
        cambio.setPrioridad(nuevaPrioridad);
        System.out.println("Prioridad del pedido " + id + " actualizada : " + nuevaPrioridad);
    }
    
    // Método para calcular el costo final
    // Si la prioridad es URGENTE, debe sumar el RECARGO_URGENTE.
    public double calcularCostoFinal(String id) throws PedidoNoEncontradoException {
        if (!pedidos.containsKey(id)) {
            throw new PedidoNoEncontradoException ("El pedido " + id + "no se encontro en el sistema");
        }
        double costoFinal = 0.0;
        Pedido calcular = pedidos.get(id);
        if (calcular.getPrioridad().equals(PrioridadPedido.URGENTE)) {
            costoFinal = calcular.getCostoBase() + RECARGO_URGENTE;
        } else{
            costoFinal = calcular.getCostoBase();
        }
        return costoFinal;
    }

    // Método para agrupar pedidos por prioridad usando EnumMap 
    // Debe devolver un EnumMap<PrioridadPedido, Integer> con el conteo de pedidos.
    public EnumMap<PrioridadPedido, Integer> agruparPedidosPorPrioridad() {
        EnumMap <PrioridadPedido, Integer> porEstado = new EnumMap<>(PrioridadPedido.class);

        for (Pedido p : pedidos.values()) {
            porEstado.put(p.getPrioridad(), 
            (porEstado.getOrDefault(p.getPrioridad(), 0) + 1)); // del enum me fijo si la prioridad ya existe y sumo 1 o me devuelve 0 por default
        }
        return porEstado;
    }

    // Método para generar reporte (COMPLETAR)
    // Debe devolver un String que liste todos los pedidos. Usa StringBuilder.
    public String generarReporte() {
        StringBuilder sb = new StringBuilder();
        int contador = 0;
        for (Pedido p : pedidos.values()) {
            sb.append("ID " + p.getId() + "| CLIENTE " + p.getCliente() + " | COSTO " + p.getCostoBase() + " | PRIORIDAD " + p.getPrioridad());
            sb.append("\n");
            contador += 1;
        }
        sb.append("Total Pedidos " + contador);
        return sb.toString();
    }
}