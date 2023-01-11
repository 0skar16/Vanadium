package dev.ztech.vanadium.api.entity;

import dev.ztech.vanadium.api.base.Base;
import dev.ztech.vanadium.api.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;

public class Player extends Entity{
    private EntityPlayer pbase;
    public Player(EntityPlayer base) {
        super(base);
        pbase = base;
    }
    public ItemStack getInventory(int slot){
        net.minecraft.item.ItemStack item  =pbase.inventory.getStackInSlot(slot);
        return ItemStack.from(item);
    }
    public ItemStack getArmor(int slot){
        net.minecraft.item.ItemStack item = pbase.inventory.armorItemInSlot(slot);
        return ItemStack.from(item);
    }
    public ItemStack getHeld(){
        net.minecraft.item.ItemStack item = pbase.inventory.getCurrentItem();
        return ItemStack.from(item);
    }
    public static Player from(EntityPlayer base){
        if(base != null){
            return new Player(base);
        }else{
            return null;
        }
    }
    public String getName(){
        return pbase.getName();
    }
}
