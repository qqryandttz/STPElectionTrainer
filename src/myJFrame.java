import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class myJFrame extends JFrame{

    JMenuBar myJMenuBar;
    JMenu myJMenu;
    JMenuItem[] myJMenuItem;
    Font menuFont;
    Color menuFontColor;

    public myJFrame(String Name) {

        setTitle(Name);
        setSize(1600, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        this.setResizable(false);

        setVisible(true);
    }
    
    public myJFrame(String Name, JMenuItem[] menuItems){

        this.myJMenuItem = menuItems;
        setTitle(Name);
        setSize(1600, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        this.setResizable(false); 

        initJMenu();
        addJMenu();
        addJMenuListener();
        setVisible(true);
    }

    void initJMenu(){

        myJMenuBar = new JMenuBar();
        myJMenu = new JMenu("菜单");
        menuFont = new Font("黑体", Font.BOLD, 18);  
        menuFontColor = new Color(0x00,0x14,0x2f);
    }

    void addJMenu() {

        for (int i = 0; i < myJMenuItem.length; i++){
            myJMenuItem[i].setFont(menuFont);
            myJMenu.add(myJMenuItem[i]);
        }
        myJMenu.setFont(menuFont);
        myJMenuBar.add(myJMenu);
        setJMenuBar(myJMenuBar);
    }

    void addJMenuListener(){
        
    }
}