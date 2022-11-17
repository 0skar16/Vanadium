package dev.ztech.vanadium.api.rendering.text;

import net.minecraft.client.Minecraft;

public class VanillaTextRenderer implements TextRenderer{

    @Override
    public int getHeight() {
        return Minecraft.getMinecraft().fontRenderer.FONT_HEIGHT;
    }

    @Override
    public int getWidth(String string) {
        return Minecraft.getMinecraft().fontRenderer.getStringWidth(string);
    }

    @Override
    public void render(String text, int x, int y, int color) {
        Minecraft.getMinecraft().fontRenderer.drawString(text, x, y, color);
    }
}
