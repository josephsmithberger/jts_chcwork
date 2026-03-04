import TurtleGraphics.*;
import java.awt.Color;
import TerminalIO.KeyboardReader;

public class TestShapes {
   public static void main (String[] args) {

      // Declare and instantiate a pen, a circle and a rectangle
      Pen p = new StandardPen();
      Shape s1 = new Circle (20, 20, 20);
      Shape s2 = new Rect (-20, -20, 10, 20);
      
      // Draw the circle and rectangle
      s1.draw (p);
      s2.draw (p);
      
      // Display a description of the circle and rectangle
      System.out.println (s1);  // toString method called implicitly
      System.out.println (s2);  // toString method called implicitly
      
      // Pause until the user is ready to continue
      KeyboardReader reader = new KeyboardReader();
      reader.pause();
      
      // Erase the circle and rectangle
      p.setColor (Color.white);
      s1.draw (p);
      s2.draw (p);
      p.setColor (Color.red);
      
      // Move the circle and rectangle, change their size, and redraw
      s1.move (30, 30);           s2.move (-30, -30);
      s1.stretchBy (2);           s2.stretchBy (2);
      s1.draw (p);                s2.draw (p);
   }
}

