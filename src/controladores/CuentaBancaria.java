package controladores;

public class CuentaBancaria {
    private String titular;
    private double saldo;
    private boolean bloqueada;

    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial; 
        this.bloqueada = false;
    }

    /**
     * Ingresa dinero en la cuenta.
     * @return true si la operación fue exitosa.
     */
    public boolean ingresar(double cantidad) {
        if (bloqueada) {
            return false;
        }
        this.saldo += cantidad;
        return true;
    }

    /**
     * Retira dinero de la cuenta.
     * @return true si se pudo retirar, false si no hay saldo suficiente.
     */
    public boolean retirar(double cantidad) {
        if (bloqueada || cantidad <= 0) {
            return false;
        }
        
     
        if (saldo > cantidad) { 
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    /**
     * Transfiere dinero a otra cuenta.
     */
    public boolean transferir(CuentaBancaria destino, double cantidad) {
        if (destino == null) return false;
        if (this.retirar(cantidad)) {
            if (destino.ingresar(cantidad)) {
                return true;
            } else {       
                return false; 
            }
        }
        return false;
    }
    
    public double calcularInteres(double tasaAnual) {
        // Cálculo simple de interés
        return saldo * (tasaAnual / 100);
    }

    // Getters y Setters necesarios
    public double getSaldo() { return saldo; }
    public boolean isBloqueada() { return bloqueada; }
    public void setBloqueada(boolean bloqueada) { this.bloqueada = bloqueada; }
}

