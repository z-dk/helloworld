package design.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * <b>类 名 称</b> :  ConsumerObserver<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/6/19 8:51<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/6/19 8:51<br/>
 * <b>修改备注</b> :
 */
public class JingDongObserver implements Observer {
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("JingDong："+o.toString()+"arg:"+arg.toString());
    }
}
