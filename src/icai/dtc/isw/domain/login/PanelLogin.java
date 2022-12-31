package icai.dtc.isw.domain.login;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Menu;
import icai.dtc.isw.domain.Usuario;
import icai.dtc.isw.domain.admin.PnlEditarUser;
import icai.dtc.isw.util.CrearBoton;
import icai.dtc.isw.util.DBUtils;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Panel con para inciar sesión.
 */
public class PanelLogin extends JPanel {

    private JButton btnLogin;
    private JTextField txtPassword;
    private JTextField txtUser;

    public Usuario user;

    public JLabel recupearPass;
    public JFrame ventanaLogin;
    public JButton btnRegister;

    public PanelLogin(JFrame ventana) {

        ventanaLogin = ventana; //Nos traemos la ventana principal de login

        this.setLayout(new GridLayout(4,1));

        JPanel fila1 = new JPanel();

        //Campo para que el usuario introduzca el nombre
        JLabel lblUsuario = new JLabel("Introduzca nombre de usuario: ");
        fila1.add(lblUsuario);

        txtUser = new JTextField(15);
        fila1.add(txtUser);

        this.add(fila1);

        JPanel fila2 = new JPanel();

        //Campo para que el usuario introduzca la contraseña
        JLabel lblPassword = new JLabel("Introduzca contraseña: ");
        fila2.add(lblPassword);
        txtPassword = new JPasswordField(10);
        fila2.add(txtPassword);

        this.add(fila2);

        JPanel fila3 = new JPanel();

        btnLogin = CrearBoton.normal("Iniciar sesión");
        btnRegister = CrearBoton.normal("Registrarse"); //Boton para cambiar de interfaz (lo hace el cardLayout en la clase LogIn)
        fila3.add(btnLogin);
        fila3.add(btnRegister);

        this.add(fila3);

        //Comprueba que el campo de texto tenga algo y comprueba los credenciales en la base de datos
        btnLogin.addActionListener(actionEvent -> {
            if (txtUser.getText().isEmpty() || txtPassword.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Porfavor, rellena todos los campos.", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                recuperarInformacion(txtUser.getText(),txtPassword.getText());
            }

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
            user = DBUtils.buscarUser(usuario);
            new Menu(user);
            ventanaLogin.dispose();
        }
        else
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.WARNING_MESSAGE);
    }

}
