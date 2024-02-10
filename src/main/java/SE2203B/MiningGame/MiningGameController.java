package SE2203B.MiningGame;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.*;

public class MiningGameController implements Initializable {
    public static MiningGameController instance;
    private static Random random;
    private static int count;
    private static LinkedList<Point2D> gridSpaces;
    private static double startTime;

    @FXML
    private AnchorPane gameBackground;
    @FXML
    private AnchorPane difficultyPane;

    @FXML
    private Label endLabel;

    @FXML
    private GridPane gameGrid;

    @FXML
    private Slider headSizeSlider;

    @FXML
    private Label headSizeLabel;

    @FXML
    private Button playBtn;

    @FXML
    private Button resetBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        headSizeLabel.setText("Difficulty");
        Image stone = new Image("file:src/main/resources/SE2203B/MiningGame/stonebackground.jpg");
        Background stoneBackground = new Background(new BackgroundImage(stone,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
        gameGrid.setBackground(stoneBackground);
        gameBackground.setBackground(MenuController.mossyStoneBackground);
        difficultyPane.setBackground(MenuController.woodBackground);
        random = new Random();
        gridSpaces = new LinkedList<>();
        instance = this;
        reset();
    }
    @FXML
    public void reset() {
        count = 0;

        List<Point2D> gridSpaces = new ArrayList<>();
        for (int i = 0; i < gameGrid.getColumnCount(); i++) {
            for (int j = 0; j < gameGrid.getRowCount(); j++) {
               gridSpaces.add(new Point2D(i, j));
            } //generates new grid space array list
        }
        Collections.shuffle(gridSpaces); //shuffled coordinates

        MiningGameController.gridSpaces = new LinkedList<>(gridSpaces);
        //giving shuffled array list to be assigned to grid

        endLabel.setText("");
        gameGrid.getChildren().setAll();
        gameGrid.setVisible(true);
        headSizeSlider.setDisable(false);
        playBtn.setDisable(false);
        resetBtn.setDisable(true);
    }
    @FXML
    public void play() {
        headSizeSlider.setDisable(true);
        playBtn.setDisable(true);
        resetBtn.setDisable(false);

        Ingot firstIngot = IngotFactory.getIngot((int) headSizeSlider.getValue()+1);
        Point2D pos = getOpenGridPos();
        firstIngot.putIn((int)pos.getX(), (int) pos.getY(), gameGrid);
        startTime = System.currentTimeMillis();
    }
    public void setHeadSize(MouseEvent event) {
        count++;

        Ingot headClicked = (Ingot) event.getSource();
        int newSize = headClicked.getHeadSize() - 1;

        gameGrid.getChildren().remove(headClicked);
        gridSpaces.add(new Point2D(headClicked.getGridX(), headClicked.getGridY()));
        Ingot[] newHeads = getNewIngot(newSize);
        for (Ingot head : newHeads) {
            Point2D pos = getOpenGridPos();
            head.putIn((int) pos.getX(), (int) pos.getY(), gameGrid);
        }

        if (gameGrid.getChildren().isEmpty()) {
            gameGrid.setVisible(false);
            double endTime = System.currentTimeMillis();
            double totalTime = (endTime - startTime) / 1000;
            endLabel.setBackground(MenuController.woodBackground);
            endLabel.setText(String.format("Good Job! - You have collected %d Ingots\n Your time was %.2fs", count, totalTime));
        }
    }
    private Ingot[] getNewIngot(int size) {
        if (size <= 0) return new Ingot[0];

        Ingot[] newHeads = new Ingot[random.nextInt(1, 4)];
        for (int i = 0; i < newHeads.length; i++) newHeads[i] = IngotFactory.getIngot(size);
        return newHeads;
    }

    private Point2D getOpenGridPos() {
        return gridSpaces.removeFirst();
    }

}

