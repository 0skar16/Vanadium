package dev.ztech.vanadium.api.rendering;

public class Vec3 {
    private float x, y, z;
    public Vec3(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }
}
