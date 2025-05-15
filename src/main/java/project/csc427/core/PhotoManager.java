package project.csc427.core;

import javafx.scene.image.Image;
import java.util.HashMap;

public final class PhotoManager {
    private static PhotoManager instance;

    private final HashMap<String, Image> cache;

    private PhotoManager() {
        cache = new HashMap<>();
    }

    public static synchronized PhotoManager getInstance() {
        if (instance == null) {
            instance = new PhotoManager();
        }
        return instance;
    }

    public Image loadPhoto(String path) {
        if (cache.containsKey(path)) {
            return cache.get(path);
        }

        try {
            Image img = new Image(path);
            cache.put(path, img);
            return img;
        } catch (Exception e) {
            System.err.println("Failed to load image: " + path);
            return null;
        }
    }

    public void clearCache() {
        cache.clear();
    }
}
