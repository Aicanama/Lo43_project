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

public class Plateau extends JPanel{

    //affichage
    private static final long serialVersionUID = 1L; //--> qu'est ce que c'est ??
    private Image plateauJoueur1 , plateauJoueur2, plateauJoueur3, plateauJoueur4;
    //icones ressources
    private  ImageIcon gold, iconeBe, iconeBr, iconeOr, iconePi, iconeGl, iconePu, iconeBo;
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

    public Plateau(){
    	
    	//grille pour les labels argent
    	this.setLayout(new GridLayout(6,3));
        
    	//chemin relatif images
    	URL urlPlateau1 = getClass().getResource("img/plateau_1.png");
        URL urlPlateau2 = getClass().getResource("img/plateau_2.png");
        URL urlPlateau3 = getClass().getResource("img/plateau_3.png");
        URL urlPlateau4 = getClass().getResource("img/plateau_4.png");
        URL urlPlateau5 = getClass().getResource("img/plateau_5.png");
        URL urlPlateau6 = getClass().getResource("img/plateau_6.png");
        URL urlPlateau7 = getClass().getResource("img/plateau_7.png");
            //age I
                //cartes
        URL urlPizza = getClass().getResource("img/pizza.png");
        URL urlPuzzle = getClass().getResource("img/puzzle.png");
        URL urlBook = getClass().getResource("img/book.png");
        URL urlBrain = getClass().getResource("img/brain.png");
        URL urlBeer = getClass().getResource("img/beer.png");
        URL urlGlobe = getClass().getResource("img/globe.png");
        URL urlOrdi = getClass().getResource("img/ordi.png");
        URL urlPiOr = getClass().getResource("img/pizza_ordi.png");
        URL urlOrBr = getClass().getResource("img/ordi_brain.png");
        URL urlBrBe = getClass().getResource("img/brain_beer.png");
        URL urlMieE = getClass().getResource("img/mieCalinouEst.png");
        URL urlMieO = getClass().getResource("img/mieCalinouOuest.png");
        URL urlOne = getClass().getResource("img/oneShoot.png");
        URL urlBou = getClass().getResource("img/bouleDisco.png");
        URL urlSav = getClass().getResource("img/savoureuse.png");
        URL urlCuc = getClass().getResource("img/CUC.png");
        URL urlSte = getClass().getResource("img/steleBartholdi.png");
        URL urlCin = getClass().getResource("img/cinema.png");
        URL urlMat = getClass().getResource("img/matrice.png");
        URL urlAng = getClass().getResource("img/anglais.png");
        URL urlEtuEc = getClass().getResource("img/etudesEcrites.png");
    	        //icones
    	URL urlGold = getClass().getResource("img/gold.png");
    	URL urlIcoBe = getClass().getResource("img/ibeer.png");
        URL urlIcoBr = getClass().getResource("img/ibrain.png");
        URL urlIcoPi = getClass().getResource("img/ipizza.png");
        URL urlIcoPu = getClass().getResource("img/ipuzzle.png");
        URL urlIcoGl = getClass().getResource("img/iglobe.png");
        URL urlIcoOr = getClass().getResource("img/iordi_brain.png"); //maybe erreur ?
        URL urlIcoBo = getClass().getResource("img/ibook.png");
            //Age II
                //cartes
        URL urlBe2 = getClass().getResource("img/beer2.png");
        URL urlBr2 = getClass().getResource("img/brain2.png");
        URL urlPi2 = getClass().getResource("img/pizza2.png");
        URL urlOr2 = getClass().getResource("img/ordi2.png");
        URL urlCave = getClass().getResource("img/caveAVins.png");
        URL urlNo = getClass().getResource("img/nooz.png");
        URL urlBar = getClass().getResource("img/bar.png");
        URL urlLitCar = getClass().getResource("img/littleCarouf.png");
        URL urlLion = getClass().getResource("img/lionBartholdi.png");
        URL urlPoud = getClass().getResource("img/poudriere.png");
        URL urlFont = getClass().getResource("img/fontaine.png");
        URL urlPalais = getClass().getResource("img/palaisJustice.png");
        URL urlCoda = getClass().getResource("img/codage.png");
        URL urlBula = getClass().getResource("img/bulats.png");
        URL urlLan2 = getClass().getResource("img/langue2.png");
        URL urlEloq = getClass().getResource("img/eloquence.png");
            //Age III
        URL urlFoy = getClass().getResource("img/foyer.png");
        URL urlLac = getClass().getResource("img/laclerc.png");
        URL urlCham = getClass().getResource("img/chambreCommerce.png");
        URL urlBas = getClass().getResource("img/basicFat.png");
        URL urlMai = getClass().getResource("img/mairie.png");
        URL urlBelf = getClass().getResource("img/belfortHotel.png");
        URL urlPol = getClass().getResource("img/police.png");
        URL urlMus = getClass().getResource("img/museum.png");
        URL urlCit = getClass().getResource("img/citadelle.png");
        URL urlBil = getClass().getResource("img/bilingue.png");
        URL urlEtuEt = getClass().getResource("img/etudeEtranger.png");
        URL urlLog = getClass().getResource("img/logiciel.png");
        URL urlScie = getClass().getResource("img/sciences2.png");
        URL urlHist = getClass().getResource("img/histoire2.png");

    	
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
            //Cartes Ressources
            pizza = new ImageIcon(ImageIO.read(urlPizza));
            beer = new ImageIcon(ImageIO.read(urlBeer));
            ordi = new ImageIcon(ImageIO.read(urlOrdi));
            brain = new ImageIcon(ImageIO.read(urlBrain));
            book = new ImageIcon(ImageIO.read(urlBook));
            globe = new ImageIcon(ImageIO.read(urlGlobe));
            puzzle = new ImageIcon(ImageIO.read(urlPuzzle));
            pizOrd = new ImageIcon(ImageIO.read(urlPiOr));
            ordBra = new ImageIcon(ImageIO.read(urlOrBr));
            braBee = new ImageIcon(ImageIO.read(urlBrBe));
            beer2 = new ImageIcon(ImageIO.read(urlBe2));
            brain2 = new ImageIcon(ImageIO.read(urlBr2));
            pizza2 = new ImageIcon(ImageIO.read(urlPi2));
            ordi2 = new ImageIcon(ImageIO.read(urlOr2));
            //Cartes Commerce
            mieCalE = new ImageIcon(ImageIO.read(urlMieE));
            mieCalO = new ImageIcon(ImageIO.read(urlMieO));
            oneS = new ImageIcon(ImageIO.read(urlOne));
            boulD = new ImageIcon(ImageIO.read(urlBou));
            caveVin = new ImageIcon(ImageIO.read(urlCave));
            nooz = new ImageIcon(ImageIO.read(urlNo));
            bar = new ImageIcon(ImageIO.read(urlBar));
            litCarouf = new ImageIcon(ImageIO.read(urlLitCar));
            foyer = new ImageIcon(ImageIO.read(urlFoy));
            laclerc = new ImageIcon(ImageIO.read(urlLac));
            chambC = new ImageIcon(ImageIO.read(urlCham));
            basicFat = new ImageIcon(ImageIO.read(urlBas));
            //Cartes Patrimoine
            savour = new ImageIcon(ImageIO.read(urlSav));
            cuc = new ImageIcon(ImageIO.read(urlCuc));
            steleB = new ImageIcon(ImageIO.read(urlSte));
            cine = new ImageIcon(ImageIO.read(urlCin));
            lionB = new ImageIcon(ImageIO.read(urlLion));
            poudr = new ImageIcon(ImageIO.read(urlPoud));
            fonta = new ImageIcon(ImageIO.read(urlFont));
            palaisJ = new ImageIcon(ImageIO.read(urlPalais));
            mairie = new ImageIcon(ImageIO.read(urlMai));
            belfHot = new ImageIcon(ImageIO.read(urlBelf));
            police = new ImageIcon(ImageIO.read(urlPol));
            museum = new ImageIcon(ImageIO.read(urlMus));
            citad = new ImageIcon(ImageIO.read(urlCit));
            //Cartes Connaissances
            matrice = new ImageIcon(ImageIO.read(urlMat));
            anglais = new ImageIcon(ImageIO.read(urlAng));
            etudeEc = new ImageIcon(ImageIO.read(urlEtuEc));
            codage = new ImageIcon(ImageIO.read(urlCoda));
            bulats = new ImageIcon(ImageIO.read(urlBula));
            langue2 = new ImageIcon(ImageIO.read(urlLan2));
            eloque = new ImageIcon(ImageIO.read(urlEloq));
            bilingue = new ImageIcon(ImageIO.read(urlBil));
            etudeEtr = new ImageIcon(ImageIO.read(urlEtuEt));
            logiciel = new ImageIcon(ImageIO.read(urlLog));
            science2 = new ImageIcon(ImageIO.read(urlScie));
            histoire2 = new ImageIcon(ImageIO.read(urlHist));
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
    
    	
    ///Definition Espace Labels
        esp1 = new JLabel();
        esp2 = new JLabel();
        esp3 = new JLabel();
        esp4 = new JLabel();
        esp5 = new JLabel();
        esp6 = new JLabel();
        ico1 = new JLabel("# or "); //pk mettre l'argent en haut ?
        esp8 = new JLabel();
        ico2 = new JLabel("# or ");
        ico3 = new JLabel("# or ");
        esp11 = new JLabel();
        ico4 = new JLabel("# or ");
        esp13 = new JLabel();
        esp14 = new JLabel();
        esp15 = new JLabel();
        esp16 = new JLabel();
        esp17 = new JLabel();
        esp18 = new JLabel();


        //création liste des labels pour chaque action soit écrite en une fois   /!\ revoir utilité /!\
        Collection<JLabel> myLabelsGold = new ArrayList<JLabel>();
        //ordre important !!
        myLabelsGold.add(esp1);
        //myLabelsGold.add(esp2);
        myLabelsGold.add(esp3);
        //myLabelsGold.add(esp4);
        myLabelsGold.add(esp5);
        myLabelsGold.add(esp6);
        //myLabelsGold.add(esp8); plus besoin vu que définit dans la fenetre
        //myLabelsGold.add(esp11);
        myLabelsGold.add(esp13);
        myLabelsGold.add(esp14);
        myLabelsGold.add(esp15);
        myLabelsGold.add(esp16);
        myLabelsGold.add(esp17);
        myLabelsGold.add(esp18);


        Collection<JLabel> labelIcone = new ArrayList<JLabel>();
        labelIcone.add(ico1);
        labelIcone.add(ico2);
        labelIcone.add(ico3);
        labelIcone.add(ico4);


        ///REVOIR CETTE PARTIE

        Border border = BorderFactory.createLineBorder(Color.BLUE , 2);
        for (JLabel label : myLabelsGold) {
        	//border
        	label.setBorder(border);

        	label.setBorder(new EmptyBorder(5, 1, 1, 1));

        	/*
        	//position Horizontal (tous pareil)
        	label.setHorizontalAlignment(SwingConstants.TRAILING); */
        }

        for (JLabel label : labelIcone) {
            label.setVerticalAlignment(SwingConstants.TOP);
            label.setHorizontalAlignment(SwingConstants.RIGHT);
            label.setIcon(gold);
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
        esp1.setVerticalAlignment(SwingConstants.TOP);
        esp1.setHorizontalAlignment(SwingConstants.CENTER);
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
        esp3.setVerticalAlignment(SwingConstants.CENTER);
        esp3.setHorizontalAlignment(SwingConstants.LEFT);
        esp6.setVerticalAlignment(SwingConstants.CENTER);
        esp6.setHorizontalAlignment(SwingConstants.LEFT);
            //esp carte bas
        esp11.setVerticalAlignment(SwingConstants.BOTTOM);
        esp11.setHorizontalAlignment(SwingConstants.LEFT);
        esp14.setVerticalAlignment(SwingConstants.CENTER);
        esp14.setHorizontalAlignment(SwingConstants.LEFT);
        esp17.setVerticalAlignment(SwingConstants.CENTER);
        esp17.setHorizontalAlignment(SwingConstants.LEFT);
            //Plateau 3
        esp13.setVerticalAlignment(SwingConstants.CENTER);
        esp13.setHorizontalAlignment(SwingConstants.LEFT);
        esp16.setVerticalAlignment(SwingConstants.CENTER);
        esp16.setHorizontalAlignment(SwingConstants.LEFT);
            //Plateau 4
        esp15.setVerticalAlignment(SwingConstants.CENTER);
        esp15.setHorizontalAlignment(SwingConstants.LEFT);
        esp18.setVerticalAlignment(SwingConstants.CENTER);
        esp18.setHorizontalAlignment(SwingConstants.LEFT);


            //Grillage pour placer les cartes
        Border borderLabelForCarte = BorderFactory.createLineBorder(Color.MAGENTA, 5);
        esp2.setLayout(new GridLayout(1,1,1,0));
        esp2.setBorder( BorderFactory.createLineBorder(Color.darkGray, 1));
        esp5.setLayout(new GridLayout(1,1,1,0));
        esp5.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        esp13.setLayout(new GridLayout(1,1,1,0));
        esp13.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        esp17.setLayout(new GridLayout(1,1,1,0));
        esp17.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        esp8.setLayout(new GridLayout(1,1/*4*/,1,0));
        esp8.setBorder(borderLabelForCarte);
        esp11.setLayout(new GridLayout(1,1/*3*/,1,0));
        esp11.setBorder(borderLabelForCarte);
        esp14.setLayout(new GridLayout(1,1,1,0));
        esp14.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));

