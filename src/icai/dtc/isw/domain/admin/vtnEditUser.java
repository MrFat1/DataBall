package icai.dtc.isw.domain.admin;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Usuario;
import icai.dtc.isw.util.CrearBoton;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Ventana emergente para editar un usuario específico
 */
public class vtnEditUser extends JFrame {

    private Usuario usuario; //Usuario a editar
    private JTextField txtNombre; //Nombre del usuario (para poder hacer una comparación mas adelante)
    private JTextField txtCorreo; //Correo del usuario (para poder hacer una comparación mas adelante)
    private JComboBox cmbRol; //Rol del usuario (para poder hacer una comparación mas adelante)
    private boolean pulsado;

    /**
     * El administrador dispondra de varios cuadros de texto con toda la informacion del usuario seleccionado.
     * Este podra editar tantos campos como desee sin guardar los cambios. EN el momento que pulse el boton de
     * guardar, todo lo que haya escrito en los textField se guardará en la base de datos.
     * @param user Usuario a editar
     */
    public vtnEditUser(Usuario user) {

        this.setTitle("Editar usuario");

        usuario = user;

        this.setLayout(new GridLayout(5,1));

        JPanel pnlNombre = new JPanel();

        JLabel lblNombre = new JLabel("Nombre: ");
        txtNombre = new JTextField(10);
        txtNombre.setText(user.getNombre());

        pnlNombre.add(lblNombre);
        pnlNombre.add(txtNombre);

        this.add(pnlNombre);

        JPanel pnlCorreo = new JPanel();

        JLabel lblCorreo = new JLabel("Correo: ");
        txtCorreo = new JTextField(20);
        txtCorreo.setText(user.getCorreo());

        pnlCorreo.add(lblCorreo);
        pnlCorreo.add(txtCorreo);

        this.add(pnlCorreo);

        JPanel pnlPass = new JPanel();

        JLabel lblPass = new JLabel("Contraseña: ");
        JLabel lblMostrarPass = new JLabel("**********");
        JButton btnMostrarPass = CrearBoton.normal("Mostrar");

        //Comprobación del estado del botón para la lógica de mostrar / ocultar la contraseña
        pulsado = false;

        btnMostrarPass.addActionListener(actionEvent -> {
            if (!pulsado) {
                lblMostrarPass.setText(user.getPassword());
                btnMostrarPass.setText("Ocultar");
                pulsado = true;
            } else {
                lblMostrarPass.setText("**********");
                btnMostrarPass.setText("Mostrar");
                pulsado = false;
            }

        });

        pnlPass.add(lblPass);
        pnlPass.add(lblMostrarPass);
        pnlPass.add(btnMostrarPass);

        this.add(pnlPass);

        JPanel pnlRol = new JPanel();

        JLabel lblRol = new JLabel("Rol: ");

        //Para evitar andar haciendo comprobaciones en código, limitamos las opciones de selección a los roles existentes
        cmbRol = new JComboBox();
        cmbRol.addItem("usuario");
        cmbRol.addItem("admin");
        cmbRol.addItem("periodista");
        cmbRol.addItem("moderador");

        cmbRol.setSelectedItem(user.getRol());

        pnlRol.add(lblRol);
        pnlRol.add(cmbRol);

        this.add(pnlRol);

        JPanel pnlSave = new JPanel();

        JButton btnSave = CrearBoton.normal("Guardar");

        //Guardado en la base de datos con comprobación
        btnSave.addActionListener(actionEvent -> {

            int opc = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres guardar la información actual de los campos de texto?",
                    "Confirmación de guardado", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (opc == JOptionPane.YES_OPTION) {
                guardarData();
            }
        });

        pnlSave.add(btnSave);

        this.add(pnlSave);

        this.setVisible(true);
        this.setSize(600,250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void guardarData() {

        Client cliente=new Client();
        HashMap<String,Object> session=new HashMap<>();
        String context="/updateUser";

        session.put("nombreOriginal",  usuario.getNombre()); //Para saber que usuario vamos a editar en base al nombre

        //Comprobamos los campos que han sido editados y en caso de haberlo sido, los metemos en la sesion para editarlos en la base de datos

        if (!(usuario.getNombre().equals(txtNombre.getText()))) {
            session.put("usuario",txtNombre.getText());
        }

        if (!(usuario.getCorreo().equals(txtCorreo.getText()))) {
            session.put("correo",txtCorreo.getText());
        }

        if (!(usuario.getRol().equals(cmbRol.getSelectedItem()))) {

            session.put("rol",cmbRol.getSelectedItem());

        }

        session= cliente.sentMessage(context,session);


        if ((boolean) session.get("confirmation")) {

            JOptionPane.showMessageDialog(this, "Usuario editado correctamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this, "Error al editar el usuario, consulta la consola", "Error", JOptionPane.ERROR_MESSAGE);
        }



    }
}
