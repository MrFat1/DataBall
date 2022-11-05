package icai.dtc.isw.domain;

import java.io.Serializable;
import java.net.URI;

/**
 * Clase para añadir un objeto Video
 */
public class Video implements Serializable {

    private URI url;
    private String nombre;

    public String getNombre() {
        return nombre;
    }
    public URI getUrl() {
        return url;
    }
    public void setUrl(URI url) {
        this.url = url;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor del video
     * @param url
     * @param nombre
     */
    public Video(URI url, String nombre) {
        this.url = url;
        this.nombre=nombre;
    }
}
