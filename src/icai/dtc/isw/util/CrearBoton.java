package icai.dtc.isw.util;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CrearBoton {

    public static JButton normal(String texto) {
        JButton btn = new JButton(texto);
        btn.setForeground(Color.BLACK);
        btn.setBackground(Color.WHITE);
        Border borde = new LineBorder(Color.BLACK);
        Border tamano = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(borde, tamano);
        btn.setBorder(compound);
        return btn;
    }

}
