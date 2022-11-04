package icai.dtc.isw.ventanas;

import icai.dtc.isw.domain.Equipo;
import icai.dtc.isw.domain.Jugador;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JugadoresToTable extends JPanel{

    public JugadoresToTable(ArrayList<Jugador> jugadores, JPanel panel){

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

        JScrollPane sp = new JScrollPane(tabla);
        panel.add(sp);
        panel.updateUI();
    }
    public static void EquiposToTable(ArrayList<Equipo> equipos, JPanel panel)
    {
        String[] columnas = {"Nombre","Entrenador","Presidente", "Posicion", "Capacidad", "Masa salarial", "Estadio"};
        String[][] data = new String[equipos.size()][equipos.size()];
        if(equipos!=null)
        {
            int i;
            for (i=0; i < equipos.size(); i++) {
                data[i] = equipos.get(i).getStats().toArray(new String[0]);
            }
        }

        JTable tabla = new JTable(data,columnas);
        tabla.setEnabled(false);
        JScrollPane sp = new JScrollPane(tabla);
        panel.add(sp, BorderLayout.CENTER);
        panel.updateUI();
    }
}
