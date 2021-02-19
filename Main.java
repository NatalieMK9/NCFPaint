package sample;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.ColorPicker;
import javafx.embed.swing.SwingFXUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Main extends Application {
    int i = 0;
    //Stack<Image> undone = new Stack<Image>();
    //Stack<Image> redone = new Stack<Image>();
    //Stack<Image> tasks = new Stack<Image>();
    WritableImage start = new WritableImage(300, 300);
    LinkedList<Image> task = new LinkedList<Image>();



    public void start(Stage stage) {
        task.clear();
        task.add(start);
        HBox flowPane = new HBox();
        Canvas canvas = new Canvas(300, 300);
        canvas.setFocusTraversable(true);
        Button clear = new Button("Clear");
        Button save = new Button("Save");
        Button undo = new Button("Undo");
        TextField text = new TextField();
        ColorPicker cp = new ColorPicker(Color.BLACK);
        Slider slider = new Slider(0, 20, 5);
        slider.setOrientation(Orientation.VERTICAL);
        slider.setShowTickLabels(true);
        slider.setBlockIncrement(5.0);
        slider.setMajorTickUnit(2);
        Group group = new Group();
        group.getChildren().add(canvas);
        group.getChildren().add(cp);
        //group.getChildren().add(slider);
        //group.getChildren().add(clear);
        //group.getChildren().add(save);
        flowPane.getChildren().add(clear);
        flowPane.getChildren().add(save);
        flowPane.getChildren().add(undo);
        flowPane.getChildren().add(group);
        flowPane.getChildren().add(slider);

        //b.setTranslateX(10);
        //b.setTranslateY(20);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0, 0, 300, 300);

        canvas.setOnKeyPressed((e) -> {
            String a = e.getCode().toString().toLowerCase();
            if (a.equals("a")) {
                graphicsContext.closePath();
                canvas.setOnMouseDragged((event) -> {
                    //for(i = 0; i<10; i++) {
                    //WritableImage addedImg = new WritableImage(300, 300);
                    //addedImg = canvas.snapshot(null, addedImg);
                    //task.add(addedImg);
                    graphicsContext.setFill(cp.getValue());
                    graphicsContext.fillRect(event.getX(), event.getY(), slider.getValue(), slider.getValue());
                    System.out.println("X: " + Double.toString(event.getX()) + "; Y: " + Double.toString(event.getY()));

                });
            }
        });

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                slider.setValue((Double) t1);
            }
        });



        canvas.setOnMouseClicked((event) -> {
                        WritableImage addedImg = new WritableImage(300, 300);
                        addedImg = canvas.snapshot(null, addedImg);
                        task.add(addedImg);
                        graphicsContext.setFill(cp.getValue());
                        graphicsContext.fillOval(event.getX(), event.getY(), 10, 10);

                    //System.out.print("Circle ");
                    stage.show();
                });

        EventHandler<ActionEvent> but = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                WritableImage addedImg = new WritableImage(300, 300);
                addedImg = canvas.snapshot(null, null);
                task.add(addedImg);
                if (e.toString().contains("Clear")) {
                    System.out.println("Cleared");
                    task.clear();
                    graphicsContext.setFill(Color.WHITE);
                    graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    canvas.requestFocus();

                }
                if (e.toString().contains("Save")) {
                    FileChooser fileChooser = new FileChooser();

                    //Set extension filter
                    FileChooser.ExtensionFilter extFilter =
                            new FileChooser.ExtensionFilter("PNG File Format Only,", "*.png");
                    fileChooser.getExtensionFilters().add(extFilter);

                    //Show save file dialog
                    File file = fileChooser.showSaveDialog(stage);
                    canvas.requestFocus();


                    if (file != null) {

                        WritableImage a = new WritableImage(300, 300);
                        Image temp = canvas.snapshot(null, a);
                        BufferedImage image = SwingFXUtils.fromFXImage(temp, null);

                        try {
                            ImageIO.write(image, "png", file);
                        } catch (IOException exception) {
                            exception.printStackTrace();
                            canvas.requestFocus();

                        }
                        System.out.println(a);
                        canvas.requestFocus();

                    }
                }
                try {
                    if (e.toString().contains("Undo")) {
                        if (!task.isEmpty()) {
                            System.out.println("Undone ");
                            //Image undo = canvas.snapshot(null, null);
                            //undone.push(undo);
                            task.removeLast();
                            Image redoneImage = task.removeLast();
                            graphicsContext.setFill(Color.WHITE);
                            graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                            graphicsContext.drawImage(redoneImage, 0, 0);
                        }
                    }
                        //System.out.println(Arrays.toString(task.toArray()));
                }
                catch (Exception exception) {
                    System.out.println("Fully Undone: " + exception);
                }


                canvas.requestFocus();
            }
        };



            cp.setOnMouseClicked(a -> {
                graphicsContext.setFill(cp.getValue());
                canvas.requestFocus();

            });

            canvas.setOnKeyReleased(new EventHandler<>() {
                String a = null;
                                       @Override
                                       public void handle(KeyEvent keyEvent) {
                                           graphicsContext.closePath();
                                           canvas.requestFocus();
                                           String a = keyEvent.getCode().toString().toLowerCase();
                                           if (a.equals("s")) {
                                               final WritableImage[] addedImg = {new WritableImage(300, 300)};
                                               //System.out.print(a);
                                               //Polygon a = new Polygon();
                                               graphicsContext.beginPath();
                                               graphicsContext.setStroke(cp.getValue());
                                               canvas.setOnMouseClicked(new EventHandler<>() {
                                                   public void handle(MouseEvent event) {
                                                       addedImg[0] = canvas.snapshot(null, addedImg[0]);
                                                       task.add(addedImg[0]);
                                                       graphicsContext.lineTo(event.getX(), event.getY());
                                                       graphicsContext.setStroke(cp.getValue());
                                                       graphicsContext.closePath();
                                                       graphicsContext.stroke();

                                                       i++;
                                                   }
                                               });
                                           } /*else {
                                               graphicsContext.closePath();
                                           */
                                       }

                                   });





        clear.setOnAction(but);
        save.setOnAction(but);
        undo.setOnAction(but);



        stage.setScene(new Scene(flowPane));
        canvas.requestFocus();
        stage.setTitle("Alex's NCF Paint Demo");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
