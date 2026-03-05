package elahorrador;

public class Retiro {

    private CuentaBase cuenta;

    public Retiro(CuentaBase cuenta) {
        this.cuenta = cuenta;
    }

    public boolean retirar(double monto) {
        // Profesor, se valida que el monto sea válido y que haya saldo suficiente.
        if (monto <= 0) {
            System.out.println("El monto a retirar debe ser mayor a cero.");
            return false;
        }
        if (monto > cuenta.saldo()) {
            System.out.println("Saldo insuficiente. Saldo actual: $" + cuenta.saldo());
            return false;
        }
        cuenta.actualizarSaldo(cuenta.saldo() - monto);
        System.out.println("Retiro exitoso de $" + monto + " | Nuevo saldo: $" + cuenta.saldo());
        return true;
    }
}
