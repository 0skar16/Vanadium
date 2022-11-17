package dev.ztech.vanadium.mod;

import java.util.List;

public class ModData {
    public String name;
    public String description;
    public String version;
    public List<String> authors;
    private int ver_major;
    private int ver_minor;
    public String id;
    public void init(){
        String[] parts = version.split("\\.");
        ver_major = Integer.parseInt(parts[0]);
        ver_minor = Integer.parseInt(parts[1]);
    }
    public int getVer_major(){
        return this.ver_major;
    }
    public int getVer_minor(){
        return this.ver_minor;
    }
}
