import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class CustomPanel extends JPanel{
    private Image image1;
    private Image image2;
    private Image image3;
    public CustomPanel(Image image1, Image image2, Image image3){
        super();
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(this.image1, 0, 200, this);
        g.drawImage(this.image2, 400, 200, this);
        g.drawImage(this.image3, 800, 0, this);
    }
}
public class MultiImage extends JFrame {
    private CustomPanel customPanel;
    public MultiImage(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        MediaTracker tracker = new MediaTracker(this);
        Image chara1 = tk.getImage("../1.gif");
        Image chara2 = tk.getImage("../2.gif");
        Image chara3 = tk.getImage("../3.gif");
        tracker.addImage(chara1, 0);
        tracker.addImage(chara1, 1);
        tracker.addImage(chara1, 2);
        try {
            tracker.waitForAll();
        } catch (Exception ex){
            System.exit(1);
        }
        this.customPanel = new CustomPanel(chara1, chara2, chara3);
        super.getContentPane().add(this.customPanel);
    }
    public static void main(String[] args){
        MultiImage newPanel = new MultiImage();
        newPanel.setVisible(true);
        newPanel.setLocation(0, 0);
        newPanel.setExtendedState(Frame.MAXIMIZED_BOTH);
    }
}