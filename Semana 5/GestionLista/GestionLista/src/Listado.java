import java.util.ArrayList;

public class Listado {
    private ArrayList <Lista> listado;

    public Listado ( ArrayList <Lista> listado){
        this.listado = listado;
    }
    
    public void mostrarListado(){
        for (Lista lista : listado){
        System.out.println(lista);
        System.out.println();
        }
    }
}
