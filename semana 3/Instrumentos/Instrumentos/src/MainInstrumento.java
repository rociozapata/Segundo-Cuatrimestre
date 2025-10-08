import java.util.ArrayList;


public class MainInstrumento {
    public static void main(String[] args) {
        

        //Creo dos instrumentos de cuerdas
        Cuerda cuerda1 = new Cuerda("Guitarra", "Fender", 856.524, 6);
        Cuerda cuerda2 = new Cuerda("Bajo ", "Ibanez", 837.499, 4);

        //Creo dos instrumentos de viento
        Viento viento1 = new Viento("Saxo Alto", "Parquer", 805.273, "Latón laqueado");
        Viento viento2 = new Viento("Trompeta", "Yamaha", 1473409.100, "Latón plateado");

        // Creo una nueva guitarra electrica que hereda de Cuerda
        GuitarraElectrica guitarra1 = new GuitarraElectrica("Guitarra Electrica", "Alpugarra", 756.360, 6, true, false);

        // Creo un nuevo teclado electrico que implementa electrico
        TecladoElectrico teclado1 = new TecladoElectrico("Teclado Electrico", "Yamaha", 1100.589, 88, false);

        //crear Arraylist Instrumentos
        ArrayList <Instrumento> orquesta = new ArrayList<>();
        //agrego al final
        orquesta.add(viento2);
        orquesta.add(cuerda1);
        orquesta.add(viento1);
        orquesta.add(cuerda2);
        orquesta.add (teclado1);
        orquesta.add (guitarra1);

        //for each para mostrar info
        System.out.println("* Metodo mostrar info en for each *");
        for (Instrumento instrumento : orquesta) {
            instrumento.mostrarInfo();
            System.out.println();
        }

        //for each para afinar con exception e instance of Afinable
        System.out.println("* Metodo afinar en for each *");
        for (Instrumento instrumento : orquesta ) {
            if (instrumento instanceof Afinable) {
                Afinable afinable = (Afinable) instrumento; //variable local que guarda el instrumento afinable para acceder al try-catch
                try {
                    afinable.afinarAutomaticamente(); // 
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println();

        //for each para tocar con exception declarada en tocar de guitarra electrica y teclado electrico
        System.out.println("* Metodo tocar en for each *");
        for (Instrumento instrumento : orquesta) {
            try {
                instrumento.tocar();
            } catch (InstrumentoApagadoExcepcion e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }

        //for each para encender con instance of Electrico 
        System.out.println(" * Metodo encender con instanceof dentro del for each * ");
        for (Instrumento instrumento : orquesta){
            if (instrumento instanceof Electrico) {
            Electrico e = (Electrico) instrumento ; // variable local que guarda el instrumento electrico para encenderlo
            e.encender();
            System.out.println();
            }         
            
        }

       
    }
}
