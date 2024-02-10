package SE2203B.MiningGame;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private Label gameDescription;
    @FXML
    private Label gameTitle;
    @FXML
    private Button startBtn;
    @FXML
    private AnchorPane menuBackground;
    public static Image mossyStone = new Image("file:src/main/resources/SE2203B/MiningGame/stoneMossyBackground.jpg");
    public static Background mossyStoneBackground = new Background(new BackgroundImage(mossyStone, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));
    public static Image wood = new Image("file:src/main/resources/SE2203B/MiningGame/WoodBackground.jpg");
    public static Background woodBackground = new Background(new BackgroundImage(wood, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT));

    @FXML
    public void start() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MiningGameApplication.class.getResource("MiningGame-view.fxml"));
        Scene game = new Scene(fxmlLoader.load());
        Stage stage = (Stage) startBtn.getScene().getWindow();
        stage.setScene(game);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameTitle.setText("MINING MINER");
        gameTitle.setBackground(woodBackground);
        gameDescription.setText("Mine all kind of rare ingots by clicking on them as they spawn on the screen." +
                "Test your mining skills with differently difficulties and see who will be the fastest miner."+
                "Press start when you are ready!!!!!");
        gameDescription.setBackground(woodBackground);
        menuBackground.setBackground(mossyStoneBackground);
    }

}
