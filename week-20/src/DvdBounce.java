import javax.swing.*;
import java.awt.*;
import java.util.Random;
class BouncyObject {
    private Image characterImage;
    private int width;
    private int height;
    private int xPosition;
    private int yPosition;
    private double direction;
    private int velocity;
    
    public BouncyObject(Image characterImage, int width, int height, int initialX, int initialY, double initialDirection, int velocity){
        this.characterImage = characterImage;
        this.width = width;
        this.height = height;
        this.xPosition = initialX;
        this.xPosition = initialY;
        this.direction = initialDirection;
        this.velocity = velocity;
    }
    //Getter
    public Image getCharacterImage() {
        return characterImage;
    }
    public Dimension getSize(){
        return new Dimension(this.width, this.height);
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getxPosition() {
        return xPosition;
    }
    public int getyPosition() {
        return yPosition;
    }
    public int getVelocity() {
        return velocity;
    }
    public double getDirection() {
        return direction;
    }
    //Setter
    public void setHeight(int height) {
        this.height = height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setDirection(double direction) {
        this.direction = direction;
    }
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
    

}

class MainPanel extends JPanel {
    private BouncyObject[] bouncyObjectArray;
    public MainPanel(Image[] character, int width, int height){
        super();
        super.setSize(new Dimension(width, height));
        this.bouncyObjectArray = new BouncyObject[character.length];
        Random random = new Random();
        for(int i = 0; i < character.length; i++){
            Image selectedCharacter = character[i];
            double randomDirection = Math.toRadians(random.nextDouble() * 360);
            this.bouncyObjectArray[i] = new BouncyObject(selectedCharacter, selectedCharacter.getWidth(this), selectedCharacter.getHeight(this), this.randomMax(width), this.randomMax(height), randomDirection, this.randomMax(10));
        }

    }
    public int randomMax(int max){
        Random random = new Random();
        return random.nextInt(max);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < this.bouncyObjectArray.length; i++){
            g.drawImage(this.bouncyObjectArray[i].getCharacterImage(), this.bouncyObjectArray[i].getxPosition(), this.bouncyObjectArray[i].getyPosition(), this);
        }
    }
}
public class DvdBounce extends JFrame {
    private MainPanel mainPanel;
    public DvdBounce(){
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
        Image[] characterArray = new Image[3];
        characterArray[0] = chara1;
        characterArray[1] = chara2;
        characterArray[2] = chara3;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
        this.mainPanel = new MainPanel(characterArray, (int)screenSize.getWidth(), (int)screenSize.getHeight());
        super.getContentPane().add(this.mainPanel);
    }
    public static void main(String[] args){
        DvdBounce newPanel = new DvdBounce();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        newPanel.setVisible(true);
        newPanel.setLocation(0, 0);
        newPanel.setSize(screenSize);
   
    }
}