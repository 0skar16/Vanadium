package dev.ztech.vanadium.api.base;

import dev.ztech.vanadium.api.rendering.text.TextRenderer;
import dev.ztech.vanadium.api.rendering.text.VanillaTextRenderer;
import dev.ztech.vanadium.api.screen.ScreenEmulator;
import dev.ztech.vanadium.api.screen.VScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

public class Session {
    private Session(){
        mc = Minecraft.getMinecraft();
    }
    public static Session INSTANCE = new Session();
    public static TextRenderer defaultTextRenderer = new VanillaTextRenderer();
    private final Minecraft mc;
    public int displayWidth(){
        return mc.displayWidth;
    }
    public int displayHeight(){
        return mc.displayHeight;
    }
    public void setScreen(VScreen screen){
        GuiScreen current = mc.currentScreen;
        mc.displayGuiScreen(new ScreenEmulator(screen, current));
    }
    public int getFPS(){
        return Minecraft.debugFPS;
    }
}
