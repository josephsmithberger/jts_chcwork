import apcslib.*;
import java.awt.Color;

public class colorProject {
    static int gradientFactor = 10;
    static Color currentColor = new Color(232, 127, 46); // original bright orange color
    static DrawingTool pen;
    static SketchPad paper;

    public static void main(String[] args) {
        // window set up
        paper = new SketchPad(1000, 700);
        pen = new DrawingTool(paper);
        
        // draw initials
        pen.setColor(currentColor);
        initialsDrawing();
    }

    public static void initialsDrawing() {
        // draw letter J
        pen.up();
        pen.setWidth(25);
        pen.move(-160, 300);
        pen.down();
        pen.move(-120, 40);
        updateColor();
        pen.move(-160, -200);
        updateColor();
        pen.move(-300, -280);
        updateColor();
        pen.move(-460, -120);
        updateColor();

        // draw letter T
        pen.up();
        pen.move(0, 320);
        pen.down();
        pen.move(80, -90);
        updateColor();
        pen.up();
        pen.move(-60, 80);
        pen.down();
        updateColor();
        pen.move(120, 120);

        // draw letter S
        pen.up();
        pen.move(340, 380);
        pen.down();
        updateColor();
        pen.move(200, 400);
        updateColor();
        pen.move(120, 200);
        updateColor();
        pen.move(200, 120);
        updateColor();
        pen.move(300, 140);
        updateColor();
        pen.move(400, 120);
        updateColor();
        pen.move(460, 0);
        updateColor();
        pen.move(300, -240);
        updateColor();
        pen.move(80, -160);
    }

    public static void updateColor() {
        int red = Math.max(currentColor.getRed() - gradientFactor, 0);
        int green = Math.max(currentColor.getGreen() - gradientFactor, 0);
        int blue = Math.max(currentColor.getBlue() + gradientFactor, 0);

        currentColor = new Color(red, green, blue); // Update the current color
        System.out.println("Red: " + red + ", Green: " + green + ", Blue: " + blue);
        pen.setColor(currentColor); // Set the pen's new color
    }
    public static void gForward(int moveAmount) {
        for (int i = 0; i < moveAmount; i++) {
            pen.forward(1);  // Move the pen forward by 1 unit each iteration
            updateColor();   // Update the pen's color after each step
        }
    }
}