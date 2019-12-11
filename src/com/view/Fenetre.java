package com.view;

import javax.swing.*;
import  java.awt.*;

public class Fenetre  extends  JFrame{


    private Plateau plateau = new Plateau();

    public static void main(String args[]){
        new Fenetre();
    }

    public Fenetre(){
        Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int hauteur = (int)tailleEcran.getHeight();
        int largeur = (int)tailleEcran.getWidth();

        this.setTitle("---Game---"); //titre
        this.setSize(tailleEcran); //plein ecran
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); //position centre ecran
        this.setContentPane(plateau);
        this.setVisible(true); //rend visible --  pack fait en sorte que tous les composants de l'application soient à leur preferredSize, ou au dessus
        System.out.println("Fenetre h: " + hauteur +" w: " + largeur );
    }

}
