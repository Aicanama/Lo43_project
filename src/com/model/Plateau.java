package com.model;

public class Plateau {

    protected char image;

    protected int ressource;

    protected String imageRessource;

    protected int nbrRessource;

    public Plateau(char n_image, int n_ressource, String n_imageRessource) {
        this.image=n_image;
        this.imageRessource=n_imageRessource;
        this.ressource=n_ressource;
        this.nbrRessource=0;
    }

    public void afficherCarte(int type) {

    }

}
