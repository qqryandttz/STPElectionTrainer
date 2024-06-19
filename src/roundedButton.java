import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

class roundedButton extends JButton {

    private int 圆角直径;

    public roundedButton(String 文本, int 圆角直径) {
        super(文本);
        this.圆角直径 = 圆角直径;
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusable(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Shape 圆角矩形 = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 圆角直径, 圆角直径);
        g2d.setColor(getBackground());
        g2d.fill(圆角矩形);

        super.paintComponent(g2d);
    }
}
