/**
 * This is a rectangle class, it generates the buildings and the windows within it
 *
 * @author Jenny 
 * @version Jan 23 2023
 */
//import libraries
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Rectangle
     {
    //attributes for the rectangular buildings
   Color colorStroke;
   Color colorFill;
   int height;
   int width;
   int x1;
   int y1;
   
   //attributes of the windows (win is short for window)
   int winHeight;
   int winWidth;
   int disWin;             //distance between each window
   Color colorStrokeWin;
   Color colorFillWin;
   
   public Rectangle(int theX1, int theY1, int high, int wid, Color c, Color f, int theWinHeight, int theWinWidth, int theDisWin, Color sWin, Color fWin){
           //x and y values are of the lower left corner of the rectangle
           x1 = theX1;
           y1 = theY1;
           height = high;  //building build from bottom to up
           width = wid;    //from left to right
           
           colorStroke = c; 
           colorFill = f;
           
           //distance of the window from other windows and the sides of the building as well as its width and height
           winWidth = theWinWidth;
           winHeight = theWinHeight;
           disWin = theDisWin;
           
           colorStrokeWin = sWin;
           colorFillWin = fWin;
   }
   public void draw(GraphicsContext pen) {
            //set the colors
            pen.setStroke(colorStroke);
            pen.setLineWidth(0.5);
            pen.setFill(colorFill);
                
            //drawing and filling the rectangle
            pen.beginPath();
                pen.lineTo(x1, y1);
                pen.lineTo(x1 + width, y1);
                pen.lineTo(x1 + width, y1 - height);
                pen.lineTo(x1, y1 - height);
                pen.fill();
            pen.closePath();
            pen.stroke();
                
            //calculating the number of windows that can fit into the width and height of a building
            int numWindowsW = (width - 10) / 20;
            int numWindowsH = (height - 10) / 20;
                  
            //change colors to window colors
            pen.setStroke(colorStrokeWin);
            pen.setFill(colorFillWin);
            
            //variables: so that the x2 and y2 (window) values can be changed within the for loop, without affecting x1 and y1 (buildings)
            int x2 = x1;
            int y2 = y1;
            for(int currentWindowsH = 0; currentWindowsH < numWindowsH; currentWindowsH++) {    //ensures that the windows are drawn within the building height
                    for (int currentWindows = 0; currentWindows < numWindowsW; currentWindows++) {  //ensures that the windows are drawn within the building width
                       
                       
                        //draws the windows
                       pen.beginPath();
                            pen.lineTo(x2 + disWin, y2 - disWin);
                            pen.lineTo(x2 + disWin + winWidth, y2 - disWin);
                            pen.lineTo(x2 + disWin + winWidth, y2 - disWin - winHeight);
                            pen.lineTo(x2 + disWin, y2 - disWin - winHeight);
                            pen.fill();
                       pen.closePath();
                        
                        
                        //increases the x value so that the next window is drawn beside it with the distance in between
                       x2 = x2 + winWidth + disWin;
                
                }
                    y2 = y2 - winHeight - disWin;   //increases the y-value, so the windows draw higher
                    x2 = x1;    //reset the x-value so that the windows start drawing at the left side again
                }
    }
    }

