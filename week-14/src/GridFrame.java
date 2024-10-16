import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridFrame extends JFrame implements ActionListener {
    private JButton[] menu = new JButton[10];

    public GridFrame(){
        super();
        Container container = this.getContentPane();
        this.initializeMenu();
        container.setLayout(new GridLayout(5, 2));
        container.setSize(new Dimension(700, 700));
        for(int i = 0; i < 10; i++){
          container.add(menu[i]);
        }
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

    }
    public static void main(String[] args){
        GridFrame a = new GridFrame();
        a.setSize(1280, 720);
        a.setLocation(0, 0);
        a.setVisible(true);
    }
}
//GridLayout
//この設計はHTMLのDisplay Gridと同じように、画面の上に行列を立て小コンポーネントを各セルに配置する設計です。配列の行と列の長さはLayoutを初期化するときに設定出来ることです。(https://www.javatpoint.com/GridLayout, https://docs.oracle.com/javase/jp/8/docs/api/java/awt/GridLayout.html)。長さによって、全セルをウィンドウのサイズに従って、自動的にレサイズされる。