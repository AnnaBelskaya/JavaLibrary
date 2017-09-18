package geometry.userinterface;
import geometry.Main;
import geometry.objects.MyCircle;
import geometry.objects.MyObject;
import geometry.objects.MyRectangle;
import geometry.objects.MyTriangle;

import java.util.Random;

public class UserActions extends BasicInterface {
    private Random r = new Random();
    private MyObject[] shapes = new MyObject[0];

    public UserActions() {
        super();
        setActions();
    }

    private void setActions(){
        generateCircles();

        draw_circles.setOnAction(event -> {
            generateCircles();
            single_thread.setDisable(false);
            multy_threads.setDisable(false);
            optimal_thread.setDisable(false);
        });

        draw_rectangles.setOnAction(event -> {
            generateRectangles();
            single_thread.setDisable(false);
            multy_threads.setDisable(false);
            optimal_thread.setDisable(false);
        });

        draw_triangles.setOnAction(event -> {
            generateTriangles();
            single_thread.setDisable(false);
            multy_threads.setDisable(false);
            optimal_thread.setDisable(false);
        });

        stop_movement.setOnAction(event -> {
            Main.isActive = false;
            single_thread.setDisable(false);
            multy_threads.setDisable(false);
            optimal_thread.setDisable(false);
        });

        single_thread.setOnAction(event -> {
            Main.isActive = true;
            Multithreading.singleThread(shapes);
            single_thread.setDisable(true);
            multy_threads.setDisable(true);
            optimal_thread.setDisable(true);
        });

        multy_threads.setOnAction(event -> {
            Main.isActive = true;
            Multithreading.multiThread(shapes);
            single_thread.setDisable(true);
            multy_threads.setDisable(true);
            optimal_thread.setDisable(true);
        });

        optimal_thread.setOnAction(event -> {
            Main.isActive = true;
            try {
                Multithreading.optimalThread(shapes);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            single_thread.setDisable(true);
            multy_threads.setDisable(true);
            optimal_thread.setDisable(true);
        });
    }

    private int getNumber(String min, String max){
        clear();
        return generateAmount(min, max,10,3);
    }

    private void generateTriangles(){
        shapes = new MyTriangle[getNumber(minTrianglesNumber.getText(),
                maxTrianglesNumber.getText())];
        for (int i = 0; i < shapes.length; i++){
            int radius = generateAmount(minR.getText(), maxR.getText(), 40, 10);
            shapes[i] = new MyTriangle(radius);
            Main.root.getChildren().add(shapes[i].getShape());
        }
    }

    private void generateCircles() {
        shapes = new MyCircle[getNumber(minCirclesNumber.getText(),
                maxCirclesNumber.getText())];
        for (int i = 0; i < shapes.length; i++){
            int radius = generateAmount(minR.getText(), maxR.getText(), 40, 10);
            shapes[i] = new MyCircle(radius);
            Main.root.getChildren().add(shapes[i].getShape());
        }
    }

    private void generateRectangles() {
        shapes = new MyRectangle[getNumber(minTrianglesNumber.getText(),
                maxTrianglesNumber.getText())];
        for (int i = 0; i < shapes.length; i++){
            int width = generateAmount(minW.getText(),
                    maxW.getText(), 40, 100);
            int height = generateAmount(minW.getText(),
                    maxW.getText(), 40, 100);
            shapes[i] = new MyRectangle(width,height);
            Main.root.getChildren().add(shapes[i].getShape());
        }
    }

    private int generateAmount(String min, String max, int a, int b){
        int number = r.nextInt(a) + b;
        if (!min.equals("") && !max.equals("")) {
            if (Integer.parseInt(min) < Integer.parseInt(max)) {
                number = r.nextInt(Integer.parseInt(max) -
                        Integer.parseInt(min) + 1) + Integer.parseInt(min);
            }
        }
        return number;
    }

    private void clear(){
        if (shapes.length != 0)
            for (int i = 0; i < shapes.length; i++)
                Main.root.getChildren().remove(shapes[i].getShape());
    }
}