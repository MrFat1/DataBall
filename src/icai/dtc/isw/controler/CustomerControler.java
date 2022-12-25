package icai.dtc.isw.controler;

import java.util.ArrayList;
import java.util.HashMap;

import com.sun.mail.imap.protocol.UIDSet;
import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Equipo;
import icai.dtc.isw.domain.Jugador;
import icai.dtc.isw.domain.Usuario;
import icai.dtc.isw.domain.Video;

public class CustomerControler {

	public ArrayList<Jugador> getBusqueda(String busqueda, String opcion) {
		return CustomerDAO.getJugadores(opcion, busqueda);
	}
	public ArrayList<Video> getVideos()
	{
		return CustomerDAO.getVideos();
	}
	public ArrayList<Equipo> getEquipos(String busqueda, String opcion){
		return CustomerDAO.getEquipos(opcion, busqueda);
	}
	public Jugador getJugador(String Nombre) {return(CustomerDAO.getJugador(Nombre));}
	public boolean confirmCustomer(String usuario,String password) {
		return(CustomerDAO.confirmCustomer(usuario,password));
	}
	public String registerCustomer(String nombre1, String correo, String password1) {
		return (CustomerDAO.register(nombre1, correo, password1));
	}

	public boolean cambiarPass(String correo, String nuevaPas) {
		return (CustomerDAO.cambiarPass(correo, nuevaPas));
	}

	public boolean confirmCorreo(String correo) {
		return (CustomerDAO.confirmCorreo(correo));
	}

	public ArrayList<Jugador> getJugadores() {
		return (CustomerDAO.getListaJugadores());
	}

	public ArrayList<Usuario> getUsuarios() {
		return (CustomerDAO.getUsuarios());
	}

	public Usuario getUserByName(String user) {
		return (CustomerDAO.getUserByName(user));
	}

	public boolean updateUser(HashMap<String, Object> session) {
		return (CustomerDAO.updateUser(session));
	}
}
