package icai.dtc.isw.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Equipo implements Serializable {

    private String estadio;
    private String nombre;
    private String entrenador;
    private String presidente;
    private int posicion;
    private int capacidad;
    private int masaSalarial;

    public String MostrarEquipo()
    {
        return getNombre();
    }
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
    public int getMasaSalarial() {
        return masaSalarial;
    }
    public void setMasaSalarial(int masaSalarial) {
        this.masaSalarial = masaSalarial;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public int getPosicion() {
        return posicion;
    }
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    public String getPresidente() {
        return presidente;
    }
    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }
    public String getEntrenador() {
        return entrenador;
    }
    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    /**
     * Constructor para añadir un nuevo equipo
     * @param nombre
     * @param entrenador
     * @param presidente
     * @param posicion
     * @param capacidad
     * @param masaSalarial
     * @param estadio
     */
    public Equipo(String nombre,String entrenador,String presidente,int posicion,int capacidad,int masaSalarial,String estadio) {
        setNombre(nombre);
        setEntrenador(entrenador);
        setPresidente(presidente);
        setPosicion(posicion);
        setCapacidad(capacidad);
        setMasaSalarial(masaSalarial);
        setEstadio(estadio);
    }


    public ArrayList<String> getStats() {
        ArrayList<String> stats = new ArrayList<>();
        stats.add(nombre);
        stats.add(entrenador);
        stats.add(presidente);
        stats.add(Integer.toString(posicion));
        stats.add(Integer.toString(capacidad));
        stats.add(Integer.toString(masaSalarial));
        stats.add(estadio);
        return stats;
        }
}
