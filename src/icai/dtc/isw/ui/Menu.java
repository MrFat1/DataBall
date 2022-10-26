package icai.dtc.isw.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.Color.black;
import static java.awt.Color.green;

public class Menu extends JFrame {
    public static void main(String[] args) {
        new Menu();
    }
    public Menu()
    {
        super("DataBall");
        this.setFont(new Font("fondo",3,20));
        this.setSize(400,500);
        this.setLocation(300,100);
        JPanel pestañas=new JPanel();
        pestañas.setLayout(new GridLayout(1,4));
        JLabel Busqueda= new JLabel("Buscar Jugadores");
        Busqueda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new JVentana();
            }
        });
        JLabel Videos= new JLabel("Videos");
        pestañas.add(Busqueda);
        pestañas.add(Videos);
        this.add(pestañas,BorderLayout.NORTH);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

}
