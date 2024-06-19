import javax.swing.*;
import java.awt.*;

class Line extends JPanel {

    public Line() {

        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(new Color(0x86, 0xc2, 0x32));
        g2d.drawLine(0, 450, getWidth(), 450);

    }

}
