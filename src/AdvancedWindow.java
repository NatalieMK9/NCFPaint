import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.Group;
import javafx.stage.Stage;

public class AdvancedWindow extends Application {
    public Stage stage;

    public RightMenuAdvanced rightMenu;
    public Canvas canvas;

    public int x, y;

    public AdvancedWindow() {
        x=700;
        y=500;

        rightMenu = new RightMenuAdvanced(this);
        // set size
        rightMenu.setPrefWidth(200);
        rightMenu.setTranslateX(x-200);
        rightMenu.setTranslateY(0);

        canvas = new Canvas(x, y);
    }

    @Override
    public void start(Stage stage) {
        Group root = new Group(rightMenu);
        Scene scene = new Scene(root, x, y);
        stage.setTitle("New College Paint");
        stage.setScene(scene);
        stage.show();
    }
}
