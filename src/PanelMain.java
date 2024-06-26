import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class PanelMain extends JPanel {

    InterfaceExecution IE;
    NetworkTopology net;
    Election election;
    JPanel panelExample;
    ColoredRadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    ButtonGroup buttonGroup;
    Color BackgroundColor;
    int isModel = 1; // 1为调参，2为推测，3为运行，4为比较

    PanelMain(InterfaceExecution interfaceExecution, NetworkTopology Net) {
        IE = interfaceExecution;
        net = Net;
        setLayout(null);
        BackgroundColor = new Color(0xf5, 0xf5, 0xf5);
        setBackground(BackgroundColor);

        ADDpanelExample();
        ADDselectedMode();

    }

    void ADDpanelExample() {

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

    void ADDselectedMode() {

        radioButton1 = new ColoredRadioButton("<html><font face='黑体' size='6'>调参模式</font></html>");
        radioButton2 = new ColoredRadioButton("<html><font face='黑体' size='6'>保存推测</font></html>");
        radioButton3 = new ColoredRadioButton("<html><font face='黑体' size='6'>运行模式</font></html>");
        radioButton4 = new ColoredRadioButton("<html><font face='黑体' size='6'>进行比较</font></html>");

        radioButton1.setBackground(BackgroundColor);
        radioButton2.setBackground(BackgroundColor);
        radioButton3.setBackground(BackgroundColor);
        radioButton4.setBackground(BackgroundColor);

        radioButton1.setBounds(550, 52, 187, 37);
        radioButton2.setBounds(550, 127, 187, 37);
        radioButton3.setBounds(550, 202, 187, 37);
        radioButton4.setBounds(550, 277, 187, 37);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);
        buttonGroup.add(radioButton4);

        radioButton1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    isModel = 1;
                    radioButton3.setEnabled(false);
                    radioButton4.setEnabled(false);

                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    radioButton3.setEnabled(true);
                    radioButton4.setEnabled(true);
                }
            }
        });

        radioButton2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    isModel = 2;
                    radioButton4.setEnabled(false);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    radioButton4.setEnabled(true);
                }
            }
        });

        radioButton3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    isModel = 3;
                    radioButton1.setEnabled(false);
                    radioButton2.setEnabled(false);
                    IE.OI.starrySkyPanel.startFastMove();
                    net.updateGraph();
                    election = new Election(net, IE);
                    // 开始算法
                    // 调用组件
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    radioButton1.setEnabled(true);
                    radioButton2.setEnabled(true);

                }
            }
        });

        radioButton4.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    isModel = 4;
                    radioButton2.setEnabled(false);
                    radioButton3.setEnabled(false);

                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    radioButton2.setEnabled(true);
                    radioButton3.setEnabled(true);

                }
            }
        });

        add(radioButton1);
        add(radioButton2);
        add(radioButton3);
        add(radioButton4);
        radioButton1.setSelected(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
        g2d.setColor(getBackground());
        g2d.fill(roundedRectangle);

    }

}

class PanelMainOne extends JPanel {

    private static final int RECT_WIDTH = 310;
    private static final int RECT_HEIGHT = 155;
    private static final int LINE_WIDTH = 5;
    roundedButton S1, S2, S3, S4;
    Color buttonFontColor, ButtonBackColor;

    PanelMainOne() {
        ADDbtnswitch();
        setLayout(null);
    }

