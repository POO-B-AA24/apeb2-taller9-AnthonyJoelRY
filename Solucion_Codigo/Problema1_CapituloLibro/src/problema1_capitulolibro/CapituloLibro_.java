package problema1_capitulolibro;

import java.util.ArrayList;
import java.util.List;

public class CapituloLibro_ {

    public static void main(String[] args) {
        CapituloLibro capitulo = new CapituloLibro();
        Seccion seccion1 = new Seccion();
        Parrafo parrafo1 = new Parrafo();
        Figura figura1 = new Figura("Figura 1: Diagrama de clases");

        Sentencia sentencia1 = new Sentencia();
        sentencia1.agregarPalabra("Este");
        sentencia1.agregarPalabra("es");
        sentencia1.agregarPalabra("el");
        sentencia1.agregarPalabra("primer");
        sentencia1.agregarPalabra("parrafo");

        parrafo1.agregarSentencia(sentencia1);
        seccion1.agregarParrafo(parrafo1);
        seccion1.agregarFigura(figura1);
        capitulo.agregarSeccion(seccion1);

        capitulo.mostrarEstructura();
    }
}

class CapituloLibro {
    private List<Seccion> secciones = new ArrayList<>();

    public void agregarSeccion(Seccion seccion) {
        secciones.add(seccion);
    }

    public void mostrarEstructura() {
        for (Seccion seccion : secciones) {
            System.out.println("Seccion:");
            for (Parrafo parrafo : seccion.getParrafos()) {
                System.out.print("  Parrafo: ");
                for (Sentencia sentencia : parrafo.getSentencias()) {
                    for (String palabra : sentencia.getPalabras()) {
                        System.out.print(palabra + " ");
                    }
                }
                System.out.println();
            }
            for (Figura figura : seccion.getFiguras()) {
                System.out.println("  Figura: " + figura.getDescripcion());
            }
        }
    }
}

class Seccion {
    private List<Parrafo> parrafos = new ArrayList<>();
    private List<Figura> figuras = new ArrayList<>();

    public void agregarParrafo(Parrafo parrafo) {
        parrafos.add(parrafo);
    }

    public void agregarFigura(Figura figura) {
        figuras.add(figura);
    }

    public List<Parrafo> getParrafos() {
        return parrafos;
    }

    public List<Figura> getFiguras() {
        return figuras;
    }
}

class Parrafo {
    private List<Sentencia> sentencias = new ArrayList<>();

    public void agregarSentencia(Sentencia sentencia) {
        sentencias.add(sentencia);
    }

    public List<Sentencia> getSentencias() {
        return sentencias;
    }
}

class Sentencia {
    private List<String> palabras = new ArrayList<>();

    public void agregarPalabra(String palabra) {
        palabras.add(palabra);
    }

    public List<String> getPalabras() {
        return palabras;
    }
}

class Figura {
    private String descripcion;

    public Figura(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
