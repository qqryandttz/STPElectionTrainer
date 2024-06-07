import java.awt.CardLayout;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

class STPElectionTrainer{
    public static void main(String[] args) {

        界面执行 界面执行 = new 界面执行();
        界面执行.开始界面执行();
    }
}


class 界面执行{

    CardLayout CL布局;
    窗口 窗口;
    主页 主页;
    操作界面 操作界面;
    JMenuItem[] 菜单项; 
    音乐播放 音效播放,背景音乐播放;
    
    void 开始界面执行(){

        CL布局 = new CardLayout();
        初始化菜单();
        窗口 = new 窗口("STPElectionTrainer",菜单项);
        主页 = new 主页();
        操作界面 = new 操作界面();

        背景音乐播放 = new 音乐播放(".\\resources\\经年如夏.mp3");
        背景音乐播放.播放循环音乐();

        窗口.getContentPane().setLayout(CL布局);
        窗口.getContentPane().add(主页, "主页");
        窗口.getContentPane().add(操作界面, "操作界面");
        CL布局.show(窗口.getContentPane(), "主页");

    }

    void 初始化菜单(){

    菜单项 = new JMenuItem[5];
    菜单项[0] = new JMenuItem("音量控制");  
    菜单项[1] = new JMenuItem("操作指南");  
    菜单项[2] = new JMenuItem("基础知识");  
    菜单项[3] = new JMenuItem("选举规则");  
    菜单项[4] = new JMenuItem("返回"); 

    }

    void 切换到主页(){

        CL布局.show(窗口.getContentPane(), "主页");
    }

    void 切换到操作界面(){

        CL布局.show(窗口.getContentPane(), "操作页面");
    }


}


class 操作界面 extends JPanel{

}

                    