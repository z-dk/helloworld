package design.abstractfactory;

/**
 * <b>类 名 称</b> :  Blue<br/>
 * <b>类 描 述</b> :  blue<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/9/27 10:34<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/9/27 10:34<br/>
 * <b>修改备注</b> :
 */
public class Blue implements Color{
    @Override
    public void fill() {
        System.out.println("blue:fill method");
    }
}
