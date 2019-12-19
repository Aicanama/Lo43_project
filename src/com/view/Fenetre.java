package com.view;

import javax.swing.*;
import  java.awt.*;

public class Fenetre  extends  JFrame{

    private Plateau plateau = new Plateau();
    //private  PlateauIndividuel plateauIndividuel = new PlateauIndividuel();
    //private JScrollPane scroll = new JScrollPane(plateau);

    public Fenetre(){
        ///Taille ecran
        Dimension tailleEcran = new Dimension((int)getToolkit().getScreenSize().getWidth(), (int)getToolkit().getScreenSize().getHeight() - 35);
        int hauteur = (int)tailleEcran.getHeight()-35;
        int largeur = (int)tailleEcran.getWidth();

        /*setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(MAXIMIZED_BOTH);*/
        System.out.println(hauteur +" "+ largeur);
        this.setTitle("---Game---"); //titre
        this.setPreferredSize(tailleEcran); //plein ecran
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLocationRelativeTo(null); //position centre ecran

        ///Content pane
        this.setContentPane(plateau);

        this.pack();
        this.setVisible(true); //rend visible -- sinon  pack fait en sorte que tous les composants de l'application soient à leur preferredSize, ou au dessus

    }

    public static void main(String args[]){
        new Fenetre();
    }

}
