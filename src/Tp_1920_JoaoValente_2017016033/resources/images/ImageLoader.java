package Tp_1920_JoaoValente_2017016033.resources.images;

import javafx.scene.image.Image;

import java.util.HashMap;

public class ImageLoader {
    static HashMap<String, Image> tabImgs;

    static {
        tabImgs = new HashMap<>();
    }

    public static Image getImage(String name) {
        Image img = tabImgs.get(name);
        if (img == null) {
            return loadImage(name);
        }
        return img;
    }

    public static Image loadImage(String name) {
        try {
            Image img = new Image(ImageLoader.class.getResourceAsStream(name));
            if (img != null) {
                tabImgs.put(name, img);
                return img;
            }
        } catch (Exception e) {
        }
        return null;
    }
}
