package com.view;


import com.model.JFrameButtonCards;

import javax.swing.*;
import java.awt.event.*;

import  java.awt.*;

public class Fenetre  extends  JFrame{

    private Plateau plateau = new Plateau();
    private static final long serialVersionUID = 1L; //--> qu'est ce que c'est ??

    public Fenetre(){
        ///Taille ecran
        Dimension tailleEcran = new Dimension((int)getToolkit().getScreenSize().getWidth(), (int)getToolkit().getScreenSize().getHeight()-35);
        int hauteur = (int)tailleEcran.getHeight()-35;
        int largeur = (int)tailleEcran.getWidth();

        this.setTitle("---Game---"); //titre
        this.setPreferredSize(tailleEcran); //plein ecran
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ///Content pane
        this.setContentPane(plateau);

        this.pack();    // pack fait en sorte que tous les composants preferredSize, ou au dessus
        this.setVisible(true); //rend visible
    }

   /* public static void main(String[] args) {
        new Fenetre();
    }*/



}