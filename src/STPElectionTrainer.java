import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

class STPElectionTrainer{
    public static void main(String[] args) {
        
    }
}


class 界面执行{

    CardLayout CL布局;
    窗口 窗口;
    主页 主页;
    操作界面 操作界面;
    音乐播放 音效播放,背景音乐播放;
    
    界面执行(){

        CL布局 = new CardLayout();
        窗口 = new 窗口("STPElectionTrainer");
        主页 = new 主页();
        操作界面 = new 操作界面();

        背景音乐播放 = new 音乐播放(".\\resources\\经年如夏.mp3");
        背景音乐播放.播放循环音乐();

        窗口.getContentPane().setLayout(CL布局);
        窗口.getContentPane().add(主页, "主页");
        窗口.getContentPane().add(操作界面, "操作界面");
        CL布局.show(窗口.getContentPane(), "主页");

    }

    void 切换到主页(){

    }

    void 切换到操作界面(){

    }


}


class 主页 extends JPanel{

    JLayeredPane LP布局;
    JLabel 标题;
    星空面板 星空面板;
    圆角按钮 基础知识按钮,选举规则按钮,操作指南按钮;  
    圆角按钮 示例1按钮,示例2按钮,示例3按钮;
    LineBorder 按钮边框;
    Font 标题字体,按钮字体,按钮触发字体;
    Color 标题字体颜色,按钮字体颜色,按钮背景颜色;
    Color 按钮触发字体颜色, 按钮触发背景颜色;
    音乐播放 触碰按钮音效播放, 按下按钮音效播放;

    主页(){

        LP布局 = new JLayeredPane();
        LP布局.setBounds(0, 0, 1600, 900);

        添加星空面板();
        添加标题();
        添加按钮();
        添加图形按钮();

        添加按钮监视器();
        添加图形按钮监视器();
    }

    void 添加星空面板(){

        星空面板 = new 星空面板();
        LP布局.add(星空面板, JLayeredPane.DEFAULT_LAYER);
        星空面板.setBounds(0,0,1700,800);
    }

    void 添加标题(){

        标题 = new JLabel("STP选举流程");
        标题.setBounds(155,75,1500,225); //待改
        标题字体 = new Font("黑体", Font.ITALIC, 120);  
        标题.setFont(标题字体);  
        标题字体颜色 = new Color(0x66, 0xfa, 0xf1);  
        标题.setForeground(标题字体颜色);
        LP布局.add(标题, JLayeredPane.DEFAULT_LAYER + 1);
    }

    void 初始化按钮(圆角按钮 按钮,String 按钮名字,int 按钮位置){

        按钮 = new 圆角按钮(按钮名字, 30);
        LP布局.add(按钮, JLayeredPane.DEFAULT_LAYER + 1); 
        按钮.setBounds(225,按钮位置,300,75);

    }

    void 添加按钮(){

        初始化按钮(基础知识按钮,"基础知识",1);
        初始化按钮(选举规则按钮,"选举规则",1);
        初始化按钮(操作指南按钮,"操作指南",1); 

        按钮边框 = new LineBorder(标题字体颜色, 2); 
        按钮字体 = new Font("黑体", Font.BOLD, 30);
        按钮触发字体 = new Font("黑体", Font.PLAIN, 27);
        按钮背景颜色 = new Color(0x01,0x42,0x54);
        按钮字体颜色 = new Color(0x1a, 0xbc, 0xbd);  
        按钮触发字体颜色 = new Color(0x66, 0xfa, 0xf1);
        触碰按钮音效播放 = new 音乐播放("resources\\触碰按钮声.mp3");
        按下按钮音效播放 = new 音乐播放("resources\\按下按钮声.mp3");

        
        基础知识按钮.setBorder(按钮边框);
        选举规则按钮.setBorder(按钮边框);
        操作指南按钮.setBorder(按钮边框);
        
        基础知识按钮.setFont(按钮字体);
        选举规则按钮.setFont(按钮字体);
        操作指南按钮.setFont(按钮字体);   
        
        基础知识按钮.setBackground(按钮背景颜色);
        选举规则按钮.setBackground(按钮背景颜色);
        操作指南按钮.setBackground(按钮背景颜色);
        
        基础知识按钮.setForeground(按钮字体颜色);
        选举规则按钮.setForeground(按钮字体颜色);
        操作指南按钮.setForeground(按钮字体颜色);
        
    }

