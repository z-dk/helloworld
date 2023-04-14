package dynamicproxy.jdk;

/**
 * <b>类 名 称</b> :  Main<br/>
 * <b>类 描 述</b> :  测试类<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/8 18:37<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/8 18:37<br/>
 * <b>修改备注</b> :
 */
public class Main {
    
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
    
        Subject subject = (Subject) new DynamicSubject().getProxy(realSubject);
        subject.request();
    }
    
}
