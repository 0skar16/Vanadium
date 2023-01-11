package dev.ztech.vanadium.api.screen;

import dev.ztech.vanadium.api.base.Session;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public class ScreenEmulator extends GuiScreen {
    private final VScreen emulatedScreen;
    private GuiScreen previous;
    public ScreenEmulator(VScreen screen, GuiScreen current){
        emulatedScreen = screen;
        previous = current;
    }
    public VScreen getEmulatedScreen() {
        return emulatedScreen;
    }
    @Override
    public void drawScreen(int MouseX, int MouseY, float partialTicks) {
        super.drawScreen(MouseX, MouseY, partialTicks);
        this.emulatedScreen.draw(Session.INSTANCE, this);
    }

    @Override
    protected void mouseClicked(int MouseX, int MouseY, int button) {
        try {
            super.mouseClicked(MouseX, MouseY, button);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.emulatedScreen.mousePressed(MouseX, MouseY, button);
    }
    public void drawDefaultBg(){
        this.drawDefaultBackground();
    }
    public void returnToPrevious(){
        if(previous instanceof GuiMainMenu){
            mc.currentScreen = previous;
        }else{
            Minecraft.getMinecraft().displayGuiScreen(previous);
        }
    }
    public VScreen getEmulated(){
        return emulatedScreen;
    }
    @Override
    public boolean doesGuiPauseGame(){
        return this.emulatedScreen.doesGuiPauseGame();
    }
    @Override
    public void mouseClickMove(int x, int y, int button, long deltat){
        this.emulatedScreen.mouseDrag(x, y, button, deltat);
    }
    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state){
        this.emulatedScreen.mouseReleased(mouseX, mouseY);
    }
}
