package geometry.objects;

import geometry.Main;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.Random;

public abstract class MyObject {
    protected Random r = new Random();
    protected String color;
    protected double x, y;
    protected int vX, vY;
    protected int radius, width, height;

    public MyObject(int radius) {
        this.radius = radius;
        setShape();
    }

    public MyObject(int width, int height) {
        this.width = width;
        this.height = height;
        setShape();
    }

    protected void setShape(){
        color = Color.color(
                r.nextDouble(),
                r.nextDouble(),
                r.nextDouble()).toString();
        x = r.nextInt(400) + 300;
        y = r.nextInt(210) + 100;
        vX = r.nextInt(7) + 1;
        vY = r.nextInt(7) + 1;
    }

    public void action() {
        while (Main.isActive) {
            move();
            try {
                Thread.sleep(r.nextInt(30) + 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() { }

    public Shape getShape(){
        return null;
    }
}
