import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;

public class Window extends Application {
    public Stage stage;

    public RightMenu rightMenu;
    public Canvas canvas;

    public int x, y;

    public Window() {
        x = 700;
        y = 500;
        rightMenu = new RightMenu(this);
        // set size
        rightMenu.setPrefWidth(200);
        rightMenu.setTranslateX(x-200);
        rightMenu.setTranslateY(0);

        // set canvas
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