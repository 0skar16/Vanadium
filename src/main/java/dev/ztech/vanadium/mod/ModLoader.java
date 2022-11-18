package dev.ztech.vanadium.mod;

import dev.ztech.vanadium.api.base.Base;
import org.lwjgl.Sys;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ModLoader {
    public static void loadMods(File searchDir, List<Class> modList){
        if(!searchDir.exists() || !searchDir.isDirectory()){
            Base.logger.logError("Invalid mod search directory: " + searchDir.getAbsolutePath());
        }else{
            File[] zips = searchDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".jar"));
            for(File modJar : zips){
                try{
                    ClassLoader loader = new URLClassLoader(new URL[]{modJar.toURI().toURL()}, ModLoader.class.getClassLoader());
                    ZipFile zipFile = new ZipFile(modJar);
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    Class oMod = null;
                    ModData moddata = null;
                    while(entries.hasMoreElements()){
                        ZipEntry entry = entries.nextElement();
                        if(entry.getName().endsWith(".class") && oMod == null){
                            Class modClass = loader.loadClass(entry.getName().replaceAll("/", ".").substring(0, entry.getName().length() - 6));
                            if(Mod.class.isAssignableFrom(modClass)){
                                oMod = modClass;
                                Base.logger.logDetail("Loaded mod: [" + modClass.getName() + "] from jar: [" + modJar.getName() + "].");
                            }
                        }else if(entry.getName().endsWith("vanadium.yml")){
                            Yaml modconf = new Yaml();
                            InputStream stream = zipFile.getInputStream(entry);
                            Map<String, Object> map = modconf.load(stream);
                            moddata = new ModData((String) map.get("name"), (String) map.get("description"), (String) map.get("version"));
                        }
                        if(oMod != null && moddata != null) {
                            break;
                        }
                    }
                    if(oMod != null && moddata != null){
                        ModList.load(oMod, moddata);
                    }
                }catch(IOException e){
                    Base.logger.logWarning("Skipping corrupt jar: " + modJar.getName());
                }catch(ReflectiveOperationException e){
                    Base.logger.logWarning("Skipping corrupt mod in: " + modJar.getName());
                }
            }
        }
    }

    public static void loadModsToList(File searchDir){
        loadMods(searchDir, ModList.getUnloadedMods());
    }
}
