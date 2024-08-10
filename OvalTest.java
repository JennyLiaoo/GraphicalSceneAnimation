import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;
public class OvalTest extends ProcessingFX {
    
    public static void main(String[] args) {
        launch(args);
    }
         ArrayList<Oval> rainyClouds;
    public void setup(GraphicsContext pen) {
            window.setBackground(Color.BLACK);
     
            rainyClouds = new ArrayList<Oval>();
        Dice genNumRainyClouds = new Dice(5, 8);
            for (int numRainCloud = 0; numRainCloud < genNumRainyClouds.getValue(); numRainCloud++) {
            Dice puffX = new Dice(0, 1200);
            Dice puffY = new Dice (100, 200);
                   Oval tester = new Oval(puffX.getValue(), puffY.getValue(), Color.WHITE);
                   tester.draw(pen);
             
                rainyClouds.add(tester);
              
           }
        
    }
    
    public void draw(GraphicsContext pen) {
        
       pen.clearRect(0, 0, window.getWidth(), window.getHeight());
         
            for (int k = 0; k < rainyClouds.size(); k++){
                        Oval b1 = rainyClouds.get(k);
                        b1.draw(pen);
                        }
        
                     
            
            
    }
    
    
    
   
}