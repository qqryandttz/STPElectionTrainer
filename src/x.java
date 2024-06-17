import javax.swing.*;

public class x {

    public static void main(String[] args) {
        // 创建一个JFrame作为顶层容器
        JFrame frame = new JFrame("Scrollable Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200); // 设置窗口大小

        // 创建一个面板，并添加一些组件以使其内容超出面板大小
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // 使用垂直BoxLayout
        for (int i = 0; i < 20; i++) {
            panel.add(new JLabel("Label " + (i + 1)));
            panel.add(Box.createVerticalStrut(10)); // 添加一些垂直间距
        }

        // 创建一个JScrollPane，并将面板添加到其中
        JScrollPane scrollPane = new JScrollPane(panel);

        // 将滚动面板添加到JFrame中
        frame.add(scrollPane);

        // 显示窗口
        frame.setVisible(true);
    }
}