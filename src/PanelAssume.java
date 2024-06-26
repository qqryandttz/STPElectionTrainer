import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;

//推测面板
class PanelAssume extends JPanel {

    InterfaceExecution IE;
    NetworkTopology net;
    Color BackgroundColor;
    Font font;
    MusicPlayer touchButtonSound, pressButtonSound;
    Color buttonFontColor, ButtonBackColor;
    Color btnActiveFontColor, ButtonActiveBackColor;

    roundedButton conzhiButton;
    JLabel root, genduankou, zhidinduankou;
    JLabel PromptWords1, PromptWords2, PromptWords3, PromptWords4, PromptWords5;
    JLabel PromptWords2_1, PromptWords2_2, PromptWords2_3, PromptWords2_4, PromptWords2_5;

    ButtonGroup rootGroup;

    ButtonGroup gButton1_1, gButton1_2, gButton1_3;
    ButtonGroup gButton2_1, gButton2_2, gButton2_3;
    ButtonGroup gButton3_1, gButton3_2, gButton3_3;
    ButtonGroup gButton4_1, gButton4_2, gButton4_3, gButton4_4;
    ButtonGroup gButton5_1, gButton5_2;

    aColoredRadioButton root1, root2, root3, root4, root5;
    ColoredRadioButton Button1_1, Button1_2, Button1_3;
    ColoredRadioButton Button2_1, Button2_2, Button2_3;
    ColoredRadioButton Button3_1, Button3_2, Button3_3;
    ColoredRadioButton Button4_1, Button4_2, Button4_3, Button4_4;
    ColoredRadioButton Button5_1, Button5_2;

    ColoredRadioButton ZButton1_1, ZButton1_2, ZButton1_3;
    ColoredRadioButton ZButton2_1, ZButton2_2, ZButton2_3;
    ColoredRadioButton ZButton3_1, ZButton3_2, ZButton3_3;
    ColoredRadioButton ZButton4_1, ZButton4_2, ZButton4_3, ZButton4_4;
    ColoredRadioButton ZButton5_1, ZButton5_2;

    PanelAssume(InterfaceExecution interfaceExecution, NetworkTopology anet) {

        IE = interfaceExecution;
        net = anet;
        setLayout(null);

        init();
        ADDbotton();
        ADDroot();
        ADDgenduankou();
        ADDzhidinduankou();
        ADDgroup();
    }

    void init() {

        BackgroundColor = new Color(0xf5, 0xf5, 0xf5);
        setBackground(BackgroundColor);
        font = new Font("黑体", Font.PLAIN, 16);
        touchButtonSound = new MusicPlayer("resources\\_200音乐\\触碰按钮声.mp3");
        pressButtonSound = new MusicPlayer("resources\\_200音乐\\按下按钮声.mp3");
        ButtonBackColor = new Color(0x61, 0x89, 0x2f);
        buttonFontColor = new Color(0x22, 0x26, 0x29);
        btnActiveFontColor = new Color(0xee, 0xee, 0xee);
        ButtonActiveBackColor = new Color(0x86, 0xc2, 0x32);
    }

