package dev.ztech.vanadium.impl.rendering.text;

import dev.ztech.vanadium.api.base.Session;
import dev.ztech.vanadium.api.rendering.RenderStack;
import dev.ztech.vanadium.api.rendering.text.TextRenderer;
import dev.ztech.vanadium.impl.base.SessionImpl;
import net.minecraft.client.Minecraft;

public class VanillaTextRenderer implements TextRenderer {

    @Override
    public int getHeight() {
        return Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT;
    }

    @Override
    public int getWidth(String string) {
        return Minecraft.getMinecraft().fontRendererObj.getStringWidth(string);
    }

    @Override
    public void render(String text, int x, int y, int color, boolean shadow) {
        Minecraft.getMinecraft().fontRendererObj.drawString(text, x, y, color, shadow);
    }

    @Override
    public void renderWithShadow(String text, int x, int y, int color) {
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(text,x,y,color);
    }

    @Override
    public void renderChroma(String text, int x, int y, boolean shadow, boolean centered) {
        int xTmp = x;
        RenderStack stack = SessionImpl.getInstance().getRenderingBuilder().getStack();
        for (char textChar : text.toCharArray())
        {
            int color = stack.getChroma(xTmp, y);
            String tmp = String.valueOf(textChar);
            if(centered){
                renderCentered(tmp, xTmp, y, color, shadow);
            }else{
                render(tmp, xTmp, y, color, shadow);
            }
            xTmp += getWidth(tmp);
        }
    }
}
