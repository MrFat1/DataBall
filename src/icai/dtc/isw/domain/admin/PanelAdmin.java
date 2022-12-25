package icai.dtc.isw.domain.admin;

import icai.dtc.isw.util.CrearBoton;
import icai.dtc.isw.util.CrearPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelAdmin extends JPanel {

    public JButton btnEditarUsuario;

    public PanelAdmin() {

        this.setOpaque(false);
        Font font = new Font("Comic Sans",Font.BOLD, 13);
        Border borde = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.GRAY);
        TitledBorder title = BorderFactory.createTitledBorder(borde, "Editar Usuario", TitledBorder.LEFT, TitledBorder.TOP, font, Color.BLACK);
        this.setBorder(title);

        btnEditarUsuario = CrearBoton.normal("Editar usuario");
        this.add(btnEditarUsuario);

        JButton btnActualizarTabla = CrearBoton.normal("Actualizar tablas");
        this.add(btnActualizarTabla);

        JButton btnEditVideos = CrearBoton.normal("Editar videos");
        this.add(btnEditVideos);

    }

}
