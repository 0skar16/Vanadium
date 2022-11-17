package dev.ztech.vanadium.ui;

import dev.ztech.vanadium.api.base.Session;
import dev.ztech.vanadium.api.rendering.RenderStack;
import dev.ztech.vanadium.api.rendering.ScaledRes;
import dev.ztech.vanadium.api.screen.ScreenEmulator;
import dev.ztech.vanadium.api.screen.VScreen;

public class VanadiumScreen extends VScreen {
    @Override
    public void draw(Session session, ScreenEmulator parent){
        super.draw(session, parent);
        RenderStack.push();
        RenderStack.scale(1.5f,1.5f,1f);
        ScaledRes sr = new ScaledRes(session);
        Session.defaultTextRenderer.renderCentered("Vanadium", sr.scaledWidth/2, 15, -1);
        RenderStack.pop();
    }
}
