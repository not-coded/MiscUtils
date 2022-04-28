package codeutilities.notcoded;

import java.net.URL;
import java.util.Scanner;

import codeutilities.notcoded.commands.feed;
import codeutilities.notcoded.commands.fly;
import codeutilities.notcoded.commands.god;
import codeutilities.notcoded.commands.heal;
import codeutilities.notcoded.commands.codeutilities;
import codeutilities.notcoded.commands.gamemode;
import codeutilities.notcoded.config.Config;
import codeutilities.notcoded.events.PlayerJoinLeave;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

//  ________________
// |                |
// |    Made by:    |
// |  ~ NotCoded ~  |
// |                |
// | Code Utilities |
// | - Ver 1.0.1 -  |
// |________________|
//

public final class Main extends JavaPlugin {

    public static Main plugin;
    String prefix;
    public static ConsoleCommandSender server;

    public void onEnable() {
        plugin = this;
        server = plugin.getServer().getConsoleSender();
        Config.loadConfig();
        prefix = Config.PREFIX;
        server.sendMessage("§9-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        server.sendMessage("§8[§b§lCode §6§lUtilities§8]" + " §6Loading stuff:");
        server.sendMessage("§6Loading config...");
        saveDefaultConfig();
        Config.loadConfig();
        server.sendMessage("§6Config loaded!");
        server.sendMessage("§6Loading commands...");
        LoadCommands();
        server.sendMessage("§6Commands loaded!");
        server.sendMessage("§6Checking for updates...");
        CheckUpdateConsole();
        server.sendMessage("§6Loading events...");
        LoadEvents();
        server.sendMessage("§6Events loaded!");
        server.sendMessage("§6Plugin loaded!");
        server.sendMessage("§9-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }


    public void onDisable() { server.sendMessage(prefix + " §6Disabling plugin..."); }

    public void LoadCommands() {
        try {
            getCommand("code-utilities").setExecutor(new codeutilities());

            getCommand("gamemode").setExecutor(new gamemode());
            getCommand("gm").setExecutor(new gamemode());
            getCommand("gms").setExecutor(new gamemode());
            getCommand("gmc").setExecutor(new gamemode());
            getCommand("gmsp").setExecutor(new gamemode());
            getCommand("gma").setExecutor(new gamemode());

            getCommand("heal").setExecutor(new heal());
            getCommand("feed").setExecutor(new feed());
            getCommand("fly").setExecutor(new fly());
            getCommand("god").setExecutor(new god());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void LoadEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoinLeave(), this);
    }

    public static void sendServerMessage(String message){
        plugin.getServer().getConsoleSender().sendMessage(message);
    }
    public void CheckUpdateConsole() {
        try {
            String version = getDescription().getVersion();
            URL url = new URL("https://raw.githubusercontent.com/not-coded/Code-Utilities/main/Plugin/version");
            Scanner s = new Scanner(url.openStream());
            String urlversion = s.nextLine();
            if (urlversion.equals(version)) {
                server.sendMessage(prefix + " §6This plugin is up to date!");
            } else {
                server.sendMessage(prefix + " §cYou are running an outdated version of Code Utilities!");
                server.sendMessage(prefix + " §cThe new version is §6" + urlversion + "§c (yours is at §6" + version + "§c)");
                server.sendMessage(prefix + " §cDownload it here:");
                server.sendMessage("§6https://github.com/not-coded/Code-Utilities/releases/download/" + urlversion + "-plugin/code-utilities-" + urlversion + ".jar");
            }
        } catch (Exception e) {
            server.sendMessage(prefix + " §6Couldn't check if plugin is up to date!");
            server.sendMessage(prefix + " §6This may be because the server(s) are down or you don't have internet.");
        }
    }

    public void CheckUpdate(Player player) {
        try {
            String version = getDescription().getVersion();
            URL url = new URL("https://raw.githubusercontent.com/not-coded/Code-Utilities/main/Plugin/version");
            Scanner s = new Scanner(url.openStream());
            String urlversion = s.nextLine();
            if (urlversion.equals(version)) {
                player.sendMessage(prefix + " §6This plugin is up to date!");
            } else {
                player.sendMessage(prefix + " §cYou are running an outdated version of Code Utilities!");
                player.sendMessage(prefix + " §cThe new version is §6" + urlversion + "§c (yours is at §6" + version + "§c)");
                player.sendMessage(prefix + " §6Download it here:");
                player.sendMessage("§6https://github.com/not-coded/Code-Utilities/releases/download/" + urlversion + "-plugin/code-utilities-" + urlversion + ".jar");
            }
        } catch (Exception e) {
            player.sendMessage(prefix + " §6Couldn't check if plugin is up to date!");
            player.sendMessage(prefix + " §6This may be because the server(s) are down or you don't have internet.");
        }
    }
}
