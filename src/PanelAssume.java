import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


//推测面板
class PanelAssume extends JPanel {

    InterfaceExecution IE;
    NetworkTopology net;
    Color BackgroundColor;
    Font font;

    JLabel root,genduankou,zhidinduankou;
    JLabel PromptWords1, PromptWords2, PromptWords3, PromptWords4, PromptWords5;
    ButtonGroup rootGroup, swGDGroup1, swGDGroup2, swGDGroup3, swGDGroup4, swGDGroup5;
    ButtonGroup swZDGroup1, swZDGroup2, swZDGroup3, swZDGroup4, swZDGroup5;
    JRadioButton root1, root2, root3, root4, root5;
    JRadioButton Button1_1, Button1_2, Button1_3;
    JRadioButton Button2_1, Button2_2, Button2_3;
    JRadioButton Button3_1, Button3_2, Button3_3;
    JRadioButton Button4_1, Button4_2, Button4_3, Button4_4;
    JRadioButton Button5_1, Button5_2;

    JRadioButton ZButton1_1, ZButton1_2, ZButton1_3;
    JRadioButton ZButton2_1, ZButton2_2, ZButton2_3;
    JRadioButton ZButton3_1, ZButton3_2, ZButton3_3;
    JRadioButton ZButton4_1, ZButton4_2, ZButton4_3, ZButton4_4;
    JRadioButton ZButton5_1, ZButton5_2;

    PanelAssume(InterfaceExecution interfaceExecution, NetworkTopology anet){

        IE = interfaceExecution;
        net = anet;
        setLayout(null);
        
        init();
        ADDroot();
        ADDgenduankou();
        ADDzhidinduankou();
    }

    void init(){

        BackgroundColor = new Color(0xd5, 0xd5, 0xd5);
        setBackground(BackgroundColor);
        font = new Font("黑体", Font.PLAIN, 17);
    }

    void ADDroot(){

        root = new JLabel("<html>name:</html>");
        root.setFont(font);
        root.setBounds(15, 20, 50, 25);
        root.setBackground(BackgroundColor);
        add(root);
        
        rootGroup = new ButtonGroup();
        root1 = new JRadioButton("SW1");
        root1.setFont(font);
        root1.setBackground(BackgroundColor);
        root1.setBounds(15, 110, 50, 25);
        add(root1);
        rootGroup.add(root1);
        root1.setSelected(true);

        root2 = new JRadioButton("SW2");
        root2.setFont(font);
        root2.setBackground(BackgroundColor);
        root2.setBounds(15, 110, 50, 25);
        add(root2);
        rootGroup.add(root2);

        root3 = new JRadioButton("SW3");
        root3.setFont(font);
        root3.setBackground(BackgroundColor);
        root3.setBounds(15, 110, 50, 25);
        add(root3);
        rootGroup.add(root3);

        root4 = new JRadioButton("SW4");
        root4.setFont(font);
        root4.setBackground(BackgroundColor);
        root4.setBounds(15, 110, 50, 25);
        add(root4);
        rootGroup.add(root4);

        if(net.Example == 3){

            root5 = new JRadioButton("SW5");
            root5.setFont(font);
            root5.setBackground(BackgroundColor);
            root5.setBounds(15, 110, 50, 25);
            add(root5);
            rootGroup.add(root5);

        }

        
    }

    void ADDgenduankou(){

        genduankou = new JLabel("<html>根端口:</html>");
        genduankou.setFont(font);
        genduankou.setBounds(15, 20, 50, 25);
        genduankou.setBackground(BackgroundColor);
        add(genduankou);

        PromptWords1 = new JLabel("<html>根端口:</html>");
        PromptWords1.setFont(font);
        PromptWords1.setBounds(15, 20, 50, 25);
        PromptWords1.setBackground(BackgroundColor);
        add(PromptWords1);

        PromptWords2 = new JLabel("<html>根端口:</html>");
        PromptWords2.setFont(font);
        PromptWords2.setBounds(15, 20, 50, 25);
        PromptWords2.setBackground(BackgroundColor);
        add(PromptWords2);

        PromptWords3 = new JLabel("<html>根端口:</html>");
        PromptWords3.setFont(font);
        PromptWords3.setBounds(15, 20, 50, 25);
        PromptWords3.setBackground(BackgroundColor);
        add(PromptWords3);

        PromptWords4 = new JLabel("<html>根端口:</html>");
        PromptWords4.setFont(font);
        PromptWords4.setBounds(15, 20, 50, 25);
        PromptWords4.setBackground(BackgroundColor);
        add(PromptWords4);

        if (net.Example == 3) {

            PromptWords5 = new JLabel("<html>根端口:</html>");
            PromptWords5.setFont(font);
            PromptWords5.setBounds(15, 20, 50, 25);
            PromptWords5.setBackground(BackgroundColor);
            add(PromptWords5);

        }

        ADDintgen_Botton();
    }

    void ADDintgen_Botton(){
        
    }

    void ADDzhidinduankou(){

        zhidinduankou = new JLabel("<html>指定端口:</html>");
        zhidinduankou.setFont(font);
        zhidinduankou.setBounds(15, 20, 50, 25);
        zhidinduankou.setBackground(BackgroundColor);
        add(zhidinduankou);
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

