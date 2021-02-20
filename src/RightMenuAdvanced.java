import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class RightMenuAdvanced extends GridPane {
    public RightMenuAdvanced(AdvancedWindow window) {
        int i=0;
        Stage primaryStage = new Stage();
        this.setPadding(new Insets(10, 15, 10, 12));

        Label label1 = new Label("make");
        label1.setTextFill(Color.GREY);

        Button handDrawBtn = new Button("Hand Draw");
        handDrawBtn.setPrefSize(100, 30);
        handDrawBtn.setUserData("Hand Draw");
        handDrawBtn.setTooltip(new Tooltip("Click and drag to draw"));

        handDrawBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Hand Draw");
                window.cp.setOnMouseClicked(a -> {
                    window.graphicsContext.setFill(window.cp.getValue());
                    window.canvas.requestFocus();

                });

                window.canvas.setOnMouseClicked((event) -> {
                    WritableImage addedImg = new WritableImage(300, 300);
                    addedImg = window.canvas.snapshot(null, addedImg);
                    window.task.add(addedImg);
                    window.graphicsContext.setFill(window.cp.getValue());
                    window.graphicsContext.fillRect(event.getX(), event.getY(), window.slider.getValue(), window.slider.getValue());
                });


                window.graphicsContext.closePath();
                window.canvas.setOnMouseDragged((event) -> {
                            //for(i = 0; i<10; i++) {
                            //WritableImage addedImg = new WritableImage(300, 300);
                            //addedImg = canvas.snapshot(null, addedImg);
                            //task.add(addedImg);
                            window.graphicsContext.setFill(window.cp.getValue());
                            window.graphicsContext.fillRect(event.getX(), event.getY(), window.slider.getValue(), window.slider.getValue());
                            System.out.println("X: " + Double.toString(event.getX()) + "; Y: " + Double.toString(event.getY()));
                        });

                window.canvas.setOnKeyReleased(new EventHandler<>() {
                    String a = null;
                    @Override
                    public void handle(KeyEvent keyEvent) {
                        window.graphicsContext.closePath();
                        window.canvas.requestFocus();
                        String a = keyEvent.getCode().toString().toLowerCase();
                        final WritableImage[] addedImg = {new WritableImage(300, 300)};
                        window.graphicsContext.beginPath();
                        window.graphicsContext.setStroke(window.cp.getValue());
                        window.canvas.setOnMouseClicked(new EventHandler<>() {
                            public void handle(MouseEvent event) {
                                addedImg[0] = window.canvas.snapshot(null, addedImg[0]);
                                window.task.add(addedImg[0]);
                                window.graphicsContext.lineTo(event.getX(), event.getY());
                                window.graphicsContext.setStroke(window.cp.getValue());
                                window.graphicsContext.closePath();
                                window.graphicsContext.stroke();

                                //i++;
                            }
                        });
                    }
                });
            }
        });

        Button pixelBtn = new Button("Pixel");
        pixelBtn.setPrefSize(100, 30);
        pixelBtn.setUserData("Pixel");
        pixelBtn.setTooltip(new Tooltip("Click to fill in a pixel"));

        pixelBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Pixel");
            }
        });

        Button eraseBtn = new Button("Erase");
        eraseBtn.setPrefSize(100, 30);
        eraseBtn.setUserData("Erase");
        eraseBtn.setTooltip(new Tooltip("Click and drag to erase"));

        eraseBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Erase");
            }
        });

        Button moveBtn = new Button("Move");
        moveBtn.setPrefSize(100, 30);
        moveBtn.setUserData("Move");
        moveBtn.setTooltip(new Tooltip("Click and drag to move objects"));

        moveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Move");
            }
        });

        Button lineBtn = new Button("Line");
        lineBtn.setPrefSize(100, 30);
        lineBtn.setUserData("Line");
        lineBtn.setTooltip(new Tooltip("Click on start point and then on end point to create"));
        lineBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Line");
            }
        });

        Button textBtn = new Button("Text");
        textBtn.setPrefSize(100, 30);
        textBtn.setUserData("Line");
        textBtn.setTooltip(new Tooltip("Click to add text"));
        textBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Text");
            }
        });

        Button polygonBtn = new Button("Polygon");
        polygonBtn.setPrefSize(100, 30);
        polygonBtn.setUserData("Polygon");
        polygonBtn.setTooltip(new Tooltip("Click to define the corners of a rectangle"));
        polygonBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Polygon");
            }
        });

        Button circleBtn = new Button("Circle");
        circleBtn.setPrefSize(100, 30);
        circleBtn.setUserData("Circle");
        circleBtn.setTooltip(new Tooltip("Create a circle around where you clicked"));
        circleBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Circle");
                window.canvas.setOnMouseClicked((event) -> {
                    WritableImage addedImg = new WritableImage(300, 300);
                    addedImg = window.canvas.snapshot(null, addedImg);
                    window.task.add(addedImg);
                    window.graphicsContext.setFill(window.cp.getValue());
                    window.graphicsContext.fillOval(event.getX(), event.getY(), window.slider.getValue(), window.slider.getValue());
                });
            }
        });

        Button curveBtn = new Button("Curve");
        curveBtn.setPrefSize(100, 30);
        curveBtn.setUserData("Circle");
        curveBtn.setTooltip(new Tooltip("Create a curve where you click"));
        curveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Curve");
            }
        });

        Button undoBtn = new Button("Undo");
        undoBtn.setPrefSize(100, 30);
        undoBtn.setUserData("Undo");
        undoBtn.setTooltip(new Tooltip("Click to undo most recent change"));

        undoBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Undo");
            }
        });

        Button redoBtn = new Button("Redo");
        redoBtn.setPrefSize(100, 30);
        redoBtn.setUserData("Undo");
        redoBtn.setTooltip(new Tooltip("Click to redo the thing you just undid"));

        redoBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Redo");
            }
        });

        Button doneBtn = new Button("Done");
        doneBtn.setPrefSize(100, 30);
        doneBtn.setUserData("Done");
        doneBtn.setTooltip(new Tooltip("Click to save your work"));

        doneBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Saved");
            }
        });

        this.add(moveBtn, 0, 0, 1, 1);
        this.add(handDrawBtn, 0, 1, 1, 1);
        this.add(pixelBtn, 0, 2, 1, 1);
        this.add(eraseBtn, 0, 3, 1, 1);
        this.add(lineBtn, 0, 4, 1, 1);
        this.add(curveBtn, 0, 5, 1, 1);
        this.add(circleBtn, 0, 6, 1, 1);
        this.add(polygonBtn, 0, 7, 1, 1);
    }
}
