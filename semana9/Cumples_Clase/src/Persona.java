import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;

    public Persona() {
    } // constructor vacio

    public Persona(String nombre, String apellido, LocalDate fechaNacimiento) { // constructor completo
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    // getters y setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public boolean yaCumplio() {
        LocalDate hoy = LocalDate.now();
        LocalDate fechaCumple = LocalDate.of(hoy.getYear(), this.fechaNacimiento.getMonthValue(),
                this.fechaNacimiento.getDayOfMonth());
        return hoy.isAfter(fechaCumple);
    }

    public boolean cumpleHoy() {
        LocalDate hoy = LocalDate.now();
        LocalDate fechaCumple = LocalDate.of(hoy.getYear(), this.fechaNacimiento.getMonthValue(),
                this.fechaNacimiento.getDayOfMonth());
        return fechaCumple.equals(hoy); // es lo mismo que asignar la comparacion a una variable
    }

    public int calcularEdad() {
        LocalDate hoy = LocalDate.now();

        if (this.yaCumplio() || this.cumpleHoy()) {
            return hoy.getYear() - fechaNacimiento.getYear();
        } else {
            return hoy.getYear() - fechaNacimiento.getYear() - 1;
        }
    }

    public String retornarPersonaConEdad() { // arma un string y suma el texto correspondiente
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ");
        sb.append(this.getNombre());
        sb.append(" ");
        sb.append(this.getApellido());
        sb.append("\nEdad: ");
        sb.append(this.calcularEdad());

        if (cumpleHoy()) {
            sb.append("Feliz Cumple!")
                    .append(this.fechaNacimiento.getDayOfMonth())
                    .append("/")
                    .append(this.fechaNacimiento.getMonthValue());
        } else if (this.yaCumplio()) {
            sb.append("\nYa cumplio este año el dia: ")
                    .append(this.fechaNacimiento.getDayOfMonth())
                    .append("/")
                    .append(this.fechaNacimiento.getMonthValue());
        }
        return sb.toString();
    }

    public String toStringCSV() { // 
        StringBuilder sb = new StringBuilder();

        sb.append(this.getNombre())
                .append(",")
                .append(this.getApellido())
                .append(",")
                .append(this.getFechaNacimiento());

        return sb.toString();
    }
}