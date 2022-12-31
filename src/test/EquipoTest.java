package test;

import icai.dtc.isw.domain.Equipo;

import static org.junit.Assert.assertEquals;

public class EquipoTest {

    private Equipo equipo;

    @org.junit.Before
    public void setUp() throws Exception {
        equipo = new Equipo("Equipo", "Entrenador", "Presidente", 1, 10, 100, "Estadio");
    }

    @org.junit.Test
    public void getNombre() {
        assertEquals("Equipo", equipo.getNombre());
    }

    @org.junit.Test
    public void setNombre() {
        equipo.setNombre("Madrid");
        assertEquals("Madrid", equipo.getNombre());
    }

    @org.junit.Test
    public void getEntrenador() {
        assertEquals("Entrenador", equipo.getEntrenador());
    }

    @org.junit.Test
    public void setEntrenador() {
        equipo.setEntrenador("Paco");
        assertEquals("Paco", equipo.getEntrenador());
    }

    @org.junit.Test
    public void getPresidente() {
        assertEquals("Presidente", equipo.getPresidente());
    }

    @org.junit.Test
    public void setPresidente() {
        equipo.setPresidente("Aurelio");
        assertEquals("Aurelio", equipo.getPresidente());
    }

    @org.junit.Test
    public void getPosicion() {
        assertEquals(1, equipo.getPosicion(), 0);
    }

    @org.junit.Test
    public void setPos() {
        equipo.setPosicion(2);
        assertEquals(2, equipo.getPosicion(), 0);
    }

    @org.junit.Test
    public void getCapacidad() {
        assertEquals(10, equipo.getCapacidad(), 0);
    }

    @org.junit.Test
    public void setCapacidad() {
        equipo.setCapacidad(20);
        assertEquals(20, equipo.getCapacidad(), 0);
    }

    @org.junit.Test
    public void getmasaSalarial() {
        assertEquals(100, equipo.getMasaSalarial(), 0);
    }

    @org.junit.Test
    public void setMS() {
        equipo.setMasaSalarial(2000);
        assertEquals(2000, equipo.getMasaSalarial(), 0);
    }

    @org.junit.Test
    public void getEstadio() {
        assertEquals("Estadio", equipo.getEstadio());
    }

    @org.junit.Test
    public void setEstadio() {
        equipo.setEstadio("Caja mágica");
        assertEquals("Caja mágica", equipo.getEstadio());
    }
}
