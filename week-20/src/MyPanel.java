import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Given that a ball is being dropped down from the air. 

public class MyPanel extends JPanel implements ActionListener {
    private Timer timer;
    private double g;
    private int t;
    public MyPanel(){
        super.setBackground(Color.black);
        super.setPreferredSize(new Dimension(1000, 1000));
        this.timer = new Timer(50, this);
        this.timer.start();
        this.g = 2;
        this.t = 0;
    }
    private int yPosition(int t){ // position in pixel
        double result = this.getHeight() - ((g * Math.pow(t, 2)) / 2);
        return this.getHeight() - (int)Math.abs(result) - 100;
    }
    public void actionPerformed(ActionEvent e){
        this.repaint();
        Toolkit.getDefaultToolkit().sync();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        System.out.println("paintComponent実行");
        g.setColor(Color.green);
        if(this.t > 50) this.t = 0;
        g.drawOval(getWidth()/2 ,this.yPosition(t++), 100, 100);
    }
}
