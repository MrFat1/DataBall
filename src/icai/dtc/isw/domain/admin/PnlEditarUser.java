package icai.dtc.isw.domain.admin;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Usuario;
import icai.dtc.isw.util.CrearBoton;
import icai.dtc.isw.util.DBUtils;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.HashMap;

public class PnlEditarUser extends JPanel {

    public JButton btnRegresar;

    public PnlEditarUser() {

        this.setOpaque(false);
        Font font = new Font("Comic Sans",Font.BOLD, 13);
        Border borde = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.GRAY);
        TitledBorder title = BorderFactory.createTitledBorder(borde, "Editar Usuario", TitledBorder.LEFT, TitledBorder.TOP, font, Color.BLACK);
        this.setBorder(title);

        JTextField txtBuscarUser = new JTextField(20);
        this.add(txtBuscarUser);

        JButton buscar = CrearBoton.normal("Buscar");
        this.add(buscar);

        buscar.addActionListener(actionEvent -> {

            if (txtBuscarUser.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Introduce un usuario", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Usuario user = DBUtils.buscarUser(txtBuscarUser.getText());
                if (user == null) {
                    JOptionPane.showMessageDialog(this, "Ese usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    txtBuscarUser.setText("");
                    new vtnEditUser(user);
                }
            }

        });

        btnRegresar = CrearBoton.normal("Atrás");
        this.add(btnRegresar);


    }

}