package com.model;

import javax.swing.*;
import java.util.ArrayList;
//Type 5

public class CarteCommerce extends Carte {
    protected int id;

    public CarteCommerce(int n_costGold, ImageIcon n_image, ArrayList n_listeRessource, int id) {
        super(n_costGold, n_image, 5, n_listeRessource);
        this.id = id;
    }
}
