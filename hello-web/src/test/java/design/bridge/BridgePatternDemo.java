package design.bridge;

/**
 * <b>类 名 称</b> :  BridgePatternDemo<br/>
 * <b>类 描 述</b> :  桥接模式<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/9/27 17:04<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/9/27 17:04<br/>
 * <b>修改备注</b> :
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100,100, 10, new RedCircle());
        Shape greenCircle = new Circle(100,100, 10, new GreenCircle());
    
        redCircle.draw();
        greenCircle.draw();
    }
}
