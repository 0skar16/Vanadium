package dev.ztech.vanadium.api.rendering.text;

import dev.ztech.vanadium.api.rendering.RenderStack;

import java.awt.*;

public interface TextRenderer {
    int getHeight();
    int getWidth(String string);
    void render(String text, int x, int y, int color, boolean shadow);
    default void render(String text, int x, int y, int color){
        render(text, x, y, color, false);
    }
    default void renderWithShadow(String text, int x, int y, int color){
        render(text, x, y, color, true);
    }
    default void renderCentered(String text, int x, int y, int color, boolean shadow){
        int offsetx = this.getWidth(text)/2;
        int offsety = this.getHeight()/2;
        this.render(text, x-offsetx, y-offsety, color);
    }
    default void renderCenteredWithShadow(String text, int x, int y, int color){
        this.renderCentered(text, x, y, color, true);
    }
    default void renderCentered(String text, int x, int y, int color){
        renderCentered(text, x, y, color, false);
    }
    default void renderChroma(String text, int x, int y, boolean shadow, boolean centered){
        int xTmp = x;
        for (char textChar : text.toCharArray())
        {
            int color = RenderStack.getChroma(xTmp, y);
            String tmp = String.valueOf(textChar);
            if(centered){
                renderCentered(tmp, xTmp, y, color, shadow);
            }else{
                render(tmp, xTmp, y, color, shadow);
            }
            xTmp += getWidth(tmp);
        }
    }
    default void renderChroma(String text, int x, int y, boolean shadow){
        renderChroma(text, x, y, shadow, false);
    }
    default void renderChroma(String text, int x, int y){
        renderChroma(text, x, y, false, false);
    }
}
