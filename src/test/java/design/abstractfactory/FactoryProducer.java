package design.abstractfactory;

/**
 * <b>类 名 称</b> :  FactoryProducer<br/>
 * <b>类 描 述</b> :  factoryproducer<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/9/27 10:41<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/9/27 10:41<br/>
 * <b>修改备注</b> :
 */
public class FactoryProducer {
    
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
