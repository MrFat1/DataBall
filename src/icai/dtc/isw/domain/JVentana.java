package icai.dtc.isw.domain;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.util.ToTable;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class JVentana extends JPanel {

    private JComboBox opciones_j;
    private JComboBox opciones_e;
    private ArrayList<Jugador> jugadores=new ArrayList<Jugador>();
    private JScrollPane tabla=new JScrollPane();

    public JVentana() {

        //Pongo un panel arriba con el título
        JLabel lblTitulo = new JLabel("Prueba COMUNICACIÓN", SwingConstants.CENTER);
        this.setLayout(new GridLayout(1,2));
        lblTitulo.setFont(new Font("Courier", Font.BOLD, 20));
        JButton btnJugadores= new JButton("Buscar Jugadores");
        JButton btnEquipos= new JButton("Buscar Equipos");
        JTextField txtJugador = new JTextField(20);
        txtJugador.setBounds(new Rectangle(200,350,250,100));
        txtJugador.setHorizontalAlignment(JTextField.LEFT);
        JPanel pnlBusqueda= new JPanel();
        pnlBusqueda.add(txtJugador);
        this.setSize(1000,1000);
        opciones_j= new JComboBox();
        opciones_j.addItem("nombre");
        opciones_j.addItem("posicion");
        opciones_j.addItem("equipo");
        opciones_j.addItem("goles");
        opciones_j.addItem("asistencias");
        opciones_j.addItem("partidos jugados");
        opciones_j.addItem("tarjetas amarillas");
        opciones_j.addItem("tarjetas rojas");
        JLabel lblJugadores =new JLabel("Opcion de jugadores");
        pnlBusqueda.add(lblJugadores);
        pnlBusqueda.add(opciones_j);
        opciones_e= new JComboBox();
        opciones_e.addItem("nombre");
        opciones_e.addItem("entrenador");
        opciones_e.addItem("presidente");
        opciones_e.addItem("posicion");
        opciones_e.addItem("capacidad");
        opciones_e.addItem("masasalarial");
        opciones_e.addItem("estadio");
        pnlBusqueda.add(opciones_e);
        pnlBusqueda.add(btnJugadores);
        pnlBusqueda.add(btnEquipos);
        btnEquipos.addActionListener(actionEvent-> {
            ArrayList<Equipo> listaEquipos = BuscarEquipo(txtJugador.getText().trim(), (String) this.opciones_e.getSelectedItem());
            //txtResultado.setText("");
            if (listaEquipos.size()==0) {
                JOptionPane.showMessageDialog(this, "No se han encontrado resultados", "Error", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                pnlBusqueda .remove(tabla);
                ArrayList<Equipo >equipos = BuscarEquipo(txtJugador.getText().trim(),(String) this.opciones_e.getSelectedItem());
                tabla= ToTable.equipos(equipos);
                pnlBusqueda.add(tabla);
                this.updateUI();
            }
        });
        btnJugadores.addActionListener(actionEvent -> {
            //Lista que contendrá todos los jugadores obtenidos en la búsqueda.
            pnlBusqueda.remove(tabla);
            jugadores = BuscarJugador(txtJugador.getText().trim(), (String) this.opciones_j.getSelectedItem());
            tabla= ToTable.jugadores(jugadores);
            pnlBusqueda.add(tabla);
            this.updateUI();
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
        {opcion="tamarillas";}
        if(opcion=="tarjetas rojas")
        {opcion="trojas";}
        HashMap<String,Object> session=new HashMap<>();
        String context="/getbusqueda";
        session.put("jugador",Busqueda);
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
