package com.model;

import java.util.ArrayList;
import java.util.Collections;

public class Moteur {

    protected int ageActuel;

    public Moteur(int n_id) {
        this.ageActuel=n_id;
    }


    public void age1Ini(ArrayList list) {
        //le type 7 ne correspond à aucune ressource
        //Il est présent pour combler type2 lorsque la carte n'a qu'une ressource
        CarteRessource carte0 = new CarteRessource(0,"a",2,7, 1);
        list.add(carte0);
        CarteRessource carte1 = new CarteRessource(0,"a",2,7, 1);
        list.add(carte1);
        CarteRessource carte2 = new CarteRessource(0,"a",1,7, 1);
        list.add(carte2);
        CarteRessource carte3 = new CarteRessource(0,"a",0,7, 1);
        list.add(carte3);
        CarteRessource carte4 = new CarteRessource(0,"a",3,7, 1);
        list.add(carte4);
        CarteRessource carte5 = new CarteRessource(0,"a",3,7, 1);
        list.add(carte5);
        CarteRessource carte6 = new CarteRessource(0,"a",4,7, 1);
        list.add(carte6);
        CarteRessource carte7 = new CarteRessource(0,"a",5,7, 1);
        list.add(carte7);
        CarteRessource carte8 = new CarteRessource(0,"a",6,7, 1);
        list.add(carte8);
        CarteRessource carte9 = new CarteRessource(0,"a",0,1, 1);
        list.add(carte9);
        CarteRessource carte10 = new CarteRessource(0,"a",1,2, 1);
        list.add(carte10);
        CarteRessource carte11 = new CarteRessource(0,"a",0,3, 1);
        list.add(carte11);
    }

    public void shuffle(ArrayList liste) {
        Collections.shuffle(liste);
    }
}
