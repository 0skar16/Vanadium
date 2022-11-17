package dev.ztech.vanadium.api.rendering.custom;

import dev.ztech.vanadium.api.base.Base;
import dev.ztech.vanadium.api.base.Resource;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class Renderer2D {
    Resource currentTexture;
    protected float zLevel;
    public static Renderer2D INSTANCE = new Renderer2D();

    public Resource getCurrentTexture() {
        return currentTexture;
    }
    public void bindTexture(Resource Texture){
        currentTexture = Texture;
    }
    public void drawRect(int x, int y, int width, int height, int color){
        Gui.drawRect(x, y, width, height, color);
    }
    public void drawTexturedRect(int x, int y, int texX, int texY, int width, int height){
        if(currentTexture == null){
            Base.logger.logError("Tried drawing a Textured Rect without setting the Texture");
            return;
        }
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(currentTexture.getResourceDomain(), currentTexture.getResourcePath()));
        float var7 = 0.00390625F;
        float var8 = 0.00390625F;
        Tessellator var9 = Tessellator.instance;
        var9.startDrawingQuads();
        var9.addVertexWithUV((double)(x + 0), (double)(y + height), (double)this.zLevel, (double)((float)(texX + 0) * var7), (double)((float)(texY + height) * var8));
        var9.addVertexWithUV((double)(x + width), (double)(y + height), (double)this.zLevel, (double)((float)(texX + width) * var7), (double)((float)(texY + height) * var8));
        var9.addVertexWithUV((double)(x + width), (double)(y + 0), (double)this.zLevel, (double)((float)(texX + width) * var7), (double)((float)(texY + 0) * var8));
        var9.addVertexWithUV((double)(x + 0), (double)(y + 0), (double)this.zLevel, (double)((float)(texX + 0) * var7), (double)((float)(texY + 0) * var8));
        var9.draw();
    }
    public void drawHorizontalLine(int y, int start, int end, int color){
        if (end < start)
        {
            int var5 = start;
            start = end;
            end = var5;
        }

        drawRect(start, y, end + 1, y + 1, color);
    }
    public void drawVerticalLine(int x, int start, int end, int color){
        if (end < start)
        {
            int var5 = start;
            start = end;
            end = var5;
        }

        drawRect(x, start + 1, x + 1, end, color);
    }
        public void drawGradientRect(int x, int y, int width, int height, int startColor, int endColor){
            float var7 = (float)(startColor >> 24 & 255) / 255.0F;
            float var8 = (float)(startColor >> 16 & 255) / 255.0F;
            float var9 = (float)(startColor >> 8 & 255) / 255.0F;
            float var10 = (float)(startColor & 255) / 255.0F;
            float var11 = (float)(endColor >> 24 & 255) / 255.0F;
            float var12 = (float)(endColor >> 16 & 255) / 255.0F;
            float var13 = (float)(endColor >> 8 & 255) / 255.0F;
            float var14 = (float)(endColor & 255) / 255.0F;
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glShadeModel(GL11.GL_SMOOTH);
            Tessellator var15 = Tessellator.instance;
            var15.startDrawingQuads();
            var15.setColorRGBA_F(var8, var9, var10, var7);
            var15.addVertex((double)width, (double)y, (double)this.zLevel);
            var15.addVertex((double)x, (double)y, (double)this.zLevel);
            var15.setColorRGBA_F(var12, var13, var14, var11);
            var15.addVertex((double)x, (double)height, (double)this.zLevel);
            var15.addVertex((double)width, (double)height, (double)this.zLevel);
            var15.draw();
            GL11.glShadeModel(GL11.GL_FLAT);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
    }
}
