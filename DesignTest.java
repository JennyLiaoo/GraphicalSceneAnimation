import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class DesignTest extends ProcessingFX {
    public static void main(String[] args) {
        launch(args);
    }

    public void setup(GraphicsContext pen) {
        /*
        pen.setStroke(Color.rgb(44, 67, 112));
        pen.setLineWidth(2);
        pen.strokeOval(400, 200, 80, 100);
        //pen.setFill(Color.rgb(79, 104, 152));
        */
        pen.strokeArc(50, 50, 80, 80, 180, 80*Math.PI, ArcType.OPEN);
        
        
    }

    public void draw(GraphicsContext pen) {

    }
}
