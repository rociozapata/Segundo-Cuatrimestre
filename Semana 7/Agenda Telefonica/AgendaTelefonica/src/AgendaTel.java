
import java.util.HashMap;

public class AgendaTel {
    private HashMap <String, String> contactos;

    /*Constructor */
    public AgendaTel(){
        this.contactos = new HashMap<>(); //se construye con un nuevo hashmap declarado previamente
    }

    public void agregarContacto(String nombre, String telefono) throws AgendaException{
        //verifica si el nombre esta vacio
        if(nombre.isEmpty()){
            throw new AgendaException("El nombre no puede estar vacio. Ingrese un nombre");
        }

        //verificar que el telefono tenga como minimo 7 digitos
        if(telefono.length() < 7){
            throw new AgendaException("El telefono no puede tener menos de 7 digitos");
        }

        //verificar si ya existe la clave
        if(contactos.containsKey(nombre)){
            throw new AgendaException("Este nombre ya existe en la agenda. No se permiten nombres duplicados");
        }
        // si llega aca es porq cumple todas las condiciones
        contactos.put(nombre.toLowerCase(), telefono);
        System.out.println("El contacto fue agregado a la agenda");

    }

    public void buscarTelefonoPorNombre(String nombreBuscado) throws AgendaException {
        // containskey devuelve true, con el signo ! busco el false. sui esta en false se lanza la excepcion
        if (!contactos.containsKey(nombreBuscado.toLowerCase())) {
                throw new AgendaException("El nombre buscado no existe en la agenda");
        }
            //el get me trae el valor de nombreBuscado
            String telefono = contactos.get(nombreBuscado.toLowerCase());
            System.out.println("Contacto: " + nombreBuscado + " *Telefono: " + telefono);       
        }
    
    public void eliminarContacto(String nombreBuscado) throws AgendaException{
        if(!contactos.containsKey(nombreBuscado)){ // mismo if que buscartelef
            throw new AgendaException("El contacto a elimiar no existe en la agenda");
        }
        String eliminar = contactos.remove(nombreBuscado); // asigno a una variable el eliminado para luego mostrarlo
        System.out.println("Contacto eliminado: " + eliminar);
    }

    public void mostrarContactos(){
        System.out.println("# LISTA CONTACTOS #");
        for(String nombre : contactos.keySet()){  // por cada nombre de tipo string contenido en contactos hago
            String telef = contactos.get(nombre);   //obtengo el valor de cada clave y la guardo en una aux
            System.out.println("[Contacto]: " + nombre + "=> telefono: " + telef); // muestro clave y valor
            System.out.println("----------------------------------------------");
        }
    }



}
