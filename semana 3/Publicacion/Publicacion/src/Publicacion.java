public class Publicacion {
    private String titulo;
    private int anio;
    private boolean disponible;

    public Publicacion(String titulo, int anio){
        this.titulo = titulo;
        this.anio = anio;
        this.disponible = true;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setAnio(int anio){
        this.anio = anio;
    }

    public int getAnio(){
        return this.anio;
    }

    public void setDisponible(boolean disponible){
        this.disponible = disponible;
    }

    public boolean getDisponible(){
        return this.disponible;
    }

    public boolean prestar(){
        if (this.disponible) {  // si esta disponible, entra al if
            System.out.println("Prestando con exito");
            this.disponible = false;
        }
        else {
            System.out.println("No se encuentra disponible");
        }
        return false;
    }

    public void devolver(){
        this.disponible = true;
    }

    public boolean estaDisponible(){
        System.out.println("El titulo " + (this.disponible ? " esta disponible" : " no esta disponible"));
        return disponible;
    }

    public void mostrarInfo(){
        System.out.println("Titulo: " + titulo);
        System.out.println("Anio: " + anio);
        System.out.println("Disponible: " + disponible);
    }

    
}
