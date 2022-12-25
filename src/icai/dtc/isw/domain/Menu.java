package icai.dtc.isw.domain;

import icai.dtc.isw.domain.admin.PanelAdminMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Menu principal del proyecto
 */
public class Menu extends JFrame {

    public Menu(Usuario user)
    {
        super("DataBall");

        this.setSize(1000,650);
        this.setLocation(100,0);
        this.setVisible(true);

        JTabbedPane pestanas=new JTabbedPane();
        this.add(pestanas);

       	Icon conoP = new ImageIcon((new ImageIcon(("resources/icon-profile.png")).getImage()).getScaledInstance(20,20,Image.SCALE_SMOOTH));
        Icon conoC = new ImageIcon((new ImageIcon(("resources/img-chat.png")).getImage()).getScaledInstance(20,20,Image.SCALE_SMOOTH));
        Icon conoV = new ImageIcon((new ImageIcon(("resources/img-video.png")).getImage()).getScaledInstance(30,20,Image.SCALE_SMOOTH));
        Icon conoB = new ImageIcon((new ImageIcon(("resources/icon-busqueda.png")).getImage()).getScaledInstance(20,20,Image.SCALE_SMOOTH));
        Icon conoA = new ImageIcon((new ImageIcon(("resources/icon-admin.png")).getImage()).getScaledInstance(20,20,Image.SCALE_SMOOTH));
        pestanas.addTab("Buscador",conoB,new JVentana());
        pestanas.addTab("Videos",conoV,new PanelVideo());
        pestanas.addTab("Perfil",conoP,new JPanel()); //Proximamente
        pestanas.addTab("Chat",conoC,new JPanel()); //Proximamente
        pestanas.addTab("Admin",conoA, new PanelAdminMain());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
