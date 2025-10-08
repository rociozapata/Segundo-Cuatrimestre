public class Instrumento {
    private String nombre;
    private String marca; 
    private double precio;

    //constructor completo 
    public Instrumento (String nombre, String marca, double precio){
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
    }

    //getters y setters
    public void setNombre (String nombre){
        this.nombre = nombre;
    }

    public void setMarca (String marca){
        this.marca = marca;
    }

    public void setPrecio (double precio){
        this.precio =  precio;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getMarca (){
        return this.marca;
    }

    public double getPrecio(){
        return this.precio;
    }

     // Metodo tocar con exception
    public void tocar() throws InstrumentoApagadoExcepcion { // agrego excepcion a la clase padre
        System.out.println("Tocando " + nombre + " de la marca " + marca);
    }

    // Metodo afinar
    public void afinar(){
        System.out.println("Afinando " + nombre + " ...");
    }

    @Override
    public String toString() {
        return "Instrumento: " + nombre + " Marca: " + marca + " Precio: $" + precio;
    }

    public void mostrarInfo(){
        System.out.println("----- INSTRUMENTO -----");
        System.out.println("Nombre: " + nombre);
        System.out.println("Marca: " + marca);
        System.out.println("Precio: $" + precio);
    }
}
