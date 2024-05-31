package 代码参考;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;  
class 文件读取 {  
  
    private String 文件路径;
    private FileInputStream 文件输入流;
    private BufferedReader 缓冲输入流; 
  
    文件读取(String s) {  
        this.文件路径 = s;  
        try {  
            文件输入流 = new FileInputStream(文件路径);  
            InputStreamReader 输入流读取器 = new InputStreamReader(文件输入流, "UTF-8");  
            缓冲输入流 = new BufferedReader(输入流读取器);  
        } catch (IOException e) {  
            e.printStackTrace();  
            JOptionPane.showMessageDialog(null, "未能获取到有效文件！(请联系我)", "警告", JOptionPane.INFORMATION_MESSAGE);  
        }  
    }  
    
    String 读取一行()  { 
        String 当前行;  
        try {  
            当前行 = 缓冲输入流.readLine(); 
            return 当前行;  
        } catch (IOException e) {  
            e.printStackTrace();    
            return null;  
        }  
    }  
    String 读取非空白行() {
        String 行;
        if((行 = this.读取一行()) != null) { 
            if (!行.trim().isEmpty()) 
                return 行;
            else
                return this.读取一行();
        } 
        return null;
    }
    
    void 读取到选择语段(String 选项,处理语句 处理语句){
        int i=0;
        while(!选项.equals(this.读取非空白行())){
            i++;
            if(i==30){
                System.out.println("排版出错!");
                break;
            }
        }
        处理语句.进行分析();
    }
    void 跳过剩余分支(String 选项){
        int i= 0;
        if(选项 == "A" || 选项 == "B")
            while(!"￥".equals(this.读取非空白行())){
                i++;
                if(i==30){
                System.out.println("排版出错!");
                break;
                }
            }
    }
    void 关闭(){  
        if (缓冲输入流 != null) {  
            try {
                缓冲输入流.close(); 
            } catch (IOException e) {
                e.printStackTrace();
            }  
        }  
    }  
}  