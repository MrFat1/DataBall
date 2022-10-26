package icai.dtc.isw.client;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class PanelImagen extends JPanel {

    private BufferedImage img = null;
    public PanelImagen() {
        try {
             img = ImageIO.read(new File("resources\\databall.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Graphics2D pint = img.createGraphics();
        pint.dispose();
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(img,0,0,null); // dibuja la imagen al iniciar la aplicacion
    }

}
