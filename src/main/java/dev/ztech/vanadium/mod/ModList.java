package dev.ztech.vanadium.mod;


import dev.ztech.vanadium.api.base.Base;
import dev.ztech.vanadium.api.events.InitEvent;
import dev.ztech.vanadium.events.EventManager;

import java.util.ArrayList;
import java.util.List;

public class ModList {
    private static final List<Mod> loadedMods = new ArrayList<Mod>();
    private static final List<Class> unloadedMods = new ArrayList<Class>();

    public static List<Mod> getLoadedMods() {
        return loadedMods;
    }

    public static List<Class> getUnloadedMods() {
        return unloadedMods;
    }

    private static Mod getCompatibleModFromList(Mod mod) {
        if (mod != null) {
            for (Mod m : loadedMods) {
                if (mod.data.id.equals(m.data.id)) return m;
            }
        }
        return null;
    }

    public static void load(Class cls, ModData moddata) {
        Base.logger.logDebug("E");
        Mod mod = null;
        try {
            moddata.init();
            mod = (Mod) cls.newInstance();
            mod.data = moddata;
            Mod sameMod = getCompatibleModFromList(mod);
            boolean useNewMod = true;
            if (sameMod != null) {
                Base.logger.logWarning("Duplicate mod: " + mod.data.name + "!  Newest version will be used!");
                if (sameMod.data.getVer_major() < mod.data.getVer_major() || (sameMod.data.getVer_major() == mod.data.getVer_major() && sameMod.data.getVer_minor() < mod.data.getVer_minor())) {
                    loadedMods.remove(sameMod);
                    EventManager.unregister(sameMod);
                } else {
                    useNewMod = false;
                }
            }
            if (useNewMod) {
                loadedMods.add(mod);
                EventManager.register(mod);
                Base.logger.logDetail("Initialized mod: [" + mod.data.name + "] version: [" + mod.data.version + "].");
            }
        } catch (Exception e) {
            if (mod != null) {
                loadedMods.remove(mod);
            }
            Base.logger.logError("Could not initialize mod: " + cls.getName());
            e.printStackTrace();
        }finally {
            if(mod != null){
                new InitEvent().call(mod);
            }
        }
    }
}
