package design.adapter;

/**
 * <b>类 名 称</b> :  AdvancedMediaPlayer<br/>
 * <b>类 描 述</b> :  advance<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/9/27 16:31<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/9/27 16:31<br/>
 * <b>修改备注</b> :
 */
public interface AdvancedMediaPlayer {
    public void playVlc(String fileName);
    public void playMp4(String fileName);
}
