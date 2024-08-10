
/**
 * Write a description of class MatrixExample here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class MatrixExample extends ProcessingFX 
{
    public static void main(String[] args) {
        launch(args);
    }
    
    double x = 0;

    public void setup(GraphicsContext pen) {
        window.setBackground(Color.BLUE);
        //Rectangle test = new Rectangle(100, 100, 100, 100, Color.RED, Color.RED, 1, 1, 1, Color.RED, Color.RED);
        //test.draw(pen);
    }
    double y = 0;
    double z = 0;
    public void draw(GraphicsContext pen) {
        
        //clears the screen each time it draws
        //prevents build up
    
        pen.clearRect(0, 0, window.getWidth(), window.getHeight());
        
        matrix.push();
            matrix.translate(150, 150);
            matrix.scale(y - z);
            Rectangle test = new Rectangle(0, 0, 100, 100, Color.RED, Color.RED, 1, 1, 1, Color.RED, Color.RED);
            test.draw(pen);
            drawGrid(pen);
        matrix.pop();
        
        if (y < 3) {
            y += 0.01;
        }
        else if (y == 3) {
            z = 2.01;
        }
        
        
        matrix.push();
            //translates the origin to a different place
            matrix.translate(300,300);
            matrix.rotate(x);
            Dot d1 = new Dot(200, 200, Color.YELLOW, 100);
            d1.draw(pen);
            drawGrid(pen);

            
            matrix.push();
                matrix.translate(250,250);
                matrix.rotate(2*x);
                Dot d2 = new Dot(40, 40, Color.WHITE, 20);
                d2.draw(pen);
                drawGrid(pen);
            matrix.pop();
            
        matrix.pop();
        
        x++;
            
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
