
/**
 * This is another cloud class just to test out more things
 *
 * @author Jenny
 * @version Jan 31 2023
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class CloudsTwo
{               
   int x;
   int y;
   int numCloudGen;
   public CloudsTwo(int theX1, int theY1){
       //attributes of the rectangle
       x = theX1;
       y = theY1;
       Dice genNumCloud = new Dice(4, 7);
       numCloudGen = genNumCloud.getValue();
   }
   public void draw(GraphicsContext pen) {      //draw the ovals
        int x2 = x;
        for(int numCloud = 0; numCloud <= numCloudGen; numCloud++) {
                    Oval test = new Oval(x2, y, Color.WHITE);
                    test.draw(pen);                
                    x2 = x2 + 40; //around 1/3 of the cloud width
        }
   }
}

