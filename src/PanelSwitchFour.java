import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//4交换机面板
class PanelSwitchFour1 extends JPanel {

    PanelSwitch ps1, ps2, ps3, ps4;
    NetworkTopology neT;

    PanelSwitchFour1(NetworkTopology anet) {

        neT = anet;
        setLayout(null);
        setOpaque(false);
        ADDPanelSwitch();
    }

    void ADDPanelSwitch() {

        ps1 = new PanelSwitch(neT.switch11, neT);
        ps2 = new PanelSwitch(neT.switch12, neT);
        ps3 = new PanelSwitch(neT.switch13, neT);
        ps4 = new PanelSwitch(neT.switch14, neT);

        ps1.setBounds(60, 0, 337, 337);
        ps2.setBounds(435, 0, 337, 337);
        ps3.setBounds(810, 0, 337, 337);
        ps4.setBounds(1185, 0, 337, 337);

        add(ps1);
        add(ps2);
        add(ps3);
        add(ps4);

    }

}

class PanelSwitchFour2 extends JPanel {

    PanelSwitch ps1, ps2, ps3, ps4;
    NetworkTopology neT;

    PanelSwitchFour2(NetworkTopology anet) {

        neT = anet;
        setLayout(null);
        setOpaque(false);
        ADDPanelSwitch();
    }

    void ADDPanelSwitch() {

        ps1 = new PanelSwitch(neT.switch21, neT);
        ps2 = new PanelSwitch(neT.switch22, neT);
        ps3 = new PanelSwitch(neT.switch23, neT);
        ps4 = new PanelSwitch(neT.switch24, neT);

        ps1.setBounds(60, 0, 337, 337);
        ps2.setBounds(435, 0, 337, 337);
        ps3.setBounds(810, 0, 337, 337);
        ps4.setBounds(1185, 0, 337, 337);

        add(ps1);
        add(ps2);
        add(ps3);
        add(ps4);

    }

}

// 5交换机面板
class PanelSwitchFive extends JPanel {

    PanelSwitch ps1, ps2, ps3, ps4, ps5;
    NetworkTopology neT;

    PanelSwitchFive(NetworkTopology anet) {

        neT = anet;
        setLayout(null);
        setOpaque(false);
        ADDPanelSwitch();
    }

    void ADDPanelSwitch() {

        ps1 = new PanelSwitch(neT.switch31, neT);
        ps2 = new PanelSwitch(neT.switch32, neT);
        ps3 = new PanelSwitch(neT.switch33, neT);
        ps4 = new PanelSwitch(neT.switch34, neT);
        ps5 = new PanelSwitch(neT.switch35, neT);

        ps1.setBounds(45, 0, 262, 337);
        ps2.setBounds(345, 0, 262, 337);
        ps3.setBounds(645, 0, 262, 337);
        ps4.setBounds(945, 0, 262, 337);
        ps5.setBounds(1245, 0, 262, 337);

        add(ps1);
        add(ps2);
        add(ps3);
        add(ps4);
        add(ps5);
    }

}

class PanelSwitch extends JPanel {

    Switch myswitch;
    NetworkTopology neT;
    JScrollPane scrollPane;
    JPanel panel;

    String theName, theMAC;
    long thePri;
    JTextField name, MAC, Pri;
    JLabel namePromptWords, MACPromptWords, PriPromptWords;
    JLabel intPIDPromptWords, intStatePromptWords;
    Font PromptWordsFont, TextFieldFont, smallFont;
    Color FontWhiteColor, FontBlackColor, BackgroundColor, BackgroundWhiteColor;
    EmptyBorder Border;

    int intNumber, zhenzhang = 80;
    JLabel intCode1, intTypePromptWords1, intStatePromptWords1, intPriPromptWords1;
    ButtonGroup intcostGroup1, intstateGroup1;
    ColoredRadioButton FEButton1, GEButton1, onButton1, offButton1;
    JTextField intPri1;

