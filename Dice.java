
/**
 * A dice class which randomly generates a number based on the input of a maximum and minimum number
 *
 * @author Jenny
 * @version Jan 9 2023
 */
//import random library
import java.util.Random;
public class Dice
{
    //attributes
    int value;
    Random gen;
    int min;
    int max;
    
    // default constructor
    public Dice() {
        gen = new Random();
        value = gen.nextInt(6) + 1;  
    }
    
    // constructor, the dice takes in a max and min value
    public Dice(int min, int max) {
        gen = new Random();
        //ensures that the value is between the max and min
        value = gen.nextInt(max - min) + min; 
        this.min = min;
        this.max = max;
    }
    
    //roll the dice 
    public void roll() {
        value = gen.nextInt(max - min) + min;
    }
    
    //gets the value from the randomly generated number
    public int getValue() {
        return value;
    }
}
