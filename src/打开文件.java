import java.awt.Desktop;  
import java.io.File;  
import java.io.IOException;  
  
class 打开文件 {  

    
    void 输入文件地址(String 文件路径){

        File 文件 = new File(文件路径);
        if (文件.exists() && 文件.isFile()) {
            if (Desktop.isDesktopSupported()) {
                Desktop 桌面 = Desktop.getDesktop();
                try {
                    桌面.open(文件);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("无法打开文件：" + 文件路径);
                }
            } else {
                System.out.println("桌面环境不支持");
            }
        } else {
            System.out.println("文件不存在或不是一个文件：" + 文件路径);
        }
    }
}