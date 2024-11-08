package examples;
import javax.swing.*;
import java.awt.event.*;

public class AppTest3 extends JFrame implements ActionListener {
    private JButton button;
    public AppTest3(){
        super();
        this.button = new JButton("押してね☆"); 
        this.button.addActionListener(this);
        this.getContentPane().add(this.button);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.button) {
            System.out.println("Hello World");
        }
    }
    public static void main(String[] args){
        AppTest3 a = new AppTest3();
        a.setSize(1920, 1080);
        a.setLocation(0, 0);
        a.setVisible(true);
    }
}