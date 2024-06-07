import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

class 主页 extends JPanel{

    JLayeredPane LP布局;
    JLabel 标题,副标题;
    starrySkyPanel starrySkyPanel;
    对角线面板 对角线1, 对角线2;
    roundedButton 基础知识按钮,选举规则按钮,操作指南按钮;  
    示例1按钮 示例1;
    roundedButton 示例1按钮,示例2按钮,示例3按钮;
    LineBorder 图形按钮边框;
    Font 标题字体,副标题字体;
    Font 按钮字体,按钮触发字体,图形按钮字体,图形按钮触发字体;
    Color 标题字体颜色,副标题字体颜色,按钮字体颜色,按钮背景颜色, 按钮边框颜色;
    Color 按钮触发字体颜色, 按钮触发背景颜色;
    打开文件 打开文件 = new 打开文件();
    playStatus 触碰按钮音效播放, 按下按钮音效播放;

    主页(){

        LP布局 = new JLayeredPane();
        LP布局.setBounds(0, 0, 1600, 900);

        添加starrySkyPanel();
        添加对角线();
        添加标题();
        添加按钮();
        添加图形按钮();

        添加按钮监视器();
        添加图形按钮监视器();

        this.setLayout(new BorderLayout());
        this.add(LP布局, BorderLayout.CENTER);

    }

    void 添加starrySkyPanel(){

        starrySkyPanel = new starrySkyPanel();
        starrySkyPanel.setBounds(0,0,1600,900);
        LP布局.add(starrySkyPanel, new Integer(JLayeredPane.DEFAULT_LAYER));
    }

