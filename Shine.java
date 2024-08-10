
/**
 * This is a star class
 *
 * @author Jenny
 * @version Jan 29 2023
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Shine
{
   Color colorFill;
   int size;
   int sizeCounter;     //tracks the size of the stars when they get animated
   int x1;
   int y1;
   
   public Shine(int theX1, int theY1, int s, Color f){
       //attributes 
       x1 = theX1;
       y1 = theY1;
       size = s;
       sizeCounter = size;
       colorFill = f;
   }
   public void draw(GraphicsContext pen) {
        pen.setFill(colorFill);
        //outline of the stars
        pen.beginPath();
            pen.lineTo(x1, y1);
            pen.lineTo(x1+size, y1-size/2);
            pen.lineTo(x1+size+size/2, y1-size-size/2);
            pen.lineTo(x1+size*2, y1-size/2);
            pen.lineTo(x1+size*3, y1);
            pen.lineTo(x1+size*2, y1+size/2);
            pen.lineTo(x1+size+size/2, y1+size+size/2);
            pen.lineTo(x1+size, y1+size/2);
            pen.fill();
        pen.closePath();
    }
    /*
        * makes the stars grow bigger and smaller, as if they are shining
        * The size counter increments to track the state/size of the star
        * If the counter equals 8, it will reset the counter 
    */ 
   public void update() {    
        if(sizeCounter == 5) {      
            size--;
            sizeCounter++;
        }
        else if(sizeCounter < 5) {
            size++;
            sizeCounter++;
        }
        else if (sizeCounter > 5 && sizeCounter < 8) {
            size--;
            sizeCounter++;
        }
        else if (sizeCounter == 8) {
            size++;
            sizeCounter = this.size;
        }
   }
}

