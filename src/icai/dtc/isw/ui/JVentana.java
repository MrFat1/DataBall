package icai.dtc.isw.ui;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Jugador;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class JVentana extends JFrame {
    public static void main(String[] args) {
        new JVentana();
    }
    private int id;
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
        JButton btnCorreo= new JButton("Recibir correo");
        JTextField txtJugador = new JTextField(20);
        txtJugador.setBounds(new Rectangle(200,350,250,100));
        txtJugador.setHorizontalAlignment(JTextField.LEFT);
        pnlCorreo.add(lblCorreo);
        pnlCorreo.add(txtJugador);
        pnlCorreo.add(btnCorreo);
        JLabel lblId = new JLabel("Introduzca su correo", SwingConstants.CENTER);
        JButton btnInformacion = new JButton("Recibir información");
        JTextField txtCorreo = new JTextField();
        JTextField txtPassword = new JTextField();
        txtCorreo.setBounds(new Rectangle(250,150,250,150));
        txtCorreo.setHorizontalAlignment(JTextField.LEFT);
        pnlCentro.add(lblId);
        pnlCentro.add(txtCorreo);
        pnlCentro.add(txtPassword);
        pnlCentro.add(btnInformacion);
        pnlCentro.setLayout(new BoxLayout(pnlCentro, BoxLayout.	X_AXIS));
        this.add(pnlCentro, BorderLayout.NORTH);
        this.add(pnlCorreo,BorderLayout.CENTER);

        //El Sur lo hago para recoger el resultado
        JPanel pnlSur = new JPanel();
        JLabel lblResultado = new JLabel("El resultado obtenido es: ", SwingConstants.CENTER);
        JTextField txtResultado = new JTextField();
        txtResultado.setBounds(new Rectangle(250,150,250,150));
        txtResultado.setEditable(false);
        txtResultado.setHorizontalAlignment(JTextField.LEFT);
        pnlSur.add(lblResultado);
        pnlSur.add(txtResultado);
        //Añado el listener al botón
        btnInformacion.addActionListener(actionEvent -> {
            txtResultado.setText(recuperarInformacion(txtCorreo.getText(),txtPassword.getText()));
        });
        btnCorreo.addActionListener(actionEvent -> {
            txtResultado.setText(Jugador(txtCorreo.getText()));
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
    public String Jugador(String jugador) {
        Client cliente=new Client();
        HashMap<String,Object> session=new HashMap<>();
        String context="/getJugador";
        session.put("Nombre",jugador);
        session=cliente.sentMessage(context,session);
        Jugador j=(Jugador) session.get("Jugador");
        return j.getNombre();
    }
}
