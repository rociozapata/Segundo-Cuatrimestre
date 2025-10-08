public class TecladoElectrico extends Instrumento implements Electrico{
    private int numeroTeclas;
    private boolean encendido;

    //Constructor
    public TecladoElectrico (String nombre, String marca, double precio, int numeroTeclas, boolean encendido){
        super(nombre, marca, precio);
        this.numeroTeclas = numeroTeclas;
        this.encendido = encendido;
    }

        //getters y setters
    public void setNumeroTeclas(int numeroTeclas) {
        this.numeroTeclas = numeroTeclas;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }
    public int getNumeroTeclas() {
        return numeroTeclas;
    }
    public boolean getEncendido() {
        return encendido;
    }

    @Override
    public void tocar() throws InstrumentoApagadoExcepcion {
        if (encendido) {
            System.out.println("Tocando teclado de " + numeroTeclas + " teclas...");
        }
        else {
           throw new InstrumentoApagadoExcepcion ("No se puede tocar " + getNombre() + " porque esta apagado");
        }
    }

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Numero de teclas: " + numeroTeclas);
        System.out.println("Encendido: " + encendido);
    }

    /* Aqui se implementan y sobreescriben los metodos de la interface electrico  */
    @Override
    public void encender(){
        System.out.println("Encendiendo el teclado " + getMarca() + " ...");
        this.encendido = true;
    }

    @Override
    public void apagar(){
        System.out.println("Apagando el teclado " + getMarca() + " ...");
        this.encendido = false;
    }

    @Override
    public boolean estaEncendido(){
        System.out.println("El teclado " + getMarca() + " está : " + (encendido ? "Encendido" : "Apagado"));
        return encendido;
    }
}
