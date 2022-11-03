package icai.dtc.isw.domain;

import icai.dtc.isw.ui.JVentana;
import icai.dtc.isw.ventanas.EstadisticasGlobal;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame {
    public static void main(String[] args) {
        new Menu();
    }

    //Identificadores de paneles
    final static String EST = "Estadisticas";

    JPanel pnlCentro;
    EstadisticasGlobal estg = new EstadisticasGlobal(null,pnlCentro);

    public Menu()
    {
        super("DataBall");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pnlCentro = new JPanel();
        pnlCentro.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(pnlCentro);
        pnlCentro.setLayout(new CardLayout(0, 0));

        //Añadir las ventanas al contenedor
        pnlCentro.add(estg,EST);

        this.setSize(400,500);
        this.setLocation(300,100);
        this.setVisible(true);

        /*JPanel pestañas=new JPanel();
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
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });*/

    }

}
