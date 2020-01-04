package com.controller;

import com.controller.CardController;
import com.observer.CardListener;

//Comme le contrôleur doit le moins possible être dépendant de Swing,
// on crée une classe abstraite représentant une vue du des cartes.

public abstract class AbstractViewCard implements CardListener {
    private CardController controller = null;

    public AbstractViewCard(CardController controller){
        super();
        this.controller = controller;
    }

    public final CardController getController(){
        return controller;
    }

    public abstract void display();
}
