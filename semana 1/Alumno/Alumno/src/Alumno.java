public class Alumno {
    public String nombre;
    public String apellido;
    public int legajo;

    public Alumno (String nombre, String apellido, int legajo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getApellido(){
        return this.apellido;
    }

    public void setLegajo(int legajo){
        this.legajo = legajo;
    }

    public int getLegajo(){
        return this.legajo;
    }

    @Override
    public String toString(){
        return "=== DATOS DEL ALUMNO===\nNombre y Apellido : " + nombre + " " + apellido + "\n" + "Legajo: " + legajo;
    }

    public void mostrarDatos(){
        System.out.println("===DATOS DEL ALUMNO===");
        System.out.println("Legajo: " + this.legajo);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellido: " + this.apellido);
    }

    public void presentarse(){
        System.out.println("Hola Olga, soy " + nombre + " " + apellido + " y mi legajo es " + legajo);
    }
}
