import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Demo extends ProcessingFX {
    public static void main(String[] args) {
        launch(args);
    }

    public void setup(GraphicsContext pen) { 
        //pen is what you use to draw, pen is part of the GraphicsContext
        //change color, all caps
        pen.setStroke(Color.BLACK);
        //change the fill
        pen.setFill(Color.RED);
        //change stroke width
        //pen.StokeWidth
        
        //*origin is at top left corner, (0,0), x is to the right, as y increases you move down
        // (x, y, width, height), can do math in the parameters
        pen.strokeLine(0,0, 100, 300);
        pen.fillOval(75, 300, 50, 50);
        pen.strokeOval(75, 300, 50, 50);
    }

    public void draw(GraphicsContext pen) {

    }
}
