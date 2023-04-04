package dev.ztech.vanadium.impl.input;

import dev.ztech.vanadium.api.eventsystem.EventTarget;
import dev.ztech.vanadium.api.eventsystem.events.CTickEvent;
import dev.ztech.vanadium.api.eventsystem.events.KeyEvent;
import dev.ztech.vanadium.api.input.KeyboardHandler;
import org.lwjgl.input.Keyboard;

import java.util.HashMap;
import java.util.Map;

public class KeyboardHandlerImpl implements KeyboardHandler {
    public static KeyboardHandlerImpl INSTANCE = new KeyboardHandlerImpl();

    public boolean isKeyDown(int key){
        return Keyboard.isKeyDown(key);
    }
    Map<Integer, Boolean> keymap = new HashMap<>();
    @EventTarget
    private void onTickTest(CTickEvent e){
        for (int i = 0; i < Keyboard.getKeyCount(); i++) {
            boolean key = Keyboard.isKeyDown(i);
            if((key && !keymap.containsKey(i)) || keymap.get(i) != key){
                keymap.put(i, key);
                new KeyEvent(i, key).call();
            }
        }
    }
}
