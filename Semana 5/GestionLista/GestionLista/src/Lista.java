public class Lista {
    private int dni;
    private String nombre;
    private String apellido;

    public Lista (int dni, String nombre, String apellido){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void setDni (int dni){
        this.dni = dni;
    }

    public int getDni(){
        return this.dni;
    }

    public void setNombre (String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setApellido (String apellido){
       this.apellido = apellido;
    }

    public String getApellido(){
        return this.apellido;
    }
    @Override
    public String toString (){
      return "[DNI]: " + dni + " [Nombre]: " + nombre + " [Apellido]: " + apellido;
    }
}
