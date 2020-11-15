package design.prototype;

import java.util.Hashtable;

/**
 * <b>类 名 称</b> :  ShapeCache<br/>
 * <b>类 描 述</b> :  shapeCache<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/9/27 16:03<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/9/27 16:03<br/>
 * <b>修改备注</b> :
 */
public class ShapeCache {
    
    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();
    
    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }
    
    // 对每种形状都运行数据库查询，并创建该形状
    // shapeMap.put(shapeKey, shape);
    // 例如，我们要添加三种形状
    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);
        
        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);
        
        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(),rectangle);
    }
    
}
