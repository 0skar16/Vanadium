package dev.ztech.vanadium.impl.rendering.custom;


import dev.ztech.vanadium.api.base.Position;
import dev.ztech.vanadium.api.base.Session;
import dev.ztech.vanadium.api.rendering.RenderStack;
import dev.ztech.vanadium.api.rendering.custom.BoundingBox;
import dev.ztech.vanadium.api.rendering.custom.ITexture;
import dev.ztech.vanadium.api.rendering.custom.Renderer2D;
import dev.ztech.vanadium.api.rendering.custom.Renderer3D;
import dev.ztech.vanadium.impl.base.SessionImpl;
import dev.ztech.vanadium.impl.rendering.RenderStackImpl;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.opengl.GL11;

public class Renderer3DImpl implements Renderer3D {
    ITexture currentTexture;

    public ITexture getCurrentTexture() {
        return currentTexture;
    }

    public void bindTexture(ITexture Texture) {
        currentTexture = Texture;
    }


    private void drawBoundingBox(AxisAlignedBB aa)  {
        RenderGlobal.drawSelectionBoundingBox(aa);
    }
    private void drawOutlinedBoundingBox(AxisAlignedBB aa, int color){
        int a = (color >> 24 & 255);
        int r = (color >> 16 & 255);
        int g = (color >> 8 & 255);
        int b = (color & 255);
        RenderGlobal.drawOutlinedBoundingBox(aa, r, g, b, a);
    }
    public void drawOutlinedBox(BoundingBox box, int color){
        Position min = box.getMin();
        Position max = box.getMax();
        drawOutlinedBoundingBox(new AxisAlignedBB(min.getX(), min.getY(), min.getZ(), max.getX(), max.getY(), min.getZ()), color);
    }
    public void drawBox(BoundingBox box, int color){
        float a = (float)(color >> 24 & 255) / 255.0F;
        float r = (float)(color >> 16 & 255) / 255.0F;
        float g = (float)(color >> 8 & 255) / 255.0F;
        float b = (float)(color & 255) / 255.0F;
        RenderStack stack = SessionImpl.getInstance().getRenderingBuilder().getStack();
        stack.push();
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(GL11.GL_BLEND);
        stack.color(r,g,b,a);
        GL11.glLineWidth(2.0F);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        Position min = box.getMin();
        Position max = box.getMax();
        drawBoundingBox(new AxisAlignedBB(min.getX(), min.getY(), min.getZ(), max.getX(), max.getY(), min.getZ()));
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        stack.pop();
    }
}

