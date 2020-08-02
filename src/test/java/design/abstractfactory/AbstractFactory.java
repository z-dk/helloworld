package design.abstractfactory;

import design.factory.Shape;

/**
 * <b>类 名 称</b> :  AbstractFactory<br/>
 * <b>类 描 述</b> :  abstract<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/9/27 10:35<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/9/27 10:35<br/>
 * <b>修改备注</b> :
 */
public abstract class AbstractFactory {
    
    public abstract Color getColor(String color);
    
    public abstract Shape getShape(String shape);
}
