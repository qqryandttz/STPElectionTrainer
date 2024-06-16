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

class homePage extends JPanel{

    InterfaceExecution IE;
    JLayeredPane LP布局;
    JLabel title,subtitle;
    starrySkyPanel starrySkyPanel;
    diagonalPanel diagonal1, diagonal2;
    roundedButton 基础知识Button,选举规则Button,操作指南Button;  
    btnExample1 btnExample1;
    btnExample2 btnExample2;
    btnExample3 btnExample3;
    roundedButton Example1,Example2,Example3;
    Font titleFont,subtitleFont;
    Font buttonFont,btnActiveFont,graphbuttonFont,graphbtnActiveFont;
    Color titleFontColor,subtitleFontColor,buttonFontColor,ButtonBackColor, ButtonBorderColor;
    Color btnActiveFontColor, ButtonActiveBackColor;
    openfile openfile = new openfile();
    playStatus touchButtonSound, pressButtonSound;

    homePage(InterfaceExecution interfaceExecution){

        IE = interfaceExecution;
        LP布局 = new JLayeredPane();
        LP布局.setBounds(0, 0, 1600, 900);

        ADDstarrySkyPanel();
        ADDdiagonal();
        ADDtitle();
        ADDButton();
        ADDgraphButton();

        ADDButtonListener();
        ADDgraphButtonListener();

        this.setLayout(new BorderLayout());
        this.add(LP布局, BorderLayout.CENTER);

    }

    void ADDstarrySkyPanel(){

        starrySkyPanel = new starrySkyPanel();
        starrySkyPanel.setBounds(0,0,1600,900);
        LP布局.add(starrySkyPanel, new Integer(JLayeredPane.DEFAULT_LAYER));
    }

