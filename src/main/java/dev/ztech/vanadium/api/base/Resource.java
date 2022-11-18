package dev.ztech.vanadium.api.base;

import net.minecraft.client.resources.IResource;
import net.minecraft.util.ResourceLocation;

import java.awt.image.BufferedImage;

public class Resource {
    private ResourceLocation rl;
    public Resource(String ns, String path){
        rl = new ResourceLocation(ns, path);
    }
    public Resource(String path){
        rl = new ResourceLocation(path);
    }
    public String getResourcePath(){
        return rl.getResourcePath();
    }
    public String getResourceDomain(){
        return rl.getResourceDomain();
    }
    public String toString(){
        return rl.toString();
    }
}