    void 添加对角线(){

        对角线1 = new 对角线面板();
        对角线1.setBounds(40, 530, 350, 280);
        LP布局.add(对角线1, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
        
        对角线2 = new 对角线面板();
        对角线2.setBounds(540, 430, 400, 320);
        LP布局.add(对角线2, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
    }

    void 添加标题(){

        标题 = new JLabel("STP选举流程");
        标题.setBounds(100,75,712,225);
        标题字体 = new Font("黑体", Font.PLAIN , 120);  
        标题.setFont(标题字体);  
        LP布局.add(标题, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
        标题字体颜色 = new Color(0xf5, 0xf5, 0xf5);  
        标题.setForeground(标题字体颜色);

        副标题 = new JLabel(
                "<html>\t\t本教程旨在帮助网络工程学习者深入理解STP（生成树协议）的选举规则。为确保您能够顺利完成练习，我们建议您先熟悉计算机网络、STP协议和RS配置的基础知识。完成理论知识学习后，您可以从主页的三个拓扑图中选择一个开始练习。</html>");
        副标题字体 = new Font("黑体", Font.PLAIN, 18);
        副标题.setFont(副标题字体);
        LP布局.add(副标题, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
        副标题.setBounds(65, 220, 787, 187);
        副标题字体颜色 = new Color(0x6b, 0x6e, 0x70);
        副标题.setForeground(副标题字体颜色);
        
    }

    void 添加按钮(){

        基础知识按钮 = new roundedButton("基础知识", 50);
        选举规则按钮 = new roundedButton("选举规则", 50);
        操作指南按钮 = new roundedButton("操作指南", 50);

        按钮边框颜色 = new Color(0x86, 0xc2, 0x32);
        按钮字体 = new Font("黑体", Font.BOLD, 30);
        按钮触发字体 = new Font("黑体", Font.PLAIN, 27);
        
        按钮背景颜色 = new Color(0x61,0x89,0x2f);
        按钮字体颜色 = new Color(0x22, 0x26, 0x29); 
        按钮触发字体颜色 = new Color(0xee, 0xee, 0xee); 
        按钮触发背景颜色 = new Color(0x86, 0xc2, 0x32);
        触碰按钮音效播放 = new playStatus("resources\\_200音乐\\触碰按钮声.mp3");
        按下按钮音效播放 = new playStatus("resources\\_200音乐\\按下按钮声.mp3");
        
        基础知识按钮.setFont(按钮字体);
        选举规则按钮.setFont(按钮字体);
        操作指南按钮.setFont(按钮字体);   
        
        基础知识按钮.setBackground(按钮背景颜色);
        选举规则按钮.setBackground(按钮背景颜色);
        操作指南按钮.setBackground(按钮背景颜色);
        
        基础知识按钮.setForeground(按钮字体颜色);
        选举规则按钮.setForeground(按钮字体颜色);
        操作指南按钮.setForeground(按钮字体颜色);

        LP布局.add(基础知识按钮, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
        LP布局.add(选举规则按钮, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
        LP布局.add(操作指南按钮, new Integer(JLayeredPane.DEFAULT_LAYER + 1));

        基础知识按钮.setBounds(125, 432, 320, 80);
        选举规则按钮.setBounds(290, 575, 320, 80);
        操作指南按钮.setBounds(455, 717, 320, 80);

    }

    void 添加图形按钮(){

        示例1 = new 示例1按钮();

        示例1按钮 = new roundedButton("示例1", 30);
        示例2按钮 = new roundedButton("示例2", 30);
        示例3按钮 = new roundedButton("示例3", 30);

        图形按钮边框 = new LineBorder(标题字体颜色, 2); 
        图形按钮字体 = new Font("黑体", Font.BOLD, 37);
        图形按钮触发字体 = new Font("黑体", Font.PLAIN, 27);
        
        示例1按钮.setBorder(图形按钮边框);
        示例2按钮.setBorder(图形按钮边框);
        示例3按钮.setBorder(图形按钮边框);
        
        示例1按钮.setFont(按钮字体);
        示例2按钮.setFont(按钮字体);
        示例3按钮.setFont(按钮字体);   
        
        示例1按钮.setBackground(按钮背景颜色);
        示例2按钮.setBackground(按钮背景颜色);
        示例3按钮.setBackground(按钮背景颜色);
        
        示例1按钮.setForeground(按钮字体颜色);
        示例2按钮.setForeground(按钮字体颜色);
        示例3按钮.setForeground(按钮字体颜色); 

        LP布局.add(示例1, new Integer(JLayeredPane.DEFAULT_LAYER));
        LP布局.add(示例1按钮, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
        LP布局.add(示例2按钮, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
        LP布局.add(示例3按钮, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
        
        示例1按钮.setBounds(1012, 35, 500, 250);
        示例2按钮.setBounds(1012, 305, 500, 250);
        示例3按钮.setBounds(1012, 580, 500, 250);
        
    }

    void 添加按钮监视器(){

        基础知识按钮.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {

                打开文件.输入文件地址("resources\\_100文档\\基础知识.txt");
                按下按钮音效播放.播放音效();
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>已为您打开文件!</font></html>",
                        "提示", JOptionPane.INFORMATION_MESSAGE);
            }  
        }); 

        基础知识按钮.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e){

                触碰按钮音效播放.播放音效();
                基础知识按钮.setForeground(按钮触发字体颜色);
                基础知识按钮.setBackground(按钮触发背景颜色);
            }

            @Override  
            public void mouseExited(MouseEvent e) {  
                基础知识按钮.setFont(按钮字体);
                基础知识按钮.setForeground(按钮字体颜色);
                基础知识按钮.setBackground(按钮背景颜色);
            }  
        });


        //
        选举规则按钮.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                打开文件.输入文件地址("resources\\_100文档\\选举规则.txt");
                按下按钮音效播放.播放音效();
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>已为您打开文件!</font></html>",
                        "提示", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        选举规则按钮.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                触碰按钮音效播放.播放音效();
                选举规则按钮.setForeground(按钮触发字体颜色);
                选举规则按钮.setBackground(按钮触发背景颜色);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                选举规则按钮.setFont(按钮字体);
                选举规则按钮.setForeground(按钮字体颜色);
                选举规则按钮.setBackground(按钮背景颜色);
            }
        });


        //
        操作指南按钮.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                打开文件.输入文件地址("resources\\_100文档\\操作指南.txt");
                按下按钮音效播放.播放音效();
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>已为您打开文件!</font></html>",
                        "提示", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        操作指南按钮.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                触碰按钮音效播放.播放音效();
                操作指南按钮.setForeground(按钮触发字体颜色);
                操作指南按钮.setBackground(按钮触发背景颜色);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                操作指南按钮.setFont(按钮字体);
                操作指南按钮.setForeground(按钮字体颜色);
                操作指南按钮.setBackground(按钮背景颜色);
            }
        });

    }
  
    void 添加图形按钮监视器(){

        示例1按钮.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                触碰按钮音效播放.播放音效();
                LP布局.add(示例1, new Integer(JLayeredPane.DEFAULT_LAYER + 2));
            }

        });

        示例1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                按下按钮音效播放.播放音效();
            }
            
        });

        示例1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {

                LP布局.add(示例1, new Integer(JLayeredPane.DEFAULT_LAYER));
            }
        });

        

    } 

}