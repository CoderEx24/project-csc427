package modular.design.studio;

import java.util.HashMap;
import java.util.Map;

public class ThemeManager {
    private static final ThemeManager instance = new ThemeManager();
    private final Map<String, AbstractUIFactory> factories;

    private ThemeManager() {
        factories = new HashMap<>();
        factories.put("Windows", new WindowsUIFactory());
        factories.put("Mac", new MacUIFactory());
    }

    public static ThemeManager getInstance() {
        return instance;
    }

    public AbstractUIFactory getFactory(String theme) {
        AbstractUIFactory factory = factories.get(theme);
        if (factory == null) {
            throw new IllegalArgumentException("Unknown theme: " + theme);
        }
        return factory;
    }
}