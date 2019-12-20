package com.view;

import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.net.URL;

public class Plateau extends JPanel{
    //conteneur = content pane

    private static final long serialVersionUID = 1L; //--> qu'est ce que c'est ??
    private Image plateauJoueur, carte;
    private  ImageIcon gold;
    private int largeurPlat;
    private int longueurPlat;


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
            carte = ImageIO.read(urlCarte);
            
            	//Icon
            gold = new ImageIcon(ImageIO.read(urlGold));
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
    
    ///Definition LabelGold et icon
    	
    	JLabel labelGold1 = new JLabel("111");
        labelGold1.setIcon(gold);
        
        /** test changement valeur labelgold1 :
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
        
        JLabel  labelGold2 = new JLabel("22 ");
        labelGold2.setIcon(gold);
        JLabel labelGold3 = new JLabel("333");
        labelGold3.setIcon(gold);
        JLabel labelGold4 = new JLabel("444 ");
        labelGold4.setIcon(gold);

       
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

      //CARTES
         //4 en haut et 3 en bas
        g.drawImage(carte,	largeurPlat+10,						longueurPlat+10,	largeurCarte,longueurCarte,this); 
        g.drawImage(carte,	largeurPlat+10*2+largeurCarte,		longueurPlat+10,	largeurCarte,longueurCarte,this);
        g.drawImage(carte,	largeurPlat+15*2+largeurCarte*2,	longueurPlat+10,	largeurCarte,longueurCarte,this);
        g.drawImage(carte,	largeurPlat+15*3+largeurCarte*3,	longueurPlat+10,	largeurCarte,longueurCarte,this);
       
        g.drawImage(carte,	largeurPlat+10+largeurCarte,		longueurPlat+10+longueurCarte+10,	largeurCarte,longueurCarte,this);
        g.drawImage(carte,	largeurPlat+10*2+largeurCarte*2,	longueurPlat+10+longueurCarte+10,	largeurCarte,longueurCarte,this);
        g.drawImage(carte,	largeurPlat+15*2+largeurCarte*3,	longueurPlat+10+longueurCarte+10,	largeurCarte,longueurCarte,this);

    }
   
    
 
}