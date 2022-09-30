package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Jugador;

public class CustomerDAO {
	
	public static boolean confirmCustomer(String usuario, String password){
		boolean confirmacion = false; //true si ha ido bien, false si no
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM Usuarios"); //Esta sentencia devuelve todos los clientes
			 ResultSet rs = pst.executeQuery()){
			while(rs.next())
			{
				//Si el usuario se encuentra en la DB devolverá true
				if (rs.getString(1).equals(usuario) && rs.getString(2).equals(password)) {
					confirmacion = true;
				}
			}
		}
		catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
		return confirmacion;
	}

	public static void getJugadores(ArrayList<Jugador> lista) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM Jugadores");
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
            	lista.add(new Jugador(rs.getString(1),rs.getString(2), rs.getString(3),rs.getInt(4),rs.getInt(5), rs.getInt(6),rs.getInt(7),rs.getInt(8) ));
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
	}
	public static Jugador getJugador(String Nombre) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		Jugador j=null;
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM Jugadores WHERE nombre ='"+Nombre+"'");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				 j= new Jugador(rs.getString(1),rs.getString(2), rs.getString(3),rs.getInt(4),rs.getInt(5), rs.getInt(6),rs.getInt(7),rs.getInt(8));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
		return j;
		//return new Customer("1","Atilano");
	}
	
	public static void main(String[] args) {
		
		
		ArrayList<Jugador> lista= new ArrayList<>();
		CustomerDAO.getJugadores(lista);
		
		
		 for (Jugador j : lista) {
			System.out.println("Nombre: "+j.getNombre()+" Equipo : "+j.getEquipo()+ " Posicion :"+ j.getPosicion()+ " con un total de " +j.getNumPartidos() +" partidos jugados ");
		}
		
	
	}

}