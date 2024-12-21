import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    public void setxPosition(int x){
        this.xPosition = x;
    }
    public void setyPosition(int y){
        this.yPosition = y;
    }
    public double calculateBounceDirection(double wallNormal) {
        double newDirection = (2 * wallNormal) - this.direction;
        if(newDirection < 0){
            newDirection += 2 * Math.PI;
        } else if(newDirection >= 2 * Math.PI){
            newDirection -= 2 * Math.PI;
        }
        return newDirection;
    }
}

class MainPanel extends JPanel implements ActionListener {
    private BouncyObject[] bouncyObjectArray;
    private Timer timer;
    public MainPanel(Image[] character, int width, int height){
        super();
        super.setBackground(Color.BLACK);
        super.setSize(new Dimension(width, height));
        this.bouncyObjectArray = new BouncyObject[character.length];
        Random random = new Random();
        for(int i = 0; i < character.length; i++){
            Image selectedCharacter = character[i];
            double randomDirection = random.nextDouble() * 2 * Math.PI;
            this.bouncyObjectArray[i] = new BouncyObject(selectedCharacter, selectedCharacter.getWidth(this), selectedCharacter.getHeight(this), this.randomMax(0, width), this.randomMax(0, height), randomDirection, this.randomMax(2, 10));
        }
        this.timer = new Timer(10, this);
        this.timer.start();
    }
    public int randomMax(int min, int max){
        Random random = new Random();
        return random.nextInt(min, max);
    }

    public void calculateWallbounce(){
        for(int i = 0; i < this.bouncyObjectArray.length; i++){
            BouncyObject object = this.bouncyObjectArray[i];
            if(object.getxPosition() < 0){
                double newDirection = object.calculateBounceDirection(0);
                this.bouncyObjectArray[i].setDirection(newDirection);
            } else if((object.getxPosition()) > this.getWidth()){
                double newDirection = object.calculateBounceDirection(Math.PI);
                this.bouncyObjectArray[i].setDirection(newDirection);
            } else if(object.getyPosition() < 0){
                double newDirection = object.calculateBounceDirection((Math.PI / 2) * 3);
                this.bouncyObjectArray[i].setDirection(newDirection);
            } else if((object.getyPosition()) > this.getHeight()){
                double newDirection = object.calculateBounceDirection(Math.PI / 2);
                this.bouncyObjectArray[i].setDirection(newDirection);
            }
        }
    }
    public void calculateMovement(){
        for(int i = 0; i < this.bouncyObjectArray.length; i++){
            BouncyObject object = this.bouncyObjectArray[i];
            int currentX = object.getxPosition();
            int currentY = object.getyPosition();
            
            double direction = object.getDirection();
            int speed = object.getVelocity();

            double xSpeed = Math.cos(direction) * speed;
            double ySpeed = Math.sin(direction) * speed;

            // System.out.println(i + 1 + " ANGLE: " + convertToPi(direction) + " COS RESULT: " + Math.cos(direction) + "  SIN RESULT: " + Math.sin(direction));

            this.bouncyObjectArray[i].setxPosition(currentX + (int)xSpeed);
            this.bouncyObjectArray[i].setyPosition(currentY + (int)ySpeed);
        }
    }
    public void actionPerformed(ActionEvent e){
        this.calculateWallbounce();
        this.calculateMovement();
        this.repaint();
        Toolkit.getDefaultToolkit().sync();
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
        // Image chara2 = tk.getImage("../2.gif");
        // Image chara3 = tk.getImage("../3.gif");
        tracker.addImage(chara1, 0);
        // tracker.addImage(chara2, 0);
        // tracker.addImage(chara3, 0);
        try {
            tracker.waitForAll();
        } catch (Exception ex){
            System.exit(1);
        }
        Image[] characterArray = new Image[1];
        characterArray[0] = chara1;
        // characterArray[1] = chara2;
        // characterArray[2] = chara3;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
        this.mainPanel = new MainPanel(characterArray, (int)screenSize.getWidth(), (int)screenSize.getHeight());
        super.getContentPane().add(this.mainPanel);
    }
    public static void main(String[] args){
        DvdBounce newPanel = new DvdBounce();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        newPanel.setVisible(true);
        newPanel.setLocation(0, 0);
        newPanel.setSize(new Dimension((int)screenSize.getWidth(), (int)screenSize.getHeight()));
   
    }
}