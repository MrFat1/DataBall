package icai.dtc.isw.domain;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.util.Correos;
import icai.dtc.isw.util.CrearBoton;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Random;

public class PanelResetPass extends JPanel {

    public JButton btnRegresar;

    private JTextField txtCorreo;

    public PanelResetPass() {

        this.setLayout(new GridLayout(2, 1));

        JPanel fila1 = new JPanel();

        JLabel lblCorreo = new JLabel("Introduce tu correo para recupear la contraseña:");
        fila1.add(lblCorreo);
        txtCorreo = new JTextField(25);
        fila1.add(txtCorreo);

        this.add(fila1);

        JPanel fila2 = new JPanel();
        JButton btnSendEmail = CrearBoton.normal("Enviar");
        fila2.add(btnSendEmail);

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
        if((boolean) session.get("confirmation")) {
            JOptionPane.showMessageDialog(this, "Se ha enviado un correo con una nueva contraseña.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            String nuevaPass = new Random().ints(10, 97, 122).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
            if (Correos.nuevaContrasena(correo, nuevaPass)) {
                txtCorreo.setText("");
                cambiarPass(correo, nuevaPass);
            } else {
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
