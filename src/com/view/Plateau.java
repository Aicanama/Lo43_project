package com.view;
import com.model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.net.URL;
import java.util.Collection;
import java.util.ArrayList;

public class Plateau extends JPanel {

    //affichage
    private static final long serialVersionUID = 1L;
    private Image plateauJoueur1, plateauJoueur2, plateauJoueur3, plateauJoueur4;
    //icones ressources
    private ImageIcon gold, iconeBe, iconeBr, iconeOr, iconePi, iconeGl, iconePu, iconeBo;
    //cartes ressources
    private ImageIcon pizza, beer, ordi, brain, book, globe, puzzle, pizOrd, ordBra, braBee, beer2, brain2, pizza2, ordi2;
    //cartes commerce
    private ImageIcon mieCalE, mieCalO, oneS, boulD, caveVin, nooz, bar, litCarouf, foyer, laclerc, chambC, basicFat;
    //cartes patrimoine
    private ImageIcon savour, cuc, steleB, cine, lionB, poudr, fonta, palaisJ, mairie, belfHot, police, museum, citad;
    //cartes connaissances
    private ImageIcon matrice, anglais, etudeEc, codage, bulats, langue2, eloque, bilingue, etudeEtr, logiciel, science2, histoire2;
    private int largeurPlat;
    private int longueurPlat;
    //différents label utilisés
    private JLabel ico1, ico2, ico3, ico4, esp1, esp2, esp3, esp4, esp5, esp6, esp8, esp11, esp13, esp14, esp15, esp16, esp17, esp18;
    int i;

    protected SousListe cardsToPrint;


    //constructeur @leo
    protected char image;
    protected int ressource;
    protected String imageRessource;
    protected int nbrRessource;

