package geometry.objects;

import geometry.Main;
import javafx.application.Platform;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class MyCircle extends MyObject {
    private Circle circle;

    public MyCircle(int radius) {
        super(radius);
    }

    @Override
    protected void setShape(){
        super.setShape();
        circle = new Circle(radius);
        circle.setFill(Paint.valueOf(color));
        circle.setTranslateX(x);
        circle.setTranslateY(y);
    }

    public void move(){
        x += vX;
        y += vY;

        if (x + vX + radius >= Main.W  || x + vX - 200 <= radius)
            vX = -vX;
        if (y + vY + radius - 10 >= Main.H  || y + vY  <= radius)
            vY = -vY;

        Platform.runLater(() -> {
            circle.setTranslateX(x);
            circle.setTranslateY(y);
        });
    }

    @Override
    public Circle getShape() {
        return circle;
    }
}