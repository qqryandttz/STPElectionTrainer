import javax.swing.*;  
import java.awt.*;  
  
public class 示例1按钮 extends JButton {  
  
    private static final int RECT_WIDTH = 300;  
    private static final int RECT_HEIGHT = 150;  
    private static final int LINE_WIDTH = 5;
  
    @Override  
    protected void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        Graphics2D g2d = (Graphics2D) g;  

        setBackground(new Color(0x47, 0x4b, 0x4f));
   
        int panelWidth = getWidth();  
        int panelHeight = getHeight();  
  
        int x = (panelWidth - RECT_WIDTH) / 2;  
        int y = (panelHeight - RECT_HEIGHT) / 2;  
  
        g2d.setStroke(new BasicStroke(LINE_WIDTH));
        g.setColor(new Color(0x86, 0xc2, 0x32));  
        g2d.drawRect(x, y, RECT_WIDTH, RECT_HEIGHT);  
   
        g2d.setColor(new Color(0x86, 0xc2, 0x32));  
        g2d.fillOval(x - 5, y - 5, 15, 15); // 左上角  
        g2d.fillOval(x + RECT_WIDTH - 5, y - 5, 15, 15); // 右上角  
        g2d.fillOval(x - 5, y + RECT_HEIGHT - 5, 15, 15); // 左下角  
        g2d.fillOval(x + RECT_WIDTH - 5, y + RECT_HEIGHT - 5, 15, 15); // 右下角  
    }  
  
}