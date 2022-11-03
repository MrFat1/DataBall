package icai.dtc.isw.domain;

import icai.dtc.isw.ui.JVentana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame {
    public static void main(String[] args) {
        new Menu();
    }
    public static JTabbedPane pestañas;
    public Menu()
    {
        super("DataBall");
        this.setFont(new Font("fondo",3,20));
        this.setSize(400,500);
        this.setLocation(300,100);
        pestañas=new JTabbedPane();
        pestañas.addTab("Jugadores",new JVentana("jugadores"));
        JLabel Busqueda= new JLabel("Buscar Jugadores");
        JLabel Videos= new JLabel("Videos");
        pestañas.addTab("Equipos",new JVentana("equipos"));
        pestañas.add(Videos);
        this.add(pestañas);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

}
