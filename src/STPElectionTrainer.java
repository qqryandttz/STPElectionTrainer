import java.awt.CardLayout;
import javax.swing.JMenuItem;

class STPElectionTrainer{
    public static void main(String[] args) {

        InterfaceExecution InterfaceExecution = new InterfaceExecution();
        InterfaceExecution.进行InterfaceExecution();
    }
}


class InterfaceExecution{

    CardLayout CL布局;
    myJFrame myJFrame;
    homePage homePage;
    OperationInterface OI;
    JMenuItem[] JMenuItem; 
    playStatus bgMusic;
    int isToggle = 0;  //0代表未进入过操作页面，1代表在主页，2代表在操作页面
    
    void 进行InterfaceExecution(){

        CL布局 = new CardLayout();
        initJMenu();
        myJFrame = new myJFrame(this,"STPElectionTrainer",JMenuItem);
        homePage = new homePage(this);
        OI = new OperationInterface(this);

        bgMusic = new playStatus(".\\resources\\_200音乐\\经年如夏.mp3");
        //bgMusic.playMusicOnLoop();

        myJFrame.getContentPane().setLayout(CL布局);
        myJFrame.getContentPane().add(homePage, "主页");
        myJFrame.getContentPane().add(OI, "操作界面");
        CL布局.show(myJFrame.getContentPane(), "主页");

    }

    void initJMenu(){

        JMenuItem = new JMenuItem[5];
        JMenuItem[0] = new JMenuItem("音量控制");  
        JMenuItem[1] = new JMenuItem("操作指南");  
        JMenuItem[2] = new JMenuItem("基础知识");  
        JMenuItem[3] = new JMenuItem("选举规则");  
        JMenuItem[4] = new JMenuItem("切换"); 

    }

    void goToHomePage(){

        CL布局.show(myJFrame.getContentPane(), "主页");
    }

    void goToOperationInterface(int x){

        CL布局.show(myJFrame.getContentPane(), "操作界面");
        OI.ComponentsOI(x);
    }

    void goToOperationInterface() {

        CL布局.show(myJFrame.getContentPane(), "操作界面");
    }


}


                    