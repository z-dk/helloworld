package design.singleton;

/**
 * <b>类 名 称</b> :  SingleObject<br/>
 * <b>类 描 述</b> :  single<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/9/27 10:48<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/9/27 10:48<br/>
 * <b>修改备注</b> :
 */
public class SingleObject {
    
    //创建 SingleObject 的一个对象
    private static SingleObject instance;
    
    //让构造函数为 private，这样该类就不会被实例化
    private SingleObject(){}
    
    //获取唯一可用的对象
    public static synchronized SingleObject getInstance(){
        if (instance == null) {
            instance = new SingleObject();
        }
        return instance;
    }
    
    public void showMessage(){
        System.out.println("Hello World!");
    }
    /*
    双重校验锁
    这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
    https://www.runoob.com/design-pattern/singleton-pattern.html
    更多实现方式如上链接
    public class Singleton {  
        private volatile static Singleton singleton;  
        private Singleton (){}  
        public static Singleton getSingleton() {  
            if (singleton == null) {  
                synchronized (Singleton.class) {  
                    if (singleton == null) {  
                        singleton = new Singleton();  
                    }  
                }  
            }  
            return singleton;  
        }  
    }
     */
}
