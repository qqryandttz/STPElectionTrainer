import javax.swing.*;
import java.awt.*;

class diagonalPanel extends JPanel {

    private static final int LINE_WIDTH = 5;

    public diagonalPanel() {

        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(LINE_WIDTH));
        g2d.setColor(new Color(0x86, 0xc2, 0x32));
        int 起始X = 0;
        int 起始Y = 0;
        int 结束X = getWidth() - 1;
        int 结束Y = getHeight() - 1;
        g2d.drawLine(起始X, 起始Y, 结束X, 结束Y);
    }

}