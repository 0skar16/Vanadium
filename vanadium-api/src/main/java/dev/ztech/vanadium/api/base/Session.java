package dev.ztech.vanadium.api.base;

import com.google.common.base.Predicate;
import dev.ztech.vanadium.api.entity.Entity;
import dev.ztech.vanadium.api.entity.Player;
import dev.ztech.vanadium.api.input.KeybindRegistry;
import dev.ztech.vanadium.api.input.KeyboardHandler;
import dev.ztech.vanadium.api.input.MouseHandler;
import dev.ztech.vanadium.api.rendering.RenderingBuilder;
import dev.ztech.vanadium.api.screen.Screen;
import dev.ztech.vanadium.api.sound.SoundHandler;

import java.util.List;

public interface Session {
    int displayWidth();
    int displayHeight();
    void setScreen(Screen screen);
    int getFPS();
    boolean isScreen(Screen screen);


    Entity getPointedEntity();
    Player getPlayer();
    List<Entity> getLoadedEntityList();

    List<Player> getLoadedPlayerList();

    <E extends Entity> List<E> getEntities(Class <? extends E> entityType, Predicate<? super E> filter);
    <P extends Player> List<P> getPlayers(Class <? extends P> entityType, Predicate<? super P> filter);
    RenderingBuilder getRenderingBuilder();
    KeybindRegistry getKeybindRegistry();
    SoundHandler getSoundHandler();
    KeyboardHandler getKeyboardHandler();
    MouseHandler getMouseHandler();

}
