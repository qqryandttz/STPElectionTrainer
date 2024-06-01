import javax.swing.*;  
import java.awt.*;  
  
public class SquarePanel extends JPanel {  
  
    private int squareSize = 100; // 正方形的边长  
  
    @Override  
    protected void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        Graphics2D g2d = (Graphics2D) g;  
  
        // 设置正方形的颜色  
        g2d.setColor(Color.BLACK); // 假设正方形边框是黑色的  
  
        // 绘制正方形  
        g2d.drawRect(50, 50, squareSize, squareSize); // (x, y, width, height)  
  
        // 设置顶点颜色为红色  
        g2d.setColor(Color.RED);  
  
        // 绘制正方形的四个顶点  
        int centerX = 50 + squareSize / 2;  
        int centerY = 50 + squareSize / 2;  
  
        // 左上角  
        g2d.fillRect(50, 50, 5, 5);  
        // 右上角  
        g2d.fillRect(centerX + 5, 50, 5, 5);  
        // 左下角  
        g2d.fillRect(50, centerY + 5, 5, 5);  
        // 右下角  
        g2d.fillRect(centerX + 5, centerY + 5, 5, 5);  
    }  
  
    public static void main(String[] args) {  
        JFrame frame = new JFrame("Square with Red Vertices");  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setSize(300, 300);  
        frame.add(new SquarePanel());  
        frame.setVisible(true);  
    }  
}