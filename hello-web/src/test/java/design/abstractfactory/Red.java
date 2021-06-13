package design.abstractfactory;

/**
 * <b>类 名 称</b> :  Red<br/>
 * <b>类 描 述</b> :  红色<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/9/27 10:32<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/9/27 10:32<br/>
 * <b>修改备注</b> :
 */
public class Red implements Color{
    @Override
    public void fill() {
        System.out.println("Red:fill method");
    }
}
