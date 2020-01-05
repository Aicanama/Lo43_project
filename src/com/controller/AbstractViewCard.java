package com.controller;

import com.controller.CardController;
import com.observer.CardListener;
import com.observer.PlayerListener;

//Comme le contr�leur doit le moins possible �tre d�pendant de Swing,
// on cr�e une classe abstraite repr�sentant une vue du des cartes.

public abstract class AbstractViewCard implements CardListener, PlayerListener {
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
