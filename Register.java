import java.awt.*;
import javax.swing.*;

public class Register extends JFrame //implements ActionListener
{
	//constructor
	public Register(){

		this.setVisible(true);
		this.setSize(500,500); //cambiar el tamaño aqui.
		this.setTitle("Register");
		this.setLocation(600,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);

		this.setLayout(new GridLayout(4,1));

		JPanel fila1 = new JPanel();
		FlowLayout layout1 = new FlowLayout();
		fila1.setLayout(layout1);
		JLabel lblEmail = new JLabel("Introduzca su email ");
		fila1.add(lblEmail);
		JTextField txtEmail = new JTextField();
		fila1.add(txtEmail);
		this.add(fila1);

		JPanel fila2 = new JPanel();
		FlowLayout layout2 = new FlowLayout();
		fila2.setLayout(layout2);
		JLabel lblRemail = new JLabel("Repita su email ");
		fila2.add(lblRemail);
		JTextField txtRemail = new JTextField();
		fila2.add(txtRemail);
		this.add(fila2);

		JPanel fila3 = new JPanel();
		FlowLayout layout3 = new FlowLayout();
		fila3.setLayout(layout3);
		JLabel lblPassword = new JLabel("Elija una contraseña ");
		fila3.add(lblPassword);
		JTextField txtPassword = new JTextField();
		fila3.add(txtPassword);
		this.add(fila3);

		JPanel fila4 = new JPanel();
		FlowLayout layout4 = new FlowLayout();
		fila4.setLayout(layout4);
		JButton btnRegister = new JButton("Registrarse");
		fila4.add(btnRegister);
		this.add(fila4);

		pack();
	} 
}