package dynamicproxy.jdk;

/**
 * <b>类 名 称</b> :  RealSubject<br/>
 * <b>类 描 述</b> :  真实对象<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/8 18:31<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/8 18:31<br/>
 * <b>修改备注</b> :
 */
public class RealSubject implements Subject {
    
    @Override
    public void request() {
        System.out.println("这里是real对象");
    }

    public void request(String name) {
        System.out.println("这里是real对象的子方法，参数为：" + name);
    }

}
