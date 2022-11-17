package dev.ztech.vanadium.api.rendering.gui;

import dev.ztech.vanadium.api.base.Session;
import dev.ztech.vanadium.api.input.MouseHandler;

public class List implements ApiGui {
    @Override
    public void draw(Session session){
        int x = MouseHandler.INSTANCE.x;
        int y = MouseHandler.INSTANCE.y;
    }

}
        

