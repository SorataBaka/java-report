import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Slider extends JFrame implements ChangeListener {
    private JSlider slider;
    private JLabel sliderValue;
    public Slider(){
        super();
        Container container = this.getContentPane();
        this.slider = new JSlider(0, 100, 50);
        this.sliderValue = new JLabel(Integer.toString(this.slider.getValue()));

        this.slider.addChangeListener(this);

        JPanel mainFrame = new JPanel();
        mainFrame.setLayout(new FlowLayout());
        mainFrame.add(this.slider);
        mainFrame.add(this.sliderValue);

        container.add(mainFrame);
    }
    public void stateChanged(ChangeEvent e){
        if(e.getSource() == this.slider){
            this.sliderValue.setText(Integer.toString(this.slider.getValue()));
        }
    }
    public static void main(String[] args){
        Slider slider = new Slider();
        slider.setVisible(true);
        slider.setLocation(0, 0);
        slider.setExtendedState(Frame.MAXIMIZED_BOTH);
    }
}