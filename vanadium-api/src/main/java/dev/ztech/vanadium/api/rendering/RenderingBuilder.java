package dev.ztech.vanadium.api.rendering;

import dev.ztech.vanadium.api.rendering.custom.Renderer2D;
import dev.ztech.vanadium.api.rendering.custom.Renderer3D;
import dev.ztech.vanadium.api.rendering.custom.TextureHandler;
import dev.ztech.vanadium.api.rendering.gui.GuiBuilder;
import dev.ztech.vanadium.api.rendering.text.TextRenderer;

public interface RenderingBuilder {
    RenderStack getStack();
    ScaledRes getScaledRes();
    TextRenderer getCurrentTextRenderer();
    GuiBuilder getGuiBuilder();
    TextureHandler getTextureHandler();
    Renderer2D getRenderer2D();
    Renderer3D getRenderer3D();
}
