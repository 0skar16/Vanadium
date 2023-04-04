package dev.ztech.vanadium;

import dev.ztech.vanadium.api.base.Base;
import dev.ztech.vanadium.api.eventsystem.events.GTickEvent;
import dev.ztech.vanadium.impl.base.SessionImpl;
import dev.ztech.vanadium.api.eventsystem.EventManager;
import dev.ztech.vanadium.api.eventsystem.EventTarget;
import dev.ztech.vanadium.api.eventsystem.events.GameStartEvent;
import dev.ztech.vanadium.api.eventsystem.events.InitEvent;
import dev.ztech.vanadium.api.eventsystem.events.UnsafeTickEvent;
import dev.ztech.vanadium.api.rendering.custom.ITexture;
import dev.ztech.vanadium.api.rendering.gui.MainMenuIntegration;
import dev.ztech.vanadium.mod.ModLoader;
import dev.ztech.vanadium.ui.MainMenuVanadiumButton;
import net.minecraft.client.main.Main;

public class Vanadium {
    public static Vanadium INSTANCE = new Vanadium();
    public static void main(String[] args){
        Base.mainDir.mkdir();
        Base.modDir.mkdir();
        Base.configDir.mkdir();
        EventManager.register(INSTANCE);
        Main.main(args);
    }
    ITexture tex;
    @EventTarget
    public void onModInit(InitEvent e){
        MainMenuIntegration.addElement(new MainMenuVanadiumButton());
    }
    @EventTarget
    public void onGameStart(GameStartEvent e){
        SessionImpl.INSTANCE = new SessionImpl();
        new InitEvent(SessionImpl.getInstance()).call();
        ModLoader.loadModsToList(Base.modDir);
    }
    @EventTarget
    public void onTick(UnsafeTickEvent e){
        //SessionImpl.getInstance().getPlayer();
    }
}
