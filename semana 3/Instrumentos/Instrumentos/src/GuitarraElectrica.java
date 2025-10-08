public class GuitarraElectrica extends Cuerda implements Electrico, Afinable {
    private boolean encendida;
    private boolean afinada;

    //constructor
    public GuitarraElectrica (String nombre, String marca, double precio, int numeroCuerdas, boolean encendida, boolean afianda){
        super(nombre, marca, precio, numeroCuerdas);
        this.encendida = encendida;
        this.afinada = afinada;
    }

    // set y get
    public void setEncendida(boolean encendida){
        this.encendida = encendida;
    }

    public void setAfinada(boolean afinada){
        this.afinada = afinada;
    }

    public boolean getAfinada(){
        return this.afinada;
    }

    public boolean getEncendida(){
        return this.encendida;
    }
  
    @Override
    public void tocar() throws InstrumentoApagadoExcepcion { 
        if (encendida) {
            System.out.println("Tocando las " + getNumeroCuerdas() + " de la " + getNombre() + " que esta " + (encendida ? "Encendida" : "Apagado"));
        }
        else {
           throw new InstrumentoApagadoExcepcion ("No se puede tocar " + getNombre() + " poque esta apagada");
        }
    }

  /*Estas lineas que siguen sobreescriben los metodos de las interfaces Electrico y Afinable */

    @Override
    public void encender(){
        System.out.println("Encendiendo la guitarra " + getMarca());
        this.encendida = true;
    }

    @Override
    public void apagar(){
        System.out.println("Apagando la guitarra " + getMarca());
        this.encendida = false;
    }

    @Override
    public boolean estaEncendido(){
        System.out.println("La guitarra " + getMarca() + " está : " + (encendida ? "Encendido" : "Apagado")); // operador ternario primero true despues false
        return encendida;
    }

    @Override
    public void afinarAutomaticamente(){
        System.out.println("Afinando automaticamente la guitarra " + getMarca());
        this.afinada = true;
    }

    @Override
    public boolean estaAfinado() throws InstrumentoDesafinadoException{ 
        if (!afinada) {
            System.out.println("El instrumento " + getNombre() + " esta desafinado. Debe afinarse primero");
        }
        System.out.println("La guitarra " + getMarca() + " está " + (afinada ? "Afinada" : "Desafinada")); // operador ternario
        return afinada;
    }

}
