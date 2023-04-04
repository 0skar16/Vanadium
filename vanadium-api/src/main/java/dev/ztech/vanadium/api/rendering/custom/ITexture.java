package dev.ztech.vanadium.api.rendering.custom;

import dev.ztech.vanadium.api.base.Session;

import java.awt.image.BufferedImage;

public interface ITexture {
    boolean blur = false;
    boolean clamp = false;
    default void load(TextureHandler textureHandler){
        textureHandler.LoadTexture(this, this.blur, this.clamp);
    }
    default void update(TextureHandler textureHandler){
        textureHandler.UpdateTexture(this);
    }
    default void unload(TextureHandler textureHandler){
        textureHandler.unloadTexture(this);
    }
    int getGlTexID(TextureHandler textureHandler);
    BufferedImage getTex(TextureHandler textureHandler);
}
