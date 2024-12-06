import apcslib.*;

import java.awt.*;

public class jsDrawing {
    static Color light_Green = new Color(120, 205, 80); // global vars:
    static Color deep_Blue = new Color(52, 155, 235); 
    static Color outline_Color = new Color (27, 26, 31);
    static Color door_Color = new Color(209, 76, 67);
    static Color door_KnobColor = new Color(133, 97, 48);
    static Color window_Color = new Color(86, 82, 107);

    public static void main(String[] args) {
        DrawingTool pen;
        SketchPad paper;
        paper = new SketchPad(1000, 1000);
        pen = new DrawingTool(paper);

        drawLandscape(pen);
        drawHouse(pen);
        drawFace(pen);

    }

    // Method to draw the house
    public static void drawHouse(DrawingTool pen) {
        Color outlineWindow = window_Color.darker();
        // house primer
        pen.setColor(Color.LIGHT_GRAY);
        pen.up();
        pen.move(-170,-10);
        pen.down();
        pen.fillRect(450, 400);
        pen.up();
        pen.move(-176,232);
        pen.down();
        pen.fillOval(500, 250);
        pen.move(77,156);
        pen.fillOval(100, 100);
        pen.move(-429,143);
        pen.fillOval(100, 100);
        pen.up();
        pen.setWidth(60);
        pen.move(150,177);
        pen.down();
        pen.setColor(deep_Blue);
        pen.move(-160,370);
        pen.move(-500,150);
        pen.move(-282,365);
        pen.move(134,250);
        // windows
        pen.up();
        pen.setWidth(3);
        pen.setColor(window_Color);
        pen.move(-40,10);
        pen.down();
        pen.fillRect(100, 150);
        pen.setColor(outlineWindow);
        pen.drawRect(100, 150);
        pen.up();
        pen.move(-38,80);
        pen.down();
        pen.move(-38,-65);
        pen.up();
        pen.move(10,7);
        pen.down();
        pen.move(-89,7);
        pen.up();
        pen.setColor(window_Color);
        pen.move(-299,10);
        pen.down();
        pen.fillRect(100, 150);
        pen.setColor(outlineWindow);
        pen.drawRect(100,150);
        pen.up();
        pen.move(-297, 80);
        pen.down();
        pen.move(-297, -65);
        pen.up();
        pen.move(-250, 7);
        pen.down();
        pen.move(-347, 7);
        pen.up();
        //door
        pen.move(-170,-100);
        pen.down();
        pen.setColor(door_Color);
        pen.fillRect(120, 219);
        pen.up();
        pen.move(-140,-100);
        pen.setColor(door_KnobColor);
        pen.down();
        pen.fillOval(28,28);
        pen.setColor(outlineWindow);
        pen.up();
        pen.move(-200,-50);
        pen.drawString("welcome");
        // house itself
        pen.up();
        pen.setWidth(5);
        pen.setColor(outline_Color);
        pen.up();
        pen.move(-200,343); 
        pen.down();
        pen.move(123,145);
        pen.move(58,138);
        pen.move(73,-209);
        pen.move(-400,-209);
        pen.move(-400,138);
        pen.move(-400,138);
        pen.move(-470,145);
        pen.move(-200,343); 
        pen.up();
        // chimney
        pen.move(19,250);
        pen.down();
        pen.setColor(Color.lightGray);
        pen.fillRect(80, 160);
        pen.setColor(outline_Color);
        pen.drawRect(80, 160);
    }

    // Method to draw the landscape
    public static void drawLandscape(DrawingTool pen) {
        // Drawing grass
        pen.setColor(light_Green);
        pen.up();
        pen.move(-500, -500);
        pen.down();
        pen.fillRect(2000, 850);
        pen.up();
        pen.move(100, -200);
        pen.drawString("🌷🌿");
        pen.move(110,-180);
        pen.drawString("🌷🌲");
        // Drawing sky
        pen.setColor(deep_Blue);
        pen.up();
        pen.move(-500, 200);
        pen.down();
        pen.fillRect(2000, 600);
        pen.up();
    }
    public static void drawFace(DrawingTool pen) {
        // face
        pen.up();
        pen.move(195,-8);
        pen.setColor(Color.yellow);
        pen.down();
        pen.fillOval(210, 200);
        pen.setColor(outline_Color);
        pen.up();
        pen.move(155,18);
        pen.down();
        pen.fillOval(15, 15);
        pen.up();
        pen.move(247,10);
        pen.down();
        pen.fillOval(15, 15);
        pen.up();
        pen.move(183,-39);
        pen.down();
        pen.fillOval(30, 10);
        // tie
        pen.setWidth(30);
        pen.up();
        pen.setColor(Color.blue);
        pen.move(180, -139);
        pen.down();
        pen.move(160, -95);
        pen.move(120, -133);
        // hat
        pen.up();
        pen.setColor(Color.black);
        pen.move(210, 140);
        pen.down();
        pen.fillRect(90, 130);
        pen.up();
        pen.move(214, 80);
        pen.down();
        pen.fillRect(170, 40);
        pen.up();

            }
}