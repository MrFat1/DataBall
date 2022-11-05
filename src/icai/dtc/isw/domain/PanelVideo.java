package icai.dtc.isw.domain;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.ui.LogIn;
import icai.dtc.isw.ventanas.YoutubePlay;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;

public class PanelVideo extends JPanel {
    /*public static void main(String[] args) {
    }*/
    public PanelVideo()
    {

        Client cliente= new Client();
        HashMap<String,Object> session=new HashMap<>();
        String context="/getvideo";
        cliente.sentMessage(context,session);
        this.setSize(800,800);
        this.setVisible(true);
        ArrayList<Video> videos=cliente.videos;
        int i;
        for (i=0; i < videos.size(); i++) {
            URI url =videos.get(i).getUrl();
            JButton boton=new JButton(videos.get(i).getNombre());
            boton.addActionListener(actionEvent->{
                YoutubePlay.open(url);
            });
            this.add(boton);
            }
        }
    }
