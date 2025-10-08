public class Libro2 {
    private String titulo;
    private String autor;
    private int copias;

    public Libro2 (String titulo, String autor, int copias) {
        this.titulo = titulo;
        this.autor = autor;
        this.copias = copias;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setAutor (String autor){
        this.autor = autor;
    }

    public String getAutor(){
        return this.autor;
    }

    public void setCopias(int copias){
        this.copias = copias;
    }

    public int getCopias(){
        return this.copias;
    }

    @Override
    public String toString(){
        return "*Titulo : " + titulo + " *Autor: " + autor + " *Copias disponibles: " + copias + "\n";
    }


}
