package net.notcoded.miscutils.events;

import net.notcoded.miscutils.config.Config;
import net.notcoded.miscutils.misc.Utilities;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static net.notcoded.miscutils.Main.plugin;

public class PlayerJoinLeave implements Listener {
    String join = Config.JOIN;

    String quit = Config.QUIT;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        DoJoinStuff(p);
        if (Utilities.isStringSet(Config.JOIN)) {
            event.setJoinMessage(PlayerChat.ChatTranslate(replacePlayer(join, p.getDisplayName())));
        }
    }

    public String replacePlayer(String message, String player){
        if(Utilities.isStringSet(message)){
            return message.replace("%player%", player);
        } else{
            return "";
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        Player p = event.getPlayer();
        if(Utilities.isStringSet(Config.QUIT)){
            event.setQuitMessage(PlayerChat.ChatTranslate(replacePlayer(quit, p.getDisplayName())));
        }
    }

    public void DoJoinStuff(Player player){
        if(Config.CHECK && Config.NOTIFYPLAYER){
            if(Utilities.hasPermission(player, "update")){
                plugin.CheckUpdate(player);
            }
        }
    }
}
