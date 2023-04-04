package dev.ztech.vanadium.api.rendering.custom;

public interface TextureHandler {
    void LoadTexture(ITexture tex, boolean blur, boolean clamp);
    void UpdateTexture(ITexture tex);
    void unloadTexture(ITexture tex);
    int glGen();
}
