package dev.ztech.vanadium.api.rendering.custom;

import java.awt.image.BufferedImage;

public interface ITexture {
    boolean blur = false;
    boolean clamp = false;
    default void load(){
        TextureHandler.LoadTexture(this, this.blur, this.clamp);
    }
    default void update(){
        TextureHandler.UpdateTexture(this);
    }
    default void unload(){
        TextureHandler.unloadTexture(this);
    }
    int getGlTexID();
    BufferedImage getTex();
}
