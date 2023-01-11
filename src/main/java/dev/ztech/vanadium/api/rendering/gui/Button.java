package dev.ztech.vanadium.api.rendering.gui;

import dev.ztech.vanadium.api.base.Session;
import dev.ztech.vanadium.api.input.MouseHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class Button implements ApiGui{
    protected GuiButton button;
    public Button(int x, int y, int width, int height, String displayString){
        id++;
        this.button = new GuiButton(9999+id, x,y,width,height,displayString);
    }
    public int getX(){
        return this.button.xPosition;
    }
    public void setX(int x){
        this.button.xPosition = x;
    }
    public int getY(){
        return this.button.yPosition;
    }
    public void setY(int y){
        this.button.yPosition = y;
    }
    public int getWidth(){
        return this.button.getButtonWidth();
    }
    public int getHeight(){
        return this.button.getButtonWidth();
    }
    @Override
    public void draw(Session session){
        int x = MouseHandler.INSTANCE.x;
        int y = MouseHandler.INSTANCE.y;
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


    public void onClick(){

    }

    private static int id = 0;
}
