import javax.swing.*;
import java.awt.*;

class OperationInterface extends JPanel{

    InterfaceExecution IE;
    int intExample;
    JLayeredPane LP布局;
    starrySkyPanel starrySkyPanel;
    Line aline;
    PanelMain panelMain;
    PanelAssume panelAssume;
    

    OperationInterface(InterfaceExecution interfaceExecution){

        IE = interfaceExecution;
        LP布局 = new JLayeredPane();
        LP布局.setBounds(0, 0, 1600, 900);

        ADDstarrySkyPanel();
        ADDaline();
        
        this.setLayout(new BorderLayout());
        this.add(LP布局, BorderLayout.CENTER);
    }

    void ComponentsOI(int isExample){

        intExample = isExample;

        ADDPaneMain();
        ADDPanelassume();
        creatPanelSwitch();

    }

    void ADDstarrySkyPanel() {

        starrySkyPanel = new starrySkyPanel();
        starrySkyPanel.setBounds(0, 0, 1600, 900);
        LP布局.add(starrySkyPanel, new Integer(JLayeredPane.DEFAULT_LAYER));
    }

    void ADDaline(){
        aline = new Line();
        aline.setBounds(0, 0, 1600, 900);
        LP布局.add(aline, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
    }

    void ADDPaneMain(){

        panelMain = new PanelMain(IE);
        panelMain.setBounds(50,40,750,375);
        LP布局.add(panelMain, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
        

    }

    void ADDPanelassume(){

        panelAssume = new PanelAssume(IE);
        panelAssume.setBounds(938, 40, 600, 375);
        LP布局.add(panelAssume, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
    }

    void creatPanelSwitch(){

    }

    



}