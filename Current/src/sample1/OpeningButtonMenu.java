package sample1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class OpeningButtonMenu extends GridPane {
    public OpeningButtonMenu(OpeningScreen window) {
        Stage primaryStage = new Stage();

        this.setTranslateX(window.x / 4.0);
        this.setTranslateY(window.y / 4.0);

        Button simpleButton = new Button("Easy");
        simpleButton.setPrefSize(100, 100);
        simpleButton.setUserData("Easy");
        simpleButton.setTooltip(new Tooltip("Open the easy to use version of the app"));
        simpleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                EasyWindow window1 = new EasyWindow();
                window1.start(primaryStage);
            }
        });

        Button advancedButton = new Button("Pro");
        advancedButton.setPrefSize(100, 100);
        advancedButton.setUserData("Pro");
        advancedButton.setTooltip(new Tooltip("Open the pro version of the app"));
        advancedButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ProWindow window1 = new ProWindow();
                window1.start(primaryStage);
            }
        });

        this.add(advancedButton, 0, 0, 1, 1);
        this.add(simpleButton, 1, 0, 1, 1);
    }
}
