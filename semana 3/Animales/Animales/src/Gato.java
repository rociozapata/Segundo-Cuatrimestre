public class Gato extends Animal{
    private String color;

    /* Constructor completo */
    public Gato (String nombre, String especie, int edad, String color){
        super(nombre, especie, edad);
        this.color = color;
    }

    /* Constructor basico */
    
    public Gato (String nombre, String especie){
        super(nombre, especie);
    }

    @Override
    public void emitirSonido(){
        System.out.println("Miau Miau");
    }

    public void ronronear(){
        System.out.println("El gato " + nombre + " de color " + color +  " esta ronroneando");
    }

}
