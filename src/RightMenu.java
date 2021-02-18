import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class RightMenu extends GridPane {

    public RightMenu(Window window) {
        Stage primaryStage = window.stage;
        this.setPadding(new Insets(10, 15, 10, 12));
        //this.setSpacing(20);

        Label label1 = new Label("make");
        label1.setTextFill(Color.WHITE);

        Button handDrawBtn = new Button("Hand Draw");
        handDrawBtn.setPrefSize(100, 100);
        handDrawBtn.setUserData("Hand Draw");
        handDrawBtn.setTooltip(new Tooltip("Click and drag to draw"));

        handDrawBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Hand Draw");
            }
        });
        Button eraseBtn = new Button("Erase");
        eraseBtn.setPrefSize(100, 100);
        eraseBtn.setUserData("Erase");
        eraseBtn.setTooltip(new Tooltip("Click and drag to erase"));

        eraseBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Erase");
            }
        });

        Button moveBtn = new Button("Move");
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
        lineBtn.setPrefSize(100, 100);
        lineBtn.setUserData("Line");
        lineBtn.setTooltip(new Tooltip("Click on start point and then on end point to create"));
        lineBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Line");
            }
        });

        Button textBtn = new Button("Text");
        textBtn.setPrefSize(100, 100);
        textBtn.setUserData("Line");
        textBtn.setTooltip(new Tooltip("Click to add text"));
        textBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Text");
            }
        });

        Button rectangleBtn = new Button("rectangle");
        rectangleBtn.setPrefSize(100, 100);
        rectangleBtn.setUserData("rectangle");
        rectangleBtn.setTooltip(new Tooltip("Click to define the corners of a rectangle"));
        rectangleBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Rectangle");
            }
        });

        Button circleBtn = new Button("Circle");
        circleBtn.setPrefSize(100, 100);
        circleBtn.setUserData("Circle");
        circleBtn.setTooltip(new Tooltip("Create a circle around where you clicked"));
        circleBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Circle");
            }
        });

        Button curveBtn = new Button("Curve");
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
                        if (!getChildren().contains(moveBtn)) {
                            getChildren().set(0, moveBtn);
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
                        if (!getChildren().contains(eraseBtn)) {
                            getChildren().set(0, eraseBtn);
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
                        if (!getChildren().contains(handDrawBtn)) {
                            getChildren().set(0, handDrawBtn);
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
                        if (!getChildren().contains(lineBtn)) {
                            getChildren().set(0, lineBtn);
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
                        if (!getChildren().contains(textBtn)) {
                            getChildren().set(0, textBtn);
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
                        if (!getChildren().contains(rectangleBtn)) {
                            getChildren().set(0, rectangleBtn);
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
                        if (!getChildren().contains(circleBtn)) {
                            getChildren().set(0, circleBtn);
                        }
                    }
                });

                Button localCurveBtn = new Button("Curve");
                localCurveBtn.setPrefSize(100, 100);
                localCurveBtn.setUserData("Curve");
                localCurveBtn.setTooltip(new Tooltip("Createt a curve where you click"));
                localCurveBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (!getChildren().contains(curveBtn)) {
                            getChildren().set(0, curveBtn);
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

        this.add(moveBtn, 0, 0, 1, 1);
        this.add(changeToolBtn, 0, 1, 1, 1);
        this.add(doneBtn, 1, 1, 1, 1);
        this.add(undoBtn, 0, 2, 1, 1);
        this.add(redoBtn, 1, 2, 1, 1);
    }
}
