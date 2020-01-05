package com.observer;

import com.model.SousListe;

import java.util.ArrayList;
import java.util.EventObject;

public class PlayerChangedEvent extends EventObject {

    private SousListe newCards;
    private int idJoueur;

    public PlayerChangedEvent(Object source, int idJ, SousListe newCard) {
        super(source);
        this.idJoueur = idJ;
        this.newCards = newCard;
    }

    public int getNewJoueurId(){
        return idJoueur;
    }

    public SousListe getNewCards(){
        return newCards;
    }

}
