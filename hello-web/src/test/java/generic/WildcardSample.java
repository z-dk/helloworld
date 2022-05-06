package generic;

class Parent {}
class Sub1 extends Parent {}
class Sub2 extends Parent {}
/**
 * <b>类 名 称</b> :  WildcardSample<br/>
 * <b>类 描 述</b> :  泛型示例<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2022/5/6 16:31<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2022/5/6 16:31<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class WildcardSample<T> {
    
    T obj;
    void test() {
        WildcardSample<Parent> sample1 = new WildcardSample<>();
        // 编译错误
        // Required type: WildcardSample<Parent>
        // Provided: WildcardSample<Sub1>
        //WildcardSample<Parent> sample2 = new WildcardSample<Sub1>();
        
        WildcardSample<?> sample3 = new WildcardSample<Parent>();
        WildcardSample<?> sample4 = new WildcardSample<Sub1>();
        WildcardSample<?> sample5 = new WildcardSample<Sub2>();
        
        sample1.obj = new Sub1();
        // 编译错误:
        // Required type: capture of ?
        // Provided: Sub1
        //sample3.obj = new Sub1();
    }
    
}
