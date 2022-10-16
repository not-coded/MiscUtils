package net.notcoded.miscutils.commands;

import net.notcoded.miscutils.config.Config;
import net.notcoded.miscutils.misc.Utilities;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static net.notcoded.miscutils.Main.plugin;

public class miscutils implements TabExecutor {
    String prefix = Config.PREFIX;
    String noperms = Config.NOPERMS;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("miscutils")) {
            if (args.length == 0) {
                return false;
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("update") || args[0].equalsIgnoreCase("upgrade")) {
                    if(Utilities.hasPermission(player, "update")) {
                        plugin.CheckUpdate(player);
                    } else {
                        player.sendMessage(noperms);
                    }
                    return true;
                }
                if (args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("restart")) {
                    if(Utilities.hasPermission(player, "reload")) {
                        plugin.onDisable();
                        plugin.onEnable();
                        player.sendMessage(prefix + " §6has been reloaded!");
                    } else {
                        player.sendMessage(noperms);
                    }
                    return true;
                }
                if(args[0].equalsIgnoreCase("about")){
                    player.sendMessage("§9-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    player.sendMessage(prefix + " §6" + Config.VERSION);
                    player.sendMessage("§6Made by NotCoded.");
                    player.sendMessage("§9-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    return true;
                }
                if(args[0].equalsIgnoreCase("help")){
                    player.sendMessage("§9-=-=-=-=-=-= " + prefix + " §9=-=-=-=-=-=-=-=-");
                    player.sendMessage("§7Showing all available commands:");
                    player.sendMessage("§f/" + cmd.getName() + " §8[§fabout§8]");
                    player.sendMessage("§f/" + cmd.getName() + " §8[§fhelp§8]");
                    if(Utilities.hasPermission(player, "reload")) {
                        player.sendMessage("§f/" + cmd.getName() + " §8[§freload§8]");
                    }
                    if(Utilities.hasPermission(player, "update")) {
                        player.sendMessage("§f/" + cmd.getName() + " §8[§fupdate§8]");
                    }
                    if(Utilities.hasPermission(player, "feed.others") && Utilities.hasPermission(player, "feed")) {
                        player.sendMessage("§f/feed §8[§fplayer§8]");
                    } else if(Utilities.hasPermission(player, "feed")){
                        player.sendMessage("§f/feed");
                    }
                    if(Utilities.hasPermission(player, "fly.others") && Utilities.hasPermission(player, "fly")) {
                        player.sendMessage("§f/fly §8[§fplayer§8]");
                    } else if(Utilities.hasPermission(player, "fly")){
                        player.sendMessage("§f/fly");
                    }
                    if(Utilities.hasPermission(player, "god.others") && Utilities.hasPermission(player, "god")) {
                        player.sendMessage("§f/god §8[§fplayer§8]");
                    } else if(Utilities.hasPermission(player, "god")){
                        player.sendMessage("§f/god");
                    }
                    if(Utilities.hasPermission(player, "heal.others") && Utilities.hasPermission(player, "heal")) {
                        player.sendMessage("§f/heal §8[§fplayer§8]");
                    } else  if(Utilities.hasPermission(player, "heal")){
                        player.sendMessage("§f/heal");
                    }
                    if(Utilities.hasPermission(player, "ping.others") && Utilities.hasPermission(player, "ping")) {
                        player.sendMessage("§f/ping §8[§fplayer§8]");
                    } else if(Utilities.hasPermission(player, "ping")){
                        player.sendMessage("§f/ping");
                    }

                    if(Utilities.hasPermission(player, "gamemode.others") && Utilities.hasPermission(player, "gamemode")) {
                        if(Utilities.hasPermission(player, "gamemode.survival") && Utilities.hasPermission(player, "gamemode.all")) {
                            player.sendMessage("§f/gamemode §8[§fsurvival§8] §8[§fplayer§8]");
                            player.sendMessage("§f/gm§7s §8[§fplayer§8]");
                        }
                        if(Utilities.hasPermission(player, "gamemode.creative") && Utilities.hasPermission(player, "gamemode.all")) {
                            player.sendMessage("§f/gamemode §8[§fcreative§8] §8[§fplayer§8]");
                            player.sendMessage("§f/gm§7c §8[§fplayer§8]");
                        }
                        if(Utilities.hasPermission(player, "gamemode.spectator") && Utilities.hasPermission(player, "gamemode.all")) {
                            player.sendMessage("§f/gamemode §8[§fspectator§8] §8[§fplayer§8]");
                            player.sendMessage("§f/gm§7sp §8[§fplayer§8]");
                        }
                        if(Utilities.hasPermission(player, "gamemode.adventure") && Utilities.hasPermission(player, "gamemode.all")) {
                            player.sendMessage("§f/gamemode §8[§fadventure§8] §8[§fplayer§8]");
                            player.sendMessage("§f/gm§7a §8[§fplayer§8]");
                        }
                    } else if(Utilities.hasPermission(player, "gamemode"))
                        if(Utilities.hasPermission(player, "gamemode.survival") && Utilities.hasPermission(player, "gamemode.all")) {
                            player.sendMessage("§f/gamemode §8[§fsurvival§8]");
                            player.sendMessage("§f/gm§7s");
                        }
                        if(Utilities.hasPermission(player, "gamemode.creative") && Utilities.hasPermission(player, "gamemode.all")) {
                            player.sendMessage("§f/gamemode §8[§fcreative§8]");
                            player.sendMessage("§f/gm§7c");
                        }
                        if(Utilities.hasPermission(player, "gamemode.spectator") && Utilities.hasPermission(player, "gamemode.all")) {
                            player.sendMessage("§f/gamemode §8[§fspectator§8]");
                            player.sendMessage("§f/gm§7sp");
                        }
                        if(Utilities.hasPermission(player, "gamemode.adventure") && Utilities.hasPermission(player, "gamemode.all")) {
                            player.sendMessage("§f/gamemode §8[§fspectator§8]");
                            player.sendMessage("§f/gm§7a");
                        }
                    player.sendMessage("§8§m---------------------------");
                    player.sendMessage("§7Showing all available other features:");
                    if(Utilities.hasPermission(player, "chatcolor")){
                        player.sendMessage("§f§lChat: §8[§f§lChatcolor§8]");
                    }
                    if(Config.CHECK && Config.NOTIFYPLAYER){
                        if(Utilities.hasPermission(player, "update")){
                            player.sendMessage("§f§lJoin: §8[§f§lUpdate notification§8]");
                        }
                    }
                    player.sendMessage("§9-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    return true;
                }
                return false;
            }
        }
        return false;
    }


    @Override
    public List<String> onTabComplete (CommandSender sender, Command command, String alias, String[]args){
        List<String> arg1 = new ArrayList<>();
        List<String> arg2 = new ArrayList<>();
        List<String> arg3 = new ArrayList<>();
        if (args.length == 1) {
            arg1.add("help");
            arg1.add("about");
            if (Utilities.hasPermission((Player)sender, "update")){
                arg1.add("update");
            }
            if (Utilities.hasPermission((Player)sender, "reload")){
                arg1.add("reload");
            }


            return arg1;
        } else if (args.length == 2){
            return arg2;
        } else if (args.length == 3){
            return arg3;
        }
        return null;
    }
}