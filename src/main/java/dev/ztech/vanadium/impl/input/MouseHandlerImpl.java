package dev.ztech.vanadium.impl.input;

import dev.ztech.vanadium.api.eventsystem.EventManager;
import dev.ztech.vanadium.api.eventsystem.EventTarget;
import dev.ztech.vanadium.api.eventsystem.events.MouseClickEvent;
import dev.ztech.vanadium.api.eventsystem.events.MouseMoveEvent;
import dev.ztech.vanadium.api.eventsystem.events.UnsafeTickEvent;
import dev.ztech.vanadium.api.input.MouseHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Mouse;

import java.util.HashMap;
import java.util.Map;

public class MouseHandlerImpl implements MouseHandler {
    public static MouseHandlerImpl INSTANCE = new MouseHandlerImpl();
    public int x;
    public int y;
    public MouseHandlerImpl(){
        EventManager.register(this);
    }
    @EventTarget
    public void onTick(UnsafeTickEvent e){
        int ox=x;
        int oy=y;
        x = Mouse.getX();
        y = Mouse.getY();
        Minecraft mc = Minecraft.getMinecraft();
        ScaledResolution sr = new ScaledResolution(mc);
        y = mc.displayHeight-y;
        x = (int)(((double)x/(double)mc.displayWidth)*(double)sr.getScaledWidth());
        y = (int)(((double)y/(double)mc.displayHeight)*(double)sr.getScaledHeight());

        if(x != ox || y != oy){
            new MouseMoveEvent(x,y).call();
        }
        for (int i = 0; i < 3; i++) {
            boolean key = Mouse.isButtonDown(i);
            if((key && !keymap.containsKey(i)) || (keymap.containsKey(i) && keymap.get(i) != key)){
                keymap.put(i, key);
                new MouseClickEvent(i, x, y, key).call();
            }
        }
    }
    public boolean isButtonDown(int button){
        return Mouse.isButtonDown(button);
    }
    Map<Integer, Boolean> keymap = new HashMap<>();
}
