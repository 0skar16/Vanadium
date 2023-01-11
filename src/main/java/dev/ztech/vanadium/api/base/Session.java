package dev.ztech.vanadium.api.base;

import com.google.common.base.Predicate;
import dev.ztech.vanadium.api.entity.Entity;
import dev.ztech.vanadium.api.entity.Player;
import dev.ztech.vanadium.api.rendering.text.TextRenderer;
import dev.ztech.vanadium.api.rendering.text.VanillaTextRenderer;
import dev.ztech.vanadium.api.screen.ScreenEmulator;
import dev.ztech.vanadium.api.screen.VScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;
import java.util.List;

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
        return Minecraft.getDebugFPS();
    }
    public boolean isScreen(VScreen screen){
        if (mc.currentScreen instanceof ScreenEmulator){
            return ((ScreenEmulator)mc.currentScreen).getEmulated() == screen;
        }else{
            return false;
        }
    }
    public Entity getPointedEntity(){
        return new Entity(mc.pointedEntity);
    }
    public Player getPlayer(){
        return Player.from(mc.thePlayer);
    }
    public List<Entity> getLoadedEntityList(){
        List<Entity> ents = new ArrayList<>();
        for (net.minecraft.entity.Entity es: mc.theWorld.getLoadedEntityList()) {
            if(es!=null)
                ents.add(Entity.from(es));
        }
        return ents;
    }
    public List<Player> getLoadedPlayerList(){
        List<Player> players = new ArrayList<>();
        for (EntityPlayer p: mc.theWorld.playerEntities){
            if(p!=null)
                players.add(Player.from(p));
        }
        return players;
    }
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
}
