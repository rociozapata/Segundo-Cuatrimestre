import java.util.EnumMap;
import java.util.HashMap;

public class SistemaEnvio {

    private HashMap <String, Paquete> paquetes;
    private static final double PRECIO_POR_KG = 5.0;
    private static final double RECARGO_EXPRESO = 10.0;

    public SistemaEnvio (){
        this.paquetes = new HashMap<>();
    }

    public void registrarPaquete(Paquete pack){
        paquetes.put(pack.getCodigo(), pack);
    }

    public void actualizarEstado(String codigo, EstadoPaquete nuevoEstado) throws PaqueteNoEncontradoException{
        if (!paquetes.containsKey(codigo)) {
            throw new PaqueteNoEncontradoException("El paquete con codigo " + codigo + " no existe en el sistema");
        }
        Paquete cambiar = paquetes.get(codigo); // en cambiar guardo el paquete a cambiar el estado
        cambiar.setEstado(nuevoEstado); // cambio el estado con el setter
        System.out.println("El nuevo estado del paquete " + codigo + " es " + nuevoEstado);
    }

    public Double calcularCosto(String codigo, boolean expreso) throws PaqueteNoEncontradoException {
        if (!paquetes.containsKey(codigo)) {
            throw new PaqueteNoEncontradoException("El paquete con codigo " + codigo + " no existe en el sistema");
        }
        Paquete calcular = paquetes.get(codigo); // asigno el paquete para poder acceder a sus atributos
        double costo = 0;
        if (expreso) {
            costo = (calcular.getPeso() * PRECIO_POR_KG) + RECARGO_EXPRESO;
        } else {
            costo = (calcular.getPeso() * PRECIO_POR_KG);
        }
        return costo;
    }

    public EnumMap agruparPaquetesPorEstado(){
        EnumMap <EstadoPaquete, Integer> agrupados = new EnumMap<>(EstadoPaquete.class);

        for (Paquete p : paquetes.values()) {
            agrupados.put(p.getEstado(), agrupados.getOrDefault(p.getEstado(), 0) + 1);
        }
        return agrupados;
    }

    public String generarReporte(){
        StringBuilder sb = new StringBuilder();
        int contador = 0;
        for (Paquete p : paquetes.values()) {
            sb.append("Codigo " + p.getCodigo() + " | Destinatario " + p.getDestinatario() + " | Peso " + p.getPeso() + " | Estado " + p.getEstado());
            sb.append("\n");
            contador += 1;
        }
        sb.append("Total de paquetes: " + contador);
        return sb.toString();
    }
}
