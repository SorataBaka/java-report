import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppTest5 extends JFrame implements ActionListener {
    private JButton button;
    private JButton resetButton;
    private JButton removeButton;

    private int counter;

    private String defaultText;

    public AppTest5(){
        super();
        
        this.defaultText = "押してね☆";

        Container container = this.getContentPane();
        container.setLayout(null);

        this.button = new JButton(this.defaultText); 
        this.button.addActionListener(this);
        this.button.setBounds((1920/2) - 200, (1080/2), 200, 100);
        
        this.resetButton = new JButton("リセット");
        this.resetButton.addActionListener(this);
        this.resetButton.setBounds((1920/2) - 200, (1080/2) - 110, 200, 100);

        this.removeButton = new JButton("回数を減算");
        this.removeButton.addActionListener(this);
        this.removeButton.setBounds((1920/2) - 200, (1080/2) + 110, 200, 100);


        container.add(this.button);
        container.add(this.resetButton);
        container.add(this.removeButton);

        this.counter = 0;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.button) {
            this.counter++;
            this.setButtonText();
        }
        if(e.getSource() == this.resetButton){
            this.counter = 0;
            this.button.setText(this.defaultText);
        }
        if(e.getSource() == this.removeButton){
            this.counter--;
            this.setButtonText();
        }
    }
    public void setButtonText(){
        this.button.setText("このボタンは"+this.counter+"回おされた");
    }
    public static void main(String[] args){
        AppTest5 a = new AppTest5();
        a.setSize(1920, 1080);
        a.setLocation(0, 0);
        a.setVisible(true);
    }
}