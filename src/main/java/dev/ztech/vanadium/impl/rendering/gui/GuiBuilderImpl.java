package dev.ztech.vanadium.impl.rendering.gui;

import dev.ztech.vanadium.api.rendering.gui.Button;
import dev.ztech.vanadium.api.rendering.gui.GuiBuilder;

public class GuiBuilderImpl implements GuiBuilder {
    @Override
    public Button buildButton(int x, int y, int w, int h, String displayString) {
        return new ButtonImpl(x, y, w, h, displayString);
    }
}
