package dev.ztech.vanadium.api.eventsystem.events;

import dev.ztech.vanadium.api.eventsystem.EventCancelable;

public class MouseMoveEvent extends EventCancelable {
    public int x;
    public int y;
    public MouseMoveEvent(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
}
