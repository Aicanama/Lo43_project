package com.observer;

import com.model.SousListe;

import java.util.ArrayList;
import java.util.EventObject;

public class CardChangedEvent extends EventObject {

    private SousListe newCartes ;
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public CardChangedEvent(Object source, ArrayList<> newCartes) {
        super(source);

        this.newCartes = newCartes;
    }

    public SousListe getNewCartesJoueur(){
        return newCartes;
    }

}
