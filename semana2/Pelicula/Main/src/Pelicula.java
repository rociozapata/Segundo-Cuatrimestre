public class Pelicula {
    private String titulo;
    private String director;
    private int duracion;
    private boolean vista;

    // constructor completo
    public Pelicula(String titulo, String director, int duracion, boolean vista) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.vista = vista;
    }

    // constructor sin estado
    public Pelicula(String titulo, String director, int duracion) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
    }

    // constructor basico
    public Pelicula(String titulo, String director) {
        this.titulo = titulo;
        this.director = director;
    }

    // getters y setters
    public void setTitulo(String titulo) {
        if (titulo.isEmpty() || titulo == null){
            this.titulo = "El titulo no puede estar vacio";
            return;
        }
        this.titulo = titulo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDuracion(int duracion) {
        if (duracion < 0) {
            System.out.println("La duracion debe ser mayor a 0 minutos");
            this.duracion = duracion;
        }
    }

    public int getDuracion() {
        return this.duracion;
    }

    public void setVista(boolean vista) {
        this.vista = vista;
    }

    public boolean getVista() {
        return this.vista;
    }

    public void marcarComoVista() {
        this.vista = true;
    }

    @Override
    public String toString() {
        return "Pelicula \nTitulo:" + this.titulo + " \nDirector:" + this.director +" \nDuracion: " + this.duracion +" \nVista: " + this.vista +"\n";}
    }


