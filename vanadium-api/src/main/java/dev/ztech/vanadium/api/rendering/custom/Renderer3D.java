package dev.ztech.vanadium.api.rendering.custom;

public interface Renderer3D {
    ITexture getCurrentTexture();
    void bindTexture(ITexture tex);
    void drawBox(BoundingBox aa, int color);
    void drawOutlinedBox(BoundingBox aa, int color);
}
