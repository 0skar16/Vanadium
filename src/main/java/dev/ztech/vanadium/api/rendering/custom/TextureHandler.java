package dev.ztech.vanadium.api.rendering.custom;

import net.minecraft.client.renderer.texture.TextureUtil;

import java.awt.image.BufferedImage;

public class TextureHandler {
    public static void LoadTexture(ITexture tex, boolean blur, boolean clamp){
        BufferedImage img = tex.getTex();
        TextureUtil.uploadTextureImageAllocate(tex.getGlTexID(), img, blur, clamp);
        TextureUtil.bindTexture(tex.getGlTexID());
    }
    public static  void UpdateTexture(ITexture tex){
        TextureUtil.uploadTextureImage(tex.getGlTexID(), tex.getTex());
    }
    public static void unloadTexture(ITexture tex){
        TextureUtil.deleteTexture(tex.getGlTexID());
    }
    public static int glGen(){
        return TextureUtil.glGenTextures();
    }
}
