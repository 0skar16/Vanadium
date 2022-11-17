package dev.ztech.vanadium.api.events;

import dev.ztech.vanadium.events.EventCancelable;

public class MouseMoveEvent extends EventCancelable {
    public int x;
    public int y;
    public MouseMoveEvent(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
}
