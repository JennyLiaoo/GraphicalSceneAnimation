
/**
 * Ovals to make the shape of the clouds
 *
 * @author Jenny
 * @version Jan 29 2023
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Oval{
    //attributes
    int x;
    int y;
    int width;
    int height;
    Color f;
    
    //default constructor
    public Oval(int theX, int theY, Color fill) {
        x = theX;
        y = theY;
        //randomly generate the width and height of the ovals for each cloud puff
        Dice w = new Dice(90, 140);
        width = w.getValue();
        Dice h = new Dice(30, 85);
        height = h.getValue();
        f = fill;
               
    }
    public void draw(GraphicsContext pen) {
        pen.setFill(f);
        pen.fillOval(x, y, width, height);
    }
    public void update() {  //the ovals all move to the right
        x -= 1;
        if(x < -300) {      //if it goes past the screen
            x = 1600;       //moves it back to start
        }
    }
}
