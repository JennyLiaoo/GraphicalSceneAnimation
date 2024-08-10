/**
 * This is a graphic scene with many randomized elements
 *
 * @author Jenny
 * @version Feb 6 2023
 */
//import libraries
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import java.util.*;
import java.util.ArrayList;
    
public class GraphicScene extends ProcessingFX {
    public static void main(String[] args) {
        launch(args);
    }
    
    //ArrayLists
    ArrayList<Triangle> mountains;
    ArrayList<Rectangle> BuildingTwo;
    ArrayList<Rectangle> BuildingOne;
    ArrayList<Oval> Clouds;
    ArrayList<Dot> snow;
    ArrayList<Shine> stars;
    
    public void setup(GraphicsContext pen) {
        //draw the background gradient image
        Image backgroundSky = new Image("images/gradient2.png");
        pen.drawImage(backgroundSky, -200, -100, 1500, 1200);   

        //Generate random number of mountains with a random x, y, height, and width using dice
        mountains = new ArrayList<Triangle>();      //arraylist
        Dice genNumMountains = new Dice(30, 40);    
        for (int numMountains = 0; numMountains < genNumMountains.getValue(); numMountains++) {     //a counter tracking the number already drawn and the number generated
            Dice x = new Dice(-400, 1200);     
            int y = 600;                       
            Dice height = new Dice(350, 500);   
            Dice width = new Dice(200, 500);     
                
            Triangle mountain = new Triangle(x.getValue(), y, height.getValue(), width.getValue(), Color.rgb(174, 201, 225), Color.rgb(174, 201, 225));
            mountain.draw(pen);
            mountains.add(mountain);             //add to arraylist
        }
        
        //Generate back layer of buildings, with randomized height, width, location and number
        BuildingTwo = new ArrayList<Rectangle>();       //arraylist of the second layer of buildings
        Dice genNumBuildingsTwo = new Dice(40, 50);  
        for (int numBuildingTwo = 0; numBuildingTwo < genNumBuildingsTwo.getValue(); numBuildingTwo++) {
            Dice x = new Dice(-50, 1200);    
            int y = 600;                          //set y-value so that they are all at the bottom of the screen
            Dice height = new Dice(5, 18);     
            Dice width = new Dice(4, 10);
            
            //must change generated size to * 20 + 10 to make all the windows fit perfectly within the buildings
            Rectangle buildingTwo = new Rectangle(x.getValue(), y, height.getValue() * 20 + 10, width.getValue() * 20 + 10, Color.rgb(174, 201, 225), Color.rgb(92, 128, 159), 10, 10, 10, Color.rgb(92, 128, 159), Color.rgb(92, 128, 159));
            buildingTwo.draw(pen);               
            BuildingTwo.add(buildingTwo);         //add to arraylist
        }

        //Generate the front layer of buildings with randomized height, width, location and number
        BuildingOne = new ArrayList<Rectangle>();   
        Dice genNumBuildings = new Dice(20, 30);
        for (int numBuilding = 0; numBuilding < genNumBuildings.getValue(); numBuilding++) {
            Dice x = new Dice(-40, 1200);       
            int y = 600;
            Dice height = new Dice(4, 15);      
            Dice width = new Dice(3, 8);
            
            //must change generated size to * 20 + 10 to make all the windows fit
            Rectangle building = new Rectangle(x.getValue(), y, height.getValue() * 20 + 10, width.getValue() * 20 + 10, Color.WHITE, Color.BLACK, 10, 10, 10, Color.rgb(50, 50, 50), Color.rgb(50, 50, 50));
            building.draw(pen);                 
            BuildingOne.add(building);          
        }
        
        //generate the stars (randomize location but they only appear at night)
        stars = new ArrayList<Shine>();
        Dice genNumStars = new Dice(20, 50);
        for (int numStars = 0; numStars < genNumStars.getValue(); numStars++) {
            Dice x = new Dice(-500, 500);       
            Dice y = new Dice(0, 500);  
            Dice starSize = new Dice(1, 3);  
            
            Shine star = new Shine(x.getValue(), y.getValue(), starSize.getValue(), Color.WHITE);
            star.draw(pen);
            stars.add(star);

        }

        //generate clouds so that they are made of a random number of ovals and so that there are a random number of clouds overall
        Clouds = new ArrayList<Oval>();
        Dice genNumRainyClouds = new Dice(2, 10);   //random number of clouds
        Dice genNumPuff = new Dice(4,7);            //random number of ovals
        for (int numRainCloud = 0; numRainCloud < genNumRainyClouds.getValue(); numRainCloud++) {       //tracks the number of total clouds drawn
             //randomize the location of the first oval
            Dice firstOvalX = new Dice(-200, 1200);   
            Dice firstOvalY = new Dice(400, 600);   
            
            //saves the location of the first oval
            int x2 = firstOvalX.getValue();            
            int y = firstOvalY.getValue();
            
            for(int numCloud = 0; numCloud <= genNumPuff.getValue(); numCloud++) {                      //tracks the number of ovals in each cloud
                Oval cloud = new Oval(x2, y, Color.WHITE);
                cloud.draw(pen);     
                Clouds.add(cloud);
    
                x2 = x2 + 40; //changes the location of the next oval so that it is drawn beside the previous
            }
        }

        //generate snow 
        Dice snowOrNo = new Dice(1, 3);      // dice that determines if it is going to snow or not
        int snowYes = 1;                     
        snow = new ArrayList<Dot>();
        Dice numSnowFlake = new Dice(40, 100);
        if (snowYes == snowOrNo.getValue()) {       //if the number 1 is rolled, it will snow, if not, it will not
            for(int numSnow = 0; numSnow < numSnowFlake.getValue(); numSnow++) {
                    Dice snowX = new Dice(0, 1000);
                    Dice snowY = new Dice(0, 600);
                    Dice snowSize = new Dice(5, 10);
                    
                    Dot Snow = new Dot(snowX.getValue(), snowY.getValue(), Color.WHITE, snowSize.getValue());
                    snow.add(Snow);
            }
        }
        
        //draws the ground
        Rectangle ground = new Rectangle(0, 600, 80, 1200, Color.WHITE, Color.WHITE, 1, 1, 1, Color.WHITE, Color.WHITE);
        ground.draw(pen);
    }
    
