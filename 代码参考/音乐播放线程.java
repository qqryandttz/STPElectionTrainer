package 代码参考;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

public class 音乐播放线程 extends Thread { 

    AdvancedPlayer 音乐播放器;
    private volatile boolean is暂停 = false;
    
    
    public 音乐播放线程(String 文件路径) {  
        try {  
            音乐播放器 = new AdvancedPlayer(new FileInputStream(文件路径)); 
        } catch (JavaLayerException e) {  
            e.printStackTrace();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        }  
        
    }  
  
    @Override  
    public void run() {  
        if (!is暂停){
            try {  
                音乐播放器.play();  
            } catch (JavaLayerException e) {  
                e.printStackTrace();  
            }
        }else{
            try {  
                Thread.sleep(100); 
            } catch (InterruptedException ie) {  
                Thread.currentThread().interrupt();  
            }  
        }
    }  

    
    public void 暂停() {  
        is暂停 = true;  
        System.out.println("我暂停了!");
    }
  
     
    public void 重新播放() {  
        is暂停 = false;  
        System.out.println("我重新播放了!");
    }  
    

}

class 音乐播放{

    String 文件路径;
    音乐播放线程 循环音乐播放线程;
    音乐播放线程 音效播放线程;
    
    public 音乐播放(String 文件路径) {  
        this.文件路径 = 文件路径;  
    }  

    void 播放音效(){

        音效播放线程 = new 音乐播放线程(文件路径);
        音效播放线程.start();
    }

    void 播放循环音乐(){

        循环音乐播放线程 = new 音乐播放线程(文件路径);
        循环音乐播放线程.start();
        循环音乐播放线程.音乐播放器.setPlayBackListener(new PlaybackListener() {
            @Override
            public void playbackFinished(PlaybackEvent event) {
            播放循环音乐();
            }
        });
    }

    void 停止(){
        循环音乐播放线程.音乐播放器.close();
    }

}

  

