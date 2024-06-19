import javax.swing.*;
import java.awt.*;

class ColoredRadioButton extends JRadioButton {

    ColoredRadioButton(String text) {
        super(text);
        setIcon(createCustomIcon(new Color(191, 191, 191))); // 未选中
        setSelectedIcon(createCustomIcon(new Color(0x47, 0x4b, 0x4f))); // 选中
    }

    Icon createCustomIcon(Color color) {
        return new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                g.setColor(color);
                g.fillRect(x, y, getIconWidth(), getIconHeight());
            }

            @Override
            public int getIconWidth() {
                return 10;
            }

            @Override
            public int getIconHeight() {
                return 10;
            }
        };
    }
}


class aColoredRadioButton extends JRadioButton {

    aColoredRadioButton(String text) {
        super(text);
        setIcon(createCustomIcon(new Color(191, 191, 191))); // 未选中
        setSelectedIcon(createCustomIcon(new Color(0x86, 0xc2, 0x32))); // 选中
    }

    Icon createCustomIcon(Color color) {
        return new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                g.setColor(color);
                g.fillRect(x, y, getIconWidth(), getIconHeight());
            }

            @Override
            public int getIconWidth() {
                return 10;
            }

            @Override
            public int getIconHeight() {
                return 10;
            }
        };
    }
}
