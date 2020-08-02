package design.abstractfactory;

import design.factory.Shape;

/**
 * <b>类 名 称</b> :  ColorFactory<br/>
 * <b>类 描 述</b> :  colorfactory<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/9/27 10:39<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/9/27 10:39<br/>
 * <b>修改备注</b> :
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }
    
    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
