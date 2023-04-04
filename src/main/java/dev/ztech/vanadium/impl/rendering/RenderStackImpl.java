package dev.ztech.vanadium.impl.rendering;

import dev.ztech.vanadium.api.rendering.RenderStack;
import dev.ztech.vanadium.api.rendering.Vec3;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class RenderStackImpl implements RenderStack {
    @Override
    public void push(){
        previousScale = scale;
        GL11.glPushMatrix();
    }
    @Override
    public void pop(){
        scale = previousScale;
        GL11.glPopMatrix();
    }

    @Override
    public Vec3 getScale() {
        return scale;
    }

    @Override
    public Vec3 getPreviousScale() {
        return previousScale;
    }

    private Vec3 scale = new Vec3(1.0f, 1.0f, 1.0f);
    private Vec3 previousScale = new Vec3(1.0f, 1.0f, 1.0f);
    @Override
    public void translate(Vec3 transform){
        GL11.glTranslatef(transform.getX(), transform.getY(), transform.getZ());
    }
    @Override
    public void scale(Vec3 scale){
        this.scale = scale;
        GL11.glScalef(scale.getX(), scale.getY(), scale.getZ());
    }


    @Override
    public void color(float r, float g, float b, float a){
        GlStateManager.color(r,g,b,a);
    }
    public int getChroma(int x, int y){
        long l = System.currentTimeMillis() - (x * 10L - y * 10L);
        return Color.HSBtoRGB(l % (int) 2000.0F / 2000.0F, 0.8F, 0.8F);
    }
}
