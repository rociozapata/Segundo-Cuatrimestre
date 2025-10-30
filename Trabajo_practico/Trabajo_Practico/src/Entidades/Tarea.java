package Entidades;

import java.time.LocalDate;
import Enums.Estado;
import Enums.Prioridad;

public class Tarea {
    private long id;
    private String titulo;
    private String descripcion;
    private LocalDate fecha_inicio;
    private LocalDate fecha_vencimiento;
    private Prioridad prioridad;
    private Estado estado;

    //constructor completo 
    public Tarea(long id, String titulo, String descripcion, LocalDate fecha_inicio, LocalDate fecha_vencimiento,
            Prioridad prioridad, Estado estado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_vencimiento = fecha_vencimiento;
        this.prioridad = prioridad;
        this.estado = estado;
    }
    // constructor sin ID
    public Tarea(String titulo, String descripcion, LocalDate fecha_inicio, LocalDate fecha_vencimiento,
            Prioridad prioridad, Estado estado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_vencimiento = fecha_vencimiento;
        this.prioridad = prioridad;
        this.estado = estado;
    }

    //constructor vacio
    public Tarea() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setDescricion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setFechaInicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFechaInicio() {
        return this.fecha_inicio;
    }

    public void setFechaVencimiento(LocalDate fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public LocalDate getFechaVencimiento() {
        return this.fecha_vencimiento;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Prioridad getPrioridad() {
        return this.prioridad;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return this.estado;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " - Titulo: " + this.titulo +
                "/nDescripcion: " + this.descripcion +
                "/nFecha Inicio: " + this.fecha_inicio + " - Fecha Vencimiento: " + this.fecha_vencimiento +
                "/nEstado: " + this.estado + " - Priodidad: " + this.prioridad;
    }

    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getId())
                .append(",")
                .append(this.getTitulo())
                .append(",")
                .append(this.getDescripcion())
                .append(",")
                .append(this.getFechaInicio())
                .append(",")
                .append(this.getPrioridad())
                .append(",")
                .append(this.getEstado());

        return sb.toString();
    }
}
