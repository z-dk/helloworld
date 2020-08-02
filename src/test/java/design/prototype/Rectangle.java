package design.prototype;

/**
 * <b>类 名 称</b> :  接口实现类$<br/>
 * <b>类 描 述</b> :  <br/>
 * <b>创 建 人</b> :  朱登奎<br/>
 * <b>创建时间</b> :  2019/9/27 9:08<br/>
 * <b>修 改 人</b> :  朱登奎<br/>
 * <b>修改时间</b> :  2019/9/27 9:08<br/>
 * <b>修改备注</b> :
 */
public class Rectangle extends Shape{
    
    public Rectangle(){
        type = "Rectangle";
    }
    
    @Override
    public void draw() {
        System.out.println("Rectangle draw() method");
    }
}
