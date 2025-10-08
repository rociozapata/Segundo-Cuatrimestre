public class Calculadora {
    public int num1;
    public int num2;

    //Suma
    public void sumar (int num1, int num2){
        int suma = num1 + num2;
        System.out.println("La suma de los numeros es: " + suma);
    }

    //Resta
    public void restar (int num1, int num2){
        int resta = num1 - num2;
        System.out.println("La resta de los numeros es: " + resta);
    }

    //Multiplicacion
    public void multiplicar (int num1, int num2) {
        int producto = num1 * num2;
        System.out.println("El producto de los numeros es:  " + producto);
    }

    //Division
    public void dividir (int num1, int num2){
        double cociente = num1 / num2;
        System.out.println("El cociente de los numeros es: " + cociente);
    }
}
