import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

class openfile {

    void inputFilePath(String FilePath) {

        File file = new File(FilePath);
        if (file.exists() && file.isFile()) {
            if (Desktop.isDesktopSupported()) {
                Desktop 桌面 = Desktop.getDesktop();
                try {
                    桌面.open(file);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("无法打开文件：" + FilePath);
                }
            } else {
                System.out.println("桌面环境不支持");
            }
        } else {
            System.out.println("文件不存在或不是一个文件：" + FilePath);
        }
    }
}