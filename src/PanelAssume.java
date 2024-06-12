import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

//推测面板
class PanelAssume extends JPanel {

    InterfaceExecution IE;
    JPanel panelExample;
    JRadioButton radioButton1,radioButton2,radioButton3,radioButton4;
    ButtonGroup buttonGroup;

    PanelAssume(InterfaceExecution interfaceExecution){
        IE = interfaceExecution;
        setLayout(null);

    }


    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

    }


}

//4交换机面板
class PanelSwitchFour extends JPanel {

}

//5交换机面板
class PanelSwitchFive extends JPanel {

}