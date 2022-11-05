package icai.dtc.isw.domain;

import java.io.Serializable;
import java.net.URI;

public class Video implements Serializable {
    public URI getUrl() {
        return url;
    }

    public void setUrl(URI url) {
        this.url = url;
    }
    private URI url;
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;


    public Video(URI url, String nombre) {
        this.url = url;
        this.nombre=nombre;
    }
}
