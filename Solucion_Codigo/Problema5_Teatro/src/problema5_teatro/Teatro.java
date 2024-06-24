package problema5_teatro;

import java.util.HashMap;

// Clase Zona que representa cada área del teatro
class Zona {

    private String nombre;
    private int numeroLocalidades;
    private double precioNormal;
    private double precioAbonado;
    private int localidadesVendidas;

    public Zona(String nombre, int numeroLocalidades, double precioNormal, double precioAbonado) {
        this.nombre = nombre;
        this.numeroLocalidades = numeroLocalidades;
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
        this.localidadesVendidas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroLocalidades() {
        return numeroLocalidades;
    }

    public double getPrecioNormal() {
        return precioNormal;
    }

    public double getPrecioAbonado() {
        return precioAbonado;
    }

    public int getLocalidadesVendidas() {
        return localidadesVendidas;
    }

    public void setLocalidadesVendidas(int localidadesVendidas) {
        this.localidadesVendidas = localidadesVendidas;
    }

    public boolean hayEspacioDisponible() {
        return localidadesVendidas < numeroLocalidades;
    }
}

// Clase Entrada que representa cada entrada vendida
class Entrada {

    private static int contadorEntradas = 1;

    private int identificador;
    private String nombreEspectador;
    private String tipoEntrada; // "Normal", "Abonado", "Reducida"
    private double precio;
    private Zona zona;

    public Entrada(String nombreEspectador, String tipoEntrada, double precio, Zona zona) {
        this.identificador = contadorEntradas++;
        this.nombreEspectador = nombreEspectador;
        this.tipoEntrada = tipoEntrada;
        this.precio = precio;
        this.zona = zona;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNombreEspectador() {
        return nombreEspectador;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public double getPrecio() {
        return precio;
    }

    public Zona getZona() {
        return zona;
    }
}

// Clase Teatro que gestiona la venta y consulta de entradas
public class Teatro {

    private HashMap<String, Zona> zonas;

    public Teatro() {
        zonas = new HashMap<>();
        // Inicialización de las zonas del teatro según los datos proporcionados
        zonas.put("Principal", new Zona("Principal", 200, 25.0, 17.5));
        zonas.put("PalcoB", new Zona("PalcoB", 40, 70.0, 40.0));
        zonas.put("Central", new Zona("Central", 400, 20.0, 14.0));
        zonas.put("Lateral", new Zona("Lateral", 100, 15.5, 10.0));
    }

    public void venderEntrada(String nombreZona, String nombreEspectador, String tipoEntrada) {
        if (zonas.containsKey(nombreZona)) {
            Zona zona = zonas.get(nombreZona);
            if (zona.hayEspacioDisponible()) {
                double precio;
                if (tipoEntrada.equals("Abonado")) {
                    precio = zona.getPrecioAbonado();
                } else {
                    precio = zona.getPrecioNormal();
                    if (tipoEntrada.equals("Reducida")) {
                        precio *= 0.85; // Aplicar descuento del 15%
                    }
                }
                Entrada nuevaEntrada = new Entrada(nombreEspectador, tipoEntrada, precio, zona);
                zona.setLocalidadesVendidas(zona.getLocalidadesVendidas() + 1);
                System.out.println("Entrada vendida correctamente:");
                System.out.println("Identificador: " + nuevaEntrada.getIdentificador());
                System.out.println("Precio: $" + nuevaEntrada.getPrecio());
            } else {
                System.out.println("La zona " + nombreZona + " está completa. No se puede vender más entradas.");
            }
        } else {
            System.out.println("La zona " + nombreZona + " no existe en el teatro.");
        }
    }

    public void consultarEntrada(int identificadorEntrada) {
        boolean entradaEncontrada = false;
        for (Zona zona : zonas.values()) {
            // Aquí deberías tener una lista o estructura para almacenar las entradas vendidas por zona
            // En este ejemplo simplificado, asumimos que solo hay una entrada por zona
            if (entradaEncontrada) {
                break;
            }
        }
        if (!entradaEncontrada) {
            System.out.println("No existe ninguna entrada con el identificador " + identificadorEntrada);
        }
    }

    public static void main(String[] args) {
        Teatro teatro = new Teatro();

        // Ejemplo de venta de entradas
        teatro.venderEntrada("Principal", "Juan Perez", "Normal");
        teatro.venderEntrada("PalcoB", "Ana Gomez", "Abonado");
        teatro.venderEntrada("Central", "Pedro Martinez", "Reducida");
        teatro.venderEntrada("Lateral", "Maria Lopez", "Normal");
    }
}
