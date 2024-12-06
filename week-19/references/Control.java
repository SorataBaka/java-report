import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

class GraphicsFrame extends JPanel {
    private int width;
    private int height;
    private int xlocation;
    private int ylocation;

    public GraphicsFrame(){
        super.setBackground(Color.black);
        super.setPreferredSize(new Dimension(1000, 500));
        this.width = this.height = this.xlocation = this.ylocation = 0;
    }
    public GraphicsFrame(int Width, int Height, int X, int Y){
        super.setBackground(Color.black);
        super.setPreferredSize(new Dimension(1000, 500));

        this.width = Width;
        this.height = Height;
        this.xlocation = X;
        this.ylocation = Y;
    }
    
    public void setWidth(int newWidth){
        this.width = newWidth;
        return;
    }
    public void setHeight(int newHeight){
        this.height = newHeight;
        return;
    }
    public void setX(int newX){
        this.xlocation = newX;
        return;
    }
    public void setY(int newY){
        this.ylocation = newY;
        return;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.yellow);
        g.drawOval(this.xlocation, this.ylocation, this.width, this.height);
    }
}
public class Control extends JFrame implements ChangeListener {
    private GraphicsFrame graphicsPanel;
    private JSlider widthSlider;
    private JSlider heightSlider;
    private JSlider xSlider;
    private JSlider ySlider;

    private JLabel widthValue;
    private JLabel heightValue;
    private JLabel xValue;
    private JLabel yValue;

    public Control(){
        super();
        Container container = this.getContentPane();
        

        this.widthSlider = new JSlider(0, 1000);
        this.heightSlider = new JSlider(0, 500);
        this.xSlider = new JSlider(0, 1000);
        this.ySlider = new JSlider(0, 500);

        this.widthSlider.addChangeListener(this);
        this.heightSlider.addChangeListener(this);
        this.xSlider.addChangeListener(this);
        this.ySlider.addChangeListener(this);

        this.graphicsPanel = new GraphicsFrame(this.widthSlider.getValue(), this.heightSlider.getValue(), this.xSlider.getValue(), this.ySlider.getValue());

        this.widthValue = new JLabel("Width: " + Integer.toString(this.widthSlider.getValue()));
        this.heightValue = new JLabel("Height: " + Integer.toString(this.heightSlider.getValue()));
        this.xValue = new JLabel("X: " + Integer.toString(this.xSlider.getValue()));
        this.yValue = new JLabel("Y: " + Integer.toString(this.ySlider.getValue()));

        JPanel widthPanel = new JPanel();
        widthPanel.setLayout(new BorderLayout());
        widthPanel.add(this.widthSlider, BorderLayout.WEST);
        widthPanel.add(this.widthValue, BorderLayout.EAST);


        JPanel heightPanel = new JPanel();
        heightPanel.setLayout(new BorderLayout());
        heightPanel.add(this.heightSlider, BorderLayout.WEST);
        heightPanel.add(this.heightValue, BorderLayout.EAST);


        JPanel xPanel = new JPanel();
        xPanel.setLayout(new BorderLayout());
        xPanel.add(this.xSlider, BorderLayout.WEST);
        xPanel.add(this.xValue, BorderLayout.EAST);


        JPanel yPanel = new JPanel();
        yPanel.setLayout(new BorderLayout());
        yPanel.add(this.ySlider, BorderLayout.WEST);
        yPanel.add(this.yValue, BorderLayout.EAST);

        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.Y_AXIS));
        sliderPanel.add(widthPanel);
        sliderPanel.add(heightPanel);
        sliderPanel.add(xPanel);
        sliderPanel.add(yPanel);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(this.graphicsPanel);
        mainPanel.add(sliderPanel);


        container.add(mainPanel);
    }
    public void stateChanged(ChangeEvent e){
        if(e.getSource() == this.widthSlider){
            this.graphicsPanel.setWidth(this.widthSlider.getValue());
            this.widthValue.setText("Width: " + Integer.toString(this.widthSlider.getValue()));
        }

        if(e.getSource() == this.heightSlider){
            this.graphicsPanel.setHeight(this.heightSlider.getValue());
            this.heightValue.setText("Height: " + Integer.toString(this.heightSlider.getValue()));
        }

        if(e.getSource() == this.xSlider){
            this.graphicsPanel.setX(this.xSlider.getValue());
            this.xValue.setText("X: " + Integer.toString(this.xSlider.getValue()));
        }

        if(e.getSource() == this.ySlider){
            this.graphicsPanel.setY(this.ySlider.getValue());
            this.yValue.setText("Y: " + Integer.toString(this.ySlider.getValue()));
        }
        this.graphicsPanel.repaint();

    }
    public static void main(String[] args){
        Control control = new Control();
        control.setVisible(true);
        control.setLocation(0, 0);
        control.setExtendedState(Frame.MAXIMIZED_BOTH);
    }
}