import javax.swing.*;  
import java.awt.*;
import java.awt.geom.RoundRectangle2D;  
  
class btnExample1 extends JButton {  
  
    private static final int RECT_WIDTH = 310;  
    private static final int RECT_HEIGHT = 155;  
    private static final int LINE_WIDTH = 5;
    private int filletRadius;

    btnExample1( int filletRadius) {  
        this.filletRadius = filletRadius;  
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
  
    @Override  
    protected void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        Graphics2D g2d = (Graphics2D) g;  

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape RoundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, filletRadius, filletRadius);
        g2d.setColor(getBackground());
        g2d.fill(RoundedRectangle);
        super.paintComponent(g2d);

        setBackground(new Color(0x86, 0xc2, 0x32));
   
        int panelWidth = getWidth();  
        int panelHeight = getHeight();  
  
        int x = (panelWidth - RECT_WIDTH) / 2;  
        int y = (panelHeight - RECT_HEIGHT) / 2;  
  
        g2d.setStroke(new BasicStroke(LINE_WIDTH));
        g.setColor(new Color(0xf5, 0xf5, 0xf5));  
        g2d.drawRect(x, y, RECT_WIDTH, RECT_HEIGHT);  
   
        g2d.setColor(new Color(0x47, 0x4b, 0x4f));  
        g2d.fillOval(x - 10, y - 10, 20, 20);   
        g2d.fillOval(x + RECT_WIDTH - 10, y - 10, 20, 20); // 右上  
        g2d.fillOval(x - 10, y + RECT_HEIGHT - 10, 20, 20); // 左下  
        g2d.fillOval(x + RECT_WIDTH - 10, y + RECT_HEIGHT - 10, 20, 20); // 右下  
    }  
  
}




class btnExample2 extends JButton {

    private static final int RECT_WIDTH = 310;
    private static final int RECT_HEIGHT = 155;
    private static final int LINE_WIDTH = 5;
    private int filletRadius;

    public btnExample2(int filletRadius) {
        this.filletRadius = filletRadius;
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape RoundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, filletRadius, filletRadius);
        g2d.setColor(getBackground());
        g2d.fill(RoundedRectangle);
        super.paintComponent(g2d);

        setBackground(new Color(0x86, 0xc2, 0x32));

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int x = (panelWidth - RECT_WIDTH) / 2;
        int y = (panelHeight - RECT_HEIGHT) / 2;

        g2d.setStroke(new BasicStroke(LINE_WIDTH));
        g.setColor(new Color(0xf5, 0xf5, 0xf5));
        g2d.drawLine(x, y, x + 310, y + 155);
        g2d.drawLine(x, y, x + 310, y);
        g2d.drawLine(x, y, x , y + 155);
        g2d.drawLine(x + 310, y, x, y + 155);
        g2d.drawLine(x + 310, y, x + 310, y + 155);


        g2d.setColor(new Color(0x47, 0x4b, 0x4f));
        g2d.fillOval(x - 10, y - 10, 20, 20); 
        g2d.fillOval(x + RECT_WIDTH - 10, y - 10, 20, 20); // 右上
        g2d.fillOval(x - 10, y + RECT_HEIGHT - 10, 20, 20); // 左下
        g2d.fillOval(x + RECT_WIDTH - 10, y + RECT_HEIGHT - 10, 20, 20); // 右下
    }

}



class btnExample3 extends JButton {

    private static final int RECT_WIDTH = 310;
    private static final int RECT_HEIGHT = 155;
    private static final int LINE_WIDTH = 5;
    private int filletRadius;

    public btnExample3(int filletRadius) {
        this.filletRadius = filletRadius;
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape RoundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, filletRadius, filletRadius);
        g2d.setColor(getBackground());
        g2d.fill(RoundedRectangle);
        super.paintComponent(g2d);

        setBackground(new Color(0x86, 0xc2, 0x32));

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int x = (panelWidth - RECT_WIDTH) / 2;
        int y = (panelHeight - RECT_HEIGHT) / 2;

        g2d.setStroke(new BasicStroke(LINE_WIDTH));
        g.setColor(new Color(0xf5, 0xf5, 0xf5));
        g2d.drawLine(x, y - 10, x + 310, y + 80);
        g2d.drawLine(x, y - 10, x , y + 80);

        g2d.drawLine(x, y+80, x+310, y + 80);
        g2d.drawLine(x, y+80, x + 155, y + 170);

        g2d.drawLine(x + 310, y + 80, x + 310, y - 10);
        g2d.drawLine(x + 310, y + 80, x + 155, y + 170);

        g2d.setColor(new Color(0x47, 0x4b, 0x4f));
        g2d.fillOval(x - 10, y - 20, 20, 20); // 左上
        g2d.fillOval(x + RECT_WIDTH - 10, y - 20, 20, 20); // 右上

        g2d.fillOval(x - 10, y + 80 - 10, 20, 20); // 左下
        g2d.fillOval(x + RECT_WIDTH - 10, y + 80 - 10, 20, 20); // 右下
        g2d.fillOval(x + (RECT_WIDTH - 10)/2 - 5, y + 160, 20, 20); // 下
    }

}
