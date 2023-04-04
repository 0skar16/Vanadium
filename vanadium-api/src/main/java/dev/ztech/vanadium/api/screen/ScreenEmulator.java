package dev.ztech.vanadium.api.screen;

public interface ScreenEmulator {
    Screen getEmulatedScreen();
    void drawDefaultBg();
    void returnToPrevious();
}
