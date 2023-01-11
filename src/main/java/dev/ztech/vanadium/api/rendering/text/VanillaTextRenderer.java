package dev.ztech.vanadium.api.rendering.text;

import net.minecraft.client.Minecraft;

public class VanillaTextRenderer implements TextRenderer{

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
}
