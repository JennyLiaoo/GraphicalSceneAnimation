import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;
public class CloudsTest extends ProcessingFX {
    
    public static void main(String[] args) {
        launch(args);
    }
       ArrayList<Clouds> test;
    double y = 0;
    public void setup(GraphicsContext pen) {
            window.setBackground(Color.BLACK);
        test = new ArrayList<Clouds>();
            
        Dice genNumRainyClouds = new Dice(5, 8);
            for (int numRainCloud = 0; numRainCloud < genNumRainyClouds.getValue(); numRainCloud++) {
            Dice puffLocationX = new Dice(0, 1200);
            Dice puffLocationY = new Dice (100, 200);
                   Clouds tester = new Clouds(puffLocationX.getValue(), puffLocationY.getValue(), Color.WHITE, Color.WHITE);
                   tester.draw(pen, matrix);
             
                test.add(tester);
              
           }
        
    }
    
    public void draw(GraphicsContext pen) {
        
       pen.clearRect(0, 0, window.getWidth(), window.getHeight());
          matrix.push();
                    matrix.translate(1200, 600);
                    matrix.rotate(180);
                       for (int k = 0; k < test.size(); k++){
                        Clouds b1 = test.get(k);
                        b1.draw(pen, matrix);
                        }
            matrix.pop();
                        
            
            
    }
    
    
    
    public void drawGrid(GraphicsContext pen) {
        pen.setLineWidth(2);
        for(int i = 0; i < window.getWidth(); i += 25) {
            pen.strokeLine(i, 0, i, window.getHeight());
        }
        for(int i = 0; i < window.getWidth(); i += 25) {
            pen.strokeLine(0, i, window.getWidth(), i);
        }
        pen.fillText("X-axis", 50, -10);
        matrix.push();
            matrix.rotate(90);
            pen.fillText("Y-axis", 50, 20);
        matrix.pop();
    }
}