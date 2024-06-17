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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//4交换机面板
class PanelSwitchFour1 extends JPanel {

    PanelSwitch ps1, ps2, ps3, ps4;
    NetworkTopology neT;

    PanelSwitchFour1() {

        neT = new NetworkTopology(1);
        setLayout(null); 
        setOpaque(false);
        ADDPanelSwitch();
    }

    void ADDPanelSwitch(){

        ps1 = new PanelSwitch(neT.switch11.name, neT.switch11.mac, 32768L, neT.switch11.intNumber, neT);
        ps2 = new PanelSwitch(neT.switch12.name, neT.switch12.mac, 32768L, neT.switch12.intNumber, neT);
        ps3 = new PanelSwitch(neT.switch13.name, neT.switch13.mac, 32768L, neT.switch13.intNumber, neT);
        ps4 = new PanelSwitch(neT.switch14.name, neT.switch14.mac, 32768L, neT.switch14.intNumber, neT);

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

    PanelSwitchFour2() {

        neT = new NetworkTopology(2);
        setLayout(null);
        setOpaque(false);
        ADDPanelSwitch();
    }

    void ADDPanelSwitch() {

        ps1 = new PanelSwitch(neT.switch21.name, neT.switch21.mac, 32768L, neT.switch21.intNumber, neT);
        ps2 = new PanelSwitch(neT.switch22.name, neT.switch22.mac, 32768L, neT.switch22.intNumber, neT);
        ps3 = new PanelSwitch(neT.switch23.name, neT.switch23.mac, 32768L, neT.switch23.intNumber, neT);
        ps4 = new PanelSwitch(neT.switch24.name, neT.switch24.mac, 32768L, neT.switch24.intNumber, neT);

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

//5交换机面板
class PanelSwitchFive extends JPanel {

    PanelSwitch ps1, ps2, ps3, ps4, ps5;
    NetworkTopology neT;

    PanelSwitchFive() {

        neT = new NetworkTopology(3);
        setLayout(null); 
        setOpaque(false);
        ADDPanelSwitch();
    }

    void ADDPanelSwitch() {

        ps1 = new PanelSwitch(neT.switch31.name, neT.switch31.mac, 32768L, neT.switch31.intNumber, neT);
        ps2 = new PanelSwitch(neT.switch32.name, neT.switch32.mac, 32768L, neT.switch32.intNumber, neT);
        ps3 = new PanelSwitch(neT.switch33.name, neT.switch33.mac, 32768L, neT.switch33.intNumber, neT);
        ps4 = new PanelSwitch(neT.switch34.name, neT.switch34.mac, 32768L, neT.switch34.intNumber, neT);
        ps5 = new PanelSwitch(neT.switch35.name, neT.switch35.mac, 32768L, neT.switch35.intNumber, neT);

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

    NetworkTopology neT;
    String theName, theMAC;
    long thePri;
    JTextField name, MAC, Pri;
    JLabel namePromptWords, MACPromptWords, PriPromptWords;
    JLabel intPIDPromptWords, intStatePromptWords;
    Font PromptWordsFont, TextFieldFont;
    Color FontColor, BackgroundColor;
    EmptyBorder Border;

    int intfNumber, zhenzhang = 80;
    JLabel intCode1, intTypePromptWords1, intStatePromptWords1, intPriPromptWords1;
    ButtonGroup intcostGroup1, intstateGroup1;
    JRadioButton FEButton1, GEButton1, onButton1, offButton1;
    JTextField intPri1;

    JLabel intCode2, intTypePromptWords2, intStatePromptWords2, intPriPromptWords2;
    ButtonGroup intcostGroup2, intstateGroup2;
    JRadioButton FEButton2, GEButton2, onButton2, offButton2;
    JTextField intPri2;

    JLabel intCode3, intTypePromptWords3, intStatePromptWords3, intPriPromptWords3;
    ButtonGroup intcostGroup3, intstateGroup3;
    JRadioButton FEButton3, GEButton3, onButton3, offButton3;
    JTextField intPri3;

    JLabel intCode4, intTypePromptWords4, intStatePromptWords4, intPriPromptWords4;
    ButtonGroup intcostGroup4, intstateGroup4;
    JRadioButton FEButton4, GEButton4, onButton4, offButton4;
    JTextField intPri4;

    PanelSwitch(String aName, String aMAC, long aPri, int intNumber, NetworkTopology anet){

        neT = anet;
        theName = aName;
        theMAC = aMAC;
        thePri = aPri;
        intfNumber = intNumber;
        setLayout(null);
        Init();
        ADDLabel();
        ADDTextField();


        if (intfNumber <= 4) {
            ADDintf(1, 114514);

            if (intfNumber <= 3) {
                ADDintf(2, 114514);

                if (intfNumber <= 2) {
                    ADDintf(3, 114514);

                    if (intfNumber <= 1) {
                        ADDintf(4, 114514);
                    }
                }
            }
        }
        

    }

    void Init(){

        TextFieldFont = new Font("黑体", Font.PLAIN, 17);
        PromptWordsFont = new Font("黑体", Font.PLAIN , 20);
        FontColor = new Color(0xf5,0xf5,0xf5);
        BackgroundColor = new Color(0x61, 0x89, 0x2f);
        Border = new EmptyBorder(0,0,0,0);
    }

    void ADDLabel(){

        namePromptWords = new JLabel("<html>name:</html>");
        namePromptWords.setFont(PromptWordsFont);
        namePromptWords.setForeground(FontColor);
        namePromptWords.setBounds( 15, 20, 50, 25);
        namePromptWords.setBackground(BackgroundColor);
        add(namePromptWords);


        MACPromptWords = new JLabel("<html>Mac :</html>");
        MACPromptWords.setFont(PromptWordsFont);
        MACPromptWords.setForeground(FontColor);
        MACPromptWords.setBounds(15, 50, 50, 25);
        MACPromptWords.setBackground(BackgroundColor);
        add(MACPromptWords);

        PriPromptWords = new JLabel("<html>Pri :</html>");
        PriPromptWords.setFont(PromptWordsFont);
        PriPromptWords.setForeground(FontColor);
        PriPromptWords.setBounds(15, 75, 50, 25);
        PriPromptWords.setBackground(BackgroundColor);
        add(PriPromptWords);
    }
 
    void ADDTextField(){

        name = new JTextField(theName);
        name.setFont(TextFieldFont);
        name.setForeground(FontColor);
        name.setBounds( 70, 22, 250, 20);
        name.setBackground(BackgroundColor);
        name.setBorder(Border);
        add(name);

        MAC = new JTextField(theMAC);
        MAC.setFont(TextFieldFont);
        MAC.setForeground(FontColor);
        MAC.setBounds(70, 52, 250, 20);
        MAC.setBackground(BackgroundColor);
        MAC.setBorder(Border);
        add(MAC);

        Pri = new JTextField("32768");
        Pri.setFont(TextFieldFont);
        Pri.setForeground(FontColor);
        Pri.setBounds(70, 82, 250, 20);
        Pri.setBackground(BackgroundColor);
        Pri.setBorder(Border);
        add(Pri);

    }


    void ADDintf(int index, int y){

        if (intfNumber <= 4) {

            intCode1 = new JLabel("<html><font face='黑体' size='4'><接口1></font></html>");
            intCode1.setForeground(FontColor);
            intCode1.setBounds(15, 110,50, 25);
            intCode1.setBackground(BackgroundColor);
            add(intCode1);

            intStatePromptWords1 = new JLabel("<html><font face='黑体' size='4'>state:</font></html>");
            intStatePromptWords1.setForeground(FontColor);
            intStatePromptWords1.setBounds(65, 110, 50, 25);
            intStatePromptWords1.setBackground(BackgroundColor);
            add(intStatePromptWords1);
            
            intTypePromptWords1 = new JLabel("<html><font face='黑体' size='4'>type:</font></html>");
            intTypePromptWords1.setForeground(FontColor);
            intTypePromptWords1.setBounds(30, 135, 50, 25);
            intTypePromptWords1.setBackground(BackgroundColor);
            add(intTypePromptWords1);

            intPriPromptWords1 = new JLabel("<html><font face='黑体' size='4'>Pri:</font></html>");
            intPriPromptWords1.setForeground(FontColor);
            intPriPromptWords1.setBounds(33, 160, 50, 30);
            intPriPromptWords1.setBackground(BackgroundColor);
            add(intPriPromptWords1);


            onButton1 = new JRadioButton("<html><font face='黑体' size='4'>ON</font></html>");
            offButton1 = new JRadioButton("<html><font face='黑体' size='4'>OFF</font></html>");
            FEButton1 = new JRadioButton("<html><font face='黑体' size='4'>FastEther</font></html>");
            GEButton1 = new JRadioButton("<html><font face='黑体' size='4'>GigabitEther</font></html>");

            onButton1.setBackground(BackgroundColor);
            offButton1.setBackground(BackgroundColor);
            FEButton1.setBackground(BackgroundColor);
            GEButton1.setBackground(BackgroundColor);

            onButton1.setForeground(FontColor);
            offButton1.setForeground(FontColor);
            FEButton1.setForeground(FontColor);
            GEButton1.setForeground(FontColor);

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
            add(onButton1);
            add(offButton1);
            add(FEButton1);
            add(GEButton1);
            onButton1.setSelected(true);
            FEButton1.setSelected(true);

            intPri1 = new JTextField("32768");
            intPri1.setFont(TextFieldFont);
            intPri1.setForeground(FontColor);
            intPri1.setBounds(75, 167, 250, 20);
            intPri1.setBackground(BackgroundColor);
            intPri1.setBorder(Border);
            add(intPri1);

            if (intfNumber <= 3) {

                intCode2 = new JLabel("<html><font face='黑体' size='4'><接口2></font></html>");
                intCode2.setForeground(FontColor);
                intCode2.setBounds(15, 110+zhenzhang, 50, 25);
                intCode2.setBackground(BackgroundColor);
                add(intCode2);

                intStatePromptWords2 = new JLabel("<html><font face='黑体' size='4'>state:</font></html>");
                intStatePromptWords2.setForeground(FontColor);
                intStatePromptWords2.setBounds(65, 110 + zhenzhang, 50, 25);
                intStatePromptWords2.setBackground(BackgroundColor);
                add(intStatePromptWords2);

                intTypePromptWords2 = new JLabel("<html><font face='黑体' size='4'>type:</font></html>");
                intTypePromptWords2.setForeground(FontColor);
                intTypePromptWords2.setBounds(30, 135 + zhenzhang, 50, 25);
                intTypePromptWords2.setBackground(BackgroundColor);
                add(intTypePromptWords2);

                intPriPromptWords2 = new JLabel("<html><font face='黑体' size='4'>Pri:</font></html>");
                intPriPromptWords2.setForeground(FontColor);
                intPriPromptWords2.setBounds(33, 160 + zhenzhang, 50, 30);
                intPriPromptWords2.setBackground(BackgroundColor);
                add(intPriPromptWords2);

                onButton2 = new JRadioButton("<html><font face='黑体' size='4'>ON</font></html>");
                offButton2 = new JRadioButton("<html><font face='黑体' size='4'>OFF</font></html>");
                FEButton2 = new JRadioButton("<html><font face='黑体' size='4'>FastEther</font></html>");
                GEButton2 = new JRadioButton("<html><font face='黑体' size='4'>GigabitEther</font></html>");

                onButton2.setBackground(BackgroundColor);
                offButton2.setBackground(BackgroundColor);
                FEButton2.setBackground(BackgroundColor);
                GEButton2.setBackground(BackgroundColor);

                onButton2.setForeground(FontColor);
                offButton2.setForeground(FontColor);
                FEButton2.setForeground(FontColor);
                GEButton2.setForeground(FontColor);

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
                add(onButton2);
                add(offButton2);
                add(FEButton2);
                add(GEButton2);
                onButton2.setSelected(true);
                FEButton2.setSelected(true);

                intPri2 = new JTextField("32768");
                intPri2.setFont(TextFieldFont);
                intPri2.setForeground(FontColor);
                intPri2.setBounds(75, 167 + zhenzhang, 250, 20);
                intPri2.setBackground(BackgroundColor);
                intPri2.setBorder(Border);
                add(intPri2);

                if (intfNumber <= 2) {

                    intCode3 = new JLabel("<html><font face='黑体' size='4'><接口3></font></html>");
                    intCode3.setForeground(FontColor);
                    intCode3.setBounds(15, 110 + zhenzhang *2, 50, 25);
                    intCode3.setBackground(BackgroundColor);
                    add(intCode3);

                    intStatePromptWords3 = new JLabel("<html><font face='黑体' size='4'>state:</font></html>");
                    intStatePromptWords3.setForeground(FontColor);
                    intStatePromptWords3.setBounds(65, 110 + zhenzhang * 2, 50, 25);
                    intStatePromptWords3.setBackground(BackgroundColor);
                    add(intStatePromptWords3);

                    intTypePromptWords3 = new JLabel("<html><font face='黑体' size='4'>type:</font></html>");
                    intTypePromptWords3.setForeground(FontColor);
                    intTypePromptWords3.setBounds(30, 135 + zhenzhang * 2, 50, 25);
                    intTypePromptWords3.setBackground(BackgroundColor);
                    add(intTypePromptWords3);

                    intPriPromptWords3 = new JLabel("<html><font face='黑体' size='4'>Pri:</font></html>");
                    intPriPromptWords3.setForeground(FontColor);
                    intPriPromptWords3.setBounds(33, 160 + zhenzhang * 2, 50, 30);
                    intPriPromptWords3.setBackground(BackgroundColor);
                    add(intPriPromptWords3);

                    onButton3 = new JRadioButton("<html><font face='黑体' size='4'>ON</font></html>");
                    offButton3 = new JRadioButton("<html><font face='黑体' size='4'>OFF</font></html>");
                    FEButton3 = new JRadioButton("<html><font face='黑体' size='4'>FastEther</font></html>");
                    GEButton3 = new JRadioButton("<html><font face='黑体' size='4'>GigabitEther</font></html>");

                    onButton3.setBackground(BackgroundColor);
                    offButton3.setBackground(BackgroundColor);
                    FEButton3.setBackground(BackgroundColor);
                    GEButton3.setBackground(BackgroundColor);

                    onButton3.setForeground(FontColor);
                    offButton3.setForeground(FontColor);
                    FEButton3.setForeground(FontColor);
                    GEButton3.setForeground(FontColor);

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
                    add(onButton3);
                    add(offButton3);
                    add(FEButton3);
                    add(GEButton3);
                    onButton3.setSelected(true);
                    FEButton3.setSelected(true);

                    intPri3 = new JTextField("32768");
                    intPri3.setFont(TextFieldFont);
                    intPri3.setForeground(FontColor);
                    intPri3.setBounds(75, 167 + zhenzhang * 2, 250, 20);
                    intPri3.setBackground(BackgroundColor);
                    intPri3.setBorder(Border);
                    add(intPri3);

                    if (intfNumber <= 1) {

                        intCode4 = new JLabel("<html><font face='黑体' size='4'><接口4></font></html>");
                        intCode4.setForeground(FontColor);
                        intCode4.setBounds(15, 110+ zhenzhang * 3, 50, 25);
                        intCode4.setBackground(BackgroundColor);
                        add(intCode4);

                        intStatePromptWords4 = new JLabel("<html><font face='黑体' size='4'>state:</font></html>");
                        intStatePromptWords4.setForeground(FontColor);
                        intStatePromptWords4.setBounds(65, 110, 50, 25);
                        intStatePromptWords4.setBackground(BackgroundColor);
                        add(intStatePromptWords4);

                        intTypePromptWords4 = new JLabel("<html><font face='黑体' size='4'>type:</font></html>");
                        intTypePromptWords4.setForeground(FontColor);
                        intTypePromptWords4.setBounds(30, 135 + zhenzhang * 3, 50, 25);
                        intTypePromptWords4.setBackground(BackgroundColor);
                        add(intTypePromptWords4);

                        intPriPromptWords4 = new JLabel("<html><font face='黑体' size='4'>Pri:</font></html>");
                        intPriPromptWords4.setForeground(FontColor);
                        intPriPromptWords4.setBounds(33, 160 + zhenzhang * 3, 50, 30);
                        intPriPromptWords4.setBackground(BackgroundColor);
                        add(intPriPromptWords4);

                        onButton4 = new JRadioButton("<html><font face='黑体' size='4'>ON</font></html>");
                        offButton4 = new JRadioButton("<html><font face='黑体' size='4'>OFF</font></html>");
                        FEButton4 = new JRadioButton("<html><font face='黑体' size='4'>FastEther</font></html>");
                        GEButton4 = new JRadioButton("<html><font face='黑体' size='4'>GigabitEther</font></html>");

                        onButton4.setBackground(BackgroundColor);
                        offButton4.setBackground(BackgroundColor);
                        FEButton4.setBackground(BackgroundColor);
                        GEButton4.setBackground(BackgroundColor);

                        onButton4.setForeground(FontColor);
                        offButton4.setForeground(FontColor);
                        FEButton4.setForeground(FontColor);
                        GEButton4.setForeground(FontColor);

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
                        add(onButton4);
                        add(offButton4);
                        add(FEButton4);
                        add(GEButton4);
                        onButton4.setSelected(true);
                        FEButton4.setSelected(true);

                        intPri4 = new JTextField("32768");
                        intPri4.setFont(TextFieldFont);
                        intPri4.setForeground(FontColor);
                        intPri4.setBounds(75, 167 + zhenzhang * 3, 250, 20);
                        intPri4.setBackground(BackgroundColor);
                        intPri4.setBorder(Border);
                        add(intPri4);

                    }
                }
            }
        }

    }







  protected void paintComponent(Graphics g) {

        

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
        g2d.setColor(getBackground());
        g2d.fill(roundedRectangle);
        setBackground(new Color(0x61, 0x89, 0x2f));

    }

}