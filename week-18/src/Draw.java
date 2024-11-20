import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.event.*;

class GraphicsFrame extends JPanel {
    private int width;
    private int height;
    private int xlocation;
    private int ylocation;
    private BufferedImage canvas;

    public GraphicsFrame() {
        super.setBackground(Color.black);
        super.setPreferredSize(new Dimension(1000, 500));
        this.width = this.height = this.xlocation = this.ylocation = 0;

        // Initialize the canvas
        canvas = new BufferedImage(1000, 500, BufferedImage.TYPE_INT_ARGB);
        clearCanvas();
    }

    public GraphicsFrame(int Width, int Height, int X, int Y) {
        this();
        this.width = Width;
        this.height = Height;
        this.xlocation = X;
        this.ylocation = Y;
    }

    public void setWidth(int newWidth) {
        this.width = newWidth;
    }

    public void setHeight(int newHeight) {
        this.height = newHeight;
    }

    public void setX(int newX) {
        this.xlocation = newX;
    }

    public void setY(int newY) {
        this.ylocation = newY;
    }

    public void flattenGraphic() {
        Graphics2D g2d = canvas.createGraphics();
        g2d.setColor(Color.yellow);
        g2d.drawOval(this.xlocation, this.ylocation, this.width, this.height);
        g2d.dispose();

        this.xlocation = this.ylocation = 0;
        this.width = 500;
        this.height = 250;
        repaint();
    }

    public void clearCanvas() {
        Graphics2D g2d = canvas.createGraphics();
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        g2d.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(canvas, 0, 0, null);
        g.setColor(Color.yellow);
        g.drawOval(this.xlocation, this.ylocation, this.width, this.height);
    }
}

public class Draw extends JFrame implements ChangeListener {
    private GraphicsFrame graphicsPanel;
    private JSlider widthSlider;
    private JSlider heightSlider;
    private JSlider xSlider;
    private JSlider ySlider;

    private JTextField widthValue;
    private JTextField heightValue;
    private JTextField xValue;
    private JTextField yValue;

