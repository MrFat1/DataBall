package icai.dtc.isw.domain.admin;

import icai.dtc.isw.util.CrearPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Panel principal
 */
public class PanelAdminMain extends JPanel {

    //Configuramos el CardLayout
    final static String ADMIN = "Admin"; //Interfaz principal
    final static String EDITAR_USER = "Buscar usuario"; //Panel de edición de usuario

    PanelAdmin pnlAdmin = new PanelAdmin();
    PnlEditarUser pnlEditarUser = new PnlEditarUser();

    public PanelAdminMain() {

        this.setLayout(new GridLayout(2, 1));

        JPanel pnlArriba = CrearPanel.titled("Estado del servidor");

        /*if (socket.isConnected()) {
            estadoServer.add(new JLabel("Conectado"));
        } else {
            estadoServer.add(new JLabel("Desconectado"));
        }*/

        this.add(pnlArriba);

        JPanel pnlCard = new JPanel();

        pnlCard.setLayout(new CardLayout(0, 0));
        pnlCard.add(pnlAdmin, ADMIN);
        pnlCard.add(pnlEditarUser, EDITAR_USER);

        //Botones para moverse entre los distintos paneles (interfaces)
        pnlAdmin.btnEditarUsuario.addActionListener(actionEvent-> {
            CardLayout cl = (CardLayout)(pnlCard.getLayout());
            cl.show(pnlCard, EDITAR_USER);
        });

        pnlEditarUser.btnRegresar.addActionListener(actionEvent -> {
            CardLayout cl = (CardLayout) (pnlCard.getLayout());
            cl.show(pnlCard, ADMIN);
        });

        this.add(pnlCard);

        this.setVisible(true);
        this.setSize(500,500);

    }

}
