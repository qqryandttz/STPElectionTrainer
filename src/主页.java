import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

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
        标题.setBounds(75,75,712,225);
        标题字体 = new Font("黑体", Font.ITALIC, 120);  
        标题.setFont(标题字体);  
        标题字体颜色 = new Color(0x66, 0xfa, 0xf1);  
        标题.setForeground(标题字体颜色);
        LP布局.add(标题, JLayeredPane.DEFAULT_LAYER + 1);
    }

    void 初始化按钮(圆角按钮 按钮,String 按钮名字,int 按钮位置){

        按钮 = new 圆角按钮(按钮名字, 30);
        LP布局.add(按钮, JLayeredPane.DEFAULT_LAYER + 1); 
        按钮.setBounds(225,按钮位置,370,75);

    }

    void 添加按钮(){

        初始化按钮(基础知识按钮,"基础知识",412);
        初始化按钮(选举规则按钮,"选举规则",465);
        初始化按钮(操作指南按钮,"操作指南",517); 

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
        按钮.setBounds(1012,按钮位置,412,225);

    }

    void 添加图形按钮(){

        初始化按钮(示例1按钮,"示例1",75);
        初始化按钮(示例2按钮,"示例2",352);
        初始化按钮(示例3按钮,"示例3",630); 

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