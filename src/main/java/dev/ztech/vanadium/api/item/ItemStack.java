package dev.ztech.vanadium.api.item;

import dev.ztech.vanadium.api.entity.Player;
import dev.ztech.vanadium.api.rendering.RenderStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;

public class ItemStack {
    public ItemStack(net.minecraft.item.ItemStack base){
        this.base = base;
    }
    private net.minecraft.item.ItemStack base;
    public void render(int x, int y){
        RenderStack.push();
        RenderHelper.enableGUIStandardItemLighting();
        Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(this.base,x,y);
        RenderStack.pop();
    }
    public boolean isDamageable(){
        return this.base.getItem().isDamageable();
    }
    public int getDamage(){
        return this.base.getItemDamage();
    }
    public int getMaxDamage(){
        return this.base.getMaxDamage();
    }
    public static ItemStack from(net.minecraft.item.ItemStack base){
        if(base != null){
            return new ItemStack(base);
        }else{
            return null;
        }
    }
}
