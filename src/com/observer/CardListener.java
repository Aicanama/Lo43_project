package com.observer;
import java.util.EventListener;

public interface CardListener extends EventListener {
    public void cardChangedRound(CardChangedEvent event);
}
