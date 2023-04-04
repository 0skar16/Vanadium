package dev.ztech.vanadium.api.eventsystem.events;


import dev.ztech.vanadium.api.base.Session;
import dev.ztech.vanadium.api.eventsystem.Event;

public class InitEvent extends Event {
    Session session;
    public InitEvent(Session session) {
        this.session = session;
    }
    public Session getSession() {
        return session;
    }
}
