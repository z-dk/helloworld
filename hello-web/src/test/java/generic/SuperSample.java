package generic;

/**
 * <b>类 名 称</b> :  ExtendSample<br/>
 * <b>类 描 述</b> :  有界泛型<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/5/6 20:26<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/5/6 20:26<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class SuperSample<T> {
    T obj;
}

class GenericSuper {
    public static void main(String[] args) {
        // 泛型下界
        SuperSample<? super Parent> sample1 = new SuperSample<Parent>();
        // 编译错误:只能存放Parent或它的父类
        //SuperSample<? super Parent> sample2 = new SuperSample<Sub1>();
        SuperSample<? super Sub1> sample3 = new SuperSample<Parent>();
        
        sample1.obj = new Sub1();
        sample1.obj = new Sub2();
        sample1.obj = new Parent();
        
        sample3.obj = new Sub1();
        // 编译错误
        //sample3.obj = new Sub2();
        // 编译错误:下界泛型只能写入声明的下界类型或其子类
        //sample3.obj = new Parent();
        // 下界泛型只能写入,不能读,只能是Object类型接收数据
        Object obj = sample3.obj;
    }
}
