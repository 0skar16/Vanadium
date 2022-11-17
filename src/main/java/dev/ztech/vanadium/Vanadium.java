package dev.ztech.vanadium;

import dev.ztech.vanadium.api.base.Base;
import dev.ztech.vanadium.api.events.GameStartEvent;
import dev.ztech.vanadium.api.events.InitEvent;
import dev.ztech.vanadium.api.rendering.gui.MainMenuIntegration;
import dev.ztech.vanadium.events.EventManager;
import dev.ztech.vanadium.events.EventTarget;
import dev.ztech.vanadium.mod.ModLoader;
import dev.ztech.vanadium.ui.MainMenuVanadiumButton;
import net.minecraft.client.main.Main;

import java.util.Arrays;

public class Vanadium {
    public static Vanadium INSTANCE = new Vanadium();
    public static void main(String[] args)
    {
        Base.mainDir.mkdir();
        Base.modDir.mkdir();
        Base.configDir.mkdir();
        EventManager.register(INSTANCE);
        Main.main(concat(new String[] {"--version", "vanadium", "--accessToken", "0", "--assetsDir", "assets", "--assetIndex", "1.7.10", "--userProperties", "{}"}, args));
    }
    public static <T> T[] concat(T[] first, T[] second)
    {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
    @EventTarget
    public void onModInit(InitEvent e){
        MainMenuIntegration.addElement(new MainMenuVanadiumButton());
    }
    @EventTarget
    public void onGameStart(GameStartEvent e){
        new InitEvent().call();
        ModLoader.loadModsToList(Base.modDir);
    }

}
