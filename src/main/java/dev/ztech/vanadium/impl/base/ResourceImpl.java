package dev.ztech.vanadium.impl.base;

import dev.ztech.vanadium.api.base.Resource;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.compress.utils.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ResourceImpl implements Resource {
    URL url;
    String dom, path;
    public ResourceImpl(URL url, String dom, String path) {
        this.url = url;
        this.dom =dom;
        this.path = path;

    }
    @Override
    public String readString() throws IOException {
        InputStream is = null;
        try {
            is = url.openStream();
            byte[] bytes = IOUtils.toByteArray(is);
            return new String(bytes, StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            System.err.printf ("Failed while reading bytes from %s: %s", url.toExternalForm(), e.getMessage());
            e.printStackTrace ();
            // Perform any other exception handling that's appropriate.
        }
        finally {
            if (is != null) { is.close(); }
        }
        return null;
    }

    @Override
    public byte[] readBytes() throws IOException {
        InputStream is = null;
        try {
            is = url.openStream ();
            byte[] bytes = IOUtils.toByteArray(is);
            return bytes;
        }
        catch (IOException e) {
            System.err.printf ("Failed while reading bytes from %s: %s", url.toExternalForm(), e.getMessage());
            e.printStackTrace ();
            // Perform any other exception handling that's appropriate.
        }
        finally {
            if (is != null) { is.close(); }
        }
        return new byte[0];

    }

    @Override
    public URL getUrl() {
        return url;
    }

    @Override
    public String getDomain() {
        return dom;
    }

    @Override
    public String getPath() {
        return path;
    }
}