    void 初始化图形按钮(圆角按钮 按钮,String 按钮名字,int 按钮位置){

        按钮 = new 圆角按钮(按钮名字, 30);
        LP布局.add(按钮, JLayeredPane.DEFAULT_LAYER + 1); 
        按钮.setBounds(225,按钮位置,300,75);

    }

    void 添加图形按钮(){

        初始化按钮(示例1按钮,"示例1",1);
        初始化按钮(示例2按钮,"示例2",1);
        初始化按钮(示例3按钮,"示例3",1); 

        按钮边框 = new LineBorder(标题字体颜色, 2); 
        按钮字体 = new Font("黑体", Font.BOLD, 30);
        按钮触发字体 = new Font("黑体", Font.PLAIN, 27);
        按钮背景颜色 = new Color(0x01,0x42,0x54);
        按钮字体颜色 = new Color(0x1a, 0xbc, 0xbd);  
        按钮触发字体颜色 = new Color(0x66, 0xfa, 0xf1);
        
        示例1按钮.setBorder(按钮边框);
        示例2按钮.setBorder(按钮边框);
        示例3按钮.setBorder(按钮边框);
        
        示例1按钮.setFont(按钮字体);
        示例2按钮.setFont(按钮字体);
        示例3按钮.setFont(按钮字体);   
        
        示例1按钮.setBackground(按钮背景颜色);
        示例2按钮.setBackground(按钮背景颜色);
        示例3按钮.setBackground(按钮背景颜色);
        
        示例1按钮.setForeground(按钮字体颜色);
        示例2按钮.setForeground(按钮字体颜色);
        示例3按钮.setForeground(按钮字体颜色); 
    }

    void 添加按钮监视器(){

        基础知识按钮.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {

                按下按钮音效播放.播放音效();
            }  
        }); 

        基础知识按钮.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e){

                触碰按钮音效播放.播放音效();
                基础知识按钮.setFont(按钮触发字体);
                基础知识按钮.setForeground(按钮触发字体颜色);
                基础知识按钮.setBounds(237,677,270,70);
                基础知识按钮.setBorderPainted(true);
            }

            @Override  
            public void mouseExited(MouseEvent e) {  
                基础知识按钮.setFont(按钮字体);
                基础知识按钮.setForeground(按钮字体颜色);
                基础知识按钮.setBounds(225,675,300,75);
                基础知识按钮.setBorderPainted(false);
            }  
        });

    }
  
    void 添加图形按钮监视器(){

    }

}

class 窗口 extends JFrame{

    JMenuBar 菜单栏;
    JMenu 主页菜单,操作界面菜单;
    JMenuItem 音量控制,关于;
    JMenuItem 返回主页,帮助;
    Font 菜单字体;
    Color 菜单字体颜色;
    
    public 窗口(String 窗口名字){

        setTitle(窗口名字);
        setSize(1600, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(false); 

        初始化菜单信息();
        主页添加菜单();

        setVisible(true);
    }

    void 初始化菜单信息(){

        菜单栏 = new JMenuBar();
        主页菜单 = new JMenu("菜单");
        操作界面菜单 = new JMenu("菜单");
        菜单字体 = new Font("黑体", Font.BOLD, 22);  
        菜单字体颜色 = new Color(0x00,0x14,0x2f);

        setJMenuBar(菜单栏);
    }

    void 设置菜单项(JMenu 菜单,JMenuItem 菜单项,String 菜单名字){

        菜单项 = new JMenuItem(菜单名字);
        菜单项.setFont(菜单字体);
        菜单.add(菜单项);
    }

    void 主页添加菜单(){

        设置菜单项(主页菜单,音量控制,"音量控制");
        设置菜单项(主页菜单,关于, "关于");
    }

    void 操作界面添加菜单(){

        设置菜单项(操作界面菜单,返回主页,"返回主页");
        设置菜单项(操作界面菜单,帮助, "帮助");
    }

    void 取消菜单(JMenu 菜单){
        菜单栏.remove(菜单);
    }

    void 取消菜单(JMenu 菜单,音乐播放 背景音乐){
        背景音乐.停止();
        菜单栏.remove(菜单);
    }

}


class 操作界面 extends JPanel{

}

