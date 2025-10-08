public class Videojuego {
    private String nombre;
    private String genero;

    public Videojuego (String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    @Override
    public String toString(){
        return "Videojuego: nombre-->" + nombre + " // genero -->" + genero;
    }
}
