package dev.ztech.vanadium.api.rendering;

public interface RenderStack {
    void push();
    void pop();
    Vec3 getScale();
    Vec3 getPreviousScale();
    void scale(Vec3 scale);
    void translate(Vec3 transform);
    void color(float r, float g, float b, float a);
    int getChroma(int x, int y);
}
