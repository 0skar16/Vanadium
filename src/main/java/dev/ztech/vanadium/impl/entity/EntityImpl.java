package dev.ztech.vanadium.impl.entity;

import dev.ztech.vanadium.api.base.Position;
import dev.ztech.vanadium.api.entity.Entity;
import dev.ztech.vanadium.api.entity.Player;
import dev.ztech.vanadium.impl.input.MouseHandlerImpl;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class EntityImpl implements Entity {
    private net.minecraft.entity.Entity base;
    @Override
    public Position getPosition(){
        return new Position(this.base.posX, this.base.posY, this.base.posZ);
    }
    public EntityImpl(net.minecraft.entity.Entity base){
        this.base = base;
    }
    @Override
    public float getHealth(){
        return ((EntityLivingBase)base).getHealth();
    }
    @Override
    public void renderOnScreen(int x, int y, int scale){
        GuiInventory.drawEntityOnScreen(x, y, scale, MouseHandlerImpl.INSTANCE.x, MouseHandlerImpl.INSTANCE.y, (EntityLivingBase) this.base);
    }
    @Override
    public boolean isNull(){
        return base==null;
    }
    @Override
    public float getMaxHealth(){
        return ((EntityLivingBase)base).getMaxHealth();
    }
    @Override
    public Player toPlayer(){
        if(base instanceof EntityPlayer){
            return new PlayerImpl((EntityPlayer) this.base);
        }
        return null;
    }
    public static EntityImpl from(net.minecraft.entity.Entity base){
        if(base != null){
            return new EntityImpl(base);
        }else{
            return null;
        }
    }
    @Override
    public boolean isPlayer(){
        return base instanceof EntityPlayer;
    }

    @Override
    public boolean equals(Entity e) {
        return equals((Object)e);
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Entity){
            return base.equals(((EntityImpl) o).base);
        }
        return false;
    }
}
