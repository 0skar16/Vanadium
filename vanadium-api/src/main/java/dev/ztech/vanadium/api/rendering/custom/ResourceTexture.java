package dev.ztech.vanadium.api.rendering.custom;

import dev.ztech.vanadium.api.base.Resource;

import java.io.IOException;

public class ResourceTexture extends StaticTexture {
    public ResourceTexture(Resource res, boolean blur, boolean clamp) throws IOException {
        super(res.readImage(), blur, clamp);
    }
    public ResourceTexture(Resource res) throws IOException {
        super(res.readImage());
    }
}
