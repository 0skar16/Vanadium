package dev.ztech.vanadium.api.eventsystem.events;

import dev.ztech.vanadium.api.eventsystem.EventCancelable;

public class KeyEvent extends EventCancelable {
    private int key;
    private boolean state;
    public KeyEvent(int key, boolean state){
        this.key = key;
        this.state = state;
    }

    public int getKey() {
        return key;
    }

    public boolean getState() {
        return state;
    }
}
