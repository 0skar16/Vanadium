package dev.ztech.vanadium.api.input;

import dev.ztech.vanadium.api.base.Base;
import dev.ztech.vanadium.api.events.MouseMoveEvent;
import dev.ztech.vanadium.api.events.UnsafeTickEvent;
import dev.ztech.vanadium.events.EventManager;
import dev.ztech.vanadium.events.EventTarget;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Mouse;

public class MouseHandler {
    public static MouseHandler INSTANCE = new MouseHandler();
    public int x;
    public int y;
    public MouseHandler(){
        EventManager.register(this);
    }
    @EventTarget
    public void onTick(UnsafeTickEvent e){
        int ox=x;
        int oy=y;
        x = Mouse.getX();
        y = Mouse.getY();
        Minecraft mc = Minecraft.getMinecraft();
        ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
        y = mc.displayHeight-y;
        x = (int)(((double)x/(double)mc.displayWidth)*(double)sr.getScaledWidth());
        y = (int)(((double)y/(double)mc.displayHeight)*(double)sr.getScaledHeight());

        if(x != ox || y != oy){
            new MouseMoveEvent(x,y).call();
        }
    }
}
