package icai.dtc.isw.util;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Equipo;
import icai.dtc.isw.domain.Jugador;
import icai.dtc.isw.domain.Usuario;
import icai.dtc.isw.domain.Video;

import java.util.ArrayList;
import java.util.HashMap;

public class DBUtils {

    /**
     * Busca a un usuario en la Base de Datos por su nombre y crea un objeto Usuario con toda la info necesaria.
     */
    public static Usuario buscarUser(String nombre)
    {
        Client cliente=new Client();
        HashMap<String,Object> session=new HashMap<>();
        String context="/getUser";
        session.put("usuario",  nombre);
        session= cliente.sentMessage(context,session);

        return (Usuario) session.get("usuario");

    }
    /**
     * Busca a un jugador segun la opción elegida y el String introducido
     * @param Busqueda
     * @param opcion
     * @return Devuelve un array que se introducira en una tabla con el método ToTable
     */
    public static ArrayList<Jugador> BuscarJugador(String Busqueda, String opcion) {
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

    /**
     * Busca un equipo según la opción elegida y el String introducido
     * @param busqueda
     * @param opcion
     * @return Devuelve un array que se introducira en una tabla con el método ToTable
     */
    public static ArrayList<Equipo> BuscarEquipo(String busqueda, String opcion)
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

    /**
     * Recupera de la base de datos todos los videos disponibles en forma de array de objetos de tipo Video
     * @return
     */
    public static ArrayList<Video> getVideos()
    {
        Client cliente= new Client();
        HashMap<String,Object> session=new HashMap<>();
        String context="/getvideo";
        cliente.sentMessage(context,session);
        ArrayList<Video> videos=cliente.videos;

        return videos;
    }

}
