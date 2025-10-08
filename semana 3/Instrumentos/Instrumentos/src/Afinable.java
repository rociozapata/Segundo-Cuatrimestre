public interface Afinable {

    void afinarAutomaticamente();
    boolean estaAfinado() throws InstrumentoDesafinadoException; // agrego excepcion a la interface 
}
