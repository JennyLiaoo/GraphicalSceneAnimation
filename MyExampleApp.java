import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This is the Main Class for your JavaFX project. It automatically links into the JavaFX library and it is designed to
 * resemble P5.js and Processing in terms of functionality.
 *
 * REPLACE THIS HEADER WITH A PROPER HEADER DESCRIBING YOUR PROJECT
 *
 * @author: You! Its your Template so put your name here
 */
public class MyExampleApp extends ProcessingFX {
    int x = 0;
    int h = 0;
    Color currFill = Color.RED;
    public static void main(String[] args) {
        launch(args);
    }

    public void setup(GraphicsContext pen) {
        pen.setFill(Color.BLACK);
        pen.fillRect(0, 0, window.getWidth(), window.getHeight());
        pen.setFill(Color.WHITE);
        pen.fillRect(100, 200, 50, 75);
        pen.setStroke(Color.YELLOW);
        pen.strokeOval(400, 200, 45, 45);
        //matrix.translate(50, 50);
    }

    public void draw(GraphicsContext pen) {
        window.setBackground(Color.YELLOW);
        window.setTitle("My Awesome Program");
        
        pen.clearRect(0, 0, window.getWidth(),window.getHeight());

        matrix.push();
            matrix.translate(50, h);
           if(h < 0) { h = (int)window.getHeight(); } 
            matrix.rotate(x);
            if(key.isPressed()) {
                pen.setFill(Color.BLUE);
            } else {
                pen.setFill(Color.RED);
            }
            //pen.setFill(Color.RED);
            pen.fillRect(0, 0, 10, 60);
        matrix.pop();
        matrix.push();
            matrix.translate(mouse.x, mouse.y);
            matrix.rotate(-x);
            //pen.setFill(Color.TRANSPARENT);
            pen.setStroke(currFill);
            pen.strokeRect(0, 0, 10, 60);
        matrix.pop();
        x++;
        h--;
        
    }

    public void mousePressed() {
        currFill = Color.PURPLE;
    }

    public void mouseReleased() {
        currFill = Color.RED;
    }

    public void keyPressed() {
        System.out.println(key.keyCode);
        System.out.println(key.key);
    }
}
