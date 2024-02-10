package SE2203B.MiningGame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class IngotFactory extends ImageView {

    private static final Image iron = new Image("file:src/main/resources/SE2203B/MiningGame/iron.png");
    private static final Image emerald = new Image("file:src/main/resources/SE2203B/MiningGame/emerald.png");
    private static final Image gold = new Image("file:src/main/resources/SE2203B/MiningGame/gold.png");
    private static final Image diamond = new Image("file:src/main/resources/SE2203B/MiningGame/diamond.png");



    private IngotFactory() {
    }

    public static Ingot getIngot(int size) {
        Image image = null;
        switch (size) {
            case 1 -> image = iron;
            case 2 -> image = gold;
            case 3 -> image = emerald;
            case 4 -> image = diamond;
        } //set number of ingots appearing on screen. determined by slider

        return new Ingot(image, size);
    }
}
