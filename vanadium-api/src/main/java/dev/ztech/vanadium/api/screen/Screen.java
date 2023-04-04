package dev.ztech.vanadium.api.screen;

import dev.ztech.vanadium.api.base.Session;
import dev.ztech.vanadium.api.rendering.gui.ApiGui;

public interface Screen extends ApiGui {
    default void draw(Session session, ScreenEmulator parent) {
        parent.drawDefaultBg();
        this.draw(session);
    };
    default boolean doesGuiPauseGame() {
        return true;
    }

}
