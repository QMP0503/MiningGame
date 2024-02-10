module com.example.hydragame {
    requires javafx.controls;
    requires javafx.fxml;


    opens SE2203B.MiningGame to javafx.fxml;
    exports SE2203B.MiningGame;
}