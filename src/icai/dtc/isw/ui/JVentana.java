package icai.dtc.isw.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Equipo;
import icai.dtc.isw.domain.Jugador;
import icai.dtc.isw.domain.Menu;

import icai.dtc.isw.util.JugadoresToTable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class JVentana extends JPanel {

    private static JComboBox opciones_j;
    private static JComboBox opciones_e;
    private static ArrayList<Jugador> jugadores=new ArrayList<Jugador>();
    //Defino al crear la ventana para que clase va a buscar
    public String busqueda;

    public static void main(String[] args) {
        JFrame jframe= new JFrame();
        JTabbedPane pestañas=new JTabbedPane();
        pestañas.addTab("Buscador",new JVentana("jugadores"));
        pestañas.addTab("Equipos", new JVentana("equipos"));
        jframe.add(pestañas);
        jframe.setSize(600,600);
        jframe.setVisible(true);
        jframe.add(new Scrollbar());
    }
    public JVentana(String busqueda) {
        this.busqueda=busqueda;

        //Pongo un panel arriba con el título
        JLabel lblTitulo = new JLabel("Prueba COMUNICACIÓN", SwingConstants.CENTER);
        this.setLayout(new GridLayout(1,2));
        lblTitulo.setFont(new Font("Courier", Font.BOLD, 20));
        JButton btnBusqueda= new JButton("Buscar");
        JTextField txtJugador = new JTextField(20);
        txtJugador.setBounds(new Rectangle(200,350,250,100));
        txtJugador.setHorizontalAlignment(JTextField.LEFT);
        JPanel pnlBusqueda= new JPanel();
        pnlBusqueda.add(txtJugador);
        this.setSize(600,600);
        if(busqueda=="jugadores")
        {
            opciones_j= new JComboBox();
            opciones_j.addItem("nombre");
            opciones_j.addItem("posicion");
            opciones_j.addItem("equipo");
            opciones_j.addItem("goles");
            opciones_j.addItem("asistencias");
            opciones_j.addItem("partidos jugados");
            opciones_j.addItem("tarjetas amarillas");
            opciones_j.addItem("tarjetas rojas");
            pnlBusqueda.add(opciones_j);
        }
        if(busqueda=="equipos")
        {
            opciones_e= new JComboBox();
            opciones_e.addItem("nombre");
            opciones_e.addItem("entrenador");
            opciones_e.addItem("presidente");
            opciones_e.addItem("posicion");
            opciones_e.addItem("capacidad");
            opciones_e.addItem("masasalarial");
            opciones_e.addItem("estadio");
            pnlBusqueda.add(opciones_e);
        }
        JButton btnOrdenar=new JButton("Ordenar");
        pnlBusqueda.add(btnBusqueda);
        pnlBusqueda.add(btnOrdenar);
        //El Sur lo hago para recoger el resultado
        //Scrollbar barra =new Scrollbar();
        //pnlSur.add(barra,BorderLayout.EAST);
        //txtResultado.setMaximumSize(new Dimension(100,100));
        //btnBusqueda.addActionListener(CardLayout());
        btnOrdenar.addActionListener(actionEvent ->{
            if(busqueda=="jugadores")
            {
                ArrayList<Jugador> listaJugadores =OrdenarJugadores((String) opciones_j.getSelectedItem());
                //txtResultado.setText("");
                for(Jugador j: listaJugadores)
                {
                    //txtResultado.setText(txtResultado.getText()+"\n"+j.MostrarJugador());
                }
            }
            if(busqueda=="equipos")
            {
                //ArrayList<Equipo> listaEquipos = OrdenarEquipo((String) opciones_e.getSelectedItem());
                //txtResultado.setText("");
                /*for(Equipo e: listaEquipos) {
                    txtResultado.setText(txtResultado.getText()+"\n"+e.MostrarEquipo());}
                }*/
        }});
        //pnlSur.setMaximumSize(new Dimension(100,100));
        btnBusqueda.addActionListener(actionEvent -> {
            //Lista que contendrá todos los jugadores obtenidos en la búsqueda.
            if(busqueda=="jugadores")
            {
                jugadores = BuscarJugador(txtJugador.getText().trim(), (String) this.opciones_j.getSelectedItem());
                JugadoresToTable.convertir(jugadores,pnlBusqueda);

            }
            if(busqueda=="equipos")
            {
                ArrayList<Equipo> listaEquipos = BuscarEquipo(txtJugador.getText().trim(), (String) this.opciones_e.getSelectedItem());
                //txtResultado.setText("");
                if (listaEquipos.size()==0) {
                    JOptionPane.showMessageDialog(this, "No se han encontrado resultados", "Error", JOptionPane.WARNING_MESSAGE);}
                /*else {
                    for(Equipo e: listaEquipos) {
                        txtResultado.setText(txtResultado.getText()+"\n"+e.MostrarEquipo());}
                }*/
            }
        });
        //pnlSur.setLayout(new BoxLayout(pnlSur, BoxLayout.Y_AXIS));
        //pnlSur.setMaximumSize(new Dimension(200,200));

        //Parte grafica

        this.add(pnlBusqueda,"Busqueda");
        this.setSize(550,600);

        this.setVisible(true);


    }
    public ArrayList<Jugador> BuscarJugador(String Busqueda, String opcion) {
        Client cliente=new Client();
        if(opcion=="tarjetas amarillas")
        {
            opcion="tamarillas";
        }
        if(opcion=="tarjetas rojas")
        {
            opcion="trojas";
        }
        HashMap<String,Object> session=new HashMap<>();
        String context="/getbusqueda";
        session.put("jugador",Busqueda);
        session.put("opcion",opcion);
        cliente.sentMessage(context,session);
        ArrayList<Jugador> lista=cliente.jugadoresOpc;
        return lista;
    }
    public ArrayList<Jugador> OrdenarJugadores(String opcion)
    {
        Client cliente= new Client();
        HashMap<String,Object> session=new HashMap<>();
        String context="/ordenarJugadores";
        session.put("opcion",opcion);
        cliente.sentMessage(context,session);
        ArrayList<Jugador> lista=cliente.jugadoresOpc;
        return lista;
    }
    public ArrayList<Equipo> BuscarEquipo(String busqueda,String opcion)
    {
        Client cliente=new Client();
        HashMap<String,Object> session=new HashMap<>();
        String context="/getequipo";
        session.put("equipo",busqueda);
        session.put("opcion",opcion);
        cliente.sentMessage(context,session);
        ArrayList<Equipo> lista=cliente.equipos;
        return lista;
    }
    public ArrayList<Equipo> OrdenarEquipo(String opcion)
    {
        Client cliente= new Client();
        HashMap<String,Object> session=new HashMap<>();
        String context="/ordenarEquipos";
        session.put("opcion",opcion);
        cliente.sentMessage(context,session);
        ArrayList<Equipo> lista=cliente.equipos;
        return lista;
    }
    public String Jugador(String nombre) {
        Client cliente=new Client();
        HashMap<String,Object> session=new HashMap<>();
        String context="/getJugador";
        session.put("Nombre", nombre);
        session=cliente.sentMessage(context,session);
        Jugador j=(Jugador) session.get("Jugador");

        return j.MostrarJugador();
    }

}
