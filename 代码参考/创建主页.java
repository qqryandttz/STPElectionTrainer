package 代码参考;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

class 创建主页 extends JPanel{

    JLayeredPane LP布局;
    JLabel 标题,副标题;
    圆角按钮 开始按钮;  
    圆角按钮 继续按钮;  
    圆角按钮 选项按钮;   
    星空面板 星空面板;
    Font 标题字体,副标题字体,按钮字体,按钮触发字体;
    Color 标题字体颜色,副标题字体颜色,按钮字体颜色,按钮背景颜色;
    Color 副标题触发字体颜色,按钮触发字体颜色;
    音乐播放 触碰按钮音效播放,按下按钮音效播放;

    创建主页(){}
    创建主页(String s,界面逻辑 逻辑){ 

        LP布局 = new JLayeredPane();
        LP布局.setBounds(0, 0, 1600, 900);
        
        添加标题和副标题();

        星空面板 = new 星空面板();
        LP布局.add(星空面板, JLayeredPane.DEFAULT_LAYER);
        星空面板.setBounds(0,0,1700,800);

        添加开始继续选项按钮();
        添加按钮的监视器(逻辑);
        
        this.setLayout(new BorderLayout());   
        this.add(LP布局, BorderLayout.CENTER); 
    }

    void 添加标题和副标题(){
        标题 = new JLabel("The Slumber Interval");
        标题字体 = new Font("黑体", Font.ITALIC, 120);  
        标题.setFont(标题字体);  
        LP布局.add(标题, JLayeredPane.DEFAULT_LAYER + 1);
        标题.setBounds(155,75,1500,225);
        标题字体颜色 = new Color(0x66, 0xfa, 0xf1);  
        标题.setForeground(标题字体颜色);

        副标题 = new JLabel("<html>Happy birthday!  I hope your dreams are filled with candies and laughter. When you wake up, maybe we can go explore the wider world together.</html>");
        副标题字体 = new Font("黑体", Font.CENTER_BASELINE, 24);  
        副标题.setFont(副标题字体);  
        LP布局.add(副标题, JLayeredPane.DEFAULT_LAYER + 1);
        副标题.setBounds(355,322,787,187);
        副标题字体颜色 = new Color(0xc5, 0xc6, 0xc7); 
        副标题.setForeground(副标题字体颜色);

        /*会闪屏,放弃了
        副标题触发字体颜色 = new Color(0xc5, 0xc6, 0xc7); 
        副标题.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                副标题字体颜色 = new Color(0xFF,0xFB,0xF7);
                副标题.setForeground(副标题字体颜色);
            }

            @Override  
            public void mouseExited(MouseEvent e) {  
                副标题.setForeground(副标题触发字体颜色);
            }  
        });
         */
    }


    void 添加开始继续选项按钮(){

        开始按钮 = new 圆角按钮("START",30);  
        继续按钮 = new 圆角按钮("CONNECTED",30);  
        选项按钮 = new 圆角按钮("OPTION",30); 
        
        开始按钮.setBorderPainted(false);
        继续按钮.setBorderPainted(false);
        选项按钮.setBorderPainted(false);
        LineBorder 边框 = new LineBorder(标题字体颜色, 2); 
        开始按钮.setBorder(边框);
        继续按钮.setBorder(边框);
        选项按钮.setBorder(边框);

        按钮字体 = new Font("黑体", Font.BOLD, 30);
        开始按钮.setFont(按钮字体);
        继续按钮.setFont(按钮字体);
        选项按钮.setFont(按钮字体);   
        按钮触发字体 = new Font("黑体", Font.PLAIN, 27);

        按钮背景颜色 = new Color(0x01,0x42,0x54);
        开始按钮.setBackground(按钮背景颜色);
        继续按钮.setBackground(按钮背景颜色);
        选项按钮.setBackground(按钮背景颜色);

        按钮字体颜色 = new Color(0x1a, 0xbc, 0xbd);  
        开始按钮.setForeground(按钮字体颜色);
        继续按钮.setForeground(按钮字体颜色);
        选项按钮.setForeground(按钮字体颜色);
        按钮触发字体颜色 = new Color(0x66, 0xfa, 0xf1);

       
        LP布局.add(开始按钮, JLayeredPane.DEFAULT_LAYER + 1); 
        LP布局.add(继续按钮, JLayeredPane.DEFAULT_LAYER + 1);  
        LP布局.add(选项按钮, JLayeredPane.DEFAULT_LAYER + 1); 
        开始按钮.setBounds(225,675,300,75);
        继续按钮.setBounds(638,675,300,75);
        选项按钮.setBounds(1050,675,300,75);
    }

