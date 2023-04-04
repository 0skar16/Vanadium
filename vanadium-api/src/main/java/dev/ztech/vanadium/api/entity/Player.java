package dev.ztech.vanadium.api.entity;

import dev.ztech.vanadium.api.item.ItemStack;

import java.util.Collection;

public interface Player extends Entity {
    ItemStack getInventory(int slot);
    ItemStack getArmor(int slot);
    ItemStack getHeld();
    String getName();
    Collection<ItemStack> getInventory();
    boolean isSprinting();
    void setSprinting(boolean sprinting);
    float getMoveForward();
    boolean isUsingItem();
    boolean isSneaking();
    void setSneaking(boolean sneaking);
}
