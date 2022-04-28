package codeutilities.notcoded.config;

import codeutilities.notcoded.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import static codeutilities.notcoded.Main.plugin;

//  ________________
// |                |
// |    Made by:    |
// |  ~ NotCoded ~  |
// |                |
// | Code Utilities |
// | - Ver 1.0.1 -  |
// |________________|
//

public class Config {
    public static String PREFIX, NOPERMS, JOIN, QUIT, VERSION;
    public static FileConfiguration config = JavaPlugin.getPlugin(Main.class).getConfig();

    public static void loadConfig(){
        Main.plugin.saveDefaultConfig();
        PREFIX = "§8[§b§lCode §6§lUtilities§8]";
        NOPERMS = PREFIX + " §6You don't have permission!";
        JOIN = config.getString("join-message");
        QUIT = config.getString("quit-message");
        VERSION = plugin.getDescription().getVersion();
        if(JOIN != null && JOIN != "" && !JOIN.contains("%player%")){
            setConfigString("join-message", JOIN + " %player%");
            JOIN = config.getString("join-message");
        }
        if(QUIT != null && QUIT != "" && !QUIT.contains("%player%")){
            setConfigString("quit-message", QUIT + " %player%");
            QUIT = config.getString("quit-message");
        }
    }

    public static void setConfigString(String output, String message){
        config.set(output.replace("&", "§"), message);
        Main.plugin.saveDefaultConfig();
    }
}