    void 添加按钮的监视器(界面逻辑 逻辑){

        触碰按钮音效播放 = new 音乐播放("resources\\_300音频\\音效\\触碰按钮声.mp3");
        按下按钮音效播放 = new 音乐播放("resources\\_300音频\\音效\\按下按钮声.mp3");

        开始按钮.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {

            按下按钮音效播放.播放音效();

            if(逻辑.is结束 == true)
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>故事已经结束啦,生活还要接着过, 加油吧!</font></html>", "Happy birthday!", JOptionPane.INFORMATION_MESSAGE);
            else
                if(逻辑.is存档 == true)
                    JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>已为您存档,点击[继续]进入游戏, 若要重新开始请重启游戏</font></html>", "提示", JOptionPane.INFORMATION_MESSAGE);
                else
                    逻辑.切换到剧情页面();
            }  
        });  
        开始按钮.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                触碰按钮音效播放.播放音效();
                开始按钮.setFont(按钮触发字体);
                开始按钮.setForeground(按钮触发字体颜色);
                开始按钮.setBounds(237,677,270,70);
                开始按钮.setBorderPainted(true);
            }

            @Override  
            public void mouseExited(MouseEvent e) {  
                开始按钮.setFont(按钮字体);
                开始按钮.setForeground(按钮字体颜色);
                开始按钮.setBounds(225,675,300,75);
                开始按钮.setBorderPainted(false);
            }  
        });


        继续按钮.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
            
            按下按钮音效播放.播放音效();

            if(逻辑.is结束 == true)
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>故事已经结束啦,生活还要接着过, 加油吧!</font></html>", "Happy birthday!", JOptionPane.INFORMATION_MESSAGE);
            else
                if( 逻辑.is存档 == true ){
                    逻辑.切换到剧情页面();
                    逻辑.剧情页面.背景音乐播放 = new 音乐播放(".\\resources\\_300音频\\背景音乐\\经年如夏.mp3");
                    逻辑.剧情页面.背景音乐播放.播放循环音乐();
                }else
                    JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>未找到有效存档 !</font></html>", "提示", JOptionPane.INFORMATION_MESSAGE);
            }  
        });  
        继续按钮.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                触碰按钮音效播放.播放音效();
                继续按钮.setFont(按钮触发字体);
                继续按钮.setForeground(按钮触发字体颜色);
                继续按钮.setBounds(650,677,270,70);
                继续按钮.setBorderPainted(true);
            }

            @Override  
            public void mouseExited(MouseEvent e) {  
                继续按钮.setFont(按钮字体);
                继续按钮.setForeground(按钮字体颜色);
                继续按钮.setBounds(636,675,300,75);
                继续按钮.setBorderPainted(false);
            }  
        });


        选项按钮.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                按下按钮音效播放.播放音效();
                
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>马上就开发到这里了!</font></html>", "选项", JOptionPane.INFORMATION_MESSAGE);
            }  
        });  
        选项按钮.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                触碰按钮音效播放.播放音效();
                选项按钮.setFont(按钮触发字体);
                选项按钮.setForeground(按钮触发字体颜色);
                选项按钮.setBounds(1058,677,270,70);
                选项按钮.setBorderPainted(true);
            }

            @Override  
            public void mouseExited(MouseEvent e) {  
                选项按钮.setFont(按钮字体);
                选项按钮.setForeground(按钮字体颜色);
                选项按钮.setBounds(1050,675,300,75);
                选项按钮.setBorderPainted(false);
            }  
        });

    }
}
