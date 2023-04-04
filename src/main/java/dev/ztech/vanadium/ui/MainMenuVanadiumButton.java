package dev.ztech.vanadium.ui;

import dev.ztech.vanadium.api.base.Session;
import dev.ztech.vanadium.api.rendering.ScaledRes;
import dev.ztech.vanadium.impl.base.SessionImpl;
import dev.ztech.vanadium.impl.rendering.ScaledResImpl;
import dev.ztech.vanadium.impl.rendering.gui.ButtonImpl;

public class MainMenuVanadiumButton extends ButtonImpl {
    public MainMenuVanadiumButton(){
        super(0,0, 20, 20, "V");
    }
    @Override
    public void draw(Session session){
        ScaledRes res = SessionImpl.getInstance().getRenderingBuilder().getScaledRes();
        this.button.xPosition = res.getScaledWidth() / 2 + 104;
        this.button.yPosition = res.getScaledHeight() / 4 + 48 + 72 + 12;
        super.draw(session);
    }
    @Override
    public void onClick(){
        SessionImpl.getInstance().setScreen(new VanadiumScreen());
    }
}
