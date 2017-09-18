package geometry.objects;

import javafx.application.Platform;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;

import static geometry.Main.H;
import static geometry.Main.W;

public class MyTriangle extends MyObject {
    private Polygon triangle;
    private double a;
    private double x1, x2, x3, y1, y2, y3;

    public MyTriangle(int radius) {
        super(radius);
    }

    @Override
    protected void setShape(){
        super.setShape();
        setPoints();
        triangle = new Polygon(x1,y1,x2,y2,x3,y3);
        triangle.setFill(Paint.valueOf(color));
    }

    private void setPoints(){
        a = 2*Math.sqrt(3)*radius;
        x1 = x;
        y1 = y - a/Math.sqrt(3);
        x2 = x - a/2;
        y2 = y + radius;
        x3 = x + a/2;
        y3 = y + radius;
    }

    public void move(){
        x+=vX;
        y+=vY;

        if (x+vX + a/Math.sqrt(3) >= W || x+vX - a/Math.sqrt(3) <= 200)
            vX = - vX;
        if (y+vY + a/Math.sqrt(3) >= H || y+vY - a/Math.sqrt(3) <= 0)
            vY = - vY;

        setPoints();
        Platform.runLater(()->{
            triangle.getPoints().clear();
            triangle.getPoints().addAll(
                        x1, y1,
                        x2, y2,
                        x3, y3 );
        });
    }

    @Override
    public Polygon getShape() {
        return triangle;
    }
}
