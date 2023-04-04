package dev.ztech.vanadium.impl.rendering.custom;

import dev.ztech.vanadium.api.base.Base;
import dev.ztech.vanadium.api.rendering.custom.ITexture;
import dev.ztech.vanadium.api.rendering.custom.Renderer2D;
import dev.ztech.vanadium.api.rendering.custom.TextureHandler;
import dev.ztech.vanadium.impl.base.SessionImpl;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class Renderer2DImpl implements Renderer2D {
    ITexture currentTexture;

    protected float zLevel = 250.0f;
    public static Renderer2DImpl INSTANCE = new Renderer2DImpl();

    public ITexture getCurrentTexture() {
        return currentTexture;
    }
    public void bindTexture(ITexture Texture){
        currentTexture = Texture;
    }

    public void drawRect(int x, int y, int width, int height, int color){
        int x1 = x;
        int x2 = x+width;
        int y1 = y+height;
        int y2 = y;
        float a = (float)(color >> 24 & 255) / 255.0F;
        float r = (float)(color >> 16 & 255) / 255.0F;
        float g = (float)(color >> 8 & 255) / 255.0F;
        float b = (float)(color & 255) / 255.0F;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(r, g, b, a);
        worldrenderer.begin(7, DefaultVertexFormats.POSITION);
        worldrenderer.pos((double)x1, (double)y1, 0.0D).endVertex();
        worldrenderer.pos((double)x2, (double)y1, 0.0D).endVertex();
        worldrenderer.pos((double)x2, (double)y2, 0.0D).endVertex();
        worldrenderer.pos((double)x1, (double)y2, 0.0D).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
    public void drawTexturedRect(int x, int y, int texX, int texY, int width, int height){
        if(currentTexture == null){
            Base.logger.logError("Tried drawing a Textured Rect without setting the Texture");
            return;
        }
        TextureHandler textureHandler = SessionImpl.getInstance().getRenderingBuilder().getTextureHandler();
        this.currentTexture.load(textureHandler);
        float dx = (float)width/(float)currentTexture.getTex(textureHandler).getWidth();
        float dy = (float)height/(float)currentTexture.getTex(textureHandler).getHeight();
        float mx = dx/8F;
        float my = dy/8F;
        float var7 = (0.00390625F*8F)/dx/**mx*/;
        float var8 = (0.00390625F*8F)/dy/**my*/;
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos((double)(x + 0), (double)(y + height), (double)this.zLevel).tex((double)((float)(texX + 0) * f), (double)((float)(texX + height) * f1)).endVertex();
        worldrenderer.pos((double)(x + width), (double)(y + height), (double)this.zLevel).tex((double)((float)(texX + width) * f), (double)((float)(texY + height) * f1)).endVertex();
        worldrenderer.pos((double)(x + width), (double)(y + 0), (double)this.zLevel).tex((double)((float)(texX + width) * f), (double)((float)(texY + 0) * f1)).endVertex();
        worldrenderer.pos((double)(x + 0), (double)(y + 0), (double)this.zLevel).tex((double)((float)(texX + 0) * f), (double)((float)(texY + 0) * f1)).endVertex();
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
            float a1 = (float)(startColor >> 24 & 255) / 255.0F;
            float r1 = (float)(startColor >> 16 & 255) / 255.0F;
            float g1 = (float)(startColor >> 8 & 255) / 255.0F;
            float b1 = (float)(startColor & 255) / 255.0F;
            float a2 = (float)(endColor >> 24 & 255) / 255.0F;
            float r2 = (float)(endColor >> 16 & 255) / 255.0F;
            float g2 = (float)(endColor >> 8 & 255) / 255.0F;
            float b2 = (float)(endColor & 255) / 255.0F;
            GlStateManager.disableTexture2D();
            GlStateManager.enableBlend();
            GlStateManager.disableAlpha();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.shadeModel(7425);
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldrenderer = tessellator.getWorldRenderer();
            worldrenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
            worldrenderer.pos((double)width, (double)height, (double)this.zLevel).color(r1, g1, b1, a1).endVertex();
            worldrenderer.pos((double)x, (double)height, (double)this.zLevel).color(r1, g1, b1, a1).endVertex();
            worldrenderer.pos((double)x, (double)y, (double)this.zLevel).color(r2, g2, b2, a2).endVertex();
            worldrenderer.pos((double)width, (double)y, (double)this.zLevel).color(r2, g2, b2, a2).endVertex();
            tessellator.draw();
            GlStateManager.shadeModel(7424);
            GlStateManager.disableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.enableTexture2D();
    }
}
