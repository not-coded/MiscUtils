package codeutilities.notcoded;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class NoDamage implements Listener {
    String prefix = JavaPlugin.getPlugin(Main.class).getConfig().getString("msg.prefix");
    String noperms = JavaPlugin.getPlugin(Main.class).getConfig().getString("msg.no-perms");
}
