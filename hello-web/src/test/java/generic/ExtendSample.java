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
public class ExtendSample<T extends Parent> {
    
    T obj;
    
    <K extends Sub1> T extendMethod(K param) {
        return this.obj;
    }
}

class Generic {
    public static void main(String[] args) {
        // 泛型上界
        ExtendSample<Parent> sample1 = new ExtendSample<>();
        ExtendSample<Sub1> sample2 = new ExtendSample<Sub1>();
        ExtendSample<? extends Parent> sample3 = new ExtendSample<Sub1>();
        ExtendSample<? extends Sub1> sample4;

        // 编译错误
        // Required type: ExtendSample<? extends Sub1>
        // Provided: ExtendSample<Sub2>
        //sample4 = new ExtendSample<Sub2>();

        // 编译错误:声明的范围不在ExtendSample定义指定的范围内
        // Type parameter '? extends Number' is not within its bound; should extend 'generic.Parent'
        //ExtendSample<? extends Number> sample5;
        sample1.obj = new Sub1();
        
        // 编译错误:上界泛型只能读,不能写
        // Required type: capture of ? extends Parent
        // Provided: Parent
        //sample3.obj = new Parent();
        // 编译通过,只能使用声明的上界类或其父类读出数据
        Parent obj = sample3.obj;
        //Sub1 obj41 = sample4.obj;
        //Parent obj4 = sample4.obj;
    }
}
