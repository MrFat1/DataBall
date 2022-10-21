package icai.dtc.isw.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Jugador;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class JVentana extends JFrame {
    public static void main(String[] args) {
        new JVentana();
    }
    private int id;
    public static JComboBox opciones;
    private String correo;
    public JVentana() {
        super("INGENIERÍA DEL SOFTWARE");
        this.setLayout(new BorderLayout());
        //Pongo un panel arriba con el título
        JPanel pnlNorte = new JPanel();
        JLabel lblTitulo = new JLabel("Prueba COMUNICACIÓN", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Courier", Font.BOLD, 20));
        pnlNorte.add(lblTitulo);
        this.add(pnlNorte, BorderLayout.NORTH);

        //Pongo el panel central el botón
        JPanel pnlCentro = new JPanel();
        JPanel pnlCorreo = new JPanel();
        JLabel lblCorreo = new JLabel("Introduzca un jugador");
        JButton btnBusqueda= new JButton("Buscar");
        JTextField txtJugador = new JTextField(20);
        txtJugador.setBounds(new Rectangle(200,350,250,100));
        txtJugador.setHorizontalAlignment(JTextField.LEFT);
        pnlCorreo.add(lblCorreo);
        pnlCorreo.add(txtJugador);
        //pnlCorreo.add(btnCorreo);
        opciones = new JComboBox();
        opciones.addItem("nombre");
        opciones.addItem("posicion");
        opciones.addItem("equipo");
        opciones.addItem("goles");
        opciones.addItem("asistencias");
        opciones.addItem("partidos jugados");
        opciones.addItem("tarjetas amarillas");
        opciones.addItem("tarjetas rojas");

        JLabel lblId = new JLabel("Introduzca su correo", SwingConstants.CENTER);
        JButton btnInformacion = new JButton("Recibir información");
        //JTextField txtCorreo = new JTextField();
        //JTextField txtPassword = new JTextField();
        //txtCorreo.setBounds(new Rectangle(250,150,250,150));
        //txtCorreo.setHorizontalAlignment(JTextField.LEFT);
        pnlCentro.add(lblId);
        //pnlCentro.add(txtCorreo);
        //pnlCentro.add(txtPassword);
        //pnlCentro.add(opciones);
        pnlCentro.add(btnInformacion);
        pnlCentro.setLayout(new BoxLayout(pnlCentro, BoxLayout.	X_AXIS));
        JPanel pnlBusqueda= new JPanel();
        pnlBusqueda.add(txtJugador);
        pnlBusqueda.add(opciones);
        pnlBusqueda.add(btnBusqueda);
        //this.add(pnlCentro, BorderLayout.NORTH);
        this.add(pnlBusqueda,BorderLayout.CENTER);

        //El Sur lo hago para recoger el resultado
        JPanel pnlSur = new JPanel();
        JLabel lblResultado = new JLabel("El resultado obtenido es: ", SwingConstants.CENTER);
        JTextField txtResultado = new JTextField();
        txtResultado.setBounds(new Rectangle(250,150,250,150));
        txtResultado.setHorizontalAlignment(JTextField.LEFT);
        pnlSur.add(lblResultado);
        pnlSur.add(txtResultado);
        //Añado el listener al botón

        btnBusqueda.addActionListener(actionEvent -> {
            Buscar(txtJugador.getText(), (String) opciones.getSelectedItem());
        });
        pnlSur.setLayout(new BoxLayout(pnlSur, BoxLayout.X_AXIS));
        this.add(pnlSur,BorderLayout.SOUTH);

        this.setSize(550,600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public String recuperarInformacion( String correo, String password) {
        Client cliente=new Client();
        String message=new String();
        HashMap<String,Object> session=new HashMap<>();
        String context="/getAccount";
        session.put("correo",correo);
        session.put("password",password);
        session=cliente.sentMessage(context,session);
        if((boolean)session.get("confirmation")==true)
            message="Your account has been confirmed";
        else
            message="Wrong account or wrong password";
        return message;
    }
    public ArrayList<Jugador> Buscar(String Busqueda, String opcion) {
        Client cliente=new Client();
        HashMap<String,Object> session=new HashMap<>();
        String context="/getbusqueda";
        session.put("jugador",Busqueda);
        session.put("opcion",opcion);
        session=cliente.sentMessage(context,session);
        ArrayList<Jugador> lista= (ArrayList<Jugador>) session.get("Jugadores");
        return lista;
    }
    //public static void
}
