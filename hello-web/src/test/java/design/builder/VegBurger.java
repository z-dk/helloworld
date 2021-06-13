package design.builder;

/**
 * <b>类 名 称</b> :  VegBurger<br/>
 * <b>类 描 述</b> :  verger<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/9/27 11:32<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/9/27 11:32<br/>
 * <b>修改备注</b> :
 */
public class VegBurger extends Burger{
    
    @Override
    public float price() {
        return 25.0f;
    }
    
    @Override
    public String name() {
        return "Veg Burger";
    }
}
