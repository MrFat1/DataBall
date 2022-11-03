package icai.dtc.isw.ventanas;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Jugador;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class EstadisticasGlobal extends JPanel{

    private static ArrayList<Jugador> jugadores;

    public static void main(String[] args) {
        //new EstadisticasGlobal(null);
        //recuperarData();
    }
    public EstadisticasGlobal(ArrayList<Jugador> jugadores,JPanel panel){
        String[] columnas = {"Nombre","Posición","Equipo", "NumPartidos", "Goles", "Asistencias", "Amarillas", "Rojas"};

        String[][] data = new String[jugadores.size()][jugadores.size()];

        //Rellenamos el array data[][] con toda la info de cada jugador.
        if(jugadores!=null)
        {
            int i;
            for (i=0; i < jugadores.size(); i++) {
                data[i] = jugadores.get(i).getStats().toArray(new String[0]);
            }
        }
        JTable tabla = new JTable(data,columnas);
        tabla.setEnabled(false);
        //jt.setBounds(30,40,200,300);

        JScrollPane sp = new JScrollPane(tabla);
        panel.add(sp);
        panel.updateUI();

    }
}
