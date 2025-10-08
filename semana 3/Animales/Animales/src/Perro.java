public class Perro extends Animal{
    private String raza;

    /* Constructor completo */
    public Perro (String nombre, String especie, int edad){
        super(nombre, especie, edad);
        this.raza = raza;
    }

    /* Constructor basico  */
     public Perro(String nombre, String especie) {
        super(nombre, especie);
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public void emitirSonido(){
        System.out.println("Guau Guau");
    }

    public void jugar(){
        System.out.println("El perro " + nombre + " esta jugando");
    }


    

}
