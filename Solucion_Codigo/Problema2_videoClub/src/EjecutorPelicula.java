
import java.util.ArrayList;
import java.util.Arrays;

public class EjecutorPelicula {

    public static void main(String[] args) {
        Dvd soporteDvd = new Dvd(4.5);
        Vhs soporteVhs = new Vhs("Cinta estandar");
        ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>(Arrays.asList(
                new Pelicula("Intensamente", "Ricardo", "2024", "Espaniol", soporteDvd),
                new Pelicula("Juego de Tronos", "Daniel", "2000", "Espaniol", soporteVhs),
                new Pelicula("Matrix", "Steveb", "2024", "Espaniol", soporteDvd)));
        for (Pelicula peli : listaPeliculas) {
            System.out.println(peli);
        }
    }
}

class Pelicula {

    public String titulo;
    public String autor;
    public String yearEdicion;
    public String idioma;
    public double costoAlquiler;
    public Soporte soporte;

    public Pelicula(String titulo, String autor, String yearEdicion, String idioma, Soporte soporte) {
        this.titulo = titulo;
        this.autor = autor;
        this.yearEdicion = yearEdicion;
        this.idioma = idioma;
        this.soporte = soporte;
    }

    public void calculaCostoAlquiler() {

    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", autor=" + autor + ", yearEdicion=" + yearEdicion + ", idioma=" + idioma + ", costoAlquiler=" + costoAlquiler + ", soporte=" + soporte + '}';
    }
}

class Soporte {

}

class Dvd extends Soporte {

    public double capacidad;

    public Dvd(double capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Dvd{" + "capacidad=" + capacidad + '}';
    }

}

class Vhs extends Soporte {

    public String tipoCinta;

    public Vhs(String tipoCinta) {
        this.tipoCinta = tipoCinta;
    }

    @Override
    public String toString() {
        return "Vhs{" + "tipoCinta=" + tipoCinta + '}';
    }

}
