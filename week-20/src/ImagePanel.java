import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class CustomPanel extends JPanel{
    private Image image;
    public CustomPanel(Image image){
        super();
        this.image = image;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, this);
    }
}
public class ImagePanel extends JFrame {
    private CustomPanel customPanel;
    public ImagePanel(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        MediaTracker tracker = new MediaTracker(this);
        Image chara = tk.getImage("../petting-cat-greg.gif");
        tracker.addImage(chara, 0);
        try {
            tracker.waitForAll();
        } catch (Exception ex){
            System.exit(1);
        }
        this.customPanel = new CustomPanel(chara);
        super.getContentPane().add(this.customPanel);
    }
    public static void main(String[] args){
        ImagePanel newPanel = new ImagePanel();
        newPanel.setVisible(true);
        newPanel.setLocation(0, 0);
        newPanel.setExtendedState(Frame.MAXIMIZED_BOTH);
    }
}