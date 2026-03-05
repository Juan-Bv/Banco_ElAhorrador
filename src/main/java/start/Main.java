package start;

import elahorrador.Banco;
import elahorrador.CuentaBase;
import elahorrador.Deposito;
import elahorrador.Retiro;
import elahorrador.Consulta;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Profesor, Scanner permite leer los datos que el usuario escribe por consola.
    static Scanner scanner = new Scanner(System.in);

    // Profesor, se crea el objeto banco con el nombre del banco.
    static Banco banco = new Banco("El Ahorrador");

    // Profesor, se usa un ArrayList para almacenar todas las cuentas creadas durante la sesión.
    static ArrayList<CuentaBase> cuentas = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("     Bienvenido a " + banco.getNombreBanco());
        System.out.println("========================================");

        int opcion;

        // Profesor, este ciclo do-while mantiene el menú activo hasta que el usuario elija salir.
        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Abrir cuenta");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Consultar saldo");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            // Profesor, el switch redirige al metodo correspondiente según la opción elegida.
            switch (opcion) {
                case 1 -> abrirCuenta();
                case 2 -> depositar();
                case 3 -> retirar();
                case 4 -> consultarSaldo();
                case 5 -> System.out.println("\nHasta luego. Gracias por usar " + banco.getNombreBanco() + "!");
                default -> System.out.println("Opcion invalida. Intenta de nuevo.");
            }

        } while (opcion != 5);
    }

    // Profesor, este metodo solicita los datos del titular y crea la cuenta en el banco.
    static void abrirCuenta() {
        System.out.print("\nNombre del titular: ");
        String titular = scanner.nextLine();

        System.out.print("Desea agregar un saldo inicial? (si/no): ");
        String respuesta = scanner.nextLine();

        CuentaBase cuenta;

        // Profesor, dependiendo de la respuesta se crea la cuenta con o sin saldo inicial.
        if (respuesta.equalsIgnoreCase("si")) {
            System.out.print("Saldo inicial: $");
            double saldoInicial = scanner.nextDouble();
            scanner.nextLine();
            cuenta = banco.crearCuenta(titular, saldoInicial);
        } else {
            cuenta = banco.crearCuenta(titular);
        }

        // Profesor, la cuenta creada se agrega a la lista para poder usarla después.
        cuentas.add(cuenta);
        System.out.println("Numero de cuenta: " + cuenta.numeroCuenta());
    }

    // Profesor, este metodo solicita el monto y ejecuta el depósito sobre la cuenta elegida.
    static void depositar() {
        CuentaBase cuenta = seleccionarCuenta();
        if (cuenta == null) return;

        System.out.print("Monto a depositar: $");
        double monto = scanner.nextDouble();
        scanner.nextLine();

        Deposito deposito = new Deposito(cuenta);
        deposito.depositar(monto);
    }

    // Profesor, este metodo solicita el monto y ejecuta el retiro sobre la cuenta elegida.
    static void retirar() {
        CuentaBase cuenta = seleccionarCuenta();
        if (cuenta == null) return;

        System.out.print("Monto a retirar: $");
        double monto = scanner.nextDouble();
        scanner.nextLine();

        Retiro retiro = new Retiro(cuenta);
        retiro.retirar(monto);
    }

    // Profesor, este metodo consulta y muestra el saldo de la cuenta seleccionada.
    static void consultarSaldo() {
        CuentaBase cuenta = seleccionarCuenta();
        if (cuenta == null) return;

        Consulta consulta = new Consulta(cuenta);
        System.out.println("Saldo actual de " + cuenta.titular() + ": $" + consulta.obtenerSaldo());
    }

    // Profesor, este metodo lista las cuentas y retorna la que el usuario elija.
    static CuentaBase seleccionarCuenta() {
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas registradas. Primero abre una cuenta.");
            return null;
        }

        System.out.println("\n--- SELECCIONA UNA CUENTA ---");
        for (int i = 0; i < cuentas.size(); i++) {
            System.out.println((i + 1) + ". " + cuentas.get(i).titular()
                    + " | " + cuentas.get(i).numeroCuenta());
        }
        System.out.print("Numero de cuenta: ");

        // Profesor, se resta 1 porque el usuario ve la lista desde 1, pero el arreglo empieza en 0.
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indice < 0 || indice >= cuentas.size()) {
            System.out.println("Seleccion invalida.");
            return null;
        }

        return cuentas.get(indice);
    }
}