    public Plateau() {

        //grille pour les labels argent
        this.setLayout(new GridLayout(6, 3));

        //chemin relatif images
        URL urlPlateau1 = getClass().getResource("img/plateau_1.png");
        URL urlPlateau2 = getClass().getResource("img/plateau_2.png");
        URL urlPlateau3 = getClass().getResource("img/plateau_3.png");
        URL urlPlateau4 = getClass().getResource("img/plateau_4.png");
        URL urlPlateau5 = getClass().getResource("img/plateau_5.png");
        URL urlPlateau6 = getClass().getResource("img/plateau_6.png");
        URL urlPlateau7 = getClass().getResource("img/plateau_7.png");

        //icones
        URL urlGold = getClass().getResource("img/gold.png");
        URL urlIcoBe = getClass().getResource("img/ibeer.png");
        URL urlIcoBr = getClass().getResource("img/ibrain.png");
        URL urlIcoPi = getClass().getResource("img/ipizza.png");
        URL urlIcoPu = getClass().getResource("img/ipuzzle.png");
        URL urlIcoGl = getClass().getResource("img/iglobe.png");
        URL urlIcoOr = getClass().getResource("img/iordi_brain.png");
        URL urlIcoBo = getClass().getResource("img/ibook.png");


        try {

            //la méthode statique read de la classe javax.imageio.ImageIO renvoie une instance de la classe
            //BufferedImage (qui étend la classe abstraite Image).

            //Image fond
            plateauJoueur1 = ImageIO.read(urlPlateau2);
            plateauJoueur2 = ImageIO.read(urlPlateau5);
            plateauJoueur3 = ImageIO.read(urlPlateau6);
            plateauJoueur4 = ImageIO.read(urlPlateau3);

            //Icon
            gold = new ImageIcon(ImageIO.read(urlGold));
            //carte = new ImageIcon(ImageIO.read(urlCarte));
            iconeBe = new ImageIcon(ImageIO.read(urlIcoBe));
            iconeBr = new ImageIcon(ImageIO.read(urlIcoBr));
            iconeBo = new ImageIcon(ImageIO.read(urlIcoBo));
            iconePi = new ImageIcon(ImageIO.read(urlIcoPi));
            iconePu = new ImageIcon(ImageIO.read(urlIcoPu));
            iconeOr = new ImageIcon(ImageIO.read(urlIcoOr));
            iconeGl = new ImageIcon(ImageIO.read(urlIcoGl));
        } catch (IOException e) {
            e.printStackTrace();
        }


        ///Definition Espace Labels
        esp1 = new JLabel("Ico1");
        esp2 = new JLabel(); // pour btn next
        esp3 = new JLabel("Ico2");
        esp4 = new JLabel();
        esp5 = new JLabel();
        esp6 = new JLabel();
        ico1 = new JLabel();
        esp8 = new JLabel();
        ico2 = new JLabel();
        ico3 = new JLabel();
        esp11 = new JLabel();
        ico4 = new JLabel();
        esp13 = new JLabel("Ico3");
        esp14 = new JLabel();
        esp15 = new JLabel("Ico4");
        esp16 = new JLabel();
        esp17 = new JLabel();
        esp18 = new JLabel();


        //création liste des labels pour chaque action soit écrite en une fois   /!\ revoir utilité /!\
        Collection<JLabel> myLabelsGold = new ArrayList<JLabel>();
        //ordre important !!
        myLabelsGold.add(esp1);
        myLabelsGold.add(esp3);
        myLabelsGold.add(esp5);
        myLabelsGold.add(esp6);
        myLabelsGold.add(ico1);
        myLabelsGold.add(ico2);
        myLabelsGold.add(ico3);
        myLabelsGold.add(ico4);
        myLabelsGold.add(esp13);
        myLabelsGold.add(esp14);
        myLabelsGold.add(esp15);
        myLabelsGold.add(esp16);
        myLabelsGold.add(esp17);
        myLabelsGold.add(esp18);


        ///REVOIR CETTE PARTIE

        Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
        for (JLabel label : myLabelsGold) {
            //border
            label.setBorder(border);

            //icon
            String name = label.getText(); //texte donné pas le nom du label

            if (name.startsWith("Ico1") || name.startsWith("Ico2") || name.startsWith("Ico3") || name.startsWith("Ico4")) {
                label.setIcon(gold);
                label.setHorizontalAlignment(SwingConstants.TRAILING);
            } else {
                label.setText("E");
                label.setFont(new Font("Serif", Font.ITALIC, 1));
            }

            if (name.startsWith("E")) {
                label.setBorder(new EmptyBorder(5, 1, 1, 1));
            }
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

        //position canvas
        //plateau 1

        esp4.setVerticalAlignment(SwingConstants.TOP);
        esp4.setHorizontalAlignment(SwingConstants.CENTER);
        //esp carte haut
        esp2.setVerticalAlignment(SwingConstants.BOTTOM);
        esp2.setHorizontalAlignment(SwingConstants.LEFT);
        esp5.setVerticalAlignment(SwingConstants.BOTTOM);
        esp5.setHorizontalAlignment(SwingConstants.LEFT);
        esp8.setVerticalAlignment(SwingConstants.CENTER);
        esp8.setHorizontalAlignment(SwingConstants.LEFT);
        //plateau 2
        esp6.setVerticalAlignment(SwingConstants.CENTER);
        esp6.setHorizontalAlignment(SwingConstants.LEFT);
        //Icone Plat1
        ico1.setVerticalAlignment(SwingConstants.TOP);
        ico1.setHorizontalAlignment(SwingConstants.RIGHT);
        //Icone Plat2
        ico2.setVerticalAlignment(SwingConstants.TOP);
        ico2.setHorizontalAlignment(SwingConstants.RIGHT);
        //Icone Plat3
        ico3.setVerticalAlignment(SwingConstants.TOP);
        ico3.setHorizontalAlignment(SwingConstants.RIGHT);
        //Icone Plat4
        ico4.setVerticalAlignment(SwingConstants.TOP);
        ico4.setHorizontalAlignment(SwingConstants.RIGHT);
        //esp carte bas
        esp11.setVerticalAlignment(SwingConstants.BOTTOM);
        esp11.setHorizontalAlignment(SwingConstants.LEFT);
        esp14.setVerticalAlignment(SwingConstants.CENTER);
        esp14.setHorizontalAlignment(SwingConstants.LEFT);
        esp17.setVerticalAlignment(SwingConstants.CENTER);
        esp17.setHorizontalAlignment(SwingConstants.LEFT);
        //Plateau 3

        esp16.setVerticalAlignment(SwingConstants.CENTER);
        esp16.setHorizontalAlignment(SwingConstants.LEFT);
        //Plateau 4
        esp18.setVerticalAlignment(SwingConstants.CENTER);
        esp18.setHorizontalAlignment(SwingConstants.LEFT);


        //Grillage pour placer les cartes
        Border borderLabelForCarte = BorderFactory.createLineBorder(Color.MAGENTA, 5);
        esp2.setLayout(new GridLayout(1, 1, 1, 0));
        esp2.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        esp5.setLayout(new GridLayout(1, 1, 1, 0));
        esp5.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        esp13.setLayout(new GridLayout(1, 1, 1, 0));
        esp13.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        esp17.setLayout(new GridLayout(1, 1, 1, 0));
        esp17.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        esp8.setLayout(new GridLayout(1, 1/*4*/, 1, 0));
        esp8.setBorder(borderLabelForCarte);
        esp11.setLayout(new GridLayout(1, 1/*3*/, 1, 0));
        esp11.setBorder(borderLabelForCarte);
        esp14.setLayout(new GridLayout(1, 1, 1, 0));
        esp14.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));

