package dev.ztech.vanadium.api.sound;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.util.ResourceLocation;

public class SoundHandler {
    public static void PlaySound(ResourceLocation sound){
        Minecraft.getMinecraft().getSoundHandler().playSound((ISound) sound);
    }
}
