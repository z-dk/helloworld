package design.builder;

/**
 * <b>类 名 称</b> :  Pepsi<br/>
 * <b>类 描 述</b> :  Pepsi<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/9/27 14:27<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/9/27 14:27<br/>
 * <b>修改备注</b> :
 */
public class Pepsi extends ColdDrink{
    @Override
    public String name() {
        return "Pepsi";
    }
    
    @Override
    public float price() {
        return 35.0f;
    }
}
