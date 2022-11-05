package icai.dtc.isw.domain;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.util.CrearBoton;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class PanelLogin extends JPanel {

    private JButton btnLogin;
    private JTextField txtPassword;
    private JTextField txtUser;

    public JLabel recupearPass;
    public JFrame ventanaLogin;
    public JButton btnRegister;

    public PanelLogin(JFrame ventana) {

        ventanaLogin = ventana; //Nos traemos la ventana principal de login

        this.setLayout(new GridLayout(4,1));

        JPanel fila1 = new JPanel();

        JLabel lblUsuario = new JLabel("Introduzca nombre de usuario: ");
        fila1.add(lblUsuario);

        txtUser = new JTextField(15);
        fila1.add(txtUser);

        this.add(fila1);

        JPanel fila2 = new JPanel();

        JLabel lblPassword = new JLabel("Introduzca contraseña: ");
        fila2.add(lblPassword);
        txtPassword = new JPasswordField(10);
        fila2.add(txtPassword);

        this.add(fila2);

        JPanel fila3 = new JPanel();

        btnLogin = CrearBoton.normal("Iniciar sesión");
        btnRegister = CrearBoton.normal("Registrarse");
        fila3.add(btnLogin);
        fila3.add(btnRegister);

        this.add(fila3);

        btnLogin.addActionListener(actionEvent -> {
            recuperarInformacion(txtUser.getText(),txtPassword.getText());
        });

        JPanel fila4 = new JPanel();
        recupearPass = new JLabel("He olvidado mi contraseña");
        fila4.add(recupearPass);
        this.add(fila4);

        this.updateUI();
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
            new Menu(txtUser.getText());
            ventanaLogin.dispose();
        }
        else
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.INFORMATION_MESSAGE);
    }

}
