package dev.ztech.vanadium.api.rendering.custom;

public interface Renderer2D {
    ITexture getCurrentTexture();
    void bindTexture(ITexture tex);
    void drawRect(int x, int y, int width, int height, int color);
    void drawTexturedRect(int x, int y, int texX, int texY, int width, int height);
    void drawHorizontalLine(int y, int start, int end, int color);
    void drawGradientRect(int x, int y, int width, int height, int startColor, int endColor);

}
