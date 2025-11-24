import java.time.LocalDate;

public class Paquete {

    private String codigo;
    private String destinatario;
    private double peso; //en kilogramos
    private EstadoPaquete estado;
    private LocalDate fechaEnvio;


    public Paquete(String codigo, String destinatario, double peso){
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.peso = peso;
        this.estado = EstadoPaquete.PENDIENTE;
        this.fechaEnvio = LocalDate.now();
    }

    public void setEstado(EstadoPaquete estado){
        this.estado = estado;
    }

    public String getCodigo(){
        return codigo;
    }

    public String getDestinatario(){
        return destinatario;
    }

    public double getPeso(){
        return peso;
    }

    public EstadoPaquete getEstado(){
        return estado;
    }

    public LocalDate getFechaEnvio(){
        return fechaEnvio;
    }

    @Override
    public String toString(){
        return "Codigo " + codigo + " | Destinatario " + destinatario + " | Peso " + peso + " | Estado " + estado;
    }
}


