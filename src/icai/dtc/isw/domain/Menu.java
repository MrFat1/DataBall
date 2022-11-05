package icai.dtc.isw.domain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Menu principal del proyecto
 */
public class Menu extends JFrame {
    public static void main(String[] args) {
        new Menu("");
    }

    String user;

    public Menu(String usuario)
    {
        super("DataBall");
        user = usuario;

        this.setSize(1000,650);
        this.setLocation(100,0);
        this.setVisible(true);

        JTabbedPane pestañas=new JTabbedPane();
        this.add(pestañas);
       	Icon conoP = new ImageIcon((new ImageIcon(("resources/icon-profile.png")).getImage()).getScaledInstance(20,20,Image.SCALE_SMOOTH));
        Icon conoC = new ImageIcon((new ImageIcon(("resources/img-chat.png")).getImage()).getScaledInstance(20,20,Image.SCALE_SMOOTH));
        Icon conoV = new ImageIcon((new ImageIcon(("resources/img-video.png")).getImage()).getScaledInstance(30,20,Image.SCALE_SMOOTH));
        pestañas.addTab("Buscador",new JVentana());
        pestañas.addTab("Videos",conoV,new PanelVideo());
        pestañas.addTab("Perfil",conoP,new JPanel()); //Proximamente
        pestañas.addTab("Chat",conoC,new JPanel()); //Proximamente
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}
