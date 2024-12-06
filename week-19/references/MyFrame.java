import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame {
    private MyPanel mp;
    public MyFrame(){
        this.mp = new MyPanel();
        JPanel panel1 = new JPanel();
        panel1.add(this.mp);
        super.getContentPane().add(panel1);
    }
    public static void main(String[] args){
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
        frame.setLocation(0, 0);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
    }
}