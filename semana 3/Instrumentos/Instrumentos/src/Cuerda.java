public class Cuerda extends Instrumento {
    private int numeroCuerdas;

    //Constructor con el super + nuevo atributo
    public Cuerda (String nombre, String marca, double precio, int numeroCuerdas){
        super(nombre, marca, precio);
        this.numeroCuerdas = numeroCuerdas;
    }

    // get y set de cuerdas
    public void setNumeroCuerdas(int numeroCuerdas){
        this.numeroCuerdas = numeroCuerdas;
    }

    public int getNumeroCuerdas(){
        return this.numeroCuerdas;
    }

    // Sobreescribo los metodos tocar y mostrarInfo
    @Override
    public void tocar() throws InstrumentoApagadoExcepcion {
        System.out.println("Tocando las " + numeroCuerdas + " cuerdas de " + getNombre());
        }
        
     @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Numero de cuerdas: " + numeroCuerdas);
    }

}

   
