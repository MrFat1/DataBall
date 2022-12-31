package icai.dtc.isw.domain;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.util.DBUtils;
import icai.dtc.isw.util.YoutubePlay;

import javax.swing.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Panel que muestra todos los videos disponibles
 */
public class PanelVideo extends JPanel {

    public PanelVideo()
    {

        this.setSize(800,800);
        this.setVisible(true);

        ArrayList<Video> videos = DBUtils.getVideos(); //Array de objetos "Video"

        int i;
        for (i=0; i < videos.size(); i++) {
            URI url = videos.get(i).getUrl();
            JButton boton=new JButton(videos.get(i).getNombre());
            boton.addActionListener(actionEvent->{
                YoutubePlay.open(url);
            });
            this.add(boton);
            }
        }
    }
