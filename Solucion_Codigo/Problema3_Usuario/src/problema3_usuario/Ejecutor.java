
package problema3_usuario;

import java.util.ArrayList;
import java.util.List;

// Clase Contacto
class Contacto {
    private String numeroMovil;
    private String nombre;

    public Contacto(String numeroMovil) {
        this.numeroMovil = numeroMovil;
    }

    public Contacto(String numeroMovil, String nombre) {
        this.numeroMovil = numeroMovil;
        this.nombre = nombre;
    }

    public String getNumeroMovil() {
        return numeroMovil;
    }

    public String getNombre() {
        return nombre;
    }
}

// Clase abstracta Mensaje
abstract class Mensaje {
    protected Contacto remitente;
    protected Contacto destinatario;

    public Mensaje(Contacto remitente, Contacto destinatario) {
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    public abstract void enviarMensaje();
    public abstract void visualizarMensaje();
}

// Clase MensajeTexto (SMS)
class MensajeTexto extends Mensaje {
    private String texto;

    public MensajeTexto(Contacto remitente, Contacto destinatario, String texto) {
        super(remitente, destinatario);
        this.texto = texto;
    }

    @Override
    public void enviarMensaje() {
        System.out.println("Enviando mensaje de texto de " + remitente.getNumeroMovil() + " a " + destinatario.getNumeroMovil() + ": " + texto);
    }

    @Override
    public void visualizarMensaje() {
        System.out.println("Mensaje de texto de " + remitente.getNumeroMovil() + " a " + destinatario.getNumeroMovil() + ": " + texto);
    }
}

// Clase MensajeImagen (MMS)
class MensajeImagen extends Mensaje {
private String nombreFicheroImagen;

    public MensajeImagen(Contacto remitente, Contacto destinatario, String nombreFicheroImagen) {
        super(remitente, destinatario);
        this.nombreFicheroImagen = nombreFicheroImagen;
    }

    @Override
    public void enviarMensaje() {
        System.out.println("Enviando mensaje con imagen de " + remitente.getNumeroMovil() + " a " + destinatario.getNumeroMovil() + ": " + nombreFicheroImagen);
    }

    @Override
    public void visualizarMensaje() {
        System.out.println("Mensaje con imagen de " + remitente.getNumeroMovil() + " a " + destinatario.getNumeroMovil() + ": " + nombreFicheroImagen);
    }
}

// Clase Ejecutor para probar el diseño con datos ficticios
public class Ejecutor {
    public static void main(String[] args) {
        // Crear contactos
        Contacto contacto1 = new Contacto("123456789", "Alice");
        Contacto contacto2 = new Contacto("987654321", "Bob");

        // Crear mensajes
        Mensaje mensajeTexto = new MensajeTexto(contacto1, contacto2, "Hola Bob, como estas?");
        Mensaje mensajeImagen = new MensajeImagen(contacto2, contacto1, "imagen.jpg");

        // Enviar y visualizar mensajes
        mensajeTexto.enviarMensaje();
        mensajeTexto.visualizarMensaje();
        mensajeImagen.enviarMensaje();
        mensajeImagen.visualizarMensaje();
    }
}

