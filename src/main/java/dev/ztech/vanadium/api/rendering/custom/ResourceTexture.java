package dev.ztech.vanadium.api.rendering.custom;

import dev.ztech.vanadium.api.base.Base;
import dev.ztech.vanadium.api.base.Resource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ResourceTexture extends StaticTexture {

    public ResourceTexture(String path, boolean blur, boolean clamp) throws IOException{
        super(loadImageFromResourcePath(path), blur, clamp);
    }
    public ResourceTexture(String path) throws IOException {
        super(loadImageFromResourcePath(path));

    }
    protected static BufferedImage loadImageFromResourcePath(String path) throws IOException {

        URL res = ResourceTexture.class.getClassLoader().getResource(path);
        return ImageIO.read(res);
    }
}
