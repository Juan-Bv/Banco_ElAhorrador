package elahorrador;

public class Consulta {

    private CuentaBase cuenta;

    public Consulta(CuentaBase cuenta) {
        this.cuenta = cuenta;
    }

    // Profesor, este metodo le pregunta a la cuenta cuánto tiene de saldo y lo retorna.
    // No modifica nada, solo consulta.
    public double obtenerSaldo() {
        return cuenta.saldo();
    }
}
