package com.model;

import javax.swing.*;
import java.util.ArrayList;

public class CarteRessource extends Carte {

    protected int type;
    protected int type2;
    protected int nombre;

    public CarteRessource(int n_costGold, ImageIcon n_image, ArrayList n_listeRessource, int type, int type2, int nombre) {
        super(n_costGold, n_image, 1, n_listeRessource);
        this.type = type;
        this.type2 = type2;
        this.nombre = nombre;
    }
}
