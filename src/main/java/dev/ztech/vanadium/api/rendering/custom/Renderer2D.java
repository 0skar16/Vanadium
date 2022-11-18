package dev.ztech.vanadium.api.rendering.custom;

import dev.ztech.vanadium.api.base.Base;
import dev.ztech.vanadium.api.base.Resource;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class Renderer2D {
    ITexture currentTexture;

    protected float zLevel = 250.0f;
    public static Renderer2D INSTANCE = new Renderer2D();

    public ITexture getCurrentTexture() {
        return currentTexture;
    }
    public void bindTexture(ITexture Texture){
        currentTexture = Texture;
    }

    public void drawRect(int x, int y, int width, int height, int color){
        width = x+width;
        height = y+height;
        int var5;

        if (x < width)
        {
            var5 = x;
            x = width;
            width = var5;
        }

        if (y < height)
        {
            var5 = y;
            y = height;
            height = var5;
        }

        float a = (float)(color >> 24 & 255) / 255.0F;
        float r = (float)(color >> 16 & 255) / 255.0F;
        float g = (float)(color >> 8 & 255) / 255.0F;
        float b = (float)(color & 255) / 255.0F;
        Tessellator var9 = Tessellator.instance;
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glColor4f(r, g, b, a);
        var9.startDrawingQuads();
        var9.addVertex((double)x, (double)height, 0.0D);
        var9.addVertex((double)width, (double)height, 0.0D);
        var9.addVertex((double)width, (double)y, 0.0D);
        var9.addVertex((double)x, (double)y, 0.0D);
        var9.draw();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
    }
    public void drawTexturedRect(int x, int y, int texX, int texY, int width, int height){
        if(currentTexture == null){
            Base.logger.logError("Tried drawing a Textured Rect without setting the Texture");
            return;
        }
        this.currentTexture.load();
        float dx = (float)width/(float)currentTexture.getTex().getWidth();
        float dy = (float)height/(float)currentTexture.getTex().getHeight();
        float mx = dx/8F;
        float my = dy/8F;
        float var7 = (0.00390625F*8F)/dx/**mx*/;
        float var8 = (0.00390625F*8F)/dy/**my*/;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + height), (double)this.zLevel, (double)((float)(texX + 0) * var7), (double)((float)(texY + height) * var8));
        tessellator.addVertexWithUV((double)(x + width), (double)(y + height), (double)this.zLevel, (double)((float)(texX + width) * var7), (double)((float)(texY + height) * var8));
        tessellator.addVertexWithUV((double)(x + width), (double)(y + 0), (double)this.zLevel, (double)((float)(texX + width) * var7), (double)((float)(texY + 0) * var8));
        tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0), (double)this.zLevel, (double)((float)(texX + 0) * var7), (double)((float)(texY + 0) * var8));
        tessellator.draw();
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
            width = x+width;
            height = y+height;
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
    public void drawHollowRect(int x, int y, int width, int height, int color){
        this.drawHorizontalLine(y, x, x+width, color);
        this.drawHorizontalLine(y-height, x, x+width, color);
        this.drawVerticalLine(x, y, y-height, color);
        this.drawVerticalLine(x+width, y, y-height, color);
    }
}
