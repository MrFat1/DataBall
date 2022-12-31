package icai.dtc.isw.ui;

import icai.dtc.isw.domain.login.PanelLogin;
import icai.dtc.isw.domain.login.PanelRegister;
import icai.dtc.isw.domain.login.PanelResetPass;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 * Clase principal del proyecto. Ejecutar esta para iniciarlo
 */
public class LogIn extends JFrame {
	public static void main(String[] args) {
		new LogIn();
	}

	private JPanel pnlCard;

	//Indentificadores para el CardLayout
	final static String RESETPASS = "Restaurar contraseña";
	final static String LOGIN = "Iniciar sesión";
	final static String REGISTER = "Registrarse";

	PanelResetPass pnlReset = new PanelResetPass();
	PanelLogin pnlLogin = new PanelLogin(this);
	PanelRegister pnlRegister = new PanelRegister(this);

	/**
	 * Ejecuta la interfaz de login y registro de usuarios.
	 */
	public LogIn()
	{

		this.setVisible(true);
		this.setSize(500,500); //cambiar el tamaño aqui.
		this.setTitle("Inicio de sesión");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);

		pnlCard = new JPanel();

		JPanel arriba = new JPanel();

		//Añadimos los paneles al CardLayout
		pnlCard.setLayout(new CardLayout(0, 0));
		pnlCard.add(pnlLogin, LOGIN);
		pnlCard.add(pnlReset, RESETPASS);
		pnlCard.add(pnlRegister, REGISTER);


		this.add(pnlCard, BorderLayout.SOUTH);
		this.add(arriba, BorderLayout.NORTH);

		JLabel img = new JLabel();
		ImageIcon icono = new ImageIcon("resources/databall.png"); //Logo de databall para mostrarlo encima de las interfaces de usuario
		Image imgg = icono.getImage();
		img.setIcon(new ImageIcon(imgg.getScaledInstance(465, 340, Image.SCALE_SMOOTH)));
		arriba.add(img);
		arriba.updateUI();

		//Cuando se clickea en el JLabel "He olvidado mi contraseña" del panel PanelResetPass.java se cambia
		//al mencionado anteriormente.
		pnlLogin.recupearPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				CardLayout cl = (CardLayout)(pnlCard.getLayout());
				cl.show(pnlCard, RESETPASS);
			}
		});

		//Volvemos a cambiar al panel de Login tras pulsar dicho botón
		pnlReset.btnRegresar.addActionListener(actionEvent-> {
			CardLayout cl = (CardLayout)(pnlCard.getLayout());
			cl.show(pnlCard, LOGIN);
		});

		//Botones para cambiar de interfaz
		pnlLogin.btnRegister.addActionListener(actionevent -> {
			CardLayout cl = (CardLayout)(pnlCard.getLayout());
			cl.show(pnlCard, REGISTER);
		});

		pnlRegister.atras.addActionListener(actionEvent-> {
			CardLayout cl = (CardLayout)(pnlCard.getLayout());
			cl.show(pnlCard, LOGIN);
		});

	}
}