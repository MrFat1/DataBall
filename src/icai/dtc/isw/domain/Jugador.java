package icai.dtc.isw.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable {
    private String Nombre;
    private String posicion;
    private String Equipo;
    private Integer NumPartidos;
    private Integer Goles;
    private Integer Asistencias;
    private Integer TarjetasAmarillas;
    private Integer TarjetasRojas;

    /**
     * Constructor para crear un objeto Jugador
     * @param Nombre
     * @param posicion
     * @param Equipo
     * @param NumPartidos
     * @param Goles
     * @param a Asistencias
     * @param Ta Tarjetas amarillas
     * @param Tr Tarjetas rojas
     */
    public Jugador(String Nombre,String posicion, String Equipo, Integer NumPartidos, Integer Goles, Integer a, Integer Ta, Integer Tr){
        this.setNombre(Nombre);
        this.setEquipo(Equipo);
        this.setPosicion(posicion);
        this.setNumPartidos(NumPartidos);
        this.setGoles(Goles);
        this.setAsistencias(a);
        this.setTarjetas_Amarillas(Ta);
        this.setTarjetas_Rojas(Tr);
    }

    public String getNombre() {
        return Nombre;}
    public void setNombre(String nombre) {
        Nombre = nombre;}
    public Integer getNumPartidos() {
        return NumPartidos;}
    public void setNumPartidos(int numPartidos) {
        NumPartidos = numPartidos;}
    public Integer getGoles() {
        return Goles;}
    public void setGoles(int goles) {
        Goles = goles;}
    public Integer getTarjetas_Amarillas() {
        return TarjetasAmarillas;}
    public void setTarjetas_Amarillas(int tarjetas_Amarillas) {
        TarjetasAmarillas = tarjetas_Amarillas;}
    public Integer getAsistencias() {
        return Asistencias;}
    public void setAsistencias(int asistencias) {
        Asistencias = asistencias;}
    public Integer getTarjetas_Rojas() {
        return TarjetasRojas;}
    public void setTarjetas_Rojas(int tarjetas_Rojas) {
        TarjetasRojas = tarjetas_Rojas;}
    public String getEquipo() {
        return Equipo;}
    public void setEquipo(String equipo) {
        Equipo = equipo;}
    public String getPosicion() {
        return posicion;}
    public void setPosicion(String posicion) {
        this.posicion = posicion;}

    public ArrayList<String> getStats() {
        ArrayList<String> stats = new ArrayList<>();

        stats.add(Nombre);
        stats.add(posicion);
        stats.add(Equipo);
        stats.add(Integer.toString(NumPartidos));
        stats.add(Integer.toString(Goles));
        stats.add(Integer.toString(Asistencias));
        stats.add(Integer.toString(TarjetasAmarillas));
        stats.add(Integer.toString(TarjetasRojas));

        return stats;
    }

    public String MostrarJugador()
    {
        return "Nombre: " + this.Nombre + " Equipo: "+ this.Equipo;
    }
}
