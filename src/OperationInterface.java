import javax.swing.*;
import java.awt.*;

class OperationInterface extends JPanel{

    InterfaceExecution IE = new InterfaceExecution();
    int intExample;
    JLayeredPane LP布局;
    starrySkyPanel starrySkyPanel;
    Line aline;
    PanelMain panelMain;
    

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

        createPanelMain();
        createPanelassume();
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

    void createPanelMain(){

        panelMain = new PanelMain(IE);
        if(intExample == 1){

        }else if(intExample == 2){
            
        }else if(intExample == 3){
            
        }

    }

    void createPanelassume(){

    }

    void creatPanelSwitch(){

    }

    



}