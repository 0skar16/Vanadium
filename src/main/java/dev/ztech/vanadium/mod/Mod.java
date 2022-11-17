package dev.ztech.vanadium.mod;

public abstract class Mod {
    public ModData data;
    public Mod(ModData mod_data){
        this.data = mod_data;
    }
}