    JLabel intCode2, intTypePromptWords2, intStatePromptWords2, intPriPromptWords2;
    ButtonGroup intcostGroup2, intstateGroup2;
    ColoredRadioButton FEButton2, GEButton2, onButton2, offButton2;
    JTextField intPri2;

    JLabel intCode3, intTypePromptWords3, intStatePromptWords3, intPriPromptWords3;
    ButtonGroup intcostGroup3, intstateGroup3;
    ColoredRadioButton FEButton3, GEButton3, onButton3, offButton3;
    JTextField intPri3;

    JLabel intCode4, intTypePromptWords4, intStatePromptWords4, intPriPromptWords4;
    ButtonGroup intcostGroup4, intstateGroup4;
    ColoredRadioButton FEButton4, GEButton4, onButton4, offButton4;
    JTextField intPri4;

    PanelSwitch(Switch aswitch, NetworkTopology anet) {

        myswitch = aswitch;
        neT = anet;
        theName = aswitch.name;
        theMAC = aswitch.mac;
        thePri = aswitch.pri;
        intNumber = aswitch.intNumber;
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {

                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
                g2d.setColor(getBackground());
                g2d.fill(roundedRectangle);

            }
        };

        if ((intNumber == 3 || intNumber == 4) && (anet.Example == 1 || anet.Example == 2)) {
            panel = new JPanel() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(300, 450);
                }

