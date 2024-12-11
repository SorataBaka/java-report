import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class GraphicsPanel extends JPanel implements MouseMotionListener{
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    public GraphicsPanel(){
        super.setBackground(Color.black);
        this.addMouseMotionListener(this);
        this.startX = this.startY = this.endX = this.endY = 0;
    }
    public void drawDot(){
        Graphics g = this.getGraphics();
        g.setColor(Color.green);
        g.drawLine(this.startX, this.startY, this.endX, this.endY);
        g.dispose();
    }
    public void mouseMoved(MouseEvent e){
        this.endX = e.getX();
        this.endY = e.getY();

    }
    public void mouseDragged(MouseEvent e){
        this.startX = this.endX;
        this.startY = this.endY;
        this.endX = e.getX();
        this.endY = e.getY();
        this.drawDot();
    }
    public void mousePressed(MouseEvent e){

    }
    public void mouseReleased(MouseEvent e){

    }
    public void mouseClicked(MouseEvent e){

    }
    public void mouseEntered(MouseEvent e){

    }
    public void mouseExited(MouseEvent e){

    }
}
public class DragApp extends JFrame {
    private GraphicsPanel gpanel;
    public DragApp(){
        super();
        this.gpanel = new GraphicsPanel();
        this.getContentPane().add(this.gpanel);
    }
    public static void main(String[] args){
        DragApp control = new DragApp();
        control.setVisible(true);
        control.setLocation(0, 0);
        control.setExtendedState(Frame.MAXIMIZED_BOTH);
        control.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}