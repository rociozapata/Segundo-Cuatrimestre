public class Libro extends Publicacion {
    private String autor;
    private int paginas;

    public Libro (String titulo, int anio, String autor, int paginas){
        super(titulo, anio);
        this.autor = autor;
        this.paginas = paginas;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public String getAutor(){
        return this.autor;
    }

    public void setPaginas(int paginas){
        this.paginas = paginas;
    }

    public int getPaginas(){
        return this.paginas;
    }

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Autor: " + autor);
        System.out.println("Paginas: " + paginas);
    }


}
