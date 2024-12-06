import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel {
    public MyPanel(){
        super.setBackground(Color.black);
        super.setPreferredSize(new Dimension(640, 240));
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.green);
        g.drawLine(50, 50, 100, 100);
        g.drawOval(32,16, 256, 128);
        g.drawString("Test String", 48, 48);
        g.drawRect(50, 50,100, 100);
    }
}
