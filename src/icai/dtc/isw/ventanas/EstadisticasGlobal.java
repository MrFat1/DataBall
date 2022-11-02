package icai.dtc.isw.ventanas;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Jugador;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class EstadisticasGlobal extends JFrame{

    private static ArrayList<Jugador> jugadores;

    public static void main(String[] args) {
        new EstadisticasGlobal();
        //recuperarData();
    }

    public static void recuperarData() {

        Client cliente = new Client();
        HashMap<String,Object> session = new HashMap<>();
        String context= "/getListaJugadores";
        cliente.sentMessage(context,session); //Devuelve un hashmap con la lista de jugadores en la clase Client
        jugadores = cliente.jugadores;
        new EstadisticasGlobal();
    }

    public EstadisticasGlobal(){

        super("Tabla de jugadores");

        String[] columnas = {"Nombre","Posición","Equipo", "NumPartidos", "Goles", "Asistencias", "Amarillas", "Rojas"};

        String[][] data = new String[10][10];

        //Rellenamos el array data[][] con toda la info de cada jugador.
        int i;
        for (i=0; i < jugadores.size(); i++) {
            data[i] = jugadores.get(i).getStats().toArray(new String[0]);
        }

        JTable tabla = new JTable(data,columnas);
        tabla.setEnabled(false);
        //jt.setBounds(30,40,200,300);

        JScrollPane sp = new JScrollPane(tabla);
        this.add(sp);
        this.setSize(300,200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
