package design.adapter;

/**
 * <b>类 名 称</b> :  MediaAdapter<br/>
 * <b>类 描 述</b> :  adapter<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/9/27 16:34<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/9/27 16:34<br/>
 * <b>修改备注</b> :
 */
public class MediaAdapter implements MediaPlayer{
    
    AdvancedMediaPlayer advancedMusicPlayer;
    
    public MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vlc") ){
            advancedMusicPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer = new Mp4Player();
        }
    }
    
    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMusicPlayer.playVlc(fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}
