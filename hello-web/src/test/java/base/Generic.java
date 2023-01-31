package base;

/**
 * <b>类 名 称</b> :  Generic<br/>
 * <b>类 描 述</b> :  泛型测试<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2020/3/2 10:41<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2020/3/2 10:41<br/>
 * <b>修改备注</b> :
 */
public class Generic {
    public static void main(String[] args) {
        SuperSample<? extends Parent> sample1 = new SuperSample<Parent>();
        SuperSample<? super Sub1> sample3 = new SuperSample<Parent>();

        System.out.println(Parent.class.isAssignableFrom(Sub1.class));
        System.out.println(Sub1.class.isAssignableFrom(Parent.class));
        System.out.println(Sub1.class.isAssignableFrom(Sub2.class));
//        sample1.obj = new Parent();
//        sample3.obj = new Parent();
    }
}
