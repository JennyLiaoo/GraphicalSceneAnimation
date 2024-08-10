
/**
 * Write a description of class DiceDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

 import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DotDemo extends ProcessingFX {
 
    public static void main(String[] args) {
        launch(args);
    }

    public void setup(GraphicsContext pen) {
        window.setBackground(Color.BLACK);

       Dice numSnow = new Dice (10, 20);
     
       for(int numSnowNow = 0; numSnowNow < numSnow.getValue(); numSnowNow++) {
        Dice posX = new Dice (0, 1200);
       Dice posY = new Dice (0, 600);
           Dot snowflake = new Dot(posX.getValue(), posY.getValue(), Color.WHITE, 20);
           snowflake.draw(pen);
       }
    }

    //continuously redraws
    public void draw(GraphicsContext pen) {
      
    }
}


