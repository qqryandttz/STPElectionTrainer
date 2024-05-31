package 代码参考;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


import java.awt.*;


class 处理语句{

    String 当前行;
    String 上一节音乐;
    String[] 文本;
    boolean is处理选择 = false;
    初始化剧情页面 剧情页面;
    char[] 当前行数组;
    文件读取 文件读取器;
    boolean is跳过分析 = false;
    boolean is背景音乐 = false;

    处理语句(String 文件路径){
        this.文件读取器 = new 文件读取(文件路径);;
    }

    boolean 存档时的进行分析(){
        while(!"*******".equals(文件读取器.读取非空白行())){
            if("null".equals(文件读取器.读取非空白行())){
                return false;
            }
        }
        return true;
    }

    void 传递剧情页面(初始化剧情页面 页面){
        this.剧情页面 = 页面;
    }

    void 进行分析(){

        if(!剧情页面.is直接显示){
            当前行 = 文件读取器.读取非空白行();
            try{
                当前行数组 = 当前行.toCharArray();
            }catch(NullPointerException e){
                剧情页面.逻辑.主页.副标题.setText("<html>Happy birthday!  I hope your dreams are filled with candies and laughter. When you wake up, maybe we can go explore the wider world together.</html>");
                JOptionPane.showMessageDialog(null, "<html><font face='黑体' size='5'>完结撒花~生日快乐呀~</font></html>", "读取结束", JOptionPane.INFORMATION_MESSAGE);
                剧情页面.逻辑.切换到主页面();
                剧情页面.逻辑.is结束 = true;
            }

            System.out.println(当前行);

            if(剧情页面.is分支中){
                if(剧情页面.选项值.equals("A") && 当前行.equals("B")){
                    is跳过分析 = true;
                    文件读取器.跳过剩余分支("A");
                    剧情页面.is分支中 = false;
                    进行分析();
                }else if(剧情页面.选项值.equals("B") && 当前行.equals("C")){
                    is跳过分析 = true;
                    文件读取器.跳过剩余分支("B");
                    剧情页面.is分支中 = false;
                    进行分析();
                }else if(剧情页面.选项值.equals("C") && 当前行.equals("￥")){
                    is跳过分析 = true;
                    文件读取器.跳过剩余分支("C");
                    剧情页面.is分支中 = false;
                    进行分析();
                }
            }
        }

        if(is跳过分析 == true){}
        else{
        if(当前行数组[0] == '#'){      //处理普通段 \/

            if(!剧情页面.is直接显示){
                is处理选择 = false;
                剧情页面.对话按钮移除();
                剧情页面.移除选项按钮();
                文本 = 当前行.split("#");
                逐个文本显示.逐个文本显示器(剧情页面.剧情文字, "<html>"+ 文本[1] +"<html>");
            }else{
                剧情页面.剧情文字.setText("<html>"+ 文本[1] +"<html>");
                逐个文本显示.停止逐个显示();
            }

        }else if(当前行数组[0] == '@'){   //处理画面 \/

            is处理选择 = false;
            String[] 路径 = 当前行.split("@");
            //System.out.println(".\\resources\\_200图片\\"+ 路径[1] +".png");
            try{
                ImageIcon bgIcon = new ImageIcon(getClass().getResource(路径[1] +".png"));      
                剧情页面.背景图片 = bgIcon.getImage();  
            }catch(NullPointerException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>找不到图片，请联系我！</font></html>", "提示", JOptionPane.INFORMATION_MESSAGE);

            }
            剧情页面.语句处理器.进行分析();


        }else if(当前行数组[0] == '~'){

            is处理选择 = false;
        

            if(当前行数组[1] != '~'){   //处理音效\/

                String[] 路径 = 当前行.split("~");
                
                剧情页面.音效播放 = new 音乐播放(".\\resources\\_300音频\\音效\\"+ 路径[1] +".mp3");
                剧情页面.音效播放.播放音效();
                剧情页面.语句处理器.进行分析();


            }else{                     //处理背景音乐\/

                if(is背景音乐 == true){
                    剧情页面.背景音乐播放.停止();
                }
                String[] 路径 = 当前行.split("~~");
                剧情页面.语句处理器.进行分析();
                剧情页面.背景音乐播放 = new 音乐播放(".\\resources\\_300音频\\背景音乐\\"+ 路径[1] +".mp3");
                //上一节音乐 = ".\\resources\\_300音频\\背景音乐\\"+ 路径[1] +".mp3";
                剧情页面.背景音乐播放.播放循环音乐();
                is背景音乐 = true;
            }
        }else if(当前行数组[0] == '￥'){ //处理选择

            is处理选择 = true;
            文本 = 当前行.split("￥A|B|C");
            剧情页面.选项a按钮.setText("<html>"+ 文本[1] +"<html>");
            剧情页面.选项b按钮.setText("<html>"+ 文本[2] +"<html>");
            剧情页面.选项c按钮.setText("<html>"+ 文本[3] +"<html>");
            剧情页面.添加选项按钮();
            
        }/*else if(当前行数组[0] == '*'){ //处理叙述段落,先不做

            剧情页面.对话按钮移除();
            剧情页面.移除选项按钮();
        }*/else if(当前行.equals("A") || 当前行.equals("B") || 当前行.equals("C")|| 当前行.equals("￥")){ 
            System.out.println("不应该啊");
        }else{                           //处理对话\/
            if(!剧情页面.is直接显示){
                is处理选择 = false;
                剧情页面.移除选项按钮();
                剧情页面.对话按钮添加();
                文本 = 当前行.split("：");
                剧情页面.名字按钮.setText("<html>"+ 文本[0] +"<html>");
                逐个文本显示.逐个文本显示器(剧情页面.剧情文字, "<html>"+ 文本[1] +"<html>");
            }else{
                剧情页面.剧情文字.setText("<html>"+ 文本[1] +"<html>");
                逐个文本显示.停止逐个显示();
            }
        }}
        is跳过分析 = false;
    }


    void 选择分析(){
        String 得到选项 = 剧情页面.传递选项();
        文件读取器.读取到选择语段(得到选项,this);
    }

}
