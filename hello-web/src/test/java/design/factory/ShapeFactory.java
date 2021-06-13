package design.factory;

/**
 * <b>类 名 称</b> :  ShapeFactory<br/>
 * <b>类 描 述</b> :  工厂<br/>
 * <b>创 建 人</b> :  朱登奎<br/>
 * <b>创建时间</b> :  2019/9/27 9:16<br/>
 * <b>修 改 人</b> :  朱登奎<br/>
 * <b>修改时间</b> :  2019/9/27 9:16<br/>
 * <b>修改备注</b> :
 */
class ShapeFactory {
    /**
     * 方法描述: 使用 getShape 方法获取形状类型的对象
     * <br/>
     * design.factory.Shape
     * <br/><b>创 建 人：</b>zhudengkui
     * <br/><b>创建时间:</b>2019/9/27 9:28
     * <br/><b>修 改 人：</b>zhudengkui
     * <br/><b>修改时间:</b>2019/9/27 9:28
     * @since  1.0.0
     */
    Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
