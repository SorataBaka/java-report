import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ComplexFrame extends JFrame implements ActionListener {
    private JButton[] menu = new JButton[5];
    private DefaultListModel<String> orders;
    private JList<String> ordersPanel;

    public ComplexFrame(){
        super();
        Container container = this.getContentPane();
        this.initializeMenu();

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout());
        for(int i = 0; i < 5; i++) menuPanel.add(this.menu[i]);


        this.orders = new DefaultListModel<String>();
        this.ordersPanel =  new JList<String>(this.orders);
        this.ordersPanel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.ordersPanel.setVisibleRowCount(10);
        this.ordersPanel.setPreferredSize(250,500);

        
        JPanel completePanel = new JPanel();
        completePanel.setLayout(new BorderLayout());
        completePanel.add(menuPanel, BorderLayout.WEST);
        completePanel.add(this.ordersPanel, BorderLayout.EAST);


        container.add(completePanel);
    }
    private void initializeMenu(){
        this.menu[0] = new JButton("炙りダブり");
        this.menu[1] = new JButton("スパチキ");
        this.menu[2] = new JButton("ハンバーガー");
        this.menu[3] = new JButton("DCB");
        this.menu[4] = new JButton("ポテト");
        for(int i = 0; i < 5; i++){
            this.menu[i].setPreferredSize(new Dimension(150, 150));
            this.menu[i].addActionListener(this);
        }
    }
    public void actionPerformed(ActionEvent e){
        if(Arrays.asList(this.menu).contains(e.getSource())){
            JButton eventButton = (JButton)e.getSource();
            this.orders.addElement(eventButton.getText());

        }
    }
    public static void main(String[] args){
        ComplexFrame a = new ComplexFrame();
        a.setSize(1280, 720);
        a.setLocation(0, 0);
        a.setVisible(true);
    }


}