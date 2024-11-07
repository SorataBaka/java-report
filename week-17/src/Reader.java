import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Reader extends JFrame implements ActionListener{
  private JTextField fileNameField;
  private JTextArea fileContentArea;
  private JButton readButton;
  public Reader(){
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
    inputFrame.add(this.fileNameField, BorderLayout.WEST);
    inputFrame.add(this.readButton, BorderLayout.EAST);

    this.fileContentArea = new JTextArea();
    this.fileContentArea.setLineWrap(true);
    this.fileContentArea.setEditable(false);
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
  public void actionPerformed(ActionEvent e){
    if((e.getSource() == this.readButton || e.getSource() == this.fileNameField) && this.fileNameField.getText().length() != 0){
      this.readFile(this.fileNameField.getText());
    }

  }
  public static void main(String[] args){
    Reader a = new Reader();
    a.setVisible(true);
    a.setLocation(0, 0);
    a.setSize(1280, 720);
  }
}
