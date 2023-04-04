package dev.ztech.vanadium.api.base;

import java.io.File;

public class Base {
    public static File mainDir = new File("./vanadium/");
    public static File modDir = new File("./vanadium/mods");
    public static File configDir = new File("./vanadium/conf");
    public static VLogger logger = new VLogger(null);
}
