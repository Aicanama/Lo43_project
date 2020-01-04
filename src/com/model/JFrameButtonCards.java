package com.model;

import com.controller.AbstractViewCard;
import com.controller.CardController;
import com.model.SousListe;
import com.observer.CardChangedEvent;
import com.view.Plateau;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;

public class JFrameButtonCards extends AbstractViewCard implements ActionListener {

    private JFrame frame = null;
    private JPanel contentPaneCarteHigh = null;
    private JPanel  contentPaneCarteLow = null;
    private Plateau plateau = null;

    private JButton btnC1 = null;
    private JButton btnC2 = null;
    private JButton btnC3 = null;
    private JButton btnC4 = null;
    private JButton btnC5 = null;
    private JButton btnC6 = null;
    private JButton btnC7 = null;

    private  ImageIcon pizza;

    public JFrameButtonCards(CardController controller, SousListe ssListeJoueur) {
        super(controller);
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


        //content pane
        contentPaneCarteHigh = new JPanel();
        contentPaneCarteLow = new JPanel();
        plateau = new Plateau();

        contentPaneCarteHigh.setLayout(new GridLayout(1,4,1,0));
        btnC1 = new JButton();
        btnC2 = new JButton();
        btnC3 = new JButton();
        btnC4 = new JButton();

        contentPaneCarteHigh.setLayout(new GridLayout(1,3,1,0));
        btnC5 = new JButton();
        btnC6 = new JButton();
        btnC7 = new JButton();

        Collection<JButton> allButtonCards = new ArrayList<JButton>();
        allButtonCards.add(btnC1);
        allButtonCards.add(btnC2);
        allButtonCards.add(btnC3);
        allButtonCards.add(btnC4);
        allButtonCards.add(btnC5);
        allButtonCards.add(btnC6);
        allButtonCards.add(btnC7);

        int i=0;
        for(JButton button : allButtonCards){
            button.setIcon(ssListeJoueur.cartes.get(i).image);
            button.addActionListener(this);
            if(i<4) contentPaneCarteHigh.add(button);
            else contentPaneCarteLow.add(button);
            i++;
        }
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
    public void close() {
        frame.dispose();
    }

    @Override
    public void cardChangedRound(CardChangedEvent event) {

        int i = 0;
        Collection<JButton> allButtonCards = new ArrayList<JButton>();
        for(JButton button : allButtonCards){
            button.setIcon(event.getNewCartesJoueur().cartes.get(i).image);
            button.setText("maj");
            button.addActionListener(this);
            contentPaneCarteHigh.add(button);
            i++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("clique sur boutton carte");


    }
}
