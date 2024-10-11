import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


public class FlowFrame extends JFrame implements ActionListener {
    private JButton addButton;
    private JButton removeButton;
    private JLabel label;

    private int counter;

    public FlowFrame(){
        super();
        Container container = super.getContentPane();
        this.counter = 0;

        this.label = new JLabel("" + this.counter);
        this.addButton = new JButton("足");
        this.removeButton = new JButton("減");

        this.addButton.addActionListener(this);
        this.removeButton.addActionListener(this);

        JPanel panel = new JPanel();
        FlowLayout mainFlow = new FlowLayout();
        panel.setLayout(mainFlow);
        panel.add(this.addButton);
        panel.add(this.label);
        panel.add(this.removeButton);
        container.add(panel);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.addButton){
            this.label.setText("" + ++this.counter);
        }

        if(e.getSource() == this.removeButton){
            this.label.setText("" + --this.counter);
        }
    }
    public static void main(String[] args){
        FlowFrame a = new FlowFrame();
        a.setSize(1280, 720);
        a.setLocation(0, 0);
        a.setVisible(true);
    }


}