package dynamicproxy.cglib;

/**
 * <b>类 名 称</b> :  Main<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/11/8 20:05<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/11/8 20:05<br/>
 * <b>修改备注</b> :
 */
public class Main {
    
    public static void main(String[] args) {
        Library target = BuyBookCglib.getProxy();
        System.out.println(target.sellBook(5));
        System.out.println("***********************");
        System.out.println(target.buyBook(3));
        System.out.println("***********************");
        target.finalMethod();
        System.out.println("***********************");
        System.out.println(target);
        System.out.println("***********************");
        // 直接调用static方法也同样无法被代理
        //target.aboutMe();
    }
    
}
