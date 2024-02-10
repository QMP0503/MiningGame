package SE2203B.MiningGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MiningGameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Mining Game");
        stage.getIcons().add(new Image("file:src/main/resources/SE2203B/MiningGame/pickaxeIcon.png"));
        FXMLLoader fxmlLoader = new FXMLLoader(MiningGameApplication.class.getResource("Menu-view.fxml"));
        Scene menu = new Scene(fxmlLoader.load());
        stage.setScene(menu);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}