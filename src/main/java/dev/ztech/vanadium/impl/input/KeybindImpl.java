package dev.ztech.vanadium.impl.input;

import dev.ztech.vanadium.api.input.Keybind;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class KeybindImpl implements Keybind {
    private int mc_id;
    public KeybindImpl(int mc_id){
        this.mc_id = mc_id;
    }
    public boolean get(){
        KeyBinding kb = Minecraft.getMinecraft().gameSettings.mc[mc_id];
        return kb.isKeyDown();
    }
    public int getKey(){
        KeyBinding kb = Minecraft.getMinecraft().gameSettings.mc[mc_id];
        return kb.getKeyCode();
    }

}
