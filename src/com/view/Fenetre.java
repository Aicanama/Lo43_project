package com.view;

import javax.swing.*;
import  java.awt.*;

public class Fenetre  extends  JFrame{

    private Plateau plateau = new Plateau();

    public Fenetre(){
        ///Taille ecran
        Dimension tailleEcran = new Dimension((int)getToolkit().getScreenSize().getWidth(), (int)getToolkit().getScreenSize().getHeight()-35);
        int hauteur = (int)tailleEcran.getHeight()-35;
        int largeur = (int)tailleEcran.getWidth();
        System.out.println(hauteur +" "+ largeur);

        this.setTitle("---Game---"); //titre
        this.setPreferredSize(tailleEcran); //plein ecran
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ///Content pane
        this.setContentPane(plateau);

        this.pack();    // pack fait en sorte que tous les composants preferredSize, ou au dessus
        this.setVisible(true); //rend visible
    }

    public static void main(String [] args){
        new Fenetre();  //appel constructeur
    }

}
