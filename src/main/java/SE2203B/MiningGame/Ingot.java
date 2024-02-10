package SE2203B.MiningGame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class Ingot extends ImageView {
    private final int headSize;
    private int currentGridX;
    private int currentGridY;
    public Ingot(Image image, int size) {
        super(image);
        headSize = size;

        setFitHeight(40);
        setFitWidth(40);
        setOnMouseClicked(MiningGameController.instance::setHeadSize);
    }

    public int getHeadSize() {
        return headSize;
    }
    public int getGridX(){
        return currentGridX;
    }
    public int getGridY(){
        return currentGridY;
    }
    public void putIn(int gridX, int gridY, GridPane board) {
        currentGridX = gridX;
        currentGridY = gridY;

        board.add(this, gridX, gridY);
    }
}
