import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
enum SelectedTool {
    PEN,
    SQUARE,
    CIRCLE,
    X

}
class Pen {
    private float width;
    private Color color;
    private float opacity;
    private int size;

    public Pen(float initialWidth){
        this.width = initialWidth;
        this.color = Color.BLACK;
        this.opacity = 100;
        this.size = 10;
        
    }
    public void setWidth(float newWidth){
        this.width = newWidth;
    }
    public float getWidth(){
        return this.width;
    }
    public void setColor(Color newColor){
        this.color = newColor;
    }
    public Color getColor(){
        return this.color;
    }
    public void setOpacity(float opacity){
        this.opacity = opacity;
    }
    public float getOpacity(){
        return this.opacity;
    }
    public void setSize(int size){
        this.size = size;
    }
    public int getSize(){
        return this.size;
    }

    public static Color convertHexToRGB(String hexString){
        if(hexString.length() < 1 || hexString.length() > 6) throw new Error(hexString + " is not a hex value");
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < hexString.length(); i += 2) {
            result.add(hexString.substring(i, Math.min(i + 2, hexString.length())));
        }
        String[] converted = result.toArray(new String[0]);
        int redValue = Integer.parseInt(converted[0], 16);
        int greenValue = Integer.parseInt(converted[1], 16);
        int blueValue = Integer.parseInt(converted[2], 16);
        return new Color(redValue, greenValue, blueValue);
    }
}

class GraphicsPanel extends JPanel implements MouseMotionListener, MouseListener{
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private BufferedImage canvas;
    private Pen pen;
    private SelectedTool selectedTool;

    public GraphicsPanel(int width, int height, Pen newPen){
        super.setBackground(Color.WHITE);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.setPreferredSize(new Dimension(width, height));
        this.startX = this.startY = this.endX = this.endY = 0;
        this.canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        this.pen = newPen;
        this.selectedTool = SelectedTool.PEN;
    }
    public void drawDot(){
        if(this.selectedTool != SelectedTool.PEN) return;
        Graphics g = this.canvas.getGraphics();
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setComposite(AlphaComposite.Clear);
        g2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        g2d.setComposite(AlphaComposite.SrcOver);

        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, pen.getOpacity() / 100.0f);
        g2d.setComposite(ac);
        g2d.setStroke(new BasicStroke(this.pen.getWidth()));
        g2d.setColor(this.pen.getColor());
        g2d.drawLine(this.startX, this.startY, this.endX, this.endY);
        g2d.dispose();

        this.getGraphics().drawImage(this.canvas, 0, 0, null);
    }
    public void drawCircle(int x, int y){
        if(this.selectedTool != SelectedTool.CIRCLE) return;
        int topLeftX = x - ((int)this.pen.getSize()) / 2;
        int topLeftY = y - ((int)this.pen.getSize()) / 2;

        Graphics2D g2d = (Graphics2D)this.canvas.getGraphics();
        g2d.setColor(this.pen.getColor());
        g2d.setStroke(new BasicStroke(this.pen.getWidth()));
        g2d.drawOval(topLeftX, topLeftY, (int)this.pen.getSize(), (int)this.pen.getSize());
        g2d.dispose();
        this.getGraphics().drawImage(this.canvas, 0, 0, null);
    }
    public void drawSquare(int x, int y){
        if(this.selectedTool != SelectedTool.SQUARE) return;
        int topLeftX = x - ((int)this.pen.getSize()) / 2;
        int topLeftY = y - ((int)this.pen.getSize()) / 2;

        Graphics2D g2d = (Graphics2D)this.canvas.getGraphics();
        g2d.setColor(this.pen.getColor());
        g2d.setStroke(new BasicStroke(this.pen.getWidth()));
        g2d.drawRect(topLeftX, topLeftY, (int)this.pen.getSize(), (int)this.pen.getSize());
        g2d.dispose();
        this.getGraphics().drawImage(this.canvas, 0, 0, null);
    }
    public void drawX(int x, int y){
        if(this.selectedTool != SelectedTool.X) return;

        Graphics2D g2d = (Graphics2D)this.canvas.getGraphics();
        g2d.setColor(this.pen.getColor());
        g2d.setStroke(new BasicStroke(this.pen.getWidth()));
        int size = this.pen.getSize();
        g2d.drawLine(x - size, y - size, x + size, y + size);
        g2d.drawLine(x + size, y - size, x - size, y + size);

        g2d.dispose();
        this.getGraphics().drawImage(this.canvas, 0, 0, null);
    }
    public void clearPanel(){
        Graphics2D g2d = (Graphics2D)this.canvas.getGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.dispose();
        this.getGraphics().drawImage(this.canvas, 0, 0, null);
    }
    public void setTool(SelectedTool tool){
        this.selectedTool = tool;
    }
    public SelectedTool getTool(){
        return this.selectedTool;
    }
    public void mouseMoved(MouseEvent e){
        this.endX = e.getX();
        this.endY = e.getY();

    }
    public void mouseDragged(MouseEvent e){
        this.startX = this.endX;
        this.startY = this.endY;
        this.endX = e.getX();
        this.endY = e.getY();
        this.drawDot();
    }

    public void mousePressed(MouseEvent e){
        switch(selectedTool){
            case SelectedTool.PEN:
                break;
            case SelectedTool.SQUARE:
            this.drawSquare(e.getX(), e.getY());
                break;
            case SelectedTool.CIRCLE:
                this.drawCircle(e.getX(), e.getY());
                break;
            case SelectedTool.X:
                this.drawX(e.getX(), e.getY());
                break;
        }
    }
    public void mouseReleased(MouseEvent e){

    }
    public void mouseClicked(MouseEvent e){

    }
    public void mouseEntered(MouseEvent e){

    }
    public void mouseExited(MouseEvent e){

    }
}
class ControlPanel extends JPanel {
    Color[] colors = new Color[] {
            Color.RED,            // 1
            Color.GREEN,          // 2
            Color.BLUE,           // 3
            Color.YELLOW,         // 4
            Color.CYAN,           // 5
            Color.MAGENTA,        // 6
            Color.ORANGE,         // 7
            Color.PINK,           // 8
            Color.LIGHT_GRAY,     // 9
            Color.DARK_GRAY,      // 10
            Color.WHITE,          // 11
            Color.BLACK,          // 12
            new Color(255, 105, 180), // 13: Hot Pink
            new Color(0, 255, 127),   // 14: Spring Green
            new Color(255, 69, 0),    // 15: Red Orange
            new Color(255, 215, 0),   // 16: Gold
            new Color(255, 99, 71),   // 17: Tomato
            new Color(34, 139, 34),   // 18: Forest Green
            new Color(72, 61, 139),   // 19: Dark Slate Blue
            new Color(0, 191, 255)    // 20: Deep Sky Blue
        };

