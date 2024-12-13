import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Given that a ball is being dropped down from the air. 

class BouncingBall {
    private static final double GRAVITY = 10; // m/s^2
    private double mass;
    private double dragCoeff;
    private double restitution;
    private int initialPosition;
    public BouncingBall(double mass, double dragCoeff, double restitution, int initialPosition) {
        this.mass = mass;
        this.dragCoeff = dragCoeff;
        this.restitution = restitution;
        this.initialPosition = initialPosition;
    }
    public double simulate(double time) {
        double position = this.initialPosition;     // Initial position (m)
        double velocity = 0; // Initial velocity (m/s)
        while (time > 0) {
            double timeStep = 0.01; // Small time step for accuracy
            double acceleration = -GRAVITY - (dragCoeff / mass) * velocity;
            position += velocity * timeStep;
            velocity += acceleration * timeStep;
            time -= timeStep;
            // Check for bounce
            if (position <= 0.0 && velocity < 0) {
                position = 0.0; // Reset position to ground level
                velocity = -velocity * restitution; // Reverse and scale velocity
            }
        }

        return position;
    }
}

public class MyPanel extends JPanel implements ActionListener {
    private Timer timer;
    public double t;
    private BouncingBall ball;
    public MyPanel(){
        super.setBackground(Color.black);
        super.setPreferredSize(new Dimension(1000, 800));
        this.timer = new Timer(10, this);
        this.timer.start();
        this.ball = new BouncingBall(2,0.1, 0.95, 700);
    }
    public void reset(){
        this.t = 0;
    }
    public void actionPerformed(ActionEvent e){
        this.repaint();
        Toolkit.getDefaultToolkit().sync();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        this.t = this.t + 0.15;
        int yPosition = 700 - (int)ball.simulate(this.t);
        System.out.println("paintComponent 実行 t = " + this.t + " y = " + yPosition);
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.green);
        g2d.drawOval(getWidth()/2 - 50, yPosition, 100, 100);
    }
}
