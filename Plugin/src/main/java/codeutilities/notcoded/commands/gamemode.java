package codeutilities.notcoded.commands;

import codeutilities.notcoded.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

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

public class gamemode implements TabExecutor {

    String prefix = Config.PREFIX;
    String noperms = Config.NOPERMS;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player))
            return true;
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("gmc")) {
            if(player.hasPermission("codeutilities.gamemode.creative") || player.hasPermission("codeutilities.gamemode.all")){
                if (args.length == 1) {
                    if (player.hasPermission("codeutilities.gamemode.others")) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            ChangeGamemode(target, player, "CREATIVE");
                            return true;
                        } else {
                            player.sendMessage(prefix + " §6That player isn't online!");
                            return false;
                        }
                    } else{
                        player.sendMessage(noperms);
                    }
                } else if (args.length == 0){
                    ChangeGamemode(player, player, "CREATIVE");
                    return true;
                }
            } else if(!player.hasPermission("codeutilities.gamemode.creative") || !player.hasPermission("codeutilities.gamemode.all")){
                player.sendMessage(noperms);
            }
        }
        else if (cmd.getName().equalsIgnoreCase("gms")) {
            if(player.hasPermission("codeutilities.gamemode.survival") || player.hasPermission("codeutilities.gamemode.all")){
                if (args.length == 0) {
                    ChangeGamemode(player, player, "SURVIVAL");
                    return true;
                }
                else if (args.length == 1) {
                    if (player.hasPermission("codeutilities.gamemode.others")) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            ChangeGamemode(target, player, "SURVIVAL");
                            return true;
                        } else {
                            player.sendMessage(prefix + " §6That player isn't online!");
                            return false;
                        }
                    } else {
                        player.sendMessage(noperms);
                    }
                }
            } else if(!player.hasPermission("codeutilities.gamemode.survival") || !player.hasPermission("codeutilities.gamemode.all")){
                player.sendMessage(noperms);
            }
        }

        else if (cmd.getName().equalsIgnoreCase("gmsp")) {
            if (player.hasPermission("codeutilities.gamemode.spectator") || player.hasPermission("codeutilities.gamemode.all")) {
                if (args.length == 1) {
                    if (player.hasPermission("codeutilities.gamemode.others")) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            ChangeGamemode(target, player, "SPECTATOR");
                            return true;
                        } else {
                            player.sendMessage(prefix + " §6That player isn't online!");
                            return false;
                        }
                    } else {
                        player.sendMessage(noperms);
                    }
                } else if (args.length == 0) {
                    ChangeGamemode(player, player, "SPECTATOR");
                    return true;
                }
            } else if (!player.hasPermission("codeutilities.gamemode.spectator") || !player.hasPermission("codeutilities.gamemode.all")) {
                player.sendMessage(noperms);
            }

        }
        else if (cmd.getName().equalsIgnoreCase("gma")) {
            if (player.hasPermission("codeutilities.gamemode.adventure") || player.hasPermission("codeutilities.gamemode.all")) {
                if (args.length == 1) {
                    if (player.hasPermission("codeutilities.gamemode.others")) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            ChangeGamemode(target, player, "ADVENTURE");
                            return true;
                        } else {
                            player.sendMessage(prefix + " §6That player isn't online!");
                            return false;
                        }
                    } else {
                        player.sendMessage(noperms);
                    }
                } else if (args.length == 0) {
                    ChangeGamemode(player, player, "ADVENTURE");
                    return true;
                }
                return false;
            }
            else if(!player.hasPermission("codeutilities.gamemode.adventure") || !player.hasPermission("codeutilities.gamemode.all")){
                player.sendMessage(noperms);
            }
        }
        else if (cmd.getName().equalsIgnoreCase("gamemode") || cmd.getName().equalsIgnoreCase("gm")) {
            if (args.length == 0) {
                player.sendMessage(prefix + " §6Invalid gamemode!");
                return false;
            }

            if (args.length == 1){
                if (args[0].equalsIgnoreCase("0") || (args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("survival"))) {
                    if(player.hasPermission("codeutilities.gamemode.survival") || player.hasPermission("codeutilities.gamemode.all")){
                        ChangeGamemode(player, player, "SURVIVAL");
                    } else {
                        player.sendMessage(noperms);
                    }
                } else if (args[0].equalsIgnoreCase("1") || (args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("creative"))) {
                    if(player.hasPermission("codeutilities.gamemode.creative") || player.hasPermission("codeutilities.gamemode.all")){
                        ChangeGamemode(player, player, "CREATIVE");
                    } else {
                        player.sendMessage(noperms);
                    }
                } else if (args[0].equalsIgnoreCase("3") || (args[0].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("spectator"))) {
                    if(player.hasPermission("codeutilities.gamemode.spectator") || player.hasPermission("codeutilities.gamemode.all")){
                        ChangeGamemode(player, player, "SPECTATOR");
                    } else {
                        player.sendMessage(noperms);
                    }
                } else if (args[0].equalsIgnoreCase("2") || (args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("adventure"))) {
                    if(player.hasPermission("codeutilities.gamemode.adventure") || player.hasPermission("codeutilities.gamemode.all")){
                        ChangeGamemode(player, player, "ADVENTURE");
                    } else {
                        player.sendMessage(noperms);
                    }
                } else{
                    player.sendMessage(prefix + " §6Invalid gamemode!");
                    return false;
                }
                return true;
            }
            if (args.length == 2) {
                if (player.hasPermission("codeutilities.gamemode.others")) {
                    if (args[0].equalsIgnoreCase("1") || (args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("creative"))) {
                        Player target = Bukkit.getPlayer(args[1]);
                        if (target != null) {
                            ChangeGamemode(target, player, "CREATIVE");
                            return true;
                        } else {
                            player.sendMessage(prefix + " §6That player isn't online!");
                            return false;
                        }
                    }
                    else if (args[0].equalsIgnoreCase("0") || (args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("survival"))) {
                        Player target = Bukkit.getPlayer(args[1]);
                        if (target != null) {
                            ChangeGamemode(target, player, "SURVIVAL");
                            return true;
                        } else {
                            player.sendMessage(prefix + " §6That player isn't online!");
                            return false;
                        }
                    }
                    else if (args[0].equalsIgnoreCase("3") || (args[0].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("spectator"))) {
                        Player target = Bukkit.getPlayer(args[1]);
                        if (target != null) {
                            ChangeGamemode(target, player, "SPECTATOR");
                            return true;
                        } else {
                            player.sendMessage(prefix + " §6That player isn't online!");
                            return false;
                        }
                    }
                    else if (args[0].equalsIgnoreCase("2") || (args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("adventure"))) {
                        Player target = Bukkit.getPlayer(args[1]);
                        if (target != null) {
                            ChangeGamemode(target, player, "ADVENTURE");
                            return true;
                        } else {
                            player.sendMessage(prefix + " §6That player isn't online!");
                            return false;
                        }
                    }
                }
                player.sendMessage(noperms);
            }
        } else {
            player.sendMessage(prefix + " §6Invalid gamemode!");
        }
        return false;
    }

    public void ChangeGamemode(Player player, Player executor, String gamemode) {
        if (executor != player) {
            player.setGameMode(GameMode.valueOf(gamemode));
            player.sendMessage(prefix + " §6Your gamemode has been set to §e" + gamemode.toUpperCase() + "§6!");
            executor.sendMessage(prefix + " §6You have set §e" + player.getName() + "'s §6gamemode to" + gamemode.toLowerCase() + "§6!");
        } else{
            player.setGameMode(GameMode.valueOf(gamemode));
            player.sendMessage(prefix + " §6Your gamemode has been set to §e" + gamemode.toLowerCase() + "§6!");
        }
    }

    @Override
    public List<String> onTabComplete (CommandSender sender, Command command, String alias, String[]args) {
        if (command.getName().equalsIgnoreCase("gamemode") || command.getName().equalsIgnoreCase("gm")) {
            if (args.length == 1) {
                List<String> arguments = new ArrayList<>();
                arguments.add("survival");
                arguments.add("creative");
                arguments.add("spectator");
                arguments.add("adventure");
                return arguments;
            }
            if (args.length == 2) {
                List<String> arguments = new ArrayList<>();
                if (sender.hasPermission("codeutilities.gamemode.others")) {
                    Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
                    Bukkit.getServer().getOnlinePlayers().toArray(players);
                    for (int i = 0; i < players.length; i++) {
                        arguments.add(players[i].getName());
                    }
                }
            }
            return null;
        } else {
            if (args.length == 1){
                List<String> arguments = new ArrayList<>();
                if (sender.hasPermission("codeutilities.gamemode.others")) {
                    Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
                    Bukkit.getServer().getOnlinePlayers().toArray(players);
                    for (int i = 0; i < players.length; i++) {
                        arguments.add(players[i].getName());
                    }
                }
            }
            return null;
        }
    }
}




