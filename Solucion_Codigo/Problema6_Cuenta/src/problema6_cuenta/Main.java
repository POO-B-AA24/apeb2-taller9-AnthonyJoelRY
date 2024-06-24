// Clase principal para representar una cuenta bancaria
class CuentaBancaria {
    protected int numeroCuenta;
    protected String nombreCliente;
    protected double balance;

    // Constructor
    public CuentaBancaria(int numeroCuenta, String nombreCliente) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.balance = 0.0;
    }

    // Método para depositar dinero
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            balance += cantidad;
            System.out.println("Deposito de $" + cantidad + " realizado. Nuevo balance: $" + balance);
        } else {
            System.out.println("Error: La cantidad a depositar debe ser mayor que cero.");
        }
    }

    // Método para retirar dinero
    public void retirar(double cantidad) {
        if (cantidad > 0) {
            if (puedeRetirar(cantidad)) {
                balance -= cantidad;
                System.out.println("Retiro de $" + cantidad + " realizado. Nuevo balance: $" + balance);
            } else {
                System.out.println("Error: Fondos insuficientes para realizar el retiro.");
            }
        } else {
            System.out.println("Error: La cantidad a retirar debe ser mayor que cero.");
        }
    }

    // Método para verificar si se puede realizar el retiro
    public boolean puedeRetirar(double cantidad) {
        return balance >= cantidad;
    }

    // Método para obtener el balance actual
    public double getBalance() {
        return balance;
    }

    // Método para imprimir el estado de la cuenta
    public void imprimirEstado() {
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Balance actual: $" + balance);
    }
}

// Clase para una cuenta de Cheques
class CuentaCheques extends CuentaBancaria {
    // Constructor
    public CuentaCheques(int numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }
}

// Clase para una cuenta de Ahorros
class CuentaAhorros extends CuentaBancaria {
    private double tasaInteres; // Tasa de interés anual

    // Constructor
    public CuentaAhorros(int numeroCuenta, String nombreCliente, double tasaInteres) {
        super(numeroCuenta, nombreCliente);
        this.tasaInteres = tasaInteres;
    }

    // Método para calcular el interés mensual y añadirlo al balance
    public void calcularInteres() {
        double interes = balance * (tasaInteres / 100) / 12; // Interés mensual
        balance += interes;
        System.out.println("Interes mensual calculado y agregado. Nuevo balance: $" + balance);
    }
}

// Clase para una cuenta Platino (tipo especial con 10% de interés)
class CuentaPlatino extends CuentaBancaria {
    private static final double TASA_INTERES_PLATINO = 10.0; // Tasa de interés fija para Cuenta Platino

    // Constructor
    public CuentaPlatino(int numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }

    // Método para calcular el interés mensual y añadirlo al balance
    public void calcularInteres() {
        double interes = balance * (TASA_INTERES_PLATINO / 100) / 12; // Interés mensual
        balance += interes;
        System.out.println("Interes mensual calculado y agregado. Nuevo balance: $" + balance);
    }
}

// Clase de prueba para demostrar el funcionamiento de las cuentas bancarias
public class Main {
    public static void main(String[] args) {
        // Crear cuentas bancarias de ejemplo
        CuentaCheques cuentaCheques = new CuentaCheques(1001, "Juan Perez");
        CuentaAhorros cuentaAhorros = new CuentaAhorros(2001, "Ana Gomez", 5.0);
        CuentaPlatino cuentaPlatino = new CuentaPlatino(3001, "Pedro Martinez");

        // Realizar operaciones en las cuentas
        cuentaCheques.depositar(1500);
        cuentaCheques.retirar(500);
        cuentaCheques.retirar(1200); // Intento de retirar más de lo que hay

        cuentaAhorros.depositar(3000);
        cuentaAhorros.calcularInteres();
        cuentaAhorros.retirar(500);

        cuentaPlatino.depositar(5000);
        cuentaPlatino.calcularInteres();
        cuentaPlatino.retirar(1000);

        // Mostrar estado de las cuentas
        System.out.println("\nEstado de cuenta - Cuenta de Cheques:");
        cuentaCheques.imprimirEstado();

        System.out.println("\nEstado de cuenta - Cuenta de Ahorros:");
        cuentaAhorros.imprimirEstado();

        System.out.println("\nEstado de cuenta - Cuenta Platino:");
        cuentaPlatino.imprimirEstado();
    }
}
