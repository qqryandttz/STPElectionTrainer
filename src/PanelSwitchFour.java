import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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

    PanelSwitchFour2(NetworkTopology anet) {

        neT = anet;
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

    PanelSwitchFive(NetworkTopology anet) {

        neT = anet;
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
    JScrollPane scrollPane;
    JPanel panel;

    String theName, theMAC;
    long thePri;
    JTextField name, MAC, Pri;
    JLabel namePromptWords, MACPromptWords, PriPromptWords;
    JLabel intPIDPromptWords, intStatePromptWords;
    Font PromptWordsFont, TextFieldFont;
    Color FontWhiteColor, FontBlackColor, BackgroundColor, BackgroundWhiteColor;
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
        setOpaque(false); 
        setBackground(new Color(0, 0, 0, 0)); 
        panel = new JPanel();

        if((intfNumber == 3 ||intNumber == 4) && (anet.Example == 1 || anet.Example == 2)){
            panel = new JPanel() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(300, 450);
                }
            };
        }else if((intfNumber == 3 || intNumber == 4) && (anet.Example == 3)) {
            panel = new JPanel() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(250, 450);
                }
            };
        } else if ((intfNumber == 1 || intNumber == 2) && (anet.Example == 3)) {
            panel = new JPanel() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(250, 300);
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

    }

    void Init(){

        TextFieldFont = new Font("黑体", Font.PLAIN, 17);
        PromptWordsFont = new Font("黑体", Font.PLAIN , 20);
        FontWhiteColor = new Color(0xf5,0xf5,0xf5);
        FontBlackColor = new Color(0x22, 0x26, 0x29);
        BackgroundColor = new Color(0x86, 0xc2, 0x32);
        BackgroundWhiteColor = new Color(0xe5, 0xe5, 0xe5);
        Border = new EmptyBorder(0,0,0,0);
    }

    void ADDLabel(){

        namePromptWords = new JLabel("<html>name:</html>");
        namePromptWords.setFont(PromptWordsFont);
        namePromptWords.setForeground(FontBlackColor);
        namePromptWords.setBounds( 15, 20, 50, 25);
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
 
    void ADDTextField(){

        name = new JTextField(theName);
        name.setFont(TextFieldFont);
        name.setForeground(FontWhiteColor);
        name.setBounds( 70, 22, 170, 20);
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


    void ADDintf(){

        if (true) {

            intCode1 = new JLabel("<html><font face='黑体' size='4'><接口1></font></html>");
            intCode1.setForeground(FontBlackColor);
            intCode1.setBounds(15, 110,50, 25);
            intCode1.setBackground(BackgroundColor);
            panel.add(intCode1);

            intStatePromptWords1 = new JLabel("<html><font face='黑体' size='4'>state:</font></html>");
            intStatePromptWords1.setForeground(FontBlackColor);
            intStatePromptWords1.setBounds(65, 110, 50, 25);
            intStatePromptWords1.setBackground(BackgroundColor);
            panel.add(intStatePromptWords1);
            
            intTypePromptWords1 = new JLabel("<html><font face='黑体' size='4'>type:</font></html>");
            intTypePromptWords1.setForeground(FontBlackColor);
            intTypePromptWords1.setBounds(30, 135, 50, 25);
            intTypePromptWords1.setBackground(BackgroundColor);
            panel.add(intTypePromptWords1);

            intPriPromptWords1 = new JLabel("<html><font face='黑体' size='4'>Pri:</font></html>");
            intPriPromptWords1.setForeground(FontBlackColor);
            intPriPromptWords1.setBounds(33, 160, 50, 30);
            intPriPromptWords1.setBackground(BackgroundColor);
            panel.add(intPriPromptWords1);


            onButton1 = new JRadioButton("<html><font face='黑体' size='4'>ON</font></html>");
            offButton1 = new JRadioButton("<html><font face='黑体' size='4'>OFF</font></html>");
            FEButton1 = new JRadioButton("<html><font face='黑体' size='4'>FE[19]</font></html>");
            GEButton1 = new JRadioButton("<html><font face='黑体' size='4'>GE[4]</font></html>");

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
            FEButton1.setSelected(true);

            intPri1 = new JTextField("32768");
            intPri1.setFont(TextFieldFont);
            intPri1.setForeground(FontWhiteColor);
            intPri1.setBounds(75, 167, 140, 20);
            intPri1.setBackground(BackgroundColor);
            intPri1.setBorder(Border);
            panel.add(intPri1);

            if (intfNumber > 1) {

                intCode2 = new JLabel("<html><font face='黑体' size='4'><接口2></font></html>");
                intCode2.setForeground(FontBlackColor);
                intCode2.setBounds(15, 110+zhenzhang, 50, 25);
                intCode2.setBackground(BackgroundColor);
                panel.add(intCode2);

                intStatePromptWords2 = new JLabel("<html><font face='黑体' size='4'>state:</font></html>");
                intStatePromptWords2.setForeground(FontBlackColor);
                intStatePromptWords2.setBounds(65, 110 + zhenzhang, 50, 25);
                intStatePromptWords2.setBackground(BackgroundColor);
                panel.add(intStatePromptWords2);

                intTypePromptWords2 = new JLabel("<html><font face='黑体' size='4'>type:</font></html>");
                intTypePromptWords2.setForeground(FontBlackColor);
                intTypePromptWords2.setBounds(30, 135 + zhenzhang, 50, 25);
                intTypePromptWords2.setBackground(BackgroundColor);
                panel.add(intTypePromptWords2);

                intPriPromptWords2 = new JLabel("<html><font face='黑体' size='4'>Pri:</font></html>");
                intPriPromptWords2.setForeground(FontBlackColor);
                intPriPromptWords2.setBounds(33, 160 + zhenzhang, 50, 30);
                intPriPromptWords2.setBackground(BackgroundColor);
                panel.add(intPriPromptWords2);

                onButton2 = new JRadioButton("<html><font face='黑体' size='4'>ON</font></html>");
                offButton2 = new JRadioButton("<html><font face='黑体' size='4'>OFF</font></html>");
                FEButton2 = new JRadioButton("<html><font face='黑体' size='4'>FE[19]</font></html>");
                GEButton2 = new JRadioButton("<html><font face='黑体' size='4'>GE[4]</font></html>");

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
                FEButton2.setSelected(true);

                intPri2 = new JTextField("32768");
                intPri2.setFont(TextFieldFont);
                intPri2.setForeground(FontWhiteColor);
                intPri2.setBounds(75, 167 + zhenzhang, 140, 20);
                intPri2.setBackground(BackgroundColor);
                intPri2.setBorder(Border);
                panel.add(intPri2);

                if (intfNumber > 2) {

                    intCode3 = new JLabel("<html><font face='黑体' size='4'><接口3></font></html>");
                    intCode3.setForeground(FontBlackColor);
                    intCode3.setBounds(15, 110 + zhenzhang *2, 50, 25);
                    intCode3.setBackground(BackgroundColor);
                    panel.add(intCode3);

                    intStatePromptWords3 = new JLabel("<html><font face='黑体' size='4'>state:</font></html>");
                    intStatePromptWords3.setForeground(FontBlackColor);
                    intStatePromptWords3.setBounds(65, 110 + zhenzhang * 2, 50, 25);
                    intStatePromptWords3.setBackground(BackgroundColor);
                    panel.add(intStatePromptWords3);

                    intTypePromptWords3 = new JLabel("<html><font face='黑体' size='4'>type:</font></html>");
                    intTypePromptWords3.setForeground(FontBlackColor);
                    intTypePromptWords3.setBounds(30, 135 + zhenzhang * 2, 50, 25);
                    intTypePromptWords3.setBackground(BackgroundColor);
                    panel.add(intTypePromptWords3);

                    intPriPromptWords3 = new JLabel("<html><font face='黑体' size='4'>Pri:</font></html>");
                    intPriPromptWords3.setForeground(FontBlackColor);
                    intPriPromptWords3.setBounds(33, 160 + zhenzhang * 2, 50, 30);
                    intPriPromptWords3.setBackground(BackgroundColor);
                    panel.add(intPriPromptWords3);

                    onButton3 = new JRadioButton("<html><font face='黑体' size='4'>ON</font></html>");
                    offButton3 = new JRadioButton("<html><font face='黑体' size='4'>OFF</font></html>");
                    FEButton3 = new JRadioButton("<html><font face='黑体' size='4'>FE[19]</font></html>");
                    GEButton3 = new JRadioButton("<html><font face='黑体' size='4'>GE[4]</font></html>");

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
                    FEButton3.setSelected(true);

                    intPri3 = new JTextField("32768");
                    intPri3.setFont(TextFieldFont);
                    intPri3.setForeground(FontWhiteColor);
                    intPri3.setBounds(75, 167 + zhenzhang * 2, 140, 20);
                    intPri3.setBackground(BackgroundColor);
                    intPri3.setBorder(Border);
                    panel.add(intPri3);

                    if (intfNumber > 3) {

                        intCode4 = new JLabel("<html><font face='黑体' size='4'><接口4></font></html>");
                        intCode4.setForeground(FontBlackColor);
                        intCode4.setBounds(15, 110+ zhenzhang * 3, 50, 25);
                        intCode4.setBackground(BackgroundColor);
                        panel.add(intCode4);

                        intStatePromptWords4 = new JLabel("<html><font face='黑体' size='4'>state:</font></html>");
                        intStatePromptWords4.setForeground(FontBlackColor);
                        intStatePromptWords4.setBounds(65, 110, 50, 25);
                        intStatePromptWords4.setBackground(BackgroundColor);
                        panel.add(intStatePromptWords4);

                        intTypePromptWords4 = new JLabel("<html><font face='黑体' size='4'>type:</font></html>");
                        intTypePromptWords4.setForeground(FontBlackColor);
                        intTypePromptWords4.setBounds(30, 135 + zhenzhang * 3, 50, 25);
                        intTypePromptWords4.setBackground(BackgroundColor);
                        panel.add(intTypePromptWords4);

                        intPriPromptWords4 = new JLabel("<html><font face='黑体' size='4'>Pri:</font></html>");
                        intPriPromptWords4.setForeground(FontBlackColor);
                        intPriPromptWords4.setBounds(33, 160 + zhenzhang * 3, 50, 30);
                        intPriPromptWords4.setBackground(BackgroundColor);
                        panel.add(intPriPromptWords4);

                        onButton4 = new JRadioButton("<html><font face='黑体' size='4'>ON</font></html>");
                        offButton4 = new JRadioButton("<html><font face='黑体' size='4'>OFF</font></html>");
                        FEButton4 = new JRadioButton("<html><font face='黑体' size='4'>FE[19]</font></html>");
                        GEButton4 = new JRadioButton("<html><font face='黑体' size='4'>GE[4]</font></html>");

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
                        FEButton4.setSelected(true);

                        intPri4 = new JTextField("32768");
                        intPri4.setFont(TextFieldFont);
                        intPri4.setForeground(FontWhiteColor);
                        intPri4.setBounds(75, 167 + zhenzhang * 3, 140, 20);
                        intPri4.setBackground(BackgroundColor);
                        intPri4.setBorder(Border);
                        panel.add(intPri4);

                    }
                }
            }
        }

    }

}