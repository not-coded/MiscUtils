package codeutilities.notcoded.commands;

import java.util.ArrayList;
import java.util.List;

import codeutilities.notcoded.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

//  ________________
// |                |
// |    Made by:    |
// |  ~ NotCoded ~  |
// |                |
// | Code Utilities |
// | - Ver 1.0.1 -  |
// |________________|
//

public class heal implements TabExecutor {
    String prefix = Config.PREFIX;
    String noperms = Config.NOPERMS;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player))
            return true;
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("heal")) {
            if (args.length == 0) {
                double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
                player.setHealth(maxHealth);
                player.sendMessage(prefix + " §6You have been healed.");
                return true;
            }
            if (args.length == 1) {
                if (player.hasPermission("codeutilities.heal.others")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        if (target == player) {
                            double d = target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
                            target.setHealth(d);
                            target.sendMessage(prefix + " §6You have been healed.");
                            return true;
                        }
                        double maxHealth = target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
                        target.setHealth(maxHealth);
                        target.sendMessage(prefix + " §6You have been healed.");
                        player.sendMessage(prefix + " §6You have healed player " + target.getName() + "§6.");
                        return true;
                    }
                    player.sendMessage(prefix + " §6That player isn't online!");
                    return false;
                }
                player.sendMessage(noperms);
            }
            return false;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1){
            List<String> playerNames = new ArrayList<>();
            Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
            Bukkit.getServer().getOnlinePlayers().toArray(players);
            for (int i = 0; i < players.length; i++){
                playerNames.add(players[i].getName());
            }

            return playerNames;
        }
        return null;
    }
}