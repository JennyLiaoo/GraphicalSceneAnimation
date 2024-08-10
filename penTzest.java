import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class penTzest extends ProcessingFX {
    public static void main(String[] args) {
        launch(args);
    }

    public void setup(GraphicsContext pen) {
        
       
            
            Shine r1 = new Shine(100, 100, 10, Color.BLACK);
            r1.draw(pen);
           
       
        
    }

    public void draw(GraphicsContext pen) {
        
    }
}
