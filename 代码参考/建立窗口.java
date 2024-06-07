package 代码参考;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class 建立窗口 extends JFrame{

    JMenuBar 菜单栏;
    JMenu 菜单;
    JRadioButtonMenuItem 音量控制;

    public 建立窗口(){}
    public 建立窗口(String s,界面逻辑 逻辑){

        setTitle(s);
        setSize(1600, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        this.setResizable(false); 

        菜单栏 = new JMenuBar();
        菜单 = new JMenu("菜单");
        //音量控制 = new JRadioButtonMenuItem("音量");  
        //菜单.add(音量控制);

        JMenuItem 回顾 = new JMenuItem("回顾");  
        JMenuItem 选项 = new JMenuItem("选项");  
        JMenuItem 返回主页面 = new JMenuItem("返回主页面");
        
        Font font = new Font("黑体", Font.BOLD, 22);  
        Color 剧情字体颜色 = new Color(0x00,0x14,0x2f);  
        菜单.setForeground(剧情字体颜色);
        菜单.setFont(font);  
        回顾.setFont(font); 
        选项.setFont(font); 
        返回主页面.setFont(font);    

        返回主页面.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) { 

                逻辑.主页.按下按钮音效播放.播放音效();
                逻辑.切换到主页面();
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5' >已为您存档!</font></html>", "提示", JOptionPane.INFORMATION_MESSAGE);
            }  
        });
        
        回顾.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                逻辑.主页.按下按钮音效播放.播放音效();
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>马上就开发到这里了!</font></html>", "回顾", JOptionPane.INFORMATION_MESSAGE);

            }  
        });

        选项.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                逻辑.主页.按下按钮音效播放.播放音效();
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>马上就开发到这里了!</font></html>", "选项", JOptionPane.INFORMATION_MESSAGE);

            }  
        });

         /*//没成功, 先放着
        this.音量控制.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                System.out.println("我点击了单选按钮!");
                if(暂停标志 == false){
                    背景音乐播放.循环音乐播放线程.暂停();
                    暂停标志 = true;
                }else{
                    背景音乐播放.循环音乐播放线程.重新播放();
                    暂停标志 = false;
                }
        }}); */
    

        菜单.add(回顾);  
        菜单.add(选项);  
        菜单.add(返回主页面);  
        菜单栏.add(菜单);  

        setVisible(true);
    }
}
