package net.notcoded.miscutils.commands;

import net.notcoded.miscutils.config.Config;
import net.notcoded.miscutils.misc.Utilities;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ping implements TabExecutor {

    String prefix = Config.PREFIX;
    String noperms = Config.NOPERMS;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player))
            return true;
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("ping")) {
            if (args.length == 0) {
                player.sendMessage(prefix + " §6Your ping is " + getPing(player) + "ms");
            }
            return true;
        }
        if (args.length == 1) {
            if (Utilities.hasPermission((Player) sender, "ping.others")) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    player.sendMessage(prefix + " §6The ping of " + target + " is " + getPing(target) + "ms");
                    return true;
                } else {
                    player.sendMessage(prefix + " §6That player isn't online!");
                    return false;
                }
            } else {
                player.sendMessage(noperms);
                return true;
            }
        }
        return true;
    }

    private int getPing(Player player) {
        return player.getPing();
    }


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            if (Utilities.hasPermission((Player) sender, "ping.others")) {
                List<String> playerNames = new ArrayList<>();
                Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
                Bukkit.getServer().getOnlinePlayers().toArray(players);
                for (Player player : players) {
                    playerNames.add(player.getName());
                }
                return playerNames;
            }

        }
        return null;
    }
}