        //Grillage pour placer les icones
        Border borderLabelForIcone = BorderFactory.createLineBorder(Color.RED, 1);
        ico1.setLayout(new GridLayout(1, 1, 0, 0));
        ico1.setBorder(borderLabelForIcone);
        ico2.setLayout(new GridLayout(1, 1, 0, 0));
        ico2.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));
        ico3.setLayout(new GridLayout(1, 1, 0, 0));
        ico3.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));
        ico4.setLayout(new GridLayout(1, 1, 0, 0));
        ico4.setBorder(borderLabelForIcone);


        //Espaces pour les plateaux
        Border borderLabelForPlat = BorderFactory.createLineBorder(Color.GREEN, 1);
        esp1.setLayout(new GridLayout(1, 1, 0, 0));
        esp1.setBorder(borderLabelForPlat);
        esp3.setLayout(new GridLayout(4, 4, 0, 0));
        esp3.setBorder(borderLabelForPlat);
        esp4.setLayout(new GridLayout(4, 4, 0, 0));
        esp4.setBorder(borderLabelForPlat);
        esp6.setLayout(new GridLayout(4, 4, 0, 0));
        esp6.setBorder(borderLabelForPlat);
        esp13.setLayout(new GridLayout(4, 4, 0, 0));
        esp13.setBorder(borderLabelForPlat);
        esp15.setLayout(new GridLayout(4, 4, 0, 0));
        esp15.setBorder(borderLabelForPlat);
        esp16.setLayout(new GridLayout(2, 2, 0, 0));
        esp16.setBorder(borderLabelForPlat);
        esp18.setLayout(new GridLayout(2, 2, 0, 0));
        esp18.setBorder(borderLabelForPlat);

        ///Definition Label Carte (paquet de carte)
        // --> definition dans JFrameButtonCards


        //Création icônes en fonction cartes choisies  (test)  (6cartes/joueur pour Age I)
        JLabel IconeCarte1 = new JLabel();
        IconeCarte1.setIcon(iconeBe);
        IconeCarte1.setVerticalAlignment(SwingConstants.TOP);
        IconeCarte1.setHorizontalAlignment(SwingConstants.LEFT);
        JLabel IconeCarte2 = new JLabel();
        IconeCarte2.setIcon(iconePi);
        IconeCarte2.setVerticalAlignment(SwingConstants.TOP);
        JLabel IconeCarte3 = new JLabel();
        IconeCarte3.setIcon(iconeBr);
        IconeCarte3.setVerticalAlignment(SwingConstants.TOP);
        JLabel IconeCarte4 = new JLabel();
        IconeCarte4.setIcon(iconeOr);
        IconeCarte4.setVerticalAlignment(SwingConstants.TOP);
        JLabel IconeCarte5 = new JLabel();
        IconeCarte5.setIcon(iconePu);
        IconeCarte5.setVerticalAlignment(SwingConstants.TOP);
        JLabel IconeCarte6 = new JLabel();
        IconeCarte6.setIcon(iconeBo);
        IconeCarte6.setVerticalAlignment(SwingConstants.TOP);

        //affichage des icones à cté des plateaux
        ico1.add(IconeCarte1);
        ico1.add(IconeCarte2);
        ico1.add(IconeCarte3);
        ico1.add(IconeCarte4);
        ico1.add(IconeCarte5);
        ico1.add(IconeCarte6);


        ///mise en place Plateau
        for (JLabel label : myLabelsGold) {
            label.setBorder(new EmptyBorder(10, 10, 10, 10)); // border INVISIBLE (pas besoin si on met label en invisible)
            this.add(label);
        }
    }

    public void paintComponent(Graphics g){

        largeurPlat = getWidth() / 3;
        longueurPlat = getHeight() / 3;

        int largeurCarte = largeurPlat / 5;
        int longueurCarte = longueurPlat / 2;

        //JOUEURS
        //joueur 1 - coin haut gauche
        g.drawImage(plateauJoueur1, 0, 0, largeurPlat, longueurPlat, this);

        //joueur 2 - coin haut droit
        g.drawImage(plateauJoueur2, largeurPlat * 2, 0, largeurPlat, longueurPlat, this);

        //joueur 3 - coin bas gauche
        g.drawImage(plateauJoueur3, 0, longueurPlat * 2, largeurPlat, longueurPlat, this);

        //joueur 4 - coin gauche
        g.drawImage(plateauJoueur4, largeurPlat * 2, longueurPlat * 2, largeurPlat, longueurPlat, this);
    }


}
