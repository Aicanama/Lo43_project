package com.view;

import com.controller.CardController;
import com.observer.CardListener;

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
    public abstract void close();
}
