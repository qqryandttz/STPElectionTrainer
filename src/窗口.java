import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class 窗口 extends JFrame{

    JMenuBar 菜单栏;
    JMenu 菜单;
    JMenuItem[] 菜单项;
    Font 菜单字体;
    Color 菜单字体颜色;

    public 窗口(String 窗口名字) {

        setTitle(窗口名字);
        setSize(1600, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(false);

        setVisible(true);
    }
    
    public 窗口(String 窗口名字, JMenuItem[] 得到菜单项){

        JMenuItem[] 菜单项 = 得到菜单项;
        setTitle(窗口名字);
        setSize(1600, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(false); 

        初始化菜单信息();
        添加菜单(菜单项);
        setVisible(true);
    }

    void 初始化菜单信息(){

        菜单栏 = new JMenuBar();
        菜单 = new JMenu("菜单");
        菜单字体 = new Font("黑体", Font.BOLD, 22);  
        菜单字体颜色 = new Color(0x00,0x14,0x2f);
        setJMenuBar(菜单栏);
    }

    void 添加菜单(JMenuItem[] 菜单项) {

        for (int i = 0; i < 菜单项.length; i++)
            设置菜单项(菜单项[i], 菜单项[i].getText());

    }

    void 设置菜单项(JMenuItem 菜单项,String 菜单名字){

        菜单项.setFont(菜单字体);
        菜单.add(菜单项);
    }
      
}