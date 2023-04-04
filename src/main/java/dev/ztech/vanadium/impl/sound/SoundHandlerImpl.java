package dev.ztech.vanadium.impl.sound;

import dev.ztech.vanadium.api.base.Resource;
import dev.ztech.vanadium.api.sound.SoundHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.util.ResourceLocation;

public class SoundHandlerImpl implements SoundHandler {
    @Override
    public void playSound(Resource sound){
        Minecraft.getMinecraft().getSoundHandler().playSound((ISound) new ResourceLocation(sound.getDomain(), sound.getPath()));
    }
}
