package dev.ztech.vanadium.impl.item;

import dev.ztech.vanadium.api.item.ItemStack;
import dev.ztech.vanadium.api.rendering.RenderStack;
import dev.ztech.vanadium.impl.base.SessionImpl;
import dev.ztech.vanadium.impl.rendering.RenderStackImpl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;

public class ItemStackImpl implements ItemStack {
    public ItemStackImpl(net.minecraft.item.ItemStack base){
        this.base = base;
    }
    private net.minecraft.item.ItemStack base;
    @Override
    public void render(int x, int y){
        RenderStack stack = SessionImpl.getInstance().getRenderingBuilder().getStack();
        stack.push();
        RenderHelper.enableGUIStandardItemLighting();
        Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(this.base,x,y);
        stack.pop();
    }
    @Override
    public boolean isDamageable(){
        return this.base.getItem().isDamageable();
    }
    @Override
    public int getDurability(){
        return this.base.getItemDamage();
    }
    @Override
    public int getMaxDurability(){
        return this.base.getMaxDamage();
    }
    public static ItemStackImpl from(net.minecraft.item.ItemStack base){
        if(base != null){
            return new ItemStackImpl(base);
        }else{
            return null;
        }
    }
}
