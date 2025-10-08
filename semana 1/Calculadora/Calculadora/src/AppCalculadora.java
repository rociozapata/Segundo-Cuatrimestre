import java.util.Scanner;

public class AppCalculadora {
    public static void main(String[] args) throws Exception {
        System.out.println("=== CALCULADORA ===");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un entero a la calculadora");
        int num1 = scanner.nextInt();    

        System.out.println("Ingrese un entero a la calculadora");
        int num2 = scanner.nextInt();

        scanner.close();

        Calculadora calculadora1 = new Calculadora();

        calculadora1.sumar(num1, num2);

        calculadora1.restar(num1, num2);
        calculadora1.multiplicar(num1, num2);
        calculadora1.dividir(num1, num2);

    }
}
