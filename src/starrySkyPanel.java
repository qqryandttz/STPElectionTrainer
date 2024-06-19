import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class starrySkyPanel extends JPanel {

    private static final int PANEL_WIDTH = 1600;
    private static final int PANEL_HEIGHT = 900;
    private int maxStars = 1000;
    private double normalSpeed = 1.04d;
    private double fastSpeed = 10.04d;
    private double currentSpeed = normalSpeed;
    private long fastMoveStartTime = 0;

    private int[][] starPositions = new int[maxStars][2];
    private Color[] starColors = new Color[maxStars];
    private Random random = new Random();

    public starrySkyPanel() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(new Color(0x22, 0x26, 0x29));

        initializeStars();
        new Timer(10, e -> {
            moveStars();
            repaint();

            if (currentSpeed == fastSpeed && System.currentTimeMillis() - fastMoveStartTime > 1500) {
                currentSpeed = normalSpeed;
            }
        }).start();
    }

    private void initializeStars() {
        for (int i = 0; i < maxStars; i++) {
            starPositions[i][0] = random.nextInt(PANEL_WIDTH);
            starPositions[i][1] = random.nextInt(PANEL_HEIGHT);

            int brightness = random.nextInt(256);
            starColors[i] = new Color(brightness, brightness, brightness);
        }
    }

    private void moveStars() {
        for (int i = 0; i < maxStars; i++) {
            starPositions[i][0] += (int) (currentSpeed * random.nextDouble());
            if (starPositions[i][0] > PANEL_WIDTH) {
                starPositions[i][0] = 0;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < maxStars; i++) {
            g2d.setColor(starColors[i]);
            g2d.fillOval(starPositions[i][0], starPositions[i][1], 2, 2);
        }
    }

    // 启动快速移动
    public void startFastMove() {
        if (currentSpeed == normalSpeed) {
            currentSpeed = fastSpeed;
            fastMoveStartTime = System.currentTimeMillis();
        }
    }
    
}