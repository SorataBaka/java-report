import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;


class GraphicsPanel extends JPanel implements MouseMotionListener{
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private BufferedImage canvas;
    public GraphicsPanel(int width, int height){
        super.setBackground(Color.black);
        this.addMouseMotionListener(this);
        this.setPreferredSize(new Dimension(width, height));
        this.startX = this.startY = this.endX = this.endY = 0;
        this.canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }
    public void drawDot(){
        Graphics g = this.canvas.getGraphics();
        g.setColor(Color.green);
        g.drawLine(this.startX, this.startY, this.endX, this.endY);
        g.dispose();

        this.getGraphics().drawImage(this.canvas, 0, 0, null);
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
public class CombinedApp extends JFrame {
    private GraphicsPanel gpanel;
    private JPanel controlPanel;
    public CombinedApp(){
        super();
        Container container = this.getContentPane();
        this.gpanel = new GraphicsPanel(1500, 1080);
        
        JPanel masterPanel = new JPanel();
        masterPanel.setLayout(new BorderLayout());
        masterPanel.add(this.gpanel, BorderLayout.WEST);


        container.add(masterPanel);
    }
    public static void main(String[] args){
        CombinedApp control = new CombinedApp();
        control.setVisible(true);
        control.setLocation(0, 0);
        control.setExtendedState(Frame.MAXIMIZED_BOTH);
        control.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}