package dev.ztech.vanadium.ui;

import dev.ztech.vanadium.api.base.Session;
import dev.ztech.vanadium.api.rendering.ScaledRes;
import dev.ztech.vanadium.api.rendering.gui.Button;

public class MainMenuVanadiumButton extends Button {
    public MainMenuVanadiumButton(){
        super(0,0, 20, 20, "V");
    }
    @Override
    public void draw(Session session){
        this.button.x = new ScaledRes(Session.INSTANCE).scaledWidth / 2 + 104;
        this.button.y = new ScaledRes(Session.INSTANCE).scaledHeight / 4 + 48 + 72 + 12;
        super.draw(session);
    }
    @Override
    public void onClick(){
        Session.INSTANCE.setScreen(new VanadiumScreen());
    }
}