    void ADDbtnswitch() {

        int x = 72, y = 72;
        S1 = new roundedButton("<html><font face='黑体' size='6'>S1 </font></html>", 15);
        S2 = new roundedButton("<html><font face='黑体' size='6'>S2 </font></html>", 15);
        S3 = new roundedButton("<html><font face='黑体' size='6'>S3 </font></html>", 15);
        S4 = new roundedButton("<html><font face='黑体' size='6'>S4 </font></html>", 15);
        buttonFontColor = new Color(0xf5, 0xf5, 0xf5);
        S1.setForeground(buttonFontColor);
        S2.setForeground(buttonFontColor);
        S3.setForeground(buttonFontColor);
        S4.setForeground(buttonFontColor);

        ButtonBackColor = new Color(0x47, 0x4b, 0x4f);
        S1.setBackground(ButtonBackColor);
        S2.setBackground(ButtonBackColor);
        S3.setBackground(ButtonBackColor);
        S4.setBackground(ButtonBackColor);

        S1.setBounds(x - 10, y - 20, 55, 38);
        S2.setBounds(x + 310 - 10, y - 20, 55, 38);
        S3.setBounds(x - 10, y + 155 - 15, 55, 38);
        S4.setBounds(x + 310 - 10, y + 155 - 15, 55, 38);

        add(S1);
        add(S2);
        add(S3);
        add(S4);

    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
        g2d.setColor(getBackground());
        g2d.fill(roundedRectangle);

        setBackground(new Color(0x86, 0xc2, 0x32));
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

class PanelMainTwo extends JPanel {

    private static final int RECT_WIDTH = 310;
    private static final int RECT_HEIGHT = 155;
    private static final int LINE_WIDTH = 5;
    roundedButton S1, S2, S3, S4;
    Color buttonFontColor, ButtonBackColor;

    PanelMainTwo() {
        ADDbtnswitch();
        setLayout(null);
    }

    void ADDbtnswitch() {

        int x = 72, y = 72;
        S1 = new roundedButton("<html><font face='黑体' size='6'>S1 </font></html>", 15);
        S2 = new roundedButton("<html><font face='黑体' size='6'>S2 </font></html>", 15);
        S3 = new roundedButton("<html><font face='黑体' size='6'>S3 </font></html>", 15);
        S4 = new roundedButton("<html><font face='黑体' size='6'>S4 </font></html>", 15);
        buttonFontColor = new Color(0xf5, 0xf5, 0xf5);
        S1.setForeground(buttonFontColor);
        S2.setForeground(buttonFontColor);
        S3.setForeground(buttonFontColor);
        S4.setForeground(buttonFontColor);

        ButtonBackColor = new Color(0x47, 0x4b, 0x4f);
        S1.setBackground(ButtonBackColor);
        S2.setBackground(ButtonBackColor);
        S3.setBackground(ButtonBackColor);
        S4.setBackground(ButtonBackColor);

        S1.setBounds(x - 10, y - 20, 55, 38);
        S2.setBounds(x + 310 - 10, y - 20, 55, 38);
        S3.setBounds(x - 10, y + 155 - 15, 55, 38);
        S4.setBounds(x + 310 - 10, y + 155 - 15, 55, 38);

        add(S1);
        add(S2);
        add(S3);
        add(S4);

    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
        g2d.setColor(getBackground());
        g2d.fill(roundedRectangle);

        setBackground(new Color(0x86, 0xc2, 0x32));

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int x = (panelWidth - RECT_WIDTH) / 2;
        int y = (panelHeight - RECT_HEIGHT) / 2;

        g2d.setStroke(new BasicStroke(LINE_WIDTH));
        g.setColor(new Color(0xf5, 0xf5, 0xf5));
        g2d.drawLine(x, y, x + 310, y + 155);
        g2d.drawLine(x, y, x + 310, y);
        g2d.drawLine(x, y, x, y + 155);
        g2d.drawLine(x + 310, y, x, y + 155);
        g2d.drawLine(x + 310, y, x + 310, y + 155);

        g2d.setColor(new Color(0x47, 0x4b, 0x4f));
        g2d.fillOval(x - 10, y - 10, 20, 20);
        g2d.fillOval(x + RECT_WIDTH - 10, y - 10, 20, 20); // 右上
        g2d.fillOval(x - 10, y + RECT_HEIGHT - 10, 20, 20); // 左下
        g2d.fillOval(x + RECT_WIDTH - 10, y + RECT_HEIGHT - 10, 20, 20); // 右下
    }

}

class PanelMainThree extends JPanel {

    private static final int RECT_WIDTH = 310;
    private static final int RECT_HEIGHT = 155;
    private static final int LINE_WIDTH = 5;
    roundedButton S1, S2, S3, S4, S5;
    Color buttonFontColor, ButtonBackColor;

    PanelMainThree() {
        ADDbtnswitch();
        setLayout(null);
    }

    void ADDbtnswitch() {

        int x = 72, y = 72;
        S1 = new roundedButton("<html><font face='黑体' size='6'>S1 </font></html>", 15);
        S2 = new roundedButton("<html><font face='黑体' size='6'>S2 </font></html>", 15);
        S3 = new roundedButton("<html><font face='黑体' size='6'>S3 </font></html>", 15);
        S4 = new roundedButton("<html><font face='黑体' size='6'>S4 </font></html>", 15);
        S5 = new roundedButton("<html><font face='黑体' size='6'>S5 </font></html>", 15);

        buttonFontColor = new Color(0xf5, 0xf5, 0xf5);
        S1.setForeground(buttonFontColor);
        S2.setForeground(buttonFontColor);
        S3.setForeground(buttonFontColor);
        S4.setForeground(buttonFontColor);
        S5.setForeground(buttonFontColor);

        ButtonBackColor = new Color(0x47, 0x4b, 0x4f);
        S1.setBackground(ButtonBackColor);
        S2.setBackground(ButtonBackColor);
        S3.setBackground(ButtonBackColor);
        S4.setBackground(ButtonBackColor);
        S5.setBackground(ButtonBackColor);

        S1.setBounds(x - 10, y - 28, 55, 38);
        S2.setBounds(x + 310 - 10, y - 28, 55, 38);

        S3.setBounds(x - 10, y + 80 - 20, 55, 38);
        S4.setBounds(x + 310 - 10, y + 80 - 20, 55, 38);
        S5.setBounds(x + (310 - 10) / 2 - 8, y + 160, 55, 38);

        add(S1);
        add(S2);
        add(S3);
        add(S4);
        add(S5);
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
        g2d.setColor(getBackground());
        g2d.fill(roundedRectangle);

        setBackground(new Color(0x86, 0xc2, 0x32));

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int x = (panelWidth - RECT_WIDTH) / 2;
        int y = (panelHeight - RECT_HEIGHT) / 2;

        g2d.setStroke(new BasicStroke(LINE_WIDTH));
        g.setColor(new Color(0xf5, 0xf5, 0xf5));
        g2d.drawLine(x, y - 10, x + 310, y + 80);
        g2d.drawLine(x, y - 10, x, y + 80);

        g2d.drawLine(x, y + 80, x + 310, y + 80);
        g2d.drawLine(x, y + 80, x + 155, y + 170);

        g2d.drawLine(x + 310, y + 80, x + 310, y - 10);
        g2d.drawLine(x + 310, y + 80, x + 155, y + 170);

        g2d.setColor(new Color(0x47, 0x4b, 0x4f));
        g2d.fillOval(x - 10, y - 20, 20, 20); // 左上
        g2d.fillOval(x + RECT_WIDTH - 10, y - 20, 20, 20); // 右上

        g2d.fillOval(x - 10, y + 80 - 10, 20, 20); // 左下
        g2d.fillOval(x + RECT_WIDTH - 10, y + 80 - 10, 20, 20); // 右下
        g2d.fillOval(x + (RECT_WIDTH - 10) / 2 - 5, y + 160, 20, 20); // 下
    }

}
