package test;

import icai.dtc.isw.domain.Usuario;
import static org.junit.Assert.*;


public class UsuarioTest {

    private Usuario usuario;

    @org.junit.Before
    public void setUp() throws Exception {
        usuario = new Usuario("test", "test@gmail.com", "test123", "usuario");
    }

    @org.junit.Test
    public void getNombre() {
        assertEquals("test", usuario.getNombre());
    }

    @org.junit.Test
    public void setNombre() {
        usuario.setNombre("test2");
        assertEquals("test2", usuario.getNombre());
    }

    @org.junit.Test
    public void getPass() {
        assertEquals("test123", usuario.getPassword());
    }

    @org.junit.Test
    public void setPass() {
        usuario.setPassword("1111");
        assertEquals("1111", usuario.getPassword());
    }


    @org.junit.Test
    public void getCorreo() {
        assertEquals("test@gmail.com", usuario.getCorreo());
    }

    @org.junit.Test
    public void setCorreo() {
        usuario.setNombre("test2@gmail.com");
        assertEquals("test2@gmail.com", usuario.getNombre());
    }


    @org.junit.Test
    public void getRol() {
        assertEquals("usuario", usuario.getRol());
    }

    @org.junit.Test
    public void setRol() {
        usuario.setRol("admin");
        assertEquals("admin", usuario.getRol());
    }

}
