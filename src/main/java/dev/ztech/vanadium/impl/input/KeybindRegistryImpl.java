package dev.ztech.vanadium.impl.input;

import dev.ztech.vanadium.api.input.Keybind;
import dev.ztech.vanadium.api.input.KeybindRegistry;
import dev.ztech.vanadium.api.mod.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import org.apache.commons.lang3.ArrayUtils;

public class KeybindRegistryImpl implements KeybindRegistry {
    public Keybind register(int key, String keybindNane, Mod owner){
        GameSettings gs = Minecraft.getMinecraft().gameSettings;
        int id = gs.mc.length;
        Minecraft.getMinecraft().gameSettings.mc = (KeyBinding[])((KeyBinding[]) ArrayUtils.add(gs.mc, new KeyBinding(keybindNane, key, owner != null ? owner.data.name : "Vanadium")));
        return new KeybindImpl(id);
    }
}
