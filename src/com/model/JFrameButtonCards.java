package com.model;

import com.controller.AbstractViewCard;
import com.controller.CardController;
import com.observer.CardChangedEvent;
import com.observer.PlayerChangedEvent;
import com.view.Plateau;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Collection;


public class JFrameButtonCards extends AbstractViewCard implements ActionListener {

    private JFrame frame = null;
    private JPanel contentPaneCarteHigh = null;
    private JPanel  contentPaneCarteLow = null;
    private Plateau plateau = null;
    protected SousListe ssListeJoueur;
    protected int idJoueur;
    protected Joueur joueur;

    private Collection<JButton> allButtonCards;
    private JButton btnC1;
    private JButton btnC2;
    private JButton btnC3;
    private JButton btnC4;
    private JButton btnC5;
    private JButton btnC6;
    private JButton btnC7;
    private JButton btnNext;
    private JLabel ico1, ico2, ico3, ico4;
    private ImageIcon gold;

    private JLabel fieldNumJoueur = null;

    private  ImageIcon pizza;

    public JFrameButtonCards(CardController controller, SousListe ssListeJoueur, int idj, Joueur j) {
        super(controller);
        this.ssListeJoueur = ssListeJoueur;
        this.idJoueur = idj;
        this.joueur = j;
        buildFrame(ssListeJoueur);
    }

