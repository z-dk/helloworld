package design.builder;

/**
 * <b>类 名 称</b> :  ChickenBurger<br/>
 * <b>类 描 述</b> :  chicken<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/9/27 14:23<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/9/27 14:23<br/>
 * <b>修改备注</b> :
 */
public class ChickenBurger extends Burger{
    @Override
    public String name() {
        return "Chicken Burger";
    }
    
    @Override
    public float price() {
        return 50.5f;
    }
}
