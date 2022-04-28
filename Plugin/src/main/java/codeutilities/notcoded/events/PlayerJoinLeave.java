package codeutilities.notcoded.events;

import codeutilities.notcoded.config.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static codeutilities.notcoded.Main.plugin;

//  ________________
// |                |
// |    Made by:    |
// |  ~ NotCoded ~  |
// |                |
// | Code Utilities |
// | - Ver 1.0.1 -  |
// |________________|
//
public class PlayerJoinLeave implements Listener {
    String join = Config.JOIN;

    String quit = Config.QUIT;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player p = event.getPlayer();
        DoJoinStuff(p);
        if(Config.QUIT != null && Config.QUIT != ""){
            event.setJoinMessage(replacePlayer(join, p.getDisplayName()));
        }
    }

    public String replacePlayer(String message, String player){
        if(message != null && message != ""){
            return message.replace("%player%", player);
        }
        return "";
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        Player p = event.getPlayer();
        if(Config.JOIN != null && Config.JOIN != ""){
            event.setQuitMessage(replacePlayer(quit, p.getDisplayName()));
        }
    }

    public void DoJoinStuff(Player player){
        if(player.hasPermission("codeutilities.update")){
            plugin.CheckUpdate(player);
        }
    }
}
