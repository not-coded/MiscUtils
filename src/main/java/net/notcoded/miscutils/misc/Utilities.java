package net.notcoded.miscutils.misc;

import org.bukkit.entity.Player;

public class Utilities {

    public static boolean hasPermission(Player player, String permission){
        return player.hasPermission("miscutils." + permission);
    }

    public static boolean isStringSet(String message){
        if(message == null){
            return false;
        }
        return !message.equals("");
    }
}
