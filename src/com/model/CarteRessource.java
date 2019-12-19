package com.model;

public class CarteRessource extends Carte{

    protected int type;

    protected int type2;

    protected int nombre;

    public CarteRessource(int n_costGold, String n_image, int n_type, int n_type2, int n_nombre) {
        super(n_costGold, n_image, 0);
        this.type=n_type;
        this.type2=n_type2;
        this.nombre=n_nombre;
    }



}
