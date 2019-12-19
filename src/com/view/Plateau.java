package com.view;

import javax.swing.*;
import java.awt.*;

public class Plateau extends JPanel {
    //conteneur = content pane

    public Plateau(){
    }

    public void paintComponent(Graphics g) {
        int largeurPlat = getWidth()/3;
        int longueurPlat = getHeight()/3;
        System.out.println(largeurPlat +" "+ longueurPlat);

        g.setColor(Color.blue);
        g.fillRect(largeurPlat,0,largeurPlat,longueurPlat);

        g.setColor(Color.red);
        g.fillRect(largeurPlat*2,longueurPlat,largeurPlat,longueurPlat);

        g.setColor(Color.green);
        g.fillRect(largeurPlat,longueurPlat*2,largeurPlat,longueurPlat);

        g.setColor(Color.yellow);
        g.fillRect(1,longueurPlat,largeurPlat,longueurPlat);




    }
}
