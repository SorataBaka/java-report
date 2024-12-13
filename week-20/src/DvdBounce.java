import javax.swing.*;
import java.awt.*;
class MainPanel extends JPanel {
    private Image character;
    public MainPanel(Image character, int width, int height){
        super();
        this.character = character;
        super.setPreferredSize(new Dimension(width, height));
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(this.character, 0, 0, this);
    }
}
public class DvdBounce extends JFrame {
    private MainPanel mainPanel;
    public DvdBounce(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        MediaTracker tracker = new MediaTracker(this);
        Image character = tk.getImage("../petting-cat-greg.gif");
        tracker.addImage(character, 0);
        try {
            tracker.waitForAll(); 
        } catch (Exception e){
            System.exit(1);
        }
        this.mainPanel = new MainPanel(character, getWidth(), getHeight());
        super.getContentPane().add(this.mainPanel);
    }
    public static void main(String[] args){
        DvdBounce newPanel = new DvdBounce();
        newPanel.setVisible(true);
        newPanel.setLocation(0, 0);
        newPanel.setExtendedState(Frame.MAXIMIZED_BOTH);
    }
}