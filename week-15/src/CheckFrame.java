import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; 

public class CheckFrame extends JFrame implements ActionListener {
    private JTextField newTask;
    private static String[] tasks = {
        "Buy Groceries",
        "Finish Java Assignment",
        "Call the bank",
        "Schedule appointment",
        "Read 20 pages of a book"
    };
    private JCheckBox[] taskPanels = new JCheckBox[this.tasks.length];

    public CheckFrame(){
        super();
        Container container = this.getContentPane();
        this.initializeTasks();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 1));
        JLabel listTitle = new JLabel("TO-DO LIST");
        listTitle.setFont(new Font("Calibri", Font.PLAIN, 40));
        mainPanel.add(listTitle);
        for(int i = 0; i < this.taskPanels.length; i++) mainPanel.add(this.taskPanels[i]);
        container.add(mainPanel);
    }
    private void initializeTasks(){
        for(int i = 0; i < this.tasks.length; i++){
            this.taskPanels[i] = new JCheckBox(this.tasks[i]);
            this.taskPanels[i].setFont(new Font("Callibri", Font.PLAIN, 40));
            this.taskPanels[i].addActionListener(this);
        }
    }
    public void actionPerformed(ActionEvent e){
        for(int i = 0; i < this.taskPanels.length; i++){
            if(e.getSource() == this.taskPanels[i]){
                this.taskPanels[i].setText("DONE");
            }
        }
    }
    public static void main(String[] args){
        CheckFrame a = new CheckFrame();
        a.setSize(1280, 720);
        a.setLocation(0, 0);
        a.setVisible(true);
    }
}