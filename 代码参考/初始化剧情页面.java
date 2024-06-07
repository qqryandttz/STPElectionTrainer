package 代码参考;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class 初始化剧情页面 extends JPanel{

    界面逻辑 逻辑;    
    处理语句 语句处理器;
    音乐播放 背景音乐播放;
    音乐播放 音效播放;
    透明按钮 剧情按钮;
    圆角按钮 选项a按钮,选项b按钮,选项c按钮;
    圆角按钮 名字按钮;
    JLabel 剧情文字;
    LineBorder 选项边框,剧情边框;
    Font 剧情文字字体,名字字体,选项字体;
    Color 剧情字体颜色,名字字体颜色,选项字体颜色,剧情边框颜色,选项边框颜色;
    Color 剧情按钮颜色,名字按钮颜色,选项按钮颜色,边框触发颜色;
    Image 背景图片;
    Boolean is直接显示 = false,is分支中 = false;
    String 选项值 = "61";

    初始化剧情页面(){}
    初始化剧情页面(String s,界面逻辑 传入逻辑){

        逻辑 = 传入逻辑;
        语句处理器 = new 处理语句( "resources\\_100文章\\旧矿界.txt");
        语句处理器.传递剧情页面(this);
        setLayout(null);
        setBackground(Color.BLACK); 
        
        创建剧情按钮(逻辑);
        创建名字按钮(逻辑);
        创建选项按钮();
    }

    @Override  
    protected void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        if (背景图片 != null) {  
            g.drawImage(背景图片, 0, 0, getWidth(), getHeight(), this);   
        }  
    }  



    void 创建剧情按钮(界面逻辑 逻辑){
        
        剧情按钮 = new 透明按钮();
        剧情按钮.setBounds(0,600,147,200);
        剧情边框颜色 = new Color(62, 83, 104);
        剧情边框 = new LineBorder(剧情边框颜色, 15); 
        剧情按钮.setBorder(剧情边框); 
        边框触发颜色 = new Color(0x1e,0x94,0xa0);
        
        剧情文字 = new JLabel("无");
        剧情文字字体 = new Font("黑体", Font.BOLD, 33);
        剧情文字.setFont(剧情文字字体);  
        剧情文字.setBounds(60,600,1500,200);
        剧情字体颜色 = new Color(0x00,0x14,0x2f);  
        剧情文字.setForeground(剧情字体颜色);
        add(剧情文字);
        add(剧情按钮);

        剧情按钮.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) { 
                
                if (语句处理器.is处理选择 == false ) {
                    if(逐个文本显示.得到is逐个显示()) {
                        is直接显示 = true;  
                        
                    }
                    //音效播放 = new 音乐播放(".\\resources\\_300音频\\音效\\按键单击.mp3") ;
                    //音效播放.播放音效();
                    语句处理器.进行分析();
                    is直接显示 = false; 
                } 
            }  
        });   
        
        剧情按钮.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                剧情边框 = new LineBorder(剧情边框颜色, 12);
                剧情按钮.setBorder(剧情边框); 
            }

            @Override  
            public void mouseExited(MouseEvent e) {  
                剧情边框 = new LineBorder(剧情边框颜色, 15);
                剧情按钮.setBorder(剧情边框); 
            }  
        });


    }

    void 创建名字按钮(界面逻辑 逻辑){
        名字按钮 = new 圆角按钮("无", 30);
        名字字体 = new Font("黑体", Font.PLAIN, 30);
        名字按钮.setFont(名字字体);
        名字字体颜色 = new Color(0xf2,0xeb,0xe5);
        名字按钮.setForeground(名字字体颜色);
        名字按钮颜色 = new Color(52, 73, 94);
        名字按钮.setBackground(名字按钮颜色);
        名字按钮.setBounds(0,565,245,56);
        名字按钮.setVisible(true);

        Insets insets = new Insets(0, 0, 5, 0);
        Border border = new EmptyBorder(insets);  //把名字调高了一点,看着舒服
        名字按钮.setBorder(border);
        add(名字按钮);

        名字按钮.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                语句处理器.进行分析();
            }  
        });
    }

    void 创建选项按钮(){

        选项a按钮 = new 圆角按钮("无", 30);
        选项b按钮 = new 圆角按钮("无", 30);
        选项c按钮 = new 圆角按钮("无", 30);

        选项字体 = new Font("黑体", Font.PLAIN, 30);
        选项a按钮.setFont(选项字体);
        选项b按钮.setFont(选项字体);
        选项c按钮.setFont(选项字体);

        选项字体颜色 = new Color(0xf2,0xeb,0xe5);
        选项a按钮.setForeground(选项字体颜色);
        选项b按钮.setForeground(选项字体颜色);
        选项c按钮.setForeground(选项字体颜色);

        选项按钮颜色 = new Color(62, 83, 104);
        选项a按钮.setBackground(选项按钮颜色);
        选项b按钮.setBackground(选项按钮颜色);
        选项c按钮.setBackground(选项按钮颜色);

        选项a按钮.setBounds(487,112,637,75);
        选项b按钮.setBounds(487,262,637,75);
        选项c按钮.setBounds(487,412,637,75);

        选项a按钮.setVisible(true);
        选项b按钮.setVisible(true);
        选项c按钮.setVisible(true);

        选项边框颜色 = new Color(0x28,0x3b,0x42);
        选项边框 = new LineBorder(选项边框颜色, 5); 
        选项a按钮.setBorder(选项边框); 
        选项b按钮.setBorder(选项边框); 
        选项c按钮.setBorder(选项边框);  
        add(选项a按钮);
        add(选项b按钮);
        add(选项c按钮);

        选项a按钮.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) { 
                逻辑.主页.按下按钮音效播放.播放音效(); 
                选项值 = "A";
                语句处理器.选择分析();
                System.out.println("你选择了A");
                is分支中 = true;         
            }  
        });

        选项b按钮.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                逻辑.主页.按下按钮音效播放.播放音效();
                选项值 = "B";
                语句处理器.选择分析();
                System.out.println("你选择了B");
                is分支中 = true;         
            }  
        });

        选项c按钮.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                逻辑.主页.按下按钮音效播放.播放音效();
                选项值 = "C";
                语句处理器.选择分析();
                System.out.println("你选择了C");
                is分支中 = true;      
            }  
        });



        选项a按钮.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                逻辑.主页.触碰按钮音效播放.播放音效();
                选项边框 = new LineBorder(边框触发颜色, 5);
                选项a按钮.setBorder(选项边框); 
            }

            @Override  
            public void mouseExited(MouseEvent e) {  
                选项边框 = new LineBorder(选项边框颜色, 5);
                选项a按钮.setBorder(选项边框); 
            }  
        });


        选项b按钮.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                逻辑.主页.触碰按钮音效播放.播放音效();
                选项边框 = new LineBorder(边框触发颜色, 5);
                选项b按钮.setBorder(选项边框); 
            }

            @Override  
            public void mouseExited(MouseEvent e) {  
                选项边框 = new LineBorder(选项边框颜色, 5);
                选项b按钮.setBorder(选项边框); 
            }  
        });



        选项c按钮.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                逻辑.主页.触碰按钮音效播放.播放音效();
                选项边框 = new LineBorder(边框触发颜色, 5);
                选项c按钮.setBorder(选项边框); 
            }

            @Override  
            public void mouseExited(MouseEvent e) {  
                选项边框 = new LineBorder(选项边框颜色, 5);
                选项c按钮.setBorder(选项边框); 
            }  
        });


    }

    void 对话按钮添加(){
        add(名字按钮);
        剧情按钮.setBorderPainted(false);
        剧情按钮.setBounds(0,620,1600,170);
        重置页面();
    }

    void 对话按钮移除(){
        remove(名字按钮);
        剧情按钮.setBorderPainted(true);
        剧情按钮.setBounds(0,600,1600,200);
        重置页面();
    }

    void 添加选项按钮(){
        add(选项a按钮);
        add(选项b按钮);
        add(选项c按钮);
        重置页面();
    }

    void 移除选项按钮(){
        remove(选项a按钮);
        remove(选项b按钮);
        remove(选项c按钮);
        重置页面();
    }

    String 传递选项(){
        return 选项值;

    }

    void 重置页面(){
        revalidate();
        repaint();
    }
}
