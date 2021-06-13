package design.builder;

/**
 * <b>类 名 称</b> :  Coke<br/>
 * <b>类 描 述</b> :  Coke<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/9/27 14:24<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/9/27 14:24<br/>
 * <b>修改备注</b> :
 */
public class Coke extends ColdDrink{
    @Override
    public String name() {
        return "Coke";
    }
    
    @Override
    public float price() {
        return 30.0f;
    }
}
