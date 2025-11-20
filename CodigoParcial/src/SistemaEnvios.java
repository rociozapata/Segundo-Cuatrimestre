import java.util.EnumMap;
import java.util.HashMap;

public class SistemaEnvios {
    private HashMap <String, Package> paquetes; // codigoPaquete, Paquete
    private static final double PRECIO_POR_KG = 5.0;
    private static final double RECARGO_EXPRESO = 10.0;

    public SistemaEnvios(){
        this.paquetes = new HashMap<>();
    }

    //agrego el paquete al hashmap paquetes
    public void registrarPaquete(Package paquete){
        paquetes.put(paquete.getCodigo(), paquete);
    }

    public void actualizarEstado(String codigo, EstadoPaquete nuevoEstado) throws PaqueteNoEncontradoException{
        if(!paquetes.containsKey(codigo)){
            throw new PaqueteNoEncontradoException("El paquete con codigo " + codigo + " no existe");
        }
        Package cambiar = paquetes.get(codigo);
        cambiar.setEstado(nuevoEstado);
        System.out.println("El estado actualizado del paquete " + codigo + " es: " + nuevoEstado);
    }

    public double calcularCosto(String codigo, boolean expreso) throws PaqueteNoEncontradoException {
        double costo; // variable para el retorno

         if(!paquetes.containsKey(codigo)){
            throw new PaqueteNoEncontradoException("El paquete con codigo " + codigo + " no existe");
        }
        Package calcular = paquetes.get(codigo);
        // si expreso esta en true, entra
        if (expreso) {
           costo = (calcular.getPeso() * PRECIO_POR_KG) + RECARGO_EXPRESO;
        } else {
            costo = (calcular.getPeso() * PRECIO_POR_KG);
        }

        return costo;
    }

    public EnumMap agruparPorEstado(){
        //esto crea un enum con todos los estados y sus cantidades encontradas dentro del for
        EnumMap <EstadoPaquete, Integer> agrupadosPorEstado = new EnumMap<>(EstadoPaquete.class);
        
        for (Package pack : paquetes.values()) {
            agrupadosPorEstado.put(pack.getEstado(), (agrupadosPorEstado.getOrDefault(pack.getEstado(), 0) + 1));
        }
        return agrupadosPorEstado;
    }

    public String generarReporte(){
        StringBuilder sb = new StringBuilder();
        int contador = 0;
        for (Package pack : paquetes.values()){
            sb.append("Codigo " + pack.getCodigo() + " | Destinatario " + pack.getDestinatario() + " | Peso " + pack.getPeso() + " | Estado " + pack.getEstado());
            sb.append("\n");
            contador += 1;
        }
        sb.append("Total de paquetes " + contador);

        return sb.toString();
    }
    
}
