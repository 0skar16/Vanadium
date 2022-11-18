package dev.ztech.vanadium.api.rendering.custom;


import dev.ztech.vanadium.api.rendering.RenderStack;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.GL_SMOOTH;

public class Renderer3D {
    ITexture currentTexture;

    public static Renderer3D INSTANCE = new Renderer3D();

    public ITexture getCurrentTexture() {
        return currentTexture;
    }

    public void bindTexture(ITexture Texture) {
        currentTexture = Texture;
    }
    public void drawLine(double x1, double y1, double z1, double x2, double y2, double z2, float thickness, int color){
        RenderStack.push();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glHint(GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glShadeModel(GL_SMOOTH);
        GL11.glLineWidth(thickness);
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex3d(x1,y1,z1);
        GL11.glVertex3d(x2,y2,z2);
        GL11.glEnd();
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        RenderStack.pop();
    }
}

