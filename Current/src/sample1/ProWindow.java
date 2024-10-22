package sample1;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.control.Slider;

import java.util.LinkedList;

public class ProWindow extends Application {
    public Stage stage;

    public RightMenuPro rightMenu;
    public Canvas canvas;
    public ColorPicker cp;
    public WritableImage start = new WritableImage(300, 300);
    public LinkedList<Image> task = new LinkedList<Image>();
    public GraphicsContext graphicsContext;
    public Slider slider;

    public int x, y;

    public ProWindow() {
        x=700;
        y=500;

        rightMenu = new RightMenuPro(this);
        // set size
        rightMenu.setPrefWidth(200);
        rightMenu.setTranslateX(x-200);
        rightMenu.setTranslateY(0);

        canvas = new Canvas(x-200, y);
        canvas.setFocusTraversable(true);
        cp = new ColorPicker(Color.BLACK);
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0, 0, x-200, y);

        slider = new Slider(1, 50, 5);
        slider.setOrientation(Orientation.VERTICAL);
        slider.setShowTickLabels(true);
        slider.setBlockIncrement(5.0);
        slider.setMajorTickUnit(2);
        slider.setTranslateX(x-30);
    }

    @Override
    public void start(Stage stage) {
        Group root = new Group(rightMenu, canvas, slider);
        Scene scene = new Scene(root, x, y);
        stage.setTitle("New College Paint");
        stage.setScene(scene);
        stage.show();
    }
}
