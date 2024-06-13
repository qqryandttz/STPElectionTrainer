import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class PanelMain extends JPanel{

    InterfaceExecution IE;
    JPanel panelExample;
    JRadioButton radioButton1,radioButton2,radioButton3,radioButton4;
    ButtonGroup buttonGroup;

    PanelMain(InterfaceExecution interfaceExecution){
        IE = interfaceExecution;
        setLayout(null);


        ADDpanelExample();
        ADDselectedMode();

    }

    void ADDpanelExample(){

        if (IE.OI.intExample == 1) {
            panelExample = new PanelMainOne();
        } else if (IE.OI.intExample == 2) {
            panelExample = new PanelMainTwo();
        } else if (IE.OI.intExample == 3) {
            panelExample = new PanelMainThree();
        } 
        panelExample.setBounds(30, 38, 480, 300);
        add(panelExample);

    }

    void ADDselectedMode(){

        radioButton1 = new JRadioButton("<html><font face='黑体' size='6'>调参模式</font></html>");
        radioButton2 = new JRadioButton("<html><font face='黑体' size='6'>推测模式</font></html>");
        radioButton3 = new JRadioButton("<html><font face='黑体' size='6'>运行模式</font></html>");
        radioButton4 = new JRadioButton("<html><font face='黑体' size='6'>比较模式</font></html>");

        radioButton1.setBounds(550, 52, 187, 37);
        radioButton2.setBounds(550, 127, 187, 37);
        radioButton3.setBounds(550, 202, 187, 37);
        radioButton4.setBounds(550, 277, 187, 37);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);
        buttonGroup.add(radioButton4);

        radioButton1.addActionListener(e -> System.out.println("1"));
        radioButton2.addActionListener(e -> System.out.println("2"));
        radioButton3.addActionListener(e -> System.out.println("3"));
        radioButton4.addActionListener(e -> System.out.println("4"));

        add(radioButton1);
        add(radioButton2);
        add(radioButton3);
        add(radioButton4);

    }

    @Override  
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
        g2d.setColor(getBackground());
        g2d.fill(roundedRectangle);
        

    }

}

class PanelMainOne extends JPanel{

    private static final int RECT_WIDTH = 310;
    private static final int RECT_HEIGHT = 155;
    private static final int LINE_WIDTH = 5;

    PanelMainOne() {
        setBackground(new Color(0x86, 0xc2, 0x32));

    }

    @Override
    protected void paintComponent(Graphics g) {

        setBackground(new Color(0x86, 0xc2, 0x32));
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
        g2d.fill(roundedRectangle);


        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int x = (panelWidth - RECT_WIDTH) / 2;
        int y = (panelHeight - RECT_HEIGHT) / 2;

        g2d.setStroke(new BasicStroke(LINE_WIDTH));
        g.setColor(new Color(0xf5, 0xf5, 0xf5));
        g2d.drawRect(x, y, RECT_WIDTH, RECT_HEIGHT);

        g2d.setColor(new Color(0x47, 0x4b, 0x4f));
        g2d.fillOval(x - 10, y - 10, 20, 20);
        g2d.fillOval(x + RECT_WIDTH - 10, y - 10, 20, 20); // 右上
        g2d.fillOval(x - 10, y + RECT_HEIGHT - 10, 20, 20); // 左下
        g2d.fillOval(x + RECT_WIDTH - 10, y + RECT_HEIGHT - 10, 20, 20); // 右下
    }

}

class PanelMainTwo extends JPanel{

    PanelMainTwo() {
        setBackground(new Color(0x86, 0xc2, 0x32));

    }

}

class PanelMainThree extends JPanel{

    PanelMainThree() {
        setBackground(new Color(0x86, 0xc2, 0x32));

    }

}

