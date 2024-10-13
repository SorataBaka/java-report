import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorderFrame extends JFrame implements ActionListener {
    private JButton addButton;
    private JButton removeButton;
    private JLabel label;

    private Font font;

    private int counter;

    public BorderFrame(){
        super();
        Container container = super.getContentPane();
        this.counter = 0;

        this.label = new JLabel("" + this.counter);
        this.addButton = new JButton("足");
        this.removeButton = new JButton("減");
        this.font = new Font("Serif", Font.PLAIN, 30);

        this.addButton.setFont(this.font);
        this.removeButton.setFont(this.font);
        this.label.setFont(this.font);

        this.addButton.addActionListener(this);
        this.removeButton.addActionListener(this);

        label.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel = new JPanel();
        BorderLayout mainFlow = new BorderLayout();
        panel.setLayout(mainFlow);
        panel.add(this.addButton, BorderLayout.WEST);
        panel.add(this.label, BorderLayout.CENTER);
        panel.add(this.removeButton, BorderLayout.EAST);
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
        BorderFrame a = new BorderFrame();
        a.setSize(1280, 720);
        a.setLocation(0, 0);
        a.setVisible(true);
    }


}