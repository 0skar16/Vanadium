package dev.ztech.vanadium;

import dev.ztech.vanadium.api.base.Base;
import dev.ztech.vanadium.api.events.GTickEvent;
import dev.ztech.vanadium.api.events.GameStartEvent;
import dev.ztech.vanadium.api.events.InitEvent;
import dev.ztech.vanadium.api.rendering.custom.ITexture;
import dev.ztech.vanadium.api.rendering.custom.Renderer2D;
import dev.ztech.vanadium.api.rendering.custom.Renderer3D;
import dev.ztech.vanadium.api.rendering.custom.ResourceTexture;
import dev.ztech.vanadium.api.rendering.gui.MainMenuIntegration;
import dev.ztech.vanadium.events.EventManager;
import dev.ztech.vanadium.events.EventTarget;
import dev.ztech.vanadium.mod.ModLoader;
import dev.ztech.vanadium.ui.MainMenuVanadiumButton;
import net.minecraft.client.main.Main;

import java.awt.*;
import java.util.Arrays;

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
        new InitEvent().call();
        ModLoader.loadModsToList(Base.modDir);
        try{
            tex = new ResourceTexture("image.png");
        }catch(Exception ex){
            Base.logger.logError("Couldn't load texture");
        }
    }

}
