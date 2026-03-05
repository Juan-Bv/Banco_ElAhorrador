package elahorrador;

public class Deposito {

    private CuentaBase cuenta;

    public Deposito(CuentaBase cuenta) {
        this.cuenta = cuenta;
    }

    public void depositar(double monto) {
        // Profesor, se valida que el monto sea mayor a cero antes de realizar el depósito.
        if (monto <= 0) {
            System.out.println("El monto a depositar debe ser mayor a cero.");
            return;
        }
        cuenta.actualizarSaldo(cuenta.saldo() + monto);
        System.out.println("Deposito exitoso de $" + monto + " | Nuevo saldo: $" + cuenta.saldo());
    }
}
