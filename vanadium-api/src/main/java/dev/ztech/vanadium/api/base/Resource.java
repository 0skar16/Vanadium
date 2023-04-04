package dev.ztech.vanadium.api.base;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public interface Resource {
    String readString() throws IOException;
    byte[] readBytes() throws IOException;
    default BufferedImage readImage() throws IOException {
        URL res = this.getUrl();
        return ImageIO.read(res);
    }
    URL getUrl();
    String getDomain();
    String getPath();
}
