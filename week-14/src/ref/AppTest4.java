import javax.swing.*;
import java.awt.event.*;

public class AppTest4 extends JFrame implements ActionListener {
    private JButton button;
    private int counter;
    public AppTest4(){
        super();
        this.button = new JButton("押してね☆"); 
        this.button.addActionListener(this);
        this.getContentPane().add(this.button);
        this.counter = 0;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.button) {
            this.counter++;
            this.button.setText("このボタンは"+this.counter+"回おされた");
        }
    }
    public static void main(String[] args){
        AppTest4 a = new AppTest4();
        a.setSize(1920, 1080);
        a.setLocation(0, 0);
        a.setVisible(true);
    }
}