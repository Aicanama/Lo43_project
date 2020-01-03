package com.controller;

import com.model.Moteur;
import com.model.SousListe;
import com.view.AbstractViewCard;
import com.view.Fenetre;

public class CardController {
    public AbstractViewCard listView = null;

    private Moteur model = null;

    public CardController (Moteur model){
        this.model = model;
        listView = new Fenetre(/*this, model.getSsListeJoueur1()*/);
        addListenersToModel();
    }

    private void addListenersToModel() {
        model.addCardListener(listView);
    }

    public void displayView(){
        listView.display();
    }

    public void closeView(){
        listView.close();
    }

    public void notifyCardChanged(SousListe SsListeJoueur) {
        model.setSsListeJoueur(SsListeJoueur);
    }

}