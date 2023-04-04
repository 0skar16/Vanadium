package dev.ztech.vanadium.api.rendering.gui;

public interface GuiBuilder {
    Button buildButton(int x, int y, int w, int h, String displayString);
}
