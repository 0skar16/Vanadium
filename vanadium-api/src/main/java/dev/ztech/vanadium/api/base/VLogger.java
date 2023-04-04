package dev.ztech.vanadium.api.base;

import dev.ztech.vanadium.api.mod.Mod;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VLogger {

    protected Object owner;

    protected String name;

    protected boolean includeDate;

    protected boolean includeTime;

    public VLogger(Object owner){
        this(owner, false, false);
    }

    public VLogger(Object owner, boolean includeDate, boolean includeTime){
        this.owner = owner;
        if(owner == null){
            name = "VANADIUM";
        }else if(owner instanceof Mod){
            name = ((Mod)owner).data.name;
        }else if(owner instanceof String){
            name = (String)owner;
        }else{
            name = owner.getClass().getSimpleName();
        }
        if(name == null){
            name = "UNKNOWN";
        }
        this.includeDate = includeDate;
        this.includeTime = includeTime;
    }

    protected void log(String message){
        System.out.println(getDate() + getTime() + "[" + name + "]" + message);
    }

    protected String getDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        
        if(includeDate){
            return "[" + formatter.format(date) + "]";
        }else{
            return "";
        }
    }

    protected String getTime(){
        
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        if(includeTime){
            return "[" + formatter.format(date) + "]";
        }else{
            return "";
        }
    }

    public void logRaw(String message){
        log(" " + message);
    }

    public void logDebug(String message){
        log("[DEBUG] " + message);
    }

    public void logDetail(String message){
        log("[DETAIL] " + message);
    }

    /**
     * Prints out a message in the format [{name}][INFO] {message}/n.
     * @param message The message to print.
     */
    public void logInfo(String message){
        log("[INFO] " + message);
    }

    /**
     * Prints out a message in the format [{name}][WARNING] {message}/n.
     * @param message The message to print.
     */
    public void logWarning(String message){
        log("[WARNING] " + message);
    }

    /**
     * Prints out a message in the format [{name}][ERROR] {message}/n.
     * @param message The message to print.
     */
    public void logError(String message){
        log("[ERROR] " + message);
    }

    /**
     * Prints out a message in the format [{name}][FATAL] {message}/n.
     * @param message The message to print.
     */
    public void logFatal(String message){
        log("[FATAL] " + message);
    }

}