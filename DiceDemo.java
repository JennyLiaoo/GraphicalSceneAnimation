
/**
 * Write a description of class DiceDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

 import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DiceDemo extends ProcessingFX {
    Dice one = new Dice(12,14);
    Dice two = new Dice(100,110);
    Dice three = new Dice(24, 16);
    public static void main(String[] args) {
        launch(args);
    }

    public void setup(GraphicsContext pen) {
        System.out.println(one.getValue());
                System.out.println(two.getValue());
                        System.out.println(three.getValue());
    }

    //continuously redraws
    public void draw(GraphicsContext pen) {
        /*
        one.roll();
        System.out.println(one.getValue());
                two.roll();
        System.out.println(two.getValue());
                three.roll();
        System.out.println(three.getValue());
        */
    }
}


