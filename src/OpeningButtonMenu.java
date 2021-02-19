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

        Button simpleButton = new Button("Simple");
        simpleButton.setPrefSize(100, 100);
        simpleButton.setUserData("Simple");
        simpleButton.setTooltip(new Tooltip("Open the simplified version of the app"));
        simpleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                SimplifiedWindow window1 = new SimplifiedWindow();
                window1.start(primaryStage);
            }
        });

        Button advancedButton = new Button("Advanced");
        advancedButton.setPrefSize(100, 100);
        advancedButton.setUserData("Advanced");
        advancedButton.setTooltip(new Tooltip("Open the advanced version of the app"));
        advancedButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AdvancedWindow window1 = new AdvancedWindow();
                window1.start(primaryStage);
            }
        });

        this.add(advancedButton, 0, 0, 1, 1);
        this.add(simpleButton, 1, 0, 1, 1);
    }
}
