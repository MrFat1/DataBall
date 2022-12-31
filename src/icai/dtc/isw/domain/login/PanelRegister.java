package icai.dtc.isw.domain.login;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Menu;
import icai.dtc.isw.domain.Usuario;
import icai.dtc.isw.util.CrearBoton;
import icai.dtc.isw.util.DBUtils;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Panel con la lógica de registro
 */
public class PanelRegister extends JPanel {

    public JButton btnRegister;
    public JButton atras;

    private JPasswordField txtPassword;
    private JTextField txtCorreo;
    private JTextField txtUser;
    private JFrame login;

    //Interfaz de registro de usuarios
    public PanelRegister(JFrame ventanaLogin) {

        login = ventanaLogin;

        this.setLayout(new GridLayout(4,1));

        JPanel fila1 = new JPanel();

        JLabel lblUsuario = new JLabel("Añade un nombre de usuario: "); //Campo para que el usuario rellene la información
        fila1.add(lblUsuario);

        txtUser = new JTextField(15);
        fila1.add(txtUser);

        this.add(fila1);

        JPanel fila2 = new JPanel();

        JLabel lblPassword = new JLabel("Añade una contraseña: "); //Campo para que el usuario rellene la información
        fila2.add(lblPassword);
        txtPassword = new JPasswordField(15);
        fila2.add(txtPassword);

        this.add(fila2);

        //Juan
        JPanel fila3 =new JPanel();

        JLabel lblCorreo=new JLabel("Añade un correo"); //Campo para que el usuario rellene la información
        txtCorreo= new JTextField(20);
        fila3.add(lblCorreo);
        fila3.add(txtCorreo);

        this.add(fila3);

        JPanel fila4 = new JPanel();

        btnRegister = CrearBoton.normal("Registrarse"); //Boton de registro
        fila4.add(btnRegister);
        atras = CrearBoton.normal("Atrás"); //Botón de cambio de interfaz
        fila4.add(atras);

        this.add(fila4);

        //Registra al usuario en la base de datos si todos los campos estan llenos
        btnRegister.addActionListener(actionEvent->{
            if (txtUser.getText().isEmpty() || txtPassword.getText().isEmpty() || txtCorreo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Porfavor, rellena todos los campos.", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                Register(txtUser.getText(),txtCorreo.getText(),txtPassword.getText());
            }


        });

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

        //Dependiendo del resultado de intentar guardar al usuario en la base de datos hará una cosa u otra.
        if(session.get("confirmation").equals("bien")) { //if resultadoRegister equals ()
            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente", "Bienvenido a Databall", JOptionPane.INFORMATION_MESSAGE);
            txtPassword.setText("");;
            txtUser.setText("");
            txtCorreo.setText("");
            login.dispose();
            Usuario user = DBUtils.buscarUser(nombre);
            new Menu(user);
        } else if (session.get("confirmation").equals("error-correo")) {
            JOptionPane.showMessageDialog(this, "Error: Este correo ya existe", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (session.get("confirmation").equals("error-usuario")) {
            JOptionPane.showMessageDialog(this, "Error: Este usuario ya existe", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (session.get("confirmation").equals("error-contraseña")) {
            JOptionPane.showMessageDialog(this, "Error: La contraseña debe ser alfanumérica", "Error", JOptionPane.WARNING_MESSAGE);
            txtPassword.setText("");
        } else
            JOptionPane.showMessageDialog(this, "Error desconocido, contacta con un administrador.", "Error", JOptionPane.WARNING_MESSAGE);

    }

}
