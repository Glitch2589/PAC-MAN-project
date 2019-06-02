/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author TripleB
 */
public class Sound {
    
    private Clip clip;
    
    public Sound(File path){// chỉ bcan62 biết sử dụng lớp này , dùng cái constructor này thì truyền vào đường dẫn để lấy file thì tạo ra 1 đối tượng soundplayer thi chi can dung phuong thuc play va stop de gii phong no
        try{
            AudioInputStream ais;
            ais = AudioSystem.getAudioInputStream(path);// lay file ne
            AudioFormat baseFormat = ais.getFormat();// format lai theo cai chuan cua no
            AudioFormat decodeFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(),
                    baseFormat.getChannels()*2,
                    baseFormat.getSampleRate(),
                    false
            );
            AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
            clip = AudioSystem.getClip();//su dung cai clip de ghep clip de bao vùng âm thanh đó lại 
            clip.open(dais);
        }catch(Exception e){}
    }
    public void play(){
        if(clip !=null){
            stop();
            clip.setFramePosition(0);
            clip.start();
        }
    }
    public void stop(){
        if(clip.isRunning()) clip.stop();
    }
    
    public void close(){
        clip.close();
    }
}
