import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class CheckFrame extends JFrame implements ActionListener {
    private ArrayList<String> taskList;
    private JTextField taskInput;
    private JPanel taskInputPanel;
    private JPanel mainPanel;
    private JButton createTaskButton;
    private void hydrate(){
        this.taskList.add("Eat bread");
        this.taskList.add("Take a break");
        this.taskList.add("Finish reports");
    }
    private void fillGrid(){
        this.mainPanel.removeAll();
        this.mainPanel.add(this.taskInputPanel);
        for(int i = 0; i < taskList.size(); i++){
            JPanel taskPanel = new JPanel();
            taskPanel.setLayout(new BorderLayout());

            JCheckBox taskCheckBox = new JCheckBox(this.taskList.get(i));
            taskCheckBox.addActionListener(this);
            taskCheckBox.setFont(new Font("Serif", Font.PLAIN, 30));

            JRadioButton priorityLow = new JRadioButton("LOW");
            JRadioButton priorityMedium = new JRadioButton("MED");
            JRadioButton priorityHigh = new JRadioButton("HIGH");

            ButtonGroup radioGroup = new ButtonGroup();
            radioGroup.add(priorityLow);
            radioGroup.add(priorityMedium);
            radioGroup.add(priorityHigh);

            JPanel radioPanel = new JPanel();
            radioPanel.setLayout(new FlowLayout());
            radioPanel.add(priorityLow);
            radioPanel.add(priorityMedium);
            radioPanel.add(priorityHigh);

            taskPanel.add(taskCheckBox, BorderLayout.WEST);
            taskPanel.add(radioPanel, BorderLayout.EAST);

            this.mainPanel.add(taskPanel);
        }
        this.mainPanel.revalidate();
        this.mainPanel.repaint();
    }
    public CheckFrame(){
        super();
        this.taskList = new ArrayList<String>();
        this.hydrate();

        this.taskInput = new JTextField();
        this.createTaskButton = new JButton("作成");

        this.taskInput.setPreferredSize(new Dimension(1000, 50));
        this.taskInput.setFont(new Font("Serif", Font.PLAIN, 50));

        this.createTaskButton.addActionListener(this);
        this.createTaskButton.setPreferredSize(new Dimension(200,50));
        this.createTaskButton.setFont(new Font("Serif", Font.PLAIN, 30));

        this.taskInputPanel = new JPanel();
        this.taskInputPanel.setLayout(new FlowLayout());
        this.taskInputPanel.add(this.taskInput);
        this.taskInputPanel.add(this.createTaskButton);
        
        Container container  = this.getContentPane();
        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new GridLayout(6, 1));
        this.fillGrid();


        container.add(mainPanel);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.createTaskButton){
            String taskName = this.taskInput.getText();
            if(taskName.length() == 0) return;
            this.taskList.add(taskName);
            this.taskInput.setText("");
            this.fillGrid();
        }
        if(e.getSource() instanceof JCheckBox){
            JCheckBox checkedBox = (JCheckBox)e.getSource();
            String taskName = checkedBox.getText();
            for(int i = 0; i < this.taskList.size(); i++){
                if(taskName == this.taskList.get(i)){
                    this.taskList.remove(i);
                    this.fillGrid();
                }
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