    private void buildFrame(SousListe ssListeJoueur) {
        //fenetre
        frame = new JFrame();

        ///Taille ecran
        Dimension tailleEcran = new Dimension((int)frame.getToolkit().getScreenSize().getWidth(), (int)frame.getToolkit().getScreenSize().getHeight()-35);
        int hauteur = (int)tailleEcran.getHeight()-35;
        int largeur = (int)tailleEcran.getWidth();

        frame.setTitle("---Game---"); //titre
        frame.setPreferredSize(tailleEcran); //plein ecran
        frame.setResizable(false);


        ico1 = new JLabel();
        ico2 = new JLabel();
        ico3 = new JLabel();
        ico4 = new JLabel();

        Collection<JLabel> myGold = new ArrayList<JLabel>();
        myGold.add(ico1);
        myGold.add(ico2);
        myGold.add(ico3);
        myGold.add(ico4);

        for (JLabel label : myGold) {
            label.setVerticalAlignment(SwingConstants.TOP);
            label.setHorizontalAlignment(SwingConstants.RIGHT);
            label.setIcon(gold);
        }

        //content pane
        contentPaneCarteHigh = new JPanel();
        contentPaneCarteLow = new JPanel();
        plateau = new Plateau();

        //affichage numero joueur
        fieldNumJoueur = new JLabel();
        fieldNumJoueur.setText(" Tour de J" + String.valueOf(idJoueur+1));
        fieldNumJoueur.setHorizontalAlignment(SwingConstants.CENTER);
        fieldNumJoueur.setFont(new Font("Serif", Font.BOLD, 30));

        contentPaneCarteHigh.setLayout(new GridLayout(1,4,1,0));
        btnC1 = new JButton();
        btnC2 = new JButton();
        btnC3 = new JButton();
        btnC4 = new JButton();

        contentPaneCarteHigh.setLayout(new GridLayout(1,3,1,0));
        btnC5 = new JButton();
        btnC6 = new JButton();
        btnC7 = new JButton();

        btnNext = new JButton("next player");
        btnNext.setEnabled(false);

        //---- btn carte -----------------------
        allButtonCards = new ArrayList<JButton>();
        allButtonCards.add(btnC1);
        allButtonCards.add(btnC2);
        allButtonCards.add(btnC3);
        allButtonCards.add(btnC4);
        allButtonCards.add(btnC5);
        allButtonCards.add(btnC6);
        allButtonCards.add(btnC7);

        int i=0;
        int k=ssListeJoueur.cartes.size();

        for(JButton button : allButtonCards){
            if(k>0) {
                button.setIcon(ssListeJoueur.cartes.get(i).image);
                button.setEnabled(true);
                //set action listeners for button
                button.addActionListener(this);
                if (i < 4) contentPaneCarteHigh.add(button);
                else contentPaneCarteLow.add(button);
                i++;
                k--;

            }

        }


        // define a custom short action command for the button
       btnC1.setActionCommand("Carte1");
       btnC2.setActionCommand("Carte2");
       btnC3.setActionCommand("Carte3");
       btnC4.setActionCommand("Carte4");
       btnC5.setActionCommand("Carte5");
       btnC6.setActionCommand("Carte6");
       btnC7.setActionCommand("Carte7");


       //----btn next -------------
        btnNext.addActionListener(this);
        btnNext.setActionCommand("Next");


        plateau.add(fieldNumJoueur,3);
        plateau.add(btnNext,1);
        plateau.add(contentPaneCarteHigh,7);
        plateau.add(contentPaneCarteLow,10);
        frame.setContentPane(plateau);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void display() {
        frame.setVisible(true);
    }

    @Override
    //affichage sans la carte choisie dun joueur
    public void cardChangedRound(CardChangedEvent event) {
        int i=0; //faire separation entre carte hautes et basses
        int k=event.getNewCartesJoueur().cartes.size(); //taille sousliste du nouveau tas du joueur (sans celle enlevé précedemnt
        System.out.println("cardChangedRound :: event.getNewCartesJoueur().cartes.size() : " + k);

       for(JButton button : allButtonCards){
           if(k>0) {
               button.setIcon(event.getNewCartesJoueur().cartes.get(i).image);
               if (i < 4) contentPaneCarteHigh.add(button);
               else contentPaneCarteLow.add(button);
               i++;
               k--;
          }
        }

            switch (event.getNewCartesJoueur().cartes.size()) {
                case 7 :
                    System.out.println("cardChangedRound:: nouveau joueur");
                case 6 : contentPaneCarteLow.remove(btnC7);
                    contentPaneCarteLow.repaint();
                break;
                case 5 : contentPaneCarteLow.remove(btnC6);
                    contentPaneCarteLow.repaint();
                    break;
                case 4 : contentPaneCarteLow.remove(btnC5);
                    contentPaneCarteLow.repaint();
                    break;
                case 3 : contentPaneCarteHigh.remove(btnC4);
                    contentPaneCarteHigh.repaint();
                    break;
                case 2 : contentPaneCarteHigh.remove(btnC3);
                    contentPaneCarteHigh.repaint();
                    break;
                default: contentPaneCarteHigh.remove(btnC2);
                    JOptionPane.showMessageDialog(frame,
                            "fin d'un age");
                    btnC1.setEnabled(false);
                    contentPaneCarteHigh.repaint();
                    System.out.println("Jframe :: cardChangedRound : plus qu'une seule carte dans ssliste = fin age");
                    break;
            }

    }

    @Override
    //changement carte lors clique next player
    //affichage sous liste joueur suivant
    public void cardChangedPlayer(PlayerChangedEvent event){
        int i=0; //faire separation entre carte hautes et basses
        int k=event.getNewCards().cartes.size(); //taille sousliste du nouveau tas du joueur (sans celle enlevé précedemnt
        System.out.println("cardChangedPlayer :: event.getNewCartesJoueur().cartes.size() : " + k);
        ssListeJoueur = event.getNewCards();

        for(JButton button : allButtonCards){
            if(k>0) {
                button.setIcon(event.getNewCards().cartes.get(i).image);
                if (i < 4) contentPaneCarteHigh.add(button);
                else contentPaneCarteLow.add(button);
                i++;
                k--;
            }
        }

        fieldNumJoueur.setText("Tour de J" + String.valueOf(event.getNewJoueurId()+1));
        fieldNumJoueur.repaint();
        plateau.repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        //ici lorsque clique
        if (action.equals("Carte1")) {
            System.out.println("Clique Carte 1");
            getController().wantRemoveCardChosen(ssListeJoueur.cartes.get(0));
            btnC1.setIcon(null);
        }
        else if (action.equals("Carte2")) {
            System.out.println("Clique Carte 2");
            getController().wantRemoveCardChosen(ssListeJoueur.cartes.get(1));
            btnC2.setIcon(null);
        }
        else if (action.equals("Carte3")) {
            System.out.println("Clique Carte 3");
            getController().wantRemoveCardChosen(ssListeJoueur.cartes.get(2));
            btnC3.setIcon(null);
        }
        else if (action.equals("Carte4")) {
            System.out.println("Clique Carte 4");
            getController().wantRemoveCardChosen(ssListeJoueur.cartes.get(3));
            btnC4.setIcon(null);
        }
        else if (action.equals("Carte5")) {
            System.out.println("Clique Carte 5");
            getController().wantRemoveCardChosen(ssListeJoueur.cartes.get(4));
            btnC5.setIcon(null);
        }
        else if (action.equals("Carte6")) {
            System.out.println("Clique Carte 6");
            getController().wantRemoveCardChosen(ssListeJoueur.cartes.get(5));
            btnC6.setIcon(null);
        }
        else if (action.equals("Carte7")) {
            System.out.println("Clique Carte 7");
            getController().wantRemoveCardChosen(ssListeJoueur.cartes.get(6));
            btnC7.setIcon(null);
        }

        for(JButton button : allButtonCards){
            button.setEnabled(false);
        }

        //si dernier joueur au dernier tour sinon au prochain joueur
        if(idJoueur==3 && allButtonCards.size()==1) {
            btnNext.setEnabled(false);
        }
        else btnNext.setEnabled(true);

        //envoi au controller nouvelle sous liste sans la carte choisie du joueur en cours
        getController().notifyCardChanged(ssListeJoueur);

        if (action.equals("Next")){
            System.out.println("Clique Next");
            ++idJoueur;
            if(idJoueur==4)
                idJoueur=0;

            //envoi au controller le nouvel idJoueur
            getController().notifyIdJoueurChanged(idJoueur);
            for(JButton button : allButtonCards){
                button.setEnabled(true);
            }
            btnNext.setEnabled(false);
        }
        plateau.repaint();

    }

}
