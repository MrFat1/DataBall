package icai.dtc.isw.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import icai.dtc.isw.configuration.PropertiesISW;
import icai.dtc.isw.controler.CustomerControler;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Equipo;
import icai.dtc.isw.domain.Jugador;
import icai.dtc.isw.message.Message;

public class SocketServer extends Thread {
	public static int port = 8081; //Valor por defecto
	public HashMap<String,String>usuarios=new HashMap<>();
	protected Socket socket;

	private SocketServer(Socket socket) {
		this.socket = socket;
		//Configure connections
		this.port = Integer.parseInt(PropertiesISW.getInstance().getProperty("port"));
		System.out.println("New client connected from " + socket.getInetAddress().getHostAddress());
		start();
	}

	public void run() {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = socket.getInputStream();
			out = socket.getOutputStream();
			//first read the object that has been sent
			ObjectInputStream objectInputStream = new ObjectInputStream(in);
		    Message mensajeIn= (Message)objectInputStream.readObject();
		    //Object to return informations 
		    ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
		    Message mensajeOut=new Message();
			HashMap<String,Object> session=mensajeIn.getSession();
			CustomerControler customerControler;
		    switch (mensajeIn.getContext()) {
				case "/ordenarJugadores":
					customerControler=new CustomerControler();
					mensajeOut.setContext("/getCustomersResponse");
					session.put("jugadores",customerControler.ordenarJugadores((String) session.get("opcion")));
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/ordenarEquipos":
					customerControler=new CustomerControler();
					mensajeOut.setContext("/getEquipos");
					session.put("equipo",customerControler.ordenarEquipos((String) session.get("opcion")));
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
		    	case "/getbusqueda":
		    		customerControler=new CustomerControler();
					String opcion= (String) session.get("opcion");
					String busqueda= (String) session.get("jugador");
		    		ArrayList<Jugador> lista=customerControler.getBusqueda(busqueda, opcion);
		    		mensajeOut.setContext("/getCustomersResponse");
		    		//HashMap<String,Object> session=new HashMap<String, Object>();
		    		session.put("jugadores",lista);
		    		mensajeOut.setSession(session);
		    		objectOutputStream.writeObject(mensajeOut);
		    		break;
				case "/getequipo":
					customerControler=new CustomerControler();
					String opcion_e= (String) session.get("opcion");
					String equipo= (String) session.get("equipo");
					ArrayList<Equipo> listaEquipo=customerControler.getEquipos(equipo,opcion_e);
					session.put("equipos",listaEquipo);
					mensajeOut.setContext("/getequipos");
					//HashMap<String,Object> session=new HashMap<String, Object>();
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getJugador":
					String nombre= (String) session.get("Nombre");
					customerControler=new CustomerControler();
					Jugador jugador=customerControler.getJugador(nombre);
					System.out.println("Nombre:"+jugador.getNombre());
					mensajeOut.setContext("/getJugador");
					session.put("Jugador",jugador);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;

				case "/getAccount":
					customerControler=new CustomerControler();
					String user= (String) session.get("usuario"); //Coge el usuario que ha introducido
					String password= (String) session.get("password"); //Coge la contrseña que ha introducido
					mensajeOut.setContext("/getAccountConfirmation"); //Devolverá este tag al cliente para que decida que hacer con la info
					boolean account=customerControler.confirmCustomer(user,password);
					session.put("confirmation",account); //Esto devolverá el resultado con el tag "confirmation" (account: true si todo ha ido bien, false si no)
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;

				case "/registerUser":
					customerControler=new CustomerControler();
					String nombre1 = (String) session.get("nombre");
					String correo = (String) session.get("correo");
					String password1 = (String) session.get("password");
					mensajeOut.setContext("/getRegisterInfo"); //Devolverá este tag al cliente para que decida que hacer con la info
					String resultadoRegister = customerControler.registerCustomer(nombre1,correo, password1);
					session.put("confirmation",resultadoRegister); //Esto devolverá el resultado con el tag "confirmation" al JRegister
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;
				case "/getlistajugadores":
					customerControler = new CustomerControler();
					ArrayList<Jugador> jugadores = customerControler.getJugadores();
					mensajeOut.setContext("/getjugadores");
					session.put("listajugadores",jugadores);
					mensajeOut.setSession(session);
					objectOutputStream.writeObject(mensajeOut);
					break;

		    	default:
		    		System.out.println("\nError al encontrar un parámetro");
		    		break;
		    }
		    
		    //Lógica del controlador 
		    //System.out.println("\n1.- He leído: "+mensaje.getContext());
		    //System.out.println("\n2.- He leído: "+(String)mensaje.getSession().get("Nombre"));
		    
		    
		    
		    //Prueba para esperar
		    /*try {
		    	System.out.println("Me duermo");
				Thread.sleep(15000);
				System.out.println("Me levanto");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			// create an object output stream from the output stream so we can send an object through it
			/*ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
			
			//Create the object to send
			String cadena=((String)mensaje.getSession().get("Nombre"));
			cadena+=" añado información";
			mensaje.getSession().put("Nombre", cadena);
			//System.out.println("\n3.- He leído: "+(String)mensaje.getSession().get("Nombre"));
			objectOutputStream.writeObject(mensaje);*
			*/

		} catch (IOException ex) {
			System.out.println("Unable to get streams from client");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("SocketServer starting");
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			while (true) {
				/**
				 * create a new {@link SocketServer} object for each connection
				 * this will allow multiple client connections
				 */
				new SocketServer(server.accept());
			}
		} catch (IOException ex) {
			System.out.println("Unable to start server.");
		} finally {
			try {
				if (server != null)
					server.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}