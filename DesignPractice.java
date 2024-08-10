import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DesignPractice extends ProcessingFX {
          int angle = 0;
    public static void main(String[] args) {
        launch(args);

    }

    public void setup(GraphicsContext pen) {
        
    }

    public void draw(GraphicsContext pen) {
        pen.clearRect(0, 0, window.getWidth(), window.getHeight());
        matrix.push();
        matrix.translate(300, 300);
        matrix.rotate(angle);
        int size = 20;
        for(int n = 0; n < 4; n++) {
        int amtRed = 255;
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 1; j++) {
                pen.setFill(Color.rgb(amtRed, 0, 0));
                pen.fillOval(j*size, i*size, size, size);
                amtRed -= 3;
                
            }
        }
        matrix.rotate(90);
    }
        matrix.pop();
        angle += 5;
        
    }
}
