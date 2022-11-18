package dev.ztech.vanadium.api.rendering.text;

public interface TextRenderer {
    int getHeight();
    int getWidth(String string);
    void render(String text, int x, int y, int color);
    default void renderCentered(String text, int x, int y, int color){
        int offsetx = this.getWidth(text)/2;
        int offsety = this.getHeight()/2;
        this.render(text, x-offsetx, y-offsety, color);
    }
    void renderWithShadow(String text, int x, int y, int color);
    default void renderCenteredWithShadow(String text, int x, int y, int color){
        int offsetx = this.getWidth(text)/2;
        int offsety = this.getHeight()/2;
        this.renderWithShadow(text, x-offsetx, y-offsety, color);
    }
}
