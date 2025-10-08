public class Viento extends Instrumento{
    private String material;

    //Constructor con herencia + material
    public Viento (String nombre, String marca, double precio, String material){
        super(nombre, marca, precio);
        this.material = material;
    }

    //get y set del nuevo atributo
    public void setMaterial (String material){
        this.material = material;
    }

    public String getMaterial(){
        return this.material;
    }

    //Se sobreescribe tocar y mostrarInfo de Instrumento
    @Override
    public void tocar(){
        System.out.println("Tocando " + getNombre() + " de " + material);
    }

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Material: " + material); // se agrega el atributo propio de la clase
    }

    

}
