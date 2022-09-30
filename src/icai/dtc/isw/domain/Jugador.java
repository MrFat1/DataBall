package icai.dtc.isw.domain;

import java.io.Serializable;

public class Jugador implements Serializable {
    private String Nombre;
    private String posicion;
    private String Equipo;
    private Integer NumPartidos;
    private Integer Goles;
    private Integer Asistencias;
    private Integer Tarjetas_Amarillas;
    private Integer Tarjetas_Rojas;
    public Jugador( String Nombre,String posicion, String Equipo, Integer NumPartidos, Integer Goles, Integer a, Integer Ta, Integer Tr){
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
        return Tarjetas_Amarillas;}
    public void setTarjetas_Amarillas(int tarjetas_Amarillas) {
        Tarjetas_Amarillas = tarjetas_Amarillas;}
    public Integer getAsistencias() {
        return Asistencias;}
    public void setAsistencias(int asistencias) {
        Asistencias = asistencias;}
    public Integer getTarjetas_Rojas() {
        return Tarjetas_Rojas;}
    public void setTarjetas_Rojas(int tarjetas_Rojas) {
        Tarjetas_Rojas = tarjetas_Rojas;}
    public String getEquipo() {
        return Equipo;}
    public void setEquipo(String equipo) {
        Equipo = equipo;}
    public String getPosicion() {
        return posicion;}
    public void setPosicion(String posicion) {
        this.posicion = posicion;}
}
