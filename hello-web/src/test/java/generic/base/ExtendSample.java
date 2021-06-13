package generic.base;

/**
 * <b>类 名 称</b> :  ExtendSample<br/>
 * <b>类 描 述</b> :  有上界的泛型类<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/2/28 20:48<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/2/28 20:48<br/>
 * <b>修改备注</b> :  <br/>
 *
 * @author zdk
 */
public class ExtendSample<T extends Parent> {
    
    T obj;
    
    <K extends Sub1> T extendMethod(K param) {
        return this.obj;
    }
    
    public static void main(String[] args) {
        //ExtendSample<? extends Number> sample5; 编译失败
    }
    
}
