package dev.ztech.vanadium.api.screen;

import dev.ztech.vanadium.api.base.Session;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;

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
    protected void mouseClicked(int MouseX, int MouseY, int p_73864_3_) {
        super.mouseClicked(MouseX, MouseY, p_73864_3_);
        this.emulatedScreen.mousePressed(Session.INSTANCE);
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
}