    //makes the sky spin
    double spin = 0;
    public void draw(GraphicsContext pen) {
        pen.clearRect(0, 0, window.getWidth(), window.getHeight()); //clears the screen for no build up
        
        //makes the background spin at the middle of the image
        matrix.push();
            matrix.translate(500, 300);
            matrix.rotate(spin);
            Image backgroundSky = new Image("images/gradient2.png");
            pen.drawImage(backgroundSky, -710, -710, 1820, 1420);
            //redraw the stars
            for (int numStars = 0; numStars < stars.size(); numStars++){
                Shine stationaryStars = stars.get(numStars);
                stationaryStars.update();
                stationaryStars.draw(pen);
            }
    
            Dot moon = new Dot(180, 180, Color.rgb(155, 180, 206), 80);     //draw moon
            moon.draw(pen);
            
            Dot sun = new Dot(-260, -260, Color.rgb(255, 236, 138), 80);    //draw sun
            sun.draw(pen);  
        matrix.pop();
        spin += 0.5;    //increment the angle so that it keeps on rotating

        
        //redraw mountains
        for (int numMountains = 0; numMountains < mountains.size(); numMountains++){
            Triangle m = mountains.get(numMountains);
            m.draw(pen);
        }

        //redraw second layer
        for (int buildingTwo = 0; buildingTwo < BuildingTwo.size(); buildingTwo++){
            Rectangle b2 = BuildingTwo.get(buildingTwo);
            b2.draw(pen);
        }

        //redraw first layer
        for (int building = 0; building < BuildingOne.size(); building++){
            Rectangle b1 = BuildingOne.get(building);
            b1.draw(pen);
        }

        //redraw the clouds
        matrix.push();
            matrix.translate(1200, 600);
            matrix.rotate(180);
            for (int cloud = 0; cloud < Clouds.size(); cloud++){
                Oval c = Clouds.get(cloud);
                c.update();        //the clouds will move over
                c.draw(pen);
            } 
        matrix.pop();
        
        //draws the ground
        Rectangle ground = new Rectangle(0, 600, 80, 1200, Color.WHITE, Color.WHITE, 1, 1, 1, Color.WHITE, Color.WHITE);
        ground.draw(pen);
        
        //redraw the snow
        for (int numSnow = 0; numSnow < snow.size(); numSnow++){
            Dot s = snow.get(numSnow);
            s.update();             //the snow will move down
            s.draw(pen);
        }
    }

    public void drawGrid(GraphicsContext pen) {         //grid drawing for reference
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