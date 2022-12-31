package icai.dtc.isw.domain.admin;

import icai.dtc.isw.util.CrearBoton;
import icai.dtc.isw.util.CrearPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Interfaz principal
 */
public class PanelAdmin extends JPanel {

    public JButton btnEditarUsuario; //Boton para acceder al panel de edición de usuarios

    public PanelAdmin() {

        //Establecemos el diseño
        this.setOpaque(false);
        Font font = new Font("Comic Sans",Font.BOLD, 13);
        Border borde = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.GRAY);
        TitledBorder title = BorderFactory.createTitledBorder(borde, "Editar Usuario", TitledBorder.LEFT, TitledBorder.TOP, font, Color.BLACK);
        this.setBorder(title);

        //Boton para acceder a la edición
        btnEditarUsuario = CrearBoton.normal("Editar usuario");
        this.add(btnEditarUsuario);

        //Boton para actualizar las tablas (proximamente)
        JButton btnActualizarTabla = CrearBoton.normal("Actualizar tablas");
        this.add(btnActualizarTabla);

        //Boton para añadir o quitar videos (proximamente)
        JButton btnEditVideos = CrearBoton.normal("Editar videos");
        this.add(btnEditVideos);

    }

}
