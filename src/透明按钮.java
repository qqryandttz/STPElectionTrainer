import javax.swing.*;  
import java.awt.*;  
  
public class 透明按钮 extends JButton {  
  
    private static final Color 半透明白色 = new Color(255, 255, 255, 240);  
  
    public 透明按钮() {  
        
        setContentAreaFilled(false); // 禁止默认的背景绘制  
        setOpaque(false); // 设置为非不透明，但这对JButton可能没有直接影响  
    }  
  
    @Override  
    protected void paintComponent(Graphics g) {  
        super.paintComponent(g); // 调用父类的paintComponent来绘制文本和图标  
  
        Graphics2D g2d = (Graphics2D) g.create();  
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); // 设置透明度  
        g2d.setColor(半透明白色);  
        g2d.fillRect(0, 0, getWidth(), getHeight()); // 绘制半透明的背景  
        g2d.dispose();  
    }  
  
}