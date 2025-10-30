package Servicio;

public class Validador {
  public static boolean validarStrings(String t) {
    return t != null && !t.isEmpty();
  }
}
// retorna true si el titulo no es nulo y si no esta vacio