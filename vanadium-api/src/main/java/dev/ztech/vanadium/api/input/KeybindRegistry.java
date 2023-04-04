package dev.ztech.vanadium.api.input;

import dev.ztech.vanadium.api.mod.Mod;

public interface KeybindRegistry {
    Keybind register(int key, String keybindName, Mod owner);
    //void unregister(Keybind keybind);
}
