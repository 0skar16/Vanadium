package dev.ztech.vanadium.impl.base;

import com.google.common.base.Predicate;
import dev.ztech.vanadium.api.base.Session;
import dev.ztech.vanadium.api.entity.Entity;
import dev.ztech.vanadium.api.entity.Player;
import dev.ztech.vanadium.api.input.KeybindRegistry;
import dev.ztech.vanadium.api.input.KeyboardHandler;
import dev.ztech.vanadium.api.input.MouseHandler;
import dev.ztech.vanadium.api.rendering.RenderingBuilder;
import dev.ztech.vanadium.api.screen.Screen;
import dev.ztech.vanadium.api.sound.SoundHandler;
import dev.ztech.vanadium.impl.entity.EntityImpl;
import dev.ztech.vanadium.impl.entity.PlayerImpl;
import dev.ztech.vanadium.api.rendering.text.TextRenderer;
import dev.ztech.vanadium.impl.input.KeybindRegistryImpl;
import dev.ztech.vanadium.impl.input.KeyboardHandlerImpl;
import dev.ztech.vanadium.impl.input.MouseHandlerImpl;
import dev.ztech.vanadium.impl.rendering.RenderingBuilderImpl;
import dev.ztech.vanadium.impl.rendering.text.VanillaTextRenderer;
import dev.ztech.vanadium.impl.screen.ScreenEmulatorImpl;
import dev.ztech.vanadium.impl.sound.SoundHandlerImpl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;
import java.util.List;

public class SessionImpl implements Session {
    public SessionImpl(){
        mc = Minecraft.getMinecraft();
    }
    public static SessionImpl INSTANCE;
    public static Session getInstance() {
        return INSTANCE;
    }
    private Minecraft mc;
    @Override
    public int displayWidth(){
        return mc.displayWidth;
    }
    @Override
    public int displayHeight(){
        return mc.displayHeight;
    }
    @Override
    public void setScreen(Screen screen){
        GuiScreen current = Minecraft.getMinecraft().currentScreen;
        mc.displayGuiScreen(new ScreenEmulatorImpl(screen, current));
    }
    @Override
    public int getFPS(){
        return Minecraft.getDebugFPS();
    }
    @Override
    public boolean isScreen(Screen screen){
        if (mc.currentScreen instanceof ScreenEmulatorImpl){
            return ((ScreenEmulatorImpl)mc.currentScreen).getEmulated() == screen;
        }else{
            return false;
        }
    }

    @Override
    public Entity getPointedEntity(){
        return new EntityImpl(mc.pointedEntity);
    }
    @Override
    public Player getPlayer(){
        return PlayerImpl.from(mc.thePlayer);
    }
    @Override
    public List<Entity> getLoadedEntityList(){
        List<Entity> ents = new ArrayList<>();
        for (net.minecraft.entity.Entity es: mc.theWorld.getLoadedEntityList()) {
            if(es!=null)
                ents.add(EntityImpl.from(es));
        }
        return ents;
    }




    @Override
    public List<Player> getLoadedPlayerList(){
        List<Player> players = new ArrayList<>();
        for (EntityPlayer p: mc.theWorld.playerEntities){
            if(p!=null)
                players.add(PlayerImpl.from(p));
        }
        return players;
    }
    @Override
    public <E extends Entity> List<E> getEntities(Class <? extends E> entityType, Predicate<? super E> filter){
        List<E> ents = new ArrayList<>();
        for (Entity entity : this.getLoadedEntityList())
        {
            if (entityType.isAssignableFrom(entity.getClass()) && filter.apply((E)entity))
            {
                ents.add((E)entity);
            }
        }

        return ents;
    }
    @Override
    public <P extends Player> List<P> getPlayers(Class <? extends P> playerType, Predicate<? super P> filter){
        List<P> pls = new ArrayList<>();
        for (Player player : this.getLoadedPlayerList())
        {
            if (playerType.isAssignableFrom(player.getClass()) && filter.apply((P)player))
            {
                pls.add((P)player);
            }
        }

        return pls;
    }
    static RenderingBuilder renderingBuilder = new RenderingBuilderImpl();
    static KeybindRegistry keybindRegistry = new KeybindRegistryImpl();
    static SoundHandler soundHandler = new SoundHandlerImpl();
    static KeyboardHandler keyboardHandler = new KeyboardHandlerImpl();
    static MouseHandler mouseHandler = new MouseHandlerImpl();
    @Override
    public RenderingBuilder getRenderingBuilder() {
        return renderingBuilder;
    }
    @Override
    public KeybindRegistry getKeybindRegistry() {
        return keybindRegistry;
    }

    @Override
    public SoundHandler getSoundHandler() {
        return soundHandler;
    }

    @Override
    public KeyboardHandler getKeyboardHandler() {
        return keyboardHandler;
    }

    @Override
    public MouseHandler getMouseHandler() {
        return mouseHandler;
    }
}
