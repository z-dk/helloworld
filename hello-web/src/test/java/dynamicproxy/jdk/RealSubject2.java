package dynamicproxy.jdk;

/**
 * <b>类 名 称</b> :  RealSubject2<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/5/9 20:24<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/5/9 20:24<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class RealSubject2 implements Subject{
    @Override
    public void request() {
        System.out.println("这里是2号实现！");
    }
}
