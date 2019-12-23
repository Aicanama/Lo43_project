package com.view;
import com.model.*;

import java.awt.*;
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
    private Image plateauJoueur;
    private  ImageIcon gold , carte;
    private int largeurPlat;
    private int longueurPlat;


    //constructeur @leo
    protected char image;
    protected int ressource;
    protected String imageRessource;
    protected int nbrRessource;

    public Plateau(){
    	
    	//grille pour les labels argent
    	this.setLayout(new GridLayout(2,3));
        
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
            carte = new ImageIcon(ImageIO.read(urlCarte));
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
    
    	
    ///Definition LabelGold et icon

    	JLabel labelGold1 = new JLabel("111 "); //mettre espace a la fin !! car sinon trop collé
        JLabel labelGold2 = new JLabel("22 ");
        JLabel labelGold3 = new JLabel("333 ");
        JLabel labelGold4 = new JLabel("444 ");
        JLabel Esp1 = new JLabel("Esp1 "); //espace seront les endroits "vides"
        JLabel Esp2 = new JLabel("Esp2 ");
 
        
        Collection<JLabel> myLabelsGold = new ArrayList<JLabel>(); //création liste des labels pour chaque action soit écrite en une fois
        //ordre important !!
        myLabelsGold.add(labelGold1);
        myLabelsGold.add(Esp1);
        myLabelsGold.add(labelGold2);
        myLabelsGold.add(labelGold3);
        myLabelsGold.add(Esp2);
        myLabelsGold.add(labelGold4);
        
        Border border = BorderFactory.createLineBorder(Color.RED , 5); //va permettre de créer des espaces pour positionner mieux
        
        for (JLabel label : myLabelsGold) {
        	//border
        	label.setBorder(border);
        	
        	//icon
        	String name = label.getText(); //texte donné pas le nom du label
        	if(!name.startsWith("Esp")) {
        		label.setIcon(gold);
        	}
        	
        	if(name.startsWith("Esp")) {
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
        
        Esp1.setVerticalAlignment(SwingConstants.TOP);
        Esp1.setHorizontalAlignment(SwingConstants.CENTER);

        Esp2.setVerticalAlignment(SwingConstants.TOP);
        Esp2.setHorizontalAlignment(SwingConstants.CENTER);





        ///Definition Label Carte

        //carte du haut (4) = espace 1

        //Border espace
        Border borderLabelForCarte = BorderFactory.createLineBorder(Color.GREEN , 5);
        Esp1.setLayout(new GridLayout(1,4,0,0));
        Esp1.setBorder(borderLabelForCarte);

        //Création carte
        JButton Carte1 = new JButton("this card");
        Carte1.setIcon(carte);
        Carte1.setVerticalAlignment(SwingConstants.BOTTOM);
        JLabel Carte2 = new JLabel();
        Carte2.setVerticalAlignment(SwingConstants.BOTTOM);
        Carte2.setIcon(carte);
        JLabel Carte3 = new JLabel();
        Carte3.setVerticalAlignment(SwingConstants.BOTTOM);
        Carte3.setIcon(carte);
        JLabel Carte4 = new JLabel();
        Carte4.setVerticalAlignment(SwingConstants.BOTTOM);
        Carte4.setIcon(carte);

        //set on Esp1
        Esp1.add(Carte1);
        Esp1.add(Carte2);
        Esp1.add(Carte3);
        Esp1.add(Carte4);

        //carte du bas (3) = espace 2

        //Border espace
        Esp2.setLayout(new GridLayout(1,4,0,0));
        Esp2.setBorder(borderLabelForCarte);

        //Création carte
        JLabel Carte5 = new JLabel();
        Carte5.setIcon(carte);
        Carte5.setVerticalAlignment(SwingConstants.BOTTOM);
        JLabel Carte6 = new JLabel();
        Carte6.setVerticalAlignment(SwingConstants.BOTTOM);
        Carte6.setIcon(carte);
        JLabel Carte7 = new JLabel();
        Carte7.setVerticalAlignment(SwingConstants.BOTTOM);
        Carte7.setIcon(carte);

        //set on Esp2
        Esp2.add(Carte5);
        Esp2.add(Carte6);
        Esp2.add(Carte7);
        





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

    public Plateau(char n_image, int n_ressource, String n_imageRessource) {
        this.image=n_image;
        this.imageRessource=n_imageRessource;
        this.ressource=n_ressource;
        this.nbrRessource=0;
    }

    public void paintComponent(Graphics g) {
        
    	largeurPlat = getWidth()/3;
        longueurPlat = getHeight()/3;
        System.out.println("largeurPlat : " + largeurPlat +" longueurPlat : "+ longueurPlat);
        
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
   
    
 
}