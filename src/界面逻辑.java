import javax.swing.*;
import java.awt.*;

class 界面逻辑{

    建立窗口 窗口;
    CardLayout CL布局;
    创建主页 主页;
    初始化剧情页面 剧情页面;
    JPanel 按钮面板;
    音乐播放 背景音乐播放;
    //存档功能 存档功能;
    boolean is存档 = false, is结束 = false;

    public void 进行CL布局(){

        窗口 = new 建立窗口("沉眠间隔",this);
        CL布局 = new CardLayout();
        窗口.getContentPane().setLayout(CL布局); 

        主页 = new 创建主页("主页",this);
        窗口.getContentPane().add(主页, "主页");  
        CL布局.show(窗口.getContentPane(),"主页");

        剧情页面 = new 初始化剧情页面("剧情页面",this);
        窗口.getContentPane().add(剧情页面, "剧情页面");

        背景音乐播放 = new 音乐播放(".\\resources\\_300音频\\背景音乐\\鸟之诗.mp3");
        背景音乐播放.播放循环音乐();

    }

    void 切换到主页面(){
        剧情页面.背景音乐播放.停止();
        CL布局.show(窗口.getContentPane(), "主页"); 
        窗口.setJMenuBar(null);
        背景音乐播放.播放循环音乐();
        is存档 = true;
    }

    void 切换到剧情页面(){
        
        CL布局.show(窗口.getContentPane(), "剧情页面"); 
        窗口.setJMenuBar(窗口.菜单栏);
        背景音乐播放.停止(); 
        剧情页面.语句处理器.进行分析();
    }
}
