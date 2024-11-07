import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Check extends JFrame implements ActionListener{
  private JCheckBox cb1, cb2;
  private JButton judge;

  public Check(){
    super();
    this.cb1 = new JCheckBox("数学が得意");
    this.cb2 = new JCheckBox("英語が得意");
    this.judge  = new JButton("判定");
    this.judge.addActionListener(this);

    Container container = this.getContentPane();
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new FlowLayout());
    mainPanel.add(this.cb1);
    mainPanel.add(this.cb2);
    mainPanel.add(this.judge);

    container.add(mainPanel);
  }
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == this.judge){
      if(this.cb1.isSelected() && this.cb2.isSelected()){
        System.out.println("あなたは天才ですね！数学と英語どっちも得意じゃん！");
      } else if(!this.cb1.isSelected() && this.cb2.isSelected()){
        System.out.println("いいですね！でも数学も重要ですよ！");
      } else if(this.cb1.isSelected() && !this.cb2.isSelected()){
        System.out.println("いいですね！でも英語も重要ですよ！");
      } else {
        System.out.println("英語と数学どっちも得意ではないんですが、もっと頑張ってください！");
      }
    }
  }
  public static void main(String[] args){
    Check a = new Check();
    a.setSize(1280, 720);
    a.setLocation(0, 0);
    a.setVisible(true);
  }
}
