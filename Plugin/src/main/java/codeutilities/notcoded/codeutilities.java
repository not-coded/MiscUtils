package codeutilities.notcoded;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class codeutilities implements CommandExecutor {
    public ArrayList<Player> list_of_flying_players = new ArrayList<>();

    public ArrayList<Player> list_of_god_players = new ArrayList<>();

    String prefix = JavaPlugin.getPlugin(Main.class).getConfig().getString("msg.prefix");
    String noperms = JavaPlugin.getPlugin(Main.class).getConfig().getString("msg.no-perms");

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player))
            return true;
        Player player = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("heal")) {
            if (args.length == 0) {
                double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
                player.setHealth(maxHealth);
                player.sendMessage(prefix + " §6You have been healed.");
                return true;
            }
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (player.hasPermission("codeutilities.heal.others")) {
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
                        player.sendMessage(prefix + " §6You have healed player" + target.getName() + "§6.");
                        return true;
                    }
                    player.sendMessage(prefix + " §6That player isn't online!");
                    return false;
                }
                player.sendMessage(noperms);
                return false;
            }
            return false;
        }
        if (cmd.getName().equalsIgnoreCase("feed")) {
            if (args.length == 0) {
                player.setFoodLevel(20);
                player.sendMessage(prefix + " §6You have been fed.");
                return true;
            }
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (player.hasPermission("codeutilities.feed.others")) {
                    if (target != null) {
                        if (target == player) {
                            target.setFoodLevel(20);
                            target.sendMessage(prefix + " §6You have been fed.");
                            return true;
                        }
                        target.setFoodLevel(20);
                        target.sendMessage(prefix + " §6You have been fed.");
                        player.sendMessage(prefix + " §6You have fed player" + target.getName() + "§6.");
                        return true;
                    }
                    player.sendMessage(prefix + " §6That player isn't online!");
                    return false;
                }
                player.sendMessage(noperms);
                return false;
            }
            return false;
        }
        if (cmd.getName().equalsIgnoreCase("god")) {
            if (args.length == 0) {
                godMethod(player, player);
                return true;
            }
            if (args.length == 1) {
                if (player.hasPermission("codeutilities.god.others")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        godMethod(target, player);
                        return true;
                    }else {
                        player.sendMessage(prefix + " §6That player isn't online!");
                        return false;
                    }
                }
                player.sendMessage(noperms);
            }
        }
        if (cmd.getName().equalsIgnoreCase("fly")) {
            if (args.length == 0) {
                flyMethod(player, player);
                return true;
            }
            if (args.length == 1) {
                if (player.hasPermission("codeutilities.fly.others")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        flyMethod(target, player);
                        return true;
                    } else {
                        player.sendMessage(prefix + " §6That player isn't online!");
                        return false;
                    }
                } else {
                    player.sendMessage(noperms);
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }

    private void flyMethod(Player player, Player executor) {
        if (!list_of_flying_players.contains(player)) {
            list_of_flying_players.add(player);
            player.setAllowFlight(true);
            if (executor == player) {
                player.sendMessage(prefix + " §6Your flight mode has now been set to true.");
            } else {
                player.sendMessage(prefix + " §6Your flight mode has now been set to true.");
                executor.sendMessage(prefix + " §6You have set flight mode of " + player.getName() + " §6to true.");
            }
        } else if (list_of_flying_players.contains(player)) {
            list_of_flying_players.remove(player);
            player.setAllowFlight(false);
            if (executor == player) {
                player.sendMessage(prefix + " §6Your flight mode has now been set to false.");
            } else {
                player.sendMessage(prefix + " §6Your flight mode has now been set to false.");
                executor.sendMessage(prefix + "You have set flight mode of " + player.getName() + " §6to false.");
            }
        }
    }

    private void godMethod(Player player, Player executor) {
        if (!list_of_god_players.contains(player)) {
            list_of_god_players.add(player);
            player.setInvulnerable(true);
            if (executor == player) {
                player.sendMessage(prefix + " §6Your god mode has now been set to true.");
            } else {
                player.sendMessage(prefix + " §6Your god mode has now been set to true.");
                executor.sendMessage(prefix + " §6You have set god mode of " + player.getName() + " §6to true.");
            }
        } else if (list_of_god_players.contains(player)) {
            list_of_god_players.remove(player);
            player.setInvulnerable(false);
            if (executor == player) {
                player.sendMessage(prefix + " §6Your god mode has now been set to false.");
            } else {
                player.sendMessage(prefix + " §6Your god mode has now been set to false.");
                executor.sendMessage(prefix + " §6You have set god mode of " + player.getName() + " §6to false.");
            }
        }
    }
}
