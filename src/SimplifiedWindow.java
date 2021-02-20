import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Group;

import java.util.LinkedList;

public class SimplifiedWindow extends Application {
    public Stage stage;

    public RightMenu rightMenu;
    public Canvas canvas;
    public ColorPicker cp;
    public WritableImage start = new WritableImage(300, 300);
    public LinkedList<Image> task = new LinkedList<Image>();
    public GraphicsContext graphicsContext;

    public int x, y;

    public SimplifiedWindow() {
        x = 700;
        y = 500;
        rightMenu = new RightMenu(this);
        // set size
        rightMenu.setPrefWidth(200);
        rightMenu.setTranslateX(x-200);
        rightMenu.setTranslateY(0);

        // set canvas
        // Todo:  add color wheel
        canvas = new Canvas(x-200, y);
        canvas.setFocusTraversable(true);
        cp = new ColorPicker(Color.BLACK);
        graphicsContext = canvas.getGraphicsContext2D();
    }

    @Override
    public void start(Stage stage) {
        Group root = new Group(rightMenu, canvas, cp);
        Scene scene = new Scene(root, x, y);
        stage.setTitle("New College Paint");
        stage.setScene(scene);
        stage.show();
    }
}