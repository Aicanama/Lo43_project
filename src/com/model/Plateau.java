package com.model;

import javax.swing.*;
import java.util.ArrayList;

public class Plateau {

    protected char image;
    protected int ressource;
    protected ImageIcon imageRessource;
    protected ArrayList<CarteRessource> listeRessource;

    public Plateau(char n_image, int n_ressource, ImageIcon n_imageRessource) {
        this.image = n_image;
        this.imageRessource = n_imageRessource;
        this.ressource = n_ressource;
        this.listeRessource = new ArrayList<CarteRessource>();
    }

    public void afficherCarte(int type) {
    }

    public void updateListe(CarteRessource carteR) {
        this.listeRessource.add(carteR);
    }
}