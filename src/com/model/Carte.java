package com.model;

import javax.swing.*;
import java.util.ArrayList;

public class Carte {

    protected int costGold;
    protected ImageIcon image;
    protected int carteType;
    protected ArrayList listeRessource;

    public Carte() {
        this.costGold=0;
        this.carteType=0;
        this.listeRessource=new ArrayList();
    }
    public Carte(int n_costGold, ImageIcon n_image, int n_carteType, ArrayList n_listeRessource) {
        this.costGold=n_costGold;
        this.image=n_image;
        this.carteType=n_carteType;
        this.listeRessource=n_listeRessource;
    }
}
