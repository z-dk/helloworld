package design.prototype;

/**
 * <b>类 名 称</b> :  prototypePattrenDemo<br/>
 * <b>类 描 述</b> :  原型模式<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/9/27 16:06<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/9/27 16:06<br/>
 * <b>修改备注</b> :
 */
public class prototypePattrenDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();
        
        Shape clonedShape = ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());
        
        Shape clonedShape2 = ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());
        
        Shape clonedShape3 = ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());
    }
}
