import TurtleGraphics.*;
import java.awt.Color;
import java.util.ArrayList;
import TerminalIO.KeyboardReader;

public class TestShapes {
   public static void main (String[] args) {

      // Declare drawing pen.
      Pen p = new StandardPen();

      // Build shapes that demonstrate interface + abstract class + inheritance.
      Shape s1 = new Circle (20, 20, 20);
      Shape s2 = new Rect (-20, -20, 10, 20);
      Shape s3 = new Triangle (0, -10, 18, 12);
      Shape s4 = new Wheel (-35, 30, 12, 8);

      ArrayList<Shape> shapes = new ArrayList<Shape>();
      shapes.add(s1);
      shapes.add(s2);
      shapes.add(s3);
      shapes.add(s4);
      
      // Draw all shapes using polymorphism through a for-each loop.
      for (Shape shape : shapes) {
         shape.draw(p);
      }

      // Display each shape description and computed area/perimeter.
      System.out.println("--- Initial Shape Data ---");
      for (Shape shape : shapes) {
         System.out.println(shape);  // toString method called implicitly
         System.out.println("Area check: " + String.format("%.4f", shape.area()));
         System.out.println("Perimeter check: " + String.format("%.4f", shape.perimeter()));
         System.out.println();
      }
      
      // Pause until the user is ready to continue
      KeyboardReader reader = new KeyboardReader();
      reader.pause();
      
      // Erase the circle and rectangle
      p.setColor (Color.white);
      for (Shape shape : shapes) {
         shape.draw(p);
      }
      p.setColor (Color.red);
      
      // Move/stretch all shapes, then redraw to prove inherited methods work.
      s1.move (30, 30);           s1.stretchBy (1.5);
      s2.move (-35, -25);         s2.stretchBy (2.0);
      s3.move (5, -20);           s3.stretchBy (1.3);
      s4.move (-15, 15);          s4.stretchBy (1.2);

      for (Shape shape : shapes) {
         shape.draw(p);
      }

      System.out.println("--- After Move/Stretch ---");
      for (Shape shape : shapes) {
         System.out.println(shape);
         System.out.println();
      }

      System.out.println("All shape tests completed.");
   }
}

