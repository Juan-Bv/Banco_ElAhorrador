package elahorrador;

// Profesor, esta clase implementa la interfaz CuentaBase,
// por eso está obligada a definir todos sus métodos.
public class MiCuenta implements CuentaBase {

    // Profesor, los atributos son privados para aplicar encapsulamiento.
    private double saldo;
    private String titular;
    private String numeroCuenta;

    public MiCuenta(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
        this.numeroCuenta = generarNumeroCuenta();
    }

    public MiCuenta(String titular, double saldoInicial) {
        this.titular = titular;
        // Profesor, se valida que el saldo inicial no sea negativo.
        this.saldo = saldoInicial < 0 ? 0.0 : saldoInicial;
        this.numeroCuenta = generarNumeroCuenta();
    }

    // Profesor, este metodo genera un número de cuenta único usando el tiempo del sistema.
    private String generarNumeroCuenta() {
        return "CTA-" + System.currentTimeMillis();
    }

    @Override
    public double saldo() { return saldo; }

    @Override
    public void actualizarSaldo(double nuevoSaldo) { this.saldo = nuevoSaldo; }

    @Override
    public String titular() { return titular; }

    @Override
    public String numeroCuenta() { return numeroCuenta; }

    @Override
    public String toString() {
        return "Cuenta: " + numeroCuenta + " | Titular: " + titular + " | Saldo: $" + saldo;
    }
}