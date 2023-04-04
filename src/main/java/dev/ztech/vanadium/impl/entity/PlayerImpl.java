package dev.ztech.vanadium.impl.entity;

import dev.ztech.vanadium.api.entity.Entity;
import dev.ztech.vanadium.api.entity.Player;
import dev.ztech.vanadium.api.item.ItemStack;
import dev.ztech.vanadium.impl.item.ItemStackImpl;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import java.util.Collection;

public class PlayerImpl extends EntityImpl implements Player {
    private EntityPlayer pbase;
    public PlayerImpl(EntityPlayer base) {
        super(base);
        pbase = base;
    }
    @Override
    public ItemStack getInventory(int slot){
        net.minecraft.item.ItemStack item  =pbase.inventory.getStackInSlot(slot);
        return ItemStackImpl.from(item);
    }
    @Override
    public ItemStack getArmor(int slot){
        net.minecraft.item.ItemStack item = pbase.inventory.armorItemInSlot(slot);
        return ItemStackImpl.from(item);
    }
    @Override
    public ItemStack getHeld(){
        net.minecraft.item.ItemStack item = pbase.inventory.getCurrentItem();
        return ItemStackImpl.from(item);
    }
    public static PlayerImpl from(EntityPlayer base){
        if(base != null){
            return new PlayerImpl(base);
        }else{
            return null;
        }
    }
    @Override
    public String getName(){
        return pbase.getName();
    }

    @Override
    public Collection<ItemStack> getInventory() {
        return null;
    }

    @Override
    public boolean isSprinting() {
        return Minecraft.getMinecraft().thePlayer.isSprinting();
    }

    @Override
    public void setSprinting(boolean sprinting) {
        Minecraft.getMinecraft().thePlayer.setSprinting(sprinting);
    }

    @Override
    public float getMoveForward() {
        return Minecraft.getMinecraft().thePlayer.moveForward;
    }

    @Override
    public boolean isUsingItem() {
        return Minecraft.getMinecraft().thePlayer.isUsingItem();
    }

    @Override
    public boolean isSneaking() {
        return Minecraft.getMinecraft().thePlayer.isSneaking();
    }

    @Override
    public void setSneaking(boolean sneaking) {
        Minecraft.getMinecraft().thePlayer.setSneaking(sneaking);
    }

    @Override
    public boolean equals(Entity e) {
        return e.toPlayer() == this;
    }
}
