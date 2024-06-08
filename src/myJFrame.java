import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class myJFrame extends JFrame{

    JMenuBar myJMenuBar;
    JMenu JMenu;
    JMenuItem[] myJMenuItem;
    Font JMenuFont;
    Color JMenuFontColor;

    public myJFrame(String myJFrameName) {

        setTitle(myJFrameName);
        setSize(1600, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        this.setResizable(false);

        setVisible(true);
    }
    
    public myJFrame(String myJFrameName, JMenuItem[] 得到myJMenuItem){

        JMenuItem[] myJMenuItem = 得到myJMenuItem;
        setTitle(myJFrameName);
        setSize(1600, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        this.setResizable(false); 

        初始化JMenu信息();
        添加JMenu(myJMenuItem);
        setVisible(true);
    }

    void 初始化JMenu信息(){

        myJMenuBar = new JMenuBar();
        JMenu = new JMenu("菜单");
        JMenuFont = new Font("黑体", Font.BOLD, 22);  
        JMenuFontColor = new Color(0x00,0x14,0x2f);
        setJMenuBar(myJMenuBar);
    }

    void 添加JMenu(JMenuItem[] myJMenuItem) {

        for (int i = 0; i < myJMenuItem.length; i++)
            设置myJMenuItem(myJMenuItem[i], myJMenuItem[i].getText());

    }

    void 设置myJMenuItem(JMenuItem myJMenuItem,String JMenuName){

        myJMenuItem.setFont(JMenuFont);
        JMenu.add(myJMenuItem);
    }
      
}