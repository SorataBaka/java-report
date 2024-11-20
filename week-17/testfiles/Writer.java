package testfiles;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Writer extends JFrame implements ActionListener{
  private JTextField fileNameField;
  private JTextArea fileContentArea;
  private JButton readButton;
  private JButton writeButton;

  public Writer(){
    super();
    JPanel inputFrame = new JPanel();
    inputFrame.setLayout(new BorderLayout());

    this.fileNameField = new JTextField(50);
    this.fileNameField.addActionListener(this);
    this.fileNameField.setPreferredSize(new Dimension(1000, 100));
    this.fileNameField.setBorder(new EmptyBorder(10, 10, 10,  10));

    this.readButton = new JButton("読み込み");
    this.readButton.setBackground(Color.blue);
    this.readButton.addActionListener(this);
    this.readButton.setPreferredSize(new Dimension(200, 100));

    this.writeButton = new JButton("書き込み");
    this.writeButton.setBackground(Color.red);
    this.writeButton.addActionListener(this);
    this.writeButton.setPreferredSize(new Dimension(200, 100));

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    buttonPanel.add(this.readButton);
    buttonPanel.add(this.writeButton);

    inputFrame.add(this.fileNameField, BorderLayout.WEST);
    inputFrame.add(buttonPanel, BorderLayout.EAST);

    this.fileContentArea = new JTextArea();
    this.fileContentArea.setLineWrap(true);
    this.fileContentArea.setEditable(true);
    this.fileContentArea.setBorder(new EmptyBorder(20, 20, 20, 20));
    JScrollPane scrollPane = new JScrollPane(this.fileContentArea);
    scrollPane.setPreferredSize(new Dimension(1280, 500));

    JPanel mainFrame = new JPanel();
    mainFrame.setBorder(new EmptyBorder(20, 20, 20, 20));
    mainFrame.setLayout(new BorderLayout());
    mainFrame.add(inputFrame, BorderLayout.NORTH);
    mainFrame.add(scrollPane, BorderLayout.SOUTH);

    Container container = this.getContentPane();
    container.add(mainFrame);

  }
  private void readFile(String fileName){
    String buffer;
    String concat = new String();

    try {
      FileReader fileReader = new FileReader(fileName);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      while((buffer = bufferedReader.readLine())!= null){
        concat += buffer;
        concat += System.getProperty("line.separator");
      }
      bufferedReader.close();
      fileReader.close();
      this.fileContentArea.setText(concat);
      return;
    }catch(Exception e){
      this.fileContentArea.setText(e.getMessage());
      return;
    }
  }
  private void writeFile(String fileName){
    try {
      FileWriter fileWriter = new FileWriter(fileName);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      bufferedWriter.write(this.fileContentArea.getText());
      bufferedWriter.flush();

      bufferedWriter.close();
      fileWriter.close();
    } catch (Exception e){
      System.out.println(e.getMessage());
    }
  }
  public void actionPerformed(ActionEvent e){
    if((e.getSource() == this.readButton || e.getSource() == this.fileNameField) && this.fileNameField.getText().length() != 0){
      this.readFile(this.fileNameField.getText());
    }
    if((e.getSource() == this.writeButton) && this.fileNameField.getText().length() != 0){
      this.writeFile(this.fileNameField.getText());
    }
  }
  public static void main(String[] args){
    Writer a = new Writer();
    a.setVisible(true);
    a.setLocation(0, 0);
    a.setSize(1280, 720);
  }
}