            //Grillage pour placer les icones
        Border borderLabelForIcone = BorderFactory.createLineBorder(Color.RED, 1);
        ico1.setLayout(new GridLayout(1,1,0,0));
        ico1.setBorder(borderLabelForIcone);
        ico2.setLayout(new GridLayout(1,1,0,0));
        ico2.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));
        ico3.setLayout(new GridLayout(1,1,0,0));
        ico3.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));
        ico4.setLayout(new GridLayout(1,1,0,0));
        ico4.setBorder(borderLabelForIcone);


        //Espaces pour les plateaux
        Border borderLabelForPlat = BorderFactory.createLineBorder(Color.GREEN , 1);
        esp1.setLayout(new GridLayout(1,1,0,0));
        esp1.setBorder(borderLabelForPlat);
        esp3.setLayout(new GridLayout(4,4,0,0));
        esp3.setBorder(borderLabelForPlat);
        esp4.setLayout(new GridLayout(4,4,0,0));
        esp4.setBorder(borderLabelForPlat);
        esp6.setLayout(new GridLayout(4,4,0,0));
        esp6.setBorder(borderLabelForPlat);
        esp13.setLayout(new GridLayout(4,4,0,0));
        esp13.setBorder(borderLabelForPlat);
        esp15.setLayout(new GridLayout(4,4,0,0));
        esp15.setBorder(borderLabelForPlat);
        esp16.setLayout(new GridLayout(2,2,0,0));
        esp16.setBorder(borderLabelForPlat);
        esp18.setLayout(new GridLayout(2,2,0,0));
        esp18.setBorder(borderLabelForPlat);

        ///Definition Label Carte (paquet de carte)
        // --> definition dans JFrameButtonCards


        //Création icônes pour les cartes
        JLabel IconeCarte1 = new JLabel();
        JLabel IconeCarte2 = new JLabel();
        JLabel IconeCarte3 = new JLabel();
        JLabel IconeCarte4 = new JLabel();
        JLabel IconeCarte5 = new JLabel();
        JLabel IconeCarte6 = new JLabel();
        JLabel IconeCarte7 = new JLabel();
        JLabel IconeCarte8 = new JLabel();
        JLabel IconeCarte9 = new JLabel();
        JLabel IconeCarte10 = new JLabel();
        JLabel IconeCarte11 = new JLabel();
        JLabel IconeCarte12 = new JLabel();
        JLabel IconeCarte13 = new JLabel();
        JLabel IconeCarte14 = new JLabel();
        JLabel IconeCarte15 = new JLabel();

        IconeCarte1.setHorizontalAlignment(SwingConstants.LEFT);


        //AIDE POUR AFFICHAGE   A CHANGER APRES EN FONCTION DU CLIC
        IconeCarte1.setIcon(iconeBe);
        IconeCarte2.setIcon(iconePi);
        IconeCarte3.setIcon(iconeBr);
        IconeCarte4.setIcon(iconeOr);
        IconeCarte5.setIcon(iconePu);
        IconeCarte6.setIcon(iconeBo);

        //affichage des icones à côté des plateaux
        //Joueur 1
            //age I
        ico1.add(IconeCarte1);
        ico1.add(IconeCarte2);
        ico1.add(IconeCarte3);
        ico1.add(IconeCarte4);
        ico1.add(IconeCarte5);
        ico1.add(IconeCarte6);
            //age II
        ico1.add(IconeCarte7);
        ico1.add(IconeCarte8);
        ico1.add(IconeCarte9);
        ico1.add(IconeCarte10);
        ico1.add(IconeCarte11);
            //age III
        ico1.add(IconeCarte12);
        ico1.add(IconeCarte13);
        ico1.add(IconeCarte14);
        ico1.add(IconeCarte15);

        //Joueur 2
            //age I
        ico2.add(IconeCarte1);
        ico2.add(IconeCarte2);
        ico2.add(IconeCarte3);
        ico2.add(IconeCarte4);
        ico2.add(IconeCarte5);
        ico2.add(IconeCarte6);
            //age II
        ico2.add(IconeCarte7);
        ico2.add(IconeCarte8);
        ico2.add(IconeCarte9);
        ico2.add(IconeCarte10);
        ico2.add(IconeCarte11);
            //age III
        ico2.add(IconeCarte12);
        ico2.add(IconeCarte13);
        ico2.add(IconeCarte14);
        ico2.add(IconeCarte15);

        //Joueur 3
            //age I
        ico3.add(IconeCarte1);
        ico3.add(IconeCarte2);
        ico3.add(IconeCarte3);
        ico3.add(IconeCarte4);
        ico3.add(IconeCarte5);
        ico3.add(IconeCarte6);
            //age II
        ico3.add(IconeCarte7);
        ico3.add(IconeCarte8);
        ico3.add(IconeCarte9);
        ico3.add(IconeCarte10);
        ico3.add(IconeCarte11);
            //age III
        ico3.add(IconeCarte12);
        ico3.add(IconeCarte13);
        ico3.add(IconeCarte14);
        ico3.add(IconeCarte15);

        //Joueur 4
            //age I
        ico4.add(IconeCarte1);
        ico4.add(IconeCarte2);
        ico4.add(IconeCarte3);
        ico4.add(IconeCarte4);
        ico4.add(IconeCarte5);
        ico4.add(IconeCarte6);
            //age II
        ico4.add(IconeCarte7);
        ico4.add(IconeCarte8);
        ico4.add(IconeCarte9);
        ico4.add(IconeCarte10);
        ico4.add(IconeCarte11);
            //age III
        ico4.add(IconeCarte12);
        ico4.add(IconeCarte13);
        ico4.add(IconeCarte14);
        ico4.add(IconeCarte15);


        ///mise en place Plateau
        for (JLabel label : myLabelsGold) {
        	this.add(label);
        }
        
        
        /** a voir lors utilsation connexion
         *  test changement valeur labelgold1 :
         * 
        	JButton button = new JButton("Change flag");
        	button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	labelGold1.setText("new value");
            }
        });
        add(button);
        */
    }


    public void actionPerformed(ActionEvent e, int joueur) {
        if (joueur == 1) {
            i = Integer.parseInt(ico1.getText());
            this.i++;
            ico1.setText(String.valueOf(i));
        } else if (joueur == 2) {
            i = Integer.parseInt(ico2.getText());
            this.i++;
            ico2.setText(String.valueOf(i));
        } else if (joueur == 3) {
            i = Integer.parseInt(ico3.getText());
            this.i++;
            ico3.setText(String.valueOf(i));
        } else if (joueur == 4) {
            i = Integer.parseInt(ico4.getText());
            this.i++;
            ico4.setText(String.valueOf(i));
        }
    }

    public void paintComponent(Graphics g) {
        
    	largeurPlat = getWidth()/3;
        longueurPlat = getHeight()/3;
        
        int largeurCarte = largeurPlat/5;
        int longueurCarte = longueurPlat/2;

        //super.paintComponent(g);

     //JOUEURS
            //joueur 1 - coin haut gauche
        g.drawImage(plateauJoueur1,0,0,largeurPlat,longueurPlat,this);

            //joueur 2 - coin haut droit
        g.drawImage(plateauJoueur2,largeurPlat*2,0,largeurPlat,longueurPlat,this);

            //joueur 3 - coin bas gauche
        g.drawImage(plateauJoueur3,0,longueurPlat*2,largeurPlat,longueurPlat,this);

            //joueur 4 - coin gauche
        g.drawImage(plateauJoueur4,largeurPlat*2,longueurPlat*2,largeurPlat,longueurPlat,this);
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