package modular.design.studio;

import java.util.HashMap;
import java.util.Map;

public class StyleFactory {
    private static final Map<String, Style> styles = new HashMap<>();

    public static Style getStyle(String font, String color, int size) {
        String key = font + color + size;
        if (!styles.containsKey(key)) {
            styles.put(key, new Style(font, color, size));
        }
        return styles.get(key);
    }
}