package icai.dtc.isw.ventanas;

import icai.dtc.isw.ui.JVentana;

import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class PruebaVideo extends JFrame {

    public static void main(String[] args) throws CannotRealizeException, IOException, NoPlayerException {
        new PruebaVideo();
    }

    public PruebaVideo() throws IOException, CannotRealizeException, NoPlayerException {

        setLayout(new BorderLayout());

        String url = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
        URL url2 = new URL(url);
        Player mediaPlayer = Manager.createRealizedPlayer(url2);

        Component video = mediaPlayer.getVisualComponent();
        Component controls = mediaPlayer.getControlPanelComponent();
        add(video,BorderLayout.CENTER);
        add(controls,BorderLayout.SOUTH);
    }

}
