package design.bridge;

/**
 * <b>类 名 称</b> :  Circle<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2019/9/27 17:02<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2019/9/27 17:02<br/>
 * <b>修改备注</b> :
 */
public class Circle extends Shape {
    
    private int x, y, radius;
    
    protected Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    @Override
    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }
}
