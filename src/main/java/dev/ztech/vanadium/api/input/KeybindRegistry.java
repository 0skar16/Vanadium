package dev.ztech.vanadium.api.input;

import dev.ztech.vanadium.mod.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import org.apache.commons.lang3.ArrayUtils;

public class KeybindRegistry {
    public static Keybind register(int key, String keybindNane, Mod owner){
        GameSettings gs = Minecraft.getMinecraft().gameSettings;
        int id = gs.mc.length;
        Minecraft.getMinecraft().gameSettings.mc = (KeyBinding[])((KeyBinding[]) ArrayUtils.add(gs.mc, new KeyBinding(keybindNane, key, owner != null ? owner.data.name : "Vanadium")));
        return new Keybind(id);
    }
}
