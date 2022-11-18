package dev.ztech.vanadium.api.events;

import dev.ztech.vanadium.events.EventCancelable;

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
