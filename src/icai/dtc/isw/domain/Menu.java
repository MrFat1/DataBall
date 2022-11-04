package icai.dtc.isw.domain;

import icai.dtc.isw.ui.JVentana;
import icai.dtc.isw.util.JugadoresToTable;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Menu extends JFrame {
    public static void main(String[] args) {
        new Menu();
    }

    //Identificadores de paneles
    final static String EST = "Estadisticas";

    JPanel pnlCentro;

    public Menu()
    {
        super("DataBall");

        /*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pnlCentro = new JPanel();
        pnlCentro.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(pnlCentro);
        pnlCentro.setLayout(new CardLayout(0, 0));
*/
        //Añadir las ventanas al contenedor
        //pnlCentro.add(estg,EST);

        this.setSize(1000,650);
        this.setLocation(100,0);
        this.setVisible(true);

        JTabbedPane pestañas=new JTabbedPane();
        this.add(pestañas);
        ImageIcon icono= new ImageIcon("resources/icon-profile.png");
        Image imgg = icono.getImage();
       	Icon conoP =new ImageIcon(imgg.getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        Icon conoC = new ImageIcon((new ImageIcon(("resources/img.png")).getImage()).getScaledInstance(20,20,Image.SCALE_SMOOTH));
        Icon conoV = new ImageIcon((new ImageIcon(("resources/video.png")).getImage()).getScaledInstance(24,21,Image.SCALE_SMOOTH));
        pestañas.addTab("Buscador",new JVentana());
        pestañas.addTab("Videos",conoV,new JPanel());
        pestañas.addTab("Perfil",conoP,new JPanel());
        pestañas.addTab("Chat",conoC,new JPanel());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}
