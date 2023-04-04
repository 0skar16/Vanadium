package dev.ztech.vanadium.ui;

import dev.ztech.vanadium.api.base.Session;
import dev.ztech.vanadium.api.rendering.RenderStack;
import dev.ztech.vanadium.api.rendering.Vec3;
import dev.ztech.vanadium.api.screen.Screen;
import dev.ztech.vanadium.impl.rendering.ScaledResImpl;

public class VanadiumScreen implements Screen {
    @Override
    public void draw(Session session) {
        RenderStack stack = session.getRenderingBuilder().getStack();
        stack.push();
        stack.scale(new Vec3(1.5f,1.5f,1f));
        ScaledResImpl sr = new ScaledResImpl(session);
        session.getRenderingBuilder().getCurrentTextRenderer().renderCentered("Vanadium", sr.scaledWidth/2, 15, -1);
        stack.pop();
    }
}