    void ADDdiagonal(){

        diagonal1 = new diagonalPanel();
        diagonal1.setBounds(40, 530, 350, 280);
        LP布局.add(diagonal1, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
        
        diagonal2 = new diagonalPanel();
        diagonal2.setBounds(540, 430, 400, 320);
        LP布局.add(diagonal2, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
    }

    void ADDtitle(){

        title = new JLabel("STP选举流程");
        title.setBounds(100,75,712,225);
        titleFont = new Font("黑体", Font.PLAIN , 120);  
        title.setFont(titleFont);  
        LP布局.add(title, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
        titleFontColor = new Color(0xf5, 0xf5, 0xf5);  
        title.setForeground(titleFontColor);

        subtitle = new JLabel(
                "<html>\t\t本教程旨在帮助网络工程学习者深入理解STP（生成树协议）的选举规则。为确保您能够顺利完成练习，我们建议您先熟悉计算机网络、STP协议和RS配置的基础知识。完成理论知识学习后，您可以从主页的三个拓扑图中选择一个开始练习。</html>");
        subtitleFont = new Font("黑体", Font.PLAIN, 18);
        subtitle.setFont(subtitleFont);
        LP布局.add(subtitle, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
        subtitle.setBounds(65, 220, 787, 187);
        subtitleFontColor = new Color(0x6b, 0x6e, 0x70);
        subtitle.setForeground(subtitleFontColor);
        
    }

    void ADDButton(){

        基础知识Button = new roundedButton("基础知识", 50);
        选举规则Button = new roundedButton("选举规则", 50);
        操作指南Button = new roundedButton("操作指南", 50);

        ButtonBorderColor = new Color(0x86, 0xc2, 0x32);
        buttonFont = new Font("黑体", Font.BOLD, 30);
        btnActiveFont = new Font("黑体", Font.PLAIN, 27);
        
        ButtonBackColor = new Color(0x61,0x89,0x2f);
        buttonFontColor = new Color(0x22, 0x26, 0x29); 
        btnActiveFontColor = new Color(0xee, 0xee, 0xee); 
        ButtonActiveBackColor = new Color(0x86, 0xc2, 0x32);
        touchButtonSound = new playStatus("resources\\_200音乐\\触碰按钮声.mp3");
        pressButtonSound = new playStatus("resources\\_200音乐\\按下按钮声.mp3");
        
        基础知识Button.setFont(buttonFont);
        选举规则Button.setFont(buttonFont);
        操作指南Button.setFont(buttonFont);   
        
        基础知识Button.setBackground(ButtonBackColor);
        选举规则Button.setBackground(ButtonBackColor);
        操作指南Button.setBackground(ButtonBackColor);
        
        基础知识Button.setForeground(buttonFontColor);
        选举规则Button.setForeground(buttonFontColor);
        操作指南Button.setForeground(buttonFontColor);

        LP布局.add(基础知识Button, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
        LP布局.add(选举规则Button, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
        LP布局.add(操作指南Button, new Integer(JLayeredPane.DEFAULT_LAYER + 1));

        基础知识Button.setBounds(125, 432, 320, 80);
        选举规则Button.setBounds(290, 575, 320, 80);
        操作指南Button.setBounds(455, 717, 320, 80);

    }

    void ADDgraphButton(){

        btnExample1 = new btnExample1(30);
        btnExample2 = new btnExample2(30);
        btnExample3 = new btnExample3(30);

        Example1 = new roundedButton("示例1", 30);
        Example2 = new roundedButton("示例2", 30);
        Example3 = new roundedButton("示例3", 30);

        graphbuttonFont = new Font("黑体", Font.BOLD, 37);
        graphbtnActiveFont = new Font("黑体", Font.PLAIN, 27);
        
        Example1.setFont(buttonFont);
        Example2.setFont(buttonFont);
        Example3.setFont(buttonFont);   
        
        Example1.setBackground(ButtonBackColor);
        Example2.setBackground(ButtonBackColor);
        Example3.setBackground(ButtonBackColor);
        
        Example1.setForeground(buttonFontColor);
        Example2.setForeground(buttonFontColor);
        Example3.setForeground(buttonFontColor); 

        LP布局.add(Example1, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
        LP布局.add(Example2, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
        LP布局.add(Example3, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
        
        Example1.setBounds(1012, 35, 500, 250);
        Example2.setBounds(1012, 305, 500, 250);
        Example3.setBounds(1012, 580, 500, 250);

        btnExample1.setBounds(1012, 35, 500, 250);
        btnExample2.setBounds(1012, 305, 500, 250);
        btnExample3.setBounds(1012, 580, 500, 250);
        
    }

    void ADDButtonListener(){

        基础知识Button.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {

                openfile.inputFilePath("resources\\_100文档\\基础知识.txt");
                pressButtonSound.playMusicOnce();
                IE.isToggle = 2;
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>已为您打开文件!</font></html>",
                        "提示", JOptionPane.INFORMATION_MESSAGE);
            }  
        }); 

        基础知识Button.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e){

                touchButtonSound.playMusicOnce();
                基础知识Button.setForeground(btnActiveFontColor);
                基础知识Button.setBackground(ButtonActiveBackColor);
            }

            @Override  
            public void mouseExited(MouseEvent e) {  
                基础知识Button.setFont(buttonFont);
                基础知识Button.setForeground(buttonFontColor);
                基础知识Button.setBackground(ButtonBackColor);
            }  
        });


        //
        选举规则Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                openfile.inputFilePath("resources\\_100文档\\选举规则.txt");
                pressButtonSound.playMusicOnce();
                IE.isToggle = 2;
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>已为您打开文件!</font></html>",
                        "提示", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        选举规则Button.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                touchButtonSound.playMusicOnce();
                选举规则Button.setForeground(btnActiveFontColor);
                选举规则Button.setBackground(ButtonActiveBackColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                选举规则Button.setFont(buttonFont);
                选举规则Button.setForeground(buttonFontColor);
                选举规则Button.setBackground(ButtonBackColor);
            }
        });


        //
        操作指南Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                openfile.inputFilePath("resources\\_100文档\\操作指南.txt");
                pressButtonSound.playMusicOnce();
                IE.isToggle = 2;
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>已为您打开文件!</font></html>",
                        "提示", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        操作指南Button.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                touchButtonSound.playMusicOnce();
                操作指南Button.setForeground(btnActiveFontColor);
                操作指南Button.setBackground(ButtonActiveBackColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                操作指南Button.setFont(buttonFont);
                操作指南Button.setForeground(buttonFontColor);
                操作指南Button.setBackground(ButtonBackColor);
            }
        });

    }
  
    void ADDgraphButtonListener(){

        //
        Example1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                touchButtonSound.playMusicOnce();
                LP布局.remove(Example1);
                LP布局.add(btnExample1, new Integer(JLayeredPane.DEFAULT_LAYER+1));
                resetPage();
            }

        });

        btnExample1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                pressButtonSound.playMusicOnce();
                if(IE.isToggle == 1){


                    int option = JOptionPane.showOptionDialog(
                            null, 
                            "<html><font face='黑体' size='5'>您确定要进入一个新的拓扑图吗？</font></html>",
                            "提示",
                            JOptionPane.YES_NO_OPTION, 
                            JOptionPane.INFORMATION_MESSAGE, 
                            null, 
                            new String[] { "确定", "取消" }, 
                            "确定"
                    );

                    if (option == JOptionPane.YES_OPTION) {
                        
                        IE.isToggle = 2;
                        IE.goToOperationInterface(1);
                    } else if (option == JOptionPane.NO_OPTION) {
                       
                    }

                }else{
                    IE.isToggle = 2;
                    IE.goToOperationInterface(1);
                }
            }
            
        });

        btnExample1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {

                LP布局.remove(btnExample1);
                LP布局.add(Example1, new Integer(JLayeredPane.DEFAULT_LAYER+1));
                resetPage();
            }
        });


        //
        Example2.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                touchButtonSound.playMusicOnce();
                LP布局.remove(Example2);
                LP布局.add(btnExample2, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
                resetPage();
            }

        });

        btnExample2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                pressButtonSound.playMusicOnce();
                IE.isToggle = 2;
                IE.goToOperationInterface(2);
            }
            

        });

        btnExample2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {

                LP布局.remove(btnExample2);
                LP布局.add(Example2, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
                resetPage();
            }
        });



        //
        Example3.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                touchButtonSound.playMusicOnce();
                LP布局.remove(Example3);
                LP布局.add(btnExample3, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
                resetPage();
            }

        });

        btnExample3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                pressButtonSound.playMusicOnce();
                IE.isToggle = 2;
                IE.goToOperationInterface(3);
            }
            

        });

        btnExample3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {

                LP布局.remove(btnExample3);
                LP布局.add(Example3, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
                resetPage();
            }
        });

        

    } 

    void resetPage() {
        revalidate();
        repaint();
    }

}