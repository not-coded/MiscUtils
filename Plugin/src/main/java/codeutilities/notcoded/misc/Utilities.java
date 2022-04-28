package codeutilities.notcoded.misc;

//  ________________
// |                |
// |    Made by:    |
// |  ~ NotCoded ~  |
// |                |
// | Code Utilities |
// | - Ver 1.0.1 -  |
// |________________|
//

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Utilities {
    public static String ChatTranslate(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> ChatTranslate(List<String> message) {
        List<String> list = new ArrayList<>();
        for (String string : message) {
            list.add(Utilities.ChatTranslate(string));
        }
        return list;
    }
}
