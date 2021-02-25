package sample1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class RightMenu extends GridPane {

    public RightMenu(EasyWindow window) {
        Stage primaryStage = window.stage;

        this.setPadding(new Insets(10, 15, 10, 12));
        //this.setSpacing(20);

        Label label1 = new Label("make");
        label1.setTextFill(Color.GREY);

        

        Button handDrawBtn = new Button("Hand Draw");
        handDrawBtn.setTranslateX(window.x - 150);
        handDrawBtn.setTranslateY(30);
        handDrawBtn.setPrefSize(100, 100);
        handDrawBtn.setUserData("Hand Draw");
        handDrawBtn.setTooltip(new Tooltip("Click and drag to draw"));

        handDrawBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Hand Draw");
                window.canvas.setOnMouseDragged((event) -> {
                    makeHandDraw(primaryStage, window, event.getX(), event.getY());
                });
            }
        });

        Button eraseBtn = new Button("Erase");
        eraseBtn.setTranslateX(window.x-150);
        eraseBtn.setTranslateY(30);
        eraseBtn.setPrefSize(100, 100);
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
        moveBtn.setTranslateX(window.x-150);
        moveBtn.setTranslateY(30);
        moveBtn.setPrefSize(100, 100);
        moveBtn.setUserData("Move");
        moveBtn.setTooltip(new Tooltip("Click and drag to move objects"));

        moveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Move");
            }
        });

        Button lineBtn = new Button("Line");
        lineBtn.setTranslateX(window.x-150);
        lineBtn.setTranslateY(30);
        lineBtn.setPrefSize(100, 100);
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
        textBtn.setTranslateX(window.x - 150);
        textBtn.setTranslateY(30);
        textBtn.setPrefSize(100, 100);
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

        Button rectangleBtn = new Button("rectangle");
        rectangleBtn.setTranslateX(window.x - 150);
        rectangleBtn.setTranslateY(30);
        rectangleBtn.setPrefSize(100, 100);
        rectangleBtn.setUserData("rectangle");
        rectangleBtn.setTooltip(new Tooltip("Click to define the corners of a rectangle"));
        rectangleBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Rectangle");
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

        Button circleBtn = new Button("Circle");
        circleBtn.setTranslateX(window.x - 150);
        circleBtn.setTranslateY(30);
        circleBtn.setPrefSize(100, 100);
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
                    window.graphicsContext.setFill(window.cp.getValue());
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
            }
        });

        Button curveBtn = new Button("Curve");
        curveBtn.setTranslateX(window.x - 150);
        curveBtn.setTranslateY(30);
        curveBtn.setPrefSize(100, 100);
        curveBtn.setUserData("Circle");
        curveBtn.setTooltip(new Tooltip("Create a curve where you click"));
        curveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Curve");
            }
        });

        Button undoBtn = new Button("Undo");
        undoBtn.setPrefSize(100, 100);
        undoBtn.setUserData("Undo");
        undoBtn.setTooltip(new Tooltip("Click to undo most recent change"));

        undoBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Undo");
                try {
                    if (!window.task.isEmpty()) {
                        //window.task.removeLast();
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
        redoBtn.setPrefSize(100, 100);
        redoBtn.setUserData("Undo");
        redoBtn.setTooltip(new Tooltip("Click to redo the thing you just undid"));

        redoBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Redo");
            }
        });

        Button doneBtn = new Button("Done");
        doneBtn.setPrefSize(100, 100);
        doneBtn.setUserData("Done");
        doneBtn.setTooltip(new Tooltip("Click to save your work"));

        doneBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Saved");
            }
        });

        Button changeToolBtn = new Button("Change Tool");
        changeToolBtn.setPrefSize(100, 100);
        changeToolBtn.setUserData("Change Tool");
        changeToolBtn.setTooltip(new Tooltip("Click to change drawing style"));
        changeToolBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                final Stage changeTool = new Stage();
                changeTool.initModality(Modality.APPLICATION_MODAL);
                changeTool.initOwner(primaryStage);
                GridPane changeToolGridPane = new GridPane();
                changeToolGridPane.prefHeight(200);
                changeToolGridPane.prefWidth(400);

                // Set up new buttons that lead to their original
                Button localMoveBtn = new Button("Move");
                localMoveBtn.setPrefSize(100, 100);
                localMoveBtn.setUserData("Move");
                localMoveBtn.setTooltip(new Tooltip("Click and drag to move objects"));
                localMoveBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (!window.root.getChildren().contains(moveBtn)) {
                            window.root.getChildren().set(3, moveBtn);
                            changeTool.close();
                        }
                    }
                });

                Button localEraseBtn = new Button("Erase");
                localEraseBtn.setPrefSize(100, 100);
                localEraseBtn.setUserData("Erase");
                localEraseBtn.setTooltip(new Tooltip("Click and drag to erase"));
                localEraseBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (!window.root.getChildren().contains(eraseBtn)) {
                            window.root.getChildren().set(3, eraseBtn);
                            changeTool.close();
                        }
                    }
                });

                Button localHandDrawBtn = new Button("Hand Draw");
                localHandDrawBtn.setPrefSize(100, 100);
                localHandDrawBtn.setUserData("Hand Draw");
                localHandDrawBtn.setTooltip(new Tooltip("Click and drag to draw"));
                localHandDrawBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (!window.root.getChildren().contains(handDrawBtn)) {
                            window.root.getChildren().set(3, handDrawBtn);
                            changeTool.close();
                        }
                    }
                });

                Button localLineBtn = new Button("Line");
                localLineBtn.setPrefSize(100, 100);
                localLineBtn.setUserData("Line");
                localLineBtn.setTooltip(new Tooltip("Click on start point and then on end point to create"));
                localLineBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (!window.root.getChildren().contains(lineBtn)) {
                            window.root.getChildren().set(3, lineBtn);
                            changeTool.close();
                        }
                    }
                });

                Button localTextBtn = new Button("Text");
                localTextBtn.setPrefSize(100, 100);
                localTextBtn.setUserData("Text");
                localTextBtn.setTooltip(new Tooltip("Click to add text"));
                localTextBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (!window.root.getChildren().contains(textBtn)) {
                            window.root.getChildren().set(3, textBtn);
                            changeTool.close();
                        }
                    }
                });

                Button localRectangleBtn = new Button("Rectangle");
                localRectangleBtn.setPrefSize(100, 100);
                localRectangleBtn.setUserData("Rectangle");
                localRectangleBtn.setTooltip(new Tooltip("Click to define the corners of a rectangle"));
                localRectangleBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (!window.root.getChildren().contains(rectangleBtn)) {
                            window.root.getChildren().set(3, rectangleBtn);
                            changeTool.close();
                        }
                    }
                });

                Button localCircleBtn = new Button("Circle");
                localCircleBtn.setPrefSize(100, 100);
                localCircleBtn.setUserData("Circle");
                localCircleBtn.setTooltip(new Tooltip("Create a circle around where you clicked"));
                localCircleBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (!window.root.getChildren().contains(circleBtn)) {
                            window.root.getChildren().set(3, circleBtn);
                            changeTool.close();
                        }
                    }
                });

                Button localCurveBtn = new Button("Curve");
                localCurveBtn.setPrefSize(100, 100);
                localCurveBtn.setUserData("Curve");
                localCurveBtn.setTooltip(new Tooltip("Create a curve where you click"));
                localCurveBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (!window.root.getChildren().contains(curveBtn)) {
                            window.root.getChildren().set(3, curveBtn);
                            changeTool.close();
                        }
                    }
                });

                changeToolGridPane.add(localMoveBtn, 0, 0, 1, 1);
                changeToolGridPane.add(localHandDrawBtn, 1, 0, 1, 1);
                changeToolGridPane.add(localEraseBtn, 2, 0, 1, 1);
                changeToolGridPane.add(localLineBtn, 3, 0, 1, 1);
                changeToolGridPane.add(localTextBtn, 0, 1, 1, 1);
                changeToolGridPane.add(localRectangleBtn, 1, 1, 1, 1);
                changeToolGridPane.add(localCircleBtn, 2, 1, 1, 1);
                changeToolGridPane.add(localCurveBtn, 3, 1, 1, 1);

                Scene changeToolScene = new Scene(changeToolGridPane, 300, 200);
                changeTool.setScene(changeToolScene);
                changeTool.show();
            }
        });

        this.add(changeToolBtn, 0, 1, 1, 1);
        this.add(doneBtn, 1, 1, 1, 1);
        this.add(undoBtn, 0, 2, 1, 1);
        this.add(redoBtn, 1, 2, 1, 1);
    }

    public void makeHandDraw(Stage stage, EasyWindow window, double x, double y) {
        final WritableImage[] addedImg = {new WritableImage(window.x - 200, window.y)};
        window.graphicsContext.setFill(window.cp.getValue());
        window.graphicsContext.setLineWidth(window.slider.getValue());
        window.graphicsContext.setStroke(window.cp.getValue());
        window.graphicsContext.lineTo(x, y);
        window.graphicsContext.stroke();
        window.canvas.setOnMouseReleased((e) -> {
            addedImg[0] = new WritableImage(window.x - 200, window.y);
            addedImg[0] = window.canvas.snapshot(null, addedImg[0]);
            window.task.add(addedImg[0]);
            window.canvas.disableProperty();
        });

        window.canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                window.graphicsContext.beginPath();
                makeHandDraw(stage, window, mouseEvent.getX(), mouseEvent.getY());
                window.graphicsContext.closePath();
            }
        });
    }

    public void makeErase(Stage stage, EasyWindow window, double x, double y) {
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
    public void makeLine(Stage stage, EasyWindow window, double startX, double startY) {
        window.graphicsContext.closePath();
        window.canvas.requestFocus();
        final WritableImage[] addedImg = {new WritableImage(window.x - 200, window.y)};
        //window.graphicsContext.beginPath();
        window.graphicsContext.setStroke(window.cp.getValue());

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
    public void makeRectangle(Stage stage, EasyWindow window, double firstX, double firstY) {
        window.graphicsContext.beginPath();
        window.canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                window.graphicsContext.setFill(window.cp.getValue());
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
    public void getText(Stage stage, EasyWindow window, double x, double y) {
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
                window.graphicsContext.setFill(window.cp.getValue());
                window.graphicsContext.fillText(text.getText(), x, y);
                stage.hide();
            }
        });

    }
}
