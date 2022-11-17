package dev.ztech.vanadium.api.rendering;

import org.lwjgl.opengl.GL11;

public class RenderStack {
    public static void push(){
        psx = csx;
        psy = csy;
        psz = csz;
        GL11.glPushMatrix();
    }
    public static void pop(){
        csx = psx;
        csy = psy;
        csz = psz;
        GL11.glPopMatrix();
    }
    private static  float csx = 1.0f;
    private static  float csy = 1.0f;
    private static  float csz = 1.0f;
    private static float psx = 1.0f;
    private static  float psy = 1.0f;
    private static  float psz = 1.0f;
    public static void translate(float x, float y, float z){
        GL11.glTranslatef(x, y, z);
    }
    public static void scale(float x, float y, float z){
        csx = x;
        csy = y;
        csz = z;
        GL11.glScalef(x, y, z);
    }
    public static float getScaleX(){
        return csx;
    }
    public static float getScaleY(){
        return csy;
    }
    public static float getScaleZ(){
        return csz;
    }

}
