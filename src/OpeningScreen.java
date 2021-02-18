import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;

public class OpeningScreen extends Application {
    public Stage stage;
    int x, y;
    public OpeningButtonMenu openingButtonMenu;

    public OpeningScreen() {
        this.x = 400;
        this.y = 400;

        this.openingButtonMenu = new OpeningButtonMenu(this);
        openingButtonMenu.setAlignment(Pos.BASELINE_CENTER);
    }
    public void start(Stage stage) {
        Group root = new Group(openingButtonMenu);
        Scene scene = new Scene(root, x, y);
        stage.setTitle("Opening Menu");
        stage.setScene(scene);
        stage.show();
    }
}
