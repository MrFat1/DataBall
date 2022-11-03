package icai.dtc.isw.domain;

public class Equipo {
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    private String estadio;

    private String nombre;

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    private String entrenador;

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    private String presidente;

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    private int posicion;

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    private int capacidad;

    public int getMasaSalarial() {
        return masaSalarial;
    }

    public void setMasaSalarial(int masaSalarial) {
        this.masaSalarial = masaSalarial;
    }

    private int masaSalarial;
public Equipo(String nombre,String entrenador,String presidente,int posicion,int capacidad,int masaSalarial,String estadio)
{
    setNombre(nombre);
    setEntrenador(entrenador);
    setPresidente(presidente);
    setPosicion(posicion);
    setCapacidad(capacidad);
    setMasaSalarial(masaSalarial);
    setEstadio(estadio);
}
public String MostrarEquipo()
{
    return getNombre();
}
}
