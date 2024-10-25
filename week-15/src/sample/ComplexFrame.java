import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.Arrays;

public class ComplexFrame extends JFrame implements ActionListener {
    private JButton[] menu = new JButton[10];
    private DefaultListModel<String> orders;
    private JList<String> ordersPanel;
    private JButton clearOrder;

    public ComplexFrame(){
        super();
        Container container = this.getContentPane();
        this.initializeMenu();

        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(780, 1000));
        menuPanel.setLayout(new FlowLayout());
        for(int i = 0; i < 10; i++) menuPanel.add(this.menu[i]);


        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());

        this.orders = new DefaultListModel<String>();
        this.ordersPanel =  new JList<String>(this.orders);
        this.ordersPanel.setFont(new Font("Callibri", Font.PLAIN, 30));
        this.ordersPanel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.ordersPanel.setVisibleRowCount(10);
        this.ordersPanel.setPreferredSize(new Dimension(500, 450));

        this.clearOrder = new JButton("会計");
        this.clearOrder.addActionListener(this);
        this.clearOrder.setPreferredSize(new Dimension(500, 200));

        rightPanel.add(this.ordersPanel, BorderLayout.NORTH);
        rightPanel.add(this.clearOrder, BorderLayout.SOUTH);
        
        JPanel completePanel = new JPanel();
        completePanel.setLayout(new BorderLayout());
        completePanel.add(menuPanel, BorderLayout.WEST);
        completePanel.add(rightPanel, BorderLayout.EAST);


        container.add(completePanel);
    }
    private void initializeMenu(){
        this.menu[0] = new JButton("炙りダブり");
        this.menu[1] = new JButton("スパチキ");
        this.menu[2] = new JButton("ハンバーガー");
        this.menu[3] = new JButton("DCB");
        this.menu[4] = new JButton("ポテト");
        this.menu[5] = new JButton("TMB");
        this.menu[6] = new JButton("テリCFO");
        this.menu[7] = new JButton("マックチキン");
        this.menu[8] = new JButton("チキチー");
        this.menu[9] = new JButton("チーズＢ");
        for(int i = 0; i < 10; i++){
            this.menu[i].setPreferredSize(new Dimension(150, 150));
            this.menu[i].addActionListener(this);
        }
    }
    public void actionPerformed(ActionEvent e){
        if(Arrays.asList(this.menu).contains(e.getSource())){
            JButton eventButton = (JButton)e.getSource();
            this.orders.addElement(eventButton.getText());
        }
        if(e.getSource() == (this.clearOrder)){
            this.orders.clear();
        }
    }
    public static void main(String[] args){
        ComplexFrame a = new ComplexFrame();
        a.setSize(1280, 720);
        a.setLocation(0, 0);
        a.setVisible(true);
    }


}