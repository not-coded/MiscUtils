package net.notcoded.miscutils.config;

import net.notcoded.miscutils.Main;
import org.bukkit.configuration.file.FileConfiguration;

import static net.notcoded.miscutils.Main.plugin;

public class Config {
    public static String PREFIX, NOPERMS, JOIN, QUIT, VERSION, CONFIG;
    public static boolean CHECK, NOTIFYCONSOLE, NOTIFYPLAYER, CHATCOLOR;

    public static FileConfiguration config;


    /*
    - Saved for a later version of MiscUtils
    public static void updateConfig(String version){
        if(!config.isSet("config-version")){
            if(!config.isSet("join-message") && !config.isSet("quit-message")){
                //The version is 1.0.0
                // Add a way to delete the file and make it regenerate.
                new File("plugins//MiscUtils").delete();
                new File("plugins//Code-Utilities").delete();

                loadConfig();
            } else{
                // The version may be 1.0.1
                // Add a way to change the file and set values
                new File("plugins//MiscUtils").delete();
                new File("plugins//Code-Utilities").delete();

                Main.plugin.saveDefaultConfig();

                config.set("join-message", JOIN);
                config.set("quit-message", QUIT);
                config.set("config-version", version);
                CONFIG = version;

                loadConfig();
            }

        } else{
            if(!CONFIG.equals(version)){
                config.set("config-version", version);
                CONFIG = version;
            }
        }
    }

     */
    public static void loadConfig(){
        Main.plugin.saveDefaultConfig();
        config = Main.plugin.getConfig();
        VERSION = plugin.getDescription().getVersion();
        CONFIG = config.getString("config-version");
        JOIN = config.getString("join-message");
        QUIT = config.getString("quit-message");
        //updateConfig(VERSION);
        PREFIX = "§8[§b§lMisc§6§lUtils§8]";
        NOPERMS = PREFIX + " §6You don't have permission!";
        CHECK = config.getBoolean("check for updates");
        CHATCOLOR = config.getBoolean("chatcolor");
        NOTIFYCONSOLE = config.getBoolean("notify console");
        NOTIFYPLAYER = config.getBoolean("notify player on join");
        if(JOIN != null && !JOIN.equals("") && !JOIN.contains("%player%")){
            setConfigString("join-message", JOIN + " %player%");
            JOIN = config.getString("join-message");
        }
        if(QUIT != null && !QUIT.equals("") && !QUIT.contains("%player%")){
            setConfigString("quit-message", QUIT + " %player%");
            QUIT = config.getString("quit-message");
        }
    }

    public static void setConfigString(String output, String message){
        config.set(output.replace("&", "§"), message);
        Main.plugin.saveDefaultConfig();
    }
}
