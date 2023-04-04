package dev.ztech.vanadium.impl.rendering.gui;

import dev.ztech.vanadium.api.base.Session;
import dev.ztech.vanadium.api.rendering.gui.Button;
import dev.ztech.vanadium.impl.input.MouseHandlerImpl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class ButtonImpl implements Button  {
    protected GuiButton button;
    public ButtonImpl(int x, int y, int width, int height, String displayString){
        id++;
        this.button = new GuiButton(9999+id, x,y,width,height,displayString);
    }
    @Override
    public int getX(){
        return this.button.xPosition;
    }
    @Override
    public void setX(int x){
        this.button.xPosition = x;
    }
    @Override
    public int getY(){
        return this.button.yPosition;
    }
    @Override
    public void setY(int y){
        this.button.yPosition = y;
    }
    @Override
    public int getWidth(){
        return this.button.getButtonWidth();
    }
    @Override
    public int getHeight(){
        return this.button.getButtonWidth();
    }

    @Override
    public void setWidth(int w) {

    }

    @Override
    public void setHeight(int h) {

    }

    @Override
    public void draw(Session session){
        int x = MouseHandlerImpl.INSTANCE.x;
        int y = MouseHandlerImpl.INSTANCE.y;
        this.button.drawButton(Minecraft.getMinecraft(), x, y);
    }
    @Override
    public boolean mousePressed(int mouseX, int mouseY, int button){
        boolean h = this.button.mousePressed(Minecraft.getMinecraft(), mouseX, mouseY);
        if(h){
            this.button.playPressSound(Minecraft.getMinecraft().getSoundHandler());
            this.onClick();
        }
        return h;
    }

    @Override
    public void onClick(){

    }

    private static int id = 0;
}
