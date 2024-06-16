import javax.swing.*;
import java.awt.*;
import java.util.Random; 
   
public class starrySkyPanel extends JPanel {  
  
    private static final int 面板宽度 = 1600;  
    private static final int 面板高度 = 900;  
    private static final int 星星最大数量 = 1000;  
    private static final double 移动速度 = 1.04d;  
  
    private int[][] 星星位置 = new int[星星最大数量][2];  
    private Color[] 星星颜色 = new Color[星星最大数量];  
    private Random 随机数生成器 = new Random();  
  
    public starrySkyPanel() {  
        setPreferredSize(new Dimension(面板宽度, 面板高度));  
        setBackground(new Color(0x22, 0x26, 0x29));  
  
        初始化星星();  
        new Timer(10, e -> { 
            移动星星();  
            repaint();  
        }).start();  
    }  
  
    private void 初始化星星() {  
        for (int i = 0; i < 星星最大数量; i++) {  
            星星位置[i][0] = 随机数生成器.nextInt(面板宽度);  
            星星位置[i][1] = 随机数生成器.nextInt(面板高度);  
  
            int 亮度 = 随机数生成器.nextInt(256);  
            星星颜色[i] = new Color(亮度, 亮度, 亮度);  
        }  
    }  
  
    private void 移动星星() {  
        for (int i = 0; i < 星星最大数量; i++) {  
            星星位置[i][0] += (int) (移动速度 * 随机数生成器.nextDouble());  
            if (星星位置[i][0] > 面板宽度) {  
                星星位置[i][0] = 0;  
            }  
        }  
    }  
  
    @Override  
    protected void paintComponent(Graphics g) {  
        super.paintComponent(g);  
  
        Graphics2D g2d = (Graphics2D) g;  
  
        for (int i = 0; i < 星星最大数量; i++) {  
            g2d.setColor(星星颜色[i]);  
            g2d.fillOval(星星位置[i][0], 星星位置[i][1], 2, 2);  
        }  
    }  
}