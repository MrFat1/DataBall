package icai.dtc.isw.util;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class CrearPanel {


        public static JPanel titled(String titulo) {

            JPanel pnl = new JPanel();

            pnl.setOpaque(false);
            Font font = new Font("Comic Sans",Font.BOLD, 13);
            Border borde = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.GRAY);
            TitledBorder title = BorderFactory.createTitledBorder(borde, titulo, TitledBorder.LEFT, TitledBorder.TOP, font, Color.BLACK);

            pnl.setBorder(title);

            return pnl;
        }
}
