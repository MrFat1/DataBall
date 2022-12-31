package test;

import icai.dtc.isw.domain.Jugador;

import static org.junit.Assert.assertEquals;

public class JugadorTest {

    private Jugador jugador;

    @org.junit.Before
    public void setUp() throws Exception {
        jugador = new Jugador("test", "Delantero", "Equipo", 10, 5, 1, 1, 0);
    }

    @org.junit.Test
    public void getNombre() {
        assertEquals("test", jugador.getNombre());
    }

    @org.junit.Test
    public void setNombre() {
        jugador.setNombre("CR7");
        assertEquals("CR7", jugador.getNombre());
    }

    @org.junit.Test
    public void getPosicion() {
        assertEquals("Delantero", jugador.getPosicion());
    }

    @org.junit.Test
    public void setPosicion() {
        jugador.setPosicion("Portero");
        assertEquals("Portero", jugador.getPosicion());
    }

    @org.junit.Test
    public void getEquipo() {
        assertEquals("Equipo", jugador.getEquipo());
    }

    @org.junit.Test
    public void setEquipo() {
        jugador.setEquipo("PSG");
        assertEquals("PSG", jugador.getEquipo());
    }

    @org.junit.Test
    public void getNPartidos() {
        assertEquals(10, jugador.getNumPartidos(), 0);
    }

    @org.junit.Test
    public void setNPartidos() {
        jugador.setNumPartidos(20);
        assertEquals(20, jugador.getNumPartidos(), 0);
    }

    @org.junit.Test
    public void getGoles() {
        assertEquals(5, jugador.getGoles(), 0);
    }

    @org.junit.Test
    public void setGoles() {
        jugador.setGoles(100);
        assertEquals(100, jugador.getGoles(), 0);
    }

    @org.junit.Test
    public void getAsistencias() {
        assertEquals(1, jugador.getAsistencias(), 0);
    }

    @org.junit.Test
    public void setAsistencias() {
        jugador.setAsistencias(5);
        assertEquals(5, jugador.getAsistencias(), 0);
    }

    @org.junit.Test
    public void getTarjAmarillas() {
        assertEquals(1, jugador.getTarjetas_Amarillas(), 0);
    }

    @org.junit.Test
    public void setTA() {
        jugador.setTarjetas_Amarillas(3);
        assertEquals(3, jugador.getTarjetas_Amarillas(), 0);
    }

    @org.junit.Test
    public void getTarjetasRojas() {
        assertEquals(0, jugador.getTarjetas_Rojas(), 0);
    }

    @org.junit.Test
    public void setTR() {
        jugador.setTarjetas_Rojas(5);
        assertEquals(5, jugador.getTarjetas_Rojas(), 0);
    }
}
