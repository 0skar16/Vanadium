package dev.ztech.vanadium.api.events;

import dev.ztech.vanadium.events.EventCancelable;

public class MouseClickEvent extends EventCancelable{
    private int key, x, y;
    private boolean state;
    public MouseClickEvent(int key, int x, int y, boolean state){
        this.key = key;
        this.x = x;
        this.y = y;
        this.state = state;
    }

    public int getKey() {
        return key;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getState() {
        return state;
    }
}
