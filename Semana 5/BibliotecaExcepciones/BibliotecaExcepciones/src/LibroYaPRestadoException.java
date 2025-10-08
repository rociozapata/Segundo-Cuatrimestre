public class LibroYaPRestadoException extends RuntimeException { // cuando extiende de RunTimeExcepcion siempre
                                                                 // va con try - catch
    public LibroYaPRestadoException (String mensaje){
        super(mensaje);
    }

}
//Se abre una nueva clase, se declara la excepcion. que extiende de Exception (todas), para mas especificacion
//puede extender de RunTimeException y dentro de la Excepcion se escribe el constructor con un mensaje de alerta
// Cuando incorporemos esta Excepcion a algun metodo, podemos personalizar el mensaje