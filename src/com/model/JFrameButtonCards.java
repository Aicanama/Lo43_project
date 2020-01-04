package com.model;

import com.controller.AbstractViewCard;
import com.controller.CardController;
import com.model.SousListe;
import com.observer.CardChangedEvent;
import com.view.Fenetre;

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
    private JPanel contentPane = null;
    private JButton button1 = null;

    private JButton button2 = null;
    private JButton button3 = null;
    private  ImageIcon pizza;

    public JFrameButtonCards(CardController controller, SousListe ssListeJoueur) {
        super(controller);
        buildFrame(ssListeJoueur);
    }

    private void buildFrame(SousListe ssListeJoueur) {
        frame = new JFrame();
        contentPane = new JPanel();

        button1 = new JButton("Mettre à jour1");
        button2 = new JButton("Mettre à jour2");
        button3 = new JButton("Mettre à jour3");

        Collection<JButton> myButton = new ArrayList<JButton>();
        myButton.add(button1);
        myButton.add(button2);
        myButton.add(button3);
        int i=0;
        for(JButton button : myButton){
            button.setIcon(ssListeJoueur.cartes.get(i).image);
            button.setText(String.valueOf(ssListeJoueur.cartes.get(i).costGold));
            button.addActionListener(this);
            contentPane.add(button);
            i++;
        }
        frame.setContentPane(contentPane);
        frame.setTitle("JFRame");
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
        Collection<JButton> myButton = new ArrayList<JButton>();
        for(JButton button : myButton){
            button.setIcon(event.getNewCartesJoueur().cartes.get(i).image);
            button.setText("maj");
            button.addActionListener(this);
            contentPane.add(button);
            i++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Ca marche ");
        button1.setText("ok ");

    }
}
