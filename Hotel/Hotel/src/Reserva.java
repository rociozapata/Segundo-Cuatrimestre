import java.time.LocalDate;

public class Reserva {
    private String codigoReserva;
    private String nombreHuesped;
    private int numeroHabitacion;
    private int cantidadNoches;
    private EstadoReserva estado;
    private LocalDate fechaIngreso;

    public Reserva(String codigoReserva, String nombreHuesped, int numeroHabitacion, int cantidadNoches){
        this.codigoReserva = codigoReserva;
        this.nombreHuesped = nombreHuesped;
        this.numeroHabitacion = numeroHabitacion;
        this.cantidadNoches = cantidadNoches;
        this.estado = EstadoReserva.PENDIENTE;
        this.fechaIngreso = LocalDate.now();
    }

    public void setCodigoReserva(String codigoReserva){
        this.codigoReserva = codigoReserva;
    }

    public String getCodigoReserva(){
        return this.codigoReserva;
    }

    public void setNombreHuesped(String nombre){
        this.nombreHuesped = nombre;
    }

    public String getNombreHuesped(){
        return this.nombreHuesped;
    }

    public void setNumeroHabitacion(int numeroHab){
        this.numeroHabitacion = numeroHab;
    }

    public Integer getNumeroHabitacion(){
        return numeroHabitacion;
    }

    public void setCantidadNoches(int cantNoches){
        this.cantidadNoches = cantNoches;
    }

    public Integer getCantidadNoches(){
        return cantidadNoches;
    }

    public void setEstadoReserva(EstadoReserva estado){
        this.estado = estado;
    }

    public EstadoReserva getEstado(){
        return this.estado;  
    }

    public void setFechaIngreso(LocalDate fechaIng){
        this.fechaIngreso = fechaIng;
    }

    public LocalDate getFechaIngreso(){
        return this.fechaIngreso;
    }

    public String toString(){
        return "Codigo: [" + codigoReserva + "] | Huesped: [" + nombreHuesped + "] | Habitacion: [" + numeroHabitacion + "] | Noches: [" + cantidadNoches + "] | Estado: [" + estado + "]";
    }
}
