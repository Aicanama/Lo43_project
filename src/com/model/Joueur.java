package com.model;

public class Joueur {

    protected int id;

    protected Plateau plateau;

    protected SousListe sousListe;

    protected int gold;

    public Joueur(int n_id, Plateau n_plateau, SousListe n_sousListe) {
        this.id=n_id;
        this.plateau=n_plateau;
        this.sousListe=n_sousListe;
        this.gold=3;
    }

    public void showSousListe() {

    }

    public void hideSousListe() {

    }

}
