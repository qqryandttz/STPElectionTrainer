import javax.swing.*;
import java.awt.*;

class OperationInterface extends JPanel {

    InterfaceExecution IE;
    NetworkTopology net;
    int intExample;
    JLayeredPane LP布局;
    starrySkyPanel starrySkyPanel;
    Line aline;
    PanelMain panelMain;
    PanelAssume panelAssume;
    JPanel PanelSwitch;

    OperationInterface(InterfaceExecution interfaceExecution) {

        IE = interfaceExecution;
        LP布局 = new JLayeredPane();
        LP布局.setBounds(0, 0, 1600, 900);

        ADDstarrySkyPanel();
        ADDaline();

        this.setLayout(new BorderLayout());
        this.add(LP布局, BorderLayout.CENTER);
    }

    void ComponentsOI(int isExample) {

        intExample = isExample;

        ADDPanelSwitch();
        ADDPaneMain();
        ADDPanelassume();

    }

    void ADDstarrySkyPanel() {

        starrySkyPanel = new starrySkyPanel();
        starrySkyPanel.setBounds(0, 0, 1600, 900);
        LP布局.add(starrySkyPanel, new Integer(JLayeredPane.DEFAULT_LAYER));
    }

    void ADDaline() {
        aline = new Line();
        aline.setBounds(0, 0, 1600, 900);
        LP布局.add(aline, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
    }

    void ADDPaneMain() {

        panelMain = new PanelMain(IE, net);
        panelMain.setBounds(60, 40, 750, 375);
        LP布局.add(panelMain, new Integer(JLayeredPane.DEFAULT_LAYER + 1));

    }

    void ADDPanelassume() {

        panelAssume = new PanelAssume(IE, net);
        panelAssume.setBounds(900, 40, 600, 375);
        LP布局.add(panelAssume, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
    }

    void ADDPanelSwitch() {

        if (intExample == 1) {
            net = new NetworkTopology(1);
            PanelSwitch = new PanelSwitchFour1(net);

        } else if (intExample == 2) {
            net = new NetworkTopology(2);
            PanelSwitch = new PanelSwitchFour2(net);
        } else if (intExample == 3) {
            net = new NetworkTopology(3);
            PanelSwitch = new PanelSwitchFive(net);
        }
        PanelSwitch.setBounds(0, 475, 1600, 412);
        LP布局.add(PanelSwitch, new Integer(JLayeredPane.DEFAULT_LAYER + 1));

    }

}