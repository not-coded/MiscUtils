package net.notcoded.miscutils;

import java.net.URL;
import java.util.Scanner;

import net.notcoded.miscutils.commands.*;
import net.notcoded.miscutils.config.Config;
import net.notcoded.miscutils.events.PlayerChat;
import net.notcoded.miscutils.events.PlayerJoinLeave;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

//  ________________
// |                |
// |    Made by:    |
// |  ~ NotCoded ~  |
// |                |
// |   MiscUtils    |
// | - Ver 1.0.2 -  |
// |________________|
//

public final class Main extends JavaPlugin {

    public static Main plugin;
    String prefix;

    public static FileConfiguration config;
    public static ConsoleCommandSender server;

    public void onEnable() {
        plugin = this;
        server = plugin.getServer().getConsoleSender();
        Config.loadConfig();
        prefix = Config.PREFIX;
        server.sendMessage("§9-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        server.sendMessage(prefix + " §6Loading stuff:");
        server.sendMessage("§6Loading config...");
        server.sendMessage("§6Config loaded!");
        server.sendMessage("§6Loading commands...");
        LoadCommands();
        server.sendMessage("§6Commands loaded!");
        if(Config.CHECK && Config.NOTIFYCONSOLE){
            server.sendMessage("§6Checking for updates...");
            CheckUpdateConsole();
        }
        server.sendMessage("§6Loading events...");
        LoadEvents();
        server.sendMessage("§6Events loaded!");
        server.sendMessage("§6Plugin loaded!");
        server.sendMessage("§9-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

    public void LoadCommands() {
        try {
            getCommand("miscutils").setExecutor(new miscutils());

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
        pm.registerEvents(new PlayerChat(), this);
    }
    public void CheckUpdateConsole() {
        try {
            String version = getDescription().getVersion();
            URL url = new URL("https://raw.githubusercontent.com/not-coded/MiscUtils/main/version");
            Scanner s = new Scanner(url.openStream());
            String urlversion = s.nextLine();
            if (urlversion.equals(version)) {
                server.sendMessage(prefix + " §6This plugin is up to date!");
            } else {
                server.sendMessage(prefix + " §cYou are running an outdated version of MiscUtils!");
                server.sendMessage(prefix + " §cThe new version is §6" + urlversion + "§c (yours is at §6" + version + "§c)");
                server.sendMessage(prefix + " §cDownload it here:");
                server.sendMessage("§6https://github.com/not-coded/MiscUtils/releases/download/" + urlversion + "/miscutils-" + urlversion + ".jar");
            }
        } catch (Exception e) {
            server.sendMessage(prefix + " §6Couldn't check if plugin is up to date!");
            server.sendMessage(prefix + " §6This may be because the server(s) are down or you don't have internet.");
        }
    }

    public void CheckUpdate(Player player) {
        try {
            String version = getDescription().getVersion();
            URL url = new URL("https://raw.githubusercontent.com/not-coded/MiscUtils/main/version");
            Scanner s = new Scanner(url.openStream());
            String urlversion = s.nextLine();
            if (urlversion.equals(version)) {
                player.sendMessage(prefix + " §6This plugin is up to date!");
            } else {
                player.sendMessage(prefix + " §cYou are running an outdated version of MiscUtils!");
                player.sendMessage(prefix + " §cThe new version is §6" + urlversion + "§c (yours is at §6" + version + "§c)");
                player.sendMessage(prefix + " §6Download it here:");
                player.sendMessage("§6https://github.com/not-coded/MiscUtils/releases/download/" + urlversion + "/miscutils-" + urlversion + ".jar");
            }
        } catch (Exception e) {
            player.sendMessage(prefix + " §6Couldn't check if plugin is up to date!");
            player.sendMessage(prefix + " §6This may be because the server(s) are down or you don't have internet.");
        }
    }
}
