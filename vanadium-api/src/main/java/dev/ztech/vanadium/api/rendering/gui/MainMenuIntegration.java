package dev.ztech.vanadium.api.rendering.gui;

import java.util.ArrayList;

public class MainMenuIntegration {
    private static ArrayList<ApiGui> elements = new ArrayList<>();
    public static void addElement(ApiGui el){
        MainMenuIntegration.elements.add(el);
    }
    public static ApiGui[] getElements() {
        ApiGui[] t = {};
        return MainMenuIntegration.elements.toArray(t);
    }
}
