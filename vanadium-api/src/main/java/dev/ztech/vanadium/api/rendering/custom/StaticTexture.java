package dev.ztech.vanadium.api.rendering.custom;

import dev.ztech.vanadium.api.base.Session;

import java.awt.image.BufferedImage;

public class StaticTexture implements ITexture{
    private BufferedImage img;
    private int glID = -1;
    boolean blur, clamp;
    public StaticTexture(BufferedImage img, boolean blur, boolean clamp){
        this.img = img;
        this.blur = blur;
        this.clamp= clamp;
    }
    public StaticTexture(BufferedImage img){
        this.img = img;
        this.blur = false;
        this.clamp = false;
    }
    @Override
    public int getGlTexID(TextureHandler textureHandler) {
        if (this.glID == -1)
        {
            this.glID = textureHandler.glGen();
        }
        return glID;
    }

    @Override
    public BufferedImage getTex(TextureHandler textureHandler) {
        return img;
    }
    @Override
    public void load(TextureHandler textureHandler){
        textureHandler.LoadTexture(this, this.blur, this.clamp);
    }
}
