package com.view;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Plateau extends JPanel {
    //conteneur = content pane

    //private static final long serialVersionUID = 1L; --> qu'est ce que c'est ??
    private Image plateauJoueur;
    private  ImageIcon gold;
    private int largeurPlat;
    private int longueurPlat;


    public Plateau(){
        try {
            //la méthode statique  read de la classe javax.imageio.ImageIO renvoie une instance de la classe BufferedImage (qui étend la classe abstraite Image).
            plateauJoueur = ImageIO.read(new File("C:\\Users\\inesm\\Documents\\Utbm\\LO43\\projet_form\\src\\com\\view\\img\\7_Wonders.png")); //chemin relatif a trouver ??
            gold = new ImageIcon( "C:\\Users\\inesm\\Documents\\Utbm\\LO43\\projet_form\\src\\com\\view\\img\\gold.png");
        }
        catch(IOException e){
            e.printStackTrace();
        }

        JLabel labelGold1 = new JLabel("11");
        labelGold1.setIcon(gold);
        JLabel  labelGold2 = new JLabel("22 ");
        labelGold2.setIcon(gold);
        JLabel labelGold3 = new JLabel("333");
        labelGold3.setIcon(gold);
        JLabel labelGold4 = new JLabel("444 ");
        labelGold4.setIcon(gold);

        this.setLayout(new GridLayout(2,3,0,0));
        labelGold1.setHorizontalAlignment(SwingConstants.CENTER);
        labelGold1.setVerticalAlignment(SwingConstants.TOP);

        labelGold2.setHorizontalAlignment(SwingConstants.TRAILING);
        labelGold2.setVerticalAlignment(SwingConstants.TOP);

        labelGold3.setHorizontalAlignment(SwingConstants.CENTER);
        labelGold3.setVerticalAlignment(SwingConstants.CENTER);

        labelGold4.setHorizontalAlignment(SwingConstants.TRAILING);
        labelGold4.setVerticalAlignment(SwingConstants.CENTER);


        this.add(labelGold1);
        this.add(labelGold2);
        this.add(labelGold3);
        this.add(labelGold4);
    }
    public void paintComponent(Graphics g) {
        largeurPlat = getWidth()/3;
        longueurPlat = getHeight()/3;
        System.out.println("largeurPlat : " + largeurPlat +" longueurPlat : "+ longueurPlat);


        super.paintComponent(g);

        /* g.drawImage(): une image, les coordonnées du coin supérieur gauche, les dimensions (l'image d'origine pourra être dilatée ou réduite en fonction de ces indications)
         * et un objet d'une classe implémentant l'interface java.awt.image.ImageObserver
         */

            //joueur 1 - coin haut gauche
        g.drawImage(plateauJoueur,0,0,largeurPlat,longueurPlat,this);


            //joueur 2 - coin haut droit
        g.drawImage(plateauJoueur,largeurPlat*2,0,largeurPlat,longueurPlat,this);


            //joueur 3 - coin bas gauche
        g.drawImage(plateauJoueur,0,longueurPlat*2,largeurPlat,longueurPlat,this);

            //joueur 4 - coin gauche
        g.drawImage(plateauJoueur,largeurPlat*2,longueurPlat*2,largeurPlat,longueurPlat,this);


    }

}
