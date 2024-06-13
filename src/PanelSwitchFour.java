import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;
import javax.swing.JTextField;

//4交换机面板
class PanelSwitchFour extends JPanel {

    PanelSwitch ps1, ps2, ps3, ps4;

    PanelSwitchFour() {
        setLayout(null); 
        setOpaque(false);
        ADDPanelSwitch();
    }

    void ADDPanelSwitch(){

        ps1 = new PanelSwitch();
        ps2 = new PanelSwitch();
        ps3 = new PanelSwitch();
        ps4 = new PanelSwitch();

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

    PanelSwitchFive() {
        setLayout(null); 
        setOpaque(false);
        ADDPanelSwitch();
    }

    void ADDPanelSwitch() {

        ps1 = new PanelSwitch();
        ps2 = new PanelSwitch();
        ps3 = new PanelSwitch();
        ps4 = new PanelSwitch();
        ps5 = new PanelSwitch();

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

    JTextField name;

    PanelSwitch(){

        name = new JTextField();
        add(name);

    }

    @Override
    protected void paintComponent(Graphics g) {

        

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
        g2d.setColor(getBackground());
        g2d.fill(roundedRectangle);
        setBackground(new Color(0x61, 0x89, 0x2f));

    }

}