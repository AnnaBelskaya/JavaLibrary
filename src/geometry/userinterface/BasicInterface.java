package geometry.userinterface;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import geometry.Main;
import javafx.geometry.Orientation;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public abstract class BasicInterface {
    protected JFXButton draw_circles = new JFXButton("Draw circles");
    protected JFXButton draw_rectangles = new JFXButton("Draw rectangles");
    protected JFXButton draw_triangles = new JFXButton("Draw triangles");
    protected JFXButton stop_movement = new JFXButton("Stop");
    protected JFXButton single_thread= new JFXButton("Single Thread");
    protected JFXButton optimal_thread= new JFXButton("Optimal Thread");
    protected JFXButton multy_threads= new JFXButton("Multy Threads");
    protected JFXTextField minW = new JFXTextField();
    protected JFXTextField maxW = new JFXTextField();
    protected JFXTextField minH = new JFXTextField();
    protected JFXTextField maxH = new JFXTextField();
    protected JFXTextField maxR = new JFXTextField();
    protected JFXTextField minR = new JFXTextField();
    protected JFXTextField minNumber = new JFXTextField();
    protected JFXTextField maxNumber = new JFXTextField();
    protected JFXTextField minCirclesNumber = new JFXTextField();
    protected JFXTextField maxCirclesNumber = new JFXTextField();
    protected JFXTextField minTrianglesNumber = new JFXTextField();
    protected JFXTextField maxTrianglesNumber = new JFXTextField();

    public BasicInterface() {
        drawInterface();
    }

    protected void drawInterface() {

        //---------------------RECTANGLE---------------------

        draw_rectangles.setStyle("-fx-font-size: 13.0px;" +
                "-fx-background-color: #0D58A6;" +
                "-fx-text-fill: #FFFFFF;");
        draw_rectangles.setMinWidth(190);

        minNumber.setPromptText("Min number");
        minNumber.setMaxWidth(80);
        minNumber.setLabelFloat(true);

        maxNumber.setPromptText("Max number");
        maxNumber.setMaxWidth(80);
        maxNumber.setLabelFloat(true);

        HBox numberBox = new HBox(minNumber, maxNumber);
        numberBox.setSpacing(10);

        minW.setPromptText("Min width");
        minW.setMaxWidth(80);
        minW.setLabelFloat(true);

        maxW.setPromptText("Max width");
        maxW.setMaxWidth(80);
        maxW.setLabelFloat(true);

        HBox widthBox = new HBox(minW, maxW);
        widthBox.setSpacing(10);

        minH.setPromptText("Min height");
        minH.setMaxWidth(80);
        minH.setLabelFloat(true);

        maxH.setPromptText("Max height");
        maxH.setMaxWidth(80);
        maxH.setLabelFloat(true);

        HBox heightBox = new HBox(minH, maxH);
        heightBox.setSpacing(10);

        //---------------------CIRCLE---------------------

        draw_circles.setStyle("-fx-font-size: 13.0px;" +
                "-fx-background-color: #0D58A6;" +
                "-fx-text-fill: #FFFFFF;");
        draw_circles.setMinWidth(190);

        minCirclesNumber.setPromptText("Min number");
        minCirclesNumber.setMaxWidth(80);
        minCirclesNumber.setLabelFloat(true);

        maxCirclesNumber.setPromptText("Max number");
        maxCirclesNumber.setMaxWidth(80);
        maxCirclesNumber.setLabelFloat(true);

        HBox circlesNumberBox = new HBox(minCirclesNumber, maxCirclesNumber);
        circlesNumberBox.setSpacing(15);

        minR.setPromptText("Min radius");
        minR.setMaxWidth(80);
        minR.setLabelFloat(true);

        maxR.setPromptText("Max radius");
        maxR.setMaxWidth(80);
        maxR.setLabelFloat(true);

        HBox circleRadiusBox = new HBox(minR, maxR);
        circleRadiusBox.setSpacing(15);

        VBox circleVBox = new VBox(circlesNumberBox, circleRadiusBox,
                draw_circles);
        circleVBox.setSpacing(15);

        //---------------------TRIANGLES---------------------

        draw_triangles.setStyle("-fx-font-size: 13.0px;" +
                "-fx-background-color: #0D58A6;" +
                "-fx-text-fill: #FFFFFF;");
        draw_triangles.setMinWidth(190);

        minTrianglesNumber.setPromptText("Min number");
        minTrianglesNumber.setMaxWidth(80);
        minTrianglesNumber.setLabelFloat(true);

        maxTrianglesNumber.setPromptText("Max number");
        maxTrianglesNumber.setMaxWidth(80);
        maxTrianglesNumber.setLabelFloat(true);

        HBox trianglesNumberBox = new HBox(minTrianglesNumber, maxTrianglesNumber);
        trianglesNumberBox.setSpacing(15);

        VBox trianglesVBox = new VBox(trianglesNumberBox,
                draw_triangles);
        trianglesVBox.setSpacing(15);

        //---------------------THREADS---------------------
        multy_threads.setStyle("-fx-font-size: 12.0px;" +
                "-fx-border-color: #FFFFFF70;");
        multy_threads.setMinWidth(60);

        single_thread.setStyle("-fx-font-size: 12.0px;" +
                "-fx-border-color: #FFFFFF70;");
        single_thread.setMinWidth(60);

        optimal_thread.setStyle("-fx-font-size: 12.0px;" +
                "-fx-border-color: #FFFFFF70;");
        optimal_thread.setMinWidth(60);

        stop_movement.setStyle("-fx-font-size: 12.0px;" +
                "-fx-border-color: #FFFFFF70;");
        stop_movement.setMinWidth(60);

        HBox buttonsBox = new HBox(multy_threads, single_thread);
        buttonsBox.setSpacing(10);

        HBox buttonsBox2 = new HBox(optimal_thread, stop_movement);
        buttonsBox2.setSpacing(10);

        VBox rectangleBox = new VBox( widthBox,
                heightBox, numberBox, draw_rectangles);
        rectangleBox.setSpacing(15);

        VBox vBox = new VBox(buttonsBox, buttonsBox2, circleVBox, rectangleBox,
                trianglesVBox);
        vBox.setTranslateX(5);
        vBox.setTranslateY(10);
        vBox.setSpacing(20);

        Separator separator = new Separator(Orientation.VERTICAL);
        separator.setTranslateX(200);
        separator.setMinHeight(Main.H);

        Main.root.getChildren().addAll(vBox, separator);
    }
}