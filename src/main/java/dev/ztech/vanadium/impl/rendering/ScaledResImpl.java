package dev.ztech.vanadium.impl.rendering;

import dev.ztech.vanadium.api.base.Session;
import dev.ztech.vanadium.api.rendering.ScaledRes;
import dev.ztech.vanadium.api.rendering.Vec3;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class ScaledResImpl implements ScaledRes {
    public int scaledWidth;
    public int scaledHeight;
    public ScaledResImpl(Session session){
        Vec3 scale = session.getRenderingBuilder().getStack().getScale();
        ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
        scaledWidth = (int)((float)sr.getScaledWidth() / scale.getX());
        scaledHeight = (int)((float)sr.getScaledHeight() / scale.getY());
    }

    @Override
    public int getScaledWidth() {
        return scaledWidth;
    }

    @Override
    public int getScaledHeight() {
        return scaledHeight;
    }
}
