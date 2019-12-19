package com.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Plateau extends JPanel {
    //conteneur = content pane

    private static final long serialVersionUID = 1L;
    Image plateauPrincipal;

    public Plateau(){
        try {

            plateauPrincipal = ImageIO.read(new File("C:\\Users\\inesm\\Documents\\Utbm\\LO43\\projet_form\\src\\com\\view\\img\\7_Wonders.png")); //chemin relatif a trouver ??
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics g) {
        int largeurPlat = getWidth()/3;
        int longueurPlat = getHeight()/3;
        System.out.println(largeurPlat +" "+ longueurPlat);

        super.paintComponent(g);
            //joueur 1 - coin haut gauche
        g.drawImage(plateauPrincipal,0,0,largeurPlat,longueurPlat,this);
            //joueur 2 - coin haut droit
        g.drawImage(plateauPrincipal,largeurPlat*2,0,largeurPlat,longueurPlat,this);
            //joueur 3 - coin bas gauche
        g.drawImage(plateauPrincipal,0,longueurPlat*2,largeurPlat,longueurPlat,this);
            //joueur 4 - coin gauche
        g.drawImage(plateauPrincipal,largeurPlat*2,longueurPlat*2,largeurPlat,longueurPlat,this);

    }

}
