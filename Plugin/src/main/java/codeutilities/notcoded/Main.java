package codeutilities.notcoded;

import java.net.URL;
import java.util.Scanner;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    String prefix = getConfig().getString("msg.prefix");
    String noperms = getConfig().getString("msg.no-perms");

    public static Main plugin;

    public void onEnable() {
        plugin = this;
        getServer().getConsoleSender().sendMessage(prefix + " §6****************************************************");
        getServer().getConsoleSender().sendMessage(prefix + " §6Loading config...");
        saveDefaultConfig();
        getServer().getConsoleSender().sendMessage(prefix + " §6Config loaded!");
        getServer().getConsoleSender().sendMessage(prefix + " §6Loading commands...");
        LoadCommands();
        getServer().getConsoleSender().sendMessage(prefix + " §6Commands loaded!");
        getServer().getConsoleSender().sendMessage(prefix + " §6Checking for updates...");
        CheckUpdate();
        getServer().getConsoleSender().sendMessage(prefix + " §6Loading events...");
        LoadEvents();
        getServer().getConsoleSender().sendMessage(prefix + " §6Events loaded!");
        getServer().getConsoleSender().sendMessage(prefix + " §6Plugin loaded!");
        getServer().getConsoleSender().sendMessage(prefix + " §6****************************************************");
    }

    public void onDisable() {
        getServer().getConsoleSender().sendMessage(prefix + " §6Disabling plugin...");
    }

    public void LoadCommands() {
        try {
            getCommand("code-utilities").setExecutor(new codeut());
            getCommand("heal").setExecutor(new codeutilities());
            getCommand("feed").setExecutor(new codeutilities());
            getCommand("fly").setExecutor(new codeutilities());
            getCommand("god").setExecutor(new codeutilities());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void LoadEvents() {
        PluginManager pm = getServer().getPluginManager();
    }

    public void CheckUpdate() {
        try {
            String version = getDescription().getVersion();
            URL url = new URL("https://raw.githubusercontent.com/not-coded/Code-Utilities/main/Plugin/version");
            Scanner s = new Scanner(url.openStream());
            String urlversion = s.nextLine();
            if (urlversion.equals(version)) {
                getServer().getConsoleSender().sendMessage(prefix + " §6This plugin is up to date!");
            } else {
                getServer().getConsoleSender().sendMessage(prefix + " §6This plugin is not up to date!");
                getServer().getConsoleSender().sendMessage(prefix + " §6Your version:" + version + "the update's version: " + urlversion + "§6.");
            }
        } catch (Exception e) {
            getServer().getConsoleSender().sendMessage(prefix + " §6Couldn't check if plugin is up to date!");
            getServer().getConsoleSender().sendMessage(prefix + " §6This may be because the server(s) are down or you don't have internet so don't worry!");
        }
    }
}
