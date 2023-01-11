package dev.ztech.vanadium.api.rendering.custom;


import dev.ztech.vanadium.api.rendering.RenderStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.util.Vector3d;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

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


    private static void drawBoundingBox(AxisAlignedBB aa)  {
        RenderGlobal.drawSelectionBoundingBox(aa);
    }
    private static void drawOutlinedBoundingBox(AxisAlignedBB aa, int color){
        int a = (color >> 24 & 255);
        int r = (color >> 16 & 255);
        int g = (color >> 8 & 255);
        int b = (color & 255);
        RenderGlobal.drawOutlinedBoundingBox(aa, r, g, b, a);
    }
    public static void drawOutlinedBox(BoundingBox box, int color){
        drawOutlinedBoundingBox(new AxisAlignedBB(box.getMinX(), box.getMinY(), box.getMinZ(), box.getMaxX(), box.getMaxY(), box.getMaxZ()), color);
    }
    public static void drawBox(BoundingBox box, int color){
        float a = (float)(color >> 24 & 255) / 255.0F;
        float r = (float)(color >> 16 & 255) / 255.0F;
        float g = (float)(color >> 8 & 255) / 255.0F;
        float b = (float)(color & 255) / 255.0F;
        RenderStack.push();
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(GL11.GL_BLEND);
        RenderStack.color(r,g,b,a);
        GL11.glLineWidth(2.0F);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        drawBoundingBox(new AxisAlignedBB(box.getMinX(), box.getMinY(), box.getMinZ(), box.getMaxX(), box.getMaxY(), box.getMaxZ()));
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        RenderStack.pop();
    }
}

