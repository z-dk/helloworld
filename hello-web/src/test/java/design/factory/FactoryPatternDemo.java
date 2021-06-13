package design.factory;

/**
 * <b>类 名 称</b> :  FactoryPatternDemo<br/>
 * <b>类 描 述</b> :  工厂模式<br/>
 * <b>创 建 人</b> :  朱登奎<br/>
 * <b>创建时间</b> :  2019/9/27 9:18<br/>
 * <b>修 改 人</b> :  朱登奎<br/>
 * <b>修改时间</b> :  2019/9/27 9:18<br/>
 * <b>修改备注</b> :
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        
        //获取 Circle 的对象，并调用它的 draw 方法
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        
        //调用 Circle 的 draw 方法
        shape1.draw();
        
        //获取 Rectangle 的对象，并调用它的 draw 方法
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        
        //调用 Rectangle 的 draw 方法
        shape2.draw();
        
        //获取 Square 的对象，并调用它的 draw 方法
        Shape shape3 = shapeFactory.getShape("SQUARE");
        
        //调用 Square 的 draw 方法
        shape3.draw();
    }
}
