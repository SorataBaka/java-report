import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class GraphicsPanel extends JPanel implements MouseListener {
    public GraphicsPanel(int panelWidth, int panelHeight){
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.addMouseListener(this);
    }
    public void mousePressed(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        System.out.println(x + " " + y);

        Graphics g = this.getGraphics();
        g.setColor(Color.green);
        g.drawLine(x - 10, y - 10, x + 10, y + 10);
        g.drawLine(x + 10, y - 10, x - 10, y + 10);
        g.dispose();   
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
public class PressApp extends JFrame {
    private GraphicsPanel gpanel;

    public PressApp(){
        super();
        Container container = this.getContentPane();
        this.gpanel = new GraphicsPanel(1000, 500);
        container.add(this.gpanel);

    }

    public static void main(String[] args){
        PressApp control = new PressApp();
        control.setVisible(true);
        control.setLocation(0, 0);
        control.setExtendedState(Frame.MAXIMIZED_BOTH);
        control.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}