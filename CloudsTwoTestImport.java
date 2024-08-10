import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;
public class CloudsTwoTestImport extends ProcessingFX {
    public static void main(String[] args) {
        launch(args);
    }
       ArrayList<Oval> tester;
    double y = 0;
    public void setup(GraphicsContext pen) {
        
        window.setBackground(Color.BLACK);
        tester = new ArrayList<Oval>();
            
        Dice genNumRainyClouds = new Dice(5, 8);
        Dice genNumPuff = new Dice(4,7);
            for (int numRainCloud = 0; numRainCloud < genNumRainyClouds.getValue(); numRainCloud++) { //draws the clouds
             //DRAW OVAL
            Dice firstOvalX = new Dice(0, 1200);    //randomize x value
            int x2 = firstOvalX.getValue();             //saves x2 value so that it can be changed in the next for loop
            Dice firstOvalY = new Dice(0, 600);
            int y = firstOvalY.getValue();
                for(int numCloud = 0; numCloud <= genNumPuff.getValue(); numCloud++) { //draws the ovals
                    
                        Oval test = new Oval(x2, y, Color.WHITE);
                        test.draw(pen);     
                        
                        tester.add(test);
                        
                        x2 = x2 + 40; //around 1/3 of the cloud width
                }
                
           }
        
            
    }

    public void draw(GraphicsContext pen) {
        
       pen.clearRect(0, 0, window.getWidth(), window.getHeight());
          matrix.push();
                    matrix.translate(1200, 600);
                    matrix.rotate(180);
                   for (int k = 0; k < tester.size(); k++){
                    Oval b1 = tester.get(k);
                    b1.draw(pen);
                    }
            
             matrix.pop();
             
            
    }
    
  
}