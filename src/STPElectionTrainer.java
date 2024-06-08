import java.awt.CardLayout;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

class STPElectionTrainer{
    public static void main(String[] args) {

        InterfaceExecution InterfaceExecution = new InterfaceExecution();
        InterfaceExecution.开始InterfaceExecution();
    }
}


class InterfaceExecution{

    CardLayout CL布局;
    myJFrame myJFrame;
    homePage homePage;
    OperationInterface OperationInterface;
    JMenuItem[] JMenuItem; 
    playStatus soundEffect,bgMusic;
    
    void 开始InterfaceExecution(){

        CL布局 = new CardLayout();
        初始化菜单();
        myJFrame = new myJFrame("STPElectionTrainer",JMenuItem);
        homePage = new homePage();
        OperationInterface = new OperationInterface();

        //bgMusic = new playStatus(".\\resources\\_200音乐\\经年如夏.mp3");
        //bgMusic.播放循环音乐();

        myJFrame.getContentPane().setLayout(CL布局);
        myJFrame.getContentPane().add(homePage, "主页");
        myJFrame.getContentPane().add(OperationInterface, "操作界面");
        CL布局.show(myJFrame.getContentPane(), "主页");

    }

    void 初始化菜单(){

    JMenuItem = new JMenuItem[5];
    JMenuItem[0] = new JMenuItem("音量控制");  
    JMenuItem[1] = new JMenuItem("操作指南");  
    JMenuItem[2] = new JMenuItem("基础知识");  
    JMenuItem[3] = new JMenuItem("选举规则");  
    JMenuItem[4] = new JMenuItem("返回"); 

    }

    void 切换到主页(){

        CL布局.show(myJFrame.getContentPane(), "主页");
    }

    void 切换到OperationInterface(){

        CL布局.show(myJFrame.getContentPane(), "操作界面");
    }


}


class OperationInterface extends JPanel{

}

                    