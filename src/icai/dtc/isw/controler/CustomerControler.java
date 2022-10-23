package icai.dtc.isw.controler;

import java.util.ArrayList;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Jugador;

public class CustomerControler {

	public void getCustomers(ArrayList<Jugador> lista) {
		CustomerDAO.getJugadores(lista);
	}
	public Jugador getJugador(String Nombre) {return(CustomerDAO.getJugador(Nombre));}
	public boolean confirmCustomer(String usuario,String password) {
		return(CustomerDAO.confirmCustomer(usuario,password));
	}
	public String registerCustomer(String nombre1, String correo, String password1) {
		return (CustomerDAO.register(nombre1, correo, password1));
	}
}
