package icai.dtc.isw.util;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

/**
 * Clase para abrir enlaces de YouTube
 */
public class YoutubePlay
{
    /**
     * Método para abrir un url en YouTube
     * @param uri
     */
    public static void open(URI uri)
    {
        if (Desktop.isDesktopSupported())
        {
            try
            {
                Desktop.getDesktop().browse(uri);
            }
            catch (IOException e)
            { /* TODO: error handling */ }
        }
        else
        { /* TODO: error handling */ }
    }
}