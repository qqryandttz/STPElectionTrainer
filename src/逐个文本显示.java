import javax.swing.*;  
import java.awt.event.*;  
import java.util.concurrent.atomic.AtomicInteger;  
  
public class 逐个文本显示 {  
    static boolean is逐个显示 = false;  
    static Timer 定时器;
  
    public static void 逐个文本显示器(final JLabel 剧情文字, final String 要显示的文本) {          
        if (!is逐个显示) {  
            is逐个显示 = true;   
                
            final AtomicInteger 当前索引 = new AtomicInteger(0);  
            定时器 = new Timer(50, new ActionListener() {  
                @Override  
                public void actionPerformed(ActionEvent e) { 
                    int index = 当前索引.getAndIncrement();                             
                    int 显示长度 = Math.min(index, 要显示的文本.length() - 6); 
                        if (显示长度 < 0) {  
                            显示长度 = 0;  
                        }  
                        
                        if (显示长度 >= 要显示的文本.length() - 6) {  
                            ((Timer) e.getSource()).stop();  
                            is逐个显示 = false;   
                        }  
                        
                        剧情文字.setText(要显示的文本.substring(0, 6 + 显示长度));  
                }
            });  
            定时器.start();  
              
        }  
    } 
    
    public static void 停止逐个显示() {  
        if (定时器 != null && is逐个显示) {  
            定时器.stop();  
            is逐个显示 = false;  
        }  
    }
  
    public static boolean 得到is逐个显示() {  
        return is逐个显示;  
    }  
}
