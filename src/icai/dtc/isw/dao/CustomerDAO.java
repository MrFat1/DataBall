package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Jugador;

public class CustomerDAO {

	/**
	 * Comprueba si el usuario se encuentra en la base de datos
	 * @param usuario Usuario a comprobar
	 * @param password Contraseña de dicho usuario
	 * @return Devuelve la confirmación
	 */
	public static boolean confirmCustomer(String usuario, String password){
		boolean confirmacion = false; //true si ha ido bien, false si no
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios");
			 ResultSet rs = pst.executeQuery()){
			while(rs.next())
			{
				String user= rs.getString(3).trim(); //La mierda del \n al final
				String pas= rs.getString(2).trim();
				if (user.equals(usuario) && pas.equals(password)) {
					return true;
				}
			}
			return confirmacion;
		}
		catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
		return confirmacion;
	}

	/**
	 * Para obtener información de un jugador dependiendo de la opción seleccionado
	 * @param opcion Opción seleccionada
	 * @param busqueda
	 * @return
	 */
	public static ArrayList<Jugador> getJugadores(String opcion, String busqueda) {
		ArrayList<Jugador> lista = new ArrayList<>();
		boolean number;
		Connection con = ConnectionDAO.getInstance().getConnection();
		try {
			Integer.parseInt(busqueda);
			number = true;
		} catch (NumberFormatException error) {
			number = false;
			System.out.println("aaaaaaaaaa");
		}
		if (number ==false) {
			try (PreparedStatement pst = con.prepareStatement("SELECT * FROM Jugadores WHERE " + opcion + " LIKE '%" + busqueda + "%'");
				 ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					lista.add(new Jugador(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));
				}

			} catch (SQLException ex) {

				System.out.println(ex.getMessage());
			}
		}
		if( number==true)
		{
			try (PreparedStatement pst = con.prepareStatement("SELECT * FROM Jugadores WHERE " + opcion + "='"+busqueda +"'");
				 ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					lista.add(new Jugador(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));
				}

			} catch (SQLException ex) {

				System.out.println(ex.getMessage());
			}
		}
		return lista;
	}

	/**
	 * Método para obtener un jugador específico
	 * @param Nombre Busca por nombre
	 * @return
	 */
	public static Jugador getJugador(String Nombre) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		Jugador j=null;
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM Jugadores WHERE nombre ='"+Nombre+"'");
			 ResultSet rs = pst.executeQuery()) {

			// rs es el conjunto de filas
			while (rs.next()) {
				 j= new Jugador(rs.getString(1),rs.getString(2), rs.getString(3),rs.getInt(4),rs.getInt(5), rs.getInt(6),rs.getInt(7),rs.getInt(8));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
		return j;
	}
	
	public static void main(String[] args) {
		ArrayList<Jugador> lista= new ArrayList<>();
		//CustomerDAO.getJugadores(lista);
		
		 for (Jugador j : lista) {
			System.out.println("Nombre: "+j.getNombre()+" Equipo : "+j.getEquipo()+ " Posicion :"+ j.getPosicion()+ " con un total de " +j.getNumPartidos() +" partidos jugados ");
		}
	}

	/**
	 * Método para comprobar si existe un usuario y registrarlo
	 * @param nombre1
	 * @param correo
	 * @param password1
	 * @return
	 */
	public static String register(String nombre1, String correo, String password1) {
		String resultado = "error"; //error default
		Connection con=ConnectionDAO.getInstance().getConnection();
		//Primero comprobamos si el usuario esta ya registrado (comprueba correo y username)
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios");
			 ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				//Si el usuario se encuentra en la DB devolverá error-usuario
				if (rs.getString(1).equals(nombre1)) {
					resultado = "error-usuario";
					break;
				} else if (rs.getString(3).equals(correo)) {
					resultado = "error-correo";
					break;
				}
			}
		}
		catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}

		//Si llegamos hasta aqui significa que no hay problema con el usuario o el correo

		//Requisito no funcional: Contraseña alfanumérica

		/*if (!password1.matches("^[a-zA-Z0-9]*$")) {
			resultado = "error-contraseña";
		} else {*/

			try (PreparedStatement pst2 = con.prepareStatement("INSERT INTO usuarios (correo, password, usuario) VALUES ('" + correo + "','" + password1 + "','" + nombre1 + "');");) {

				resultado="bien";

			}
			catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		//}
		return resultado;
	}


}
