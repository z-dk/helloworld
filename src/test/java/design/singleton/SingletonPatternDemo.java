package design.singleton;

/**
 * <b>类 名 称</b> :  SingletonPatternDemo<br/>
 * <b>类 描 述</b> :  单例模式<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/9/27 10:50<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/9/27 10:50<br/>
 * <b>修改备注</b> :
 */
public class SingletonPatternDemo {
    public static void main(String[] args) {
        
        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //SingleObject object = new SingleObject();
        
        //获取唯一可用的对象
        SingleObject object = SingleObject.getInstance();
        
        //显示消息
        object.showMessage();
    }
}