                @Override
                protected void paintComponent(Graphics g) {

                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
                    g2d.setColor(getBackground());
                    g2d.fill(roundedRectangle);

                }
            };
        } else if ((intNumber == 3 || intNumber == 4) && (anet.Example == 3)) {
            panel = new JPanel() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(250, 450);
                }

                @Override
                protected void paintComponent(Graphics g) {

                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
                    g2d.setColor(getBackground());
                    g2d.fill(roundedRectangle);
                }
            };
        } else if ((intNumber == 1 || intNumber == 2) && (anet.Example == 3)) {
            panel = new JPanel() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(250, 300);
                }

                @Override
                protected void paintComponent(Graphics g) {

                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
                    g2d.setColor(getBackground());
                    g2d.fill(roundedRectangle);

                }
            };

        }
        panel.setLayout(null);
        Init();
        ADDLabel();
        ADDTextField();
        ADDintf();
        panel.setBackground(new Color(0xe5, 0xe5, 0xe5));
        scrollPane = new JScrollPane(panel);
        if (anet.Example == 1 || anet.Example == 2) {
            scrollPane.setPreferredSize(new Dimension(337, 337));
        } else if (anet.Example == 3) {
            scrollPane.setPreferredSize(new Dimension(270, 337));
        }

        add(scrollPane, BorderLayout.CENTER);
        ADDswitch();
        ADDintLister();

    }

    void Init() {

        TextFieldFont = new Font("黑体", Font.PLAIN, 17);
        PromptWordsFont = new Font("黑体", Font.PLAIN, 20);
        smallFont = new Font("黑体", Font.PLAIN, 15);
        FontWhiteColor = new Color(0xf5, 0xf5, 0xf5);
        FontBlackColor = new Color(0x22, 0x26, 0x29);
        BackgroundColor = new Color(0x86, 0xc2, 0x32);
        BackgroundWhiteColor = new Color(0xe5, 0xe5, 0xe5);
        Border = new EmptyBorder(0, 0, 0, 0);
    }

    void ADDLabel() {

        namePromptWords = new JLabel("<html>name:</html>");
        namePromptWords.setFont(PromptWordsFont);
        namePromptWords.setForeground(FontBlackColor);
        namePromptWords.setBounds(15, 20, 50, 25);
        namePromptWords.setBackground(BackgroundColor);
        panel.add(namePromptWords);

        MACPromptWords = new JLabel("<html>Mac :</html>");
        MACPromptWords.setFont(PromptWordsFont);
        MACPromptWords.setForeground(FontBlackColor);
        MACPromptWords.setBounds(15, 50, 50, 25);
        MACPromptWords.setBackground(BackgroundColor);
        panel.add(MACPromptWords);

        PriPromptWords = new JLabel("<html>Pri :</html>");
        PriPromptWords.setFont(PromptWordsFont);
        PriPromptWords.setForeground(FontBlackColor);
        PriPromptWords.setBounds(15, 75, 50, 25);
        PriPromptWords.setBackground(BackgroundColor);
        panel.add(PriPromptWords);
    }

    void ADDTextField() {

        name = new JTextField(theName);
        name.setFont(TextFieldFont);
        name.setForeground(FontWhiteColor);
        name.setBounds(70, 22, 170, 20);
        name.setBackground(BackgroundColor);
        name.setBorder(Border);
        panel.add(name);

        MAC = new JTextField(theMAC);
        MAC.setFont(TextFieldFont);
        MAC.setForeground(FontWhiteColor);
        MAC.setBounds(70, 52, 170, 20);
        MAC.setBackground(BackgroundColor);
        MAC.setBorder(Border);
        panel.add(MAC);

        Pri = new JTextField("32768");
        Pri.setFont(TextFieldFont);
        Pri.setForeground(FontWhiteColor);
        Pri.setBounds(70, 82, 170, 20);
        Pri.setBackground(BackgroundColor);
        Pri.setBorder(Border);
        panel.add(Pri);

    }

    void ADDintf() {

        if (true) {

            intCode1 = new JLabel("<html><font face='黑体' size='4'><接口1></font></html>");
            intCode1.setForeground(FontBlackColor);
            intCode1.setBounds(15, 110, 50, 25);
            intCode1.setBackground(BackgroundColor);
            panel.add(intCode1);

            intStatePromptWords1 = new JLabel("state:");
            intStatePromptWords1.setForeground(FontBlackColor);
            intStatePromptWords1.setBounds(65, 110, 50, 25);
            intStatePromptWords1.setBackground(BackgroundColor);
            intStatePromptWords1.setFont(smallFont);
            panel.add(intStatePromptWords1);

            intTypePromptWords1 = new JLabel("type:");
            intTypePromptWords1.setForeground(FontBlackColor);
            intTypePromptWords1.setBounds(30, 135, 50, 25);
            intTypePromptWords1.setBackground(BackgroundColor);
            intTypePromptWords1.setFont(smallFont);
            panel.add(intTypePromptWords1);

            intPriPromptWords1 = new JLabel("Pri:");
            intPriPromptWords1.setForeground(FontBlackColor);
            intPriPromptWords1.setBounds(33, 160, 50, 30);
            intPriPromptWords1.setBackground(BackgroundColor);
            intPriPromptWords1.setFont(smallFont);
            panel.add(intPriPromptWords1);

            onButton1 = new ColoredRadioButton("ON");
            offButton1 = new ColoredRadioButton("OFF");
            FEButton1 = new ColoredRadioButton("FE[19]");
            GEButton1 = new ColoredRadioButton("GE[4]");

            onButton1.setFont(smallFont);
            offButton1.setFont(smallFont);
            FEButton1.setFont(smallFont);
            GEButton1.setFont(smallFont);

            onButton1.setBackground(BackgroundWhiteColor);
            offButton1.setBackground(BackgroundWhiteColor);
            FEButton1.setBackground(BackgroundWhiteColor);
            GEButton1.setBackground(BackgroundWhiteColor);

            onButton1.setForeground(FontBlackColor);
            offButton1.setForeground(FontBlackColor);
            FEButton1.setForeground(FontBlackColor);
            GEButton1.setForeground(FontBlackColor);

            onButton1.setBounds(115, 110, 50, 25);
            offButton1.setBounds(175, 110, 50, 25);
            FEButton1.setBounds(70, 137, 100, 25);
            GEButton1.setBounds(175, 137, 120, 25);
            intcostGroup1 = new ButtonGroup();
            intstateGroup1 = new ButtonGroup();

            intcostGroup1.add(onButton1);
            intcostGroup1.add(offButton1);
            intstateGroup1.add(FEButton1);
            intstateGroup1.add(GEButton1);
            panel.add(onButton1);
            panel.add(offButton1);
            panel.add(FEButton1);
            panel.add(GEButton1);
            onButton1.setSelected(true);
            GEButton1.setSelected(true);

            intPri1 = new JTextField("32768");
            intPri1.setFont(TextFieldFont);
            intPri1.setForeground(FontWhiteColor);
            intPri1.setBounds(75, 167, 140, 20);
            intPri1.setBackground(BackgroundColor);
            intPri1.setBorder(Border);
            intPri1.setFont(smallFont);
            panel.add(intPri1);

            if (intNumber > 1) {

                intCode2 = new JLabel("<html><font face='黑体' size='4'><接口2></font></html>");
                intCode2.setForeground(FontBlackColor);
                intCode2.setBounds(15, 110 + zhenzhang, 50, 25);
                intCode2.setBackground(BackgroundColor);
                panel.add(intCode2);

                intStatePromptWords2 = new JLabel("state:");
                intStatePromptWords2.setForeground(FontBlackColor);
                intStatePromptWords2.setBounds(65, 110 + zhenzhang, 50, 25);
                intStatePromptWords2.setBackground(BackgroundColor);
                intStatePromptWords2.setFont(smallFont);
                panel.add(intStatePromptWords2);

                intTypePromptWords2 = new JLabel("type:");
                intTypePromptWords2.setForeground(FontBlackColor);
                intTypePromptWords2.setBounds(30, 135 + zhenzhang, 50, 25);
                intTypePromptWords2.setBackground(BackgroundColor);
                intTypePromptWords2.setFont(smallFont);
                panel.add(intTypePromptWords2);

                intPriPromptWords2 = new JLabel("Pri:");
                intPriPromptWords2.setForeground(FontBlackColor);
                intPriPromptWords2.setBounds(33, 160 + zhenzhang, 50, 30);
                intPriPromptWords2.setBackground(BackgroundColor);
                intPriPromptWords2.setFont(smallFont);
                panel.add(intPriPromptWords2);

                onButton2 = new ColoredRadioButton("ON");
                offButton2 = new ColoredRadioButton("OFF");
                FEButton2 = new ColoredRadioButton("FE[19]");
                GEButton2 = new ColoredRadioButton("GE[4]");

                onButton2.setFont(smallFont);
                offButton2.setFont(smallFont);
                FEButton2.setFont(smallFont);
                GEButton2.setFont(smallFont);

                onButton2.setBackground(BackgroundWhiteColor);
                offButton2.setBackground(BackgroundWhiteColor);
                FEButton2.setBackground(BackgroundWhiteColor);
                GEButton2.setBackground(BackgroundWhiteColor);

                onButton2.setForeground(FontBlackColor);
                offButton2.setForeground(FontBlackColor);
                FEButton2.setForeground(FontBlackColor);
                GEButton2.setForeground(FontBlackColor);

                onButton2.setBounds(115, 110 + zhenzhang, 50, 25);
                offButton2.setBounds(175, 110 + zhenzhang, 50, 25);
                FEButton2.setBounds(70, 137 + zhenzhang, 100, 25);
                GEButton2.setBounds(175, 137 + zhenzhang, 120, 25);
                intcostGroup2 = new ButtonGroup();
                intstateGroup2 = new ButtonGroup();

                intcostGroup2.add(onButton2);
                intcostGroup2.add(offButton2);
                intstateGroup2.add(FEButton2);
                intstateGroup2.add(GEButton2);
                panel.add(onButton2);
                panel.add(offButton2);
                panel.add(FEButton2);
                panel.add(GEButton2);
                onButton2.setSelected(true);
                GEButton2.setSelected(true);

                intPri2 = new JTextField("32768");
                intPri2.setFont(TextFieldFont);
                intPri2.setForeground(FontWhiteColor);
                intPri2.setBounds(75, 167 + zhenzhang, 140, 20);
                intPri2.setBackground(BackgroundColor);
                intPri2.setBorder(Border);
                intPri2.setFont(smallFont);
                panel.add(intPri2);

                if (intNumber > 2) {

                    intCode3 = new JLabel("<html><font face='黑体' size='4'><接口3></font></html>");
                    intCode3.setForeground(FontBlackColor);
                    intCode3.setBounds(15, 110 + zhenzhang * 2, 50, 25);
                    intCode3.setBackground(BackgroundColor);
                    panel.add(intCode3);

                    intStatePromptWords3 = new JLabel("state:");
                    intStatePromptWords3.setForeground(FontBlackColor);
                    intStatePromptWords3.setBounds(65, 110 + zhenzhang * 2, 50, 25);
                    intStatePromptWords3.setBackground(BackgroundColor);
                    intStatePromptWords3.setFont(smallFont);
                    panel.add(intStatePromptWords3);

                    intTypePromptWords3 = new JLabel("type:");
                    intTypePromptWords3.setForeground(FontBlackColor);
                    intTypePromptWords3.setBounds(30, 135 + zhenzhang * 2, 50, 25);
                    intTypePromptWords3.setBackground(BackgroundColor);
                    intTypePromptWords3.setFont(smallFont);
                    panel.add(intTypePromptWords3);

                    intPriPromptWords3 = new JLabel("Pri:");
                    intPriPromptWords3.setForeground(FontBlackColor);
                    intPriPromptWords3.setBounds(33, 160 + zhenzhang * 2, 50, 30);
                    intPriPromptWords3.setBackground(BackgroundColor);
                    intPriPromptWords3.setFont(smallFont);
                    panel.add(intPriPromptWords3);

                    onButton3 = new ColoredRadioButton("ON");
                    offButton3 = new ColoredRadioButton("OFF");
                    FEButton3 = new ColoredRadioButton("FE[19]");
                    GEButton3 = new ColoredRadioButton("GE[4]");

                    onButton3.setFont(smallFont);
                    offButton3.setFont(smallFont);
                    FEButton3.setFont(smallFont);
                    GEButton3.setFont(smallFont);

                    onButton3.setBackground(BackgroundWhiteColor);
                    offButton3.setBackground(BackgroundWhiteColor);
                    FEButton3.setBackground(BackgroundWhiteColor);
                    GEButton3.setBackground(BackgroundWhiteColor);

                    onButton3.setForeground(FontBlackColor);
                    offButton3.setForeground(FontBlackColor);
                    FEButton3.setForeground(FontBlackColor);
                    GEButton3.setForeground(FontBlackColor);

                    onButton3.setBounds(115, 110 + zhenzhang * 2, 50, 25);
                    offButton3.setBounds(175, 110 + zhenzhang * 2, 50, 25);
                    FEButton3.setBounds(70, 137 + zhenzhang * 2, 100, 25);
                    GEButton3.setBounds(175, 137 + zhenzhang * 2, 120, 25);
                    intcostGroup3 = new ButtonGroup();
                    intstateGroup3 = new ButtonGroup();

                    intcostGroup3.add(onButton3);
                    intcostGroup3.add(offButton3);
                    intstateGroup3.add(FEButton3);
                    intstateGroup3.add(GEButton3);
                    panel.add(onButton3);
                    panel.add(offButton3);
                    panel.add(FEButton3);
                    panel.add(GEButton3);
                    onButton3.setSelected(true);
                    GEButton3.setSelected(true);

                    intPri3 = new JTextField("32768");
                    intPri3.setFont(TextFieldFont);
                    intPri3.setForeground(FontWhiteColor);
                    intPri3.setBounds(75, 167 + zhenzhang * 2, 140, 20);
                    intPri3.setBackground(BackgroundColor);
                    intPri3.setBorder(Border);
                    intPri3.setFont(smallFont);
                    panel.add(intPri3);

                    if (intNumber > 3) {

                        intCode4 = new JLabel("<html><font face='黑体' size='4'><接口4></font></html>");
                        intCode4.setForeground(FontBlackColor);
                        intCode4.setBounds(15, 110 + zhenzhang * 3, 50, 25);
                        intCode4.setBackground(BackgroundColor);
                        panel.add(intCode4);

                        intStatePromptWords4 = new JLabel("state:");
                        intStatePromptWords4.setForeground(FontBlackColor);
                        intStatePromptWords4.setBounds(65, 110, 50, 25);
                        intStatePromptWords4.setBackground(BackgroundColor);
                        intStatePromptWords4.setFont(smallFont);
                        panel.add(intStatePromptWords4);

                        intTypePromptWords4 = new JLabel("type:");
                        intTypePromptWords4.setForeground(FontBlackColor);
                        intTypePromptWords4.setBounds(30, 135 + zhenzhang * 3, 50, 25);
                        intTypePromptWords4.setBackground(BackgroundColor);
                        intTypePromptWords4.setFont(smallFont);
                        panel.add(intTypePromptWords4);

                        intPriPromptWords4 = new JLabel("Pri:");
                        intPriPromptWords4.setForeground(FontBlackColor);
                        intPriPromptWords4.setBounds(33, 160 + zhenzhang * 3, 50, 30);
                        intPriPromptWords4.setBackground(BackgroundColor);
                        intPriPromptWords4.setFont(smallFont);
                        panel.add(intPriPromptWords4);

                        onButton4 = new ColoredRadioButton("ON");
                        offButton4 = new ColoredRadioButton("OFF");
                        FEButton4 = new ColoredRadioButton("FE[19]");
                        GEButton4 = new ColoredRadioButton("GE[4]");

                        onButton4.setFont(smallFont);
                        offButton4.setFont(smallFont);
                        FEButton4.setFont(smallFont);
                        GEButton4.setFont(smallFont);

                        onButton4.setBackground(BackgroundWhiteColor);
                        offButton4.setBackground(BackgroundWhiteColor);
                        FEButton4.setBackground(BackgroundWhiteColor);
                        GEButton4.setBackground(BackgroundWhiteColor);

                        onButton4.setForeground(FontBlackColor);
                        offButton4.setForeground(FontBlackColor);
                        FEButton4.setForeground(FontBlackColor);
                        GEButton4.setForeground(FontBlackColor);

                        onButton4.setBounds(115, 110 + zhenzhang * 3, 50, 25);
                        offButton4.setBounds(175, 110 + zhenzhang * 3, 50, 25);
                        FEButton4.setBounds(70, 137 + zhenzhang * 3, 100, 25);
                        GEButton4.setBounds(175, 137 + zhenzhang * 3, 120, 25);
                        intcostGroup4 = new ButtonGroup();
                        intstateGroup4 = new ButtonGroup();

                        intcostGroup4.add(onButton4);
                        intcostGroup4.add(offButton4);
                        intstateGroup4.add(FEButton4);
                        intstateGroup4.add(GEButton4);
                        panel.add(onButton4);
                        panel.add(offButton4);
                        panel.add(FEButton4);
                        panel.add(GEButton4);
                        onButton4.setSelected(true);
                        GEButton4.setSelected(true);

                        intPri4 = new JTextField("32768");
                        intPri4.setFont(TextFieldFont);
                        intPri4.setForeground(FontWhiteColor);
                        intPri4.setBounds(75, 167 + zhenzhang * 3, 140, 20);
                        intPri4.setBackground(BackgroundColor);
                        intPri4.setBorder(Border);
                        intPri4.setFont(smallFont);
                        panel.add(intPri4);

                    }
                }
            }
        }

    }

    void ADDswitch() {

        name.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("文本被插入: " + name.getText());
                myswitch.name = name.getText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("文本被删除: " + name.getText());
                myswitch.name = name.getText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("文本内容已更改: " + name.getText());
                myswitch.name = name.getText();
            }
        });

        MAC.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("文本被插入: " + MAC.getText());
                myswitch.mac = MAC.getText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("文本被删除: " + MAC.getText());
                myswitch.mac = MAC.getText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("文本内容已更改: " + MAC.getText());
                myswitch.mac = MAC.getText();
            }
        });

        Pri.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("文本被插入: " + Pri.getText());
                myswitch.pri = Long.parseLong(Pri.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("文本被删除: " + Pri.getText());
                myswitch.pri = Long.parseLong(Pri.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("文本内容已更改: " + Pri.getText());
                myswitch.pri = Long.parseLong(Pri.getText());
            }
        });

    }

    void ADDintLister() {

        if (true) {

            intPri1.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    System.out.println("文本被插入: " + intPri1.getText());
                    myswitch.Interface1.pri = Long.parseLong(intPri1.getText());
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    System.out.println("文本被删除: " + intPri1.getText());
                    myswitch.Interface1.pri = Long.parseLong(intPri1.getText());
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    System.out.println("文本内容已更改: " + intPri1.getText());
                    myswitch.Interface1.pri = Long.parseLong(intPri1.getText());
                }
            });

            onButton1.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        System.out.println("选中");
                        myswitch.Interface1.state = true;

                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        System.out.println("未选中");
                        myswitch.Interface1.state = false;
                    }
                }
            });

            FEButton1.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        myswitch.Interface1.cost = 19;

                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        myswitch.Interface1.cost = 4;
                    }
                }
            });

        }

        if (intNumber > 1) {

            intPri2.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    System.out.println("文本被插入: " + intPri2.getText());
                    myswitch.Interface2.pri = Long.parseLong(intPri2.getText());
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    System.out.println("文本被删除: " + intPri2.getText());
                    myswitch.Interface2.pri = Long.parseLong(intPri2.getText());
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    System.out.println("文本内容已更改: " + intPri2.getText());
                    myswitch.Interface2.pri = Long.parseLong(intPri2.getText());
                }
            });

            onButton2.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        myswitch.Interface2.state = true;

                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        myswitch.Interface2.state = false;
                    }
                }
            });

            FEButton2.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        myswitch.Interface2.cost = 19;

                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        myswitch.Interface2.cost = 4;
                    }
                }
            });

        }

        if (intNumber > 2) {

            intPri3.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    System.out.println("文本被插入: " + intPri3.getText());
                    myswitch.Interface3.pri = Long.parseLong(intPri3.getText());
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    System.out.println("文本被删除: " + intPri3.getText());
                    myswitch.Interface3.pri = Long.parseLong(intPri3.getText());
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    System.out.println("文本内容已更改: " + intPri3.getText());
                    myswitch.Interface3.pri = Long.parseLong(intPri3.getText());
                }
            });

            onButton3.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        myswitch.Interface3.state = true;

                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        myswitch.Interface3.state = false;
                    }
                }
            });

            FEButton3.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        myswitch.Interface3.cost = 19;

                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        myswitch.Interface3.cost = 4;
                    }
                }
            });

        }

        if (intNumber > 3) {

            intPri4.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    System.out.println("文本被插入: " + intPri4.getText());
                    myswitch.Interface4.pri = Long.parseLong(intPri4.getText());
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    System.out.println("文本被删除: " + intPri4.getText());
                    myswitch.Interface4.pri = Long.parseLong(intPri4.getText());
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    System.out.println("文本内容已更改: " + intPri4.getText());
                    myswitch.Interface4.pri = Long.parseLong(intPri4.getText());
                }
            });

            onButton4.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        myswitch.Interface4.state = true;

                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        myswitch.Interface4.state = false;
                    }
                }
            });

            FEButton4.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        myswitch.Interface4.cost = 19;

                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        myswitch.Interface4.cost = 4;
                    }
                }
            });

        }

    }

}