package dev.ztech.vanadium.api.input;

import dev.ztech.vanadium.mod.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class Keybind {
    private int mc_id;
    public Keybind(int mc_id){
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
