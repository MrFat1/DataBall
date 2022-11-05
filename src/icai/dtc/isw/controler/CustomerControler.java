package icai.dtc.isw.controler;

import java.util.ArrayList;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Equipo;
import icai.dtc.isw.domain.Jugador;

public class CustomerControler {

	public ArrayList<Jugador> getBusqueda(String busqueda, String opcion) {
		return CustomerDAO.getJugadores(opcion, busqueda);
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

	public boolean confirmCorreo(String correo) {
		return (CustomerDAO.confirmCorreo(correo));
	}

	public ArrayList<Jugador> getJugadores() {
		return (CustomerDAO.getListaJugadores());
	}
}
