package dev.ztech.vanadium.api.rendering.gui;

import dev.ztech.vanadium.api.base.Session;

public interface Button extends ApiGui {
    int getX();
    void setX(int x);
    int getY();
    void setY(int y);
    int getWidth();
    int getHeight();
    void setWidth(int w);
    void setHeight(int h);
    void onClick();
}
