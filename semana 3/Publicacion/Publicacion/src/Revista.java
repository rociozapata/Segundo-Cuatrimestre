public class Revista extends Publicacion {
    private int numero;
    private String mes;

    public Revista (String titulo, int anio, int numero, String mes){
        super(titulo, anio);
        this.numero = numero;
        this.mes = mes;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }   

    public int getNumero(){
        return this.numero;
    }

    public void setMes(String mes){
        this.mes = mes;
    }

    public String getMes(){
        return this.mes;
    }

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Numero: " + numero);
        System.out.println("Mes: " + mes);
    }

}
