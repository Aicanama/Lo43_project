package com.view;
import com.model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.net.URL;
import java.util.Collection;
import java.util.ArrayList;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class Plateau extends JPanel{

    //affichage
    private static final long serialVersionUID = 1L; //--> qu'est ce que c'est ??
    private Image plateauJoueur;
    private ImageIcon gold, carte;
    private int largeurPlat;
    private int longueurPlat;
    private JLabel labelGold1;
    int i;


    //constructeur @leo
    protected char image;
    protected int ressource;
    protected String imageRessource;
    protected int nbrRessource;

    public Plateau() {

        //grille pour les labels argent
        this.setLayout(new GridLayout(2, 3));

        //chemin relatif images
        URL url7Wonders = getClass().getResource("img/7_Wonders.png");
        URL urlCarte = getClass().getResource("img/1Carte.png");
        URL urlGold = getClass().getResource("img/gold.png");

        try {

            //la méthode statique  read de la classe javax.imageio.ImageIO renvoie une instance de la classe 
            //BufferedImage (qui étend la classe abstraite Image).

            //Image fond
            plateauJoueur = ImageIO.read(url7Wonders);

            //Icon
            gold = new ImageIcon(ImageIO.read(urlGold));
            //carte = new ImageIcon(ImageIO.read(urlCarte));

        } catch (IOException e) {
            e.printStackTrace();
        }


        ///Definition LabelGold et icon

        labelGold1 = new JLabel("111"); //mettre espace a la fin !! car sinon trop collé
        JLabel labelGold2 = new JLabel("22 ");
        JLabel labelGold3 = new JLabel("333 ");
        JLabel labelGold4 = new JLabel("444 ");
        JLabel esp1 = new JLabel("esp1 "); //espace seront les endroits "vides"
        JLabel esp2 = new JLabel("esp2 ");

        Collection<JLabel> myLabelsGold = new ArrayList<JLabel>(); //création liste des labels pour chaque action soit écrite en une fois
        //ordre important !!
        myLabelsGold.add(labelGold1);
        myLabelsGold.add(esp1);
        myLabelsGold.add(labelGold2);
        myLabelsGold.add(labelGold3);
        myLabelsGold.add(esp2);
        myLabelsGold.add(labelGold4);

        Border border = BorderFactory.createLineBorder(Color.RED, 5); //va permettre de créer des espaces pour positionner mieux

        for (JLabel label : myLabelsGold) {
            //border
            label.setBorder(border);

            //icon
            String name = label.getText(); //texte donné pas le nom du label
            if (!name.startsWith("Esp")) {
                label.setIcon(gold);
            }

            if (name.startsWith("Esp")) {
                label.setBorder(new EmptyBorder(10, 10, 10, 10));
            }

            //position Horizontal (tous pareil)
            label.setHorizontalAlignment(SwingConstants.TRAILING);
        }

        /** Pour le moment laisser en commentaire pour bien voir où mettre !!
         *
         * for (JLabel label : myLabels) {
         String name = label.getText();
         if(name.startsWith("Esp")) {
         label.setBorder(new EmptyBorder(10, 10, 10, 10)); // border INVISIBLE (pas besoin si on met label en invisible)
         label.setVisible(false); //fonction permettant de mettre la border et jlabel invisble
         }
         } */

        //position canvas (vertical uniquement voir boucle pour horizontal)

        labelGold1.setVerticalAlignment(SwingConstants.TOP);
        labelGold2.setVerticalAlignment(SwingConstants.TOP);
        labelGold3.setVerticalAlignment(SwingConstants.CENTER);
        labelGold4.setVerticalAlignment(SwingConstants.CENTER);

        esp1.setVerticalAlignment(SwingConstants.TOP);
        esp1.setHorizontalAlignment(SwingConstants.CENTER);

        esp2.setVerticalAlignment(SwingConstants.TOP);
        esp2.setHorizontalAlignment(SwingConstants.CENTER);


        ///Definition Label Carte + button

        //carte du haut (4) = espace 1

        //Border espace
        Border borderLabelForCarte = BorderFactory.createLineBorder(Color.GREEN, 5);
        esp1.setLayout(new GridLayout(1, 4, 0, 0));
        esp1.setBorder(borderLabelForCarte);

        //Création carte haut
        //obligé de creer a chaque fois l'espace ...
        JLabel espCarte1 = new JLabel("Esp carte1"); //espace mis a chaque fois au dessus des cartes button
        JLabel espCarte2 = new JLabel("Esp carte2");
        JLabel espCarte3 = new JLabel("Esp carte3");
        JLabel espCarte4 = new JLabel("Esp carte4");


        JLabel Carte1 = new JLabel();
        Carte1.setLayout(new GridLayout(2, 1, 0, 0)); //mise en place de la répartition dans la case d'une carte
        JButton BtnC1 = new JButton(carte); //icone est mise sur le bouton
        Carte1.add(espCarte1);
        Carte1.add(BtnC1);
        BtnC1.setActionCommand("BtnC1");

        BtnC1.addActionListener(this::actionPerformed);

        JLabel Carte2 = new JLabel();
        Carte2.setLayout(new GridLayout(2, 1, 0, 0));
        JButton BtnC2 = new JButton(carte);
        Carte2.add(espCarte2);
        Carte2.add(BtnC2);

        JLabel Carte3 = new JLabel();
        Carte3.setLayout(new GridLayout(2, 1, 0, 0));
        JButton BtnC3 = new JButton(carte);
        Carte3.add(espCarte3);
        Carte3.add(BtnC3);

        JLabel Carte4 = new JLabel();
        Carte4.setLayout(new GridLayout(2, 1, 0, 0));
        JButton BtnC4 = new JButton(carte);
        Carte4.add(espCarte4);
        Carte4.add(BtnC4);

        //set on esp1
        esp1.add(Carte1);
        esp1.add(Carte2);
        esp1.add(Carte3);
        esp1.add(Carte4);

        //carte du bas (3) = espace 2

        //Border espace
        esp2.setLayout(new GridLayout(1, 4, 0, 0));
        esp2.setBorder(borderLabelForCarte);

        //Création carte Bas

        JLabel Carte5 = new JLabel();
        Carte5.setLayout(new GridLayout(2, 1, 0, 0)); //mise en place de la répartition dans la case d'une carte
        JButton BtnC5 = new JButton(carte); //icone est mise sur le bouton
        Carte5.add(BtnC5);

        JLabel Carte6 = new JLabel();
        Carte6.setLayout(new GridLayout(2, 1, 0, 0)); //mise en place de la répartition dans la case d'une carte
        JButton BtnC6 = new JButton(carte); //icone est mise sur le bouton
        Carte6.add(BtnC6);

        JLabel Carte7 = new JLabel();
        Carte7.setLayout(new GridLayout(2, 1, 0, 0)); //mise en place de la répartition dans la case d'une carte
        JButton BtnC7 = new JButton(carte); //icone est mise sur le bouton
        Carte7.add(BtnC7);

        //set on esp2
        esp2.add(Carte5);
        esp2.add(Carte6);
        esp2.add(Carte7);


        ///mise en place Plateau
        for (JLabel label : myLabelsGold) {
            this.add(label);
        }

    }

    public Plateau(char n_image, int n_ressource, String n_imageRessource) {
        this.image=n_image;
        this.imageRessource=n_imageRessource;
        this.ressource=n_ressource;
        this.nbrRessource=0;
    }

    public void paintComponent(Graphics g) {
        
    	largeurPlat = getWidth()/3;
        longueurPlat = getHeight()/3;
        
        int largeurCarte = largeurPlat/5;
        int longueurCarte = longueurPlat/2;

        //super.paintComponent(g);

        /* g.drawImage(): une image, les coordonnées du coin supérieur gauche, les dimensions 
         * et un objet d'une classe implémentant l'interface java.awt.image.ImageObserver
         */
     //JOUEURS
            //joueur 1 - coin haut gauche
        g.drawImage(plateauJoueur,0,0,largeurPlat,longueurPlat,this);

            //joueur 2 - coin haut droit
        g.drawImage(plateauJoueur,largeurPlat*2,0,largeurPlat,longueurPlat,this);

            //joueur 3 - coin bas gauche
        g.drawImage(plateauJoueur,0,longueurPlat*2,largeurPlat,longueurPlat,this);

            //joueur 4 - coin gauche
        g.drawImage(plateauJoueur,largeurPlat*2,longueurPlat*2,largeurPlat,longueurPlat,this);
    }

    public void actionPerformed(ActionEvent e) {
        i = Integer.parseInt(labelGold1.getText());
        this.i++;
        labelGold1.setText(String.valueOf(i));

    }



    }

    /** Leo
public class Plateau {

    protected char image;
    protected int ressource;
    protected String imageRessource;
    protected ArrayList<CarteRessource> listeRessource;

    public Plateau(char n_image, int n_ressource, String n_imageRessource) {
        this.image=n_image;
        this.imageRessource=n_imageRessource;
        this.ressource=n_ressource;
        this.listeRessource = new ArrayList<CarteRessource>();
    }

    public void afficherCarte(int type) {
    }

    public void updateListe(CarteRessource carteR) {
        this.listeRessource.add(carteR);
    }
*/