    public Draw(){
        super();
        Container container = this.getContentPane();
        

        this.widthSlider = new JSlider(0, 1000);
        this.heightSlider = new JSlider(0, 500);
        this.xSlider = new JSlider(0, 1000);
        this.ySlider = new JSlider(0, 500);

        this.widthSlider.setValue(500);
        this.heightSlider.setValue(250);
        this.xSlider.setValue(0);
        this.ySlider.setValue(0);

        this.widthSlider.addChangeListener(this);
        this.heightSlider.addChangeListener(this);
        this.xSlider.addChangeListener(this);
        this.ySlider.addChangeListener(this);

        this.graphicsPanel = new GraphicsFrame(this.widthSlider.getValue(), this.heightSlider.getValue(), this.xSlider.getValue(), this.ySlider.getValue());


        this.widthValue = new JTextField(Integer.toString(this.widthSlider.getValue()));
        this.heightValue = new JTextField(Integer.toString(this.heightSlider.getValue()));
        this.xValue = new JTextField(Integer.toString(this.xSlider.getValue()));
        this.yValue = new JTextField(Integer.toString(this.ySlider.getValue()));

        this.widthValue.addKeyListener(this.createKeyAdapter());
        this.heightValue.addKeyListener(this.createKeyAdapter());
        this.xValue.addKeyListener(this.createKeyAdapter());
        this.yValue.addKeyListener(this.createKeyAdapter());

        this.widthValue.setPreferredSize(new Dimension(50, 50));
        this.heightValue.setPreferredSize(new Dimension(50, 50));
        this.xValue.setPreferredSize(new Dimension(50, 50));
        this.yValue.setPreferredSize(new Dimension(50, 50));

        this.widthValue.addActionListener(this.createKeyChangeListener());
        this.heightValue.addActionListener(this.createKeyChangeListener());
        this.xValue.addActionListener(this.createKeyChangeListener());
        this.yValue.addActionListener(this.createKeyChangeListener());


        JPanel widthText = new JPanel(new FlowLayout());
        JPanel heightText = new JPanel(new FlowLayout());
        JPanel xText = new JPanel(new FlowLayout());
        JPanel yText = new JPanel(new FlowLayout());

        widthText.add(new JLabel("Width"));
        widthText.add(this.widthValue);
        heightText.add(new JLabel("Height"));
        heightText.add(this.heightValue);
        xText.add(new JLabel("X"));
        xText.add(this.xValue);
        yText.add(new JLabel("Width"));
        yText.add(this.yValue);



        JPanel widthPanel = new JPanel();
        widthPanel.setLayout(new BorderLayout());
        widthPanel.add(this.widthSlider, BorderLayout.WEST);
        widthPanel.add(widthText, BorderLayout.EAST);


        JPanel heightPanel = new JPanel();
        heightPanel.setLayout(new BorderLayout());
        heightPanel.add(this.heightSlider, BorderLayout.WEST);
        heightPanel.add(heightText, BorderLayout.EAST);


        JPanel xPanel = new JPanel();
        xPanel.setLayout(new BorderLayout());
        xPanel.add(this.xSlider, BorderLayout.WEST);
        xPanel.add(xText, BorderLayout.EAST);


        JPanel yPanel = new JPanel();
        yPanel.setLayout(new BorderLayout());
        yPanel.add(this.ySlider, BorderLayout.WEST);
        yPanel.add(yText, BorderLayout.EAST);

        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.Y_AXIS));
        sliderPanel.add(widthPanel);
        sliderPanel.add(heightPanel);
        sliderPanel.add(xPanel);
        sliderPanel.add(yPanel);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        JButton setShape = new JButton("SET");
        setShape.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            graphicsPanel.flattenGraphic();
            widthSlider.setValue(500);
            heightSlider.setValue(250);
            xSlider.setValue(0);
            ySlider.setValue(0);
            graphicsPanel.repaint();
          }
        });
        JButton clearCanvas = new JButton("CLEAR");
        clearCanvas.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e){
            graphicsPanel.clearCanvas();
            graphicsPanel.repaint();
          }
        });
        buttonsPanel.add(setShape);
        buttonsPanel.add(clearCanvas);

        sliderPanel.add(buttonsPanel);



        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(this.graphicsPanel);
        mainPanel.add(sliderPanel);


        container.add(mainPanel);
    }
    public KeyAdapter createKeyAdapter(){
      return new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e){
          char c = e.getKeyChar();
          if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
            e.consume();
          }
        }
      };
    }
    public ActionListener createKeyChangeListener(){
      return new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
          JTextField changedField = (JTextField)e.getSource();
          if(changedField == widthValue){
            widthSlider.setValue(Integer.parseInt(changedField.getText()));
          }else if(changedField == heightValue){
            heightSlider.setValue(Integer.parseInt(changedField.getText()));
          }else if(changedField == xValue){
            xSlider.setValue(Integer.parseInt(changedField.getText()));
          }else if(changedField == yValue){
            ySlider.setValue(Integer.parseInt(changedField.getText()));
          }
        }
      };
    }
    public void stateChanged(ChangeEvent e){
        if(e.getSource() == this.widthSlider){
            this.graphicsPanel.setWidth(this.widthSlider.getValue());
            this.widthValue.setText(Integer.toString(this.widthSlider.getValue()));
        }

        if(e.getSource() == this.heightSlider){
            this.graphicsPanel.setHeight(this.heightSlider.getValue());
            this.heightValue.setText(Integer.toString(this.heightSlider.getValue()));
        }

        if(e.getSource() == this.xSlider){
            this.graphicsPanel.setX(this.xSlider.getValue());
            this.xValue.setText(Integer.toString(this.xSlider.getValue()));
        }

        if(e.getSource() == this.ySlider){
            this.graphicsPanel.setY(this.ySlider.getValue());
            this.yValue.setText(Integer.toString(this.ySlider.getValue()));
        }
        this.graphicsPanel.repaint();

    }
    public static void main(String[] args){
        Draw control = new Draw();
        control.setVisible(true);
        control.setLocation(0, 0);
        control.setExtendedState(Frame.MAXIMIZED_BOTH);
    }
}