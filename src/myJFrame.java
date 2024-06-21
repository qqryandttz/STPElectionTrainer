import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Frame;

class myJFrame extends JFrame{

    InterfaceExecution IE;
    JMenuBar myJMenuBar;
    JMenu myJMenu;
    JMenuItem[] myJMenuItem;
    Font menuFont;
    Color menuFontColor;
    openfile openfile = new openfile();
    MusicPlayer touchButtonSound, pressButtonSound;

    myJFrame(InterfaceExecution interfaceExecution,String Name) {

        IE = interfaceExecution;
        setTitle(Name);
        setSize(1600, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        this.setResizable(false);

        setVisible(true);
    }
    
    public myJFrame(InterfaceExecution interfaceExecution,String Name, JMenuItem[] menuItems){

        IE = interfaceExecution;
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
        touchButtonSound = new MusicPlayer("resources\\_200音乐\\触碰按钮声.mp3");
        pressButtonSound = new MusicPlayer("resources\\_200音乐\\按下按钮声.mp3");
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

        myJMenuItem[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                openfile.inputFilePath("resources\\_100文档\\基础知识.txt");
                pressButtonSound.playMusicOnce();
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>已为您打开文件!</font></html>",
                        "提示", JOptionPane.INFORMATION_MESSAGE);            }
        });

        myJMenuItem[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                openfile.inputFilePath("resources\\_100文档\\选举规则.txt");
                pressButtonSound.playMusicOnce();
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>已为您打开文件!</font></html>",
                        "提示", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        myJMenuItem[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                openfile.inputFilePath("resources\\_100文档\\操作指南.txt");
                pressButtonSound.playMusicOnce();
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>已为您打开文件!</font></html>",
                        "提示", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        myJMenuItem[4].addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) { 

                if(IE.isToggle == 0){

                    JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>请先进入一个拓扑图！</font></html>",
                            "提示", JOptionPane.INFORMATION_MESSAGE);

                }else if(IE.isToggle == 1){

                    IE.goToOperationInterface();
                    IE.isToggle = 2;

                } else if (IE.isToggle == 2) {

                    JOptionPane.showMessageDialog(new Frame(),
                            "<html><font face='黑体' size='5'>已为您存档，再次点击切换可返回拓扑图。</font></html>",
                            "提示", JOptionPane.INFORMATION_MESSAGE);
                    IE.goToHomePage();
                    IE.isToggle = 1;

                }
            }  
        });
        
    }
}