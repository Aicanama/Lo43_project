package com.view;

import javax.swing.*;
import java.awt.*;

public class Plateau extends JPanel {
    //conteneur = content pane

    public void paintComponent(Graphics g) {
        int largeurRec = getWidth()/3;
        int longueurRec = getHeight()/3;

        g.setColor(Color.blue);
        g.fillRect(largeurRec,10,largeurRec,longueurRec);

        g.setColor(Color.red);
        g.fillRect(largeurRec,10,largeurRec,longueurRec);
    }
}
