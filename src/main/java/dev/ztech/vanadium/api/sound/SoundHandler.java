package dev.ztech.vanadium.api.sound;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class SoundHandler {
    public static void PlaySound(ResourceLocation sound){
        Minecraft.getMinecraft().getSoundHandler().func_147680_a(sound);
    }
}
