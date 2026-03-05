package elahorrador;

// Profesor, esta interfaz funciona como un contrato: cualquier clase que la implemente
// está obligada a definir estos métodos.
public interface CuentaBase {

    double saldo();
    void actualizarSaldo(double nuevoSaldo);
    String titular();
    String numeroCuenta();
    String toString();
}
