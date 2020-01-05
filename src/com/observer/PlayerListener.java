package com.observer;

import java.util.EventListener;

public interface PlayerListener extends EventListener {
        public void cardChangedPlayer(PlayerChangedEvent event);
}
