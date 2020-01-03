package com.model;

import javax.swing.*;
import java.util.ArrayList;
//Type 3

public class CarteConnaissance extends Carte {
    protected int type;

    public CarteConnaissance(int n_costGold, ImageIcon n_image, ArrayList n_listeRessource, int type) {
        super(n_costGold, n_image, 3, n_listeRessource);
        this.type = type;
    }
}
