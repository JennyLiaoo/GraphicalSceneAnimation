
/**
 * This used to be a cloud class, it is now unused in my actual project
 *
 * @author Jenny
 * @version Jan 29 2023
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Clouds
{
   Color colorStroke;
   Color colorFill;
   int x;
   int y;
   int wid;
   int high;
   int numCloudPuffs;

   public Clouds(int theX1, int theY1, Color c, Color f){
       //attributes of the rectangle
       x = theX1;
       y = theY1;       
       colorStroke = c;
       colorFill = f;
       //randomized size of puffs
       Dice w = new Dice(90, 140);
       wid = w.getValue();
       Dice h = new Dice(30, 85);
       high = h.getValue();
       Dice numPuffs = new Dice(4,7);
       numCloudPuffs = numPuffs.getValue();
        
   }
   public void draw(GraphicsContext pen, Matrix matrix) {       //attempting at using the matrix
        matrix.push();
            //matrix.translate(x, y);
            //matrix.rotate(180);
            pen.setStroke(colorStroke);
            pen.setFill(colorFill);
            //pen.fillOval(x, y, width, height);
            int x2 = x; 
            for(int numPuff = 0; numPuff <= numCloudPuffs; numPuff++) {
                pen.fillOval(x2, y, wid, high);  
                    
                x2 = x2 + wid/3;
            }
        matrix.pop();
   }
}

