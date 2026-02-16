import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test extends JPanel implements ActionListener {
    private int x, y;
    private int radius;
    private int velocityX, velocityY;
    private boolean isBouncing;
    private boolean isOnGround;

    public test(int radius) {
        this.radius = radius;
        this.x = 100;
        this.y = 50;
        this.velocityX = 5;
        this.velocityY = -5;
        this.isBouncing = false;
        this.isOnGround = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(x, y, radius * 2, radius * 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    private void move() {
        x += velocityX;
        y += velocityY;

        if (y + radius >= getHeight()) {
            isBouncing = true;
            velocityY *= -1;
            isOnGround = false;
        }

        if (y <= 0) {
            isOnGround = true;
            velocityY *= -1;
            isBouncing = false;
        }
    }

    public void bounceUp() {
        if (!isBouncing && !isOnGround) {
            velocityY = 5;
            isBouncing = true;
        }
    }

    public void bounceDown() {
        if (isBouncing) {
            velocityY = -5;
            isBouncing = false;
        }
    }
}

class BouncingBall extends test {
    public BouncingBall(int radius) {
        super(radius);
    }

    public void addActionListener(ActionListener l) {
        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BouncingBall.this.actionPerformed(e);
                if (l != null) {
                    l.actionPerformed(e);
                }
            }
        });
        timer.start();
    }
}

class BouncingBallApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        BouncingBall ball = new BouncingBall(20);
        frame.add(ball);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Adding event listeners to move the ball
        ball.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logic to move the ball according to keyboard input
            }
        });
    }
}