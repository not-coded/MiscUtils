package net.notcoded.miscutils.events;

import net.notcoded.miscutils.config.Config;
import net.notcoded.miscutils.misc.Utilities;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {

        if(Config.CHATCOLOR){
            if(Utilities.hasPermission(event.getPlayer(), "chatcolor")){
                event.setMessage(ChatTranslate(event.getMessage()));
            }
        }
    }

    public static String ChatTranslate(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