    private Pen pen;
    private JSlider widthSlider;
    private JTextField widthField;
    private JSlider opacitySlider;
    private JTextField opacityField;
    private JSlider sizeSlider;
    private JTextField sizeField;
    private GraphicsPanel graphicsPanel;
    
    public ControlPanel(Pen newPen,  GraphicsPanel graphicsPanel){
        this.graphicsPanel = graphicsPanel;
        this.pen = newPen;
        super.setBackground(Color.WHITE);
        super.setPreferredSize(new Dimension(420, 1080));
        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.widthSlider = new JSlider();
        this.widthSlider.setMinimum(1);
        this.widthSlider.setMaximum(100);
        this.widthSlider.setValue((int)this.pen.getWidth());
        this.widthSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e){
                JSlider eventObject = (JSlider)e.getSource();
                int widthValue = eventObject.getValue();
                pen.setWidth((float)widthValue);
                widthField.setText(String.valueOf(widthValue));
            }
        });

        this.widthField = new JTextField();
        this.widthField.setPreferredSize(new Dimension(50, 30));
        this.widthField.setText(String.valueOf((int)this.pen.getWidth()));
        this.widthField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    JTextField source = (JTextField)e.getSource();
                    String newValueString = source.getText();
                    int newValue = Integer.parseInt(newValueString);
                    if(newValue < 1) return;
                    widthSlider.setValue(newValue);
                    pen.setWidth(newValue);
                } catch (NumberFormatException ex){
                    return;
                }
            }
        });


        JPanel widthPanel = new JPanel();
        widthPanel.setLayout(new FlowLayout());
        widthPanel.add(new JLabel("Stroke: "));
        widthPanel.add(this.widthSlider);
        widthPanel.add(this.widthField);


        this.sizeSlider = new JSlider();
        this.sizeSlider.setMinimum(1);
        this.sizeSlider.setMaximum(100);
        this.sizeSlider.setValue((int)this.pen.getSize());
        this.sizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e){
                JSlider eventObject = (JSlider)e.getSource();
                int widthValue = eventObject.getValue();
                pen.setSize(widthValue);
                sizeField.setText(String.valueOf(widthValue));
            }
        });

        this.sizeField = new JTextField();
        this.sizeField.setPreferredSize(new Dimension(50, 30));
        this.sizeField.setText(String.valueOf(this.pen.getSize()));
        this.sizeField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    JTextField source = (JTextField)e.getSource();
                    String newValueString = source.getText();
                    int newValue = Integer.parseInt(newValueString);
                    if(newValue < 1) return;
                    widthSlider.setValue(newValue);
                    pen.setSize(newValue);
                } catch (NumberFormatException ex){
                    return;
                }
            }
        });


        JPanel sizePanel = new JPanel();
        sizePanel.setLayout(new FlowLayout());
        sizePanel.add(new JLabel("Size: "));
        sizePanel.add(this.sizeSlider);
        sizePanel.add(this.sizeField);


        this.opacitySlider = new JSlider();
        this.opacitySlider.setMinimum(0);
        this.opacitySlider.setMaximum(100);
        this.opacitySlider.setValue((int)this.pen.getOpacity());
        this.opacitySlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e){
                JSlider eventObject = (JSlider)e.getSource();
                int opacityValue = eventObject.getValue();
                pen.setOpacity((float)opacityValue);
                opacityField.setText(String.valueOf(opacityValue));
            }
        });

        this.opacityField = new JTextField();
        this.opacityField.setPreferredSize(new Dimension(50, 30));
        this.opacityField.setText(String.valueOf((int)this.pen.getOpacity()));
        this.opacityField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    JTextField source = (JTextField)e.getSource();
                    String newValueString = source.getText();
                    int newValue = Integer.parseInt(newValueString);
                    if(newValue < 1 || newValue > 100) return;
                    opacitySlider.setValue(newValue);
                    pen.setOpacity(newValue);
                } catch (NumberFormatException ex){
                    return;
                }
            }
        });

        JPanel colorSelector = new JPanel();
        colorSelector.setLayout(new GridLayout(10, 2));
        colorSelector.setPreferredSize(new Dimension(300, 300));

        for(int i = 0; i < 20; i++){
            final int index = i;
            JButton colorButton = new JButton();
            colorButton.setBackground(colors[i]);
            colorButton.setForeground(colors[i]);
            colorButton.setBorderPainted(false);
            colorButton.setOpaque(true);
            colorButton.setPreferredSize(new Dimension(30, 30));
            colorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    pen.setColor(colors[index]);
                }
            });
            colorSelector.add(colorButton);
        }

        JPanel opacityPanel = new JPanel();
        opacityPanel.setLayout(new FlowLayout());
        opacityPanel.add(new JLabel("Opacity: "));
        opacityPanel.add(this.opacitySlider);
        opacityPanel.add(this.opacityField);

        JButton penButton = new JButton("PEN");
        penButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                graphicsPanel.setTool(SelectedTool.PEN);
            }
        });
        JButton circleButton = new JButton("CIRCLE");
        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                graphicsPanel.setTool(SelectedTool.CIRCLE);
            }
        });
        JButton squareButton = new JButton("SQUARE");
        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                graphicsPanel.setTool(SelectedTool.SQUARE);
            }
        });
        JButton xButton = new JButton("X");
        xButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                graphicsPanel.setTool(SelectedTool.X);
            }
        });
        JPanel toolPanel = new JPanel();
        toolPanel.setLayout(new FlowLayout());
        toolPanel.add(penButton);
        toolPanel.add(circleButton);
        toolPanel.add(squareButton);
        toolPanel.add(xButton);


        JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                graphicsPanel.clearPanel();
            }
        });
        JPanel miscPanel = new JPanel();
        miscPanel.setLayout(new FlowLayout());
        miscPanel.add(reset);
        

        JTextField hexInput = new JTextField();
        hexInput.setColumns(6);
        hexInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JTextField converted = (JTextField)e.getSource();
                String hexValue = converted.getText();
                Color color = Pen.convertHexToRGB(hexValue);
                pen.setColor(color);
            }
        });

        JPanel hexInputPanel = new JPanel();
        hexInputPanel.setLayout(new FlowLayout());
        hexInputPanel.add(new JLabel("HEX"));
        hexInputPanel.add(hexInput);
        
        
        super.add(widthPanel);
        super.add(sizePanel);
        super.add(opacityPanel);
        super.add(toolPanel);
        super.add(miscPanel);
        super.add(colorSelector);
        super.add(hexInputPanel);
    }
}
public class CombinedApp extends JFrame {
    private GraphicsPanel gpanel;
    private JPanel controlPanel;
    private Pen pen;

    
    public CombinedApp(){
        super();
        Container container = this.getContentPane();
        this.pen = new Pen(5);
        this.gpanel = new GraphicsPanel(1500, 1080, pen);
        this.controlPanel = new ControlPanel(pen, this.gpanel);
        
        JPanel masterPanel = new JPanel();
        masterPanel.setLayout(new BorderLayout());
        masterPanel.add(this.gpanel, BorderLayout.WEST);
        masterPanel.add(this.controlPanel, BorderLayout.EAST);


        container.add(masterPanel);
    }
    public static void main(String[] args){
        CombinedApp control = new CombinedApp();
        control.setVisible(true);
        control.setLocation(0, 0);
        control.setExtendedState(Frame.MAXIMIZED_BOTH);
        control.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}