package icai.dtc.isw.domain;

import icai.dtc.isw.util.CrearBoton;

import javax.swing.*;
import java.awt.*;

public class PanelResetPass extends JPanel {

    public JButton btnRegresar;

    public PanelResetPass() {

        this.setLayout(new GridLayout(2, 1));

        JPanel fila1 = new JPanel();

        JLabel lblCorreo = new JLabel("Introduce tu correo para recupear la contraseña:");
        fila1.add(lblCorreo);
        JTextField txtCorreo = new JTextField(25);
        fila1.add(txtCorreo);

        this.add(fila1);

        JPanel fila2 = new JPanel();
        JButton btnSendEmail = CrearBoton.normal("Enviar");
        fila2.add(btnSendEmail);

        btnRegresar = CrearBoton.normal("Atrás");
        fila2.add(btnRegresar);

        this.add(fila2);

    }

}
