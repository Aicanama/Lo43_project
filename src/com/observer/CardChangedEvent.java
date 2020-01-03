package com.observer;

import com.model.SousListe;

import java.util.ArrayList;
import java.util.EventObject;

public class CardChangedEvent extends EventObject {

    private SousListe newCartes ;

    public CardChangedEvent(Object source, SousListe newCartes) {
        super(source);
        this.newCartes = newCartes;
    }

    public SousListe getNewCartesJoueur(){
        return newCartes;
    }

}
