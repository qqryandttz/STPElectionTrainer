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
    操作界面 操作界面;
    JMenuItem[] JMenuItem; 
    playStatus 音效播放,背景音乐播放;
    
    void 开始InterfaceExecution(){

        CL布局 = new CardLayout();
        初始化菜单();
        myJFrame = new myJFrame("STPElectionTrainer",JMenuItem);
        homePage = new homePage();
        操作界面 = new 操作界面();

        //背景音乐播放 = new 音乐播放(".\\resources\\_200音乐\\经年如夏.mp3");
        //背景音乐播放.播放循环音乐();

        myJFrame.getContentPane().setLayout(CL布局);
        myJFrame.getContentPane().add(homePage, "主页");
        myJFrame.getContentPane().add(操作界面, "操作界面");
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

    void 切换到操作界面(){

        CL布局.show(myJFrame.getContentPane(), "操作页面");
    }


}


class 操作界面 extends JPanel{

}

                    