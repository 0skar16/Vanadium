package dev.ztech.vanadium.api.base;

public interface ResourceManager {
    Resource getResource(Class<?> loader, String domain, String path);
    default Resource getResource(Class<?> loader, String path) {
        return getResource(loader, "minecraft", path);
    }

}
