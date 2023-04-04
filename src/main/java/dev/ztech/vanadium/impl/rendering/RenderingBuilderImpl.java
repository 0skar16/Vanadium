package dev.ztech.vanadium.impl.rendering;

import dev.ztech.vanadium.api.rendering.RenderStack;
import dev.ztech.vanadium.api.rendering.RenderingBuilder;
import dev.ztech.vanadium.api.rendering.ScaledRes;
import dev.ztech.vanadium.api.rendering.custom.Renderer2D;
import dev.ztech.vanadium.api.rendering.custom.Renderer3D;
import dev.ztech.vanadium.api.rendering.custom.TextureHandler;
import dev.ztech.vanadium.api.rendering.gui.GuiBuilder;
import dev.ztech.vanadium.api.rendering.text.TextRenderer;
import dev.ztech.vanadium.impl.base.SessionImpl;
import dev.ztech.vanadium.impl.rendering.custom.Renderer2DImpl;
import dev.ztech.vanadium.impl.rendering.custom.Renderer3DImpl;
import dev.ztech.vanadium.impl.rendering.custom.TextureHandlerImpl;
import dev.ztech.vanadium.impl.rendering.gui.GuiBuilderImpl;
import dev.ztech.vanadium.impl.rendering.text.VanillaTextRenderer;

public class RenderingBuilderImpl implements RenderingBuilder {
    public static RenderStack stack = new RenderStackImpl();
    public static TextRenderer tr = new VanillaTextRenderer();
    public static GuiBuilder gb = new GuiBuilderImpl();
    public static TextureHandler th = new TextureHandlerImpl();
    public static Renderer2D r2d = new Renderer2DImpl();
    public static Renderer3D r3d = new Renderer3DImpl();
    @Override
    public RenderStack getStack() {
        return stack;
    }

    @Override
    public ScaledRes getScaledRes() {
        return new ScaledResImpl(SessionImpl.getInstance());
    }

    @Override
    public TextRenderer getCurrentTextRenderer() {
        return tr;
    }

    @Override
    public GuiBuilder getGuiBuilder() {
        return gb;
    }

    @Override
    public TextureHandler getTextureHandler() {
        return th;
    }

    @Override
    public Renderer2D getRenderer2D() {
        return r2d;
    }

    @Override
    public Renderer3D getRenderer3D() {
        return r3d;
    }
}
