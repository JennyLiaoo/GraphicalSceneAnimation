import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.*;
import java.util.ArrayList;
public class ArrayTest extends ProcessingFX {
    public static void main(String[] args) {
        launch(args);
    }
   ArrayList<Dot> test;
   double spd = 0;
    public void setup(GraphicsContext pen) {
        test = new ArrayList<Dot>();
        Dice numDot = new Dice (20, 40);
            for(int i = 0; i < numDot.getValue(); i++) {
            Dice a = new Dice(40, 400);
            Dice b = new Dice(60, 440);
            Dice x = new Dice(20, 40);
            Dot d = new Dot(a.getValue(), b.getValue(), Color.RED, x.getValue());
            d.draw(pen);
            test.add(d);
        }
        
            
    }

    public void draw(GraphicsContext pen) {
        
        pen.clearRect(0, 0, window.getWidth(), window.getHeight());
        matrix.push();
            //translates the origin to a different place
            matrix.translate(500,300);
            matrix.rotate(spd);
            Dot d1 = new Dot(180, 180, Color.YELLOW, 80);
            d1.draw(pen);
            
                
            Dot d2 = new Dot(-260, -260, Color.RED, 80);
            d2.draw(pen);
            

        matrix.pop();
        spd++;
        for (int c = 0; c < test.size(); c++){
            Dot e = test.get(c);
            e.draw(pen);
            
            }
    
        
    
}
}