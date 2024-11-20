package testfiles;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Editor extends JFrame implements ActionListener{
  private JTextField fileNameField;
  private JTextArea fileContentArea;
  private JButton readButton;
  private JButton writeButton;
  private JButton selectFile;
  private JLabel status;

  public Editor(){
    super();
    JPanel inputFrame = new JPanel();
    inputFrame.setLayout(new BorderLayout());

    this.fileNameField = new JTextField(100);
    this.fileNameField.addActionListener(this);
    this.fileNameField.setPreferredSize(new Dimension(1000, 100));
    this.fileNameField.setBorder(new EmptyBorder(10, 10, 10,  10));

    this.readButton = new JButton("読み込み");
    this.readButton.setBackground(Color.BLUE);
    this.readButton.setOpaque(true);
    this.readButton.addActionListener(this);
    this.readButton.setPreferredSize(new Dimension(200, 100));

    this.writeButton = new JButton("書き込み");
    this.writeButton.setBackground(Color.RED);  
    this.writeButton.setOpaque(true);
    this.writeButton.addActionListener(this);
    this.writeButton.setPreferredSize(new Dimension(200, 100));

    this.selectFile = new JButton("ファイル選択");
    this.selectFile.setBackground(Color.GREEN);
    this.selectFile.setOpaque(true);
    this.selectFile.addActionListener(this);
    this.selectFile.setPreferredSize(new Dimension(200, 100));

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    buttonPanel.add(this.readButton);
    buttonPanel.add(this.selectFile);
    buttonPanel.add(this.writeButton);

    inputFrame.add(this.fileNameField, BorderLayout.WEST);
    inputFrame.add(buttonPanel, BorderLayout.EAST);

    this.fileContentArea = new JTextArea();
    this.fileContentArea.setLineWrap(true);
    this.fileContentArea.setEditable(true);
    this.fileContentArea.setBorder(new EmptyBorder(20, 20, 20, 20));
    JScrollPane scrollPane = new JScrollPane(this.fileContentArea);
    scrollPane.setPreferredSize(new Dimension(1280, 500));

    this.status = new JLabel("メッセージ：　なし");

    JPanel mainFrame = new JPanel();
    mainFrame.setBorder(new EmptyBorder(20, 20, 20, 20));
    mainFrame.setLayout(new BorderLayout());
    mainFrame.add(inputFrame, BorderLayout.NORTH);
    mainFrame.add(scrollPane, BorderLayout.SOUTH);
    mainFrame.add(this.status, BorderLayout.CENTER);

    Container container = this.getContentPane();
    container.add(mainFrame);

  }
  private void setStatus(String message){
    if(message.isEmpty()) message = "なし";
    this.status.setText("メッセージ：　" + message);
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
      this.setStatus(e.getMessage());
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
      this.setStatus(fileName);
    }
  }
  private String fileSelector(){
    JFileChooser fileChooser = new JFileChooser();
    int returnValue = fileChooser.showOpenDialog(null);
    if(returnValue == JFileChooser.APPROVE_OPTION){
      File selectedFile = fileChooser.getSelectedFile();
      return selectedFile.getPath();
    }
    return "";
  }
  public void actionPerformed(ActionEvent e){
    if((e.getSource() == this.readButton || e.getSource() == this.fileNameField)){
      if(this.fileNameField.getText().isEmpty()){
        this.setStatus("ファイルパスは空にできません");
        return;
      }
      this.readFile(this.fileNameField.getText());
      this.setStatus("ファイルを読み込みました。");
      return;
    }
    if((e.getSource() == this.writeButton)){
      if(this.fileNameField.getText().isEmpty()){
        this.setStatus("ファイルパスは空にできません");
        return;
      }
      this.writeFile(this.fileNameField.getText());
      this.setStatus("ファイルを書き込みました。");
      return;
    }
    if(e.getSource() == this.selectFile){
      String filePath = fileSelector();
      if(filePath.isEmpty()) return;
      this.fileNameField.setText(filePath);
      this.setStatus("ファイルを選択しました。");
    }
  }
}
