import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Poll {
   public static void main(String[] args) {
      JFrame pollFrame = new JFrame("Poll");
      PollWindow pw = new PollWindow();
      pw.setBounds(0, 0, 900, 900);
      pollFrame.add(pw);
      pollFrame.setSize(900,900);
      pollFrame.setLayout(null);
      pollFrame.setVisible(true); 
   }
}
   
class PollWindow extends JPanel implements ActionListener {
   JButton button1, button2, button3, button4;
   int count1, count2, count3, count4;
   Timer animTimer;
   int animSlice, animFrom, animTo, animCurrent;
  
  public PollWindow()
  {
    button1 = new JButton("Nintendo");
    button1.setToolTipText("Vote for Nintendo");
    button1.addActionListener(this);

    button2 = new JButton("Playstation");
    button2.setToolTipText("Vote for Playstation");
    button2.addActionListener(this);

    button3 = new JButton("Xbox");
    button3.setToolTipText("Vote for Xbox");
    button3.addActionListener(this);

    button4 = new JButton("Steam");
    button4.setToolTipText("Vote for Steam");
    button4.addActionListener(this);

    add(button1);
    add(button2);
    add(button3);
    add(button4);

    animTimer = new Timer(10, e -> {
      animCurrent += 12;
      if (animCurrent >= animTo) {
        animCurrent = animTo;
        animTimer.stop();
      }
      repaint();
    });
  }

  /**
   *  Processes button events
   */
  public void actionPerformed(ActionEvent e)
  {
    JButton button = (JButton)e.getSource();

    if (button == button1) {
      animSlice = 1;
      count1++;
    } else if (button == button2) {
      animSlice = 2;
      count2++;
    } else if (button == button3) {
      animSlice = 3;
      count3++;
    } else if (button == button4) {
      animSlice = 4;
      count4++;
    }

    int total = count1 + count2 + count3 + count4;
    int oldTotal = total - 1;
    
    if (animSlice == 1) {
      animFrom = countToDegrees(count1 - 1, oldTotal);
      animTo = countToDegrees(count1, total);
    } else if (animSlice == 2) {
      animFrom = countToDegrees(count1, oldTotal) + countToDegrees(count2 - 1, oldTotal);
      animTo = countToDegrees(count1, total) + countToDegrees(count2, total);
    } else if (animSlice == 3) {
      animFrom = countToDegrees(count1, oldTotal) + countToDegrees(count2, oldTotal) + countToDegrees(count3 - 1, oldTotal);
      animTo = countToDegrees(count1, total) + countToDegrees(count2, total) + countToDegrees(count3, total);
    } else {
      animFrom = countToDegrees(count1, oldTotal) + countToDegrees(count2, oldTotal) + countToDegrees(count3, oldTotal) + countToDegrees(count4 - 1, oldTotal);
      animTo = countToDegrees(count1, total) + countToDegrees(count2, total) + countToDegrees(count3, total) + countToDegrees(count4, total);
    }

    animCurrent = animFrom;
    animTimer.restart();
  }

  // Displays the numbers and the pie chart
  @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    final int xStep = getWidth()/5;

    // Display numbers
    int y = 575;
    g.drawString(button1.getText() + ": " + count1, xStep, y);
    g.drawString(button2.getText() + ": " + count2, 2*xStep, y);
    g.drawString(button3.getText() + ": " + count3, 3*xStep, y);
    g.drawString(button4.getText() + ": "+ count4, 4*xStep, y);

    // Display legend (colors)
    y = 580;
    g.setColor(Color.red);
    g.fillRect(xStep, y, 25, 25);
    g.setColor(Color.blue);
    g.fillRect(2*xStep, y, 25, 25);
    g.setColor(Color.green);
    g.fillRect(3*xStep, y, 25, 25);
    g.setColor(Color.darkGray);
    g.fillRect(4*xStep, y, 25, 25);


    // Display pie chart
    int total = count1 + count2 + count3 + count4;
    if (total == 0)
      return;

    final int size = 2*xStep, x = getWidth()/2 - size/2;
    y = 70;
    g.setColor(Color.lightGray);
    g.fillOval(x, y, size, size);

    int degrees, from = 0;
    degrees = countToDegrees(count1, total);
    g.setColor(Color.red);
    g.fillArc(x, y, size, size, from, animSlice == 1 ? Math.min(animCurrent, degrees) : degrees);
    from += degrees;
    degrees = countToDegrees(count2, total);
    g.setColor(Color.blue);
    g.fillArc(x, y, size, size, from, animSlice == 2 ? Math.min(animCurrent - from, degrees) : degrees);
    from += degrees;
    degrees = countToDegrees(count3, total);
    g.setColor(Color.green);
    g.fillArc(x, y, size, size, from, animSlice == 3 ? Math.min(animCurrent - from, degrees) : degrees);
    from += degrees; 
    degrees = 360 - from;
    g.setColor(Color.darkGray);
    g.fillArc(x, y, size, size, from, animSlice == 4 ? Math.min(animCurrent - from, degrees) : degrees);
  }

  /**
   *  Converts the count as a fraction of the total into
   *  the size of the pie slice in degrees.
   */
  private int countToDegrees(int count, int total)
  {
    return (int) ((double) count / (double)total * 360);
  }
}

