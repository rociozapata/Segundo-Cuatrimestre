public class Animal {
    protected String nombre;
    private String especie;
    private int edad;

    //Constructor completo
    public Animal (String nombre, String especie, int edad){
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    //Constructor basico
    public Animal (String nombre, String especie){
        this.nombre = nombre;
        this.especie = especie;
    }
    //getters y setters
    
    public void setNombre (String nombre){
        if (nombre == null) {
            System.out.println("El nombre no puede estar vacio");
        }
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setEspecie (String especie){
        this.especie = especie;
    }

    public String getEspecie (){
        return this.especie;
    }

    public void setEdad (int edad){
        if (edad < 0) {
            System.out.println("La edad no puede ser negativa");
        }
        this.edad = edad;
    }

    public int getEdad(){
        return this.edad;
    }

    public void emitirSonido(){
        System.out.println("Sonido de animal ");
    }

    @Override
    public String toString (){
        return "Animal: [nombre] " + nombre + " " + "[especie] " + especie + " " + "[edad] " + edad;
    }
}
