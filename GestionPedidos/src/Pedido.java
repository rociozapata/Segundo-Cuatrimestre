
import java.time.LocalDate;

public class Pedido {
    // Atributos
    private String id;
    private String cliente;
    private double costoBase; // Costo en USD
    private PrioridadPedido prioridad;
    private LocalDate fechaCreacion;

    // Constructor
    public Pedido(String id, String cliente, double costoBase) {
        this.id = id;
        this.cliente = cliente;
        this.costoBase = costoBase;
        this.prioridad = PrioridadPedido.NORMAL;
        this.fechaCreacion = LocalDate.now();
    }

    // Getters
    public String getId() {
        return this.id;
    }
    public String getCliente() {
        return this.cliente;
    }
    public double getCostoBase() {
        return this.costoBase;
    }
    public PrioridadPedido getPrioridad() {
        return this.prioridad;
    }
    public LocalDate getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    // Setters
    public void setPrioridad(PrioridadPedido prioridad) {
        this.prioridad = prioridad;
    }

    // Debe devolver el ID, Cliente, Costo Base y Prioridad.
    @Override
    public String toString() { 
        return "ID " + id + " | CLIENTE " + cliente + " | COSTO BASE " + costoBase + " | PRIORODAD " + prioridad;
    }
}

