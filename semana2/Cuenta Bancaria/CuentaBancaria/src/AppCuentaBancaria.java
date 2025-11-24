import java.util.Scanner;

public class AppCuentaBancaria {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        /* Crea cuenta bancaria completa */
        CuentaBancaria cuenta1 = new CuentaBancaria("Rocio Zapata", "36283347000", 150000.36, true);

        /* Crea cuenta bancaria basico */
        CuentaBancaria cuenta2 = new CuentaBancaria("Victor Perroud");

        /* Crear cuenta bancaria nueva */
        CuentaBancaria cuenta3 = new CuentaBancaria("Pilar Zapata", "3378523160");
        CuentaBancaria cuenta4 = new CuentaBancaria("Danisa Tristan", "4857932666");

        cuenta2.activarCuenta(true);
        cuenta2.depositar(480000);

        cuenta1.extraer(50000);
        System.out.println("La cuenta es vip: " + cuenta1.esCuentaVip());
        cuenta1.getEstadoCuenta();

        cuenta3.setActiva(true);
        cuenta3.depositar(300);
        cuenta3.getEstadoCuenta();

        cuenta4.setActiva(false);
        cuenta4.depositar(200);

        System.out.println(cuenta1);
        System.out.println(cuenta2);
        System.out.println(cuenta3);
        System.out.println(cuenta4);

        scanner.close();
    }
}
