package sample1;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/***
 * Right side menu for the advanced window.
 *
 * @author RANT
 * @version 1.0
 * @since 2021-02-25
 */
public class RightMenuPro extends GridPane {
    public ColorPicker cp;

    /***
     * Constructor for the RightMenuAdvanced class
     * @param window the Advanced window to access
     */
    public RightMenuPro(ProWindow window) {
        window.task.add(new WritableImage(window.x-200, window.y));
        int i=0;
        cp = new ColorPicker(Color.BLACK);
        cp.setPrefSize(100, 30);
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
                window.canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        makeHandDraw(primaryStage, window, mouseEvent.getX(), mouseEvent.getY());
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
                window.canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        window.graphicsContext.setFill(cp.getValue());
                        window.graphicsContext.fillRect(event.getX() - (window.slider.getValue() / 2),
                                event.getY() - (window.slider.getValue() / 2), window.slider.getValue(),
                                window.slider.getValue());


                    }
                });
                window.canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        // Do nothing
                    }
                });
                window.canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        // do nothing
                    }
                });
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
                window.canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        makeErase(primaryStage, window, mouseEvent.getX(), mouseEvent.getY());
                    }
                });
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
                window.canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        // Do nothing
                    }
                });
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
                window.canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        makeLine(primaryStage, window, mouseEvent.getX(), mouseEvent.getY());
                    }
                });
                window.canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        // Do nothing
                    }
                });
                window.canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        //do nothing
                    }
                });
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
                window.canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        getText(new Stage(), window, mouseEvent.getX(), mouseEvent.getY());
                    }
                });
                window.canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        // Do nothing
                    }
                });
                window.canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        // Do nothing
                    }
                });
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
                window.canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        makeRectangle(primaryStage, window, mouseEvent.getX(), mouseEvent.getY());
                    }
                });
                window.canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        // Do nothing
                    }
                });
                window.canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        // Do nothing
                    }
                });
            }
        });

        Button clipartButton = new Button("Clipart");
        clipartButton.setPrefSize(100, 30);
        clipartButton.setUserData("Clipart");
        clipartButton.setTooltip(new Tooltip("Click to insert clipart"));
        clipartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Clipart");
                window.canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        // Do nothing
                    }
                });
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
                    WritableImage addedImg = new WritableImage(window.x-200, window.y);
                    addedImg = window.canvas.snapshot(null, addedImg);
                    window.task.add(addedImg);
                    window.graphicsContext.setFill(cp.getValue());
                    window.graphicsContext.fillOval(event.getX() - (window.slider.getValue() / 2),
                            event.getY() - (window.slider.getValue() / 2), window.slider.getValue(),
                            window.slider.getValue());
                });
                window.canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        // Do nothing
                    }
                });
                window.canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        // do nothing
                    }
                });
                window.canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        // do nothing
                    }
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
                window.canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        window.graphicsContext.setStroke(window.cp.getValue());
                        window.graphicsContext.strokeArc(event.getX(), event.getY(), window.slider.getValue()*5, 100, 180, 120, ArcType.OPEN);
                        window.graphicsContext.stroke();
                    }
                });
                // Undo any possible handlers set by other methods.
                window.canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        // Do nothing
                    }
                });
            }
        });

        Button undoBtn = new Button("Undo");
        undoBtn.setPrefSize(60, 30);
        undoBtn.setUserData("Undo");
        undoBtn.setTooltip(new Tooltip("Click to undo most recent change"));

        undoBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Undo");
                try {
                    if (!window.task.isEmpty()) {
                        window.task.removeLast();
                        Image redoneImage = window.task.removeLast();
                        window.graphicsContext.setFill(Color.WHITE);
                        window.graphicsContext.fillRect(0, 0, window.canvas.getWidth(), window.canvas.getHeight());
                        window.graphicsContext.drawImage(redoneImage, 0, 0);
                    }
                } catch (Exception exception) {
                    System.out.println("Fully Undone: " + exception);
                }
            }
        });

        Button redoBtn = new Button("Redo");
        redoBtn.setPrefSize(60, 30);
        redoBtn.setUserData("Undo");
        redoBtn.setTooltip(new Tooltip("Click to redo the thing you just undid"));

        redoBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Redo");
            }
        });

        Button doneBtn = new Button("Done");
        doneBtn.setPrefSize(60, 30);
        doneBtn.setUserData("Done");
        doneBtn.setTooltip(new Tooltip("Click to save your work"));

        doneBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Saved");
                FileChooser fileChooser = new FileChooser();

                //Set extension filter
                FileChooser.ExtensionFilter extFilter =
                                            new FileChooser.ExtensionFilter("Image File Format Only", "*.png", "*.jpeg", "*.svg", "*.gif");
                fileChooser.getExtensionFilters().add(extFilter);

                //Show save file dialog
                File file = fileChooser.showSaveDialog(window.stage);
                window.canvas.requestFocus();


                if (file != null) {

                    WritableImage a = new WritableImage((int) window.canvas.getWidth(), (int) window.canvas.getHeight());
                    Image temp = window.canvas.snapshot(null, a);
                    BufferedImage image = SwingFXUtils.fromFXImage(temp, null);

                    try {
                        Checker u = new Checker();
                        String ext = u.getExtension(file);
                        ImageIO.write(image, ext, file);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                        window.canvas.requestFocus();
                    }
                }
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
        this.add(textBtn, 0, 8, 1, 1);
        this.add(clipartButton, 0, 9, 1, 1);
        this.add(cp, 0, 10, 1, 1);
        this.add(undoBtn, 1, 0, 1, 1);
        this.add(redoBtn, 1, 5, 1, 1);
        this.add(doneBtn, 1, 10, 1, 1);

    }

    /***
     * Allows you to draw free hand using recursion.
     * @param stage the stage to use
     * @param window the window to use
     * @param x the starting x coordinate
     * @param y the starting y coordinate
     */
    public void makeHandDraw(Stage stage, ProWindow window, double x, double y) {
        final WritableImage[] addedImg = {new WritableImage(window.x - 200, window.y)};
        window.graphicsContext.setFill(cp.getValue());
        window.graphicsContext.setLineWidth(window.slider.getValue());
        window.graphicsContext.setStroke(cp.getValue());
        window.graphicsContext.lineTo(x, y);
        window.graphicsContext.stroke();
        window.canvas.setOnMouseReleased((e) -> {
            window.graphicsContext.beginPath();
            addedImg[0] = new WritableImage(window.x - 200, window.y);
            addedImg[0] = window.canvas.snapshot(null, addedImg[0]);
            window.task.add(addedImg[0]);
            window.canvas.disableProperty();
        });

        window.canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                makeHandDraw(stage, window, mouseEvent.getX(), mouseEvent.getY());
                window.graphicsContext.closePath();
            }
        });
    }

    /***
     * Like free hand, the erase feature uses recursion to erase as many things as you want.
     * @param stage the stage to use
     * @param window the window to use
     * @param x the starting x coordinate
     * @param y the starting y coordinate
     */
    public void makeErase(Stage stage, ProWindow window, double x, double y) {
        final WritableImage[] addedImg = {new WritableImage(window.x - 200, window.y)};
        window.graphicsContext.setFill(Color.WHITE);
        window.graphicsContext.setStroke(Color.WHITE);
        window.graphicsContext.setLineWidth(window.slider.getValue());
        window.graphicsContext.lineTo(x, y);
        window.graphicsContext.stroke();
        window.canvas.setOnMouseReleased((e) -> {
            addedImg[0] = new WritableImage(window.x - 200, window.y);
            addedImg[0] = window.canvas.snapshot(null, addedImg[0]);
            window.task.add(addedImg[0]);
            window.canvas.disableProperty();
            window.graphicsContext.closePath();
        });

        window.canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                window.graphicsContext.beginPath();
                makeErase(stage, window, mouseEvent.getX(), mouseEvent.getY());
            }
        });
    }

    /***
     * Makes lines using recursion
     * @param stage the stage to use
     * @param window the window to use
     * @param startX the starting x coordinate
     * @param startY the starting y coordinate
     */
    public void makeLine(Stage stage, ProWindow window, double startX, double startY) {
        window.graphicsContext.closePath();
        window.canvas.requestFocus();
        final WritableImage[] addedImg = {new WritableImage(window.x - 200, window.y)};
        //window.graphicsContext.beginPath();
        window.graphicsContext.setStroke(cp.getValue());

        window.canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                addedImg[0] = window.canvas.snapshot(null, addedImg[0]);
                window.task.add(addedImg[0]);
                window.graphicsContext.setLineWidth(window.slider.getValue());
                window.graphicsContext.strokeLine(startX, startY, event.getX(), event.getY());
                window.canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        makeLine(stage, window, mouseEvent.getX(), mouseEvent.getY());
                    }
                });
            }
        });
    }

    /***
     * makes rectangles using recursion
     * @param stage the stage to use
     * @param window the window to use
     * @param firstX the first x coordinate
     * @param firstY the first y coordinate
     */
    public void makeRectangle(Stage stage, ProWindow window, double firstX, double firstY) {
        window.graphicsContext.beginPath();
        window.canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                window.graphicsContext.setFill(cp.getValue());
                if (firstX < mouseEvent.getX() && firstY > mouseEvent.getY()) {
                    window.graphicsContext.fillRect(firstX, mouseEvent.getY(), mouseEvent.getX() - firstX, firstY - mouseEvent.getY());
                } else if (firstX > mouseEvent.getX() && firstY < mouseEvent.getY()){
                    window.graphicsContext.fillRect(mouseEvent.getX(), firstY, firstX - mouseEvent.getX(), mouseEvent.getY() - firstY);
                } else if (firstX > mouseEvent.getX() && firstY > mouseEvent.getY()) {
                    window.graphicsContext.fillRect(mouseEvent.getX(), mouseEvent.getY(), firstX - mouseEvent.getX(), firstY - mouseEvent.getY());
                } else {
                    window.graphicsContext.fillRect(firstX, firstY, mouseEvent.getX() - firstX, mouseEvent.getY() - firstY);
                }

                WritableImage addedImg = new WritableImage(window.x-200, window.y);
                addedImg = window.canvas.snapshot(null, addedImg);
                window.task.add(addedImg);
                window.canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        window.graphicsContext.setFill(window.cp.getValue());
                        makeRectangle(stage, window, mouseEvent.getX(), mouseEvent.getY());
                    }
                });

            }
        });
    }

    /***
     * makes a window to enter text in and puts it on the canvas upon clicking enter
     * @param stage the stage to use
     * @param window the window to use
     * @param x the x coordinate of the text
     * @param y the y coordinate of the text
     */
    public void getText(Stage stage, ProWindow window, double x, double y) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));
        final TextField text = new TextField();
        text.setPromptText("Text");
        Button enterButton = new Button("Enter");
        grid.add(new Label( "Text:"), 0, 0);
        grid.add(text, 1, 0);
        grid.add(enterButton, 1, 1);
        Scene newScene = new Scene(grid);
        stage.setScene(newScene);
        stage.show();

        enterButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                window.graphicsContext.setFill(cp.getValue());
                window.graphicsContext.fillText(text.getText(), x, y);
                stage.hide();
            }
        });

    }
}
// Oracle Class for getting extension of a file for saving.
class Checker {
    /*
     * Get the extension of a file.
     */
    public String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}
