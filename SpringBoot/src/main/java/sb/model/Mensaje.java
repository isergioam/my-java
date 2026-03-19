package sb.model;


/**
 * Clase sencilla para representar un mensaje.
 */
public class Mensaje {

    private String texto;
    private String autor;

    public Mensaje() {
    }

    public Mensaje(String texto, String autor) {
        this.texto = texto;
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}