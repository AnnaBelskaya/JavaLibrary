package geometry.objects;

import geometry.Main;
import javafx.application.Platform;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class MyRectangle extends MyObject{
    private Rectangle rectangle;

    public MyRectangle(int width, int height) {
        super(width, height);
    }

    @Override
    protected void setShape() {
        super.setShape();
        rectangle = new Rectangle(x, y, width, height);
        rectangle.setFill(Paint.valueOf(color));
    }

    public void move(){
        x += vX;
        y += vY;

        if (x + vX + width >= Main.W || x <= 205)
            vX = -vX;
        if (y + vY + height + 5 >= Main.H || y <= 0)
            vY = -vY;

        Platform.runLater(() -> {
            rectangle.setX(x);
            rectangle.setY(y);
        });
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

    @Override
    public Rectangle getShape(){
        return rectangle;
    }
}
