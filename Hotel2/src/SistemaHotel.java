import java.util.ArrayList;
import java.util.HashMap;

public class SistemaHotel {
    private HashMap<String, Reserva> reservas;  //codigoReserva, reserva
    private HashMap<Integer, String> ocupadas;  //numeroHab, codigoReserva
    private final static Integer total_habitaciones = 50;

    //constructor que inicializa dos nuevos hashmaps vacios
    public SistemaHotel(){
        this.reservas = new HashMap<>();
        this.ocupadas = new HashMap<>();
    }

    public void agregarReserva(Reserva reserva) throws Exception{
        if (ocupadas.containsKey(reserva.getNumeroHabitacion())) {
            throw new IllegalStateException ("La habitacion ya esta ocupada");
        }
        //Si la hab esta libre, crea la reserva
        reservas.put(reserva.getCodigoReserva(), reserva);
        ocupadas.put(reserva.getNumeroHabitacion(),reserva.getCodigoReserva());
        System.out.println("La reserva fue agregada con exito!");
        System.out.println();
    }

    public void confirmarReserva(String codigoReserva) throws ReservaNoEncontradaException{
        Reserva confirmar = buscarReservaPorCodigo(codigoReserva); // busca la reserva 
        confirmar.setEstadoReserva(EstadoReserva.CONFIRMADA); //cambia estado 
        System.out.println("La RESERVA " + codigoReserva + " fue confirmada. (Habitacion "+ confirmar.getNumeroHabitacion()+ "ocupada)");
        System.out.println();
    }

    public void hacerCheckIn(String codigoReserva) throws ReservaNoEncontradaException{
        Reserva confirmar = buscarReservaPorCodigo(codigoReserva); // ASIGNO LO QUE RETORNA EL METODO BUSCAR
        confirmar.setEstadoReserva(EstadoReserva.CHECK_IN); // setteo nuevo estado
        ocupadas.put(confirmar.getNumeroHabitacion(), confirmar.getCodigoReserva());
        System.out.println("✓ CHECK-IN realizado para RESERVA " + codigoReserva);
        System.out.println();
    }

    public void hacerCheckOut(String codigoReserva) throws ReservaNoEncontradaException{
        Reserva liberar = buscarReservaPorCodigo(codigoReserva); //asigno la reserva buscada a una nueva reserva aux
        liberar.setEstadoReserva(EstadoReserva.CHECK_OUT); // setteo el nuevo estado
        ocupadas.remove(liberar.getNumeroHabitacion()); // remuevo de ocupadas la reserva
        System.out.println("✓ Check-out realizado. (Habitacion " + liberar.getNumeroHabitacion() + " liberada)");
        System.out.println();
    }

    public void cancelarReserva(String codigoReserva) throws ReservaNoEncontradaException{
        Reserva liberar = buscarReservaPorCodigo(codigoReserva); //asigno la reserva buscada a una nueva reserva aux
        liberar.setEstadoReserva(EstadoReserva.CANCELADA); // setteo el nuevo estado
        ocupadas.remove(liberar.getNumeroHabitacion()); // remuevo de ocupadas la reserva
        System.out.println("✓ Reserva " + codigoReserva + " cancelada (Habitación " + liberar.getNumeroHabitacion() + " liberada)");
        reservas.remove(codigoReserva);
        System.out.println();
    }

    public Reserva buscarReservaPorCodigo(String codigoReserva) throws ReservaNoEncontradaException{
        if(!reservas.containsKey(codigoReserva)){
            throw new ReservaNoEncontradaException("La reserva [" + codigoReserva + "] no fue encontrada");
        }
        return reservas.get(codigoReserva);
    }

    public ArrayList<Reserva> obtenerReservasPorEstado(EstadoReserva estado){
        ArrayList<Reserva> lista = new ArrayList<>();
        for (Reserva r : reservas.values()) {
            if (r.getEstado() == estado) {
                lista.add(r);
            }
        }
        return lista;    
    }

    public String generarReporteOcupacional(){
        int total_reservas = reservas.size();
        int total_ocupadas = ocupadas.size();
        double porcentaje_ocupadas = ((total_ocupadas * 100) / total_habitaciones);
        return "Total Reservas : [" + total_reservas + "]\nHabitaciones Ocupadas: [" + total_ocupadas + "]\nOcupacion: [" + porcentaje_ocupadas +"]%\n"; 
    }
}
