package elahorrador;

public class Banco {

    private String nombreBanco;

    public Banco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    // Profesor, estos dos métodos crean una cuenta nueva.
    // El primero la crea con saldo en cero, para cuando el cliente no trae dinero.
    public CuentaBase crearCuenta(String titular) {
        CuentaBase cuenta = new MiCuenta(titular);
        System.out.println("[" + nombreBanco + "] Cuenta creada para: " + titular);
        return cuenta;
    }

    // Profesor, el segundo la crea con un saldo inicial, para cuando el cliente ya llega con dinero.
    // En ambos casos se retorna como CuentaBase, no como MiCuenta, porque el resto del programa
    // solo necesita saber que cumple el contrato de la interfaz.
    public CuentaBase crearCuenta(String titular, double saldoInicial) {
        CuentaBase cuenta = new MiCuenta(titular, saldoInicial);
        System.out.println("[" + nombreBanco + "] Cuenta creada para: " + titular
                + " con saldo inicial de $" + saldoInicial);
        return cuenta;
    }

    // Profesor, este metodo recibe una cuenta y retorna su saldo actual.
    public double obtenerSaldo(CuentaBase cuenta) {
        return cuenta.saldo();
    }

    // Profesor, este metodo retorna el nombre del banco para mostrarlo en pantalla.
    public String getNombreBanco() {
        return nombreBanco;
    }
}