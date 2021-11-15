package codeutilities.notcoded;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class codeut implements CommandExecutor {
    String prefix = JavaPlugin.getPlugin(Main.class).getConfig().getString("msg.prefix");
    String noperms = JavaPlugin.getPlugin(Main.class).getConfig().getString("msg.no-perms");

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("code-utilities")) {
            if (args.length == 0) {
                player.sendMessage("§b-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                player.sendMessage(prefix + " §6Commands:");
                player.sendMessage("");
                player.sendMessage("§6/heal");
                player.sendMessage("§6/heal §8<player>");
                player.sendMessage("");
                player.sendMessage("§6/feed");
                player.sendMessage("§6/feed §8<player>");
                player.sendMessage("");
                player.sendMessage("§6/god");
                player.sendMessage("§6/god §8<player>");
                player.sendMessage("");
                player.sendMessage("§6/fly");
                player.sendMessage("§6/fly §8<player>");
                player.sendMessage("");
                player.sendMessage("§8Made by: §6NotCoded");
                player.sendMessage("§8Commands and permissions: §6/code-utilities perms");
                player.sendMessage("§b-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                return true;
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("perms")) {
                    player.sendMessage("§b-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    player.sendMessage(prefix + " §6Commands and permissions:");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/heal");
                    player.sendMessage("§8Permission: §6codeutilities.heal");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/heal <player>");
                    player.sendMessage("§8Permission: §6codeutilities.heal.others");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/feed");
                    player.sendMessage("§8Permission: §6codeutilities.feed");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/feed <player>");
                    player.sendMessage("§8Permission: §6codeutilities.feed.others");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/god");
                    player.sendMessage("§8Permission: §6codeutilities.god");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/god <player>");
                    player.sendMessage("§8Permission: §6codeutilities.god.others");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/fly");
                    player.sendMessage("§8Permission: §6codeutilities.fly");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/fly <player>");
                    player.sendMessage("§8Permission: §6codeutilities.fly.others");
                    player.sendMessage("");
                    player.sendMessage("§8Made by: §6NotCoded");
                    player.sendMessage("§8Commands: §6/code-utilities cmds");
                    player.sendMessage("§b-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    return true;
                }
                if (args[0].equalsIgnoreCase("permission")) {

                    player.sendMessage("§b-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    player.sendMessage(prefix + " §6Commands and permissions:");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/heal");
                    player.sendMessage("§8Permission: §6codeutilities.heal");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/heal <player>");
                    player.sendMessage("§8Permission: §6codeutilities.heal.others");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/feed");
                    player.sendMessage("§8Permission: §6codeutilities.feed");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/feed <player>");
                    player.sendMessage("§8Permission: §6codeutilities.feed.others");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/god");
                    player.sendMessage("§8Permission: §6codeutilities.god");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/god <player>");
                    player.sendMessage("§8Permission: §6codeutilities.god.others");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/fly");
                    player.sendMessage("§8Permission: §6codeutilities.fly");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/fly <player>");
                    player.sendMessage("§8Permission: §6codeutilities.fly.others");
                    player.sendMessage("");
                    player.sendMessage("§8Made by: §6NotCoded");
                    player.sendMessage("§8Commands: §6/code-utilities cmds");
                    player.sendMessage("§b-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    return true;
                }
                if (args[0].equalsIgnoreCase("permissions")) {
                    player.sendMessage("§b-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    player.sendMessage(prefix + " §6Commands and permissions:");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/heal");
                    player.sendMessage("§8Permission: §6codeutilities.heal");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/heal <player>");
                    player.sendMessage("§8Permission: §6codeutilities.heal.others");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/feed");
                    player.sendMessage("§8Permission: §6codeutilities.feed");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/feed <player>");
                    player.sendMessage("§8Permission: §6codeutilities.feed.others");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/god");
                    player.sendMessage("§8Permission: §6codeutilities.god");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/god <player>");
                    player.sendMessage("§8Permission: §6codeutilities.god.others");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/fly");
                    player.sendMessage("§8Permission: §6codeutilities.fly");
                    player.sendMessage("");
                    player.sendMessage("§8Command: §6/fly <player>");
                    player.sendMessage("§8Permission: §6codeutilities.fly.others");
                    player.sendMessage("");
                    player.sendMessage("§8Made by: §6NotCoded");
                    player.sendMessage("§8Commands: §6/code-utilities cmds");
                    player.sendMessage("§b-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                }
                if (args[0].equalsIgnoreCase("cmds")) {
                    player.sendMessage("§b-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    player.sendMessage(prefix + " §6Commands:");
                    player.sendMessage("");
                    player.sendMessage("§6/heal");
                    player.sendMessage("§6/heal §8<player>");
                    player.sendMessage("");
                    player.sendMessage("§6/feed");
                    player.sendMessage("§6/feed §8<player>");
                    player.sendMessage("");
                    player.sendMessage("§6/god");
                    player.sendMessage("§6/god §8<player>");
                    player.sendMessage("");
                    player.sendMessage("§6/fly");
                    player.sendMessage("§6/fly §8<player>");
                    player.sendMessage("");
                    player.sendMessage("§8Made by: §6NotCoded");
                    player.sendMessage("§8Commands and permissions: §6/code-utilities perms");
                    player.sendMessage("§b-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    return true;
                }
                if (args[0].equalsIgnoreCase("command")) {

                    player.sendMessage("§b-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    player.sendMessage(prefix + " §6Commands:");
                    player.sendMessage("");
                    player.sendMessage("§6/heal");
                    player.sendMessage("§6/heal §8<player>");
                    player.sendMessage("");
                    player.sendMessage("§6/feed");
                    player.sendMessage("§6/feed §8<player>");
                    player.sendMessage("");
                    player.sendMessage("§6/god");
                    player.sendMessage("§6/god §8<player>");
                    player.sendMessage("");
                    player.sendMessage("§6/fly");
                    player.sendMessage("§6/fly §8<player>");
                    player.sendMessage("");
                    player.sendMessage("§8Made by: §6NotCoded");
                    player.sendMessage("§8Commands and permissions: §6/code-utilities perms");
                    player.sendMessage("§b-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    return true;
                }
                if (args[0].equalsIgnoreCase("commands")) {
                    player.sendMessage("§b-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    player.sendMessage(prefix + " §6Commands:");
                    player.sendMessage("");
                    player.sendMessage("§6/heal");
                    player.sendMessage("§6/heal §8<player>");
                    player.sendMessage("");
                    player.sendMessage("§6/feed");
                    player.sendMessage("§6/feed §8<player>");
                    player.sendMessage("");
                    player.sendMessage("§6/god");
                    player.sendMessage("§6/god §8<player>");
                    player.sendMessage("");
                    player.sendMessage("§6/fly");
                    player.sendMessage("§6/fly §8<player>");
                    player.sendMessage("");
                    player.sendMessage("§8Made by: §6NotCoded");
                    player.sendMessage("§8Commands and permissions: §6/code-utilities perms");
                    player.sendMessage("§b-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    return true;
                }
            }
        }
        return false;
    }
}