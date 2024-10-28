import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Radio extends JFrame implements ActionListener {
  private JRadioButton rb1, rb2, rb3;
  private JButton kettei;
  public Radio(){
    Container container  = this.getContentPane();
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new FlowLayout());

    this.rb1 = new JRadioButton("就職");
    this.rb2 = new JRadioButton("専攻科進学");
    this.rb3 = new JRadioButton("大学編入学");

    this.kettei = new JButton("決定");
    this.kettei.addActionListener(this);

    ButtonGroup group = new ButtonGroup();
    group.add(this.rb1);
    group.add(this.rb2);
    group.add(this.rb3);

    mainPanel.add(this.rb1);
    mainPanel.add(this.rb2);
    mainPanel.add(this.rb3);
    mainPanel.add(this.kettei);

    container.add(mainPanel);
  }
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == this.kettei){
      if(!this.rb1.isSelected() && !this.rb2.isSelected() && !this.rb3.isSelected()){
        System.out.println("科目を決定してください！");
      } else if(this.rb1.isSelected()){
        System.out.println("実習系科目には特にしっかり取り組みましょう!");
      } else if(this.rb2.isSelected()){
        System.out.println("専攻科を決定しました！推薦を準備しましょう！");
      } else if(this.rb3.isSelected()){
        System.out.println("大学編入学を決定しました！学力のために勉強しましょう！");
      }
      
    }
  }

  public static void main(String[] args){
    Radio a = new Radio();
    a.setSize(1280, 720);
    a.setLocation(0, 0);
    a.setVisible(true);
  }
  
}
