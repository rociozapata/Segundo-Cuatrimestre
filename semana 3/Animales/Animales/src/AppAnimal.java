
public class AppAnimal {
    public static void main(String[] args) {
        
        Perro perroCompleto = new Perro("Atila", "Perro", 11, "mestizo");
        Perro perroSimple = new Perro("Gaia", "perro");

        Gato gatoCompleto = new Gato("Quiron", "gato", 4, "gris con rayas negras");
        Gato gatoSimple = new Gato ("Pispi", "gato");

        System.out.println(perroCompleto);
        System.out.println();
        System.out.println(perroSimple);
        System.out.println();
        System.out.println(gatoCompleto);
        System.out.println();
        System.out.println(gatoSimple);
        System.out.println();

        gatoSimple.emitirSonido();
        System.out.println();
        perroSimple.emitirSonido();
        System.out.println();
        gatoCompleto.ronronear();
        System.out.println();
        perroCompleto.jugar();
        System.out.println();



        
    }
}
