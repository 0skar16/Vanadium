package dev.ztech.vanadium.api.rendering.custom;

import java.awt.image.BufferedImage;

public class DynamicTexture implements ITexture{
    BufferedImage img;
    public DynamicTexture(BufferedImage img){
        this.img =img;
    }
    @Override
    public int getGlTexID() {
        return 0;
    }

    @Override
    public BufferedImage getTex() {
        return null;
    }
    public void changeTexture(BufferedImage img){
        this.img = img;
    }
}
