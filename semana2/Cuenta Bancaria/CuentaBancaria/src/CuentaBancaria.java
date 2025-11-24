public class CuentaBancaria {
    private String titular;
    private String numeroCuenta;
    private double saldo;
    private boolean activa;

    //Constructor completo
    public CuentaBancaria (String titular, String numeroCuenta, double saldo, boolean activa){
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.activa = activa;
    }

    //constructor cuenta nueva
    public CuentaBancaria(String titular, String numeroCuenta){
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
        this.activa = true;
    }

    //Constructor cuenta nueva
    public CuentaBancaria (String titular){
        this.titular = titular;
        this.numeroCuenta = "SIN ASIGNAR";
        this.saldo = 0;
        this.activa = false;
    }
    
    // getters y setters
    public void setTitular(String titular){
        if (titular.isEmpty() || titular == null) {
            this.titular = "El campo Titular no puede estar vacio\n";
            return;
        }
        this.titular = titular;
    }

    public String getTitular(){
        return this.titular; 
    }

    public void setNumeroCuenta(String numeroCuenta){
        this.numeroCuenta = numeroCuenta;
    }

    public String getNumeroCuenta(){
        return this.numeroCuenta;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setActiva(boolean activa){
        this.activa = activa;
    }

    public boolean getActiva(){
        return this.activa;
    }

    public void depositar(double monto){
        if (activa && monto > 0) {
            this.saldo = saldo + monto;
        }
        else {
            System.out.println("Esta cuenta esta inactiva. No se permite realizar depositos\n");
        }
    }

    public void extraer(double monto){
        if (activa && saldo >= monto) {
            this.saldo = saldo - monto;
            System.out.println("Extraccion :" + monto + "\n" + "Saldo: " + saldo + "\n");
        }
        if (activa == true && saldo < monto) {
            System.out.println("El saldo no es sufiente para realiar esta operacion\n");
        }
        else {
            System.out.println("La cuenta no esta activa\n");
        } 
    }

    public void activarCuenta(boolean activa){
        this.activa = activa;
    }

    public void desactivarCuenta(boolean activa){
        if (saldo == 0) {
            this.activa = activa;
        }
        else {
            System.out.println("No puede desactivarse la ceunta si aun posee saldo positivo\n");
        }
    }

    public boolean esCuentaVip (){
        boolean vip = false;
        if (saldo > 10000) {
            vip = true;
        }
        else {
            vip = false;
        }
        return vip;
    }
    
    public String getEstadoCuenta(){
        return "Titular: " + titular + "\n" + "Numero Cuenta: " + numeroCuenta + "\n" + "Saldo (USD): " + saldo + "\n" + "Activa: " + activa + "\n" + "Cuenta VIP: " + esCuentaVip(); 
    }

    @Override
    public String toString(){
        return "Titular:" + titular + "\n" + "Numero Cuenta:" + numeroCuenta + "\n" + "Saldo(USD):" + saldo +  "\n" + "Cuenta Activa:" + activa + "\n";        
    }

}
