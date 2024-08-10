
/**
 * A triangle class to make the mountains
 *
 * @author Jenny
 * @version Jan 25 2023
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Triangle
{
   //attributes
   Color colorStroke;
   Color colorFill;
   int x1;
   int y1;
   int width;
   int height;
   
   //constructor
   public Triangle(int theX1, int theY1, int theWidth, int theHeight, Color c, Color f){
       x1 = theX1;
       y1 = theY1;
       width = theWidth;
       height = theHeight;
       colorStroke = c;
       colorFill = f;
   }
   public void draw(GraphicsContext pen) {
        //setting fill and stroke
        pen.setStroke(colorStroke);
        pen.setLineWidth(2);
        pen.setFill(colorFill);
    
        //draws an isosceles triangle
        pen.beginPath();
            pen.lineTo(x1, y1);
            pen.lineTo(x1 + width, y1);
            pen.lineTo(x1 + (width/2), y1 - height);
            pen.fill();
        pen.closePath();
        pen.stroke();

    }
   public void setPt(int pt, int x, int y) {        //for updating 
        if(pt == 1) {
            x1 = x;
            y1 = y;
        }
   }
}

