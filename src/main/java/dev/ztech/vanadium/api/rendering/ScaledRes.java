package dev.ztech.vanadium.api.rendering;

import dev.ztech.vanadium.api.base.Session;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class ScaledRes {
    public int scaledWidth;
    public int scaledHeight;
    public ScaledRes(Session session){
        ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
        scaledWidth = (int)((float)sr.getScaledWidth() / RenderStack.getScaleX());
        scaledHeight = (int)((float)sr.getScaledHeight() / RenderStack.getScaleY());
    }
}
