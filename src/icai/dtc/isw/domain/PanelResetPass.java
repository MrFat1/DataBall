package icai.dtc.isw.domain;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.util.Correos;
import icai.dtc.isw.util.CrearBoton;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

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
            enviarCorreo(txtCorreo.getText());
        });

        btnRegresar = CrearBoton.normal("Atrás");
        fila2.add(btnRegresar);

        this.add(fila2);

    }

    private void enviarCorreo(String correo) {

        Client cliente=new Client();
        HashMap<String,Object> session=new HashMap<>();
        String context="/getCorreo"; //Tag para el server
        session.put("correo",  correo);
        session=cliente.sentMessage(context,session);
        if((boolean) session.get("confirmation")) {
            JOptionPane.showMessageDialog(this, "Se ha enviado un correo con una nueva contraseña.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            Correos.nuevaContrasena(correo, "test");
            txtCorreo.setText("");

        }
        else
            JOptionPane.showMessageDialog(this, "Este correo no esta registrado.", "Error", JOptionPane.INFORMATION_MESSAGE);

    }

}
