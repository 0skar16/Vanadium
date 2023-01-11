package dev.ztech.vanadium.api.entity;

import dev.ztech.vanadium.api.base.Position;
import dev.ztech.vanadium.api.input.MouseHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;

public class Entity {
    private net.minecraft.entity.Entity base;
    public Position getPosition(){
        return new Position(this.base.posX, this.base.posY, this.base.posZ);
    }
    public Entity(net.minecraft.entity.Entity base){
        this.base = base;
    }
    public float getHealth(){
        return ((EntityLivingBase)base).getHealth();
    }
    public void renderOnScreen(int x, int y, int scale){
        GuiInventory.drawEntityOnScreen(x, y, scale, MouseHandler.INSTANCE.x, MouseHandler.INSTANCE.y, (EntityLivingBase) this.base);
    }
    public boolean isNull(){
        return base==null;
    }
    public float getMaxHealth(){
        return ((EntityLivingBase)base).getMaxHealth();
    }
    public Player toPlayer(){
        if(base instanceof EntityPlayer){
            return new Player((EntityPlayer) this.base);
        }
        return null;
    }
    public static Entity from(net.minecraft.entity.Entity base){
        if(base != null){
            return new Entity(base);
        }else{
            return null;
        }
    }
    public boolean isPlayer(){
        return base instanceof EntityPlayer;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Entity){
            return base.equals(((Entity) o).base);
        }
        return false;
    }
}
