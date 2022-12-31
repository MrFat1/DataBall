package icai.dtc.isw.domain.login;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.util.Correos;
import icai.dtc.isw.util.CrearBoton;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Random;

/**
 * Panel para restear contraseñas basado en un correo electrónico
 */
public class PanelResetPass extends JPanel {

    public JButton btnRegresar;

    private JTextField txtCorreo;

    public PanelResetPass() {

        this.setLayout(new GridLayout(2, 1));

        JPanel fila1 = new JPanel();

        JLabel lblCorreo = new JLabel("Introduce tu correo para recupear la contraseña:"); //Campo para que el usuario introduza un correo de recuperación
        fila1.add(lblCorreo);
        txtCorreo = new JTextField(25);
        fila1.add(txtCorreo);

        this.add(fila1);

        JPanel fila2 = new JPanel();
        JButton btnSendEmail = CrearBoton.normal("Enviar"); //Botón para enviar el correo al email indicado en el campo de texto
        fila2.add(btnSendEmail);

        //Comprueba que es un correo válido (contiene el @) y envía el correo
        btnSendEmail.addActionListener(actionEvent -> {
            if (txtCorreo.getText().isEmpty() || !(txtCorreo.getText().contains("@"))) {
                JOptionPane.showMessageDialog(this, "Introduce un correo electrónico válido.", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                enviarCorreo(txtCorreo.getText());
            }
        });

        btnRegresar = CrearBoton.normal("Atrás");
        fila2.add(btnRegresar);

        this.add(fila2);

    }

    /**
     * Método para enviar un correo con la contraseña de recuperación
     * @param correo
     */
    private void enviarCorreo(String correo) {

        Client cliente=new Client();
        HashMap<String,Object> session=new HashMap<>();
        String context="/getCorreo"; //Tag para el server
        session.put("correo",  correo);
        session=cliente.sentMessage(context,session);

        //La clase correos devolverá el estado de la confirmación
        if((boolean) session.get("confirmation")) {

            //Generador de contraseñas alfanuméricas aleatorias de 10 caracteres
            String nuevaPass = new Random().ints(10, 97, 122).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

            if (Correos.nuevaContrasena(correo, nuevaPass)) {
                JOptionPane.showMessageDialog(this, "Enviando correo, un momento...", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                txtCorreo.setText("");
                cambiarPass(correo, nuevaPass);
            } else {
                //En caso de error, habrá que comprobar si hay algún problema con el token del correo (Daniel sabe)
                JOptionPane.showMessageDialog(this, "Ha habido un error al enviar el correo, contacta con un Administrador.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Este correo no esta registrado.", "Error", JOptionPane.WARNING_MESSAGE);

    }

    /**
     * Cambia la contraseña de un correo especifico
     * @param correo
     */
    private void cambiarPass(String correo, String nuevaPas) {
        Client cliente=new Client();
        HashMap<String,Object> session=new HashMap<>();
        String context="/cambiarPass"; //Tag para el server
        session.put("correo",  correo);
        session.put("nuevaPas", nuevaPas);
        session=cliente.sentMessage(context,session);
        if((boolean) session.get("confirmation")) {
            JOptionPane.showMessageDialog(this, "Su contraseña se ha actualizado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(this, "Error al actualizar la contraseña, contacte con un Administrador.", "Error", JOptionPane.WARNING_MESSAGE);

    }

}
