package codeutilities.notcoded.commands;

import codeutilities.notcoded.Main;
import codeutilities.notcoded.config.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

//  ________________
// |                |
// |    Made by:    |
// |  ~ NotCoded ~  |
// |                |
// | Code Utilities |
// | - Ver 1.0.1 -  |
// |________________|
//

public class codeutilities implements TabExecutor {
    String prefix = Config.PREFIX;
    String noperms = Config.NOPERMS;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("code-utilities")) {
            if (args.length == 0) {
                return false;
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("update") || args[0].equalsIgnoreCase("upgrade")) {
                    if (player.hasPermission("codeutilities.update")) {
                        JavaPlugin.getPlugin(Main.class).CheckUpdate(player);
                    } else {
                        player.sendMessage(noperms);
                    }
                    return true;
                }
                /* - Planned for Code Utilities 1.0.3
                if (args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("restart")) {
                    if (player.hasPermission("codeutilities.reload")){
                        Config.loadConfig();
                        player.sendMessage(prefix + " §6Config has been reloaded!");
                    } else {
                        player.sendMessage(noperms);
                    }
                    return true;
                }
                */
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
                    if(player.hasPermission("codeutilities.reload")){
                        player.sendMessage("§f/" + cmd.getName() + " §8[§freload§8]");
                    }
                    if(player.hasPermission("codeutilities.update")){
                        player.sendMessage("§f/" + cmd.getName() + " §8[§fupdate§8]");
                    }
                    if(player.hasPermission("codeutilities.feed.others") && player.hasPermission("codeutilities.feed")){
                        player.sendMessage("§f/feed §8[§fplayer§8]");
                    } else if(player.hasPermission("codeutilities.feed")){
                        player.sendMessage("§f/feed");
                    }
                    if(player.hasPermission("codeutilities.fly.others") && player.hasPermission("codeutilities.fly")){
                        player.sendMessage("§f/fly §8[§fplayer§8]");
                    } else if(player.hasPermission("codeutilities.fly")){
                        player.sendMessage("§f/fly");
                    }
                    if(player.hasPermission("codeutilities.god.others") && player.hasPermission("codeutilities.god")){
                        player.sendMessage("§f/god §8[§fplayer§8]");
                    } else if(player.hasPermission("codeutilities.god")){
                        player.sendMessage("§f/god");
                    }
                    if(player.hasPermission("codeutilities.heal.others") && player.hasPermission("codeutilities.heal")){
                        player.sendMessage("§f/heal §8[§fplayer§8]");
                    } else if (player.hasPermission("codeutilities.heal")){
                        player.sendMessage("§f/heal");
                    }

                    if(player.hasPermission("codeutilities.gamemode.others") && player.hasPermission("codeutilities.gamemode")){
                        if (player.hasPermission("codeutilities.gamemode.survival") || player.hasPermission("codeutilities.gamemode.all")){
                            player.sendMessage("§f/gamemode §8[§fsurvival§8] §8[§fplayer§8]");
                            player.sendMessage("§f/gm§7s §8[§fplayer§8]");
                        }
                        if (player.hasPermission("codeutilities.gamemode.creative") || player.hasPermission("codeutilities.gamemode.all")){
                            player.sendMessage("§f/gamemode §8[§fcreative§8] §8[§fplayer§8]");
                            player.sendMessage("§f/gm§7c §8[§fplayer§8]");
                        }
                        if(player.hasPermission("codeutilities.gamemode.spectator") || player.hasPermission("codeutilities.gamemode.all")){
                            player.sendMessage("§f/gamemode §8[§fspectator§8] §8[§fplayer§8]");
                            player.sendMessage("§f/gm§7sp §8[§fplayer§8]");
                        }
                        if(player.hasPermission("codeutilities.gamemode.adventure") || player.hasPermission("codeutilities.gamemode.all")){
                            player.sendMessage("§f/gamemode §8[§fspectator§8] §8[§fplayer§8]");
                            player.sendMessage("§f/gm§7a §8[§fplayer§8]");
                        }
                    } else if(player.hasPermission("codeutilities.gamemode")){
                        if (player.hasPermission("codeutilities.gamemode.survival") || player.hasPermission("codeutilities.gamemode.all")){
                            player.sendMessage("§f/gamemode §8[§fsurvival§8]");
                            player.sendMessage("§f/gm§7s");
                        } if (player.hasPermission("codeutilities.gamemode.creative") || player.hasPermission("codeutilities.gamemode.all")){
                            player.sendMessage("§f/gamemode §8[§fcreative§8]");
                            player.sendMessage("§f/gm§7c");
                        } if(player.hasPermission("codeutilities.gamemode.spectator") || player.hasPermission("codeutilities.gamemode.all")){
                            player.sendMessage("§f/gamemode §8[§fspectator§8]");
                            player.sendMessage("§f/gm§7sp");
                        } if(player.hasPermission("codeutilities.gamemode.adventure") || player.hasPermission("codeutilities.gamemode.all")) {
                            player.sendMessage("§f/gamemode §8[§fspectator§8]");
                            player.sendMessage("§f/gm§7a");
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
            if (sender.hasPermission("codeutilities.update")){
                arg1.add("update");
            }
            /* - Planned for Code Utilities 1.0.3
            if (sender.hasPermission("codeutilities.reload")){
                arg1.add("reload");
            }
            */


            return arg1;
        } else if (args.length == 2){
            return arg2;
        } else if (args.length == 3){
            return arg3;
        }
        return null;
    }
}