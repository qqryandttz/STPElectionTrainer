import java.io.FileInputStream;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

class musicPlaybackThread extends Thread {

    AdvancedPlayer musicPlayer;
    volatile boolean isPauseMusic = false; 

    public musicPlaybackThread(String path) {
        try {
            musicPlayer = new AdvancedPlayer(new FileInputStream(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() { 
            synchronized (this) { 
                while (isPauseMusic) {
                    try {
                        this.wait(); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                musicPlayer.play(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        
    }

    public void pauseMusic() {
        synchronized (this) { 
            isPauseMusic = true;
            this.notifyAll();
        }
    }

    public void replayMusic() {
        synchronized (this) { 
            isPauseMusic = false;
            this.notifyAll(); 
        }
    }
}

class playStatus{

    String path;
    musicPlaybackThread loopMusicPlaybackThread;
    musicPlaybackThread onceMusicPlaybackThread;
    
    public playStatus(String path) {  
        this.path = path;  
    }  

    void playMusicOnce(){

        onceMusicPlaybackThread = new musicPlaybackThread(path);
        onceMusicPlaybackThread.start();
    }

    void playMusicOnLoop(){

        loopMusicPlaybackThread = new musicPlaybackThread(path);
        loopMusicPlaybackThread.start();
        loopMusicPlaybackThread.musicPlayer.setPlayBackListener(new PlaybackListener() {
            @Override
            public void playbackFinished(PlaybackEvent event) {
            playMusicOnLoop();
            }
        });
    }

    void stop(){
        if (loopMusicPlaybackThread != null) {
            loopMusicPlaybackThread.musicPlayer.stop();
            loopMusicPlaybackThread.musicPlayer.close();
            loopMusicPlaybackThread = null;
        }
    }

    void PauseMusic(){
        loopMusicPlaybackThread.pauseMusic();
    }

    void replayMusic(){
        loopMusicPlaybackThread.replayMusic();
    }

    

}
/* 
class x{
    public static void main(String[] args) {

        playStatus bgMusic;
        bgMusic = new playStatus("B:\\BaiduSyncdisk\\_2area\\_300学校\\大一下\\数据结构\\结课作业\\STPElectionTrainer\\resources\\_200音乐\\经年如夏.mp3");
        bgMusic.playMusicOnLoop();
        Scanner 接受 = new Scanner(System.in);
        while ("a".equals(接受.nextLine())){
            bgMusic.PauseMusic();
            break;
        }
        while ("b".equals(接受.nextLine())) {

            bgMusic.replayMusic();
            break;
        }
    }
}

  

*/