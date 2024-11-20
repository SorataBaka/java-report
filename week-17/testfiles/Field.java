package testfiles;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
public class Field extends JFrame implements ActionListener {
  private JTextField textField;
  private JTextArea textArea;
  public Field(){
    super();
    this.textField = new JTextField(26);
    this.textField.addActionListener(this);
    this.textField.setPreferredSize(new Dimension(1280, 150));
    this.textField.setBorder(new EmptyBorder(20, 20, 20, 20));

    this.textArea = new JTextArea();
    this.textArea.setPreferredSize(new Dimension(1280, 300));
    this.textArea.setBorder(new EmptyBorder(20, 20 ,20, 20));
    this.textArea.setEditable(false);
    this.textArea.setAutoscrolls(true);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());

    mainPanel.add(this.textField, BorderLayout.NORTH);
    mainPanel.add(this.textArea, BorderLayout.SOUTH);

    Container container = this.getContentPane();
    container.add(mainPanel);
  }
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == this.textField){
      String enteredText = this.textField.getText();
      if(enteredText.length() == 0 ) return;
      this.textArea.append(enteredText);
      this.textArea.append(System.getProperty("line.separator"));
    }

  }
  public static void main(String[] args){
    Field a = new Field();
    a.setSize(1280, 720);
    a.setLocation(0, 0);
    a.setVisible(true);
  }
}
