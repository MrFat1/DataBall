package icai.dtc.isw.ui;

import icai.dtc.isw.client.Client;

import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

//import javax.swing.JFrame;

public class LogIn extends JFrame {
	public static void main(String[] args) {
		new LogIn();
	}
	//constructor
	public LogIn() 
	{

		//JFrame frame = new JFrame();

		this.setVisible(true);
		this.setSize(500,500); //cambiar el tamaño aqui.
		this.setTitle("Log In");
		this.setLocation(600,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);


		// CREO EL CONTENEDOR

		this.setLayout(new GridLayout(3,1));


		JPanel fila1 = new JPanel();

		FlowLayout layout1 = new FlowLayout();
		fila1.setLayout(layout1);

		JLabel lblUsuario = new JLabel("Introduzca nombre de usuario: ");
		fila1.add(lblUsuario);

		JTextField txtUser = new JTextField(15);
		fila1.add(txtUser);

		this.add(fila1);

		JPanel fila2 = new JPanel();

		FlowLayout layout2 = new FlowLayout();
		fila2.setLayout(layout2);

		JLabel lblPassword = new JLabel("Introduzca contraseña: ");
		fila2.add(lblPassword);

		JPasswordField txtPassword = new JPasswordField(10);
		fila2.add(txtPassword);

		this.add(fila2);

		JPanel fila3 = new JPanel();

		FlowLayout layout3 = new FlowLayout();
		fila3.setLayout(layout3);

		JButton btnLogin = new JButton("Iniciar sesion");
		//btnLogin.setBounds(200,100,100,50);
		fila3.add(btnLogin);
		this.add(fila3);
		pack();

		//Botones
		btnLogin.addActionListener(actionEvent -> {
			recuperarInformacion(txtUser.getText(),txtPassword.getText());
		});
	}

	public void recuperarInformacion(String usuario, String password) {
		Client cliente=new Client();
		HashMap<String,Object> session=new HashMap<>();
		String context="/getAccount"; //Tag para el server
		session.put("usuario",  usuario);
		session.put("password", password);
		session=cliente.sentMessage(context,session); //Cliente devolvera un hashmap con info que hayamos decidido traer de vuelta (en este caso un true o false)
		if((boolean)session.get("confirmation")==true)
			JOptionPane.showMessageDialog(this, "Your account has been confirmed", "Welcome", JOptionPane.INFORMATION_MESSAGE);

		else
			JOptionPane.showMessageDialog(this, "Wrong account or wrong password", "Error", JOptionPane.INFORMATION_MESSAGE);
	}
}