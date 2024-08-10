import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SunTest extends ProcessingFX {
    public static void main(String[] args) {
        launch(args);
    }
    double spd = 0;
    public void setup(GraphicsContext pen) {
        
        
    }

    public void draw(GraphicsContext pen) {
        window.setBackground(Color.BLUE);
        //clears the screen each time it draws
        //prevents build up
        pen.clearRect(0, 0, window.getWidth(), window.getHeight());
        
        
        matrix.push();
            //translates the origin to a different place
            matrix.translate(500,300);
            matrix.rotate(spd);
            Dot d1 = new Dot(180, 180, Color.YELLOW, 80);
            d1.draw(pen);
            drawGrid(pen);
                
            Dot d2 = new Dot(-260, -260, Color.RED, 80);
            d2.draw(pen);
            

        /*
            
            matrix.push();
                matrix.translate(250,250);
                matrix.rotate(2*spd);
                Dot d2 = new Dot(40, 40, Color.WHITE, 20);
                d2.draw(pen);
                drawGrid(pen);
            matrix.pop();
            */
        matrix.pop();
        
        spd++;
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