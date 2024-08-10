import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RectangleTest extends ProcessingFX {
    public static void main(String[] args) {
        launch(args);
    }

    public void setup(GraphicsContext pen) {
        window.setBackground(Color.BLACK);
        int x = 50;
        int y = 300;
        Dice h = new Dice(4, 10);
        Dice w = new Dice(4, 10);
       
        int windowDistance = 10;
        int windowHeight = 10;
        int windowWidth = 10;
        
        Rectangle r1 = new Rectangle(x, y, h.getValue() * 20 + 10, w.getValue() * 20 + 10, Color.GREY, Color.GREY, windowHeight, windowWidth, windowDistance, Color.WHITE, Color.WHITE);
        r1.draw(pen);
        
        
        /*
        for (int i = 0; i < 10; i++) {
           Dice x = new Dice(0, 600);
           Dice y = new Dice(0, 600);
           Dice height = new Dice(0,200);
           Dice width = new Dice(0, 100);
           
           Rectangle r2 = new Rectangle(x.getValue(), y.getValue(), height.getValue(), width.getValue(), Color.BLACK, Color.BLACK);
           r2.draw(pen);
           
       }
       */
    }

    public void draw(GraphicsContext pen) {

    }
}