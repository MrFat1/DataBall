package icai.dtc.isw.util;

import icai.dtc.isw.domain.Equipo;
import icai.dtc.isw.domain.Jugador;
import icai.dtc.isw.domain.Usuario;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Clase para convertir arrays de datos en tablas
 */
public class ToTable extends JPanel{

    /**
     * Método para añadir un array a una tabla
     * @param array Array a añadir
     */
    public static JScrollPane jugadores(ArrayList<Jugador> array){

        String[] columnas = {"Nombre","Posición","Equipo", "NumPartidos", "Goles", "Asistencias", "Amarillas", "Rojas"};

        String[][] data = new String[array.size()][array.size()];

        //Rellenamos el array data[][] con toda la info de cada jugador.
        if(array!=null)
        {
            int i;
            for (i=0; i < array.size(); i++) {
                data[i] = array.get(i).getStats().toArray(new String[0]);
            }
        }
        JTable tabla = new JTable(data,columnas);
        tabla.setEnabled(false);

        JScrollPane sp = new JScrollPane(tabla);
        return sp;
    }

    /**
     * Array a tabla de equipos
     * @param equipos
     * @return Devuelve un JScrollPane con la tabla incluida en el
     */
    public static JScrollPane equipos(ArrayList<Equipo> equipos)
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
        return sp;
    }

    /**
     * Pone todos los valores de un array en una tabla de Usuarios
     * @param array
     * @return Devuelve un JScrollPane con la tabla incluida en el
     */
    public static JScrollPane usuarios(ArrayList<Usuario> array){
        //Correo, password, usuario, imagen, rol

        String[] columnas = {"Nombre","Correo","Contraseña", "rol"};

        String[][] data = new String[array.size()][array.size()];

        //Rellenamos el array data[][] con toda la info de cada jugador.
        if(array!=null)
        {
            int i;
            for (i=0; i < array.size(); i++) {
                data[i] = array.get(i).getDatos().toArray(new String[0]);
            }
        }
        JTable tabla = new JTable(data,columnas);
        tabla.setEnabled(false);

        JScrollPane sp = new JScrollPane(tabla);
        return sp;
    }
}
