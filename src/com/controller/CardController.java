package com.controller;

import com.model.*;
import com.view.Fenetre;

import javax.swing.*;

public class CardController {
    public JFrameButtonCards buttonView = null;

    private Moteur model = null;

    public CardController (Moteur model){
        this.model = model;
        buttonView = new JFrameButtonCards(this, model.getSsListeJoueur());
        addListenersToModel();
    }

    private void addListenersToModel() {
        model.addCardListener(buttonView);
    }

    public void displayView(){
        buttonView.display();
    }


    public void notifyCardChanged(SousListe SsListeJoueur) {
        model.setSsListeJoueur(SsListeJoueur);
    }

    public void wantRemoveCardChosen(Carte carte){
        model.remove1CardFromSousListe(carte);
    }

}