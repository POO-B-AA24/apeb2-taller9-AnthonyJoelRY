package problema4_Trabajador;
import java.util.ArrayList;

// Clase abstracta Trabajador
abstract class Trabajador {
    protected String nombre;
    protected String apellidos;
    protected String direccion;
    protected String dni;

    // Constructor
    public Trabajador(String nombre, String apellidos, String direccion, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.dni = dni;
    }

    // Método abstracto para calcular el sueldo
    public abstract double calcularSueldo();
}

// Clase FijoMensual
class FijoMensual extends Trabajador {
    private double salarioMensual;

    // Constructor
    public FijoMensual(String nombre, String apellidos, String direccion, String dni, double salarioMensual) {
        super(nombre, apellidos, direccion, dni);
        this.salarioMensual = salarioMensual;
    }

    // Implementación del método abstracto calcularSueldo
    @Override
    public double calcularSueldo() {
        return salarioMensual;
    }
}

// Clase Comisionista
class Comisionista extends Trabajador {
    private double porcentajeComision;
    private double ventasRealizadas;

    // Constructor
    public Comisionista(String nombre, String apellidos, String direccion, String dni, double porcentajeComision, double ventasRealizadas) {
        super(nombre, apellidos, direccion, dni);
        this.porcentajeComision = porcentajeComision;
        this.ventasRealizadas = ventasRealizadas;
    }

    // Implementación del método abstracto calcularSueldo
    @Override
    public double calcularSueldo() {
        return porcentajeComision * ventasRealizadas;
    }
}

// Clase PorHoras
class PorHoras extends Trabajador {
    private double precioHora;
    private int horasNormales;
    private int horasExtra;

    // Constructor
    public PorHoras(String nombre, String apellidos, String direccion, String dni, double precioHora, int horasNormales, int horasExtra) {
        super(nombre, apellidos, direccion, dni);
        this.precioHora = precioHora;
        this.horasNormales = horasNormales;
        this.horasExtra = horasExtra;
    }

    // Implementación del método abstracto calcularSueldo
    @Override
    public double calcularSueldo() {
        double sueldo = horasNormales * precioHora;
        if (horasExtra > 0) {
            sueldo += horasExtra * (precioHora * 1.5); // Suponiendo un 50% más por horas extra
        }
        return sueldo;
    }
}

// Clase Jefe
class Jefe extends Trabajador {

    // Constructor
    public Jefe(String nombre, String apellidos, String direccion, String dni) {
        super(nombre, apellidos, direccion, dni);
    }

    // Implementación del método abstracto calcularSueldo
    @Override
    public double calcularSueldo() {
        return 10000; // Sueldo fijo para el jefe (ejemplo)
    }
}

// Clase SistemaNomina
class SistemaNomina {
    private ArrayList<Trabajador> trabajadores;

    // Constructor
    public SistemaNomina() {
        this.trabajadores = new ArrayList<>();
    }

    // Método para agregar un trabajador al sistema de nómina
    public void agregarTrabajador(Trabajador trabajador) {
        trabajadores.add(trabajador);
    }

    // Método para calcular y mostrar la nómina de todos los trabajadores
    public void calcularNomina() {
        for (Trabajador trabajador : trabajadores) {
            double sueldo = trabajador.calcularSueldo();
            System.out.printf("Nomina para %s %s: %.2f%n", trabajador.nombre, trabajador.apellidos, sueldo);
        }
    }
}

// Clase principal para probar el sistema de nómina
public class Main {
    public static void main(String[] args) {
        // Crear una instancia del sistema de nómina
        SistemaNomina sistema = new SistemaNomina();

        // Agregar algunos trabajadores de ejemplo
        sistema.agregarTrabajador(new FijoMensual("Juan", "Perez", "Av. Principal 123", "12345678A", 3000));
        sistema.agregarTrabajador(new Comisionista("Ana", "Gomez", "Calle Secundaria 456", "87654321B", 0.1, 50000));
        sistema.agregarTrabajador(new PorHoras("Carlos", "Lopez", "Plaza Mayor 789", "13579246C", 15, 40, 5));
        sistema.agregarTrabajador(new Jefe("Maria", "Martinez", "Paseo Grande 001", "98765432D"));

        // Calcular y mostrar la nómina
        sistema.calcularNomina();
    }
}
