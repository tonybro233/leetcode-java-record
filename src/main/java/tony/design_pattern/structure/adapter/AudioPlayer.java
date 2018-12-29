package tony.design_pattern.structure.adapter;

public class AudioPlayer implements MediaPlayer {
    @Override
    public void play(String fileName) {

        if(fileName.endsWith(".mp3")){
            //播放 mp3 音乐文件的内置支持
            System.out.println("Playing mp3 file. Name: "+ fileName);
        } else{
            //mediaAdapter 提供了播放其他文件格式的支持
            new MediaAdapter().play(fileName);
        }
    }
}
