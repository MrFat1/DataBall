import java.awt.*;
import javax.swing.*;

//import javax.swing.JFrame;

public class LogIn extends JFrame //implements ActionListener
{
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

		JTextField txtUser = new JTextField("Nombre de Usuario");
		fila1.add(txtUser);

		this.add(fila1);


		JPanel fila2 = new JPanel();

		FlowLayout layout2 = new FlowLayout();
		fila2.setLayout(layout2);

		JLabel lblPassword = new JLabel("Introduzca contraseña: ");
		fila2.add(lblPassword);

		JPasswordField txtPassword = new JPasswordField("Contraseña");
		fila2.add(txtPassword);

		/*
		JButton btnShow = new JButton("Ver");
		//btnLogin.setBounds(200,100,100,50);
		fila2.add(btnShow);
		//btnShow.addActionListener(this);
			//	getPassword() Returns the text contained in this TextComponent. */

		this.add(fila2);


		JPanel fila3 = new JPanel();

		FlowLayout layout3 = new FlowLayout();
		fila3.setLayout(layout3);


		JButton btnLogin = new JButton("Iniciar sesion");
		//btnLogin.setBounds(200,100,100,50);
		fila3.add(btnLogin);

		this.add(fila3);
		pack();



	}

}