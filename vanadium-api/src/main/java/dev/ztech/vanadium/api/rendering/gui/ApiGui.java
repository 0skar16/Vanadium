package dev.ztech.vanadium.api.rendering.gui;

import dev.ztech.vanadium.api.base.Session;

public interface ApiGui {

    default boolean isRendering() {
        return true;
    }

    void draw(Session session);
    default boolean mousePressed(int mouseX, int mouseY, int button){
        return false;
    }
    default void mouseReleased(int mouseX, int mouseY){};
    default void mouseDrag(int x, int y, int button, long deltat){};
}
