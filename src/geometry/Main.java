package geometry;

import geometry.objects.MyTriangle;
import geometry.userinterface.UserActions;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
    public static boolean isActive = true;
    public static Pane root;
    public static final int W = 800;
    public static final int H = 500;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new Pane();
        root.setStyle("-fx-background: #FAEBD7;");
        Scene scene = new Scene(root,W,H);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Main");
        primaryStage.show();

        new UserActions();
    }
    @Override
    public void stop() throws Exception {
        isActive = false;
        super.stop();
    }
}
