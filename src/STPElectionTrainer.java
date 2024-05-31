import java.awt.Color;
import java.awt.Font;
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


class 界面逻辑{

    
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

    主页(){

        LP布局 = new JLayeredPane();
        LP布局.setBounds(0, 0, 1600, 900);

        添加星空面板();
        添加标题();
        添加按钮();
        添加图形按钮();
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

        按钮边框 = new LineBorder(标题字体颜色, 2); 
        按钮字体 = new Font("黑体", Font.BOLD, 30);
        按钮触发字体 = new Font("黑体", Font.PLAIN, 27);
        按钮背景颜色 = new Color(0x01,0x42,0x54);
        按钮字体颜色 = new Color(0x1a, 0xbc, 0xbd);  
        按钮触发字体颜色 = new Color(0x66, 0xfa, 0xf1);

    }

    void 添加按钮(){

        初始化按钮(基础知识按钮,"基础知识",1);
        初始化按钮(选举规则按钮,"选举规则",1);
        初始化按钮(操作指南按钮,"操作指南",1); 
        
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

        按钮边框 = new LineBorder(标题字体颜色, 2); 
        按钮字体 = new Font("黑体", Font.BOLD, 30);
        按钮触发字体 = new Font("黑体", Font.PLAIN, 27);
        按钮背景颜色 = new Color(0x01,0x42,0x54);
        按钮字体颜色 = new Color(0x1a, 0xbc, 0xbd);  
        按钮触发字体颜色 = new Color(0x66, 0xfa, 0xf1);

    }

    void 添加图形按钮(){

        初始化按钮(示例1按钮,"示例1",1);
        初始化按钮(示例2按钮,"示例2",1);
        初始化按钮(示例3按钮,"示例3",1); 
        
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

    
}

class 窗口 extends JFrame{

    JMenuBar 菜单栏;
    JMenu 菜单;
    JMenuItem 音量控制,关于;
    JMenuItem 返回主页,帮助;
    
    public 窗口(String 窗口名字){

        setTitle(窗口名字);
        setSize(1600, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(false); 

    }

    void 主页添加菜单(){

        音量控制 = new JMenuItem("音量控制");
        关于 = new JMenuItem("关于");
    }

    void 剧情页面添加菜单(){

        返回主页 = new JMenuItem("返回主页");
        帮助 = new JMenuItem("帮助");
    }

    void 重置菜单(){
        setJMenuBar(null);
    }

    void 重置菜单(音乐播放 背景音乐){
        背景音乐.停止();
        setJMenuBar(null);
    }

}

class 操作界面{

}