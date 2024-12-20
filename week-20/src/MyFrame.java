import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyFrame extends JFrame {
    private MyPanel mp;
    public MyFrame(){
        this.mp = new MyPanel();
        JPanel panel1 = new JPanel();
        panel1.add(this.mp);
        JButton resetButton = new JButton("リセット");
        resetButton.setPreferredSize(new Dimension(this.getWidth(), 100));
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                mp.reset();
            }
        });
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(panel1, BorderLayout.CENTER);
        mainPanel.add(resetButton, BorderLayout.SOUTH);
        super.getContentPane().add(mainPanel);
    }
    public static void main(String[] args){
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
        frame.setLocation(0, 0);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
    }
}