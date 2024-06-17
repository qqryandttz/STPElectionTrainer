import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JLabel;
import javax.swing.JPanel;
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

        ps1 = new PanelSwitch(neT.switch11.name, neT.switch11.mac, 32768L);
        ps2 = new PanelSwitch(neT.switch12.name, neT.switch12.mac, 32768L);
        ps3 = new PanelSwitch(neT.switch13.name, neT.switch13.mac, 32768L);
        ps4 = new PanelSwitch(neT.switch14.name, neT.switch14.mac, 32768L);

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

        ps1 = new PanelSwitch(neT.switch21.name, neT.switch21.mac, 32768L);
        ps2 = new PanelSwitch(neT.switch22.name, neT.switch22.mac, 32768L);
        ps3 = new PanelSwitch(neT.switch23.name, neT.switch23.mac, 32768L);
        ps4 = new PanelSwitch(neT.switch24.name, neT.switch24.mac, 32768L);

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

        ps1 = new PanelSwitch(neT.switch31.name, neT.switch31.mac, 32768L);
        ps2 = new PanelSwitch(neT.switch32.name, neT.switch32.mac, 32768L);
        ps3 = new PanelSwitch(neT.switch33.name, neT.switch33.mac, 32768L);
        ps4 = new PanelSwitch(neT.switch34.name, neT.switch34.mac, 32768L);
        ps5 = new PanelSwitch(neT.switch35.name, neT.switch35.mac, 32768L);

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

    String theName, theMAC;
    long thePri;
    JTextField name, MAC, Pri;
    JLabel namePromptWords, MACPromptWords, PriPromptWords;
    JLabel intPIDPromptWords, intStatePromptWords;
    Font PromptWordsFont, TextFieldFont;
    Color FontColor;
    EmptyBorder Border;

    PanelSwitch(String aName, String aMAC, long aPri){

        theName = aName;
        theMAC = aMAC;
        thePri = aPri;
        setLayout(null);
        Init();
        ADDLabel();
        ADDTextField();

    }

    void Init(){

        TextFieldFont = new Font("黑体", Font.PLAIN, 17);
        PromptWordsFont = new Font("黑体", Font.PLAIN , 20);
        FontColor = new Color(0xf5,0xf5,0xf5);
        Border = new EmptyBorder(0,0,0,0);
    }

    void ADDLabel(){

        namePromptWords = new JLabel("<html>name:</html>");
        namePromptWords.setFont(PromptWordsFont);
        namePromptWords.setForeground(FontColor);
        namePromptWords.setBounds( 10, 20, 50, 25);
        namePromptWords.setBackground(new Color(0x61, 0x89, 0x2f));
        add(namePromptWords);


        MACPromptWords = new JLabel("<html>MAC :</html>");
        MACPromptWords.setFont(PromptWordsFont);
        MACPromptWords.setForeground(FontColor);
        MACPromptWords.setBounds(10, 50, 50, 25);
        MACPromptWords.setBackground(new Color(0x61, 0x89, 0x2f));
        add(MACPromptWords);

        PriPromptWords = new JLabel("<html>pri :</html>");
        PriPromptWords.setFont(PromptWordsFont);
        PriPromptWords.setForeground(FontColor);
        PriPromptWords.setBounds(10, 75, 50, 25);
        PriPromptWords.setBackground(new Color(0x61, 0x89, 0x2f));
        add(PriPromptWords);
    }
 
    void ADDTextField(){

        name = new JTextField(theName);
        name.setFont(TextFieldFont);
        name.setForeground(FontColor);
        name.setBounds( 66, 22, 250, 20);
        name.setBackground(new Color(0x61, 0x89, 0x2f));
        name.setBorder(Border);
        add(name);

        MAC = new JTextField(theMAC);
        MAC.setFont(TextFieldFont);
        MAC.setForeground(FontColor);
        MAC.setBounds(66, 52, 250, 20);
        MAC.setBackground(new Color(0x61, 0x89, 0x2f));
        MAC.setBorder(Border);
        add(MAC);

        Pri = new JTextField("32768L");
        Pri.setFont(TextFieldFont);
        Pri.setForeground(FontColor);
        Pri.setBounds(66, 82, 250, 20);
        Pri.setBackground(new Color(0x61, 0x89, 0x2f));
        Pri.setBorder(Border);
        add(Pri);

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