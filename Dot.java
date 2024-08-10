
/**
 * Multi-use circles, these dots are used to make snow, sun, etc.
 *
 * @author Jenny
 * @version Jan 27 2023
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Dot{
    //attributes
    Color color;
    int size;
    int x;
    int y;
    
    //default constructor
    public Dot(int theX, int theY, Color c, int s) {
        x = theX;
        y = theY;
        color = c;
        size = s;       
    }
    public void draw(GraphicsContext pen) {
        pen.setFill(color);
        pen.fillOval(x, y, size, size);
    }
    public void update() {      //updates the y - position of the snow so that it goes back to the top
        y += 1;
        if(y > 600) {
            y = -10;
        }
    }
}
