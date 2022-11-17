package dev.ztech.vanadium.api.rendering.gui;

import dev.ztech.vanadium.api.base.Session;

public interface ApiGui {

    default boolean isRendering() {
        return true;
    }

    void draw(Session session);
    default boolean mousePressed(Session session){
        return false;
    }
    default void mouseReleased(Session session){};
}
