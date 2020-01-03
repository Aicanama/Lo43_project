package com.controller;

import com.model.Moteur;
import com.model.SousListe;
import com.view.AbstractViewCard;
import com.view.Fenetre;

public class CardController {
    public AbstractViewCard buttonView = null;

    private Moteur model = null;

    public CardController (Moteur model){
        this.model = model;
        //buttonView = new Fenetre(/*this, model.getSsListeJoueur1()*/);
        addListenersToModel();
    }

    private void addListenersToModel() {
        model.addCardListener(buttonView);
    }

    public void displayView(){
        buttonView.display();
    }

    public void closeView(){
        buttonView.close();
    }

    public void notifyCardChanged(SousListe SsListeJoueur) {
        model.setSsListeJoueur(SsListeJoueur);
    }

}