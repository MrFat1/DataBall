package icai.dtc.isw.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Menu;

import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

public class LogIn extends JFrame {
	public static void main(String[] args) {
		new LogIn();
	}
	//Es necesario hacerlos static para que los action listeners puedan interactuar con ellos
	private static JButton btnLogin;
	private static JPanel fila4;
	private static JTextField txtPassword;
	private static JTextField txtUser;
	private static JTextField txtCorreo;
	private boolean Pulsado=false;
	public LogIn() 
	{

		this.setVisible(true);
		this.setSize(500,500); //cambiar el tamaño aqui.
		this.setTitle("Log In");
		this.setLocation(600,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);

		this.setLayout(new GridLayout(4,1));

		JPanel fila1 = new JPanel();

		FlowLayout layout1 = new FlowLayout();
		fila1.setLayout(layout1);

		JLabel lblUsuario = new JLabel("Introduzca nombre de usuario: ");
		fila1.add(lblUsuario);

		txtUser = new JTextField(15);
		fila1.add(txtUser);

		this.add(fila1);

		JPanel fila2 = new JPanel();

		FlowLayout layout2 = new FlowLayout();
		fila2.setLayout(layout2);

		JLabel lblPassword = new JLabel("Introduzca contraseña: ");
		fila2.add(lblPassword);

		txtPassword = new JPasswordField(10);
		fila2.add(txtPassword);

		this.add(fila2);

		JPanel fila3 = new JPanel();

		FlowLayout layout3 = new FlowLayout();
		fila3.setLayout(layout3);

		//Juan
		fila4 =new JPanel();
		FlowLayout layout4= new FlowLayout();
		fila4.setLayout(layout4);

		JLabel lblCorreo=new JLabel("Introducza su correo");
		txtCorreo= new JTextField(10);
		fila4.add(lblCorreo);
		fila4.add(txtCorreo);
		this.add(fila4);
		fila4.setVisible(false);

		JButton Register= new JButton("Registrarse");
		Register.addActionListener(actionEvent->{

			if(Pulsado==true)
			{
				Register(txtUser.getText(),txtCorreo.getText(),txtPassword.getText());
			}
			else
			{
				Pulsado=true;
				fila4.setVisible(true);
				btnLogin.setVisible(false);
			}
		});


		//
		btnLogin = new JButton("Iniciar sesion");
		//btnLogin.setBounds(200,100,100,50);
		fila3.add(btnLogin);
		fila3.add(Register);
		this.add(fila3);

		pack();

		//Botones
		btnLogin.addActionListener(actionEvent -> {
			recuperarInformacion(txtUser.getText(),txtPassword.getText());
		});
	}

	/**
	 * Método para comprobar si el usuario se encuentra registrado en la base de datos
	 * @param usuario
	 * @param password
	 */
	public void recuperarInformacion(String usuario, String password) {
		Client cliente=new Client();
		HashMap<String,Object> session=new HashMap<>();
		String context="/getAccount"; //Tag para el server
		session.put("usuario",  usuario);
		session.put("password", password);
		session=cliente.sentMessage(context,session); //Cliente devolvera un hashmap con info que hayamos decidido traer de vuelta (en este caso un true o false)
		if((boolean) session.get("confirmation")) {
			JOptionPane.showMessageDialog(this, "Cuenta confirmada", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
			new Menu();
			this.dispose();
		}
		else
			JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Método para el registro de usuarios
	 * @param nombre
	 * @param correo
	 * @param password
	 */
	public void Register(String nombre, String correo, String password) {
		Client cliente=new Client();
		HashMap<String,Object> session=new HashMap<>();
		String context="/registerUser";
		session.put("nombre", nombre);
		session.put("correo", correo);
		session.put("password", password);
		session=cliente.sentMessage(context,session); //Devuelve un string con info sobre el registro
		if(session.get("confirmation").equals("bien")) { //if resultadoRegister equals ()
			JOptionPane.showMessageDialog(this, "Usuario registrado correctamente", "Bienvenido a Databall", JOptionPane.INFORMATION_MESSAGE);
			btnLogin.setVisible(true);
			Pulsado=false;
			fila4.setVisible(false);
			txtPassword.setText(null);
			txtUser.setText(null);
			txtCorreo.setText(null);
		} else if (session.get("confirmation").equals("error-correo")) {
			JOptionPane.showMessageDialog(this, "Error: Este correo ya existe", "Error", JOptionPane.WARNING_MESSAGE);
		} else if (session.get("confirmation").equals("error-usuario")) {
			JOptionPane.showMessageDialog(this, "Error: Este usuario ya existe", "Error", JOptionPane.WARNING_MESSAGE);
		} else if (session.get("confirmation").equals("error-contraseña")) {
			JOptionPane.showMessageDialog(this, "Error: La contraseña debe ser alfanumérica", "Error", JOptionPane.WARNING_MESSAGE);
		} else
			JOptionPane.showMessageDialog(this, "Error desconocido, contacta con un administrador.", "Error", JOptionPane.WARNING_MESSAGE);

	}
}