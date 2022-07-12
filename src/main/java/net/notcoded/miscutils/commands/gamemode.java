package net.notcoded.miscutils.commands;

import net.notcoded.miscutils.config.Config;
import net.notcoded.miscutils.misc.Utilities;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class gamemode implements TabExecutor {

    String prefix = Config.PREFIX;
    String noperms = Config.NOPERMS;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player))
            return true;
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("gmc")) {
            if(Utilities.hasPermission(player, "gamemode.creative") && Utilities.hasPermission(player, "gamemode.all")) {
                if (args.length == 1) {
                    if(Utilities.hasPermission(player, "gamemode.others")){
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
            } else {
                player.sendMessage(noperms);
            }
        }
        else if (cmd.getName().equalsIgnoreCase("gms")) {
            if(Utilities.hasPermission(player, "gamemode.survival") && Utilities.hasPermission(player, "gamemode.all")) {
                if (args.length == 0) {
                    ChangeGamemode(player, player, "SURVIVAL");
                    return true;
                }
                else if (args.length == 1) {
                    if(Utilities.hasPermission(player, "gamemode.others")){
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
            } else {
                player.sendMessage(noperms);
            }
        }

        else if (cmd.getName().equalsIgnoreCase("gmsp")) {
            if(Utilities.hasPermission(player, "gamemode.spectator") && Utilities.hasPermission(player, "gamemode.all")) {
                if (args.length == 1) {
                    if(Utilities.hasPermission(player, "gamemode.others")){
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
            } else {
                player.sendMessage(noperms);
            }

        }
        else if (cmd.getName().equalsIgnoreCase("gma")) {
            if(Utilities.hasPermission(player, "gamemode.adventure") && Utilities.hasPermission(player, "gamemode.all")) {
                if (args.length == 1) {
                    if(Utilities.hasPermission(player, "gamemode.others")){
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
            else {
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
                    if(Utilities.hasPermission(player, "gamemode.survival") && Utilities.hasPermission(player, "gamemode.all")) {
                        ChangeGamemode(player, player, "SURVIVAL");
                    } else {
                        player.sendMessage(noperms);
                    }
                } else if (args[0].equalsIgnoreCase("1") || (args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("creative"))) {
                    if(Utilities.hasPermission(player, "gamemode.creative") && Utilities.hasPermission(player, "gamemode.all")) {
                        ChangeGamemode(player, player, "CREATIVE");
                    } else {
                        player.sendMessage(noperms);
                    }
                } else if (args[0].equalsIgnoreCase("3") || (args[0].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("spectator"))) {
                    if(Utilities.hasPermission(player, "gamemode.spectator") && Utilities.hasPermission(player, "gamemode.all")) {
                        ChangeGamemode(player, player, "SPECTATOR");
                    } else {
                        player.sendMessage(noperms);
                    }
                } else if (args[0].equalsIgnoreCase("2") || (args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("adventure"))) {
                    if(Utilities.hasPermission(player, "gamemode.adventure") && Utilities.hasPermission(player, "gamemode.all")) {
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
                if(Utilities.hasPermission(player, "gamemode.others")){
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
                if(Utilities.hasPermission((Player)sender, "gamemode.others")){
                    Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
                    Bukkit.getServer().getOnlinePlayers().toArray(players);
                    for (Player player : players) {
                        arguments.add(player.getName());
                    }
                }
            }
        } else {
            if (args.length == 1){
                List<String> arguments = new ArrayList<>();
                if(Utilities.hasPermission((Player)sender, "gamemode.others")){
                    Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
                    Bukkit.getServer().getOnlinePlayers().toArray(players);
                    for (Player player : players) {
                        arguments.add(player.getName());
                    }
                }
            }
        }
        return null;
    }
}




