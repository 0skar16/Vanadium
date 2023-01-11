package dev.ztech.vanadium.api.screen;

import dev.ztech.vanadium.api.base.Session;
import dev.ztech.vanadium.api.rendering.gui.ApiGui;

public class VScreen implements ApiGui {
    public void draw(Session session, ScreenEmulator parent){
        parent.drawDefaultBg();
        this.draw(session);
    }

    @Override
    public void draw(Session session) {

    }

    public boolean doesGuiPauseGame(){
        return true;
    }
}
