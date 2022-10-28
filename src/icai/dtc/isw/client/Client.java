package icai.dtc.isw.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import icai.dtc.isw.domain.Jugador;
import icai.dtc.isw.ui.LogIn;
import org.apache.log4j.Logger;

import icai.dtc.isw.configuration.PropertiesISW;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.message.Message;

import javax.swing.*;

public class Client {
	private String host;
	private int port;
	public ArrayList<Jugador> jugadores;
	final static Logger logger = Logger.getLogger(Client.class);
	public Client(String host, int port) {
		this.host=host;
		this.port=port;
	}
	public Client() {
		this.host = PropertiesISW.getInstance().getProperty("host");
		this.port = Integer.parseInt(PropertiesISW.getInstance().getProperty("port"));
	}
	public HashMap<String, Object> sentMessage(String Context, HashMap<String, Object> session) {
		//Configure connections
		//String host = PropertiesISW.getInstance().getProperty("host");
		//int port = Integer.parseInt(PropertiesISW.getInstance().getProperty("port"));
		Logger.getRootLogger().info("Host: "+host+" port"+port);
		System.out.println("Host: "+host+" port"+port);
		//Create a cliente class
		//Client cliente=new Client(host, port);
		
		//HashMap<String,Object> session=new HashMap<String, Object>();
		//session.put("/getCustomer","");
		
		Message mensajeEnvio=new Message();
		Message mensajeVuelta=new Message();
		mensajeEnvio.setContext(Context);///getCustomer"
		mensajeEnvio.setSession(session);
		this.sent(mensajeEnvio,mensajeVuelta);
		
		//Usaremos este para mensajes debug (solo se verán en la consola)
		switch (mensajeVuelta.getContext()) { //Esto ya es lo que hara a la vuelta
			case "/getCustomersResponse":
				jugadores=(ArrayList<Jugador>)(mensajeVuelta.getSession().get("jugadores"));
				/*for (Jugador j : lista) {
					System.out.println("Nombre: "+j.getNombre()+" Equipo : "+j.getEquipo()+ " Posicion :"+ j.getPosicion()+ " con un total de " +j.getNumPartidos() +" partidos jugados ");
				}*/
				break;
			case "/getCustomerResponse":
				session=mensajeVuelta.getSession();
				Jugador j =(Jugador) (session.get("Jugador"));
				System.out.println("Nombre: "+j.getNombre()+" Equipo : "+j.getEquipo()+ " Posicion :"+ j.getPosicion()+ " con un total de " +j.getNumPartidos() +" partidos jugados ");
				break;

			case "/getAccountConfirmation":
				session=mensajeVuelta.getSession();
				//String b = (String) session.get("confirmation");
				/*f(b)
					System.out.println("Your account has been confirmed");
				else{

					System.out.println("Wrong account or wrong password");
				}*/
				break;

			case "/getRegisterInfo":
				session = mensajeVuelta.getSession();
				System.out.println(session);

			default:
				/*Logger.getRootLogger().info("Option not found");
				System.out.println("\nError a la vueltaaa");
				break;
		*/
		}
		//System.out.println("3.- En Main.- El valor devuelto es: "+((String)mensajeVuelta.getSession().get("Nombre")));
		return session;
	}
	


	public void sent(Message messageOut, Message messageIn) {
		try {

			System.out.println("Connecting to host " + host + " on port " + port + ".");

			Socket echoSocket = null;
			OutputStream out = null;
			InputStream in = null;

			try {
				echoSocket = new Socket(host, port);
				in = echoSocket.getInputStream();
				out = echoSocket.getOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
				
				//Create the objetct to send
				objectOutputStream.writeObject(messageOut);
				
				// create a DataInputStream so we can read data from it.
		        ObjectInputStream objectInputStream = new ObjectInputStream(in);
		        Message msg=(Message)objectInputStream.readObject();
		        messageIn.setContext(msg.getContext());
		        messageIn.setSession(msg.getSession());
		        /*System.out.println("\n1.- El valor devuelto es: "+messageIn.getContext());
		        String cadena=(String) messageIn.getSession().get("Nombre");
		        System.out.println("\n2.- La cadena devuelta es: "+cadena);*/
				
			} catch (UnknownHostException e) {
				System.err.println("Unknown host: " + host);
				System.exit(1);
			} catch (IOException e) {
				System.err.println("Unable to get streams from server");
				System.exit(1);
			}		

			/** Closing all the resources */
			out.close();
			in.close();			
			echoSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}