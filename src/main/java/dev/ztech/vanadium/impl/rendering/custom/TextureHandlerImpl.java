package dev.ztech.vanadium.impl.rendering.custom;

import dev.ztech.vanadium.api.rendering.custom.ITexture;
import dev.ztech.vanadium.api.rendering.custom.TextureHandler;
import dev.ztech.vanadium.impl.base.SessionImpl;
import net.minecraft.client.renderer.texture.TextureUtil;

import java.awt.image.BufferedImage;

public class TextureHandlerImpl implements TextureHandler {
    public void LoadTexture(ITexture tex, boolean blur, boolean clamp){
        TextureHandler textureHandler = SessionImpl.getInstance().getRenderingBuilder().getTextureHandler();
        BufferedImage img = tex.getTex(textureHandler);
        TextureUtil.uploadTextureImageAllocate(tex.getGlTexID(textureHandler), img, blur, clamp);
        TextureUtil.bindTexture(tex.getGlTexID(textureHandler));
    }
    public void UpdateTexture(ITexture tex){
        TextureHandler textureHandler = SessionImpl.getInstance().getRenderingBuilder().getTextureHandler();
        TextureUtil.uploadTextureImage(tex.getGlTexID(textureHandler), tex.getTex(textureHandler));
    }
    public void unloadTexture(ITexture tex){
        TextureHandler textureHandler = SessionImpl.getInstance().getRenderingBuilder().getTextureHandler();
        TextureUtil.deleteTexture(tex.getGlTexID(textureHandler));
    }
    public int glGen(){
        return TextureUtil.glGenTextures();
    }
}