    void ADDbotton() {

        conzhiButton = new roundedButton("重置", 20);
        conzhiButton.setBackground(ButtonBackColor);
        conzhiButton.setForeground(buttonFontColor);
        conzhiButton.setBounds(15, 300, 70, 40);
        conzhiButton.setFont(font);
        add(conzhiButton);

        conzhiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                pressButtonSound.playMusicOnce();
                conzhi();
            }
        });
        conzhiButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                touchButtonSound.playMusicOnce();
                conzhiButton.setForeground(btnActiveFontColor);
                conzhiButton.setBackground(ButtonActiveBackColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {

                conzhiButton.setForeground(buttonFontColor);

            }
        });
    }

    void ADDroot() {

        root = new JLabel("ROOT");
        root.setFont(font);
        root.setBounds(20, 20, 100, 25);
        root.setBackground(BackgroundColor);
        add(root);

        rootGroup = new ButtonGroup();
        root1 = new aColoredRadioButton("SW1");
        root1.setFont(font);
        root1.setBackground(BackgroundColor);
        root1.setBounds(110, 20, 50, 25);
        add(root1);
        rootGroup.add(root1);
        root1.setSelected(true);

        root2 = new aColoredRadioButton("SW2");
        root2.setFont(font);
        root2.setBackground(BackgroundColor);
        root2.setBounds(200, 20, 50, 25);
        add(root2);
        rootGroup.add(root2);

        root3 = new aColoredRadioButton("SW3");
        root3.setFont(font);
        root3.setBackground(BackgroundColor);
        root3.setBounds(290, 20, 50, 25);
        add(root3);
        rootGroup.add(root3);

        root4 = new aColoredRadioButton("SW4");
        root4.setFont(font);
        root4.setBackground(BackgroundColor);
        root4.setBounds(380, 20, 50, 25);
        add(root4);
        rootGroup.add(root4);

        if (net.Example == 3) {

            root5 = new aColoredRadioButton("SW5");
            root5.setFont(font);
            root5.setBackground(BackgroundColor);
            root5.setBounds(470, 20, 50, 25);
            add(root5);
            rootGroup.add(root5);
        }

        ADDrootLister();
    }

    void ADDrootLister() {
        root1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    net.ROOTnumber = 1;
                    zhidinS1();
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    OFFzhidinS1();
                }
            }
        });

        root2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    net.ROOTnumber = 2;
                    zhidinS2();
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    OFFzhidinS2();
                }
            }
        });

        root3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    net.ROOTnumber = 3;
                    zhidinS3();
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    OFFzhidinS3();
                }
            }
        });

        root4.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    net.ROOTnumber = 4;
                    zhidinS4();
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    OFFzhidinS4();
                }
            }
        });

        if (net.Example == 3) {
            root5.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        net.ROOTnumber = 5;
                        zhidinS5();
                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        OFFzhidinS5();
                    }
                }
            });
        }

    }

    void ADDgenduankou() {

        genduankou = new JLabel("<html><根端口></html>");
        genduankou.setFont(font);
        genduankou.setBounds(20, 50, 100, 25);
        genduankou.setBackground(BackgroundColor);
        add(genduankou);

        PromptWords1 = new JLabel("<html>S1-></html>");
        PromptWords1.setFont(font);
        PromptWords1.setBounds(110, 50, 50, 25);
        PromptWords1.setBackground(BackgroundColor);
        add(PromptWords1);

        PromptWords2 = new JLabel("<html>S2-></html>");
        PromptWords2.setFont(font);
        PromptWords2.setBounds(110, 80, 50, 25);
        PromptWords2.setBackground(BackgroundColor);
        add(PromptWords2);

        PromptWords3 = new JLabel("<html>S3-></html>");
        PromptWords3.setFont(font);
        PromptWords3.setBounds(110, 110, 50, 25);
        PromptWords3.setBackground(BackgroundColor);
        add(PromptWords3);

        PromptWords4 = new JLabel("<html>S4-></html>");
        PromptWords4.setFont(font);
        PromptWords4.setBounds(110, 140, 50, 25);
        PromptWords4.setBackground(BackgroundColor);
        add(PromptWords4);

        if (net.Example == 3) {

            PromptWords5 = new JLabel("<html>S5-></html>");
            PromptWords5.setFont(font);
            PromptWords5.setBounds(110, 170, 50, 25);
            PromptWords5.setBackground(BackgroundColor);
            add(PromptWords5);

        }

        ADDintgen_Botton();
    }

    void ADDintgen_Botton() {

        Button1_1 = new ColoredRadioButton("接口1");
        Button1_1.setFont(font);
        Button1_1.setBackground(BackgroundColor);
        Button1_1.setBounds(170, 50, 90, 25);
        add(Button1_1);
        Button1_2 = new ColoredRadioButton("接口2");
        Button1_2.setFont(font);
        Button1_2.setBackground(BackgroundColor);
        Button1_2.setBounds(270, 50, 90, 25);
        add(Button1_2);

        if (net.Example == 2) {
            Button1_3 = new ColoredRadioButton("接口3");
            Button1_3.setFont(font);
            Button1_3.setBackground(BackgroundColor);
            Button1_3.setBounds(370, 50, 90, 25);
            add(Button1_3);
        }

        Button2_1 = new ColoredRadioButton("接口1");
        Button2_1.setFont(font);
        Button2_1.setBackground(BackgroundColor);
        Button2_1.setBounds(170, 80, 90, 25);
        add(Button2_1);
        if (net.Example != 3) {
            Button2_2 = new ColoredRadioButton("接口2");
            Button2_2.setFont(font);
            Button2_2.setBackground(BackgroundColor);
            Button2_2.setBounds(270, 80, 90, 25);
            add(Button2_2);
            if (net.Example == 2) {
                Button2_3 = new ColoredRadioButton("接口3");
                Button2_3.setFont(font);
                Button2_3.setBackground(BackgroundColor);
                Button2_3.setBounds(370, 80, 90, 25);
                add(Button2_3);
            }
        }

        Button3_1 = new ColoredRadioButton("接口1");
        Button3_1.setFont(font);
        Button3_1.setBackground(BackgroundColor);
        Button3_1.setBounds(170, 110, 90, 25);
        add(Button3_1);
        Button3_2 = new ColoredRadioButton("接口2");
        Button3_2.setFont(font);
        Button3_2.setBackground(BackgroundColor);
        Button3_2.setBounds(270, 110, 90, 25);
        add(Button3_2);
        if (net.Example == 3) {
            Button3_3 = new ColoredRadioButton("接口3");
            Button3_3.setFont(font);
            Button3_3.setBackground(BackgroundColor);
            Button3_3.setBounds(370, 110, 90, 25);
            add(Button3_3);
        }

        Button4_1 = new ColoredRadioButton("接口1");
        Button4_1.setFont(font);
        Button4_1.setBackground(BackgroundColor);
        Button4_1.setBounds(170, 140, 90, 25);
        add(Button4_1);
        Button4_2 = new ColoredRadioButton("接口2");
        Button4_2.setFont(font);
        Button4_2.setBackground(BackgroundColor);
        Button4_2.setBounds(270, 140, 90, 25);
        add(Button4_2);

        if (net.Example == 3) {
            Button4_3 = new ColoredRadioButton("接口3");
            Button4_3.setFont(font);
            Button4_3.setBackground(BackgroundColor);
            Button4_3.setBounds(370, 140, 90, 25);
            add(Button4_3);
            Button4_4 = new ColoredRadioButton("接口4");
            Button4_4.setFont(font);
            Button4_4.setBackground(BackgroundColor);
            Button4_4.setBounds(470, 140, 90, 25);
            add(Button4_4);
            Button5_1 = new ColoredRadioButton("接口1");
            Button5_1.setFont(font);
            Button5_1.setBackground(BackgroundColor);
            Button5_1.setBounds(170, 170, 90, 25);
            add(Button5_1);

            Button5_2 = new ColoredRadioButton("接口2");
            Button5_2.setFont(font);
            Button5_2.setBackground(BackgroundColor);
            Button5_2.setBounds(270, 170, 90, 25);
            add(Button5_2);
        }

    }

    void ADDzhidinduankou() {

        int y = 120;
        if (net.Example == 3) {
            y = 150;
        }
        zhidinduankou = new JLabel("<html><指定端口></html>");
        zhidinduankou.setFont(font);
        zhidinduankou.setBounds(20, 50 + y, 100, 25);
        zhidinduankou.setBackground(BackgroundColor);
        add(zhidinduankou);

        PromptWords2_1 = new JLabel("<html>S1-></html>");
        PromptWords2_1.setFont(font);
        PromptWords2_1.setBounds(110, 50 + y, 50, 25);
        PromptWords2_1.setBackground(BackgroundColor);
        add(PromptWords2_1);

        PromptWords2_2 = new JLabel("<html>S2-></html>");
        PromptWords2_2.setFont(font);
        PromptWords2_2.setBounds(110, 80 + y, 50, 25);
        PromptWords2_2.setBackground(BackgroundColor);
        add(PromptWords2_2);

        PromptWords2_3 = new JLabel("<html>S3-></html>");
        PromptWords2_3.setFont(font);
        PromptWords2_3.setBounds(110, 110 + y, 50, 25);
        PromptWords2_3.setBackground(BackgroundColor);
        add(PromptWords2_3);

        PromptWords2_4 = new JLabel("<html>S4-></html>");
        PromptWords2_4.setFont(font);
        PromptWords2_4.setBounds(110, 140 + y, 50, 25);
        PromptWords2_4.setBackground(BackgroundColor);
        add(PromptWords2_4);

        if (net.Example == 3) {

            PromptWords2_5 = new JLabel("<html>S5-></html>");
            PromptWords2_5.setFont(font);
            PromptWords2_5.setBounds(110, 170 + y, 50, 25);
            PromptWords2_5.setBackground(BackgroundColor);
            add(PromptWords2_5);

        }

        ADDintzhi_Botton();
    }

    void ADDintzhi_Botton() {

        int y = 120;
        if (net.Example == 3) {
            y = 150;
        }
        ZButton1_1 = new ColoredRadioButton("接口1");
        ZButton1_1.setFont(font);
        ZButton1_1.setBackground(BackgroundColor);
        ZButton1_1.setBounds(170, y + 50, 90, 25);
        add(ZButton1_1);
        ZButton1_2 = new ColoredRadioButton("接口2");
        ZButton1_2.setFont(font);
        ZButton1_2.setBackground(BackgroundColor);
        ZButton1_2.setBounds(270, y + 50, 90, 25);
        add(ZButton1_2);
        if (net.Example == 2) {
            ZButton1_3 = new ColoredRadioButton("接口3");
            ZButton1_3.setFont(font);
            ZButton1_3.setBackground(BackgroundColor);
            ZButton1_3.setBounds(370, y + 50, 90, 25);
            add(ZButton1_3);
        }

        ZButton2_1 = new ColoredRadioButton("接口1");
        ZButton2_1.setFont(font);
        ZButton2_1.setBackground(BackgroundColor);
        ZButton2_1.setBounds(170, y + 80, 90, 25);
        add(ZButton2_1);
        if (net.Example != 3) {
            ZButton2_2 = new ColoredRadioButton("接口2");
            ZButton2_2.setFont(font);
            ZButton2_2.setBackground(BackgroundColor);
            ZButton2_2.setBounds(270, y + 80, 90, 25);
            add(ZButton2_2);
            if (net.Example == 2) {
                ZButton2_3 = new ColoredRadioButton("接口3");
                ZButton2_3.setFont(font);
                ZButton2_3.setBackground(BackgroundColor);
                ZButton2_3.setBounds(370, y + 80, 90, 25);
                add(ZButton2_3);
            }
        }

        ZButton3_1 = new ColoredRadioButton("接口1");
        ZButton3_1.setFont(font);
        ZButton3_1.setBackground(BackgroundColor);
        ZButton3_1.setBounds(170, y + 110, 90, 25);
        add(ZButton3_1);
        ZButton3_2 = new ColoredRadioButton("接口2");
        ZButton3_2.setFont(font);
        ZButton3_2.setBackground(BackgroundColor);
        ZButton3_2.setBounds(270, y + 110, 90, 25);
        add(ZButton3_2);
        if (net.Example == 3) {
            ZButton3_3 = new ColoredRadioButton("接口3");
            ZButton3_3.setFont(font);
            ZButton3_3.setBackground(BackgroundColor);
            ZButton3_3.setBounds(370, y + 110, 90, 25);
            add(ZButton3_3);
        }

        ZButton4_1 = new ColoredRadioButton("接口1");
        ZButton4_1.setFont(font);
        ZButton4_1.setBackground(BackgroundColor);
        ZButton4_1.setBounds(170, y + 140, 90, 25);
        add(ZButton4_1);
        ZButton4_2 = new ColoredRadioButton("接口2");
        ZButton4_2.setFont(font);
        ZButton4_2.setBackground(BackgroundColor);
        ZButton4_2.setBounds(270, y + 140, 90, 25);
        add(ZButton4_2);

        if (net.Example == 3) {
            ZButton4_3 = new ColoredRadioButton("接口3");
            ZButton4_3.setFont(font);
            ZButton4_3.setBackground(BackgroundColor);
            ZButton4_3.setBounds(370, y + 140, 90, 25);
            add(ZButton4_3);
            ZButton4_4 = new ColoredRadioButton("接口4");
            ZButton4_4.setFont(font);
            ZButton4_4.setBackground(BackgroundColor);
            ZButton4_4.setBounds(470, y + 140, 90, 25);
            add(ZButton4_4);

            ZButton5_1 = new ColoredRadioButton("接口1");
            ZButton5_1.setFont(font);
            ZButton5_1.setBackground(BackgroundColor);
            ZButton5_1.setBounds(170, y + 170, 90, 25);
            add(ZButton5_1);

            ZButton5_2 = new ColoredRadioButton("接口2");
            ZButton5_2.setFont(font);
            ZButton5_2.setBackground(BackgroundColor);
            ZButton5_2.setBounds(270, y + 170, 90, 25);
            add(ZButton5_2);
        }
    }

    void ADDgroup() {

        gButton1_1 = new ButtonGroup();
        gButton1_1.add(Button1_1);
        gButton1_1.add(ZButton1_1);
        gButton1_2 = new ButtonGroup();
        gButton1_2.add(Button1_2);
        gButton1_2.add(ZButton1_2);
        gButton1_3 = new ButtonGroup();
        gButton1_3.add(Button1_3);
        gButton1_3.add(ZButton1_3);

        gButton2_1 = new ButtonGroup();
        gButton2_1.add(Button2_1);
        gButton2_1.add(ZButton2_1);
        gButton2_2 = new ButtonGroup();
        gButton2_2.add(Button2_2);
        gButton2_2.add(ZButton2_2);
        gButton2_3 = new ButtonGroup();
        gButton2_3.add(Button2_3);
        gButton2_3.add(ZButton2_3);

        gButton3_1 = new ButtonGroup();
        gButton3_1.add(Button3_1);
        gButton3_1.add(ZButton3_1);
        gButton3_2 = new ButtonGroup();
        gButton3_2.add(Button3_2);
        gButton3_2.add(ZButton3_2);
        gButton3_3 = new ButtonGroup();
        gButton3_3.add(Button3_3);
        gButton3_3.add(ZButton3_3);

        gButton4_1 = new ButtonGroup();
        gButton4_1.add(Button4_1);
        gButton4_1.add(ZButton4_1);
        gButton4_2 = new ButtonGroup();
        gButton4_2.add(Button4_2);
        gButton4_2.add(ZButton4_2);
        gButton4_3 = new ButtonGroup();
        gButton4_3.add(Button4_3);
        gButton4_3.add(ZButton4_3);
        gButton4_4 = new ButtonGroup();
        gButton4_4.add(Button4_4);
        gButton4_4.add(ZButton4_4);

        if (net.Example == 3) {
            gButton5_1 = new ButtonGroup();
            gButton5_1.add(Button5_1);
            gButton5_1.add(ZButton5_1);
            gButton5_2 = new ButtonGroup();
            gButton5_2.add(Button5_2);
            gButton5_2.add(ZButton5_2);
        }

        zhidinS1();
    }

    void zhidinS1() {

        ZButton1_1.setSelected(true);
        ZButton1_2.setSelected(true);
        if (net.Example == 2) {
            ZButton1_3.setSelected(true);
        }
    }

    void OFFzhidinS1() {

        gButton1_1.clearSelection();
        gButton1_2.clearSelection();
        gButton1_3.clearSelection();
    }

    void zhidinS2() {

        ZButton2_1.setSelected(true);
        if (net.Example != 3) {
            ZButton2_2.setSelected(true);
            if (net.Example == 2) {
                ZButton2_3.setSelected(true);
            }
        }
    }

    void OFFzhidinS2() {

        gButton2_1.clearSelection();
        gButton2_2.clearSelection();
        gButton2_3.clearSelection();
    }

    void zhidinS3() {

        ZButton3_1.setSelected(true);
        ZButton3_2.setSelected(true);
        if (net.Example == 3) {
            ZButton3_3.setSelected(true);
        }
    }

    void OFFzhidinS3() {

        gButton3_1.clearSelection();
        gButton3_2.clearSelection();
        gButton3_3.clearSelection();
    }

    void zhidinS4() {

        ZButton4_1.setSelected(true);
        ZButton4_2.setSelected(true);
        if (net.Example == 3) {
            ZButton4_3.setSelected(true);
            ZButton4_4.setSelected(true);
        }
    }

    void OFFzhidinS4() {

        gButton4_1.clearSelection();
        gButton4_2.clearSelection();
        gButton4_3.clearSelection();
        gButton4_4.clearSelection();
    }

    void zhidinS5() {

        ZButton5_1.setSelected(true);
        ZButton5_2.setSelected(true);
    }

    void OFFzhidinS5() {

        gButton5_1.clearSelection();
        gButton5_2.clearSelection();
    }

    void conzhi() {

        gButton1_1.clearSelection();
        gButton1_2.clearSelection();
        gButton1_3.clearSelection();
        gButton2_1.clearSelection();
        gButton2_2.clearSelection();
        gButton2_3.clearSelection();
        gButton3_1.clearSelection();
        gButton3_2.clearSelection();
        gButton3_3.clearSelection();
        gButton4_1.clearSelection();
        gButton4_2.clearSelection();
        gButton4_3.clearSelection();
        gButton4_4.clearSelection();

        ZButton1_1.setSelected(true);
        ZButton1_2.setSelected(true);
        if (net.Example == 2) {
            ZButton1_3.setSelected(true);
        }

        if (net.Example == 3) {
            gButton5_1.clearSelection();
            gButton5_2.clearSelection();
        }

        root1.setSelected(true);
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
