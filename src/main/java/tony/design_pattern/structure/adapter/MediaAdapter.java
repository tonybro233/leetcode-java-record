package tony.design_pattern.structure.adapter;

/**
 * 播放器接口适配器
 */
public class MediaAdapter implements MediaPlayer {

    @Override
    public void play(String fileName) {
        if(fileName.endsWith(".vlc")){
            new VlcPlayer().playVlc(fileName);
        }else if(fileName.endsWith(".mp4")){
            new Mp4Player().playMp4(fileName);
        }
    }
}
